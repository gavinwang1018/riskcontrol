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
<body onload="loadTriskcaseRecords();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseRecordList.queryFields}" />
	<t:saveState id="triskcaseRecords" value="#{triskcaseRecordList.triskcaseRecords}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcaseRecord.t_riskcase_record_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="triskcaseRecordList">
       <a4j:jsFunction name="loadTriskcaseRecords" action="#{triskcaseRecordList.initTriskcaseRecords}" reRender="triskcaseRecordList,triskcaseRecords" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="triskcaseRecordDataTable" var="triskcaseRecord"
				value="#{triskcaseRecordList.triskcaseRecords}" rowClasses="rowsClass,rowsClass2"
				rows="15"
				sortColumn="#{triskcaseRecordList.sortColumn}"
				sortAscending="#{triskcaseRecordList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{triskcaseRecordList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{triskcaseRecord.id}" />
					<h:inputHidden id="riskcaseId" value="#{triskcaseRecord.riskcaseId}" />
					<h:inputHidden id="investigationDate" value="#{triskcaseRecord.investigationDate}" />
					<h:inputHidden id="createDate" value="#{triskcaseRecord.createDate}" />
					<h:inputHidden id="investigationWay" value="#{triskcaseRecord.investigationWay}" />
					<h:inputHidden id="isPickFlow" value="#{triskcaseRecord.isPickFlow}" />
					<h:inputHidden id="pickCnt" value="#{triskcaseRecord.pickCnt}" />
					<h:inputHidden id="pickAmt" value="#{triskcaseRecord.pickAmt}" />
					<h:inputHidden id="pick180Cnt" value="#{triskcaseRecord.pick180Cnt}" />
					<h:inputHidden id="pick180Amt" value="#{triskcaseRecord.pick180Amt}" />
					<h:inputHidden id="pickStatus" value="#{triskcaseRecord.pickStatus}" />
					<h:inputHidden id="pickFlawCnt" value="#{triskcaseRecord.pickFlawCnt}" />
					<h:inputHidden id="pickEmptyCnt" value="#{triskcaseRecord.pickEmptyCnt}" />
					<h:inputHidden id="investigationResult" value="#{triskcaseRecord.investigationResult}" />
					<h:inputHidden id="riskLevel" value="#{triskcaseRecord.riskLevel}" />
					<h:inputHidden id="riskType" value="#{triskcaseRecord.riskType}" />
					<h:inputHidden id="processType" value="#{triskcaseRecord.processType}" />
					<h:inputHidden id="processFreezeAmt" value="#{triskcaseRecord.processFreezeAmt}" />
					<h:inputHidden id="processWithdrawCnt" value="#{triskcaseRecord.processWithdrawCnt}" />
					<h:inputHidden id="description" value="#{triskcaseRecord.description}" />
					<h:inputHidden id="caseno" value="#{triskcaseRecord.caseno}" />
					<h:inputHidden id="userId" value="#{triskcaseRecord.userId}" />
					<h:inputHidden id="submit" value="#{triskcaseRecord.submit}" />
					<h:inputHidden id="otherInvestigationWay" value="#{triskcaseRecord.otherInvestigationWay}" />
					<h:inputHidden id="otherRiskType" value="#{triskcaseRecord.otherRiskType}" />
					<h:inputHidden id="otherProcessType" value="#{triskcaseRecord.otherProcessType}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseRecord.caseno']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseRecord.id}','#{triskcaseRecord.id}')">					
						<h:outputText value="#{triskcaseRecord.caseno}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseRecord.investigationDate']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseRecord.id}','#{triskcaseRecord.id}')">					
						<h:outputText value="#{triskcaseRecord.investigationDate}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseRecord.createDate']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseRecord.id}','#{triskcaseRecord.id}')">					
						<h:outputText value="#{triskcaseRecord.createDate}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseRecord.investigationWay']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseRecord.id}','#{triskcaseRecord.id}')">					
						<h:outputText value="#{triskcaseRecord.investigationWay}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseRecord.isPickFlow']}" />
					</f:facet>
				<h:selectBooleanCheckbox id="isPickFlow1" value="#{triskcaseRecord.isPickFlow}"  disabled="true"/>
				</t:column>
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="scroll_1"
                    for="triskcaseRecordDataTable"
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
                    for="triskcaseRecordDataTable"
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