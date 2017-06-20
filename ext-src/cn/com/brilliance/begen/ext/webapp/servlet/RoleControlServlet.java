/**
 * 
 */
package cn.com.brilliance.begen.ext.webapp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.brilliance.begen.common.Constants;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.TroleUserDAO;
import cn.com.brilliance.begen.model.TroleUser;
import cn.com.brilliance.begen.webapp.servlet.UserBean;

/**
 * @author user
 * 
 */
public class RoleControlServlet extends HttpServlet {

	public RoleControlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userId = request.getParameter("_user_id");
			String roles = request.getParameter("roles");
			String[] roleStrs = roles.split(",");

			TroleUserDAO troleUserDAO = (TroleUserDAO) Tools
					.getBean("troleUserDAO");

			TroleUser tu = new TroleUser();
			tu.setUserId(userId);
			List list = troleUserDAO.getTroleUserList(tu);
			for (int n = 0; n < list.size(); n++) {
				TroleUser troleUser = (TroleUser) list.get(n);
				troleUserDAO.removeTroleUser(troleUser.getId());
			}

			if (roleStrs != null && roleStrs.length > 0) {
				for (int i = 0; i < roleStrs.length; i++) {
					String roleid = roleStrs[i];
					TroleUser troleUser = new TroleUser();
					troleUser.setRoleId(roleid);
					troleUser.setUserId(userId);
					troleUserDAO.saveTroleUser(troleUser);
				}
			}
			response.sendRedirect("ext_right/ext_role_set.faces?_user_id="
					+ userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
