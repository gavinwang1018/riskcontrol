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
<body onload="loadSysLoginfos();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{sysLoginfoList.queryFields}" />
	<t:saveState id="sysLoginfos" value="#{sysLoginfoList.sysLoginfos}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['sysLoginfo.sys_loginfo_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="sysLoginfoList">
       <a4j:jsFunction name="loadSysLoginfos" action="#{sysLoginfoList.initSysLoginfos}" reRender="sysLoginfoList,sysLoginfos" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="sysLoginfoDataTable" var="sysLoginfo"
				value="#{sysLoginfoList.sysLoginfos}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{sysLoginfoList.sortColumn}"
				sortAscending="#{sysLoginfoList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{sysLoginfoList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{sysLoginfo.id}" />
					<h:inputHidden id="operator" value="#{sysLoginfo.operator}" />
					<h:inputHidden id="operationType" value="#{sysLoginfo.operationType}" />
					<h:inputHidden id="operationTitle" value="#{sysLoginfo.operationTitle}" />
					<h:inputHidden id="operationTime" value="#{sysLoginfo.operationTime}" />
					<h:inputHidden id="clientIp" value="#{sysLoginfo.clientIp}" />
					<h:inputHidden id="terminalType" value="#{sysLoginfo.terminalType}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysLoginfo.operator']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysLoginfo.id}','#{sysLoginfo.id}')">					
						<h:outputText value="#{sysLoginfo.operator}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysLoginfo.operationType']}" />
					</f:facet>
				<be:outputText id="operationType1" value="#{sysLoginfo.operationType}">
                   <f:selectItem itemLabel="#{text['sysLoginfo.operationType.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['sysLoginfo.operationType.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['sysLoginfo.operationType.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['sysLoginfo.operationType.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['sysLoginfo.operationType.5']}" itemValue="5"/>
                   <f:selectItem itemLabel="#{text['sysLoginfo.operationType.6']}" itemValue="6"/>
                   <f:selectItem itemLabel="#{text['sysLoginfo.operationType.7']}" itemValue="7"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysLoginfo.operationTitle']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysLoginfo.id}','#{sysLoginfo.id}')">					
						<h:outputText value="#{sysLoginfo.operationTitle}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysLoginfo.operationTime']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysLoginfo.id}','#{sysLoginfo.id}')">					
						<h:outputText value="#{sysLoginfo.operationTime}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysLoginfo.clientIp']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysLoginfo.id}','#{sysLoginfo.id}')">					
						<h:outputText value="#{sysLoginfo.clientIp}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysLoginfo.terminalType']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysLoginfo.id}','#{sysLoginfo.id}')">					
						<h:outputText value="#{sysLoginfo.terminalType}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>