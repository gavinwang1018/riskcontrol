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
<body onload="loadTmchnts();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_mchnt/t_mchnt_list_edit_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tmchnt.t_mchnt_list_edit_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tmchntList.tmchnt}" />
	<t:saveState value="#{tmchntList.queryFields}" />
	<t:saveState id="tmchnts" value="#{tmchntList.tmchnts}" />
	    <a4j:jsFunction name="deleteTmchnt" action="#{tmchntList.delete}"  reRender="tmchntPanel,tmchnts" oncomplete="rowIndexVarOfTmchnt = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTmchnt" action="#{tmchntList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tmchntList"  >
	<a4j:jsFunction name="loadTmchnts" action="#{tmchntList.initTmchnts}" reRender="tmchntPanel,tmchnts" />
<script>
		var rowIndexVarOfTmchnt = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tmchnt.t_mchnt_list_edit_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tmchntPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tmchntList.edit}"  onclick="if(rowIndexVarOfTmchnt == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_mchnt_list_edit.2c908349169f7cda0116a3db840f02c3']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_mchnt/t_mchnt_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tmchntList.view}" onclick="if(rowIndexVarOfTmchnt == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_mchnt_list_edit.2c908349169f7cda0116a3db841f02c4']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_mchnt/t_mchnt_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTmchnt == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTmchnt();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_mchnt_list_edit.2c908349169f7cda0116a3db843e02c5']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{tmchntList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_mchnt_list_edit.2c908349169f7cda0116a3db83f002c2']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_mchnt/t_mchnt_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tmchntRowIndex" value="#{tmchntList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tmchntDataTable" var="tmchnt"
				value="#{tmchntList.tmchnts}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{tmchntList.sortColumn}"
				sortAscending="#{tmchntList.ascending}"
				binding="#{tmchntList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTmchnt='#{rowIndexVar}';document.getElementById('tmchntList:tmchntRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="id" arrow="true">		                
							<h:outputText value="#{text['tmchnt.id']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="id" value="#{tmchnt.id}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="merchantcategory" arrow="true">		                
							<h:outputText value="#{text['tmchnt.merchantcategory']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="merchantcategory_link" value="../t_mcc/t_mcc_ViewForm.faces?_key=#{tmchnt.merchantcategory}">
				  <h:outputText id="merchantcategory" value="#{tmchnt.merchantcategoryOfTmcc.id}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="foreigncard" arrow="true">		                
							<h:outputText value="#{text['tmchnt.foreigncard']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="foreigncard" value="#{tmchnt.foreigncard}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="merchantnature" arrow="true">		                
							<h:outputText value="#{text['tmchnt.merchantnature']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="merchantnature" value="#{tmchnt.merchantnature}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="name" arrow="true">		                
							<h:outputText value="#{text['tmchnt.name']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="name" value="#{tmchnt.name}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="briefname" arrow="true">		                
							<h:outputText value="#{text['tmchnt.briefname']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="briefname" value="#{tmchnt.briefname}" />
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

		</h:panelGrid>

	</h:form>
</f:view>
</body>