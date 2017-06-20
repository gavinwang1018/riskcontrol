<%@page import="java.util.*"%> 
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="cn.com.brilliance.begen.common.BeGenHistory"%>
<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%
String basePath = request.getContextPath();
javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().setLocale(cn.com.brilliance.begen.common.bundle.ResourceBundle.getLocale(request));

%>
<head>
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/config.css" />
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/right.css" />
<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>
</head>
<body onload="loadHidInfo();">	

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
		<f:loadBundle var="text" basename="ApplicationResources" />
<script language=javascript>
try{
	parent.historyIframe.addHistory('/t_user_info/t_user_info_form_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tuserInfoForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="tuserInfo.t_user_info_form_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tuserInfoForm.tuserInfo.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'tuserInfoForm');"><a href="#"><h:outputText value="#{text['tuserInfo.t_user_info_form_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{tuserInfoForm.tuserInfoPrimaryKey}" />
	<h:form id="tuserInfoForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{tuserInfoForm.edit}" rendered="#{sessionScope._user_info.actionMap['action.20'] == 'true'}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_user_info_form.2c908349169f7cda0116a994c3b2077c']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_user_info/t_user_info_form_EditForm.faces?_key=#{tuserInfoForm.tuserInfo.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{tuserInfoForm.closeUser}" onclick="if(!confirm('#{text['button.close']}'))return false;" rendered="#{sessionScope._user_info.actionMap['action.20'] == 'true'}">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_user_info_form.2c908349169f7cda0116a994c3c2077d']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{tuserInfoForm.roleControl}" rendered="#{sessionScope._user_info.actionMap['action.20'] == 'true'}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="角色设置" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../ext_right/ext_role_set.faces?_user_id=#{tuserInfoForm.tuserInfo.id}"/>
					</h:commandLink>		
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_user_info_form.2c908349171ad65f01172a7047d60007']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="loginName" styleClass="outputlabel" value="#{text['tuserInfo.loginName']}" />
				<h:outputText id="loginName" value="#{tuserInfoForm.tuserInfo.loginName}" />
	            <h:inputHidden />
			    <x:message for="loginName" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="name" styleClass="outputlabel" value="#{text['tuserInfo.name']}" />
				<h:outputText id="name" value="#{tuserInfoForm.tuserInfo.name}" />
	            <h:inputHidden />
			    <x:message for="name" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="password" styleClass="outputlabel" value="#{text['tuserInfo.password']}" />
	            <h:inputHidden />
			    <x:message for="password" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="email" styleClass="outputlabel" value="#{text['tuserInfo.email']}" />
				<h:outputText id="email" value="#{tuserInfoForm.tuserInfo.email}" />
	            <h:inputHidden />
			    <x:message for="email" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="enable" styleClass="outputlabel" value="#{text['tuserInfo.enable']}" />
				<h:selectBooleanCheckbox id="enable" value="#{tuserInfoForm.tuserInfo.enable}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="enable" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="organizeId" styleClass="outputlabel" value="#{text['tuserInfo.organizeId']}" />
				<h:outputLink id="organizeId_link" value="../t_organize_info/t_organize_info_ViewForm.faces?_key=#{tuserInfoForm.tuserInfo.organizeId}">
    				<h:outputText id="organizeId" value="#{tuserInfoForm.tuserInfo.organizeIdOfTorganizeInfo.name}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="organizeId" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>

	
</f:view>
</body>	