<%@ page language="java" pageEncoding="GBK"	contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="cn.com.brilliance.begen.common.*" %>
<%@ page import="cn.com.brilliance.risk.ext.interfaces.DataManageController" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%
String path = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>节假日维护</title>
<link rel="stylesheet" type="text/css" media="all" href="<%=path%>/styles/config.css" />
<link rel="stylesheet" type="text/css" media="all" href="<%=path%>/styles/right.css" />
<script type="text/javascript" src="<%=path%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=path%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/common.js"></script>
</head>
<%
DataManageController dataManageController = (DataManageController)Tools.getBean("dataManageController");
List list = dataManageController.queryForList("select holiday_date from t_holiday");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
List itemList = new ArrayList();
if(list != null && list.size() > 0) {
for(int i = 0; i < list.size(); i++) {
	Map map = (Map)list.get(i);
	Timestamp timestamp = (Timestamp)map.get("holiday_date");
	String dateStr = sdf.format(timestamp);
	String[] dateArray = dateStr.split("-");
	int monthNum = Integer.parseInt(dateArray[1]);
	int dayNum = Integer.parseInt(dateArray[2]);
	String date = String.valueOf(monthNum) + "#" + String.valueOf(dayNum);
	itemList.add(date);
}
}
%>
<body onload="loadHidInfo();" >
<form name="form1" method="post" action="<%=path%>/DateMgrServlet">
  <table width="100%" border="0">
<%
		for(int rows=0;rows<4;rows++) {  	
%>
    <tr>
<%    	
    	for(int cols=0;cols<3;cols++) {
    	int month=rows*3+cols+1;
    	String monthStr = String.valueOf(month);
%>    	
      <td width="24%" valign="top">
<p><%=month%>月 </p>
<%
        for(int j=0; j<5;j++) {
        	if(j!=4) {
%>	        
        	<p>
<%       		
        	for(int jd=0;jd<7;jd++) {
        		String day = String.valueOf(j*7 + jd + 1);
        		String jdd = monthStr + "#" + String.valueOf(j*7 + jd + 1);
%>					
					<%=day%> <input id=checkbox type=checkbox name=checkbox value=<%=jdd%> <%if(itemList.contains(jdd)){%> checked <%}%> >
<%					
        	}
        } else {
        	int monthsize = 0;
        	if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
        		monthsize = 3;
        	} else if(month==4 || month==6 || month==9 || month==11) {
							monthsize = 2;
        		} else {
        				monthsize = 1;
        			}
        	for(int jd=0;jd<monthsize;jd++) {
	        	String day = String.valueOf(29 + jd);
        		String jdd = monthStr + "#" + String.valueOf(29 + jd);
%>        	
					<%=day%> <input id=checkbox type=checkbox name=checkbox value=<%=jdd%> <%if(itemList.contains(jdd)){%> checked <%}%> >
<%				
					}
					}
%>
        	</p>
<%        	
        }
%>	
        </td>
<%}%>            
    </tr>
<%}%>    
  </table>
  <input type="submit" name="submit" value="保存" />
  <input type="button" name="button" value="全部清空" onclick="clearAll();" />
</form>
</body>
<script type="text/javascript">
function clearAll() {
	var chkobj = eval("document.all.checkbox");
	for(var i=0;i<chkobj.length;i++){
		chkobj[i].checked = false;
	}
}
</script>
</html>
