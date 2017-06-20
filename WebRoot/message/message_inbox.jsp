<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="cn.com.brilliance.begen.model.*" %>
<%@ page import="cn.com.brilliance.begen.common.Tools" %>
<%@ page import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<%@ page import="java.util.*" %>
<%
    String basePath = request.getContextPath();	
    List<SysMessage> messageList = (List)request.getAttribute("messageList");
%>

<html>
<head>
<title>Message</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/message.css" />
<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/includedate.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/commons-validator.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/lookupajax.js"></script>
<script language="javascript">
function selcheck() {
  var objs = msg_list.getElementsByTagName("input");
  var is_check_all=document.getElementById("checkall").checked;
  for(var i=0; i<objs.length; i++) {
    if(objs[i].type.toLowerCase() == "checkbox" )
      if (is_check_all == true){
	  	objs[i].checked = true;
	  }
	  else
	  {
	  objs[i].checked = false;
	  };
  }
}

function checkdelete() {
	var checkedmsg=false;
  var objs = msg_list.getElementsByTagName("input");
  for(var i=0; i<objs.length; i++) {
    if(objs[i].type.toLowerCase() == "checkbox" )
      if (objs[i].checked == true){
	  	checkedmsg=true;
	  }
  }
	
	if (checkedmsg==false){
		alert("<%=ResourceBundle.getText(request,"alert.confirm.delete")%>");
		return false;
	}
	else{
		msg_list.submit();
	}

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
</style>
</head>
<script  language="JavaScript" defer>
loadHidInfo()
</script>

<body onunload="parent.get_message_result();">
	<div id="main_body">
      
<div id="message_title">
        	<div><img src="<%=basePath%>/images/message_action_inbox.gif" hspace="20" vspace="10" align="middle"><span class="message_title_tip"><%=ResourceBundle.getText(request,"label.message")%>-<%=ResourceBundle.getText(request,"link.message.inbox")%></span></div>
      </div>
		<div id="message_content">
        <form action="<%=basePath%>/MessageServlet?__type=delete_in" method="post" name="msg_list" id="msg_list">
		  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="message_list_table">
            <tr>
              <td width="5%" height="25" bgcolor="#DDECFF" ><div align="center"><input type="checkbox" id="checkall" name="checkall" onClick="selcheck()"></div></td>
              <td width="5%" bgcolor="#DDECFF" ><div align="center"><%=ResourceBundle.getText(request,"message.status")%></div></td>
              <td width="12%" bgcolor="#DDECFF" ><div align="center"><%=ResourceBundle.getText(request,"label.operate")%></div></td>
              <td width="13%" bgcolor="#DDECFF"><div align="center"><%=ResourceBundle.getText(request,"message.sender")%></div></td>
              <td width="45%" bgcolor="#DDECFF"><div align="center"><%=ResourceBundle.getText(request,"message.subject")%></div></td>
              <td width="20%" bgcolor="#DDECFF"><div align="center"><%=ResourceBundle.getText(request,"message.time")%></div></td>
            </tr>
<%
for (SysMessage msg : messageList){
%>
            <tr onmouseover="this.style.backgroundColor='#eeeeee'" onmouseout="this.style.backgroundColor=''">
              <td height="25" class="message_new_content"><div align="center">
                <input name="__msg_id" type="checkbox" id="msg_id" value="<%=msg.getId() %>">
              </div></td>
              <td height="25" class="message_new_content"><div align="center"><%if(msg.getReadFlag().booleanValue()){ %><img src="<%=basePath%>/images/mail_readed.gif"><%}else{ %><img src="<%=basePath%>/images/mail_unread.gif"><%} %></div></td>
              <td  class="message_new_content_inputarea"><div align="center"><a href="MessageServlet?__type=delete_in&__msg_id=<%=msg.getId() %>" class="message_link"><%=ResourceBundle.getText(request,"button.delete")%></a> | <a href="MessageServlet?__type=detail&__msg_id=<%=msg.getId() %>" class="message_link"><%=ResourceBundle.getText(request,"label.view")%></a></div></td>
              <td  class="message_new_content_inputarea"><div align="center"><a href="MessageServlet?__type=detail&__msg_id=<%=msg.getId() %>" class="message_link"><%=Tools.getUserName(msg.getSender())%></a></div></td>
              <td  class="message_new_content_inputarea"><a href="MessageServlet?__type=detail&__msg_id=<%=msg.getId() %>" class="message_link"><%=msg.getTitle() %></a></td>
              <td  class="message_new_content_inputarea"><div align="center"><%=Tools.getFormatDate(msg.getSendTime(),"yyyy-MM-dd hh:mm:ss") %></div></td>
            </tr>  
<%
}
 %>          
            <tr>
              <td height="30" colspan="6" bgcolor="#EEEEEE"><div align="center">
                <input type="button" name="button" id="button" value="<%=ResourceBundle.getText(request,"button.delete")%>" class="button" onclick="return checkdelete();">
                <input type="reset" name="button2" id="button2" value="<%=ResourceBundle.getText(request,"button.reset")%>"  class="button">
              </div></td>
            </tr>
          </table>
          </form>
	  </div>
    </div>    		
</body>
</html>					