<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<%
String basePath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<title>Message</title>
<style type="text/css">
<!--
body {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	text-decoration: none;
	margin: 0px;
	padding-top: 5px;
}
a:link {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #000000;
	text-decoration: none;
}
a:visited {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #000000;
	text-decoration: none;
}
a:hover {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #0066FF;
	text-decoration: none;
}
-->
</style>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td width="20"><div align="right"><img src="<%=basePath%>/images/transmit_list.gif"  hspace="5" /></div></td>
    <td><p><a href="<%=basePath%>/TransmitServlet?__type=todolist" target="mainFrame"><%=ResourceBundle.getText(request,"link.transmit.todolist")%></a><span id="transmit_count" style="color:black;padding-left:5px;"></span></p></td>
  </tr>
  <tr>
    <td><div align="right"><img src="<%=basePath%>/images/transmit_inprocess.gif" alt=""  hspace="5" /></div></td>
    <td><a href="<%=basePath%>/TransmitServlet?__type=resultlist&__end=0" target="mainFrame"><%=ResourceBundle.getText(request,"link.transmit.inprocess")%></a></td>
  </tr>
  <tr>
    <td><div align="right"><img src="<%=basePath%>/images/transmit_history.gif" alt=""  hspace="5" /></div></td>
    <td><a href="<%=basePath%>/TransmitServlet?__type=resultlist&__end=1" target="mainFrame"><%=ResourceBundle.getText(request,"link.transmit.history")%></a></td>
  </tr>
</table>
</body>
</html>										