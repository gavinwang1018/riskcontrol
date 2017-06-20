<%@page import="java.util.*"%> 
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="cn.com.brilliance.begen.common.BeGenHistory"%>
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
<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
<script>
var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;
</script>
</head>
<body onload="loadTruleInstanceMcc();loadHidInfo();">
<center>
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>
try{
	parent.historyIframe.addHistory('/t_rule_instance_mcc/t_rule_instance_mcc_form_edit_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceMccForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','子规则实例码表(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceMccForm.truleInstanceMcc.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{truleInstanceMccForm.truleInstanceMccPrimaryKey}" />
	<h:form id="truleInstanceMccForm" style="width:96%">
    	<f:verbatim><div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"></f:verbatim><h:outputText value="#{text['truleInstanceMcc.t_rule_instance_mcc_form_edit_ViewForm.heading']}" /><f:verbatim></a></li>
    	    </ul>
    	</div></f:verbatim>
	<a4j:jsFunction name="loadTruleInstanceMcc" action="#{truleInstanceMccForm.loadTruleInstanceMcc}" reRender="truleInstanceMccForm"></a4j:jsFunction>		
		<h:inputHidden id="forId"/>	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"><li></f:verbatim>
					<h:commandLink   onclick="window.close()">
						<f:verbatim><span class="linkCancelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.cancel']}"/>
					</h:commandLink>						
					<f:verbatim></li></ul></f:verbatim>
				</h:panelGroup>
			</h:panelGrid>	
						
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_rule_instance_mcc_form_edit.2c90834916ad22cb0116b2a5e088017d']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="ruleInstanceId" styleClass="outputlabel" value="#{text['truleInstanceMcc.ruleInstanceId']}" />
				<h:outputLink id="ruleInstanceId_link" value="../t_rule_instance/t_rule_instance_ViewForm.faces?_key=#{truleInstanceMccForm.truleInstanceMcc.ruleInstanceId}">
    				<h:outputText id="ruleInstanceId" value="#{truleInstanceMccForm.truleInstanceMcc.ruleInstanceIdOfTruleInstance.id}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="ruleInstanceId" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="param1" styleClass="outputlabel" value="#{text['truleInstanceMcc.param1']}" />
				<h:outputText id="param1" value="#{truleInstanceMccForm.truleInstanceMcc.param1}" />
	            <h:inputHidden />
			    <x:message for="param1" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="param2" styleClass="outputlabel" value="#{text['truleInstanceMcc.param2']}" />
				<h:outputText id="param2" value="#{truleInstanceMccForm.truleInstanceMcc.param2}" />
	            <h:inputHidden />
			    <x:message for="param2" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="param3" styleClass="outputlabel" value="#{text['truleInstanceMcc.param3']}" />
				<h:outputText id="param3" value="#{truleInstanceMccForm.truleInstanceMcc.param3}" />
	            <h:inputHidden />
			    <x:message for="param3" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="param4" styleClass="outputlabel" value="#{text['truleInstanceMcc.param4']}" />
				<h:outputText id="param4" value="#{truleInstanceMccForm.truleInstanceMcc.param4}" />
	            <h:inputHidden />
			    <x:message for="param4" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mccCode" styleClass="outputlabel" value="#{text['truleInstanceMcc.mccCode']}" />
				<h:outputText id="mccCode" value="#{truleInstanceMccForm.truleInstanceMcc.mccCode}" />
	            <h:inputHidden />
			    <x:message for="mccCode" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="riskThreshold" styleClass="outputlabel" value="#{text['truleInstanceMcc.riskThreshold']}" />
				<h:outputText id="riskThreshold" value="#{truleInstanceMccForm.truleInstanceMcc.riskThreshold}" />
	            <h:inputHidden />
			    <x:message for="riskThreshold" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="bigmccCode" styleClass="outputlabel" value="#{text['truleInstanceMcc.bigmccCode']}" />
				<h:outputText id="bigmccCode" value="#{truleInstanceMccForm.truleInstanceMcc.bigmccCode}" />
	            <h:inputHidden />
			    <x:message for="bigmccCode" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mccId" styleClass="outputlabel" value="#{text['truleInstanceMcc.mccId']}" />
				<h:outputLink id="mccId_link" value="../t_mcc/t_mcc_ViewForm.faces?_key=#{truleInstanceMccForm.truleInstanceMcc.mccId}">
    				<h:outputText id="mccId" value="#{truleInstanceMccForm.truleInstanceMcc.mccIdOfTmcc.id}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="mccId" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>
</f:view>
</center>
</body>	