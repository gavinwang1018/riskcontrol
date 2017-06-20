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
	parent.historyIframe.addHistory('/t_keo_mchnt/t_keo_mchnt_list_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tkeoMchntList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tkeoMchnt.t_keo_mchnt_list_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('tkeoMchntQuery:searchtab')"><h:outputText value="#{text['tkeoMchnt.tkeoMchntQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="tkeoMchntQuery" >
		<a4j:jsFunction name="queryTkeoMchnts" action="#{tkeoMchntList.query}" reRender="tkeoMchntPanel,tkeoMchnts" oncomplete="document.getElementById('tkeoMchntList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('tkeoMchntQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTkeoMchnts();return false;" rendered="#{sessionScope._user_info.actionMap['action.50'] == 'true'}">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="belongToInst" value="#{text['tkeoMchnt.belongToInst']}  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="belongToInst" value="#{tkeoMchntList.queryFields.belongToInst}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="type" value="#{text['tkeoMchnt.type']}  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="type" value="#{tkeoMchntList.queryFields.type}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.5']}" itemValue="5"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.6']}" itemValue="6"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.7']}" itemValue="7"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.8']}" itemValue="8"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="mchntCd_like" value="#{text['tkeoMchnt.mchntCd']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="mchntCd_like" value="#{tkeoMchntList.queryFields.mchntCd_like}" tabindex="1" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="mchntName_like" value="#{text['tkeoMchnt.mchntName']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="mchntName_like" value="#{tkeoMchntList.queryFields.mchntName_like}" tabindex="2" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>







		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{tkeoMchntList.tkeoMchnt}" />
	<t:saveState value="#{tkeoMchntList.queryFields}" />
	    <a4j:jsFunction name="deleteTkeoMchnt" action="#{tkeoMchntList.delete}"  reRender="tkeoMchntPanel,tkeoMchnts" oncomplete="rowIndexVarOfTkeoMchnt = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTkeoMchnt" action="#{tkeoMchntList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tkeoMchntList" >
<script>
		var rowIndexVarOfTkeoMchnt = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tkeoMchnt.t_keo_mchnt_list_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tkeoMchntPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>


<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tkeoMchntList.edit}"  onclick="if(rowIndexVarOfTkeoMchnt == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.51'] == 'true'}">				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="编辑" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_keo_mchnt/t_keo_mchnt_form_reasonedit_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTkeoMchnt == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTkeoMchnt();}return false" rendered="#{sessionScope._user_info.actionMap['action.51'] == 'true'}">
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_keo_mchnt_list.2c908349169f7cda0116a48a75e30612']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

       
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tkeoMchntRowIndex" value="#{tkeoMchntList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tkeoMchntDataTable" var="tkeoMchnt"
				value="#{tkeoMchntList.tkeoMchnts}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{tkeoMchntList.sortColumn}"
				sortAscending="#{tkeoMchntList.ascending}"
				binding="#{tkeoMchntList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTkeoMchnt='#{rowIndexVar}';document.getElementById('tkeoMchntList:tkeoMchntRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="belongToInst" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.belongToInst']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="belongToInst" value="#{tkeoMchnt.belongToInst}">
                   <f:selectItems value="#{selectItems.torganizeInfoItems}"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="type" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.type']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="type" value="#{tkeoMchnt.type}">
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.5']}" itemValue="5"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.6']}" itemValue="6"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.7']}" itemValue="7"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.8']}" itemValue="8"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mchntCd" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.mchntCd']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="mchntCd" value="#{tkeoMchnt.mchntCd}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mchntName" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.mchntName']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="mchntName" value="#{tkeoMchnt.mchntName}" />
				</t:column>
	
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="settlementAccntNo" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.settlementAccntNo']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="settlementAccntNo" value="#{tkeoMchnt.settlementAccntNo}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="state" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.state']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="state" value="#{tkeoMchnt.state}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="approvedDate" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.approvedDate']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="approvedDate" value="#{tkeoMchnt.approvedDate}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="withdrawInputdate" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.withdrawInputdate']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="withdrawInputdate" value="#{tkeoMchnt.withdrawInputdate}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="reason" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.reason']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="reason" value="#{tkeoMchnt.reason}" />
				</t:column>
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="tkeoMchnt_scroll_1" 
                    for="tkeoMchntDataTable"
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
            <t:dataScroller id="tkeoMchnt_scroll_2" 
                    for="tkeoMchntDataTable"
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