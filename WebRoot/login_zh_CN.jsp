<%@ page language="java" contentType="text/html; charset=gb2312" %>
<%@ page language="java" import="cn.com.brilliance.begen.common.Tools" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户登录</title>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0"> 
<link rel="stylesheet" type="text/css" href="styles/softkey.css" />
<link rel="stylesheet" type="text/css" href="styles/login.css" />
<script language=javascript content-type="text/javascript" src="scripts/softkeyboard.js"></script>
<script language=javascript content-type="text/javascript" src="scripts/behaviour.js"></script>
<script language=javascript content-type="text/javascript" src="scripts/setname.js"></script>
<%
String path = request.getContextPath(); 
%>
<head>
<script>
function chgBorder(thisobj,pointer){
	if (pointer==1)
	{
		thisobj.style.borderColor="#0066cc";
	}else{
		thisobj.style.borderColor="#999999";
	}
	
}
function checklogin(){
var f=document.form_login;

if (f.user_id.value==""){
	f.user_id.focus();
	alert("请输入用户名!");
	return false;
	}else if(f.password.value==""){
	alert("请输入密码!");	
	return false;
	}else{
		f.submit();
	}
}
</script>

</head>
<body onload="document.getElementById('user_id').focus();">
			<div id="mainBody">
				<div id="loginLeft"></div>
				<div id="loginRight">
					<div id="loginForm">
						
						<div class="form_title"></div>
						<form name="form_login" id="form1" method="post" action="<%=path %>/LoginServlet" onsubmit="return checklogin();">
						<ul>
							<li>
							<span class="form_item">用户名：</span><input type="text" name="user_id" id="user_id" class="form_text" onfocus="chgBorder(this,1);closekeyboard();" onblur="chgBorder(this,0)"></li>
							<li><span class="form_item">密　码：</span><input id="password" name="password" type="password" class="form_text" onfocus="chgBorder(this,1);password1=this;showkeyboard();this.readOnly=0;Calc.password.value=this.value" onblur="chgBorder(this,0)"></li>
							<!--
							<li><span class="form_item">验证码：</span><input type="text" class="form_text" onfocus="chgBorder(this,1)" onblur="chgBorder(this,0)"></li>-->
							<li class="li_checkbox"><input type=checkbox id="checkbox1" class="form_checkbox"><span class="form_item_id">记住用户名</span><span class="errorInfo"><%=(request.getAttribute("$errorMsg$")) == null?"":request.getAttribute("$errorMsg$")%></span></li>
							<li class="btn_login"><input type="image" src="<%=path%>/images/btn_login.gif" /></li>
						</ul>
					</form>
					</div>
				</div>
			</div>
</body>
</html>