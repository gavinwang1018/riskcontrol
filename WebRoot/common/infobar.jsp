<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage" %>
<%
String basePath = request.getContextPath();
ResultPage resultPage = (ResultPage)request.getAttribute(ResultPage.REQUEST_ATTRIBUTE_NAME);
if (resultPage == null) {
	resultPage = new ResultPage();
	resultPage.setMessageType(ResultPage.MESSAGE_TYPE_OTHER_ERROR);
}
%>

<% 
if (resultPage.getMessageLabel() != null && !"".equals(resultPage.getMessageLabel())){ 
%>
<div id="errorInfor" class="error" style="cursor:hand;display:'';font-size:12px;"  title="<%=resultPage.getMessageContent()%>">
<%} 
else{
%>
<div id="errorInfor" class="error" style="cursor:hand;display:'none';font-size:12px;"  title="<%=resultPage.getMessageContent()%>">
<%
}
%>
		<img src="<%=basePath%>/images/iconInformation.gif" width=14 height=13 style="vertical-align:middle;margin-right:5px;" /><span style="clear:none"><%=resultPage.getMessageLabel()%></span><span style="text-align:right;float:right;vertical-align:top;margin-top:-15px;"><img src="<%=basePath%>/images/errorclose.gif" width=14 height=14 style="vertical-align:top;cursor:hand;" onclick="showError(this)"></span>
		<div id="errorURL" style="display:none;height:16px;margin-top:4px;">
<%
for(int i = 0; i < resultPage.getLinks().size() ; i ++){
String link = String.valueOf(resultPage.getLinks().getValue(i));
if (!link.startsWith("http://"))
	link = basePath + link;

%>
	&nbsp;&nbsp;<img src="<%=basePath%>/images/math.gif" width=14 height=14 /><a href="<%=link%>"><%=resultPage.getLinks().get(i)%></a>
<%
}
%>
		</div>
	</div>
<% 
if (resultPage.getMessageLabel() == null || "".equals(resultPage.getMessageLabel())){ 
%>
<br/>
<%
} 
%>
