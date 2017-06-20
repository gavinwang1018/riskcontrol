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
	<t:saveState value="#{userInfoForm.sysUser}" />

	<h:form id="sysUserForm">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" headerClass="mainHeader" footerClass="mainFooter">
			<f:facet name="header">
				<h:panelGroup><h:graphicImage url="../images/icon_sub_edit.gif" style="vertical-align:middle;"  /><h:outputText value="修改用户信息" /></h:panelGroup>
			</f:facet>
			

			
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
				<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
					<h:panelGroup><f:verbatim><table><tr ><td valign=top></td><td></f:verbatim>
					<h:outputLabel for="userName" styleClass="outputlabel" value="#{text['sysUser.userName']}" />
					<f:verbatim></td></tr></table></f:verbatim>
					</h:panelGroup>
					
					<h:panelGroup>
					<f:verbatim><span class="mustw"></span></f:verbatim>
					<h:inputText id="userName" value="#{userInfoForm.sysUser.userName}" tabindex="1"  maxlength="20" styleClass="edit_input">
					<s:commonsValidator type="required" arg="#{text['sysUser.userName']}" client="true" server="false" />
					</h:inputText>
					<f:verbatim>&nbsp;&nbsp;<font color="#999999"><%=ResourceBundle.getText(request,"userinfo.name")%></font></f:verbatim>
					</h:panelGroup>
	
	  	            <h:inputHidden />
				    <x:message for="userId" styleClass="fieldError" />
				</h:panelGrid>		
			</h:panelGrid>		
		
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			
				<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
					<h:panelGroup><f:verbatim><table><tr ><td valign=top></td><td></f:verbatim>
						<h:outputLabel for="personSex" styleClass="outputlabel" value="#{text['sysUser.personSex']}" />
						<f:verbatim></td></tr></table></f:verbatim>
					</h:panelGroup>
						
					<h:panelGroup>
						<f:verbatim><span ></span></f:verbatim> 
						<h:selectOneRadio id="personSex" value="#{userInfoForm.sysUser.personSex}"  readonly="false"  tabindex="4">
		                   <f:selectItem itemLabel="#{text['sysUser.personSex.0']}" itemValue="0"/>
		                   <f:selectItem itemLabel="#{text['sysUser.personSex.1']}" itemValue="1"/>              
						</h:selectOneRadio >	
					</h:panelGroup>
		
		  	            <h:inputHidden />
					    <x:message for="personSex" styleClass="fieldError" />
				</h:panelGrid>
				
			</h:panelGrid>


			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
					<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
						<h:panelGroup><f:verbatim><table><tr ><td valign=top></td><td></f:verbatim>
						<h:outputLabel for="email" styleClass="outputlabel" value="#{text['sysUser.email']}" />
						<f:verbatim></tr></table></f:verbatim></h:panelGroup>
						<h:panelGroup>
						<f:verbatim><span class="mustw"></span></f:verbatim>
						    <h:inputText id="email" value="#{userInfoForm.sysUser.email}" tabindex="5" styleClass="edit_input">
							<s:commonsValidator type="required" arg="#{text['sysUser.email']}" client="true" server="false" />
							<s:commonsValidator type="email"  arg="#{text['sysUser.email']}" client="true" server="false" />
						</h:inputText>
						<f:verbatim>&nbsp;&nbsp;<font color="#999999"><%=ResourceBundle.getText(request,"userinfo.email")%></font></f:verbatim>
						</h:panelGroup>
		  	            <h:inputHidden />
					    <x:message for="email" styleClass="fieldError" />
					</h:panelGrid>
			</h:panelGrid>		

			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
				<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
					<h:panelGroup><f:verbatim><table><tr ><td valign=top></td><td></f:verbatim>
					<h:outputLabel for="phone" styleClass="outputlabel" value="#{text['sysUser.phone']}" />
					<f:verbatim></td></tr></table></f:verbatim></h:panelGroup>
				    <h:inputText id="phone" value="#{userInfoForm.sysUser.phone}" size="20" tabindex="6" styleClass="edit_input">
					</h:inputText>
	  	            <h:inputHidden />
				    <x:message for="phone" styleClass="fieldError" />
				</h:panelGrid>
				
			</h:panelGrid>


			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
				<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
					<h:panelGroup><f:verbatim><table><tr ><td valign=top></td><td></f:verbatim>
					<h:outputLabel for="remark" styleClass="outputlabel" value="#{text['sysUser.remark']}" />
					<f:verbatim></td></tr></table></f:verbatim>
					</h:panelGroup>
					
					<h:panelGroup>
					<f:verbatim><span class="notw"></span></f:verbatim>
				    <h:inputTextarea id="remark" value="#{userInfoForm.sysUser.remark}" rows="10" cols="26"  readonly="false" tabindex="7" styleClass="edit_textarea">
	                </h:inputTextarea>			
					</h:panelGroup>
				
	  	            <h:inputHidden />
				    <x:message for="remark" styleClass="fieldError" />
				</h:panelGrid>
			</h:panelGrid>
			<f:facet name="footer">
				<h:panelGroup>
					<h:panelGroup>
        				<h:commandButton  onclick="return validateSysUserForm(this.form)"  value="#{text['button.save']}" action="#{userInfoForm.modifyUserInfo}" styleClass="button" />
					</h:panelGroup>
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	</h:form>
	<s:validatorScript functionName="validateSysUserForm" />
	<script type="text/javascript">
    	function validateSysUser(form) {
    		if (validateSysUserForm(form) == false) return false;
        		
        	}
	</script>
</f:view>
</body>
