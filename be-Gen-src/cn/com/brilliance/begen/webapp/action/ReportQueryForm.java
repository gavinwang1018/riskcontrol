package cn.com.brilliance.begen.webapp.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

public class ReportQueryForm extends BasePage {
	private HashMap queryMap ;
	private String sysReportDef;
	private String format;
	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public ReportQueryForm(){
		queryMap = new HashMap();
	}
	
	public HashMap getQueryMap() {
		return queryMap;
	}

	
	
	public String getSysReportDef() {
		return sysReportDef;
	}

	public void setSysReportDef(String sysReportDef) {
		this.sysReportDef = sysReportDef;
	}

	public void setQueryMap(HashMap queryMap) {
		this.queryMap = queryMap;
	}

	public void query(){
		HttpServletResponse response = (HttpServletResponse)this.getFacesContext().getExternalContext().getResponse();
		String param = "";
		for (Iterator iter = queryMap.keySet().iterator();iter.hasNext();){
			String key = (String)iter.next();
			String value = (String)queryMap.get(key);
			if (value != null && !"".equals(value)){
				param += "&" + key + "=" + value;
			}
		}
		try {
			response.sendRedirect("http://" + this.getRequest().getServerName() + ":" + this.getRequest().getServerPort() + "/birt/run?__report=report/rptdesign/" + sysReportDef + "&__format=" + format + param);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getFacesContext().responseComplete();
	}
}
