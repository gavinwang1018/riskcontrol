<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<!DOCTYPE html public"-//w3c//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="UTF-8">
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta name="description" content="" />
<title>SearchResult</title>
</head>
<style type="text/css">
body{
padding-top: 5px;
}
.searchButton{
	font-family: "宋体";
	background-image:  url(images/Btn_bg.gif);
	background-repeat: repeat-x;
	background-position: center center;
	font-size: 12px;
	color:#000000;
	padding:3px 2px 0 2px;
	cursor:pointer;
	font-weight:normal;
	display:inline;
	text-decoration: none;
	border-top: 1px solid #8EA9B4;
	border-right: 1px solid #8EA9B4;
	border-bottom: 1px solid #8EA9B4;
	border-left: 1px solid #8EA9B4;
	background-color: #FFFFFF;
	margin:3px 5px;
	cursor:hand;
}
a {	
	padding: 5px 8px 8px 8px;
	color:#336699;
	text-decoration: none;
}

a:hover {
	color:#336699;
	text-decoration: underline;
}
.Td_Bg{
	padding-left:15px;
}
	</style>
	
<script language="javascript">
		
	function searchObj()
{
	var queryObj=document.getElementById("__query");
	if(queryObj.value=='')
	{
		alert("<%=ResourceBundle.getText(request,"validate.search.empty")%>")
		queryObj.focus();
		return;
	}
	else if(queryObj.value.length<2)
	{
		alert("<%=ResourceBundle.getText(request,"validate.search.length")%>")
		queryObj.focus();
		return;
	}
	else 
	{
		parent.showSysInform();
		form1.submit();
	}
}
	
</script>	
	
	

<body style="margin:0;height:100%"  onload="">
	<table cellspacing=0 cellpadding=0 style="width:100%;height:70px;">
		<form action="" name="form1" method="POST" target="mainFrame">
		<tr>
			<td class="Td_Bg"><select name="__data_object_name" style="width:124px;"><option value="">--------------</option></select></td>
		</tr>
		<tr>
			<td class="Td_Bg"><input type="text" style="width:50%;margin-bottom:4px;" name="__query"><input type=button value="<%=ResourceBundle.getText(request,"button.query")%>" onclick="searchObj()" class="searchButton"></td>
		</tr>
		<tr>
			<td id="showResultTd" class="Td_Bg">
				<font style="font-size:12px;"  id="showResult"></font>
			</td>
		</tr>
		<tr>
			<td style="text-align:right;font-size:12px;padding:5px;" class="Td_Bg"><font id="showPages"></font></td>
		</tr>
		</form>
	</table>
</body>


</html>
