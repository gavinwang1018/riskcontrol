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
<body onload="loadTorganizeUsers();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_organize_user/t_organize_user_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{torganizeUserList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="torganizeUser.t_organize_user_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{torganizeUserList.torganizeUser}" />
	<t:saveState value="#{torganizeUserList.queryFields}" />
	<t:saveState id="torganizeUsers" value="#{torganizeUserList.torganizeUsers}" />
	    <a4j:jsFunction name="deleteTorganizeUser" action="#{torganizeUserList.delete}"  reRender="torganizeUserPanel,torganizeUsers" oncomplete="rowIndexVarOfTorganizeUser = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTorganizeUser" action="#{torganizeUserList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="torganizeUserList"  >
	<a4j:jsFunction name="loadTorganizeUsers" action="#{torganizeUserList.initTorganizeUsers}" reRender="torganizeUserPanel,torganizeUsers" />
<script>
		var rowIndexVarOfTorganizeUser = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['torganizeUser.t_organize_user_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="torganizeUserPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{torganizeUserList.edit}"  onclick="if(rowIndexVarOfTorganizeUser == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_user.2c90834916d142fa0116d2e90af7004a']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_organize_user/t_organize_user_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{torganizeUserList.view}" onclick="if(rowIndexVarOfTorganizeUser == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_user.2c90834916d142fa0116d2e90b07004b']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_organize_user/t_organize_user_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTorganizeUser == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTorganizeUser();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_user.2c90834916d142fa0116d2e90b26004c']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{torganizeUserList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_organize_user.2c90834916d142fa0116d2e90a7a0049']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_organize_user/t_organize_user_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="torganizeUserRowIndex" value="#{torganizeUserList.rowIndex}"></h:inputHidden>
			<t:dataTable id="torganizeUserDataTable" var="torganizeUser"
				value="#{torganizeUserList.torganizeUsers}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{torganizeUserList.sortColumn}"
				sortAscending="#{torganizeUserList.ascending}"
				binding="#{torganizeUserList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTorganizeUser='#{rowIndexVar}';document.getElementById('torganizeUserList:torganizeUserRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="organizeId" arrow="true">		                
							<h:outputText value="#{text['torganizeUser.organizeId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="organizeId_link" value="../t_organize_info/t_organize_info_ViewForm.faces?_key=#{torganizeUser.organizeId}">
				  <h:outputText id="organizeId" value="#{torganizeUser.organizeIdOfTorganizeInfo.name}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="userId" arrow="true">		                
							<h:outputText value="#{text['torganizeUser.userId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="userId_link" value="../t_user_info/t_user_info_ViewForm.faces?_key=#{torganizeUser.userId}">
				  <h:outputText id="userId" value="#{torganizeUser.userIdOfTuserInfo.id}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="type" arrow="true">		                
							<h:outputText value="#{text['torganizeUser.type']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="type" value="#{torganizeUser.type}"  disabled="true"/>
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>