<%@ page contentType="text/html;charset=UTF-8" %>
<% 
String path = request.getContextPath(); 
cn.com.brilliance.begen.common.bundle.ResourceBundle.setLocale(request,java.util.Locale.US);
%>
<%@ page language="java" import="cn.com.brilliance.begen.common.Tools" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户登录</title>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0"> 
<link rel="stylesheet" type="text/css" href="styles/softkey.css" />
<script language=javascript content-type="text/javascript" src="scripts/softkeyboard.js"></script>
<script language=javascript content-type="text/javascript" src="scripts/behaviour.js"></script>
<script language=javascript content-type="text/javascript" src="scripts/setname.js"></script>
<head>
<style>
body{background:#ccc;}
#div_login{
	border:1px solid black;
	background:#f2f2f2;
	width:470px;
	margin:0 auto;
	padding:10px 0;
}
#div_login form{
margin:0;
padding:0;}
#div_login #login_image{
	background:url(images/img_login.gif) no-repeat;
	width:450px;
	height:200px;
	margin:0 auto;
}
#div_login #login_form{
	width:450px;
	margin:10px auto 0;
}
.input{
	height:17px;
	border:1px solid #999;
	background:#f2f2f2;
	width:110px;
	font-size:12px;
	line-height:17px;
}
.text_user{
	font-size:12px;
	color:black;
	padding:3px 5px 2px 5px;
	border-left:1px solid #999;
	border-top:1px solid #999;
	border-bottom:1px solid #999;
	position:relative;
	top:-3px;
}
.text_password{
	font-size:12px;
	color:black;
	padding:3px 5px 2px 5px;
	border-left:1px solid #999;
	border-top:1px solid #999;
	border-bottom:1px solid #999;
	position:relative;
	top:-3px;	
}
.btn_login{
line-height:17px;
padding-top:10px;
padding-bottom:0px;
cursor:pointer;
position:relative;
top:3px;
}
.chb_login{
	cursor:pointer;
	top:3px;	
}

</style>
<script>
function centerLogin(){
win_height=window.screen.Height/2-300;
//document.getElementById("div_login").style.marginTop=win_height;
}
function checklogin(){
var f=document.form1;

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
<body>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
<div id="div_login">
	<div id="login_image"></div>
	<div id="login_form"><form name="form1" id="form1" method="post" action="<%=path %>/LoginServlet" onsubmit="return checklogin();">
		<span class="text_user">用户:</span><input type="text" id="user_id" name="user_id" class="input" onfocus="closekeyboard()">
		<span class="text_password">密码:</span><input id="password" name="password" type="password" class="input"  onkeydown="Calc.password.value=this.value"
           onclick="password1=this;showkeyboard();this.readOnly=0;Calc.password.value=this.value">
		<span class="btn_login"><img id="button1" src="images/btn_login.gif" border="0" onclick="checklogin();closekeyboard();"></span>
		<span class="chb_login"><input type=checkbox id="checkbox1"/><label>记住用户名</label></span>
		<span id="labError" style="float:left;text-align:center;color:red;margin-left:100px;margin-top:5px;font-size:12px;">
			<%=(request.getAttribute("$errorMsg$")) == null?"":request.getAttribute("$errorMsg$")%>
		</span>
		
	</form></div>
</div>
</body>
</html>