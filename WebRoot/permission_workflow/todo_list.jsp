<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
String basePath = request.getContextPath();
%>
<html>
  <head>
    <title><%=ResourceBundle.getText(request,"title.todolist")%></title> 
        <link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/config.css" />
		<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
		<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>
		<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
  </head>
<script  language="JavaScript" defer>
loadHidInfo()
</script>

  <body>
      <div class="title">	
		<img src="<%=basePath%>/images/title_icon_edit.gif" align=left /><p class="titleText"><%=ResourceBundle.getText(request,"label.todolist")%></p>			
		<p class="titleText1"><%=ResourceBundle.getText(request,"label.todolist")%></p>					
	  </div>
<br/>

			<table id="todolisttable" border="0" cellpadding="0" cellspacing="0" class="mainTable">
				<tr>
					<th class="mainHeader"><img src="<%=basePath%>/images/icon_sub_list.gif" style="vertical-align:middle;" />待办工作项</th>
				</tr>
				
				
				<tr>
					<td>
						<table class="detail" style="border-bottom:2px solid #7ABEFF;" id="todoTable">
							<tr>
								<th class="headTable"><%=ResourceBundle.getText(request,"label.operate")%></th>
								<th class="headTable"><%=ResourceBundle.getText(request,"label.label")%></th>
								<th class="headTable"><%=ResourceBundle.getText(request,"label.creator")%></th>
								<th class="headTable"><%=ResourceBundle.getText(request,"label.createtime")%></th>
								<th class="headTable"><%=ResourceBundle.getText(request,"label.receiver")%></th>
							</tr>
<%
List list = (List)request.getAttribute("__todo_list");
for (int i = 0 ; i < list.size(); i ++){
	Map map = (Map)list.get(i);
%>
							<tr class="rowsClass2">
								<td style="width:10px;">
									<nobr>
                   	    <a href='<%=map.get("url")%>&_taskInsId=<%=map.get("id")%>' class="listbtn"><%=ResourceBundle.getText(request,"button.operate")%></a>
									</nobr>
								</td>  								
								<td><%=map.get("taskTitle")%></td>
								<td><%=map.get("operator")%></td>
								<%
								String instanceStart = String.valueOf(map.get("instanceStart"));
								instanceStart = instanceStart.substring(0,instanceStart.length() - 2);
								%>
								<td><%=instanceStart%></td>
								<%
								String org = (String)map.get("receiptOrg");
								String role = (String)map.get("receiptRole");
								String user = (String)map.get("receiptUser");								
								%>
								<td><%=org%> <%=role%> <%=user%></td>
							</tr>
<%
}
%>
                        </table>
					</td>
				</tr>
			</table>	    
  </body>
    <script language=javascript>
  highlightTableRows("todoTable");
  </script>
</html>
