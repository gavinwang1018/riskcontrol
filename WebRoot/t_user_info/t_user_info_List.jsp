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
<body onload="loadTuserInfos();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_user_info/t_user_info_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tuserInfoList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tuserInfo.t_user_info_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tuserInfoList.tuserInfo}" />
	<t:saveState value="#{tuserInfoList.queryFields}" />
	<t:saveState id="tuserInfos" value="#{tuserInfoList.tuserInfos}" />
	    <a4j:jsFunction name="deleteTuserInfo" action="#{tuserInfoList.delete}"  reRender="tuserInfoPanel,tuserInfos" oncomplete="rowIndexVarOfTuserInfo = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTuserInfo" action="#{tuserInfoList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tuserInfoList"  >
	<a4j:jsFunction name="loadTuserInfos" action="#{tuserInfoList.initTuserInfos}" reRender="tuserInfoPanel,tuserInfos" />
<script>
		var rowIndexVarOfTuserInfo = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tuserInfo.t_user_info_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tuserInfoPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tuserInfoList.edit}"  onclick="if(rowIndexVarOfTuserInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_user_info.2c908349169f7cda0116a99378750771']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_user_info/t_user_info_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tuserInfoList.view}" onclick="if(rowIndexVarOfTuserInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_user_info.2c908349169f7cda0116a99378850772']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_user_info/t_user_info_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTuserInfo == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTuserInfo();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_user_info.2c908349169f7cda0116a99378a40773']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{tuserInfoList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_user_info.2c908349169f7cda0116a99378180770']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_user_info/t_user_info_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tuserInfoRowIndex" value="#{tuserInfoList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tuserInfoDataTable" var="tuserInfo"
				value="#{tuserInfoList.tuserInfos}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{tuserInfoList.sortColumn}"
				sortAscending="#{tuserInfoList.ascending}"
				binding="#{tuserInfoList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTuserInfo='#{rowIndexVar}';document.getElementById('tuserInfoList:tuserInfoRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="loginName" arrow="true">		                
							<h:outputText value="#{text['tuserInfo.loginName']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="loginName" value="#{tuserInfo.loginName}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="name" arrow="true">		                
							<h:outputText value="#{text['tuserInfo.name']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="name" value="#{tuserInfo.name}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="password" arrow="true">		                
							<h:outputText value="#{text['tuserInfo.password']}" />
						</t:commandSortHeader>	
				</f:facet>
            	<h:outputText id="password" value="#{tuserInfo.password}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="email" arrow="true">		                
							<h:outputText value="#{text['tuserInfo.email']}" />
						</t:commandSortHeader>	
				</f:facet>
				 <h:outputText id="email" value="#{tuserInfo.email}" />
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>