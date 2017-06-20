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
<body onload="loadTkeoMchnts();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<br>
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('tkeoMchntQuery:searchtab')"><h:outputText value="#{text['tkeoMchnt.tkeoMchntList.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>

	<h:form id="tkeoMchntQuery">
		<a4j:jsFunction name="queryTkeoMchnts" action="#{tkeoMchntList.query}" reRender="tkeoMchntList" />   		
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
				<h:commandLink  onclick="queryTkeoMchnts();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		 
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent backColor"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="belongToInst" value="#{text['tkeoMchnt.belongToInst']}  #{text['query.equal']}" />

				<h:panelGroup>
				<h:selectOneMenu id="belongToInst" value="#{tkeoMchntList.queryFields.belongToInst}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItems value="#{selectItems.torganizeInfoItems}"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="type" value="#{text['tkeoMchnt.type']}  #{text['query.equal']}" />

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

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="mchntCd_like" value="#{text['tkeoMchnt.mchntCd']}  #{text['query.like']}" />

				<h:panelGroup>
			    <h:inputTextarea id="mchntCd_like" value="#{tkeoMchntList.queryFields.mchntCd_like}" rows="4"/>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="mchntName_like" value="#{text['tkeoMchnt.mchntName']}  #{text['query.like']}" />

				<h:panelGroup>
			    <h:inputTextarea id="mchntName_like" value="#{tkeoMchntList.queryFields.mchntName_like}" rows="4"/>
				</h:panelGroup>
			  </h:panelGrid>








		</h:panelGrid>			
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{tkeoMchntList.queryFields}" />
	<t:saveState id="tkeoMchnts" value="#{tkeoMchntList.tkeoMchnts}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tkeoMchnt.t_keo_mchnt_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="tkeoMchntList">
       <a4j:jsFunction name="loadTkeoMchnts" action="#{tkeoMchntList.initTkeoMchnts}" reRender="tkeoMchntList,tkeoMchnts" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="tkeoMchntDataTable" var="tkeoMchnt"
				value="#{tkeoMchntList.tkeoMchnts}" rowClasses="rowsClass,rowsClass2"
				rows="50"
				sortColumn="#{tkeoMchntList.sortColumn}"
				sortAscending="#{tkeoMchntList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{tkeoMchntList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{tkeoMchnt.id}" />
					<h:inputHidden id="mchntCd" value="#{tkeoMchnt.mchntCd}" />
					<h:inputHidden id="reason" value="#{tkeoMchnt.reason}" />
					<h:inputHidden id="mchntName" value="#{tkeoMchnt.mchntName}" />
					<h:inputHidden id="type" value="#{tkeoMchnt.type}" />
					<h:inputHidden id="belongToInst" value="#{tkeoMchnt.belongToInst}" />
					<h:inputHidden id="settlementAccntNo" value="#{tkeoMchnt.settlementAccntNo}" />
					<h:inputHidden id="state" value="#{tkeoMchnt.state}" />
					<h:inputHidden id="approvedDate" value="#{tkeoMchnt.approvedDate}" />
					<h:inputHidden id="withdrawInputdate" value="#{tkeoMchnt.withdrawInputdate}" />
					<h:inputHidden id="mchntId" value="#{tkeoMchnt.mchntId}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tkeoMchnt.belongToInst']}" />
					</f:facet>
				<be:outputText id="belongToInst1" value="#{tkeoMchnt.belongToInst}">
                   <f:selectItems value="#{selectItems.torganizeInfoItems}"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tkeoMchnt.type']}" />
					</f:facet>
				<be:outputText id="type1" value="#{tkeoMchnt.type}">
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
						<h:outputText value="#{text['tkeoMchnt.mchntCd']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tkeoMchnt.id}','#{tkeoMchnt.id}')">					
						<h:outputText value="#{tkeoMchnt.mchntCd}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tkeoMchnt.mchntName']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tkeoMchnt.id}','#{tkeoMchnt.id}')">					
						<h:outputText value="#{tkeoMchnt.mchntName}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tkeoMchnt.reason']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tkeoMchnt.id}','#{tkeoMchnt.id}')">					
						<h:outputText value="#{tkeoMchnt.reason}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tkeoMchnt.settlementAccntNo']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tkeoMchnt.id}','#{tkeoMchnt.id}')">					
						<h:outputText value="#{tkeoMchnt.settlementAccntNo}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tkeoMchnt.state']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tkeoMchnt.id}','#{tkeoMchnt.id}')">					
						<h:outputText value="#{tkeoMchnt.state}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tkeoMchnt.approvedDate']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tkeoMchnt.id}','#{tkeoMchnt.id}')">					
						<h:outputText value="#{tkeoMchnt.approvedDate}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tkeoMchnt.withdrawInputdate']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tkeoMchnt.id}','#{tkeoMchnt.id}')">					
						<h:outputText value="#{tkeoMchnt.withdrawInputdate}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tkeoMchnt.reason']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tkeoMchnt.id}','#{tkeoMchnt.id}')">					
						<h:outputText value="#{tkeoMchnt.reason}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="scroll_1"
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
            <t:dataScroller id="scroll_2"
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
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>