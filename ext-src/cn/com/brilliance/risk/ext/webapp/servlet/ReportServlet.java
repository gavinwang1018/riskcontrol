package cn.com.brilliance.risk.ext.webapp.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.exception.ReportException;
import cn.com.brilliance.begen.service.TorganizeInfoService;
import cn.com.brilliance.begen.webapp.listener.ContextLoaderListener;

public class ReportServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4867320117376899418L;

	JRResultSetDataSource jrds=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mode = (String) this.getServletContext().getAttribute("mode");
		System.out.println();
		String branchInst = (String) this.getServletContext().getAttribute("belongToInst");
		String statBeginDate = (String) this.getServletContext().getAttribute("beginDate");
		String statEndDate = (String) this.getServletContext().getAttribute("endDate");
		
		TorganizeInfoService torganizeInfoService = (TorganizeInfoService) ContextLoaderListener.getApplicationContext().getBean("torganizeInfoService");
		String orgName = torganizeInfoService.getTorganizeInfo(branchInst).getName();
		System.out.println(orgName);
		
		String format = getFormatList().get(Integer.parseInt(mode));
		try {
			Map map = new HashMap();
			map.put("orgName", orgName);
			map.put("statBeginDate", statBeginDate);
			map.put("statEndDate", statEndDate);
			JasperPrint jasperPrint;
			try {
				jasperPrint = JasperFillManager.fillReport(request.getSession()
						.getServletContext().getResourceAsStream(
								"/t_report/VariousTime.jasper"), map,
						Tools.getConnection());
				if ("html".equals(format)) {
					response.setContentType("text/html;charset=gb2312");
					PrintWriter out = response.getWriter();
					JRHtmlExporter exporter = new JRHtmlExporter();
					request.getSession().setAttribute(
					ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
					exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
					exporter.setParameter(
							JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
					exporter.exportReport();
					System.out.println("end");
				} else if ("excel".equals(format)) {
					response.setContentType("application/vnd.ms-excel");
					request.getSession().setAttribute(
					ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
					response.sendRedirect("servlets/xls");
				} else {
					response.setContentType("application/pdf");
					ServletOutputStream outputStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint,outputStream);
				}
			} catch (JRException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} catch (ReportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> getFormatList(){
		List list = new ArrayList();
		list.add("");
		list.add("html");
		list.add("excel");
		list.add("pdf");
		return list;
	}
}
