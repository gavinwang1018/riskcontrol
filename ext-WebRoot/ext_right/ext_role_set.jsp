<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=gb2312" %>
<%@ page isThreadSafe="false" %>
<%@ page import="java.util.*" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="cn.com.brilliance.begen.common.Tools" %>
<%@ page import="cn.com.brilliance.risk.ext.common.Function" %>
<%@ page import="cn.com.brilliance.risk.ext.interfaces.DataManageController" %>
<%@ page import="cn.com.brilliance.begen.dao.TroleUserDAO" %>
<%@ page import="cn.com.brilliance.begen.model.TroleUser" %>
<%@ page import="cn.com.brilliance.begen.common.Constants" %>
<%@ page import="cn.com.brilliance.begen.webapp.servlet.UserBean" %>
<%
String path = request.getContextPath();
String userId = request.getParameter("_user_id");
UserBean userBean = (UserBean)request.getSession().getAttribute(Constants.SESSION_USER_INFO);
List roleList = new ArrayList();
boolean isParentCompany = false;

if(userId != null){
	TroleUserDAO troleUserDAO = (TroleUserDAO) Tools.getBean("troleUserDAO");
	TroleUser tu = new TroleUser();
	tu.setUserId(userId);
	List list = troleUserDAO.getTroleUserList(tu);
	for (int n = 0; n < list.size(); n++) {
		TroleUser troleUser = (TroleUser) list.get(n);
		roleList.add(troleUser.getRoleId());
	}	
	isParentCompany = Function.isParentCompany(userBean.getTuserInfo().getOrganizeIdOfTorganizeInfo().getId());
}		
DataManageController dataManageController = (DataManageController) Tools.getBean("dataManageController");
String sql = "select id,name,code from t_role_info order by code";
List list = dataManageController.queryForList(sql);
%>
<html>
<head>
<title>角色列表</title>

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
<form id="roleSetForm" method="post" action="<%=path%>/RoleControlServlet">
<table border="0" align="center">
<%
for(int i=0; i<list.size(); i++){
  Map txnMap = (Map)list.get(i);
  BigDecimal respCode = (BigDecimal)txnMap.get("id");
  String respName = (String)txnMap.get("name");  
  String code = (String)txnMap.get("code");
  if(isParentCompany){
%>
<%
if( i % 3 == 0){
%>
<tr>
<%}%>
  <td>
    <input type=checkbox name="respId" value="<%=respCode.toString()%>" <%if(roleList.contains(respCode.toString())){%>checked<%}%>><%=respName%>
  </td>
<%
if( i % 3 == 2){
%>  
</tr>
<%}
}else if("1".equals(code) || "4".equals(code) || "5".equals(code) || "6".equals(code) || "7".equals(code)){
%>
<%
if( i % 3 == 0){
%>
<tr>
<%}%>
  <td>
    <input type=checkbox name="respId" value="<%=respCode.toString()%>" <%if(roleList.contains(respCode.toString())){%>checked<%}%>><%=respName%>
  </td>
<%
if( i % 3 == 2){
%>  
</tr>
<%}
}
}%>
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
<input type="hidden" name="roles" id="roles">
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
    document.getElementById("roles").value=selValue;
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