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
<body onload="loadTkeoMchnts();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_keo_mchnt/t_keo_mchnt_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tkeoMchntList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tkeoMchnt.t_keo_mchnt_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tkeoMchntList.tkeoMchnt}" />
	<t:saveState value="#{tkeoMchntList.queryFields}" />
	<t:saveState id="tkeoMchnts" value="#{tkeoMchntList.tkeoMchnts}" />
    <a4j:jsFunction name="moveUpTkeoMchnt" action="#{tkeoMchntList.moveUp}"  reRender="tkeoMchntPanel,tkeoMchnts"  oncomplete="rowIndexVarOfmoveUpTkeoMchnt = -1">
	</a4j:jsFunction>	
    <a4j:jsFunction name="moveDownTkeoMchnt" action="#{tkeoMchntList.moveDown}"  reRender="tkeoMchntPanel,tkeoMchnts"  oncomplete="rowIndexVarOfmoveDownTkeoMchnt = -1">
	</a4j:jsFunction>
	    <a4j:jsFunction name="deleteTkeoMchnt" action="#{tkeoMchntList.delete}"  reRender="tkeoMchntPanel,tkeoMchnts" oncomplete="rowIndexVarOfTkeoMchnt = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTkeoMchnt" action="#{tkeoMchntList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tkeoMchntList"  >
	<a4j:jsFunction name="loadTkeoMchnts" action="#{tkeoMchntList.initTkeoMchnts}" reRender="tkeoMchntPanel,tkeoMchnts" />
<script>
		var rowIndexVarOfTkeoMchnt = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tkeoMchnt.t_keo_mchnt_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tkeoMchntPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
		    <h:commandLink  onclick="if(rowIndexVarOfTkeoMchnt == -1){alert('#{text['button.selected.confirm']}')}else{moveUpTkeoMchnt();}return false" >
				<f:verbatim><span class="linkMoveUpImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.up']}" />
			</h:commandLink>
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
	        <h:commandLink onclick="if(rowIndexVarOfTkeoMchnt == -1){alert('#{text['button.selected.confirm']}')}else{moveDownTkeoMchnt();}return false" >
				<f:verbatim><span class="linkMoveDownImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.down']}"  />
			</h:commandLink>
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tkeoMchntList.edit}"  onclick="if(rowIndexVarOfTkeoMchnt == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_keo_mchnt.2c908349169f7cda0116a4898c5e05f0']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_keo_mchnt/t_keo_mchnt_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tkeoMchntList.view}" onclick="if(rowIndexVarOfTkeoMchnt == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_keo_mchnt.2c908349169f7cda0116a4898c7d05f1']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_keo_mchnt/t_keo_mchnt_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTkeoMchnt == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTkeoMchnt();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_keo_mchnt.2c908349169f7cda0116a4898c9c05f2']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{tkeoMchntList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_keo_mchnt.2c908349169f7cda0116a4898c1005ed']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_keo_mchnt/t_keo_mchnt_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tkeoMchntRowIndex" value="#{tkeoMchntList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tkeoMchntDataTable" var="tkeoMchnt"
				value="#{tkeoMchntList.tkeoMchnts}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{tkeoMchntList.sortColumn}"
				sortAscending="#{tkeoMchntList.ascending}"
				binding="#{tkeoMchntList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTkeoMchnt='#{rowIndexVar}';document.getElementById('tkeoMchntList:tkeoMchntRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mchntCd" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.mchntCd']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="mchntCd" value="#{tkeoMchnt.mchntCd}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="reason" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.reason']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="reason" value="#{tkeoMchnt.reason}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mchntName" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.mchntName']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="mchntName" value="#{tkeoMchnt.mchntName}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="type" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.type']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="type" value="#{tkeoMchnt.type}">
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.5']}" itemValue="5"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.6']}" itemValue="6"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.7']}" itemValue="7"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.8']}" itemValue="8"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="belongToInst" arrow="true">		                
							<h:outputText value="#{text['tkeoMchnt.belongToInst']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="belongToInst" value="#{tkeoMchnt.belongToInst}">
                   <f:selectItems value="#{selectItems.belongToInstList}"/>
				</be:outputText>
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>