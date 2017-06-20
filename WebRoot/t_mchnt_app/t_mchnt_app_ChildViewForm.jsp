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
<body onload="loadTmchntApp();loadHidInfo();">
<center>
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>
try{
	parent.historyIframe.addHistory('/t_mchnt_app/t_mchnt_app_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntAppForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','商户多应用表(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntAppForm.tmchntApp.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tmchntAppForm.tmchntAppPrimaryKey}" />
	<h:form id="tmchntAppForm" style="width:96%">
    	<f:verbatim><div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"></f:verbatim><h:outputText value="#{text['tmchntApp.t_mchnt_app_ViewForm.heading']}" /><f:verbatim></a></li>
    	    </ul>
    	</div></f:verbatim>
	<a4j:jsFunction name="loadTmchntApp" action="#{tmchntAppForm.loadTmchntApp}" reRender="tmchntAppForm"></a4j:jsFunction>		
		<h:inputHidden id="forId"/>	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"><li></f:verbatim>
					<h:commandLink   onclick="window.close()">
						<f:verbatim><span class="linkClearImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.cancel']}"/>
					</h:commandLink>						
					<f:verbatim></li></ul></f:verbatim>
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
</center>
</body>	