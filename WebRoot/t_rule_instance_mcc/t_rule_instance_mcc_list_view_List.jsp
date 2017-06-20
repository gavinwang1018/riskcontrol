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
<body onload="loadTruleInstanceMccs();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_rule_instance_mcc/t_rule_instance_mcc_list_view_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceMccList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="truleInstanceMcc.t_rule_instance_mcc_list_view_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{truleInstanceMccList.truleInstanceMcc}" />
	<t:saveState value="#{truleInstanceMccList.queryFields}" />
	<t:saveState id="truleInstanceMccs" value="#{truleInstanceMccList.truleInstanceMccs}" />
	    <a4j:jsFunction name="deleteTruleInstanceMcc" action="#{truleInstanceMccList.delete}"  reRender="truleInstanceMccPanel,truleInstanceMccs" oncomplete="rowIndexVarOfTruleInstanceMcc = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTruleInstanceMcc" action="#{truleInstanceMccList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="truleInstanceMccList"  >
	<a4j:jsFunction name="loadTruleInstanceMccs" action="#{truleInstanceMccList.initTruleInstanceMccs}" reRender="truleInstanceMccPanel,truleInstanceMccs" />
<script>
		var rowIndexVarOfTruleInstanceMcc = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['truleInstanceMcc.t_rule_instance_mcc_list_view_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="truleInstanceMccPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleInstanceMccList.edit}"  onclick="if(rowIndexVarOfTruleInstanceMcc == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_mcc_list_view.2c90834916ad22cb0116b2a73c6e01b9']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule_instance_mcc/t_rule_instance_mcc_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleInstanceMccList.view}" onclick="if(rowIndexVarOfTruleInstanceMcc == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_mcc_list_view.2c90834916ad22cb0116b2a73c8e01ba']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule_instance_mcc/t_rule_instance_mcc_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTruleInstanceMcc == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTruleInstanceMcc();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_mcc_list_view.2c90834916ad22cb0116b2a73c9d01bb']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{truleInstanceMccList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_rule_instance_mcc_list_view.2c90834916ad22cb0116b2a73c4f01b8']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_rule_instance_mcc/t_rule_instance_mcc_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="truleInstanceMccRowIndex" value="#{truleInstanceMccList.rowIndex}"></h:inputHidden>
			<t:dataTable id="truleInstanceMccDataTable" var="truleInstanceMcc"
				value="#{truleInstanceMccList.truleInstanceMccs}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{truleInstanceMccList.sortColumn}"
				sortAscending="#{truleInstanceMccList.ascending}"
				binding="#{truleInstanceMccList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTruleInstanceMcc='#{rowIndexVar}';document.getElementById('truleInstanceMccList:truleInstanceMccRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="ruleInstanceId" arrow="true">		                
							<h:outputText value="#{text['truleInstanceMcc.ruleInstanceId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="ruleInstanceId_link" value="../t_rule_instance/t_rule_instance_ViewForm.faces?_key=#{truleInstanceMcc.ruleInstanceId}">
				  <h:outputText id="ruleInstanceId" value="#{truleInstanceMcc.ruleInstanceIdOfTruleInstance.id}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="param1" arrow="true">		                
							<h:outputText value="#{text['truleInstanceMcc.param1']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="param1" value="#{truleInstanceMcc.param1}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="param2" arrow="true">		                
							<h:outputText value="#{text['truleInstanceMcc.param2']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="param2" value="#{truleInstanceMcc.param2}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="param3" arrow="true">		                
							<h:outputText value="#{text['truleInstanceMcc.param3']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="param3" value="#{truleInstanceMcc.param3}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="param4" arrow="true">		                
							<h:outputText value="#{text['truleInstanceMcc.param4']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="param4" value="#{truleInstanceMcc.param4}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mccCode" arrow="true">		                
							<h:outputText value="#{text['truleInstanceMcc.mccCode']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="mccCode" value="#{truleInstanceMcc.mccCode}" />
				</t:column>
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="truleInstanceMcc_scroll_1" 
                    for="truleInstanceMccDataTable"
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
            <t:dataScroller id="truleInstanceMcc_scroll_2" 
                    for="truleInstanceMccDataTable"
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