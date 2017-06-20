<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage"%>
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
    	
	
	<a4j:jsFunction name="loadTruleInstanceBigMccList" action="#{extTruleInstanceMccList.initParameterConfigView}" oncomplete="loadChild()" reRender="extTruleInstanceMccPanel,extTruleInstanceMccList" /> 	

    <a4j:jsFunction name="deleteInstanceMcc" action="#{truleInstanceMccList.deleteBuffer}"  reRender="truleInstanceMccPanel,truleInstanceMccs" oncomplete="rowIndexVarOfTruleInstanceMcc = -1" >
	</a4j:jsFunction>	
	
<script>
		var rowIndexVarOfTruleInstanceMcc = -1;
</script>			
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
								</ul>
							</f:verbatim>
						</h:panelGroup>
					</h:panelGrid>

					<h:panelGrid columns="1" cellspacing="0" cellpadding="0"
						styleClass="sectionTable" headerClass="sectionHeader"
						footerClass="mainFooter2">
						<f:facet name="header">
							<h:outputText
								value="子规则 #{truleInstanceForm.truleInstance.code}--同一商户终端的银行卡交易间隔时间小于预警时间的情形" />
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
									<h:selectBooleanCheckbox id="enable" disabled="true"
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

										<h:outputText id="description"
											value="#{truleInstanceForm.truleInstance.description}"
											style="width:'86%'">
										</h:outputText>
									</h:panelGroup>


								</h:panelGroup>
								<h:inputHidden />
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
					<be:outputText id="cycle" value="#{truleInstanceForm.truleInstance.cycle}" style="width:'86%'">
						<f:selectItem itemLabel="天" itemValue="1" />
						<f:selectItem itemLabel="周" itemValue="2" />
						<f:selectItem itemLabel="半月" itemValue="3" />
						<f:selectItem itemLabel="月" itemValue="4" />
					</be:outputText>
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


										<h:outputText id="timeParam"
											value="#{truleInstanceForm.truleInstance.timeParam}"
											style="width:'86%'">

										</h:outputText>
									</h:panelGroup>


								</h:panelGroup>
								<h:inputHidden />
								<x:message for="timeParam" styleClass="fieldError" />
							</h:panelGrid>


						</h:panelGrid>



			<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
							styleClass="sectionTable" columnClasses="rowTable3,rowTable3"
							headerClass="mainHeader" footerClass="mainFooter" rendered="#{sessionScope._user_info.tuserInfo.organizeIdOfTorganizeInfo.id == '0'}">
					
					<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" rendered="#{sessionScope._user_info.tuserInfo.organizeIdOfTorganizeInfo.id == '0'}">

							<h:outputLabel for="organization" styleClass="outputlabel" value="所属机构" rendered="#{sessionScope._user_info.tuserInfo.organizeIdOfTorganizeInfo.id == '0'}" />
						<h:panelGroup>
									<f:verbatim>
										<span class="notw"></span>
									</f:verbatim>
							<h:panelGroup>
								<h:selectOneMenu id="organization" disabled="true" value="#{truleInstanceForm.truleInstance.belongToInst}" style="width:'80%'" rendered="#{sessionScope._user_info.tuserInfo.organizeIdOfTorganizeInfo.id == '0'}">
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



	<%-- 五大类 start --%>
		<f:verbatim>
			<span class="notw"></span>
		</f:verbatim>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="参数设置" /></a></li>
    	    </ul>
    	</div>

	<h:panelGrid  id="extTruleInstanceMccPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>

    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="extTruleInstanceMccRowIndex" value="#{extTruleInstanceMccList.rowIndex}"></h:inputHidden>
			<t:dataTable id="extTruleInstanceMccDataTable" var="extTruleInstanceMcc"
				value="#{extTruleInstanceMccList.truleInstanceMccs}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{extTruleInstanceMccList.sortColumn}"
				sortAscending="#{extTruleInstanceMccList.ascending}"
				preserveDataModel="true"
				binding="#{extTruleInstanceMccList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
				rowOnClick="rowIndexVarOfExtTruleInstanceMcc='#{rowIndexVar}';document.getElementById('truleInstanceForm:extTruleInstanceMccRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				

								
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="param1" arrow="true">		                
							<h:outputText value="时间间隔 (秒)" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="param1" value="#{extTruleInstanceMcc.param1}" style="width:'30%'"/>
				</t:column>

				
			</t:dataTable>


		</h:panelGrid>



			</h:form>
			<s:validatorScript functionName="validateTruleInstanceForm" />
			<%@ include file="../calculator.jsp"%>
		</f:view>
</body>
