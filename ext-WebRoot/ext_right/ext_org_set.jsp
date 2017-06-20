<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=gb2312" %>
<%@ page isThreadSafe="false" %>
<%@ page import="java.util.*" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="cn.com.brilliance.begen.common.Tools" %>
<%@ page import="cn.com.brilliance.risk.ext.interfaces.DataManageController" %>
<%@ page import="cn.com.brilliance.begen.dao.TorganizeUserDAO" %>
<%@ page import="cn.com.brilliance.begen.model.TorganizeUser" %>
<%
String path = request.getContextPath();
String userId = request.getParameter("_user_id");
List orgList = new ArrayList();
if(userId != null){
	TorganizeUserDAO torganizeUserDAO = (TorganizeUserDAO) Tools.getBean("torganizeUserDAO");
	TorganizeUser tu = new TorganizeUser();
	tu.setUserId(userId);
	List list = torganizeUserDAO.getTorganizeUserList(tu);
	for (int n = 0; n < list.size(); n++) {
		TorganizeUser torganizeUser = (TorganizeUser) list.get(n);
		System.out.println("torganizeUser:" + torganizeUser.getOrganizeId());
		orgList.add(torganizeUser.getOrganizeId());
	}
}	
DataManageController dataManageController = (DataManageController) Tools.getBean("dataManageController");
String sql = "select id,name from t_organize_info where dw_flag='1' order by name";
List list = dataManageController.queryForList(sql);
%>
<html>
<head>
<title>机构列表</title>

<link rel="stylesheet" type="text/css" media="all" href="<%=path%>/styles/config.css" />
<link rel="stylesheet" type="text/css" media="all" href="<%=path%>/styles/right.css" />
<script type="text/javascript" src="<%=path%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=path%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/common.js"></script>

<script type="text/javascript" src="<%=path%>/scripts/behaviour.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/getclass.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/calculator.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/edit.js"></script>

</head>
<body>
<form name="orgConfig" method="post" action="<%=path%>/OrgControlServlet">
<table border="0" align="center">
<%
for(int i=0; i<list.size(); i++){
  Map txnMap = (Map)list.get(i);
  BigDecimal respCode = (BigDecimal)txnMap.get("id");
  String respName = (String)txnMap.get("name");  
%>
<%
if( i % 3 == 0){
%>
<tr>
<%}%>
  <td>
    <input type=checkbox name="respId" value="<%=respCode.toString()%>" <%if(orgList.contains(respCode.toString())){%>checked<%}%>><%=respName%>
  </td>
<%
if( i % 3 == 2){
%>  
</tr>
<%}}%>
</table>
<table align="center" style="mainTable">
<tr>
  <td>
    <input type="button" name="submit" value="全选" onclick="selAll();">&nbsp;
  </td>
  <td>
    <input type="button" name="submit" value="全不选" onclick="clearAll();">&nbsp;
  </td>
  <td>
    <input type="submit" name="submit" value="保存" onclick="doSubmit();">&nbsp;
  </td>    
</tr>
</table>
<input type="hidden" id="orgs" name="orgs">
<input type="hidden" name="_user_id" value="<%=userId%>">
</form>
</BODY>
</html>
<script language="javascript">

  function doSubmit(){
    var selValue = "";
	var checkboxs = document.getElementsByName("respId");
	for(i=0; i<checkboxs.length;i++){
		checks = checkboxs[i];
		if(checks.checked){
		    	selValue = selValue + checks.value + ",";	
		}
	}
	var selLen = selValue.length;
	if(selLen > 0){
		selValue = selValue.substring(0,(selLen-1));
	}  
    document.getElementById("orgs").value=selValue;
	//orgConfig.submit();
  }
  
  function doRequest(){
    var selValue = "";
	var checkboxs = document.getElementsByName("respId");
	for(i=0; i<checkboxs.length;i++){
		checks = checkboxs[i];
		if(checks.checked){
		    	selValue = selValue + checks.value + ",";	
		}
	}
	var selLen = selValue.length;
	if(selLen > 0){
		selValue = selValue.substring(0,(selLen-1));
	}
		
	opener.document.getElementById("estrnlogQuery:respcode").value = selValue;
	window.close();
  }
  
  function selAll(){
     var selValue = "";
	 var checkboxs = document.getElementsByName("respId");
	 for(i=0; i<checkboxs.length;i++){
		checkboxs[i].checked = true;
	}
  }
  
  function clearAll(){
     var selValue = "";
	 var checkboxs = document.getElementsByName("respId");
	 for(i=0; i<checkboxs.length;i++){
		checkboxs[i].checked = false;
	}  
  }
</script>