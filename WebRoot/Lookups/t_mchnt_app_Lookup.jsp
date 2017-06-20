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
<body onload="loadTmchntApps();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tmchntAppList.queryFields}" />
	<t:saveState id="tmchntApps" value="#{tmchntAppList.tmchntApps}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tmchntApp.t_mchnt_app_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="tmchntAppList">
       <a4j:jsFunction name="loadTmchntApps" action="#{tmchntAppList.initTmchntApps}" reRender="tmchntAppList,tmchntApps" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="tmchntAppDataTable" var="tmchntApp"
				value="#{tmchntAppList.tmchntApps}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{tmchntAppList.sortColumn}"
				sortAscending="#{tmchntAppList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{tmchntAppList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="mchntId" value="#{tmchntApp.mchntId}" />
					<h:inputHidden id="apptype" value="#{tmchntApp.apptype}" />
					<h:inputHidden id="main" value="#{tmchntApp.main}" />
					<h:inputHidden id="acquirer" value="#{tmchntApp.acquirer}" />
					<h:inputHidden id="networktransferinst" value="#{tmchntApp.networktransferinst}" />
					<h:inputHidden id="memberinstmerno" value="#{tmchntApp.memberinstmerno}" />
					<h:inputHidden id="depositbank" value="#{tmchntApp.depositbank}" />
					<h:inputHidden id="settlementaccntname" value="#{tmchntApp.settlementaccntname}" />
					<h:inputHidden id="settlementaccntno" value="#{tmchntApp.settlementaccntno}" />
					<h:inputHidden id="belongToInst" value="#{tmchntApp.belongToInst}" />
					<h:inputHidden id="id" value="#{tmchntApp.id}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchntApp.mchntId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmchntApp.id}','#{tmchntApp.id}')">					
						<h:outputText value="#{tmchntApp.mchntId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchntApp.apptype']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmchntApp.id}','#{tmchntApp.id}')">					
						<h:outputText value="#{tmchntApp.apptype}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchntApp.main']}" />
					</f:facet>
				<h:selectBooleanCheckbox id="main1" value="#{tmchntApp.main}"  disabled="true"/>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchntApp.acquirer']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmchntApp.id}','#{tmchntApp.id}')">					
						<h:outputText value="#{tmchntApp.acquirer}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchntApp.networktransferinst']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmchntApp.id}','#{tmchntApp.id}')">					
						<h:outputText value="#{tmchntApp.networktransferinst}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchntApp.memberinstmerno']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmchntApp.id}','#{tmchntApp.id}')">					
						<h:outputText value="#{tmchntApp.memberinstmerno}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>