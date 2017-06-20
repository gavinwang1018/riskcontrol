package cn.com.brilliance.begen.webapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.service.PermissionWorkflowManager;

public class PermissionWorkflowServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String type = request.getParameter("__type");
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean)session.getAttribute("_user_info");
		PermissionWorkflowManager permissionWorkflowManager = (PermissionWorkflowManager)Tools.getBean("permissionWorkflowManager");
		if ("todolist".equals(type)){
			List list = permissionWorkflowManager.getTodoActivityList(String.valueOf(userBean.getTuserInfo().getId()));
			request.setAttribute("__todo_list", list);
			request.getRequestDispatcher("permission_workflow/todo_list.jsp").forward(request, response);
		}
	}
}
