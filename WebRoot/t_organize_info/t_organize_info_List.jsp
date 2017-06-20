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
<body onload="loadTorganizeInfos();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_organize_info/t_organize_info_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{torganizeInfoList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="torganizeInfo.t_organize_info_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{torganizeInfoList.torganizeInfo}" />
	<t:saveState value="#{torganizeInfoList.queryFields}" />
	<t:saveState id="torganizeInfos" value="#{torganizeInfoList.torganizeInfos}" />
	    <a4j:jsFunction name="deleteTorganizeInfo" action="#{torganizeInfoList.delete}"  reRender="torganizeInfoPanel,torganizeInfos" oncomplete="rowIndexVarOfTorganizeInfo = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTorganizeInfo" action="#{torganizeInfoList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="torganizeInfoList"  >
	<a4j:jsFunction name="loadTorganizeInfos" action="#{torganizeInfoList.initTorganizeInfos}" reRender="torganizeInfoPanel,torganizeInfos" />
<script>
		var rowIndexVarOfTorganizeInfo = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['torganizeInfo.t_organize_info_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="torganizeInfoPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{torganizeInfoList.edit}"  onclick="if(rowIndexVarOfTorganizeInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_info.2c908349169f7cda0116a41a559a04df']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_organize_info/t_organize_info_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{torganizeInfoList.view}" onclick="if(rowIndexVarOfTorganizeInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_info.2c908349169f7cda0116a41a55b904e0']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_organize_info/t_organize_info_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTorganizeInfo == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTorganizeInfo();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_info.2c908349169f7cda0116a41a55c904e1']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{torganizeInfoList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_organize_info.2c908349169f7cda0116a41a557b04de']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_organize_info/t_organize_info_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="torganizeInfoRowIndex" value="#{torganizeInfoList.rowIndex}"></h:inputHidden>
			<t:dataTable id="torganizeInfoDataTable" var="torganizeInfo"
				value="#{torganizeInfoList.torganizeInfos}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{torganizeInfoList.sortColumn}"
				sortAscending="#{torganizeInfoList.ascending}"
				binding="#{torganizeInfoList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTorganizeInfo='#{rowIndexVar}';document.getElementById('torganizeInfoList:torganizeInfoRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="name" arrow="true">		                
							<h:outputText value="#{text['torganizeInfo.name']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="name" value="#{torganizeInfo.name}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="dwFlag" arrow="true">		                
							<h:outputText value="#{text['torganizeInfo.dwFlag']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="dwFlag" value="#{torganizeInfo.dwFlag}"  disabled="true"/>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="originalSort" arrow="true">		                
							<h:outputText value="#{text['torganizeInfo.originalSort']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="originalSort" value="#{torganizeInfo.originalSort}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="globalSort" arrow="true">		                
							<h:outputText value="#{text['torganizeInfo.globalSort']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="globalSort" value="#{torganizeInfo.globalSort}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="fwdInsIdCd" arrow="true">		                
							<h:outputText value="#{text['torganizeInfo.fwdInsIdCd']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="fwdInsIdCd" value="#{torganizeInfo.fwdInsIdCd}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="parentId" arrow="true">		                
							<h:outputText value="#{text['torganizeInfo.parentId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="parentId_link" value="../t_organize_info/t_organize_info_ViewForm.faces?_key=#{torganizeInfo.parentId}">
				  <h:outputText id="parentId" value="#{torganizeInfo.parentIdOfTorganizeInfo.name}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="isCheck" arrow="true">		                
							<h:outputText value="#{text['torganizeInfo.isCheck']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="isCheck" value="#{torganizeInfo.isCheck}">
                   <f:selectItem itemLabel="#{text['torganizeInfo.isCheck.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['torganizeInfo.isCheck.1']}" itemValue="1"/>
				</be:outputText>
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>