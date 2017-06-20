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
<body onload="loadTrules();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_rule/t_rule_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="trule.t_rule_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{truleList.trule}" />
	<t:saveState value="#{truleList.queryFields}" />
	<t:saveState id="trules" value="#{truleList.trules}" />
	    <a4j:jsFunction name="deleteTrule" action="#{truleList.delete}"  reRender="trulePanel,trules" oncomplete="rowIndexVarOfTrule = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTrule" action="#{truleList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="truleList"  >
	<a4j:jsFunction name="loadTrules" action="#{truleList.initTrules}" reRender="trulePanel,trules" />
<script>
		var rowIndexVarOfTrule = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['trule.t_rule_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="trulePanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleList.edit}"  onclick="if(rowIndexVarOfTrule == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule.2c90834916ad22cb0116b328f6690200']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule/t_rule_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleList.view}" onclick="if(rowIndexVarOfTrule == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule.2c90834916ad22cb0116b328f6880201']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule/t_rule_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTrule == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTrule();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule.2c90834916ad22cb0116b328f6970202']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{truleList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_rule.2c90834916ad22cb0116b328f62a01ff']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_rule/t_rule_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="truleRowIndex" value="#{truleList.rowIndex}"></h:inputHidden>
			<t:dataTable id="truleDataTable" var="trule"
				value="#{truleList.trules}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
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

		</h:panelGrid>

	</h:form>
</f:view>
</body>