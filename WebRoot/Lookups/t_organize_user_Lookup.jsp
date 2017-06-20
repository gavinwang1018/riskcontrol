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
<body onload="loadTorganizeUsers();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{torganizeUserList.queryFields}" />
	<t:saveState id="torganizeUsers" value="#{torganizeUserList.torganizeUsers}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['torganizeUser.t_organize_user_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="torganizeUserList">
       <a4j:jsFunction name="loadTorganizeUsers" action="#{torganizeUserList.initTorganizeUsers}" reRender="torganizeUserList,torganizeUsers" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="torganizeUserDataTable" var="torganizeUser"
				value="#{torganizeUserList.torganizeUsers}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{torganizeUserList.sortColumn}"
				sortAscending="#{torganizeUserList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{torganizeUserList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{torganizeUser.id}" />
					<h:inputHidden id="organizeId" value="#{torganizeUser.organizeId}" />
					<h:inputHidden id="userId" value="#{torganizeUser.userId}" />
					<h:inputHidden id="type" value="#{torganizeUser.type}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['torganizeUser.organizeId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{torganizeUser.id}','#{torganizeUser.id}')">					
						<h:outputText value="#{torganizeUser.organizeId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['torganizeUser.userId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{torganizeUser.id}','#{torganizeUser.id}')">					
						<h:outputText value="#{torganizeUser.userId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['torganizeUser.type']}" />
					</f:facet>
				<h:selectBooleanCheckbox id="type1" value="#{torganizeUser.type}"  disabled="true"/>
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>