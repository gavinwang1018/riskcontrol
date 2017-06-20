package cn.com.brilliance.begen.webapp.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.brilliance.begen.common.Constants;
import cn.com.brilliance.begen.dao.TroleUserDAO;
import cn.com.brilliance.begen.dao.TuserInfoDAO;
import cn.com.brilliance.begen.model.TroleUser;
import cn.com.brilliance.begen.model.TuserInfo;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4920305914503294971L;

	private static WebApplicationContext appContext = null;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (appContext == null) {
			appContext = WebApplicationContextUtils
					.getRequiredWebApplicationContext(this.getServletContext());
		}

		String loginName = request.getParameter("user_id");
		String password = "";
		password = request.getParameter("password");
		TuserInfoDAO tuserInfoDAO = (TuserInfoDAO) appContext
				.getBean("tuserInfoDAO");
		TuserInfo tuserInfo = new TuserInfo();
		tuserInfo.setLoginName(loginName);
		tuserInfo.setPassword(password);
		List appUserList = tuserInfoDAO.getTuserInfoList(tuserInfo);
		if (loginName == null || password == null || appUserList == null
				|| appUserList.size() == 0) {
			request.setAttribute("$errorMsg$", "登录失败! 用户不存在或密码错误!");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
			return;
		}
		TuserInfo appUser = (TuserInfo) appUserList.get(0);

		boolean enable = appUser.getEnable().booleanValue();
		if (!enable) {
			request.setAttribute("$errorMsg$", "登录失败! 用户已被注销!");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
			return;
		}
		
		TroleUserDAO troleUserDAO = (TroleUserDAO) appContext
				.getBean("troleUserDAO");

		TroleUser troleUser = new TroleUser();
		troleUser.setUserId(appUser.getId());
		List list = troleUserDAO.getTroleUserList(troleUser);
		HashSet set = new HashSet();
		HashSet permissionSet = new HashSet();
		for (int i = 0; i < list.size(); i++) {
			TroleUser userRole = (TroleUser) list.get(i);
			set.add(userRole.getRoleId());
			permissionSet.add(userRole.getRoleIdOfTroleInfo().getCode());
		}

		UserBean userBean = new UserBean();
		userBean.setTuserInfo(appUser);
		userBean.setRoleSet(set);
		userBean.setPermissionSet(permissionSet);
		HttpSession session = request.getSession();
		session.setAttribute(Constants.SESSION_USER_INFO, userBean);
		if(request == null) return;
		request.getRequestDispatcher("frame.faces").forward(request, response);
	}

}
