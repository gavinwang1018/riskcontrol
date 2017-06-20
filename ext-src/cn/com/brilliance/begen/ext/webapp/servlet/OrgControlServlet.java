/**
 * 
 */
package cn.com.brilliance.begen.ext.webapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.TorganizeUserDAO;
import cn.com.brilliance.begen.model.TorganizeUser;

/**
 * @author user
 * 
 */
public class OrgControlServlet extends HttpServlet {

	public OrgControlServlet() {
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
			String orgs = (String) request.getParameter("orgs");

			TorganizeUserDAO torganizeUserDAO = (TorganizeUserDAO) Tools
					.getBean("torganizeUserDAO");

			TorganizeUser tu = new TorganizeUser();
			tu.setUserId(userId);
			List list = torganizeUserDAO.getTorganizeUserList(tu);
			for (int n = 0; n < list.size(); n++) {
				TorganizeUser _tu = (TorganizeUser) list.get(n);
				torganizeUserDAO.removeTorganizeUser(_tu.getId());
			}

			String[] orgStrs = orgs.split(",");
			if (orgStrs != null && orgStrs.length > 0) {
				for (int i = 0; i < orgStrs.length; i++) {
					String orgid = orgStrs[i];
					TorganizeUser torganizeUser = new TorganizeUser();
					torganizeUser.setOrganizeId(orgid);
					torganizeUser.setUserId(userId);
					torganizeUserDAO.saveTorganizeUser(torganizeUser);
				}
			}
			response.sendRedirect("ext_right/ext_org_set.faces?_user_id="
					+ userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
