<%@ page contentType="text/html; charset=gb2312" %>
<%@ page language="java" import="cn.com.brilliance.begen.common.Tools" %>
<!DOCTYPE html public"-//w3c//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="gb2312">
<head>
<meta http-equiv="content-type" content="text/html;charset=gb2312" />
<meta name="description" content="" />
<title>ERROR</title>
</head>
<script language="javascript">
function backIndex(){
setTimeout("window.history.go(-1)",5000)
}
</script>
<body onLoad="backIndex()">
<BR>
<table cellSpacing=0 cellPadding=0 width=450 align=center border=0 height="366" background="<%=Tools.getEnvionment("image_path")%>/ero.jpg" border=5>
  <tr>
    <td>&nbsp;</td>
    <td>
		<table cellspacing=0 cellpadding=0 width="96%" border=0>      
        	<tr>
          	<td style="letter-spacing:8px;text-align:center;font-size:18px"><strong>数据提交失败！</strong></td>
        	</tr>
    	</table>
	</td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td vAlign=top><BR>
      <table cellSpacing=0 cellPadding=0 width="90%" align=center border=0>        
        <tr>
          <td class=org height=30 style="letter-spacing:3px;text-align:center;font-size:16px;line-height:22px;">
          	<%=request.getAttribute("$errorInfo$")%><br>
          	  系统将自动跳转返回,请稍候......  <BR> 
如果您的浏览器不支持自动跳转，请点<a href="#" onclick="backIndex()">这里</a>!
          </td>
        </tr>
		</table>
    </td>
    <td>&nbsp;</td>
  </tr>
</table></body></html>

