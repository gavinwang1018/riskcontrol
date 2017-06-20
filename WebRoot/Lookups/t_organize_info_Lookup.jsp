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
<body onload="loadTorganizeInfos();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<br>
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('torganizeInfoQuery:searchtab')"><h:outputText value="#{text['torganizeInfo.torganizeInfoList.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>

	<h:form id="torganizeInfoQuery">
		<a4j:jsFunction name="queryTorganizeInfos" action="#{torganizeInfoList.query}" reRender="torganizeInfoList" />   		
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
					
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('torganizeInfoQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTorganizeInfos();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		 
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent backColor"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="name_like" value="#{text['torganizeInfo.name']}  #{text['query.like']}" />

				<h:panelGroup>
			    <h:inputText id="name_like" value="#{torganizeInfoList.queryFields.name_like}" tabindex="1" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>



             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="organizeLevel" value="#{text['torganizeInfo.organizeLevel']}  #{text['query.equal']}" />

				<h:panelGroup>
			    <h:inputText id="organizeLevel" value="#{torganizeInfoList.queryFields.organizeLevel}" styleClass="edit_input">
					<s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['torganizeInfo.organizeLevel']}" client="true" server="false" />
				</h:inputText>					
				</h:panelGroup>
			  </h:panelGrid>


		</h:panelGrid>			
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{torganizeInfoList.queryFields}" />
	<t:saveState id="torganizeInfos" value="#{torganizeInfoList.torganizeInfos}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['torganizeInfo.t_organize_info_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="torganizeInfoList">
       <a4j:jsFunction name="loadTorganizeInfos" action="#{torganizeInfoList.initTorganizeInfos}" reRender="torganizeInfoList,torganizeInfos" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="torganizeInfoDataTable" var="torganizeInfo"
				value="#{torganizeInfoList.torganizeInfos}" rowClasses="rowsClass,rowsClass2"
				rows="50"
				sortColumn="#{torganizeInfoList.sortColumn}"
				sortAscending="#{torganizeInfoList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{torganizeInfoList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{torganizeInfo.id}" />
					<h:inputHidden id="name" value="#{torganizeInfo.name}" />
					<h:inputHidden id="dwFlag" value="#{torganizeInfo.dwFlag}" />
					<h:inputHidden id="originalSort" value="#{torganizeInfo.originalSort}" />
					<h:inputHidden id="globalSort" value="#{torganizeInfo.globalSort}" />
					<h:inputHidden id="fwdInsIdCd" value="#{torganizeInfo.fwdInsIdCd}" />
					<h:inputHidden id="parentId" value="#{torganizeInfo.parentId}" />
					<h:inputHidden id="organizeBm" value="#{torganizeInfo.organizeBm}" />
					<h:inputHidden id="organizeLevel" value="#{torganizeInfo.organizeLevel}" />
					<h:inputHidden id="isCheck" value="#{torganizeInfo.isCheck}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['torganizeInfo.name']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{torganizeInfo.id}','#{torganizeInfo.name}')">					
						<h:outputText value="#{torganizeInfo.name}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['torganizeInfo.dwFlag']}" />
					</f:facet>
				<h:selectBooleanCheckbox id="dwFlag1" value="#{torganizeInfo.dwFlag}"  disabled="true"/>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['torganizeInfo.name']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{torganizeInfo.id}','#{torganizeInfo.name}')">					
					<h:outputText id="parentId-name" value="#{torganizeInfo.parentIdOfTorganizeInfo.name}"  styleClass="linkLookUp" />			
				</h:outputLink>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['torganizeInfo.organizeLevel']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{torganizeInfo.id}','#{torganizeInfo.name}')">					
						<h:outputText value="#{torganizeInfo.organizeLevel}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="scroll_1"
                    for="torganizeInfoDataTable"
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
                    for="torganizeInfoDataTable"
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