package cn.com.brilliance.risk.ext.webapp.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.risk.ext.interfaces.DataManageController;

public class DateMgrServlet extends HttpServlet {
	
	private DataManageController dataManageController = (DataManageController)Tools.getBean("dataManageController");

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
		delete();//插入数据之前先清空数据库
		String paramValues[] = request.getParameterValues("checkbox");
		if(paramValues != null && paramValues.length > 0) {
			for (int i = 0; i < paramValues.length; i++) {
				String str = paramValues[i];
				String[] dateArray = str.split("#");
				String dateStr = getYear()+ "-" + dateArray[0] + "-" + dateArray[1];
				save(dateStr);
			}
		}
		response.sendRedirect("common/result2.jsp");
	}
	
	private String getYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date());
	}
	
	private void save(String date) {
		String sql = "insert into t_holiday (holiday_date) values (to_date('" + date + "','yyyy-MM-dd'))";
		dataManageController.update(sql);
	}
	
	private void delete() {
		dataManageController.update("delete from t_holiday");
	}
}
