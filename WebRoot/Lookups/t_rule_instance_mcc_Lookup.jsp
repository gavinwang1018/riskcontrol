<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%
String basePath = request.getContextPath();
javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().setLocale(cn.com.brilliance.begen.common.bundle.ResourceBundle.getLocale(request));
%>
<%@ include file="/common/taglibs.jsp"%>
<head>
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/config.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/styles/right.css" />

<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>

<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/calculator.js"></script>
</head>
<body onload="loadTruleInstanceMccs();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{truleInstanceMccList.queryFields}" />
	<t:saveState id="truleInstanceMccs" value="#{truleInstanceMccList.truleInstanceMccs}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['truleInstanceMcc.t_rule_instance_mcc_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="truleInstanceMccList">
       <a4j:jsFunction name="loadTruleInstanceMccs" action="#{truleInstanceMccList.initTruleInstanceMccs}" reRender="truleInstanceMccList,truleInstanceMccs" oncomplete="checkLookupS()" />		
		<h:panelGrid  columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
					<f:verbatim><li></f:verbatim>	
					<h:commandLink onclick="window.close()">
					<f:verbatim><span class="linkCancelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.cancel']}" />
					</h:commandLink>	
					<f:verbatim></li></f:verbatim>	
			</h:panelGroup>
		 </h:panelGrid>
			<t:dataTable id="truleInstanceMccDataTable" var="truleInstanceMcc"
				value="#{truleInstanceMccList.truleInstanceMccs}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{truleInstanceMccList.sortColumn}"
				sortAscending="#{truleInstanceMccList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{truleInstanceMccList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{truleInstanceMcc.id}" />
					<h:inputHidden id="ruleInstanceId" value="#{truleInstanceMcc.ruleInstanceId}" />
					<h:inputHidden id="param1" value="#{truleInstanceMcc.param1}" />
					<h:inputHidden id="param2" value="#{truleInstanceMcc.param2}" />
					<h:inputHidden id="param3" value="#{truleInstanceMcc.param3}" />
					<h:inputHidden id="param4" value="#{truleInstanceMcc.param4}" />
					<h:inputHidden id="mccCode" value="#{truleInstanceMcc.mccCode}" />
					<h:inputHidden id="riskThreshold" value="#{truleInstanceMcc.riskThreshold}" />
					<h:inputHidden id="bigmccCode" value="#{truleInstanceMcc.bigmccCode}" />
					<h:inputHidden id="mccId" value="#{truleInstanceMcc.mccId}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceMcc.ruleInstanceId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceMcc.id}','#{truleInstanceMcc.id}')">					
						<h:outputText value="#{truleInstanceMcc.ruleInstanceId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceMcc.param1']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceMcc.id}','#{truleInstanceMcc.id}')">					
						<h:outputText value="#{truleInstanceMcc.param1}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceMcc.param2']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceMcc.id}','#{truleInstanceMcc.id}')">					
						<h:outputText value="#{truleInstanceMcc.param2}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceMcc.param3']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceMcc.id}','#{truleInstanceMcc.id}')">					
						<h:outputText value="#{truleInstanceMcc.param3}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceMcc.param4']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceMcc.id}','#{truleInstanceMcc.id}')">					
						<h:outputText value="#{truleInstanceMcc.param4}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceMcc.mccCode']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceMcc.id}','#{truleInstanceMcc.id}')">					
						<h:outputText value="#{truleInstanceMcc.mccCode}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>