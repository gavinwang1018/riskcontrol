package cn.com.brilliance.begen.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.brilliance.begen.common.CmsUtil;

public class ImageViewServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String fileLocation = request.getParameter("fileLocation");
		String fileName = request.getParameter("fileName");
		response.setContentType("image/jpeg");
		response.setHeader("Content-disposition", "inline ;filename="
				+ toUtf8String(fileName));				
		CmsUtil.loadFileToHttpServletResponse(fileLocation,response);
	}
	
    public static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            }
            else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0)
                        k += 256;
                    sb.append("%" + Integer.toHexString(k).
                              toUpperCase());
                }
            }
        }
        return sb.toString();
    }
}
