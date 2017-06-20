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
<body onload="loadTriskcaseRecord();loadHidInfo();">
<center>
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>
try{
	parent.historyIframe.addHistory('/t_riskcase_record/t_riskcase_record_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseRecordForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','案例处理登记要素表(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseRecordForm.triskcaseRecord.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseRecordForm.triskcaseRecordPrimaryKey}" />
	<h:form id="triskcaseRecordForm" style="width:96%">
    	<f:verbatim><div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"></f:verbatim><h:outputText value="#{text['triskcaseRecord.t_riskcase_record_ViewForm.heading']}" /><f:verbatim></a></li>
    	    </ul>
    	</div></f:verbatim>
	<a4j:jsFunction name="loadTriskcaseRecord" action="#{triskcaseRecordForm.loadTriskcaseRecord}" reRender="triskcaseRecordForm"></a4j:jsFunction>		
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
				<h:outputText value="#{text['section.t_riskcase_record.2c90834916e5db4a0116e613cbea001f']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="riskcaseId" styleClass="outputlabel" value="#{text['triskcaseRecord.riskcaseId']}" />
				<h:outputLink id="riskcaseId_link" value="../t_riskcase/t_riskcase_ViewForm.faces?_key=#{triskcaseRecordForm.triskcaseRecord.riskcaseId}">
    				<h:outputText id="riskcaseId" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseId}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="riskcaseId" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="investigationDate" styleClass="outputlabel" value="#{text['triskcaseRecord.investigationDate']}" />
				<h:outputText id="investigationDate" value="#{triskcaseRecordForm.triskcaseRecord.investigationDate}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="investigationDate" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="createDate" styleClass="outputlabel" value="#{text['triskcaseRecord.createDate']}" />
				<h:outputText id="createDate" value="#{triskcaseRecordForm.triskcaseRecord.createDate}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="createDate" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="investigationWay" styleClass="outputlabel" value="#{text['triskcaseRecord.investigationWay']}" />
				<be:outputText id="investigationWay" value="#{triskcaseRecordForm.triskcaseRecord.investigationWay}">					
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.3']}" itemValue="3"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="investigationWay" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="isPickFlow" styleClass="outputlabel" value="#{text['triskcaseRecord.isPickFlow']}" />
				<h:selectBooleanCheckbox id="isPickFlow" value="#{triskcaseRecordForm.triskcaseRecord.isPickFlow}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="isPickFlow" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="pickCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickCnt']}" />
				<h:outputText id="pickCnt" value="#{triskcaseRecordForm.triskcaseRecord.pickCnt}" />
	            <h:inputHidden />
			    <x:message for="pickCnt" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="pickAmt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickAmt']}" />
				<h:outputText id="pickAmt" value="#{triskcaseRecordForm.triskcaseRecord.pickAmt}" />
	            <h:inputHidden />
			    <x:message for="pickAmt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="pick180Cnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pick180Cnt']}" />
				<h:outputText id="pick180Cnt" value="#{triskcaseRecordForm.triskcaseRecord.pick180Cnt}" />
	            <h:inputHidden />
			    <x:message for="pick180Cnt" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="pick180Amt" styleClass="outputlabel" value="#{text['triskcaseRecord.pick180Amt']}" />
				<h:outputText id="pick180Amt" value="#{triskcaseRecordForm.triskcaseRecord.pick180Amt}" />
	            <h:inputHidden />
			    <x:message for="pick180Amt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="pickStatus" styleClass="outputlabel" value="#{text['triskcaseRecord.pickStatus']}" />
				<be:outputText id="pickStatus" value="#{triskcaseRecordForm.triskcaseRecord.pickStatus}">					
                   <f:selectItem itemLabel="#{text['triskcaseRecord.pickStatus.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.pickStatus.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.pickStatus.2']}" itemValue="2"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="pickStatus" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="pickFlawCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickFlawCnt']}" />
				<h:outputText id="pickFlawCnt" value="#{triskcaseRecordForm.triskcaseRecord.pickFlawCnt}" />
	            <h:inputHidden />
			    <x:message for="pickFlawCnt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="pickEmptyCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickEmptyCnt']}" />
				<h:outputText id="pickEmptyCnt" value="#{triskcaseRecordForm.triskcaseRecord.pickEmptyCnt}" />
	            <h:inputHidden />
			    <x:message for="pickEmptyCnt" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="investigationResult" styleClass="outputlabel" value="#{text['triskcaseRecord.investigationResult']}" />
				<be:outputText id="investigationResult" value="#{triskcaseRecordForm.triskcaseRecord.investigationResult}">					
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationResult.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationResult.0']}" itemValue="0"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="investigationResult" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="riskLevel" styleClass="outputlabel" value="#{text['triskcaseRecord.riskLevel']}" />
				<be:outputText id="riskLevel" value="#{triskcaseRecordForm.triskcaseRecord.riskLevel}">					
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.3']}" itemValue="3"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="riskLevel" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="riskType" styleClass="outputlabel" value="#{text['triskcaseRecord.riskType']}" />
				<be:outputText id="riskType" value="#{triskcaseRecordForm.triskcaseRecord.riskType}">					
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.4']}" itemValue="4"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="riskType" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="processType" styleClass="outputlabel" value="#{text['triskcaseRecord.processType']}" />
				<be:outputText id="processType" value="#{triskcaseRecordForm.triskcaseRecord.processType}">					
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.00']}" itemValue="00"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.01']}" itemValue="01"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.10']}" itemValue="10"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.11']}" itemValue="11"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.12']}" itemValue="12"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.13']}" itemValue="13"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="processType" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="processFreezeAmt" styleClass="outputlabel" value="#{text['triskcaseRecord.processFreezeAmt']}" />
				<h:outputText id="processFreezeAmt" value="#{triskcaseRecordForm.triskcaseRecord.processFreezeAmt}" />
	            <h:inputHidden />
			    <x:message for="processFreezeAmt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="processWithdrawCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.processWithdrawCnt']}" />
				<h:outputText id="processWithdrawCnt" value="#{triskcaseRecordForm.triskcaseRecord.processWithdrawCnt}" />
	            <h:inputHidden />
			    <x:message for="processWithdrawCnt" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="description" styleClass="outputlabel" value="#{text['triskcaseRecord.description']}" />
			    <h:inputTextarea id="description" value="#{triskcaseRecordForm.triskcaseRecord.description}" cols="20" rows="4" readonly="true" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="description" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>
</f:view>
</center>
</body>	