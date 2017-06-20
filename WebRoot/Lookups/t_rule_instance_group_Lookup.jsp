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
<body onload="loadTruleInstanceGroups();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<br>
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('truleInstanceGroupQuery:searchtab')"><h:outputText value="#{text['truleInstanceGroup.truleInstanceGroupList.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>

	<h:form id="truleInstanceGroupQuery">
		<a4j:jsFunction name="queryTruleInstanceGroups" action="#{truleInstanceGroupList.query}" reRender="truleInstanceGroupList" />   		
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
					
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('truleInstanceGroupQuery'));">
					<f:verbatim><span class="linkClearImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTruleInstanceGroups();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		 
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent backColor"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="ruleGroupId" value="#{text['truleInstanceGroup.ruleGroupId']}  #{text['query.equal']}" />

				<h:panelGroup>

	
	
					<h:inputText id="read_ruleGroupId" value="#{truleInstanceGroupList.queryFields.ruleGroupIdOfTruleGroup.id}" disabled="true" tabindex="1" styleClass="edit_input" /><h:inputHidden id="ruleGroupId" value="#{truleInstanceGroupList.queryFields.ruleGroupId}" /><f:verbatim><span class="lookup_button" onmousedown="event.cancelBubble=true;showdiv(this,'t_rule_group_Lookup.faces','truleInstanceGroupQuery','ruleGroupId','')"></span></f:verbatim>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="ruleInstanceId" value="#{text['truleInstanceGroup.ruleInstanceId']}  #{text['query.equal']}" />

				<h:panelGroup>

	
	
					<h:inputText id="read_ruleInstanceId" value="#{truleInstanceGroupList.queryFields.ruleInstanceIdOfTruleInstance.id}" disabled="true" tabindex="2" styleClass="edit_input" /><h:inputHidden id="ruleInstanceId" value="#{truleInstanceGroupList.queryFields.ruleInstanceId}" /><f:verbatim><span class="lookup_button" onmousedown="event.cancelBubble=true;showdiv(this,'t_rule_instance_Lookup.faces','truleInstanceGroupQuery','ruleInstanceId','')"></span></f:verbatim>
				</h:panelGroup>
			  </h:panelGrid>


		</h:panelGrid>			
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{truleInstanceGroupList.queryFields}" />
	<t:saveState id="truleInstanceGroups" value="#{truleInstanceGroupList.truleInstanceGroups}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['truleInstanceGroup.t_rule_instance_group_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="truleInstanceGroupList">
       <a4j:jsFunction name="loadTruleInstanceGroups" action="#{truleInstanceGroupList.initTruleInstanceGroups}" reRender="truleInstanceGroupList,truleInstanceGroups" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="truleInstanceGroupDataTable" var="truleInstanceGroup"
				value="#{truleInstanceGroupList.truleInstanceGroups}" rowClasses="rowsClass,rowsClass2"
				rows="50"
				sortColumn="#{truleInstanceGroupList.sortColumn}"
				sortAscending="#{truleInstanceGroupList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{truleInstanceGroupList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{truleInstanceGroup.id}" />
					<h:inputHidden id="ruleGroupId" value="#{truleInstanceGroup.ruleGroupId}" />
					<h:inputHidden id="ruleInstanceId" value="#{truleInstanceGroup.ruleInstanceId}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceGroup.ruleGroupId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceGroup.id}','#{truleInstanceGroup.id}')">					
						<h:outputText value="#{truleInstanceGroup.ruleGroupId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceGroup.ruleInstanceId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceGroup.id}','#{truleInstanceGroup.id}')">					
						<h:outputText value="#{truleInstanceGroup.ruleInstanceId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="scroll_1"
                    for="truleInstanceGroupDataTable"
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
            <t:dataScroller id="scroll_2"
                    for="truleInstanceGroupDataTable"
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
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>