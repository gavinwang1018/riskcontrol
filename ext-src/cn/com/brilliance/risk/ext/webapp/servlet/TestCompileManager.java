package cn.com.brilliance.risk.ext.webapp.servlet;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import cn.com.brilliance.begen.common.Tools;

public class TestCompileManager {
	public static void main(String[] args) {
		String name = "VariousBranches";
		String sourceFileName = "E:\\yl\\riskControl\\ext-WebRoot\\t_report\\" + name + ".jrxml";
		String destFileName = "E:\\yl\\riskControl\\ext-WebRoot\\t_report\\" + name + ".jasper";
		try {
			JasperCompileManager.compileReportToFile(sourceFileName,
					destFileName);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String destFileName1 = "D:\\jakarta-tomcat-5.0.28\\webapps\\riskControl\\t_report\\" + name + ".jasper";
		try {
			JasperCompileManager.compileReportToFile(sourceFileName,
					destFileName1);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}