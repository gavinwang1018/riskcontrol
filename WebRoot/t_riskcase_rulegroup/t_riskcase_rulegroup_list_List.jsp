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
<body onload="loadTriskcaseRulegroups();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_riskcase_rulegroup/t_riskcase_rulegroup_list_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseRulegroupList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="triskcaseRulegroup.t_riskcase_rulegroup_list_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseRulegroupList.triskcaseRulegroup}" />
	<t:saveState value="#{triskcaseRulegroupList.queryFields}" />
	<t:saveState id="triskcaseRulegroups" value="#{triskcaseRulegroupList.triskcaseRulegroups}" />
	    <a4j:jsFunction name="deleteTriskcaseRulegroup" action="#{triskcaseRulegroupList.delete}"  reRender="triskcaseRulegroupPanel,triskcaseRulegroups" oncomplete="rowIndexVarOfTriskcaseRulegroup = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTriskcaseRulegroup" action="#{triskcaseRulegroupList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="triskcaseRulegroupList"  >
	<a4j:jsFunction name="loadTriskcaseRulegroups" action="#{triskcaseRulegroupList.initTriskcaseRulegroups}" reRender="triskcaseRulegroupPanel,triskcaseRulegroups" />
<script>
		var rowIndexVarOfTriskcaseRulegroup = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcaseRulegroup.t_riskcase_rulegroup_list_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="triskcaseRulegroupPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseRulegroupList.edit}"  onclick="if(rowIndexVarOfTriskcaseRulegroup == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase_rulegroup_list.2c908349169f7cda0116a409298b0427']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase_rulegroup/t_riskcase_rulegroup_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseRulegroupList.view}" onclick="if(rowIndexVarOfTriskcaseRulegroup == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase_rulegroup_list.2c908349169f7cda0116a40929ab0428']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase_rulegroup/t_riskcase_rulegroup_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTriskcaseRulegroup == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTriskcaseRulegroup();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase_rulegroup_list.2c908349169f7cda0116a40929ba0429']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{triskcaseRulegroupList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_riskcase_rulegroup_list.2c908349169f7cda0116a409296c0426']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_riskcase_rulegroup/t_riskcase_rulegroup_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="triskcaseRulegroupRowIndex" value="#{triskcaseRulegroupList.rowIndex}"></h:inputHidden>
			<t:dataTable id="triskcaseRulegroupDataTable" var="triskcaseRulegroup"
				value="#{triskcaseRulegroupList.triskcaseRulegroups}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{triskcaseRulegroupList.sortColumn}"
				sortAscending="#{triskcaseRulegroupList.ascending}"
				binding="#{triskcaseRulegroupList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTriskcaseRulegroup='#{rowIndexVar}';document.getElementById('triskcaseRulegroupList:triskcaseRulegroupRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="riskCaseId" arrow="true">		                
							<h:outputText value="#{text['triskcaseRulegroup.riskCaseId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="riskCaseId" value="#{triskcaseRulegroup.riskCaseId}">
                   <f:selectItem itemLabel="#{text['triskcaseRulegroup.riskCaseId.1']}" itemValue="1"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="ruleGroupId" arrow="true">		                
							<h:outputText value="#{text['triskcaseRulegroup.ruleGroupId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="ruleGroupId" value="#{triskcaseRulegroup.ruleGroupId}">
                   <f:selectItem itemLabel="#{text['triskcaseRulegroup.ruleGroupId.1']}" itemValue="1"/>
				</be:outputText>
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>