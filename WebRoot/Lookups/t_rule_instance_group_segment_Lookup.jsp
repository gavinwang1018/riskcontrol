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
<body onload="loadTruleInstanceGroupSegments();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<br>
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('truleInstanceGroupSegmentQuery:searchtab')"><h:outputText value="#{text['truleInstanceGroupSegment.truleInstanceGroupSegmentList.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>

	<h:form id="truleInstanceGroupSegmentQuery">
		<a4j:jsFunction name="queryTruleInstanceGroupSegments" action="#{truleInstanceGroupSegmentList.query}" reRender="truleInstanceGroupSegmentList" />   		
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
					
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('truleInstanceGroupSegmentQuery'));">
					<f:verbatim><span class="linkClearImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTruleInstanceGroupSegments();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		 
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent backColor"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="ruleInstanceGroupId" value="#{text['truleInstanceGroupSegment.ruleInstanceGroupId']}  #{text['query.equal']}" />

				<h:panelGroup>

	
	
					<h:inputText id="read_ruleInstanceGroupId" value="#{truleInstanceGroupSegmentList.queryFields.ruleInstanceGroupIdOfTruleInstanceGroup.id}" disabled="true" tabindex="1" styleClass="edit_input" /><h:inputHidden id="ruleInstanceGroupId" value="#{truleInstanceGroupSegmentList.queryFields.ruleInstanceGroupId}" /><f:verbatim><span class="lookup_button" onmousedown="event.cancelBubble=true;showdiv(this,'t_rule_instance_group_Lookup.faces','truleInstanceGroupSegmentQuery','ruleInstanceGroupId','')"></span></f:verbatim>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="ruleInstanceId" value="#{text['truleInstanceGroupSegment.ruleInstanceId']}  #{text['query.equal']}" />

				<h:panelGroup>

	
	
					<h:inputText id="read_ruleInstanceId" value="#{truleInstanceGroupSegmentList.queryFields.ruleInstanceIdOfTruleInstance.id}" disabled="true" tabindex="2" styleClass="edit_input" /><h:inputHidden id="ruleInstanceId" value="#{truleInstanceGroupSegmentList.queryFields.ruleInstanceId}" /><f:verbatim><span class="lookup_button" onmousedown="event.cancelBubble=true;showdiv(this,'t_rule_instance_Lookup.faces','truleInstanceGroupSegmentQuery','ruleInstanceId','')"></span></f:verbatim>
				</h:panelGroup>
			  </h:panelGrid>





		</h:panelGrid>			
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{truleInstanceGroupSegmentList.queryFields}" />
	<t:saveState id="truleInstanceGroupSegments" value="#{truleInstanceGroupSegmentList.truleInstanceGroupSegments}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['truleInstanceGroupSegment.t_rule_instance_group_segment_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="truleInstanceGroupSegmentList">
       <a4j:jsFunction name="loadTruleInstanceGroupSegments" action="#{truleInstanceGroupSegmentList.initTruleInstanceGroupSegments}" reRender="truleInstanceGroupSegmentList,truleInstanceGroupSegments" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="truleInstanceGroupSegmentDataTable" var="truleInstanceGroupSegment"
				value="#{truleInstanceGroupSegmentList.truleInstanceGroupSegments}" rowClasses="rowsClass,rowsClass2"
				rows="50"
				sortColumn="#{truleInstanceGroupSegmentList.sortColumn}"
				sortAscending="#{truleInstanceGroupSegmentList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{truleInstanceGroupSegmentList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{truleInstanceGroupSegment.id}" />
					<h:inputHidden id="propertion" value="#{truleInstanceGroupSegment.propertion}" />
					<h:inputHidden id="ruleInstanceGroupId" value="#{truleInstanceGroupSegment.ruleInstanceGroupId}" />
					<h:inputHidden id="begin" value="#{truleInstanceGroupSegment.begin}" />
					<h:inputHidden id="end" value="#{truleInstanceGroupSegment.end}" />
					<h:inputHidden id="ruleInstanceId" value="#{truleInstanceGroupSegment.ruleInstanceId}" />
					<h:inputHidden id="value" value="#{truleInstanceGroupSegment.value}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceGroupSegment.ruleInstanceGroupId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceGroupSegment.id}','#{truleInstanceGroupSegment.id}')">					
						<h:outputText value="#{truleInstanceGroupSegment.ruleInstanceGroupId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceGroupSegment.ruleInstanceId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceGroupSegment.id}','#{truleInstanceGroupSegment.id}')">					
						<h:outputText value="#{truleInstanceGroupSegment.ruleInstanceId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceGroupSegment.propertion']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceGroupSegment.id}','#{truleInstanceGroupSegment.id}')">					
						<h:outputText value="#{truleInstanceGroupSegment.propertion}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceGroupSegment.begin']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceGroupSegment.id}','#{truleInstanceGroupSegment.id}')">					
						<h:outputText value="#{truleInstanceGroupSegment.begin}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['truleInstanceGroupSegment.end']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{truleInstanceGroupSegment.id}','#{truleInstanceGroupSegment.id}')">					
						<h:outputText value="#{truleInstanceGroupSegment.end}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="scroll_1"
                    for="truleInstanceGroupSegmentDataTable"
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
                    for="truleInstanceGroupSegmentDataTable"
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