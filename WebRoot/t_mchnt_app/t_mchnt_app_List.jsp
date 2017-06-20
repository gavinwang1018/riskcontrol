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
<body onload="loadTmchntApps();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_mchnt_app/t_mchnt_app_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntAppList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tmchntApp.t_mchnt_app_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tmchntAppList.tmchntApp}" />
	<t:saveState value="#{tmchntAppList.queryFields}" />
	<t:saveState id="tmchntApps" value="#{tmchntAppList.tmchntApps}" />
	    <a4j:jsFunction name="deleteTmchntApp" action="#{tmchntAppList.delete}"  reRender="tmchntAppPanel,tmchntApps" oncomplete="rowIndexVarOfTmchntApp = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTmchntApp" action="#{tmchntAppList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tmchntAppList"  >
	<a4j:jsFunction name="loadTmchntApps" action="#{tmchntAppList.initTmchntApps}" reRender="tmchntAppPanel,tmchntApps" />
<script>
		var rowIndexVarOfTmchntApp = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tmchntApp.t_mchnt_app_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tmchntAppPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tmchntAppList.edit}"  onclick="if(rowIndexVarOfTmchntApp == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_mchnt_app.2c90834916e5db4a0116e6251015009e']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_mchnt_app/t_mchnt_app_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tmchntAppList.view}" onclick="if(rowIndexVarOfTmchntApp == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_mchnt_app.2c90834916e5db4a0116e6251034009f']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_mchnt_app/t_mchnt_app_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTmchntApp == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTmchntApp();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_mchnt_app.2c90834916e5db4a0116e625104400a0']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{tmchntAppList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_mchnt_app.2c90834916e5db4a0116e6251005009d']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_mchnt_app/t_mchnt_app_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tmchntAppRowIndex" value="#{tmchntAppList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tmchntAppDataTable" var="tmchntApp"
				value="#{tmchntAppList.tmchntApps}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{tmchntAppList.sortColumn}"
				sortAscending="#{tmchntAppList.ascending}"
				binding="#{tmchntAppList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTmchntApp='#{rowIndexVar}';document.getElementById('tmchntAppList:tmchntAppRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mchntId" arrow="true">		                
							<h:outputText value="#{text['tmchntApp.mchntId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="mchntId_link" value="../t_mchnt/t_mchnt_ViewForm.faces?_key=#{tmchntApp.mchntId}">
				  <h:outputText id="mchntId" value="#{tmchntApp.mchntIdOfTmchnt.id}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="apptype" arrow="true">		                
							<h:outputText value="#{text['tmchntApp.apptype']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="apptype" value="#{tmchntApp.apptype}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="main" arrow="true">		                
							<h:outputText value="#{text['tmchntApp.main']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="main" value="#{tmchntApp.main}"  disabled="true"/>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="acquirer" arrow="true">		                
							<h:outputText value="#{text['tmchntApp.acquirer']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="acquirer" value="#{tmchntApp.acquirer}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="networktransferinst" arrow="true">		                
							<h:outputText value="#{text['tmchntApp.networktransferinst']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="networktransferinst" value="#{tmchntApp.networktransferinst}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="memberinstmerno" arrow="true">		                
							<h:outputText value="#{text['tmchntApp.memberinstmerno']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="memberinstmerno" value="#{tmchntApp.memberinstmerno}" />
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>