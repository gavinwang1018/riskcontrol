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
<body onload="loadSysTransmitDetails();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{sysTransmitDetailList.queryFields}" />
	<t:saveState id="sysTransmitDetails" value="#{sysTransmitDetailList.sysTransmitDetails}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['sysTransmitDetail.sys_transmit_detail_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="sysTransmitDetailList">
       <a4j:jsFunction name="loadSysTransmitDetails" action="#{sysTransmitDetailList.initSysTransmitDetails}" reRender="sysTransmitDetailList,sysTransmitDetails" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="sysTransmitDetailDataTable" var="sysTransmitDetail"
				value="#{sysTransmitDetailList.sysTransmitDetails}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{sysTransmitDetailList.sortColumn}"
				sortAscending="#{sysTransmitDetailList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{sysTransmitDetailList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{sysTransmitDetail.id}" />
					<h:inputHidden id="transmitId" value="#{sysTransmitDetail.transmitId}" />
					<h:inputHidden id="readFlag" value="#{sysTransmitDetail.readFlag}" />
					<h:inputHidden id="advice" value="#{sysTransmitDetail.advice}" />
					<h:inputHidden id="transmitTime" value="#{sysTransmitDetail.transmitTime}" />
					<h:inputHidden id="receiver" value="#{sysTransmitDetail.receiver}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysTransmitDetail.transmitId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysTransmitDetail.id}','#{sysTransmitDetail.id}')">					
						<h:outputText value="#{sysTransmitDetail.transmitId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysTransmitDetail.readFlag']}" />
					</f:facet>
				<h:selectBooleanCheckbox id="readFlag1" value="#{sysTransmitDetail.readFlag}"  disabled="true"/>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysTransmitDetail.advice']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysTransmitDetail.id}','#{sysTransmitDetail.id}')">					
						<h:outputText value="#{sysTransmitDetail.advice}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysTransmitDetail.transmitTime']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysTransmitDetail.id}','#{sysTransmitDetail.id}')">					
						<h:outputText value="#{sysTransmitDetail.transmitTime}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['sysTransmitDetail.receiver']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysTransmitDetail.id}','#{sysTransmitDetail.id}')">					
						<h:outputText value="#{sysTransmitDetail.receiver}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>