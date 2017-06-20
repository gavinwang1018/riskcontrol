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
<body onload="loadTroleUsers();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_role_user/t_role_user_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{troleUserList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="troleUser.t_role_user_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{troleUserList.troleUser}" />
	<t:saveState value="#{troleUserList.queryFields}" />
	<t:saveState id="troleUsers" value="#{troleUserList.troleUsers}" />
	    <a4j:jsFunction name="deleteTroleUser" action="#{troleUserList.delete}"  reRender="troleUserPanel,troleUsers" oncomplete="rowIndexVarOfTroleUser = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTroleUser" action="#{troleUserList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="troleUserList"  >
	<a4j:jsFunction name="loadTroleUsers" action="#{troleUserList.initTroleUsers}" reRender="troleUserPanel,troleUsers" />
<script>
		var rowIndexVarOfTroleUser = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['troleUser.t_role_user_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="troleUserPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{troleUserList.edit}"  onclick="if(rowIndexVarOfTroleUser == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_role_user.2c908349169f7cda0116a8fcc4900688']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_role_user/t_role_user_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{troleUserList.view}" onclick="if(rowIndexVarOfTroleUser == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_role_user.2c908349169f7cda0116a8fcc4bf0689']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_role_user/t_role_user_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTroleUser == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTroleUser();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_role_user.2c908349169f7cda0116a8fcc4cf068a']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{troleUserList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_role_user.2c908349169f7cda0116a8fcc4710687']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_role_user/t_role_user_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="troleUserRowIndex" value="#{troleUserList.rowIndex}"></h:inputHidden>
			<t:dataTable id="troleUserDataTable" var="troleUser"
				value="#{troleUserList.troleUsers}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{troleUserList.sortColumn}"
				sortAscending="#{troleUserList.ascending}"
				binding="#{troleUserList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTroleUser='#{rowIndexVar}';document.getElementById('troleUserList:troleUserRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="roleId" arrow="true">		                
							<h:outputText value="#{text['troleUser.roleId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="roleId" value="#{troleUser.roleId}">
                   <f:selectItems value="#{selectItems.troleInfoItems}"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="userId" arrow="true">		                
							<h:outputText value="#{text['troleUser.userId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="userId" value="#{troleUser.userId}">
                   <f:selectItems value="#{selectItems.tuserInfoItems}"/>
				</be:outputText>
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>