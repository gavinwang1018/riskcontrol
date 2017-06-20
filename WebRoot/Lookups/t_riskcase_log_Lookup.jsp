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
<body onload="loadTriskcaseLogs();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseLogList.queryFields}" />
	<t:saveState id="triskcaseLogs" value="#{triskcaseLogList.triskcaseLogs}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcaseLog.t_riskcase_log_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="triskcaseLogList">
       <a4j:jsFunction name="loadTriskcaseLogs" action="#{triskcaseLogList.initTriskcaseLogs}" reRender="triskcaseLogList,triskcaseLogs" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="triskcaseLogDataTable" var="triskcaseLog"
				value="#{triskcaseLogList.triskcaseLogs}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{triskcaseLogList.sortColumn}"
				sortAscending="#{triskcaseLogList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{triskcaseLogList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{triskcaseLog.id}" />
					<h:inputHidden id="userMame" value="#{triskcaseLog.userMame}" />
					<h:inputHidden id="operatorDatetime" value="#{triskcaseLog.operatorDatetime}" />
					<h:inputHidden id="ip" value="#{triskcaseLog.ip}" />
					<h:inputHidden id="content" value="#{triskcaseLog.content}" />
					<h:inputHidden id="loginName" value="#{triskcaseLog.loginName}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseLog.userMame']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseLog.id}','#{triskcaseLog.id}')">					
						<h:outputText value="#{triskcaseLog.userMame}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseLog.operatorDatetime']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseLog.id}','#{triskcaseLog.id}')">					
						<h:outputText value="#{triskcaseLog.operatorDatetime}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseLog.ip']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseLog.id}','#{triskcaseLog.id}')">					
						<h:outputText value="#{triskcaseLog.ip}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseLog.content']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseLog.id}','#{triskcaseLog.id}')">					
						<h:outputText value="#{triskcaseLog.content}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseLog.loginName']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseLog.id}','#{triskcaseLog.id}')">					
						<h:outputText value="#{triskcaseLog.loginName}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>