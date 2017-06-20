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
<body onload="loadTuserInfos();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<br>
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('tuserInfoQuery:searchtab')"><h:outputText value="#{text['tuserInfo.tuserInfoList.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>

	<h:form id="tuserInfoQuery">
		<a4j:jsFunction name="queryTuserInfos" action="#{tuserInfoList.query}" reRender="tuserInfoList" />   		
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
					
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('tuserInfoQuery'));">
					<f:verbatim><span class="linkClearImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTuserInfos();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		 
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent backColor"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="loginName_like" value="#{text['tuserInfo.loginName']}  #{text['query.like']}" />

				<h:panelGroup>
			    <h:inputText id="loginName_like" value="#{tuserInfoList.queryFields.loginName_like}" tabindex="1" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="name_like" value="#{text['tuserInfo.name']}  #{text['query.like']}" />

				<h:panelGroup>
			    <h:inputText id="name_like" value="#{tuserInfoList.queryFields.name_like}" tabindex="2" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>



             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="organizeId" value="#{text['tuserInfo.organizeId']}  #{text['query.equal']}" />

				<h:panelGroup>

	
	
					<h:inputText id="read_organizeId" value="#{tuserInfoList.queryFields.organizeIdOfTorganizeInfo.name}" disabled="true" tabindex="3" styleClass="edit_input" /><h:inputHidden id="organizeId" value="#{tuserInfoList.queryFields.organizeId}" /><f:verbatim><span class="lookup_button" onmousedown="event.cancelBubble=true;showdiv(this,'t_organize_info_Lookup.faces','tuserInfoQuery','organizeId','')"></span></f:verbatim>
				</h:panelGroup>
			  </h:panelGrid>

             <h:inputHidden/> 	

		</h:panelGrid>			
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{tuserInfoList.queryFields}" />
	<t:saveState id="tuserInfos" value="#{tuserInfoList.tuserInfos}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tuserInfo.t_user_info_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="tuserInfoList">
       <a4j:jsFunction name="loadTuserInfos" action="#{tuserInfoList.initTuserInfos}" reRender="tuserInfoList,tuserInfos" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="tuserInfoDataTable" var="tuserInfo"
				value="#{tuserInfoList.tuserInfos}" rowClasses="rowsClass,rowsClass2"
				rows="50"
				sortColumn="#{tuserInfoList.sortColumn}"
				sortAscending="#{tuserInfoList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{tuserInfoList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{tuserInfo.id}" />
					<h:inputHidden id="loginName" value="#{tuserInfo.loginName}" />
					<h:inputHidden id="name" value="#{tuserInfo.name}" />
					<h:inputHidden id="password" value="#{tuserInfo.password}" />
					<h:inputHidden id="email" value="#{tuserInfo.email}" />
					<h:inputHidden id="enable" value="#{tuserInfo.enable}" />
					<h:inputHidden id="organizeId" value="#{tuserInfo.organizeId}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tuserInfo.loginName']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tuserInfo.id}','#{tuserInfo.id}')">					
						<h:outputText value="#{tuserInfo.loginName}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tuserInfo.name']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tuserInfo.id}','#{tuserInfo.id}')">					
						<h:outputText value="#{tuserInfo.name}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tuserInfo.password']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tuserInfo.id}','#{tuserInfo.id}')">					
						<h:outputText value="#{tuserInfo.password}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tuserInfo.email']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tuserInfo.id}','#{tuserInfo.id}')">					
						<h:outputText value="#{tuserInfo.email}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['torganizeInfo.name']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tuserInfo.id}','#{tuserInfo.id}')">					
					<h:outputText id="organizeId-name" value="#{tuserInfo.organizeIdOfTorganizeInfo.name}"  styleClass="linkLookUp" />			
				</h:outputLink>
				</t:column>
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="scroll_1"
                    for="tuserInfoDataTable"
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
                    for="tuserInfoDataTable"
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