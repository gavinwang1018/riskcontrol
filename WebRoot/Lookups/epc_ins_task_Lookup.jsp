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
<body onload="loadEpcInsTasks();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{epcInsTaskList.queryFields}" />
	<t:saveState id="epcInsTasks" value="#{epcInsTaskList.epcInsTasks}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['epcInsTask.epc_ins_task_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="epcInsTaskList">
       <a4j:jsFunction name="loadEpcInsTasks" action="#{epcInsTaskList.initEpcInsTasks}" reRender="epcInsTaskList,epcInsTasks" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="epcInsTaskDataTable" var="epcInsTask"
				value="#{epcInsTaskList.epcInsTasks}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{epcInsTaskList.sortColumn}"
				sortAscending="#{epcInsTaskList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{epcInsTaskList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{epcInsTask.id}" />
					<h:inputHidden id="processInsId" value="#{epcInsTask.processInsId}" />
					<h:inputHidden id="stateDefId" value="#{epcInsTask.stateDefId}" />
					<h:inputHidden id="taskTitle" value="#{epcInsTask.taskTitle}" />
					<h:inputHidden id="operator" value="#{epcInsTask.operator}" />
					<h:inputHidden id="taskOperator" value="#{epcInsTask.taskOperator}" />
					<h:inputHidden id="instanceStart" value="#{epcInsTask.instanceStart}" />
					<h:inputHidden id="instanceEnd" value="#{epcInsTask.instanceEnd}" />
					<h:inputHidden id="url" value="#{epcInsTask.url}" />
					<h:inputHidden id="instanceState" value="#{epcInsTask.instanceState}" />
					<h:inputHidden id="receiptOrg" value="#{epcInsTask.receiptOrg}" />
					<h:inputHidden id="receiptRole" value="#{epcInsTask.receiptRole}" />
					<h:inputHidden id="receiptUser" value="#{epcInsTask.receiptUser}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsTask.processInsId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{epcInsTask.id}','#{epcInsTask.processInsId}')">					
						<h:outputText value="#{epcInsTask.processInsId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsTask.stateDefId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{epcInsTask.id}','#{epcInsTask.processInsId}')">					
						<h:outputText value="#{epcInsTask.stateDefId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsTask.taskTitle']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{epcInsTask.id}','#{epcInsTask.processInsId}')">					
						<h:outputText value="#{epcInsTask.taskTitle}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsTask.operator']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{epcInsTask.id}','#{epcInsTask.processInsId}')">					
						<h:outputText value="#{epcInsTask.operator}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsTask.taskOperator']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{epcInsTask.id}','#{epcInsTask.processInsId}')">					
						<h:outputText value="#{epcInsTask.taskOperator}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsTask.instanceStart']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{epcInsTask.id}','#{epcInsTask.processInsId}')">					
						<h:outputText value="#{epcInsTask.instanceStart}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>