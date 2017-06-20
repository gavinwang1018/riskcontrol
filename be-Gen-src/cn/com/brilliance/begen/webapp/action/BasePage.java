package cn.com.brilliance.begen.webapp.action;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import cn.com.brilliance.begen.common.Constants;
import cn.com.brilliance.begen.common.FormulaData;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.common.webapp.action.BasePagedBackingBean;
import cn.com.brilliance.begen.common.webapp.action.DataPage;
import cn.com.brilliance.begen.common.webapp.action.ResultPage;
import cn.com.brilliance.begen.dao.SysAutonumberDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.exception.SystemException;
import cn.com.brilliance.begen.exception.UserException;
import cn.com.brilliance.begen.model.SysAutonumber;
import cn.com.brilliance.begen.webapp.listener.ContextLoaderListener;
import cn.com.brilliance.begen.webapp.servlet.UserBean;

public class BasePage extends BasePagedBackingBean implements Serializable {

	public static final String jstlBundleParam = "javax.servlet.jsp.jstl.fmt.localizationContext";

	public BasePage() {

	}

	protected UserBean getUserBean() throws UserException {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session
				.getAttribute(Constants.SESSION_USER_INFO);
		if (userBean == null)
			throw new UserException("用户没有登录或超时");
		return userBean;
	}

	public void setValueBinding(String valueBindingName, Object value) {
		ValueBinding binding = FacesContext.getCurrentInstance()
				.getApplication().createValueBinding(valueBindingName);
		binding.setValue(FacesContext.getCurrentInstance(), value);
	}

	public Object getValueBinding(String valueBindingName) {
		ValueBinding binding = FacesContext.getCurrentInstance()
				.getApplication().createValueBinding(valueBindingName);
		return binding.getValue(FacesContext.getCurrentInstance());
	}

	/**
	 * Allow overriding of facesContext for unit tests
	 * 
	 * @param userManager
	 */

	// Convenience methods ====================================================
	public String getParameter(String name) {
		return getRequest().getParameter(name);
	}

	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public String getBundleName() {
		// get name of resource bundle from JSTL settings, JSF makes this too
		// hard
		return getServletContext().getInitParameter(jstlBundleParam);
	}

	// public Map getCountries() {
	// CountryModel model = new CountryModel();
	//
	// return model.getCountries(getRequest().getLocale());
	// }

	public ResourceBundle getBundle() {
		return ResourceBundle.getBundle(getBundleName(), getRequest()
				.getLocale());
	}

	public String getText(String key) {
		String message;

		try {
			message = getBundle().getString(key);
		} catch (java.util.MissingResourceException mre) {
			// log.warn("Missing key for '" + key + "'");

			return "???" + key + "???";
		}

		return message;
	}

	public String getText(String key, Object arg) {
		if (arg == null) {
			return getBundle().getString(key);
		}

		MessageFormat form = new MessageFormat(getBundle().getString(key));

		if (arg instanceof String) {
			return form.format(new Object[] { arg });
		} else if (arg instanceof Object[]) {
			return form.format(arg);
		} else {
			// log.error("arg '" + arg + "' not String or Object[]");

			return "";
		}
	}

	protected void addMessageString(String key) {
		// JSF Success Messages won't live past a redirect, so I don't use it
		// FacesUtils.addInfoMessage(formatMessage(key, arg));
		addMessage(ResultPage.MESSAGE_TYPE_SUCCESS, key, null);
	}

	protected void addMessage(String key, Object arg) {
		// JSF Success Messages won't live past a redirect, so I don't use it
		// FacesUtils.addInfoMessage(formatMessage(key, arg));
		addMessageString(getText(key, arg));

	}

	protected void addMessage(int code, String value, Exception e) {
		ResultPage resultPage = new ResultPage();
		resultPage.setMessageType(code);
		resultPage.setMessageLabel(value);
		if (e != null)
			resultPage.setMessageContent(e.toString());
		resultPage.setRequestAttribute(this.getRequest());
	}

	protected void addMessageString(int code, String label, String content) {
		ResultPage resultPage = new ResultPage();
		resultPage.setMessageType(code);
		resultPage.setMessageLabel(label);
		resultPage.setMessageContent(content);
		resultPage.setRequestAttribute(this.getRequest());
	}

	/*
	 * protected void addMessage(String key) { addMessage(key, null); }
	 */

	protected void addErrorString(String key, Object arg) {
		// The "JSF Way" doesn't allow you to put HTML in your error messages,
		// so I don't use it.
		// FacesUtils.addErrorMessage(formatMessage(key, arg));
		addMessage(ResultPage.MESSAGE_TYPE_OTHER_ERROR, getText(key, arg), null);
	}

	/**
	 * Servlet API Convenience method
	 * 
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	/**
	 * Servlet API Convenience method
	 * 
	 * @return
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * Servlet API Convenience method
	 * 
	 * @return
	 */
	protected HttpServletResponse getResponse() {
		return (HttpServletResponse) FacesContext.getCurrentInstance()
				.getExternalContext().getResponse();
	}

	/**
	 * Servlet API Convenience method
	 * 
	 * @return
	 */
	protected ServletContext getServletContext() {
		return (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
	}

	public Object getBean(String name) {
		return ContextLoaderListener.getApplicationContext().getBean(name);
	}

	protected static String getDefaultValue(String formula)
			throws BeGenException {
		try {

			VelocityContext vc = new VelocityContext();
			vc.put("tools", new Tools());
			StringWriter sw = new StringWriter();
			Tools.getVelocityEngine().evaluate(vc, sw, "", formula);
			vc = null;
			return sw.toString();
		} catch (ParseErrorException e) {
			// TODO Auto-generated catch block
			throw new SystemException("解析表达式错误 formula='" + formula + "'", e);
		} catch (MethodInvocationException e) {
			// TODO Auto-generated catch block
			throw new SystemException("解析表达式错误 formula='" + formula + "'", e);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			throw new SystemException("资源文件没有找到", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new SystemException("输出结果错误", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new SystemException("VELOCITY 初始化错误", e);
		}

	}

	protected static String getFormulaValue(String formula, Object valueObject)
			throws BeGenException {
		try {
			VelocityContext vc = new VelocityContext();
			FormulaData formulaData = new FormulaData(valueObject);
			vc.put("data", formulaData);
			StringWriter sw = new StringWriter();
			Tools.getVelocityEngine().evaluate(vc, sw, "", formula);
			vc = null;
			return sw.toString();
		} catch (ParseErrorException e) {
			// TODO Auto-generated catch block
			throw new SystemException("解析表达式错误 formula='" + formula + "'", e);
		} catch (MethodInvocationException e) {
			// TODO Auto-generated catch block
			throw new SystemException("解析表达式错误 formula='" + formula + "'", e);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			throw new SystemException("资源文件没有找到", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new SystemException("输出结果错误", e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new SystemException("VELOCITY 初始化错误", e);
		}
	}

	protected synchronized String getAutoNumberValue(String dataObjectName,
			String fieldName, String autonumberformat, int autonumberstart) {
		SysAutonumberDAO sysAutonumberDAO = (SysAutonumberDAO) getBean("sysAutonumberDAO");
		SysAutonumber sysAutonumber = new SysAutonumber();
		sysAutonumber.setSysField(dataObjectName + ":" + fieldName);
		List list = sysAutonumberDAO.getSysAutonumberList(sysAutonumber);
		int i = autonumberstart - 1;
		if (list.size() > 0) {
			sysAutonumber = (SysAutonumber) list.get(0);
			i = sysAutonumber.getNumvalue().intValue();
		} else {
			sysAutonumber = new SysAutonumber();
			sysAutonumber.setSysField(dataObjectName + ":" + fieldName);
		}
		i++;
		sysAutonumber.setNumvalue(new Integer(i));
		sysAutonumberDAO.saveSysAutonumber(sysAutonumber);

		return makeAutoString(autonumberformat, i);
	}

	private static String makeAutoString(String format, int i) {
		int start = format.indexOf("{");
		int end = format.indexOf("}");
		while (end <= start) {
			end += format.substring(end + 1).indexOf("}") + 1;
			if (end == -1 || end == format.length() - 1)
				return format;
		}
		String tmp = format.substring(start + 1, end);
		if ("YY".equalsIgnoreCase(tmp) || "YYYY".equalsIgnoreCase(tmp)
				|| "DD".equalsIgnoreCase(tmp)) {
			SimpleDateFormat sdf = new SimpleDateFormat(tmp.toLowerCase());
			tmp = sdf.format(new Date());
		} else if ("MM".equals(tmp)) {
			SimpleDateFormat sdf = new SimpleDateFormat(tmp);
			tmp = sdf.format(new Date());
		} else if ("HH".equals(tmp)) {
			SimpleDateFormat sdf = new SimpleDateFormat(tmp);
			tmp = sdf.format(new Date());
		} else if ("SS".equalsIgnoreCase(tmp)) {
			SimpleDateFormat sdf = new SimpleDateFormat(tmp.toLowerCase());
			tmp = sdf.format(new Date());
		} else if ("mm".equals(tmp)) {
			SimpleDateFormat sdf = new SimpleDateFormat(tmp);
			tmp = sdf.format(new Date());
		} else {
			if (Integer.parseInt(tmp) == 0) {
				NumberFormat nf = NumberFormat.getIntegerInstance();
				nf.setMinimumIntegerDigits(tmp.length());
				nf.setGroupingUsed(false);
				tmp = nf.format(i);
			} else {
				return null;
			}
		}
		format = format.substring(0, start) + tmp + format.substring(end + 1);
		return makeAutoString(format, i);
	}

	protected static String makeExpress(String formula) {
		String express = "#set( $return =" + formula + ")$return";
		return express;
	}

	protected String getFailureAction() {
		ActionParameter actionParameter = (ActionParameter) getValueBinding("#{actionParameter}");
		if (actionParameter == null
				|| actionParameter.getFailureAction() == null)
			return "failure";

		String failureAction = actionParameter.getFailureAction();
		if (!(failureAction.length() > 4 && failureAction.substring(0, 4)
				.toLowerCase().equals("url:"))) {
			return actionParameter.getFailureAction();
		}
		String url = failureAction.substring(4);
		try {
			this.getResponse().sendRedirect(url);
		} catch (IOException e) {
			this.addMessage(ResultPage.MESSAGE_TYPE_DATAMANAGE_ERROR, "页面["
					+ url + "]跳转出错!", e);
		}
		this.getFacesContext().responseComplete();
		return failureAction;
	}

	protected String getSuccessAction() {
		ActionParameter actionParameter = (ActionParameter) getValueBinding("#{actionParameter}");
		if (actionParameter == null
				|| actionParameter.getSuccessAction() == null)
			return "success";
		String successAction = actionParameter.getSuccessAction();
		if (!(successAction.length() > 4 && successAction.substring(0, 4)
				.toLowerCase().equals("url:"))) {
			return actionParameter.getSuccessAction();
		}
		if (this.getFacesContext().getResponseComplete()) {
			return null;
		}
		String url = successAction.substring(4);
		try {
			this.getResponse().sendRedirect(url);
		} catch (IOException e) {
			this.addMessage(ResultPage.MESSAGE_TYPE_DATAMANAGE_ERROR, "页面["
					+ url + "]跳转出错!", e);
		}
		this.getFacesContext().responseComplete();
		return successAction;
	}

	protected DataPage getDataPage(int startRow, int pageSize) {
		return null;
	}
}
