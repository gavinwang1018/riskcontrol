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
<body onload="loadTtransInfos();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_trans_info/t_trans_info_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{ttransInfoList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="ttransInfo.t_trans_info_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{ttransInfoList.ttransInfo}" />
	<t:saveState value="#{ttransInfoList.queryFields}" />
	<t:saveState id="ttransInfos" value="#{ttransInfoList.ttransInfos}" />
	    <a4j:jsFunction name="deleteTtransInfo" action="#{ttransInfoList.delete}"  reRender="ttransInfoPanel,ttransInfos" oncomplete="rowIndexVarOfTtransInfo = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTtransInfo" action="#{ttransInfoList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="ttransInfoList"  >
	<a4j:jsFunction name="loadTtransInfos" action="#{ttransInfoList.initTtransInfos}" reRender="ttransInfoPanel,ttransInfos" />
<script>
		var rowIndexVarOfTtransInfo = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['ttransInfo.t_trans_info_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="ttransInfoPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{ttransInfoList.edit}"  onclick="if(rowIndexVarOfTtransInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_trans_info.2c90834917aea6a90117afaf50940055']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_trans_info/t_trans_info_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{ttransInfoList.view}" onclick="if(rowIndexVarOfTtransInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_trans_info.2c90834917aea6a90117afaf50b30056']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_trans_info/t_trans_info_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTtransInfo == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTtransInfo();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_trans_info.2c90834917aea6a90117afaf50d30057']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{ttransInfoList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_trans_info.2c90834917aea6a90117afaf50560054']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_trans_info/t_trans_info_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="ttransInfoRowIndex" value="#{ttransInfoList.rowIndex}"></h:inputHidden>
			<t:dataTable id="ttransInfoDataTable" var="ttransInfo"
				value="#{ttransInfoList.ttransInfos}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{ttransInfoList.sortColumn}"
				sortAscending="#{ttransInfoList.ascending}"
				binding="#{ttransInfoList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTtransInfo='#{rowIndexVar}';document.getElementById('ttransInfoList:ttransInfoRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="settleDt" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.settleDt']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="settleDt" value="#{ttransInfo.settleDt}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="sysTraNo" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.sysTraNo']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="sysTraNo" value="#{ttransInfo.sysTraNo}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="respCd4" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.respCd4']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="respCd4" value="#{ttransInfo.respCd4}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="transId" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.transId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="transId" value="#{ttransInfo.transId}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="settleIn" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.settleIn']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="settleIn" value="#{ttransInfo.settleIn}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="transAt" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.transAt']}" />
						</t:commandSortHeader>	
				</f:facet>
				 <h:outputText id="transAt" value="#{ttransInfo.transAt}" />
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>