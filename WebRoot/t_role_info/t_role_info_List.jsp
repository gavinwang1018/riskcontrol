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
	parent.historyIframe.addHistory('/t_role_info/t_role_info_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{troleInfoList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="troleInfo.t_role_info_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('troleInfoQuery:searchtab')"><h:outputText value="#{text['troleInfo.troleInfoQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="troleInfoQuery" >
		<a4j:jsFunction name="queryTroleInfos" action="#{troleInfoList.query}" reRender="troleInfoPanel,troleInfos" oncomplete="document.getElementById('troleInfoList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('troleInfoQuery'));" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTroleInfos();return false;" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="name_like" value="#{text['troleInfo.name']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="name_like" value="#{troleInfoList.queryFields.name_like}" tabindex="1" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>


             <h:inputHidden/> 	
		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{troleInfoList.troleInfo}" />
	<t:saveState value="#{troleInfoList.queryFields}" />
	<t:saveState id="troleInfos" value="#{troleInfoList.troleInfos}" />
	    <a4j:jsFunction name="deleteTroleInfo" action="#{troleInfoList.delete}"  reRender="troleInfoPanel,troleInfos" oncomplete="rowIndexVarOfTroleInfo = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTroleInfo" action="#{troleInfoList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="troleInfoList" >
<script>
		var rowIndexVarOfTroleInfo = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['troleInfo.t_role_info_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="troleInfoPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{troleInfoList.edit}"  onclick="if(rowIndexVarOfTroleInfo == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_role_info.2c908349169f7cda0116a4b9e6c90623']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_role_info/t_role_info_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{troleInfoList.view}" onclick="if(rowIndexVarOfTroleInfo == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_role_info.2c908349169f7cda0116a4b9e6e80624']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_role_info/t_role_info_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTroleInfo == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTroleInfo();}return false" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_role_info.2c908349169f7cda0116a4b9e6f80625']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{troleInfoList.add}" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_role_info.2c908349169f7cda0116a4b9e6a90622']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_role_info/t_role_info_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="troleInfoRowIndex" value="#{troleInfoList.rowIndex}"></h:inputHidden>
			<t:dataTable id="troleInfoDataTable" var="troleInfo"
				value="#{troleInfoList.troleInfos}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{troleInfoList.sortColumn}"
				sortAscending="#{troleInfoList.ascending}"
				binding="#{troleInfoList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTroleInfo='#{rowIndexVar}';document.getElementById('troleInfoList:troleInfoRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="name" arrow="true">		                
							<h:outputText value="#{text['troleInfo.name']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="name" value="#{troleInfo.name}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="code" arrow="true">		                
							<h:outputText value="#{text['troleInfo.code']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="code" value="#{troleInfo.code}" />
				</t:column>
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="troleInfo_scroll_1" 
                    for="troleInfoDataTable"
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
            <t:dataScroller id="troleInfo_scroll_2" 
                    for="troleInfoDataTable"
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

<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{troleInfoList.edit}"  onclick="if(rowIndexVarOfTroleInfo == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_role_info.2c908349169f7cda0116a4b9e6c90623']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_role_info/t_role_info_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{troleInfoList.view}" onclick="if(rowIndexVarOfTroleInfo == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_role_info.2c908349169f7cda0116a4b9e6e80624']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_role_info/t_role_info_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTroleInfo == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTroleInfo();}return false" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_role_info.2c908349169f7cda0116a4b9e6f80625']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{troleInfoList.add}" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_role_info.2c908349169f7cda0116a4b9e6a90622']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_role_info/t_role_info_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
    		
		</h:panelGrid>

	</h:form>
</f:view>
</body>