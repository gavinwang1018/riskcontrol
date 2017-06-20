package cn.com.brilliance.risk.ext.webapp.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;

public class RiskcaseFileDownServlet extends HttpServlet {

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

		String riskcaseId = request.getParameter("id");
		String organizeId = request.getParameter("organizeId");
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		String month = sdf.format(new Date());
		String server_path = Tools.getEnvionment("server_path");
		String path = server_path + "/" + organizeId + "/" + month;
		String fileName = path + "/" + riskcaseId + ".csv";
		System.out.println("server_path is: " + server_path);
		System.out.println("path is:" + path);
		System.out.println("fileName is: " + fileName);
		File file = new File(fileName);
		int flag;
		try {
			if(!file.exists()) {
				System.out.println("file no exist");
				flag = doShell(riskcaseId, organizeId, server_path);
			} else {
				System.out.println("file exist");
				flag = 0;
			}
			if (flag == 0) {
				response.setHeader("Content-disposition", "attachment ;filename="
						+ toUtf8String(riskcaseId + ".csv"));
				downLoadFile(fileName,response);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}
	
	private void downLoadFile(String saveFile,HttpServletResponse response) {
		File file = new File(saveFile);
		ServletOutputStream ops = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			response.setContentLength((int) file.length());
			byte[] buffer = new byte[64 * 1024];
			int count;
			ops = response.getOutputStream();
			while ((count = fis.read(buffer)) > 0)
				ops.write(buffer, 0, count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
				ops.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	

	private int doShell(String riskcaseId, String organizeId, String path)
			throws IOException, InterruptedException {

		String dbUser = Tools.getEnvionment("db_user");
		String dbPassword = Tools.getEnvionment("db_password");
		Runtime rt = Runtime.getRuntime();
		String str = "UnloadDataToTxt.sh " + " " + organizeId + " " + path + " " + riskcaseId + " "
				+ dbUser + " " + dbPassword;
		System.out.println("str is: " + str);
		Process pcs = rt.exec(str);
		pcs.waitFor();
		System.out.println("value: "+ pcs.exitValue());
		return pcs.exitValue();
	}

	/**
	 * 将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名
	 * 
	 * @param s
	 *            原文件名
	 * @return 重新编码后的文件名
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					ex.printStackTrace();
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

}
