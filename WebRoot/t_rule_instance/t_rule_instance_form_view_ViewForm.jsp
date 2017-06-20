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
	parent.historyIframe.addHistory('/t_rule_instance/t_rule_instance_form_view_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="truleInstance.t_rule_instance_form_view_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceForm.truleInstance.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'truleInstanceForm');"><a href="#"><h:outputText value="#{text['truleInstance.t_rule_instance_form_view_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{truleInstanceForm.truleInstancePrimaryKey}" />
	<h:form id="truleInstanceForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{truleInstanceForm.edit}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_rule_instance_form_view.2c908349169f7cda0116a991b355073b']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_rule_instance/t_rule_instance_form_view_EditForm.faces?_key=#{truleInstanceForm.truleInstance.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{truleInstanceForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_rule_instance_form_view.2c908349169f7cda0116a991b375073c']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_rule_instance_form_view.2c90834916ad22cb0116b2b1044701d9']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="code" styleClass="outputlabel" value="#{text['truleInstance.code']}" />
				<h:outputText id="code" value="#{truleInstanceForm.truleInstance.code}" />
	            <h:inputHidden />
			    <x:message for="code" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="description" styleClass="outputlabel" value="#{text['truleInstance.description']}" />
				<h:outputText id="description" value="#{truleInstanceForm.truleInstance.description}" />
	            <h:inputHidden />
			    <x:message for="description" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="enable" styleClass="outputlabel" value="#{text['truleInstance.enable']}" />
				<h:selectBooleanCheckbox id="enable" value="#{truleInstanceForm.truleInstance.enable}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="enable" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="versionBm" styleClass="outputlabel" value="#{text['truleInstance.versionBm']}" />
				<h:outputText id="versionBm" value="#{truleInstanceForm.truleInstance.versionBm}" />
	            <h:inputHidden />
			    <x:message for="versionBm" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="cycle" styleClass="outputlabel" value="#{text['truleInstance.cycle']}" />
				<h:outputText id="cycle" value="#{truleInstanceForm.truleInstance.cycle}" />
	            <h:inputHidden />
			    <x:message for="cycle" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="timeParam" styleClass="outputlabel" value="#{text['truleInstance.timeParam']}" />
				<h:outputText id="timeParam" value="#{truleInstanceForm.truleInstance.timeParam}" />
	            <h:inputHidden />
			    <x:message for="timeParam" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="needTransInfo" styleClass="outputlabel" value="#{text['truleInstance.needTransInfo']}" />
				<h:selectBooleanCheckbox id="needTransInfo" value="#{truleInstanceForm.truleInstance.needTransInfo}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="needTransInfo" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="transInfo" styleClass="outputlabel" value="#{text['truleInstance.transInfo']}" />
				<h:selectBooleanCheckbox id="transInfo" value="#{truleInstanceForm.truleInstance.transInfo}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="transInfo" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="supportTrace" styleClass="outputlabel" value="#{text['truleInstance.supportTrace']}" />
				<h:selectBooleanCheckbox id="supportTrace" value="#{truleInstanceForm.truleInstance.supportTrace}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="supportTrace" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="beginTraceDate" styleClass="outputlabel" value="#{text['truleInstance.beginTraceDate']}" />
				<h:outputText id="beginTraceDate" value="#{truleInstanceForm.truleInstance.beginTraceDate}" >
					<f:convertDateTime pattern="yyyy-MM-dd HH:mm:ss" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="beginTraceDate" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="type" styleClass="outputlabel" value="#{text['truleInstance.type']}" />
				<be:outputText id="type" value="#{truleInstanceForm.truleInstance.type}">					
                   <f:selectItem itemLabel="#{text['truleInstance.type.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['truleInstance.type.1']}" itemValue="1"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="type" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="belongToInst" styleClass="outputlabel" value="#{text['truleInstance.belongToInst']}" />
				<h:outputLink id="belongToInst_link" value="../t_organize_info/t_organize_info_ViewForm.faces?_key=#{truleInstanceForm.truleInstance.belongToInst}">
    				<h:outputText id="belongToInst" value="#{truleInstanceForm.truleInstance.belongToInstOfTorganizeInfo.name}"/>
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