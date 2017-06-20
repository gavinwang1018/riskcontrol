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
<body onload="loadTriskcaseLogs();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_riskcase_log/t_riskcase_log_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseLogList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="triskcaseLog.t_riskcase_log_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseLogList.triskcaseLog}" />
	<t:saveState value="#{triskcaseLogList.queryFields}" />
	<t:saveState id="triskcaseLogs" value="#{triskcaseLogList.triskcaseLogs}" />
	<a4j:jsFunction name="addTriskcaseLog" action="#{triskcaseLogList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="triskcaseLogList"  >
	<a4j:jsFunction name="loadTriskcaseLogs" action="#{triskcaseLogList.initTriskcaseLogs}" reRender="triskcaseLogPanel,triskcaseLogs" />
<script>
		var rowIndexVarOfTriskcaseLog = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcaseLog.t_riskcase_log_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="triskcaseLogPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseLogList.view}" onclick="if(rowIndexVarOfTriskcaseLog == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase_log.2c908349169f7cda0116a4372d54053a']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase_log/t_riskcase_log_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="triskcaseLogRowIndex" value="#{triskcaseLogList.rowIndex}"></h:inputHidden>
			<t:dataTable id="triskcaseLogDataTable" var="triskcaseLog"
				value="#{triskcaseLogList.triskcaseLogs}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{triskcaseLogList.sortColumn}"
				sortAscending="#{triskcaseLogList.ascending}"
				binding="#{triskcaseLogList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTriskcaseLog='#{rowIndexVar}';document.getElementById('triskcaseLogList:triskcaseLogRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="userMame" arrow="true">		                
							<h:outputText value="#{text['triskcaseLog.userMame']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="userMame" value="#{triskcaseLog.userMame}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="operatorDatetime" arrow="true">		                
							<h:outputText value="#{text['triskcaseLog.operatorDatetime']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="operatorDatetime" value="#{triskcaseLog.operatorDatetime}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="ip" arrow="true">		                
							<h:outputText value="#{text['triskcaseLog.ip']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="ip" value="#{triskcaseLog.ip}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="content" arrow="true">		                
							<h:outputText value="#{text['triskcaseLog.content']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="content" value="#{triskcaseLog.content}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="loginName" arrow="true">		                
							<h:outputText value="#{text['triskcaseLog.loginName']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="loginName" value="#{triskcaseLog.loginName}" />
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>