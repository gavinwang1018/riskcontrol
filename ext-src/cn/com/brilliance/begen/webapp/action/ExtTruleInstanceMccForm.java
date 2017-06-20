package cn.com.brilliance.begen.webapp.action;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import cn.com.brilliance.begen.dao.ExtTruleInstanceMccDAO;
import cn.com.brilliance.begen.dao.TruleInstanceDAO;
import cn.com.brilliance.begen.dao.TruleInstanceMccDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.webapp.action.FormPage;

/**
 * TruleInstanceMcc对象Form.
 * 
 * @author Administrator.
 * 
 */
public class ExtTruleInstanceMccForm extends BasePage implements FormPage {

	private ExtTruleInstanceMccService service = (ExtTruleInstanceMccService) getBean("extTruleInstanceMccService");

	private String lookupKey;

	/**
	 * truleInstanceMcc对象.
	 */
	private ExtTruleInstanceMcc extTruleInstanceMcc;

	/**
	 * TruleInstanceMcc对象主键.
	 */
	private java.lang.String truleInstanceMccPrimaryKey;

	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

	/**
	 * Returns the TruleInstanceMcc.
	 * 
	 * @return TruleInstanceMcc.
	 */
	public ExtTruleInstanceMcc getExtTruleInstanceMcc() {
		if (extTruleInstanceMcc == null) {
			extTruleInstanceMcc = new ExtTruleInstanceMcc();
		}
		return extTruleInstanceMcc;
	}

	/**
	 * Sets the TruleInstanceMcc.
	 * 
	 * @param truleInstanceMcc
	 *            The truleInstanceMcc to set.
	 */
	public void setExtTruleInstanceMcc(ExtTruleInstanceMcc extTruleInstanceMcc) {
		this.extTruleInstanceMcc = extTruleInstanceMcc;
	}

	/**
	 * Returns the truleInstanceMccPrimaryKey.
	 * 
	 * @return TruleInstanceMccPrimaryKey.
	 */
	public java.lang.String getExtTruleInstanceMccPrimaryKey() {
		return truleInstanceMccPrimaryKey;
	}

	/**
	 * Sets the truleInstanceMccPrimaryKey.
	 * 
	 * @param truleInstanceMccPrimaryKey
	 *            The TruleInstanceMccPrimaryKey to set.
	 */
	public void setTruleInstanceMccPrimaryKey(
			java.lang.String truleInstanceMccPrimaryKey) {
		this.truleInstanceMccPrimaryKey = truleInstanceMccPrimaryKey;
		initTruleInstanceMcc();
	}

	public void initTruleInstanceMcc() {
		try {
			if (truleInstanceMccPrimaryKey == null
					|| truleInstanceMccPrimaryKey.equals("")) {
				return;
			}
			this.setExtTruleInstanceMcc(service
					.getExtTruleInstanceMcc(truleInstanceMccPrimaryKey));
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
	}

	/**
	 * 存储TruleInstanceMcc对象.
	 * 
	 * @return String.
	 */
	public String save() {
		try {
			if (truleInstanceMccPrimaryKey == null
					&& this.extTruleInstanceMcc.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getExtTruleInstanceMcc(this.extTruleInstanceMcc.getId()) != null) {
					addMessage("error.database.duplicatekey", "id["
							+ this.extTruleInstanceMcc.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (truleInstanceMccPrimaryKey == null
					|| truleInstanceMccPrimaryKey.equals(this.extTruleInstanceMcc
							.getId())) {
				this.extTruleInstanceMcc = service
						.saveExtTruleInstanceMcc(this.extTruleInstanceMcc);
				String key = extTruleInstanceMcc.getId();
				this.truleInstanceMccPrimaryKey = key;
				if (truleInstanceMccPrimaryKey == null) {
					addMessage("truleInstanceMcc.message.added",
							this.extTruleInstanceMcc.getId());
				} else {
					addMessage("truleInstanceMcc.message.saved",
							this.extTruleInstanceMcc.getId());
				}
			} else {
				addMessageString("exception.save.primarykey");
				return null;
			}
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

	public String saveAndNew() {
		try {
			String action = save();
			if (action == null) {
				return null;
			}
			ExtTruleInstanceMcc extTruleInstanceMcc = new ExtTruleInstanceMcc();
			this.extTruleInstanceMcc = extTruleInstanceMcc;
			truleInstanceMccPrimaryKey = null;
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return null;
	}

	/**
	 * 删除TruleInstanceMcc对象.
	 * 
	 * @return String.
	 */
	public String delete() {
		try {
			service.delete(this.extTruleInstanceMcc.getId());
			CmsUtil.deleteFile("t_rule_instance_mcc/"
					+ this.extTruleInstanceMcc.getId());
			addMessage("truleInstanceMcc.message.deleted",
					this.extTruleInstanceMcc.getId());

		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

	/**
	 * 删除TruleInstanceMcc对象 (子表有数据不允许删除）.
	 * 
	 * @return String.
	 */
	public String deleteOfNoChild() {
		try {
			ExtTruleInstanceMcc extTruleInstanceMcc = service
					.getExtTruleInstanceMcc(this.extTruleInstanceMcc.getId());
			service.delete(extTruleInstanceMcc.getId());
			addMessage("truleInstanceMcc.message.deleted",
					this.extTruleInstanceMcc.getId());

		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

	public String edit() {

		return getSuccessAction();
	}

	public String getHistoryUrlParameter() {
		if (this.truleInstanceMccPrimaryKey == null)
			return "_key=" + this.extTruleInstanceMcc.getId();
		return "_key=" + this.truleInstanceMccPrimaryKey;
	}

	public String popSave() {
		this.getRequest().getSession().setAttribute("__pop_object",
				this.extTruleInstanceMcc);
		this.getRequest().getSession().setAttribute("__pop_data_object",
				"ExtTruleInstanceMcc");
		return "popSuccess";
	}

	public String saveAll() {
		try {
			if (truleInstanceMccPrimaryKey == null
					&& this.extTruleInstanceMcc.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getExtTruleInstanceMcc(this.extTruleInstanceMcc.getId()) != null) {
					addMessage("error.database.duplicatekey", "id["
							+ this.extTruleInstanceMcc.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (truleInstanceMccPrimaryKey == null
					|| truleInstanceMccPrimaryKey.equals(this.extTruleInstanceMcc
							.getId())) {

				this.extTruleInstanceMcc = service.saveAll(this.extTruleInstanceMcc);
				String key = extTruleInstanceMcc.getId();
				this.truleInstanceMccPrimaryKey = key;
				if (truleInstanceMccPrimaryKey == null) {
					addMessage("truleInstanceMcc.message.added",
							this.extTruleInstanceMcc.getId());
				} else {
					addMessage("truleInstanceMcc.message.saved",
							this.extTruleInstanceMcc.getId());
				}
			} else {
				addMessageString("exception.save.primarykey");
				return null;
			}
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return this.getSuccessAction();
	}

	public String saveMultiAll() {
		try {
			if (truleInstanceMccPrimaryKey == null
					&& this.extTruleInstanceMcc.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getExtTruleInstanceMcc(this.extTruleInstanceMcc.getId()) != null) {
					addMessage("error.database.duplicatekey", "id["
							+ this.extTruleInstanceMcc.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (truleInstanceMccPrimaryKey == null
					|| truleInstanceMccPrimaryKey.equals(this.extTruleInstanceMcc
							.getId())) {
				this.extTruleInstanceMcc = service.saveAll(this.extTruleInstanceMcc);

				String key = extTruleInstanceMcc.getId();
				this.truleInstanceMccPrimaryKey = key;
				if (truleInstanceMccPrimaryKey == null) {
					addMessage("truleInstanceMcc.message.added",
							this.extTruleInstanceMcc.getId());
				} else {
					addMessage("truleInstanceMcc.message.saved",
							this.extTruleInstanceMcc.getId());
				}
			} else {
				addMessageString("exception.save.primarykey");
				return null;
			}
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}

		return this.getSuccessAction();
	}

	public void loadExtTruleInstanceMcc() {
		ExtTruleInstanceMcc extTruleInstanceMcc = (ExtTruleInstanceMcc) this
				.getRequest().getSession().getAttribute("__pop_object");
		this.extTruleInstanceMcc = extTruleInstanceMcc;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}




}
