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
<body onload="loadTmccs();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tmccList.queryFields}" />
	<t:saveState id="tmccs" value="#{tmccList.tmccs}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tmcc.t_mcc_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="tmccList">
       <a4j:jsFunction name="loadTmccs" action="#{tmccList.initTmccs}" reRender="tmccList,tmccs" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="tmccDataTable" var="tmcc"
				value="#{tmccList.tmccs}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{tmccList.sortColumn}"
				sortAscending="#{tmccList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{tmccList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{tmcc.id}" />
					<h:inputHidden id="mccName" value="#{tmcc.mccName}" />
					<h:inputHidden id="mccCode" value="#{tmcc.mccCode}" />
					<h:inputHidden id="bigmccName" value="#{tmcc.bigmccName}" />
					<h:inputHidden id="bigmccCode" value="#{tmcc.bigmccCode}" />
					<h:inputHidden id="midmccName" value="#{tmcc.midmccName}" />
					<h:inputHidden id="midmccCode" value="#{tmcc.midmccCode}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmcc.mccName']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmcc.id}','#{tmcc.id}')">					
						<h:outputText value="#{tmcc.mccName}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmcc.mccCode']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmcc.id}','#{tmcc.id}')">					
						<h:outputText value="#{tmcc.mccCode}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmcc.bigmccName']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmcc.id}','#{tmcc.id}')">					
						<h:outputText value="#{tmcc.bigmccName}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmcc.bigmccCode']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmcc.id}','#{tmcc.id}')">					
						<h:outputText value="#{tmcc.bigmccCode}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmcc.midmccName']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmcc.id}','#{tmcc.id}')">					
						<h:outputText value="#{tmcc.midmccName}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmcc.midmccCode']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmcc.id}','#{tmcc.id}')">					
						<h:outputText value="#{tmcc.midmccCode}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>