<%@ include file="/common/taglibs.jsp"%>

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage" %>
<%
String basePath = request.getContextPath();
javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().setLocale(cn.com.brilliance.begen.common.bundle.ResourceBundle.getLocale(request));

%>

<head>
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/config.css" />
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/right.css" />
<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>

<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/calculator.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/edit.js"></script>
<script>
var imagePath = "<%=basePath%>/images";
var scriptPath = "<%=basePath%>/scripts";
</script>
</head>
<body onload="loadTbaseargs();loadHidInfo();getDateObj()">
<center>
<input type="hidden" name="checkcontent" id="checkcontent">
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>

	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tbaseargForm.tbaseargPrimaryKey}" />
	<t:saveState value="#{tbaseargForm.tbasearg}" />
	<t:saveState value="#{tbaseargForm.queryFields}" />
	<t:saveState id="tbaseargs" value="#{tbaseargForm.tbaseargs}" />
	<a4j:jsFunction name="deleteTbasearg" action="#{tbaseargForm.delete}"  reRender="tbaseargPanel,tbaseargs" oncomplete="rowIndexVarOfTbasearg = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTbasearg" action="#{tbaseargForm.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	

	<h:form id="tbaseargForm" style="width:96%;">
		<a4j:jsFunction name="loadTbaseargs" action="#{tbaseargForm.initWarnLevel}"  reRender="tbaseargPanel,tbaseargs"/>
    	<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tbasearg.t_basearg_form_warnleveledit_EditForm.heading']}" /></a></li>
    	    </ul>
    	</div>
		<h:panelGrid id="tbaseargPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
		            <h:commandLink action="#{tbaseargForm.saveAlls}" tabindex="1" 
					  onclick=" if(!validateTbaseargForm(document.getElementById('tbaseargForm')))return; "  rendered="#{sessionScope._user_info.actionMap['action.31'] == 'true'}" >
						<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionedit.t_basearg_form_warnleveledit.2c908349171a86da01171a8cbb200015']}" />
					</h:commandLink>
<f:verbatim></li></f:verbatim>

	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
			</h:panelGrid>
			
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				
			</f:facet>	
			<h:inputHidden id="tbaseargRowIndex" value="#{tbaseargForm.rowIndex}"></h:inputHidden>
			<t:dataTable id="tbaseargDataTable" var="tbasearg"
				value="#{tbaseargForm.tbaseargs}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{tbaseargForm.sortColumn}"
				sortAscending="#{tbaseargForm.ascending}"
				binding="#{tbaseargForm.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" >				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="name" arrow="true">		                
							<h:outputText value="#{text['tbasearg.name']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="name" value="#{tbasearg.name}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="type" arrow="true">		                
							<h:outputText value="#{text['tbasearg.type']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="type" value="#{tbasearg.type}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="code" arrow="true">		                
							<h:outputText value="#{text['tbasearg.code']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="code" value="#{tbasearg.code}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="param1" arrow="true">		                
							<h:outputText value="#{text['tbasearg.downvalue']}" />
						</t:commandSortHeader>	
				</f:facet>
				
				<h:inputText id="param1" value="#{tbasearg.param1}" tabindex="2" styleClass="edit_input"/>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="param2" arrow="true">		                
							<h:outputText value="#{text['tbasearg.upvalue']}" />
						</t:commandSortHeader>	
				</f:facet>
				
				<h:inputText id="param2" value="#{tbasearg.param2}" tabindex="2" styleClass="edit_input"/>
				</t:column>
				
			</t:dataTable>


			
		</h:panelGrid>
		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	</h:form>
	<s:validatorScript functionName="validateTbaseargForm" />
<%@ include file="../calculator.jsp"%>
</f:view>
</body>