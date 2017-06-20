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
<body onload="loadTtransInfos();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{ttransInfoList.queryFields}" />
	<t:saveState id="ttransInfos" value="#{ttransInfoList.ttransInfos}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['ttransInfo.t_trans_info_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="ttransInfoList">
       <a4j:jsFunction name="loadTtransInfos" action="#{ttransInfoList.initTtransInfos}" reRender="ttransInfoList,ttransInfos" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="ttransInfoDataTable" var="ttransInfo"
				value="#{ttransInfoList.ttransInfos}" rowClasses="rowsClass,rowsClass2"
				rows="50"
				sortColumn="#{ttransInfoList.sortColumn}"
				sortAscending="#{ttransInfoList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{ttransInfoList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{ttransInfo.id}" />
					<h:inputHidden id="settleDt" value="#{ttransInfo.settleDt}" />
					<h:inputHidden id="sysTraNo" value="#{ttransInfo.sysTraNo}" />
					<h:inputHidden id="respCd4" value="#{ttransInfo.respCd4}" />
					<h:inputHidden id="transId" value="#{ttransInfo.transId}" />
					<h:inputHidden id="settleIn" value="#{ttransInfo.settleIn}" />
					<h:inputHidden id="transAt" value="#{ttransInfo.transAt}" />
					<h:inputHidden id="msgTp" value="#{ttransInfo.msgTp}" />
					<h:inputHidden id="locTransDtTm" value="#{ttransInfo.locTransDtTm}" />
					<h:inputHidden id="mchntTp" value="#{ttransInfo.mchntTp}" />
					<h:inputHidden id="retriRefNo" value="#{ttransInfo.retriRefNo}" />
					<h:inputHidden id="priAcctNo" value="#{ttransInfo.priAcctNo}" />
					<h:inputHidden id="bin" value="#{ttransInfo.bin}" />
					<h:inputHidden id="cardAttr" value="#{ttransInfo.cardAttr}" />
					<h:inputHidden id="cardMedia" value="#{ttransInfo.cardMedia}" />
					<h:inputHidden id="termId" value="#{ttransInfo.termId}" />
					<h:inputHidden id="mchntCd" value="#{ttransInfo.mchntCd}" />
					<h:inputHidden id="cardAccptrNmLoc" value="#{ttransInfo.cardAccptrNmLoc}" />
					<h:inputHidden id="acqInsIdCd" value="#{ttransInfo.acqInsIdCd}" />
					<h:inputHidden id="fwdInsIdCd" value="#{ttransInfo.fwdInsIdCd}" />
					<h:inputHidden id="rcvInsIdCd" value="#{ttransInfo.rcvInsIdCd}" />
					<h:inputHidden id="issInsIdCd" value="#{ttransInfo.issInsIdCd}" />
					<h:inputHidden id="origSysTraNo" value="#{ttransInfo.origSysTraNo}" />
					<h:inputHidden id="origTransmsnDtTm" value="#{ttransInfo.origTransmsnDtTm}" />
					<h:inputHidden id="rsnCd" value="#{ttransInfo.rsnCd}" />
					<h:inputHidden id="authDt" value="#{ttransInfo.authDt}" />
					<h:inputHidden id="authIdRespCd" value="#{ttransInfo.authIdRespCd}" />
					<h:inputHidden id="posEntryMdCd" value="#{ttransInfo.posEntryMdCd}" />
					<h:inputHidden id="posCondCd" value="#{ttransInfo.posCondCd}" />
					<h:inputHidden id="procCd" value="#{ttransInfo.procCd}" />
					<h:inputHidden id="settleYm" value="#{ttransInfo.settleYm}" />
					<h:inputHidden id="fwdInsIdOriginal" value="#{ttransInfo.fwdInsIdOriginal}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['ttransInfo.settleDt']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{ttransInfo.id}','#{ttransInfo.id}')">					
						<h:outputText value="#{ttransInfo.settleDt}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['ttransInfo.sysTraNo']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{ttransInfo.id}','#{ttransInfo.id}')">					
						<h:outputText value="#{ttransInfo.sysTraNo}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['ttransInfo.respCd4']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{ttransInfo.id}','#{ttransInfo.id}')">					
						<h:outputText value="#{ttransInfo.respCd4}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['ttransInfo.transId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{ttransInfo.id}','#{ttransInfo.id}')">					
						<h:outputText value="#{ttransInfo.transId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['ttransInfo.settleIn']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{ttransInfo.id}','#{ttransInfo.id}')">					
						<h:outputText value="#{ttransInfo.settleIn}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['ttransInfo.transAt']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{ttransInfo.id}','#{ttransInfo.id}')">					
						<h:outputText value="#{ttransInfo.transAt}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="scroll_1"
                    for="ttransInfoDataTable"
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
                    for="ttransInfoDataTable"
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