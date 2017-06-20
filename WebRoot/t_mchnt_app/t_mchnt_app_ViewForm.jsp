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
	parent.historyIframe.addHistory('/t_mchnt_app/t_mchnt_app_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntAppForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="tmchntApp.t_mchnt_app_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntAppForm.tmchntApp.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'tmchntAppForm');"><a href="#"><h:outputText value="#{text['tmchntApp.t_mchnt_app_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{tmchntAppForm.tmchntAppPrimaryKey}" />
	<h:form id="tmchntAppForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{tmchntAppForm.edit}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_mchnt_app.2c90834916e5db4a0116e62503630094']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_mchnt_app/t_mchnt_app_EditForm.faces?_key=#{tmchntAppForm.tmchntApp.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{tmchntAppForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_mchnt_app.2c90834916e5db4a0116e62503820095']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_mchnt_app.2c90834916e5db4a0116e62501ec0088']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mchntId" styleClass="outputlabel" value="#{text['tmchntApp.mchntId']}" />
				<h:outputLink id="mchntId_link" value="../t_mchnt/t_mchnt_ViewForm.faces?_key=#{tmchntAppForm.tmchntApp.mchntId}">
    				<h:outputText id="mchntId" value="#{tmchntAppForm.tmchntApp.mchntIdOfTmchnt.id}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="mchntId" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="apptype" styleClass="outputlabel" value="#{text['tmchntApp.apptype']}" />
				<h:outputText id="apptype" value="#{tmchntAppForm.tmchntApp.apptype}" />
	            <h:inputHidden />
			    <x:message for="apptype" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="main" styleClass="outputlabel" value="#{text['tmchntApp.main']}" />
				<h:selectBooleanCheckbox id="main" value="#{tmchntAppForm.tmchntApp.main}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="main" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="acquirer" styleClass="outputlabel" value="#{text['tmchntApp.acquirer']}" />
				<h:outputText id="acquirer" value="#{tmchntAppForm.tmchntApp.acquirer}" />
	            <h:inputHidden />
			    <x:message for="acquirer" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="networktransferinst" styleClass="outputlabel" value="#{text['tmchntApp.networktransferinst']}" />
				<h:outputText id="networktransferinst" value="#{tmchntAppForm.tmchntApp.networktransferinst}" />
	            <h:inputHidden />
			    <x:message for="networktransferinst" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="memberinstmerno" styleClass="outputlabel" value="#{text['tmchntApp.memberinstmerno']}" />
				<h:outputText id="memberinstmerno" value="#{tmchntAppForm.tmchntApp.memberinstmerno}" />
	            <h:inputHidden />
			    <x:message for="memberinstmerno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="depositbank" styleClass="outputlabel" value="#{text['tmchntApp.depositbank']}" />
				<h:outputText id="depositbank" value="#{tmchntAppForm.tmchntApp.depositbank}" />
	            <h:inputHidden />
			    <x:message for="depositbank" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="settlementaccntname" styleClass="outputlabel" value="#{text['tmchntApp.settlementaccntname']}" />
				<h:outputText id="settlementaccntname" value="#{tmchntAppForm.tmchntApp.settlementaccntname}" />
	            <h:inputHidden />
			    <x:message for="settlementaccntname" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="settlementaccntno" styleClass="outputlabel" value="#{text['tmchntApp.settlementaccntno']}" />
				<h:outputText id="settlementaccntno" value="#{tmchntAppForm.tmchntApp.settlementaccntno}" />
	            <h:inputHidden />
			    <x:message for="settlementaccntno" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="belongToInst" styleClass="outputlabel" value="#{text['tmchntApp.belongToInst']}" />
				<h:outputLink id="belongToInst_link" value="../t_organize_info/t_organize_info_ViewForm.faces?_key=#{tmchntAppForm.tmchntApp.belongToInst}">
    				<h:outputText id="belongToInst" value="#{tmchntAppForm.tmchntApp.belongToInstOfTorganizeInfo.name}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="belongToInst" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>

	
</f:view>
</body>	