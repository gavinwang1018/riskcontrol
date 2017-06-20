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
<body onload="loadTriskcaseRulegroups();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseRulegroupList.queryFields}" />
	<t:saveState id="triskcaseRulegroups" value="#{triskcaseRulegroupList.triskcaseRulegroups}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcaseRulegroup.t_riskcase_rulegroup_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="triskcaseRulegroupList">
       <a4j:jsFunction name="loadTriskcaseRulegroups" action="#{triskcaseRulegroupList.initTriskcaseRulegroups}" reRender="triskcaseRulegroupList,triskcaseRulegroups" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="triskcaseRulegroupDataTable" var="triskcaseRulegroup"
				value="#{triskcaseRulegroupList.triskcaseRulegroups}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{triskcaseRulegroupList.sortColumn}"
				sortAscending="#{triskcaseRulegroupList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{triskcaseRulegroupList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{triskcaseRulegroup.id}" />
					<h:inputHidden id="riskCaseId" value="#{triskcaseRulegroup.riskCaseId}" />
					<h:inputHidden id="ruleGroupId" value="#{triskcaseRulegroup.ruleGroupId}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseRulegroup.riskCaseId']}" />
					</f:facet>
				<be:outputText id="riskCaseId1" value="#{triskcaseRulegroup.riskCaseId}">
                   <f:selectItem itemLabel="#{text['triskcaseRulegroup.riskCaseId.1']}" itemValue="1"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseRulegroup.ruleGroupId']}" />
					</f:facet>
				<be:outputText id="ruleGroupId1" value="#{triskcaseRulegroup.ruleGroupId}">
                   <f:selectItem itemLabel="#{text['triskcaseRulegroup.ruleGroupId.1']}" itemValue="1"/>
				</be:outputText>
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>