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
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/right.css" />
<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>

<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/calculator.js"></script>
<script language=javascript src="<%=basePath%>/scripts/getreset.js"></script>
<script language=javascript src="<%=basePath%>/scripts/edit.js"></script>
</head>
<body onload="loadTruleInstances();loadHidInfo();getDateObj();loadDateSelect();">
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts";

try{
	parent.historyIframe.addHistory('/t_rule_instance/t_rule_instance_list_edit_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="truleInstance.t_rule_instance_list_edit_List.note" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<f:verbatim><div class="mytab1">
	    <ul class="myTabBar1">
	      <li class="Selected"><a href="#"></f:verbatim><h:outputText value="#{text['truleInstance.t_rule_instance_list_edit_List.heading']}" /><f:verbatim></a></li>
	    </ul>
	</div></f:verbatim>
	<t:saveState value="#{truleInstanceList.truleInstance}" />
	<t:saveState value="#{truleInstanceList.queryFields}" />
	<t:saveState id="truleInstances" value="#{truleInstanceList.truleInstances}" />
	    <a4j:jsFunction name="deleteTruleInstance" action="#{truleInstanceList.deleteBuffer}"  reRender="truleInstanceDataTable,truleInstances" oncomplete="rowIndexVarOfTruleInstance = -1">
		<a4j:actionparam name="param1" assignTo="#{truleInstanceList.rowIndex}"  /> 
	</a4j:jsFunction>	

	<h:form id="truleInstanceList">
	<a4j:jsFunction name="loadTruleInstances" action="#{truleInstanceList.initTruleInstances}" reRender="truleInstanceList,truleInstances" />
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul class="button_bar"></f:verbatim>						

	<h:panelGroup >
			   <f:verbatim><li></f:verbatim><h:commandLink action="#{truleInstanceList.edit}">
				<f:verbatim><span class="linkEditImg"></span></f:verbatim>
				<h:outputText styleClass="linkEditImg"  value="#{text['actionlistrec.t_rule_instance_list_edit.2c908349169f7cda0116a99156be0727']}"  onclick="if(rowIndexVarOfTruleInstance == -1){alert('#{text['button.selected.confirm']}');return false;}"/>
					<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule_instance/t_rule_instance_EditForm"/>
			   </h:commandLink><f:verbatim></li></f:verbatim>				   
			        </h:panelGroup>

	<h:panelGroup >
			   <f:verbatim><li></f:verbatim>
				<h:commandLink action="#{truleInstanceList.view}" onclick="if(rowIndexVarOfTruleInstance == -1){alert('#{text['button.selected.confirm']}');return false;}">
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText"  value="#{text['actionlistrec.t_rule_instance_list_edit.2c908349169f7cda0116a99156de0728']}"/>
					<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule_instance/t_rule_instance_ViewForm"/>
			   </h:commandLink><f:verbatim></li></f:verbatim>
			        </h:panelGroup>

	<h:panelGroup >
            <f:verbatim><li></f:verbatim>
				<h:commandLink action="#{truleInstanceList.delete}"	onclick="if(rowIndexVarOfTruleInstance == -1){alert('#{text['button.selected.confirm']}');return false;}else if(!confirm('#{text['button.confirm.delete']}')){return false;}"  >
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_list_edit.2c908349169f7cda0116a99156ed0729']}"/>
			</h:commandLink><f:verbatim></li></f:verbatim>
			        </h:panelGroup>

	            <f:verbatim><li></f:verbatim><h:commandLink action="#{truleInstanceList.add}"  >
					<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_rule_instance/t_rule_instance_EditForm.faces" />
					<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_rule_instance_list_edit.2c908349169f7cda0116a99156af0726']}"/>
	            </h:commandLink><f:verbatim></li></f:verbatim>
                <f:verbatim><li></f:verbatim><h:commandLink action="#{truleInstanceList.save}">
					<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.save']}"/>
				</h:commandLink><f:verbatim></li></f:verbatim>		
				<f:verbatim></ul></f:verbatim>
				</h:panelGroup>
			</h:panelGrid>
<f:verbatim>				
<script>
		var rowIndexVarOfTruleInstance = -1;
</script>
</f:verbatim>
<h:inputHidden id="truleInstanceRowIndex" value="#{truleInstanceList.rowIndex}"></h:inputHidden>
			<t:dataTable id="truleInstanceDataTable" var="truleInstance"
				value="#{truleInstanceList.truleInstances}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" rowOnClick="rowIndexVarOfTruleInstance='#{rowIndexVar}';document.getElementById('truleInstanceList:truleInstanceRowIndex').value='#{rowIndexVar}';"  onclick="hightlightRows(this)"
				preserveDataModel="true" 
				rows="50"
			
				sortColumn="#{truleInstanceList.sortColumn}"
				sortAscending="#{truleInstanceList.ascending}"
				binding="#{truleInstanceList.dataTable}"  headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd">
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">	
            <t:dataScroller id="scroll_1"
                    for="truleInstanceDataTable"
                    rowsCountVar="rowsCount"
                    displayedRowsCountVar="displayedRowsCountVar"
                    firstRowIndexVar="firstRowIndex"
                    lastRowIndexVar="lastRowIndex"
                    pageCountVar="pageCount"
                    immediate="true"
                    pageIndexVar="pageIndex"
                    paginator="true"
                    paginatorMaxPages="9">
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
                    for="truleInstanceDataTable"
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
	<script type="text/javascript">
		highlightTableRows("truleInstanceList:truleInstanceDataTable");
	</script>
</f:view>
</body>