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
<body onload="loadTriskcases();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_riskcase/t_riskcase_form_caseover_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="triskcase.t_riskcase_form_caseover_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseList.triskcase}" />
	<t:saveState value="#{triskcaseList.queryFields}" />
	<t:saveState id="triskcases" value="#{triskcaseList.triskcases}" />
	<a4j:jsFunction name="addTriskcase" action="#{triskcaseList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="triskcaseList"  >
	<a4j:jsFunction name="loadTriskcases" action="#{triskcaseList.initTriskcases}" reRender="triskcasePanel,triskcases" />
<script>
		var rowIndexVarOfTriskcase = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcase.t_riskcase_form_caseover_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="triskcasePanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseList.view}" onclick="if(rowIndexVarOfTriskcase == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase_form_caseover.2c90834917143e52011715c77f7200fb']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase/t_riskcase_form_caseover_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="triskcaseRowIndex" value="#{triskcaseList.rowIndex}"></h:inputHidden>
			<t:dataTable id="triskcaseDataTable" var="triskcase"
				value="#{triskcaseList.triskcases}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="20"
				sortColumn="#{triskcaseList.sortColumn}"
				sortAscending="#{triskcaseList.ascending}"
				binding="#{triskcaseList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTriskcase='#{rowIndexVar}';document.getElementById('triskcaseList:triskcaseRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="caseno" arrow="true">		                
							<h:outputText value="#{text['triskcase.caseno']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="caseno" value="#{triskcase.caseno}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="belongToInst" arrow="true">		                
							<h:outputText value="#{text['triskcase.belongToInst']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="belongToInst" value="#{triskcase.belongToInst}">
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="beenUrgent" arrow="true">		                
							<h:outputText value="#{text['triskcase.beenUrgent']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="beenUrgent" value="#{triskcase.beenUrgent}"  disabled="true"/>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="trace" arrow="true">		                
							<h:outputText value="#{text['triskcase.trace']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="trace" value="#{triskcase.trace}"  disabled="true"/>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="submit2Inst" arrow="true">		                
							<h:outputText value="#{text['triskcase.submit2Inst']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="submit2Inst" value="#{triskcase.submit2Inst}">
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</be:outputText>
				</t:column>
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="triskcase_scroll_1" 
                    for="triskcaseDataTable"
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
            <t:dataScroller id="triskcase_scroll_2" 
                    for="triskcaseDataTable"
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