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
	parent.historyIframe.addHistory('/t_rule/t_rule_list_edit_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="trule.t_rule_list_edit_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('truleQuery:searchtab')"><h:outputText value="#{text['trule.truleQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="truleQuery" >
		<a4j:jsFunction name="queryTrules" action="#{truleList.query}" reRender="trulePanel,trules" oncomplete="document.getElementById('truleList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('truleQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTrules();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="id" value="#{text['trule.id']}  #{text['query.equal']}" />				
				<h:panelGroup>
			    <h:inputText id="id" value="#{truleList.queryFields.id}" tabindex="1" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>





             <h:inputHidden/> 	
		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{truleList.trule}" />
	<t:saveState value="#{truleList.queryFields}" />
	<t:saveState id="trules" value="#{truleList.trules}" />
	    <a4j:jsFunction name="deleteTrule" action="#{truleList.delete}"  reRender="trulePanel,trules" oncomplete="rowIndexVarOfTrule = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTrule" action="#{truleList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="truleList"  style="display:none">
<script>
		var rowIndexVarOfTrule = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['trule.t_rule_list_edit_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="trulePanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleList.edit}"  onclick="if(rowIndexVarOfTrule == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_list_edit.2c90834916ad22cb0116b32f4bbf0214']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule/t_rule_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleList.view}" onclick="if(rowIndexVarOfTrule == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_list_edit.2c90834916ad22cb0116b32f4bde0215']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule/t_rule_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTrule == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTrule();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_list_edit.2c90834916ad22cb0116b32f4bfe0216']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{truleList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_rule_list_edit.2c90834916ad22cb0116b32f4ba00213']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_rule/t_rule_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="truleRowIndex" value="#{truleList.rowIndex}"></h:inputHidden>
			<t:dataTable id="truleDataTable" var="trule"
				value="#{truleList.trules}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{truleList.sortColumn}"
				sortAscending="#{truleList.ascending}"
				binding="#{truleList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTrule='#{rowIndexVar}';document.getElementById('truleList:truleRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="id" arrow="true">		                
							<h:outputText value="#{text['trule.id']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="id" value="#{trule.id}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="description" arrow="true">		                
							<h:outputText value="#{text['trule.description']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="description" value="#{trule.description}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="supportTrace" arrow="true">		                
							<h:outputText value="#{text['trule.supportTrace']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="supportTrace" value="#{trule.supportTrace}"  disabled="true"/>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="transInfo" arrow="true">		                
							<h:outputText value="#{text['trule.transInfo']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="transInfo" value="#{trule.transInfo}"  disabled="true"/>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="type" arrow="true">		                
							<h:outputText value="#{text['trule.type']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="type" value="#{trule.type}">
                   <f:selectItem itemLabel="#{text['trule.type.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['trule.type.2']}" itemValue="2"/>
				</be:outputText>
				</t:column>
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="trule_scroll_1" 
                    for="truleDataTable"
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
            <t:dataScroller id="trule_scroll_2" 
                    for="truleDataTable"
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