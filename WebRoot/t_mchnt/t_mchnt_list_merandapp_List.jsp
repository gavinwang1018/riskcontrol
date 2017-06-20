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
	parent.historyIframe.addHistory('/t_mchnt/t_mchnt_list_merandapp_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntAndAppList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tmchnt.t_mchnt_list_merandapp_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('tmchntQuery:searchtab')"><h:outputText value="#{text['tmchnt.tmchntQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="tmchntQuery" >
		<a4j:jsFunction name="queryTmchnts" action="#{tmchntAndAppList.queryMer}" reRender="tmchntPanel,tmchnts" oncomplete="document.getElementById('tmchntAndAppList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('tmchntQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTmchnts();return false;"  rendered="#{sessionScope._user_info.actionMap['action.50'] == 'true'}">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="subinst" value="#{text['tmchnt.subinst']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="subinst" value="#{tmchntAndAppList.queryFields.subinst}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="merchantno_like" value="#{text['tmchnt.merchantno']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="merchantno_like" value="#{tmchntAndAppList.queryFields.merchantno_like}" tabindex="1" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="name_like" value="#{text['tmchnt.name']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="name_like" value="#{tmchntAndAppList.queryFields.name_like}" tabindex="2" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

              <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="belongToInst" value="商户大类" />				
				<h:panelGroup>
				<h:selectOneMenu id="belongToInst" value="#{tmchntAndAppList.queryFields.big_mcc}">
                 <a4j:support event="onchange" action="#{tmchntAndAppList.getCertainMcc}" reRender="ruleGroup" />
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItems value="#{tmchntAndAppList.bigmccCodeNames}"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>

			  <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="ruleGroup" value="商户类型 " />				
				<h:panelGroup>
				<h:selectOneMenu id="ruleGroup" value="#{tmchntAndAppList.queryFields.merchantcategory}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItems value="#{tmchntAndAppList.tmccNamesOfTmccs}"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>


		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{tmchntAndAppList.tmchnt}" />
	<t:saveState value="#{tmchntAndAppList.queryFields}" />
	<t:saveState id="tmchnts" value="#{tmchntAndAppList.tmchnts}" />
	<a4j:jsFunction name="addTmchnt" action="#{tmchntAndAppList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tmchntAndAppList" >
<script>
		var rowIndexVarOfTmchnt = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tmchnt.t_mchnt_list_merandapp_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tmchntPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tmchntAndAppList.view}" onclick="if(rowIndexVarOfTmchnt == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_mchnt_list_merandapp.2c90834916f534a20116f6cdbbd600a7']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_mchnt/t_mchnt_form_detailview_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tmchntRowIndex" value="#{tmchntAndAppList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tmchntDataTable" var="tmchnt"
				value="#{tmchntAndAppList.tmchntApps}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{tmchntAndAppList.sortColumn}"
				sortAscending="#{tmchntAndAppList.ascending}"
				binding="#{tmchntAndAppList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTmchnt='#{rowIndexVar}';document.getElementById('tmchntAndAppList:tmchntRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="subinst" arrow="true">		                
							<h:outputText value="#{text['tmchnt.subinst']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="subinst" value="#{tmchnt.subinst}">
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="merchantno" arrow="true">		                
							<h:outputText value="#{text['tmchnt.merchantno']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="merchantno" value="#{tmchnt.merchantno}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="name" arrow="true">		                
							<h:outputText value="#{text['tmchnt.name']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="name" value="#{tmchnt.name}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="merchantcategory" arrow="true">		                
							<h:outputText value="#{text['tmchnt.merchantcategory']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="merchantcategory" value="#{tmchnt.merchantcategory}">
                   <f:selectItems value="#{tmchntAndAppList.tmccNamessOfTmccs}"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="state" arrow="true">		                
							<h:outputText value="#{text['tmchnt.state']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="state" value="#{tmchnt.state}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="accountno" arrow="true">		                
							<h:outputText value="结算帐号" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="accountno" value="#{tmchnt.settlementaccntno}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="approveddate" arrow="true">		                
							<h:outputText value="#{text['tmchnt.approveddate']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="approveddate" value="#{tmchnt.approveddate}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="withdrawinputdate" arrow="true">		                
							<h:outputText value="#{text['tmchnt.withdrawinputdate']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="withdrawinputdate" value="#{tmchnt.withdrawinputdate}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="tmchnt_scroll_1" 
                    for="tmchntDataTable"
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
            <t:dataScroller id="tmchnt_scroll_2" 
                    for="tmchntDataTable"
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