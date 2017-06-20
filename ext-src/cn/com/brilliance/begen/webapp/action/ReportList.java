package cn.com.brilliance.begen.webapp.action;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.common.webapp.action.FormPage;

public class ReportList extends BasePage implements FormPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5270927246740758166L;

	private String mode;

	private String belongToInst;

	private Date beginDate;

	private Date endDate;

	private Map queryFields;

	// ====================================
	WritableSheet sheet;

	File tempFile;

	WritableWorkbook workbook;

	WritableFont headerFont;

	WritableFont titleFont;

	WritableFont detFont;

	WritableCellFormat titleFormat;

	WritableCellFormat headerFormat;

	WritableCellFormat detFormat;

	WritableCellFormat priceFormat;

	WritableCellFormat dateFormat;

	Label l = null;

	jxl.write.Number n = null;

	jxl.write.DateTime d = null;

	int column = 0;// ==================

	// ====================================

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getBelongToInst() {
		return belongToInst;
	}

	public void setBelongToInst(String belongToInst) {
		this.belongToInst = belongToInst;
	}

	public void query(String reportServlet) {
		this.getServletContext().setAttribute("mode", "1");
		this.getServletContext().setAttribute("belongToInst", belongToInst);
		System.out.println(beginDate+"   "+endDate);
		String begin = Tools.getFormatDate(beginDate, "yyyy-MM-dd");
		String end = Tools.getFormatDate(endDate, "yyyy-MM-dd");
		this.getServletContext().setAttribute("beginDate", begin);
		this.getServletContext().setAttribute("endDate", end);
		String url = reportServlet;
		try {
			getResponse().sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.getFacesContext().responseComplete();
	}

	public String queryVariousIndustries() {
		query("../VariousIndustriesReportServlet");
		return null;
	}

	public String queryVariousChannels() {
		query("../VariousChannelsReportServlet");
		return null;
	}

	public String queryVariousBranches() {
		query("../VariousBranchesReportServlet");
		return null;
	}

	public String queryVariousTime() {
		query("../VariousTimeReportServlet");
		return null;
	}

	private void export(String reportName) {
		String orgName = (String) getValueBinding("#{reportList.belongToInst}");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fileDate = sdf.format(new Date());
		String statBeginDate = Tools.getFormatDate(beginDate, "yyyy-MM-dd");
		String statEndDate = Tools.getFormatDate(endDate, "yyyy-MM-dd");
		System.out.println(statBeginDate + " " + endDate);
		String filePath = this.getServletContext().getRealPath("/");

		String fileName = filePath + "t_report\\" + reportName + ".jrxml";

		String jasperFile;
		
		Map map = new HashMap();
		map.put("orgName", orgName);
		map.put("statBeginDate", statBeginDate);
		map.put("statEndDate", statEndDate);
			
		OutputStream ouputStream = null;
		try {
			jasperFile = JasperCompileManager.compileReportToFile(fileName);
			ouputStream = this.getResponse().getOutputStream(); 

			
			// this.getResponse().setContentType("text/html;charset=utf-8");

			// 向HelloWorld.jasper文件中填充数据，这一步将生产出HelloWorld .jrprint文件
			String jrprintFile = JasperFillManager.fillReportToFile(jasperFile,
					map, Tools.getConnection());
			// 将.jrprint文件转换成XLS格式(即Excel文件)，需要用到POI类库.
			File sourceFile = new File(jrprintFile);
			JasperPrint jasperPrint = (JasperPrint) JRLoader
					.loadObject(sourceFile);
//			File destFile = new File(sourceFile.getParent(), jasperPrint
//					.getName()
//					+ ".xls");
//			JRXlsExporter exporter = new JRXlsExporter();

//			byte[] bytes;
//			ByteArrayOutputStream bo = new ByteArrayOutputStream();
//			exporter
//					.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
//			exporter.setParameter(
//					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
//					Boolean.TRUE);
//			exporter.setParameter(
//					JRXlsExporterParameter.CHARACTER_ENCODING,
//					"GB2312");   
//			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
//					Boolean.FALSE);
//			exporter.setParameter(
//					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
//					Boolean.FALSE);
			// exporter.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED,Boolean.TRUE);
//			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,destFile.toString());
//			exporter.exportReport();
//			this.getFacesContext().responseComplete();

//			this.getResponse().setContentType("application/xls");   
//			this.getResponse().setCharacterEncoding("GB2312"); 
//			this.getResponse().setHeader("Content-Disposition", "inline; filename=\""   
//                    + URLEncoder.encode(reportName, "GB2312") + fileDate + ".xls\""); 
			
			
			this.getResponse().setContentType("application/vnd.ms-excel");
			this.getRequest().getSession().setAttribute(
					ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,
					jasperPrint);
			this.getResponse().sendRedirect("../servlets/xls");
			
			this.getFacesContext().responseComplete();
			
			
//			bytes = bo.toByteArray();
//			System.out.println("length:    "+bytes.length);
//			if (bytes != null && bytes.length > 0) {
//				this.getResponse().reset();
//				this.getResponse().setContentType("application/vnd.ms-excel;charset=GB2312");
//				this.getResponse().setHeader("Content-Disposition",
//						"attachment;filename=" + reportName +fileDate + ".xls");// 打开保存
//				this.getResponse().setContentLength(bytes.length);
//				System.out.println(bytes.length);
//				ServletOutputStream sos;
//				try {
//					sos = this.getResponse().getOutputStream();
//					sos.write(bytes, 0, bytes.length);
//					sos.flush();
//					sos.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {   
            if (ouputStream != null) {   
                try {   
                    ouputStream.close();   
                } catch (IOException ex) {   
                }   
            }   
        }  

	}

	public String exportVariousIndustries() {
		String name = "分支机构疑似风险商户案例处理情况统计表";
		export(name);
		addMessageString(name+"  导出成功");
		return getSuccessAction();
	}

	public String exportVariousChannels() {
		String name = "各渠道疑似风险商户案例处理情况统计表";
		export("VariousChannels");
		addMessageString(name+"  导出成功");
		return getSuccessAction();
	}

	public String exportVariousBranches() {
		String name = "各行业疑似风险商户案例处理情况统计表";
		export("VariousBranches");
		addMessageString(name + "  导出成功");
		return getSuccessAction();
	}

	public String exportVariousTime() {
		String name = "疑似风险商户案例处理时间统计表";
		export("VariousTime");
		addMessageString(name + "  导出成功");
		return getSuccessAction();
	}

	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	public String saveAndNew() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Map getQueryFields() {
		return queryFields;
	}

	public void setQueryFields(Map queryFields) {
		this.queryFields = queryFields;
	}

}
