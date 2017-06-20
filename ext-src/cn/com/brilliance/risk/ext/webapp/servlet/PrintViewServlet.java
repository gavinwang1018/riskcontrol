package cn.com.brilliance.risk.ext.webapp.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.servlet.VelocityServlet;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.TriskcaseDAO;
import cn.com.brilliance.begen.dao.TriskcaseRecordDAO;
import cn.com.brilliance.begen.model.Triskcase;
import cn.com.brilliance.begen.model.TriskcaseRecord;
import cn.com.brilliance.risk.model.comm.TriskcaseRecordHelper;

public class PrintViewServlet extends VelocityServlet {

	protected Properties loadConfiguration(ServletConfig config)
			throws IOException, FileNotFoundException {

		Properties p = new Properties();

		String path = config.getServletContext().getRealPath("/")
				+ "WEB-INF/template";
		if (path == null) {
			System.out.println("cannot find the path!");
			path = "/";
		}
		p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, path);
		p.setProperty(Velocity.INPUT_ENCODING, "GBK");
		p.setProperty(Velocity.OUTPUT_ENCODING, "GBK");
		return p;
	}

	public Template handleRequest(HttpServletRequest request,
			HttpServletResponse response, Context ctx) {
		String riskcaseKey = request.getParameter("riskcaseId");
		String id = request.getParameter("id");
		TriskcaseRecordHelper recordHelper = new TriskcaseRecordHelper();
		TriskcaseRecord triskcaseRecord = new TriskcaseRecord();
		String riskcaseId = "";
		if(riskcaseKey != null) {
			riskcaseId = riskcaseKey;
		}
		if(id != null) {
			TriskcaseRecordDAO triskcaseRecordDAO = (TriskcaseRecordDAO) Tools
					.getBean("triskcaseRecordDAO");
			triskcaseRecord = triskcaseRecordDAO
					.getTriskcaseRecord(id);
			riskcaseId = triskcaseRecord.getRiskcaseId();
		} 
		TriskcaseDAO triskcaseDAO = (TriskcaseDAO) Tools.getBean("triskcaseDAO");
		Triskcase triskcase = triskcaseDAO.getTriskcase(riskcaseId);
		ctx.put("triskcaseRecord", triskcaseRecord);
		ctx.put("triskcase", triskcase);
		ctx.put("recordHelper", recordHelper);
		Template t = null;
		try {
			t = getTemplate("record.vm");
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
