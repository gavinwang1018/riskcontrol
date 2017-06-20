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
<body onload="loadEpcInsProcs();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{epcInsProcList.queryFields}" />
	<t:saveState id="epcInsProcs" value="#{epcInsProcList.epcInsProcs}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['epcInsProc.epc_ins_proc_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="epcInsProcList">
       <a4j:jsFunction name="loadEpcInsProcs" action="#{epcInsProcList.initEpcInsProcs}" reRender="epcInsProcList,epcInsProcs" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="epcInsProcDataTable" var="epcInsProc"
				value="#{epcInsProcList.epcInsProcs}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{epcInsProcList.sortColumn}"
				sortAscending="#{epcInsProcList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{epcInsProcList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{epcInsProc.id}" />
					<h:inputHidden id="processDefId" value="#{epcInsProc.processDefId}" />
					<h:inputHidden id="processState" value="#{epcInsProc.processState}" />
					<h:inputHidden id="processStart" value="#{epcInsProc.processStart}" />
					<h:inputHidden id="processEnd" value="#{epcInsProc.processEnd}" />
					<h:inputHidden id="dataObject" value="#{epcInsProc.dataObject}" />
					<h:inputHidden id="dataObjectKey" value="#{epcInsProc.dataObjectKey}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsProc.processDefId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{epcInsProc.id}','#{epcInsProc.processDefId}')">					
						<h:outputText value="#{epcInsProc.processDefId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsProc.processState']}" />
					</f:facet>
				<be:outputText id="processState1" value="#{epcInsProc.processState}">
                   <f:selectItem itemLabel="#{text['epcInsProc.processState.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['epcInsProc.processState.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['epcInsProc.processState.3']}" itemValue="3"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsProc.processStart']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{epcInsProc.id}','#{epcInsProc.processDefId}')">					
						<h:outputText value="#{epcInsProc.processStart}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsProc.processEnd']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{epcInsProc.id}','#{epcInsProc.processDefId}')">					
						<h:outputText value="#{epcInsProc.processEnd}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsProc.dataObject']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{epcInsProc.id}','#{epcInsProc.processDefId}')">					
						<h:outputText value="#{epcInsProc.dataObject}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['epcInsProc.dataObjectKey']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{epcInsProc.id}','#{epcInsProc.processDefId}')">					
						<h:outputText value="#{epcInsProc.dataObjectKey}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>