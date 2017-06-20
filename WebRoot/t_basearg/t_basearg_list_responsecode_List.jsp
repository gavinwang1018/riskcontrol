<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="cn.com.brilliance.begen.common.BeGenHistory"%>
<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage" %>
<%
String basePath = request.getContextPath();
javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().setLocale(cn.com.brilliance.begen.common.bundle.ResourceBundle.getLocale(request));

%>
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
<script language=javascript src="<%=basePath%>/scripts/getreset.js"></script>
</head>
<body onload="loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_basearg/t_basearg_list_responsecode_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tbaseargList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tbasearg.t_basearg_list_responsecode_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('tbaseargQuery:searchtab')"><h:outputText value="响应码查询" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="tbaseargQuery" >
		<a4j:jsFunction name="queryTbaseargs" action="#{tbaseargList.queryResponseCode}" reRender="tbaseargPanel,tbaseargs" oncomplete="document.getElementById('tbaseargList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('tbaseargQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTbaseargs();return false;" >
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="name_like" value="#{text['tbasearg.name']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="name_like" value="#{tbaseargList.queryFields.name_like}" tabindex="1" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

			<h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="code" value="#{text['tbasearg.code']}  #{text['query.equal']}" />				
				<h:panelGroup>
			    <h:inputText id="code" value="#{tbaseargList.queryFields.code}" tabindex="2" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>



		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{tbaseargList.tbasearg}" />
	<t:saveState value="#{tbaseargList.queryFields}" />
	<t:saveState id="tbaseargs" value="#{tbaseargList.tbaseargs}" />
	<a4j:jsFunction name="addTbasearg" action="#{tbaseargList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tbaseargList" >
<script>
		var rowIndexVarOfTbasearg = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tbasearg.t_basearg_list_responsecode_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tbaseargPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
       
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tbaseargRowIndex" value="#{tbaseargList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tbaseargDataTable" var="tbasearg"
				value="#{tbaseargList.tbaseargs}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{tbaseargList.sortColumn}"
				sortAscending="#{tbaseargList.ascending}"
				binding="#{tbaseargList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTbasearg='#{rowIndexVar}';document.getElementById('tbaseargList:tbaseargRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
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
				
				<be:outputText id="code" value="#{tbasearg.code}">
                   <f:selectItem itemLabel="响应码" itemValue="RespCode"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="param1" arrow="true">		                
							<h:outputText value="#{text['tbasearg.param1']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="param1" value="#{tbasearg.param1}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="param2" arrow="true">		                
							<h:outputText value="#{text['tbasearg.param2']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="param2" value="#{tbasearg.param2}" />
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>