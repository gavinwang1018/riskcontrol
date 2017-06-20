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
	parent.historyIframe.addHistory('/t_mcc/t_mcc_form_edit_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmccForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="tmcc.t_mcc_form_edit_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmccForm.tmcc.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'tmccForm');"><a href="#"><h:outputText value="#{text['tmcc.t_mcc_form_edit_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{tmccForm.tmccPrimaryKey}" />
	<h:form id="tmccForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{tmccForm.edit}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_mcc_form_edit.2c908349169f7cda0116a417338a049a']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_mcc/t_mcc_form_edit_EditForm.faces?_key=#{tmccForm.tmcc.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{tmccForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_mcc_form_edit.2c908349169f7cda0116a41733a9049b']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_mcc_form_edit.2c908349169f7cda0116a41732230492']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mccName" styleClass="outputlabel" value="#{text['tmcc.mccName']}" />
				<h:outputText id="mccName" value="#{tmccForm.tmcc.mccName}" />
	            <h:inputHidden />
			    <x:message for="mccName" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mccCode" styleClass="outputlabel" value="#{text['tmcc.mccCode']}" />
				<h:outputText id="mccCode" value="#{tmccForm.tmcc.mccCode}" />
	            <h:inputHidden />
			    <x:message for="mccCode" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="bigmccName" styleClass="outputlabel" value="#{text['tmcc.bigmccName']}" />
				<h:outputText id="bigmccName" value="#{tmccForm.tmcc.bigmccName}" />
	            <h:inputHidden />
			    <x:message for="bigmccName" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="bigmccCode" styleClass="outputlabel" value="#{text['tmcc.bigmccCode']}" />
				<h:outputText id="bigmccCode" value="#{tmccForm.tmcc.bigmccCode}" />
	            <h:inputHidden />
			    <x:message for="bigmccCode" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="midmccName" styleClass="outputlabel" value="#{text['tmcc.midmccName']}" />
				<h:outputText id="midmccName" value="#{tmccForm.tmcc.midmccName}" />
	            <h:inputHidden />
			    <x:message for="midmccName" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="midmccCode" styleClass="outputlabel" value="#{text['tmcc.midmccCode']}" />
				<h:outputText id="midmccCode" value="#{tmccForm.tmcc.midmccCode}" />
	            <h:inputHidden />
			    <x:message for="midmccCode" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>

	
</f:view>
</body>	