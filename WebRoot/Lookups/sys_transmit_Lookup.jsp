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
<body onload="loadSysTransmits();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{sysTransmitList.queryFields}" />
	<t:saveState id="sysTransmits" value="#{sysTransmitList.sysTransmits}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['sysTransmit.sys_transmit_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="sysTransmitList">
       <a4j:jsFunction name="loadSysTransmits" action="#{sysTransmitList.initSysTransmits}" reRender="sysTransmitList,sysTransmits" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="sysTransmitDataTable" var="sysTransmit"
				value="#{sysTransmitList.sysTransmits}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{sysTransmitList.sortColumn}"
				sortAscending="#{sysTransmitList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{sysTransmitList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{sysTransmit.id}" />
					<h:inputHidden id="title" value="#{sysTransmit.title}" />
					<h:inputHidden id="dataObject" value="#{sysTransmit.dataObject}" />
					<h:inputHidden id="dataObjectKey" value="#{sysTransmit.dataObjectKey}" />
					<h:inputHidden id="formLayout" value="#{sysTransmit.formLayout}" />
					<h:inputHidden id="startTime" value="#{sysTransmit.startTime}" />
					<h:inputHidden id="sender" value="#{sysTransmit.sender}" />
					<h:inputHidden id="endTime" value="#{sysTransmit.endTime}" />
					<h:inputHidden id="endFlag" value="#{sysTransmit.endFlag}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysTransmit.title']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysTransmit.id}','#{sysTransmit.id}')">					
						<h:outputText value="#{sysTransmit.title}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysTransmit.dataObject']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysTransmit.id}','#{sysTransmit.id}')">					
						<h:outputText value="#{sysTransmit.dataObject}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysTransmit.dataObjectKey']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysTransmit.id}','#{sysTransmit.id}')">					
						<h:outputText value="#{sysTransmit.dataObjectKey}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysTransmit.formLayout']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysTransmit.id}','#{sysTransmit.id}')">					
						<h:outputText value="#{sysTransmit.formLayout}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysTransmit.startTime']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysTransmit.id}','#{sysTransmit.id}')">					
						<h:outputText value="#{sysTransmit.startTime}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysTransmit.sender']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysTransmit.id}','#{sysTransmit.id}')">					
						<h:outputText value="#{sysTransmit.sender}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>