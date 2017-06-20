<!DOCTYPE html public"-//w3c//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="UTF-8">
<body>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage" %>
<%@ page language="java" import="cn.com.brilliance.begen.common.Tools" %>
<%@ page language="java" import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<%
String basePath = request.getContextPath();
ResultPage resultPage = (ResultPage)request.getAttribute(ResultPage.REQUEST_ATTRIBUTE_NAME);
if (resultPage == null) {
	resultPage = new ResultPage();
	resultPage.setMessageType(ResultPage.MESSAGE_TYPE_OTHER_ERROR);
}
 %>

<style>
BODY {
	PADDING-RIGHT: 0px; PADDING-LEFT: 0px;PADDING-BOTTOM: 0px; MARGIN: 0px; FONT: 12px/1.75em arial; COLOR: #000000; PADDING-TOP: 0px
}
TABLE {
	FONT: 12px "Courier New", Courier, monospace
}
FORM {
	PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px
}
INPUT {
	BORDER-TOP-WIDTH: 1px; BORDER-LEFT-WIDTH: 1px; FONT-SIZE: 12px; BORDER-BOTTOM-WIDTH: 1px; BORDER-RIGHT-WIDTH: 1px
}
A:link {
	COLOR: #0049aa; TEXT-DECORATION: none
}
A:visited {
	COLOR: #0049aa; TEXT-DECORATION: none
}
A:hover {
	COLOR: #1488fd; TEXT-DECORATION: none
}
#MainContainer {
	BACKGROUND: #ffffff; WIDTH: 990px
}
#MainContainer #Footer {
	BORDER-TOP: #999999 1px dashed; FONT-SIZE: 11px; MARGIN: 10px; COLOR: #999999; TEXT-ALIGN: left
}
#MainContainer #Footer UL {
	FLOAT: left; MARGIN: 0px
}
#MainContainer #Footer LI {
	MARGIN: 6px auto; LIST-STYLE-TYPE: none
}
#MainContainer #Footer LI A {
	FONT-SIZE: 11px; COLOR: #999999; TEXT-DECORATION: underline
}
.MessageBox {
	MARGIN-top: 80px; WIDTH: 451px;text-align:left;
}
.MessageBox .Title {
	PADDING-LEFT: 20px; FONT-WEIGHT: bold; BACKGROUND: url(<%=basePath%>/images/MessageBox_Title.gif) no-repeat 50% top; WIDTH: 431px; PADDING-TOP: 15px; HEIGHT: 25px
}
.MessageBox .Body {
	BORDER-RIGHT: #e6e6e6 1px solid; BORDER-LEFT: #e6e6e6 1px solid; WIDTH: 449px; PADDING-TOP: 20px; HEIGHT: 150px
}
.MessageBox .Body .Icon {
	BACKGROUND: url(<%=basePath%>/images/result_<%=resultPage.getMessageType()%>.gif) no-repeat 20px top; FLOAT: left; WIDTH: 100px; HEIGHT: 100%
}
.MessageBox .Body .Content {
	FLOAT: left; OVERFLOW: hidden; WIDTH: 329px
}
#Error_MessageBox .Content #Message {
	MARGIN-BOTTOM: 10px
}
#Error_MessageBox .Content #ReturnBox {
	
}
#Succeed_MessageBox .Content #ReturnBox {
	
}
#Error_MessageBox .Content #ReturnBox UL {
	MARGIN: 0px 0px 10px 20px
}
#Succeed_MessageBox .Content #ReturnBox UL {
	MARGIN: 0px 0px 10px 20px
}
#Error_MessageBox .Content #ReturnBox UL LI {
	OVERFLOW: hidden; WHITE-SPACE: nowrap; TEXT-OVERFLOW: ellipsis
}
#Succeed_MessageBox .Content #ReturnBox UL LI {
	OVERFLOW: hidden; WHITE-SPACE: nowrap; TEXT-OVERFLOW: ellipsis
}
#Error_MessageBox .Content #ShowTrack {
	COLOR: #999999
}
#Error_MessageBox .Content #TrackBox #tbErrorTrack {
	WIDTH: 320px; HEIGHT: 120px
}
.MessageBox .Bottom {
	BACKGROUND: url(MessageBox_Bottom.gif) no-repeat 50% top; WIDTH: 451px; HEIGHT: 12px
}
</style>

<center>
<div id="Error_MessageBox" class="MessageBox">
    <div class="Title"><%=resultPage.getMessageTypeLabel()%></div>
    <div class="Body">
        <div class="Icon"></div>
        <div class="Content">
            <div id="Message"><%=resultPage.getMessageLabel()%></div>
            <div id="ReturnBox">
            <ul>

<%
for(int i = 0; i < resultPage.getLinks().size() ; i ++){
String link = String.valueOf(resultPage.getLinks().getValue(i));
if (!link.startsWith("http://"))
	link = basePath + link;

%>
            <li><a href="<%=link%>"><%=resultPage.getLinks().get(i)%></a></li>
<%
}
%>
            </ul></div>
<%
if (resultPage.getMessageContent() != null) {
 %>
            <div id="ShowTrack"><input type="checkbox" onclick="Hide('TrackBox')" /> <%=ResourceBundle.getText(request,"result.exception.detail")%></div>
            <div id="TrackBox" style="display:none;">
                <textarea id="tbErrorTrack">
<%=resultPage.getMessageContent()%>
				</textarea>
            </div>
<%
}
 %>
        </div>
    </div>
    <div class="MessageBox_Bottom"></div>
</div></center>


<script language=javascript>
function Hide(id)
{
    var me = document.getElementById(id);
    if(me.style.display == "none")
    {
        //展开
        me.style.display = "";
    }
    else
    {
        //隐藏
        me.style.display = "none";
    }
}
	</script>
</body>
</html>