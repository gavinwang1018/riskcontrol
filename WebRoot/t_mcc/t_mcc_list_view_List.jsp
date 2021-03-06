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
	parent.historyIframe.addHistory('/t_mcc/t_mcc_list_view_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmccList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tmcc.t_mcc_list_view_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('tmccQuery:searchtab')"><h:outputText value="#{text['tmcc.tmccQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="tmccQuery" >
		<a4j:jsFunction name="queryTmccs" action="#{tmccList.query}" reRender="tmccPanel,tmccs" oncomplete="document.getElementById('tmccList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('tmccQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTmccs();return false;" >
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
           
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="bigmccCode" value="#{text['tmcc.bigmccCode']}  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="bigmccCode" value="#{tmccList.queryFields.bigmccCode}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItem itemLabel="#{text['tmcc.bigmccCode.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['tmcc.bigmccCode.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['tmcc.bigmccCode.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['tmcc.bigmccCode.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['tmcc.bigmccCode.5']}" itemValue="5"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>


             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="mccCode_like" value="#{text['tmcc.mccCode']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="mccCode_like" value="#{tmccList.queryFields.mccCode_like}" tabindex="2" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>



		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{tmccList.tmcc}" />
	<t:saveState value="#{tmccList.queryFields}" />
	<t:saveState id="tmccs" value="#{tmccList.tmccs}" />
	    <a4j:jsFunction name="deleteTmcc" action="#{tmccList.delete}"  reRender="tmccPanel,tmccs" oncomplete="rowIndexVarOfTmcc = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTmcc" action="#{tmccList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tmccList" >
<script>
		var rowIndexVarOfTmcc = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tmcc.t_mcc_list_view_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tmccPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tmccRowIndex" value="#{tmccList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tmccDataTable" var="tmcc"
				value="#{tmccList.tmccs}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{tmccList.sortColumn}"
				sortAscending="#{tmccList.ascending}"
				binding="#{tmccList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTmcc='#{rowIndexVar}';document.getElementById('tmccList:tmccRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="bigmccName" arrow="true">		                
							<h:outputText value="#{text['tmcc.bigmccName']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="bigmccName" value="#{tmcc.bigmccName}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="bigmccCode" arrow="true">		                
							<h:outputText value="#{text['tmcc.bigmccCode']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="bigmccCode" value="#{tmcc.bigmccCode}" />
				
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mccName" arrow="true">		                
							<h:outputText value="#{text['tmcc.mccName']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="mccName" value="#{tmcc.mccName}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mccCode" arrow="true">		                
							<h:outputText value="#{text['tmcc.mccCode']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="mccCode" value="#{tmcc.mccCode}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="midmccName" arrow="true">		                
							<h:outputText value="#{text['tmcc.midmccName']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="midmccName" value="#{tmcc.midmccName}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="midmccCode" arrow="true">		                
							<h:outputText value="#{text['tmcc.midmccCode']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="midmccCode" value="#{tmcc.midmccCode}" />
				</t:column>
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="tmcc_scroll_1" 
                    for="tmccDataTable"
                    rowsCountVar="rowsCount"
                    displayedRowsCountVar="displayedRowsCountVar"
                    firstRowIndexVar="firstRowIndex"
                    lastRowIndexVar="lastRowIndex"
                    pageCountVar="pageCount"
                    immediate="true"
                    pageIndexVar="pageIndex"
                    paginator="true"
                    paginatorMaxPages="9"

                    >
			<f:facet name="first" >
                <h:outputText value="#{text['page.first']}"/>
            </f:facet>
            <f:facet name="last">
                <h:outputText value="#{text['page.last']}"/>
            </f:facet>
            <f:facet name="previous">
                <h:outputText value="#{text['page.previous']}"/>
            </f:facet>
            <f:facet name="next">
                <h:outputText value="#{text['page.next']}"/>
            </f:facet>
            </t:dataScroller> 			
            <t:dataScroller id="tmcc_scroll_2" 
                    for="tmccDataTable"
                    rowsCountVar="rowsCount"
                    displayedRowsCountVar="displayedRowsCountVar"
                    firstRowIndexVar="firstRowIndex"
                    lastRowIndexVar="lastRowIndex"
                    pageCountVar="pageCount"
                    immediate="true"
                    pageIndexVar="pageIndex"
                    >
                <h:outputFormat value="#{text['pageFooter']}" styleClass="standard" >
                    <f:param value="#{rowsCount}" />
                    <f:param value="#{displayedRowsCountVar}" />
                    <f:param value="#{firstRowIndex}" />
                    <f:param value="#{lastRowIndex}" />
                    <f:param value="#{pageIndex}" />
                    <f:param value="#{pageCount==0?1:pageCount}" />
                </h:outputFormat>
             </t:dataScroller>           
            </h:panelGrid>

		</h:panelGrid>

	</h:form>
</f:view>
</body>