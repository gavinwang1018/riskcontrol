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
<body onload="loadSysWorkflowInsTasks();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{sysWorkflowInsTaskList.queryFields}" />
	<t:saveState id="sysWorkflowInsTasks" value="#{sysWorkflowInsTaskList.sysWorkflowInsTasks}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['sysWorkflowInsTask.sys_workflow_ins_task_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="sysWorkflowInsTaskList">
       <a4j:jsFunction name="loadSysWorkflowInsTasks" action="#{sysWorkflowInsTaskList.initSysWorkflowInsTasks}" reRender="sysWorkflowInsTaskList,sysWorkflowInsTasks" oncomplete="checkLookupS()" />		
		<h:panelGrid  columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
					<f:verbatim><li></f:verbatim>	
					<h:commandLink onclick="window.close()">
					<f:verbatim><span class="linkClearImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.cancel']}" />
					</h:commandLink>	
					<f:verbatim></li></f:verbatim>	
			</h:panelGroup>
		 </h:panelGrid>
			<t:dataTable id="sysWorkflowInsTaskDataTable" var="sysWorkflowInsTask"
				value="#{sysWorkflowInsTaskList.sysWorkflowInsTasks}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{sysWorkflowInsTaskList.sortColumn}"
				sortAscending="#{sysWorkflowInsTaskList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{sysWorkflowInsTaskList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{sysWorkflowInsTask.id}" />
					<h:inputHidden id="operator" value="#{sysWorkflowInsTask.operator}" />
					<h:inputHidden id="taskOperator" value="#{sysWorkflowInsTask.taskOperator}" />
					<h:inputHidden id="instanceStart" value="#{sysWorkflowInsTask.instanceStart}" />
					<h:inputHidden id="instanceEnd" value="#{sysWorkflowInsTask.instanceEnd}" />
					<h:inputHidden id="instanceState" value="#{sysWorkflowInsTask.instanceState}" />
					<h:inputHidden id="receiptOrg" value="#{sysWorkflowInsTask.receiptOrg}" />
					<h:inputHidden id="receiptRole" value="#{sysWorkflowInsTask.receiptRole}" />
					<h:inputHidden id="receiptUser" value="#{sysWorkflowInsTask.receiptUser}" />
					<h:inputHidden id="processInsId" value="#{sysWorkflowInsTask.processInsId}" />
					<h:inputHidden id="taskTitle" value="#{sysWorkflowInsTask.taskTitle}" />
					<h:inputHidden id="stateDefId" value="#{sysWorkflowInsTask.stateDefId}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysWorkflowInsTask.operator']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysWorkflowInsTask.id}','#{sysWorkflowInsTask.id}')">					
						<h:outputText value="#{sysWorkflowInsTask.operator}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysWorkflowInsTask.taskOperator']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysWorkflowInsTask.id}','#{sysWorkflowInsTask.id}')">					
						<h:outputText value="#{sysWorkflowInsTask.taskOperator}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysWorkflowInsTask.instanceStart']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysWorkflowInsTask.id}','#{sysWorkflowInsTask.id}')">					
						<h:outputText value="#{sysWorkflowInsTask.instanceStart}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysWorkflowInsTask.instanceEnd']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysWorkflowInsTask.id}','#{sysWorkflowInsTask.id}')">					
						<h:outputText value="#{sysWorkflowInsTask.instanceEnd}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysWorkflowInsTask.instanceState']}" />
					</f:facet>
				<be:outputText id="instanceState1" value="#{sysWorkflowInsTask.instanceState}">
                   <f:selectItem itemLabel="#{text['sysWorkflowInsTask.instanceState.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['sysWorkflowInsTask.instanceState.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['sysWorkflowInsTask.instanceState.2']}" itemValue="2"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysWorkflowInsTask.receiptOrg']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysWorkflowInsTask.id}','#{sysWorkflowInsTask.id}')">					
						<h:outputText value="#{sysWorkflowInsTask.receiptOrg}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>