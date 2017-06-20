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
	parent.historyIframe.addHistory('/t_mchnt/t_mchnt_list_add_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tmchnt.t_mchnt_list_add_List.heading" />","2")
}catch(e){}

function selAll(){
	var allInputs=document.getElementById("tmchntList").getElementsByTagName("input");
    for(var i=0;i<allInputs.length;i++)
    {
    	if(allInputs[i].type=="checkbox"){
    		allInputs[i].checked=true;
    	}
    }
}

function unselAll(){
	var allInputs=document.getElementById("tmchntList").getElementsByTagName("input");
    for(var i=0;i<allInputs.length;i++)
    {
    	if(allInputs[i].type=="checkbox"){
    		allInputs[i].checked=false;
    	}
    }
}

function myCheck(){
	var allInputs=document.getElementById("tmchntList").getElementsByTagName("input");
	var j=0;
    for(var i=0;i<allInputs.length;i++)
    {
    	if(allInputs[i].type=="checkbox"){
    		if(allInputs[i].checked) {
    			return false;
    		}
    	}
    }
	return true;
}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('tmchntQuery:searchtab')"><h:outputText value="#{text['tmchnt.tmchntQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="tmchntQuery" >
		<a4j:jsFunction name="queryTmchnts" action="#{tmchntList.query}" reRender="tmchntPanel,tmchnts" oncomplete="document.getElementById('tmchntList').style.display='block';parent.dyniframesize('mainFrame')" />   
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
				<h:commandLink  onclick="queryTmchnts();return false;" rendered="#{sessionScope._user_info.actionMap['action.50'] == 'true'}">
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
				<h:selectOneMenu id="subinst" value="#{tmchntList.queryFields.subinst}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</h:selectOneMenu >
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="merchantno_like" value="#{text['tmchnt.merchantno']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="merchantno_like" value="#{tmchntList.queryFields.merchantno_like}" tabindex="2" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="briefname_like" value="#{text['tmchnt.briefname']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="briefname_like" value="#{tmchntList.queryFields.briefname_like}" tabindex="3" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>
             <h:inputHidden/> 	
		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{tmchntList.tmchnt}" />
	<t:saveState value="#{tmchntList.queryFields}" />
	
	<h:form id="tmchntList" >
<script>
		var rowIndexVarOfTmchnt = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tmchnt.t_mchnt_list_add_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tmchntPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
       <f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink onclick="selAll();return false">				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="全选" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>        	

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink onclick="unselAll();return false">		   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="重置" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim> 
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tmchntRowIndex" value="#{tmchntList.rowIndex}"></h:inputHidden>
			<f:verbatim>	
<script language=javascript>

</script>	
			</f:verbatim>
			<t:dataTable id="tmchntDataTable" var="tmchnt"
				value="#{tmchntList.tmchnts}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{tmchntList.sortColumn}"
				sortAscending="#{tmchntList.ascending}"
				binding="#{tmchntList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTmchnt='#{rowIndexVar}';document.getElementById('tmchntList:tmchntRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column width="30">
					<f:facet name="header">
						<h:outputText value="#{text['button.operator']}" />
					</f:facet>	
				 <h:panelGroup><f:verbatim><nobr></f:verbatim>

				<h:panelGroup >                                              
					<h:selectBooleanCheckbox id="check" value="#{tmchnt.checked}" />
					    <f:verbatim>&nbsp&nbsp</f:verbatim>
			        </h:panelGroup>
				 <f:verbatim><nobr></f:verbatim></h:panelGroup>					 	
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
						<t:commandSortHeader columnName="briefname" arrow="true">		                
							<h:outputText value="#{text['tmchnt.briefname']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="briefname" value="#{tmchnt.briefname}" />
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
						<t:commandSortHeader columnName="merchantcategory" arrow="true">		                
							<h:outputText value="#{text['tmchnt.merchantcategory']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="merchantcategory" value="#{tmchnt.merchantcategory}">
                   <f:selectItems value="#{extSelectItems.tmccNamessOfTmccs}"/>
				</be:outputText>
				
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="registerAddress" arrow="true">		                
							<h:outputText value="#{text['tmchnt.registerAddress']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="registerAddress" value="#{tmchnt.registerAddress}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="licenseno" arrow="true">		                
							<h:outputText value="#{text['tmchnt.licenseno']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="licenseno" value="#{tmchnt.licenseno}" />
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

			
			<h:panelGrid columns="3" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="type" value="#{text['tkeoMchnt.type']}  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="type" value="#{tmchntList.type}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.7']}" itemValue="7"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.8']}" itemValue="8"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>
			
			<h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="reason" value="原因" />				
				<h:panelGroup>
			    <h:inputTextarea id="reason" value="#{tmchntList.reason}" rows="4"/>
				</h:panelGroup>
			  </h:panelGrid>
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>  
					<f:verbatim><li></f:verbatim>
						<h:commandLink onclick="if(myCheck())
												{alert('请至少选择一条记录');return false}
											if(document.getElementById('tmchntList:type').value==''){
												 alert('请选择类型');return false}
											if(document.getElementById('tmchntList:reason').value==''){
												 alert('请填写原因');return false}
											if (document.getElementById('tmchntList:type').value=='1'){
												
												 if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.1']}')){
												    return false;}			
											}
											if (document.getElementById('tmchntList:type').value=='2'){
												if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.2']}' )){
												    return false;}							
											}
											if (document.getElementById('tmchntList:type').value=='3'){
												if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.3']}')){
												    return false;}							
											}
											if (document.getElementById('tmchntList:type').value=='4'){
												if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.4']}')){
												    return false;}							
											}
											if (document.getElementById('tmchntList:type').value=='7'){
												if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.7']}' )){
												    return false;}							
											}
											if (document.getElementById('tmchntList:type').value=='8'){
												if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.8']}' )){
												    return false;}							
											}
											" action="#{tmchntList.saveTkeoMchnt}" rendered="#{sessionScope._user_info.actionMap['action.51'] == 'true'}">		
									<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionedit.t_mchnt_form_edit.2c908349169f7cda0116a3db457f02b8']}" />
						
						</h:commandLink>
					<f:verbatim></li></f:verbatim>  
					<f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
			</h:panelGrid>
</h:panelGrid>
		</h:panelGrid>

	</h:form>
</f:view>
</body>