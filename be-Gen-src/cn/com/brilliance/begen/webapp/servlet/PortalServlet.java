package cn.com.brilliance.begen.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PortalServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PortalServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/**		String portalId = request.getParameter("$portal_id$");
		StringBuffer sb = new StringBuffer();
		sb.append("<html>").append("\n")
			.append("<head>").append("\n")
			.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\">").append("\n")
			.append("<title></title>").append("\n")
			.append("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"styles/portal.css\" />").append("\n")
			.append("<link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"styles/config.css\" />").append("\n")
			.append("</head>").append("\n")
			.append("<script language=javascript defer>").append("\n")
			.append("var arrIframeW=new Array()").append("\n")
			.append("function dyniframesize()").append("\n")
			.append("{").append("\n")
			.append("	var iframeObj=document.getElementsByTagName('iframe');").append("\n")
			.append("	for(var k=0;k<iframeObj.length;k++)").append("\n")
			.append("	{").append("\n")
			.append("		iframeObj[k].height = iframeObj[k].Document.body.scrollHeight+20").append("\n")
			.append("		var arrlength=iframeObj[k].id").append("\n")
			.append("		arrIframeW[arrlength]=iframeObj[k].parentNode.parentNode.parentNode.parentNode.style.width").append("\n")
			.append("	}").append("\n")
			.append("}").append("\n")
				
			.append("function hidSelfIframe(obj)").append("\n")
			.append("{").append("\n")
			.append("	var iframename='iframe'+obj").append("\n")
			.append("	var thisIframe=document.getElementById(iframename)").append("\n")		
			.append("	var	allIframeObj=document.getElementsByTagName('iframe')").append("\n")
			
			.append("	if(document.getElementById('changtomax'+obj).src.search('revert.jpg')!=-1)").append("\n")
			.append("	{").append("\n")	
			.append("		for(var i=0;i<allIframeObj.length;i++)").append("\n")
			.append("		{").append("\n")
			.append("			allIframeObj[i].parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.style.display='';").append("\n")
			.append("			var arrName=allIframeObj[i].id").append("\n")
			.append("			allIframeObj[i].parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.style.width=arrIframeW[arrName]").append("\n")
			.append("			if(allIframeObj[i].parentNode.parentNode.style.display=='none')").append("\n")
			.append("			{").append("\n")
			.append("				allIframeObj[i].parentNode.parentNode.previousSibling.style.display=''").append("\n")
			.append("				allIframeObj[i].parentNode.parentNode.style.display=''").append("\n")
			.append("			}").append("\n")
			.append("		}").append("\n")
			.append("		document.getElementById('changtomax'+obj).src='images/large.jpg'").append("\n")
			.append("	}").append("\n")
			
			.append("	if(thisIframe.style.display=='none')").append("\n")
			.append("	{").append("\n")
			.append("		thisIframe.style.display=''").append("\n")
			.append("		document.getElementById('changtomin'+obj).src='images/small.jpg'").append("\n")
			.append("	}").append("\n")
			.append("	else if(thisIframe.style.display=='')").append("\n")
			.append("	{").append("\n")
			.append("	thisIframe.style.display='none'").append("\n")
			.append("	document.getElementById('changtomin'+obj).src='images/revert.jpg'").append("\n")
			.append("	}").append("\n")
			.append("}").append("\n")
			
			.append("function hidOtherIframe(obj)").append("\n")
			.append("{").append("\n")
			.append("	var	allIframeObj=document.getElementsByTagName('iframe');").append("\n")
			.append("	var iframename='iframe'+obj").append("\n")
			.append("	var thisIframe=document.getElementById(iframename)").append("\n")		
			.append("	var	allIframeObj=document.getElementsByTagName('iframe')").append("\n")		
			.append("	if(document.getElementById('changtomin'+obj).src.search('revert.jpg')!=-1)").append("\n")
			.append("	{").append("\n")		
			.append("		thisIframe.style.display=''").append("\n")	
			.append("		document.getElementById('changtomin'+obj).src='images/small.jpg'").append("\n")	
			.append("	}").append("\n")	
			.append("	if(document.getElementById('changtomax'+obj).src.search('large.jpg')!=-1)").append("\n")
			.append("	{").append("\n")
			.append("		for(var i=0;i<allIframeObj.length;i++)").append("\n")
			.append("		{").append("\n")
			.append("			allIframeObj[i].parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.style.display='none';").append("\n")
			.append("		}").append("\n")		
			.append("		thisIframe.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.style.width='100%'").append("\n")
			.append("		thisIframe.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.style.display=''").append("\n")
			.append("		for(var i=0;i<allIframeObj.length;i++)").append("\n")
			.append("		{").append("\n")
			.append("			if((allIframeObj[i].id.substr(6,1)==obj.substr(0,1))&&(allIframeObj[i].id!=iframename))").append("\n")
			.append("			{").append("\n")
			.append("				allIframeObj[i].parentNode.parentNode.previousSibling.style.display='none'").append("\n")
			.append("				allIframeObj[i].parentNode.parentNode.style.display='none'").append("\n")
			.append("			}").append("\n")
			.append("		}").append("\n")
			.append("		document.getElementById('changtomax'+obj).src='images/revert.jpg'").append("\n")
			.append("	}").append("\n")
			.append("	else").append("\n")
			.append("	{").append("\n")
			.append("		for(var i=0;i<allIframeObj.length;i++)").append("\n")
			.append("		{").append("\n")
			.append("			allIframeObj[i].parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.style.display=''").append("\n")
			.append("			var arrName=allIframeObj[i].id").append("\n")
			.append("			allIframeObj[i].parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.style.width=arrIframeW[arrName]").append("\n")
			.append("			if(allIframeObj[i].parentNode.parentNode.style.display=='none')").append("\n")
			.append("			{").append("\n")
			.append("				allIframeObj[i].parentNode.parentNode.previousSibling.style.display=''").append("\n")
			.append("				allIframeObj[i].parentNode.parentNode.style.display=''").append("\n")
			.append("			}").append("\n")
			.append("		}").append("\n")
			.append("		document.getElementById('changtomax'+obj).src='images/large.jpg'").append("\n")
			.append("	}").append("\n")
			.append("}").append("\n")

			
			.append("</script>").append("\n")
			.append("\n")
			.append("<body onload=\"dyniframesize()\">").append("\n");
		SysPortalDefDAO sysPortalDefDAO = (SysPortalDefDAO)ContextLoaderListener.getApplicationContext().getBean("sysPortalDefDAO");
		SysPortalSectionDefDAO sysPortalSectionDefDAO = (SysPortalSectionDefDAO)ContextLoaderListener.getApplicationContext().getBean("sysPortalSectionDefDAO");
		SysPortalDef sysPortalDef = sysPortalDefDAO.getSysPortalDef(portalId);
		int cols = Integer.parseInt(sysPortalDef.getCols());
		String width[] = new String[]{sysPortalDef.getWidthFst(),sysPortalDef.getWidthSec(),sysPortalDef.getWidthThd()};
*/
		
/*colspan支持
 * 		boolean flag = true;
		int n = 0;
		sb.append("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"float:left;clear:none;\" width=100% >").append("\n");
		while(flag){
			flag = false;
			sb.append("<tr>").append("\n");
			int span = 0;
			for (int i = 0 ; i < cols; i ++){
				SysPortalSectionDef sysPortalSectionDef = new SysPortalSectionDef();
				sysPortalSectionDef.setSysRecordOrder(new Integer(n));
				sysPortalSectionDef.setCols(new Integer(i));
				sysPortalSectionDef.setPortalId(portalId);
				List list = sysPortalSectionDefDAO.getSysPortalSectionDefList(sysPortalSectionDef);
				if (list.size() > 0){
					flag = true;
					sysPortalSectionDef = (SysPortalSectionDef)list.get(0);
					String url = sysPortalSectionDef.getPortletIdOfSysPortletDef().getUrl();
					if (url.indexOf("?") != -1){
						url += "&_is_portal=true";
					}
					else{
						url += "?_is_portal=true";
					}
					
					
					String str = new String(sysPortalSectionDef.getPortletIdOfSysPortletDef().getLabel().getBytes("GBK"),"ISO-8859-1");
					sb.append("<td valign=top width=").append(getWidth(width,cols,i,sysPortalSectionDef.getColspan().intValue())).append(" colspan=\"").append(sysPortalSectionDef.getColspan()).append("\">").append("\n")
						.append("<table width=100% class=\"portal_table\" border=1>").append("\n")
						.append("<tr><td>").append(str).append("</td></tr><tr><td>").append("\n")
						.append("<iframe style=\"overflow:hidden\" frameborder=0 width=100% src=\"")
						.append(url)
						.append("\" id=\"iframe").append(n).append(i).append("\"></iframe>").append("\n")
						.append("</td></tr></table>").append("\n");
					sb.append("</td>").append("\n");
					span = sysPortalSectionDef.getColspan().intValue() - 1; 
				}else{
					if (span > 0 ){
						span--;	
					}else{
						sb.append("<td></td>");
					}
					
				}
				
			}
			sb.append("</tr>");
			n++;
		}
		sb.append("</table>").append("\n");
*/
		//不支持colspan
/**
									
		sb.append("<table width=\"100%\" cellspacing=0 cellpadding=1>" ).append("\n");
		sb.append("	<tr>").append("\n");
		for (int i = 0;i< cols; i ++){
			sb.append("<td valign=\"top\"  width=\"").append(getWidth(width,cols,i)).append("\" border=\"0\" >").append("\n");
			sb.append("<table  id=\"table").append(i).append("\" width=\"100%\" cellspacing=0 cellpadding=0>").append("\n");
			sb.append("	<tr>").append("\n");
			sb.append("		<td>").append("\n");
			sb.append("<table width=\"100%\" cellspacing=0 cellpadding=1><tr>").append("\n");
			SysPortalSectionDef sysPortalSectionDef = new SysPortalSectionDef();
			sysPortalSectionDef.setCols(new Integer(i));
			sysPortalSectionDef.setPortalId(portalId);
			List list = sysPortalSectionDefDAO.getSysPortalSectionDefList(sysPortalSectionDef);
			for (int j = 0;j < list.size(); j++){
				sysPortalSectionDef = (SysPortalSectionDef)list.get(j);
				
				String url = sysPortalSectionDef.getPortletIdOfSysPortletDef().getUrl();
				if (url.indexOf("?") != -1){
					url += "&_is_portal=true";
				}
				else{
					url += "?_is_portal=true";
				}

				String str = new String(sysPortalSectionDef.getPortletIdOfSysPortletDef().getLabel().getBytes("GBK"),"ISO-8859-1");
				sb.append("<tr>").append("\n");
				sb.append("	<td  width=\"100%\" class=\"panel_title\">").append(str).append("<span style='float:right;margin-top:-13px;'><img  onclick=\"hidSelfIframe('").append(i).append(j).append("')\"  id='changtomin").append(i).append(j).append("' src='images/small.jpg' /><img onclick=\"hidOtherIframe('").append(i).append(j).append("')\"  id='changtomax").append(i).append(j).append("\'  src='images/large.jpg'></span></td>").append("\n");
				sb.append("</tr>").append("\n");
				sb.append("<tr>").append("\n");
				sb.append("	<td>").append("\n");
				sb.append("		<iframe frameborder=0 width=100% src=\"")
					.append(url)
					.append("\" id=\"iframe").append(i).append(j).append("\"></iframe>").append("\n");
				sb.append("	</td>");
				sb.append("</tr>").append("\n");
			}
			
			sb.append("</table>").append("\n");
			sb.append("</td>").append("\n");		
			sb.append("</tr>").append("\n");
			sb.append("</table>").append("\n");
			sb.append("</td>").append("\n");
		}
		sb.append("</tr></table>");
		
		//end of 不支持colspan

		
		
		sb.append("</body>").append("\n");
		sb.append("</html>").append("\n");
		response.getWriter().write(sb.toString());*/
	}

	
	private String getWidth(String[] width,int cols,int col){
		String ps[][] = new String[][]{{"100","100","100"},{"30","50","70"},{"20","40","60"}};
		return Integer.parseInt(ps[cols - 1][Integer.parseInt(width[col]) - 1]) + "%";
	}

	
	private String getWidth(String[] width,int cols,int col,int colspan){
		String ps[][] = new String[][]{{"100","100","100"},{"30","50","70"},{"20","40","60"}};
		int rtn = 0;
		while(colspan != 0){
			rtn = Integer.parseInt(ps[cols - 1][Integer.parseInt(width[col]) - 1]) + rtn;
			col++;
			colspan--;
		}
		return rtn + "%";
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
