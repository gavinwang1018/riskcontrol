<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="cn.com.brilliance.begen.service.MessageManager" %>
<%@ page import="cn.com.brilliance.begen.model.*" %>
<%@ page import="cn.com.brilliance.begen.common.Tools" %>
<%@ page import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<%
    String basePath = request.getContextPath();	
    SysMessage msg = (SysMessage)request.getAttribute("message");
    boolean in = MessageManager.TYPE_IN.equals(msg.getType());
%>

<html>
<head>
<title>Message</></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/message.css" />
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

<body onload="parent.get_message_result();">
	<div id="main_body">
     
<div id="message_title">
        	<div><img src="<%=basePath%>/images/message_action_new.gif" hspace="20" vspace="10" align="middle"><span class="message_title_tip"><%=ResourceBundle.getText(request,"label.message")%>-<%=ResourceBundle.getText(request,"message.detail")%></span></div>
      </div>
		<div id="message_content">
        <form method="post" action="MessageServlet?__type=<% if(in){%>delete_in<%}else {%>delete_out<%} %>" onSubmit="return confirm('<%=ResourceBundle.getText(request,"alert.confirm.delete")%>')">
		  <input type="hidden" name="__msg_id" value="<%=msg.getId()%>">
		  <table width="810" border="0" cellpadding="0" cellspacing="1" class="message_list_table" >
            <tr>
              <td width="120" height="25" bgcolor="#DDECFF" class="message_new_content"><div align="right" style="width:120px;"><%=ResourceBundle.getText(request,"message.subject")%>:</div></td>
              <td width="681" class="message_new_content_inputarea"><div class="msg_content_title"><%=msg.getTitle()%></div></td>
            </tr>
            <%if (in){ %>
            <tr>
              <td width="120" height="25" bgcolor="#DDECFF" class="message_new_content"><div align="right"><%=ResourceBundle.getText(request,"message.sender")%>:</div></td>
              <td class="message_new_content_inputarea"><div  class="msg_content_sender"><%=Tools.getUserName(msg.getSender())%></div></td>
            </tr>
            <%
            }
            else{ 
            %>
            <tr>
              <td width="120" height="25" bgcolor="#DDECFF" class="message_new_content"><div align="right"><%=ResourceBundle.getText(request,"message.receiver")%>:</div></td>
              <td class="message_new_content_inputarea"><div class="msg_content_sender"><%=Tools.getUserName(msg.getReceiver())%></div></td>
            </tr>
            <%
            }
             %>
            <tr>
              <td width="120" height="25" bgcolor="#DDECFF" class="message_new_content"><div align="right"><%=ResourceBundle.getText(request,"message.time")%>:</div></td>
              <td class="message_new_content_inputarea"><div class="msg_content_time"><%=Tools.getFormatDate(msg.getSendTime(),"yyyy-MM-dd hh:mm:ss")%></div></td>
            </tr>
            <tr>
              <td  width="120" height="25" valign="top" bgcolor="#DDECFF" class="message_new_content"><div align="right"><%=ResourceBundle.getText(request,"message.content")%>:</div></td>
              <td width="681" style="overflow-x:hidden;" class="message_new_content_inputarea"><div class="pre_width">
              	  <pre class="msg_content_detail"><%=msg.getContent()%></pre></div>
               </td>
            </tr>
            <tr>
              <td class="message_new_content_inputarea" height="30" colspan="2" bgcolor="#EEEEEE"><div align="center">
                <input type="submit" name="button" id="button" value="<%=ResourceBundle.getText(request,"button.delete")%>" class="button">
              </div></td>
            </tr>
          </table>
          </form>
		</div>
    </div>    		
</body>
</html>					