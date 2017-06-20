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
<body onload="loadTpermissions();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_permission/t_permission_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tpermissionList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tpermission.t_permission_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tpermissionList.tpermission}" />
	<t:saveState value="#{tpermissionList.queryFields}" />
	<t:saveState id="tpermissions" value="#{tpermissionList.tpermissions}" />
	    <a4j:jsFunction name="deleteTpermission" action="#{tpermissionList.delete}"  reRender="tpermissionPanel,tpermissions" oncomplete="rowIndexVarOfTpermission = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTpermission" action="#{tpermissionList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tpermissionList"  >
	<a4j:jsFunction name="loadTpermissions" action="#{tpermissionList.initTpermissions}" reRender="tpermissionPanel,tpermissions" />
<script>
		var rowIndexVarOfTpermission = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tpermission.t_permission_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tpermissionPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tpermissionList.edit}"  onclick="if(rowIndexVarOfTpermission == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_permission.2c90834916c1da250116c211aa81002d']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_permission/t_permission_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tpermissionList.view}" onclick="if(rowIndexVarOfTpermission == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_permission.2c90834916c1da250116c211aa90002e']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_permission/t_permission_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTpermission == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTpermission();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_permission.2c90834916c1da250116c211aab0002f']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{tpermissionList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_permission.2c90834916c1da250116c211aa61002c']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_permission/t_permission_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tpermissionRowIndex" value="#{tpermissionList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tpermissionDataTable" var="tpermission"
				value="#{tpermissionList.tpermissions}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{tpermissionList.sortColumn}"
				sortAscending="#{tpermissionList.ascending}"
				binding="#{tpermissionList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTpermission='#{rowIndexVar}';document.getElementById('tpermissionList:tpermissionRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="roleId" arrow="true">		                
							<h:outputText value="#{text['tpermission.roleId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="roleId_link" value="../t_role_info/t_role_info_ViewForm.faces?_key=#{tpermission.roleId}">
				  <h:outputText id="roleId" value="#{tpermission.roleIdOfTroleInfo.id}"/>
				</h:outputLink>	
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>