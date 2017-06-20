<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<%
String basePath = request.getContextPath();
%>
<html>
<head>
<title>Message</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/message.css" />
<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>
<script language="javascript">
function selectcontacter(){
window.open('select.jsp','Address','status=yes,resizable=yes,scrollbars=yes,top=0,left=0,width=600,height=500')}

function checknew(){
	if (form_newmsg.receiver.value=="")
	{alert ("<%=ResourceBundle.getText(request,"alert.message.receiver")%>");
	form_newmsg.receiver.focus();
	return false;}
	else if(form_newmsg.title.value=="")
	{alert ("<%=ResourceBundle.getText(request,"alert.message.subject")%>");
	form_newmsg.title.focus();
	return false;}
	else{
	form_newmsg.submit();
	}
}
	function changep(thisobj,p){
	thisobj.style.backgroundPosition=p;
	}
</script>
<style>
.button{
	height:25px;
	width:80px;
	font-family: "宋体";
	background-image:  url(<%=basePath%>/images/Btn_bg.gif);
	background-repeat: repeat-x;
	background-position: center center;
	font-size: 12px;
	color:#000000;
	padding:3px 2px 0 2px;
	cursor:pointer;
	font-weight:normal;
	display:inline;
	text-decoration: none;
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-top-color: #CCCCCC;
	border-right-color: #CCCCCC;
	border-bottom-color: #CCCCCC;
	border-left-color: #CCCCCC;
	background-color: #FFFFFF;
	margin:3px 5px;
}
.input_single{background:url(<%=basePath%>/images/bg_input_text.jpg) repeat-x;}
.input_receiver{background:url(<%=basePath%>/images/bg_input_text.jpg) repeat-x;}
.trigger_lookup{background:url(<%=basePath%>/images/trigger_lookup.gif) no-repeat;cursor:pointer;_cursor:hand;
width:17px;
height:24px;
position:relative;top:4px;
border-bottom:1px solid #B5B8C8;}
.space_img{
width:17px;
height:23px}
.style1 {color: #666666}
.trigger_lookup{
	background:url(<%=basePath%>/images/trigger_lookup.gif) no-repeat;
	cursor:pointer;
	_cursor:hand;
	width:17px;
	height:24px;
	position:relative;left:-6px;top:4px;
	border-bottom:1px solid #B5B8C8;
}
</style>
</head>
<script  language="JavaScript" defer>
loadHidInfo()
function changep(thisobj,p){
	thisobj.style.backgroundPosition=p;
	}
</script>

<body onload="form_newmsg.title.focus()" onunload="parent.get_message_result();">
	<div id="main_body">
<div id="message_title">
        	<div><img src="<%=basePath%>/images/message_action_new.gif" hspace="20" vspace="10" align="middle"><span class="message_title_tip"><%=ResourceBundle.getText(request,"label.message")%>-<%=ResourceBundle.getText(request,"link.message.new")%></span></div>
      </div>
		<div id="message_content">
        <form method="post" action="<%=basePath%>/MessageServlet?__type=save" name="form_newmsg" id="form_newmsg">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="message_new_table_outline">
            <tr>
              <td>		  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="message_new_table">
            <tr>
              <td height="25" colspan="2" bgcolor="EEEEEE" class="message_new_content style1"> <%=ResourceBundle.getText(request,"link.message.new")%></td>
            </tr>
            <tr>
              <td width="10%" height="25" bgcolor="#DDECFF" class="message_new_content"><div align="right"><%=ResourceBundle.getText(request,"message.receiver")%>:</div></td>
              <td width="71%" class="message_new_content_inputarea"><input type="text" name="receiver" id="receiver" class="input_receiver" readonly style="background:url(<%=basePath%>/images/bg_input_text.jpg) repeat-x;"><span class="trigger_lookup" onmouseover="changep(this,'-17px 0')" onmouseout="changep(this,'0 0')" onclick="selectcontacter();"><img src="<%=basePath%>/images/spacer.gif" alt="<%=ResourceBundle.getText(request,"message.choosereceiver")%>" border="0" class="space_img"></span></td>
            </tr>
            <tr>
              <td height="25" bgcolor="#DDECFF" class="message_new_content"><div align="right"><%=ResourceBundle.getText(request,"message.subject")%>:</div></td>
              <td  class="message_new_content_inputarea"><input type="text" name="title" id="title"  class="input_single" style="background:url(<%=basePath%>/images/bg_input_text.jpg) repeat-x;"></td>
            </tr>
            <tr>
              <td height="25" valign="top" bgcolor="#DDECFF" class="message_new_content"><div align="right"><%=ResourceBundle.getText(request,"message.content")%>:</div></td>
              <td  class="message_new_content_inputarea"><textarea name="content" rows="20"  class="input_multi" id="content"></textarea></td>
            </tr>
            
          </table></td>
            </tr>
            <tr>
              <td height="30" bgcolor="#DDECFF"><div align="center">
                <input type="button" name="button" id="button" value="<%=ResourceBundle.getText(request,"button.send")%>" class="button" onClick="return checknew();">
                <input type="hidden" name="org" id="org">
                <input type="hidden" name="role" id="role">
                <input type="hidden" name="user" id="user">
</div></td>
            </tr>
          </table>
          </form>
		</div>
    </div>    		
</body>
</html>					