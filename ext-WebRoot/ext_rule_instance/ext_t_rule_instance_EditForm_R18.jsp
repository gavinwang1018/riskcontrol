<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage"%>
<%
	String basePath = request.getContextPath();
	String cycle = request.getParameter("cycle");
	if(cycle == null) cycle = "";
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
	<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/calculator.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/edit.js"></script>
</head>

<body onload="loadChild();getDateObj();loadDateSelect()">
<script>
var imagePath = "<%=basePath%>/images";
var scriptPath = "<%=basePath%>/scripts";

var childScript = "loadTruleInstanceBigMccList();loadTruleInstanceMccList();loadHidInfo()".split(";");
var scriptCount = 0;
function loadChild(){
	eval(childScript[scriptCount++]);
}	
</script>

	<center>
		<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
		<f:view>

			<f:loadBundle var="text" basename="ApplicationResources" />
			<t:saveState value="#{truleInstanceForm.truleInstancePrimaryKey}" />
			<t:saveState value="#{truleInstanceForm.truleInstance}" />
    	
<t:saveState id="extTruleInstanceMccList" value="#{extTruleInstanceMccList.truleInstanceMccs}" />
<t:saveState id="truleInstanceMccList" value="#{truleInstanceMccList.mccList}" />

<h:form id="truleInstanceForm" style="width:96%;">

    	
    <a4j:jsFunction name="addRuleInstanceMcc" action="#{truleInstanceMccList.multiAdd}" reRender="truleInstanceMccPanel,truleInstanceMccList">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
    	
	<a4j:jsFunction name="loadTruleInstanceMccList" action="#{truleInstanceMccList.initTruleInstanceMccs}" oncomplete="loadChild()" reRender="truleInstanceMccPanel,truleInstanceMccList" /> 
	
	<a4j:jsFunction name="loadTruleInstanceBigMccList" action="#{extTruleInstanceMccList.initTruleInstanceBigMccs}" oncomplete="loadChild()" reRender="extTruleInstanceMccPanel,extTruleInstanceMccList" /> 	

    <a4j:jsFunction name="deleteInstanceMcc" action="#{truleInstanceMccList.deleteBuffer}"  reRender="truleInstanceMccPanel,truleInstanceMccs" oncomplete="rowIndexVarOfTruleInstanceMcc = -1" >
	</a4j:jsFunction>	
	
<script>
		var rowIndexVarOfTruleInstanceMcc = -1;
</script>			
<input type="hidden" name="cycle" value="<%=cycle%>">
				<div class="mytab1">
					<ul class="myTabBar1">
						<li class="Selected">
							<a href="#"><h:outputText
									value="#{text['truleInstance.t_rule_instance_EditForm.heading']}" />
							</a>
						</li>
					</ul>
				</div>
				<h:panelGrid columns="1" cellspacing="0" cellpadding="0"
					styleClass="mainTable">
					<h:panelGrid columns="1" cellspacing="0" cellpadding="0"
						styleClass="titleTable" columnClasses="titleTdClass">
						<h:panelGroup>
							<f:verbatim>
								<ul id="tool_r">
							</f:verbatim>

							<f:verbatim>
								<li>
							</f:verbatim>
							<h:commandLink action="#{truleInstanceForm.saveAllData}" tabindex="1" rendered="#{sessionScope._user_info.actionMap['action.3'] == 'true'}"
								onclick=" if(!validateTruleInstanceForm(document.getElementById('truleInstanceForm')))return; ">
								<f:verbatim>
									<span class="linkSaveImg"></span>
								</f:verbatim>
								<h:outputText styleClass="buttonText"
									value="#{text['actionedit.t_rule_instance.2c908349169f7cda0116a990bb6906fe']}" />
							</h:commandLink>
							<f:verbatim>
								</li>
							</f:verbatim>

							<f:verbatim>
								</ul>
							</f:verbatim>
						</h:panelGroup>
					</h:panelGrid>

					<h:panelGrid columns="1" cellspacing="0" cellpadding="0"
						styleClass="sectionTable" headerClass="sectionHeader"
						footerClass="mainFooter2">
						<f:facet name="header">
							<h:outputText
								value="子规则 #{truleInstanceForm.truleInstance.code}--一段时间内商户的退货金额超过商户总清算金额的情况" />
						</f:facet>


						<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
							styleClass="sectionTable" columnClasses="rowTable3,rowTable3"
							headerClass="mainHeader" footerClass="mainFooter">
							<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
								styleClass="sectionTable" columnClasses="colTitleView,colValueView">
								<h:outputLabel for="enable" styleClass="outputlabel"
									value="#{text['truleInstance.enable']}" />
								<h:panelGroup>
									<f:verbatim>
										<span class="notw"></span>
									</f:verbatim>
									<h:selectBooleanCheckbox id="enable" disabled="#{truleInstanceForm.truleInstance._checked_flag}"
										value="#{truleInstanceForm.truleInstance.enable}"
										readonly="false" tabindex="2">
									</h:selectBooleanCheckbox>
								</h:panelGroup>
								<h:inputHidden />
								<x:message for="enable" styleClass="fieldError" />
							</h:panelGrid>




							<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
								styleClass="sectionTable" columnClasses="colTitleView,colValueView">
								<h:outputLabel for="description" styleClass="outputlabel"
									value="#{text['truleInstance.description']}" />
								<h:panelGroup>
									<f:verbatim>
										<span class="notw"></span>
									</f:verbatim>
									<h:panelGroup>

										<f:verbatim><span class="mustw"></span></f:verbatim>
										<h:inputText id="description"
											value="#{truleInstanceForm.truleInstance.description}"
											style="width:'86%'" tabindex="3" maxlength="100"
											styleClass="edit_input">
										<s:commonsValidator type="required" arg="文字表述" client="true" server="false" />
										</h:inputText>
									</h:panelGroup>


								</h:panelGroup>
								<h:inputHidden />
								<x:message for="description" styleClass="fieldError" />
							</h:panelGrid>


						</h:panelGrid>


						<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
							styleClass="sectionTable" columnClasses="rowTable3,rowTable3"
							headerClass="mainHeader" footerClass="mainFooter">
							<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
								styleClass="sectionTable" columnClasses="colTitleView,colValueView">
								<h:outputLabel for="cycle" styleClass="outputlabel"
									value="#{text['truleInstance.cycle']}" />
								<h:panelGroup>
									<f:verbatim>
										<span class="notw"></span>
									</f:verbatim>
									<h:panelGroup>

										
					<h:selectOneMenu id="mccCode" value="#{truleInstanceForm.truleInstance.cycle}" style="width:'80%'">
	  					  <f:selectItems value="#{truleInstanceForm.cycles}"/>
					</h:selectOneMenu>
									</h:panelGroup>


								</h:panelGroup>
								<h:inputHidden />
								<x:message for="cycle" styleClass="fieldError" />
							</h:panelGrid>




							<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
								styleClass="sectionTable" columnClasses="colTitleView,colValueView">
								<h:outputLabel for="timeParam" styleClass="outputlabel"
									value="#{text['truleInstance.timeParam']}" />
								<h:panelGroup>
									<f:verbatim>
										<span class="notw"></span>
									</f:verbatim>
									<h:panelGroup>


										<h:inputText id="timeParam"
											value="#{truleInstanceForm.truleInstance.timeParam}"
											style="width:'86%'" tabindex="5" maxlength="20"
											styleClass="edit_input">

										</h:inputText>
									</h:panelGroup>


								</h:panelGroup>
								<h:inputHidden />
								<x:message for="timeParam" styleClass="fieldError" />
							</h:panelGrid>


						</h:panelGrid>
						
						
						
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
							styleClass="sectionTable" columnClasses="rowTable3,rowTable3"
							headerClass="mainHeader" footerClass="mainFooter">
						<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
							<h:outputLabel for="beginTraceDate" styleClass="outputlabel" value="回溯开始时间" />
				           <h:panelGroup>
					         <f:verbatim><span class="notw"></span></f:verbatim>
						        <h:panelGroup>
						           <be:inputDate id="beginTraceDate" value="#{truleInstanceForm.truleInstance.beginTraceDate}" style="width:86%" tabindex="11"   styleClass="edit_input" >
								     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
					               </be:inputDate>
			   			         </h:panelGroup>
			                               </h:panelGroup>	            <h:inputHidden />
						    <x:message for="beginTraceDate" styleClass="fieldError" />
						</h:panelGrid>
			
			
			
			
						<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
							<h:outputLabel for="endTraceDate" styleClass="outputlabel" value="回溯结束时间" />
				           <h:panelGroup>
					         <f:verbatim><span class="notw"></span></f:verbatim>
						        <h:panelGroup>
						           <be:inputDate id="endTraceDate" value="#{truleInstanceForm.truleInstance.endTraceDate}" style="width:86%" tabindex="11"   styleClass="edit_input" >
								     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
					               </be:inputDate>
			   			         </h:panelGroup>
			                               </h:panelGroup>	            <h:inputHidden />
						    <x:message for="endTraceDate" styleClass="fieldError" />
						</h:panelGrid>


			</h:panelGrid>

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
							styleClass="sectionTable" columnClasses="rowTable3,rowTable3"
							headerClass="mainHeader" footerClass="mainFooter" rendered="#{sessionScope._user_info.tuserInfo.organizeIdOfTorganizeInfo.id == '0'}">
							<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
								styleClass="sectionTable" columnClasses="colTitleView,colValueView">
								<h:outputLabel for="supportTrace" styleClass="outputlabel"
									value="#{text['truleInstance.supportTrace']}" />
								<h:panelGroup>
									<f:verbatim>
										<span class="notw"></span>
									</f:verbatim>
									<h:selectBooleanCheckbox id="supportTrace"
										value="#{truleInstanceForm.truleInstance.supportTrace}"
										readonly="false" tabindex="2">
									</h:selectBooleanCheckbox>
								</h:panelGroup>
								<h:inputHidden />
							</h:panelGrid>							
						<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" rendered="#{sessionScope._user_info.tuserInfo.organizeIdOfTorganizeInfo.id == '0'}">

					<h:outputLabel for="organization" styleClass="outputlabel" value="所属机构" rendered="#{sessionScope._user_info.tuserInfo.organizeIdOfTorganizeInfo.id == '0'}" />
						<h:panelGroup>
									<f:verbatim>
										<span class="notw"></span>
									</f:verbatim>
							<h:panelGroup>
								<h:selectOneMenu id="organization" value="#{truleInstanceForm.truleInstance.belongToInst}" style="width:'80%'" rendered="#{sessionScope._user_info.tuserInfo.organizeIdOfTorganizeInfo.id == '0'}">
					  					  <f:selectItem itemLabel="全部" itemValue="*" />
					  					  <f:selectItems value="#{extSelectItems.belongToInstForRuleItems}"/>
								</h:selectOneMenu>
							</h:panelGroup>
						</h:panelGroup>
								<h:inputHidden />
								<x:message for="organization" styleClass="fieldError" />
						</h:panelGrid>

			</h:panelGrid>

						<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
							styleClass="sectionTable" columnClasses="rowTable3,rowTable3"
							headerClass="mainHeader" footerClass="mainFooter">
							<h:outputText value="" />


							<h:outputText value="" />
						</h:panelGrid>

					</h:panelGrid>
				</h:panelGrid>
				<input type="hidden" name="tdClospan" value="2">



		





			</h:form>
			<s:validatorScript functionName="validateTruleInstanceForm" />
			<%@ include file="../calculator.jsp"%>
		</f:view>
</body>
