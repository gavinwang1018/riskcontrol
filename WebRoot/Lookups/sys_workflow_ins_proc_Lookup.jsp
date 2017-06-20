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
<body onload="loadSysWorkflowInsProcs();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{sysWorkflowInsProcList.queryFields}" />
	<t:saveState id="sysWorkflowInsProcs" value="#{sysWorkflowInsProcList.sysWorkflowInsProcs}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['sysWorkflowInsProc.sys_workflow_ins_proc_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="sysWorkflowInsProcList">
       <a4j:jsFunction name="loadSysWorkflowInsProcs" action="#{sysWorkflowInsProcList.initSysWorkflowInsProcs}" reRender="sysWorkflowInsProcList,sysWorkflowInsProcs" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="sysWorkflowInsProcDataTable" var="sysWorkflowInsProc"
				value="#{sysWorkflowInsProcList.sysWorkflowInsProcs}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{sysWorkflowInsProcList.sortColumn}"
				sortAscending="#{sysWorkflowInsProcList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{sysWorkflowInsProcList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{sysWorkflowInsProc.id}" />
					<h:inputHidden id="processDefId" value="#{sysWorkflowInsProc.processDefId}" />
					<h:inputHidden id="processState" value="#{sysWorkflowInsProc.processState}" />
					<h:inputHidden id="processStart" value="#{sysWorkflowInsProc.processStart}" />
					<h:inputHidden id="processEnd" value="#{sysWorkflowInsProc.processEnd}" />
					<h:inputHidden id="dataObjectKey" value="#{sysWorkflowInsProc.dataObjectKey}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysWorkflowInsProc.processDefId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysWorkflowInsProc.id}','#{sysWorkflowInsProc.id}')">					
						<h:outputText value="#{sysWorkflowInsProc.processDefId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysWorkflowInsProc.processState']}" />
					</f:facet>
				<be:outputText id="processState1" value="#{sysWorkflowInsProc.processState}">
                   <f:selectItem itemLabel="#{text['sysWorkflowInsProc.processState.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['sysWorkflowInsProc.processState.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['sysWorkflowInsProc.processState.2']}" itemValue="2"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysWorkflowInsProc.processStart']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysWorkflowInsProc.id}','#{sysWorkflowInsProc.id}')">					
						<h:outputText value="#{sysWorkflowInsProc.processStart}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysWorkflowInsProc.processEnd']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysWorkflowInsProc.id}','#{sysWorkflowInsProc.id}')">					
						<h:outputText value="#{sysWorkflowInsProc.processEnd}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysWorkflowInsProc.dataObjectKey']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysWorkflowInsProc.id}','#{sysWorkflowInsProc.id}')">					
						<h:outputText value="#{sysWorkflowInsProc.dataObjectKey}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>