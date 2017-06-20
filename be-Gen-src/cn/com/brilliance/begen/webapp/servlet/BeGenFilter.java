package cn.com.brilliance.begen.webapp.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.com.brilliance.begen.common.BeGenHistory;
import cn.com.brilliance.begen.common.Constants;
import cn.com.brilliance.begen.common.webapp.action.ResultPage;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.exception.LoginException;

public class BeGenFilter implements Filter {

	private static final Logger logger = Logger.getLogger(BeGenFilter.class);

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		ResultPage resultPage = new ResultPage();
		if (req.getSession().getAttribute(Constants.SESSION_USER_INFO) == null
				&& !req.getServletPath().startsWith("/login")) {
			resp.sendRedirect(req.getContextPath() + "/redirect.htm");
			return;
		}
		if ("true".equals(req.getParameter("__clear_history")))
			req.getSession().removeAttribute("_history_list");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Cache-Control", "no-store");
		resp.setDateHeader("Expires", 0);
		resp.setHeader("Pragma", "no-cache");

		filterChain.doFilter(request, response);
//		try {
//		} catch (IOException e) {
//			logger
//					.error(
//							"doFilter(ServletRequest, ServletResponse, FilterChain)", e); //$NON-NLS-1$
//			resultPage.setMessageType(ResultPage.MESSAGE_TYPE_OTHER_ERROR);
//			resultPage.setMessageLabel("数据读写异常！请返回上一步操作或重新登录。");
//			resultPage.setMessageContent(e.getMessage());
//			resultPage.addLink(BeGenHistory.getInstance(req).getLastTitle(),
//					BeGenHistory.getInstance(req).getLastLink());
//			resultPage.forwardResultPage(req, resp);
//		} catch (ServletException e) {
//			logger
//					.error(
//							"doFilter(ServletRequest, ServletResponse, FilterChain)", e); //$NON-NLS-1$
//			resultPage.setMessageType(ResultPage.MESSAGE_TYPE_DATAMANAGE_ERROR);
//			resultPage.setMessageLabel("数据处理异常！请返回上一步操作或重新登录。");
//			resultPage.setMessageContent(e.getMessage());
//			resultPage.addLink(BeGenHistory.getInstance(req).getLastTitle(),
//					BeGenHistory.getInstance(req).getLastLink());
//			resultPage.forwardResultPage(req, resp);
//			// TODO Auto-generated catch block
//		} catch (LoginException e) {
//			logger
//					.error(
//							"doFilter(ServletRequest, ServletResponse, FilterChain)", e); //$NON-NLS-1$
//			resultPage.setMessageType(ResultPage.MESSAGE_TYPE_REGISTER_ERROR);
//			resultPage.setMessageLabel("登录失败！请重新登录或联系管理员。");
//			resultPage.setMessageContent(e.getMessage());
//			resultPage.setRequestAttribute(req);
//			request.getRequestDispatcher("redirect.jsp").forward(request,
//					response);
//		} catch (BeGenException e) {
//			logger
//					.error(
//							"doFilter(ServletRequest, ServletResponse, FilterChain)", e); //$NON-NLS-1$
//			resultPage.setMessageType(ResultPage.MESSAGE_TYPE_OTHER_ERROR);
//			resultPage.setMessageLabel("系统处理异常！请返回上一步操作或重新登录。");
//			resultPage.setMessageContent(e.getMessage());
//			resultPage.addLink(BeGenHistory.getInstance(req).getLastTitle(),
//					BeGenHistory.getInstance(req).getLastLink());
//			resultPage.forwardResultPage(req, resp);
//
//		}
//		logger
//				.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - 结束"); //$NON-NLS-1$		

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
