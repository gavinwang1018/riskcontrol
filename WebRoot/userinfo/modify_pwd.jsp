<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<%@ include file="/common/taglibs.jsp"%>
<%
String basePath = request.getContextPath();
javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().setLocale(cn.com.brilliance.begen.common.bundle.ResourceBundle.getLocale(request));
%>
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/config.css" />
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>
<body>
<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<h:form id="userInfoForm">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" headerClass="mainHeader" footerClass="mainFooter">
			<f:facet name="header">
				<h:panelGroup><h:graphicImage url="../images/icon_sub_edit.gif" style="vertical-align:middle;"  /><h:outputText value="#{text['userinfo.password.modify']}" /></h:panelGroup>
			</f:facet>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="mainHeader2" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="" />
			</f:facet>	
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable border_left" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			  <h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				 <h:panelGroup><f:verbatim><table><tr ><td valign=top></td><td></f:verbatim>
					<h:outputLabel for="oldPassword" styleClass="outputlabel" value="#{text['userinfo.password.old']}" />
					<f:verbatim></td></tr></table></f:verbatim></h:panelGroup>
					<h:panelGroup>
					<f:verbatim><span class="mustw"></span></f:verbatim>
					<h:inputSecret id="oldPassword" value="#{userInfoForm.oldPassword}" styleClass="edit_input">
				  <s:commonsValidator type="required" arg="#{text['userinfo.password.old']}" client="true" server="false" />
				  </h:inputSecret>
        </h:panelGroup>
  	      <h:inputHidden />
			    <x:message for="oldPassword" styleClass="fieldError" />
			  </h:panelGrid>
			  <h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				 <h:panelGroup><f:verbatim><table><tr ><td valign=top></td><td></f:verbatim>
					<h:outputLabel for="password" styleClass="outputlabel" value="#{text['userinfo.password.new']}" />
					<f:verbatim></td></tr></table></f:verbatim></h:panelGroup>
					<h:panelGroup>
					<f:verbatim><span class="mustw"></span></f:verbatim>
					<h:inputSecret id="password" value="#{userInfoForm.password}" styleClass="edit_input">
				  <s:commonsValidator type="required" arg="#{text['userinfo.password.new']}" client="true" server="false" />
				  </h:inputSecret>
				  <f:verbatim>&nbsp;&nbsp<font color="#999999"><%=ResourceBundle.getText(request,"userinfo.password.hint")%></font></f:verbatim>
        </h:panelGroup>
  	      <h:inputHidden />
			    <x:message for="password" styleClass="fieldError" />
			  </h:panelGrid>			   
			  <h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				 <h:panelGroup><f:verbatim><table><tr ><td valign=top></td><td></f:verbatim>
					<h:outputLabel for="password1" styleClass="outputlabel" value="#{text['userinfo.password.repeat']}" />
					<f:verbatim></td></tr></table></f:verbatim></h:panelGroup>
					<h:panelGroup>
					<f:verbatim><span class="mustw"></span></f:verbatim>
					<h:inputSecret id="password1" value="" styleClass="edit_input">
				      <s:commonsValidator type="required" arg="#{text['userinfo.password.repeat']}" client="true" server="false" />
 				   </h:inputSecret>
 				   <f:verbatim>&nbsp;&nbsp<font color="#999999"><%=ResourceBundle.getText(request,"userinfo.password.confirm")%></font></f:verbatim>
        </h:panelGroup>
  	      <h:inputHidden />
			    <x:message for="password1" styleClass="fieldError" />
			  </h:panelGrid>			  
			</h:panelGrid>			
		</h:panelGrid>
			<f:facet name="footer">
				<h:panelGroup>
					<h:panelGroup>
        <h:commandButton  onclick="return validateUserInfoForm(this.form)"  value="#{text['button.save']}" action="#{userInfoForm.modifyPassword}" styleClass="button" />
					</h:panelGroup>
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	</h:form>
	<s:validatorScript functionName="validateUserInfoForm" />
	<script type="text/javascript">
    	function validateUserInfo(form) {
    		if (validateUserInfoForm(form) == false) return false;
       	var password =document.getElementById("userInfoForm:password");
       	var password1 =document.getElementById("userInfoForm:password1");       	
       	if(password.value != password1.value){
       		alert('<%=ResourceBundle.getText(request,"userinfo.password.retry")%>')
       		password.value = '';
       		password1.value  = '';
       		password.focus();
       		return false;
       	}
      }
	</script>
</f:view>
</body>
