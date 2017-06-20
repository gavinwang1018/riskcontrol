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
<body onload="loadTriskcaseRecords();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_riskcase_record/t_riskcase_record_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseRecordList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="triskcaseRecord.t_riskcase_record_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseRecordList.triskcaseRecord}" />
	<t:saveState value="#{triskcaseRecordList.queryFields}" />
	<t:saveState id="triskcaseRecords" value="#{triskcaseRecordList.triskcaseRecords}" />
	    <a4j:jsFunction name="deleteTriskcaseRecord" action="#{triskcaseRecordList.delete}"  reRender="triskcaseRecordPanel,triskcaseRecords" oncomplete="rowIndexVarOfTriskcaseRecord = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTriskcaseRecord" action="#{triskcaseRecordList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="triskcaseRecordList"  >
	<a4j:jsFunction name="loadTriskcaseRecords" action="#{triskcaseRecordList.initTriskcaseRecords}" reRender="triskcaseRecordPanel,triskcaseRecords" />
<script>
		var rowIndexVarOfTriskcaseRecord = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcaseRecord.t_riskcase_record_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="triskcaseRecordPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseRecordList.edit}"  onclick="if(rowIndexVarOfTriskcaseRecord == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase_record.2c90834916e5db4a0116e613df82003e']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase_record/t_riskcase_record_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseRecordList.view}" onclick="if(rowIndexVarOfTriskcaseRecord == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase_record.2c90834916e5db4a0116e613dfa1003f']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase_record/t_riskcase_record_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTriskcaseRecord == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTriskcaseRecord();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase_record.2c90834916e5db4a0116e613dfb10040']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{triskcaseRecordList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_riskcase_record.2c90834916e5db4a0116e613df72003d']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_riskcase_record/t_riskcase_record_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="triskcaseRecordRowIndex" value="#{triskcaseRecordList.rowIndex}"></h:inputHidden>
			<t:dataTable id="triskcaseRecordDataTable" var="triskcaseRecord"
				value="#{triskcaseRecordList.triskcaseRecords}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{triskcaseRecordList.sortColumn}"
				sortAscending="#{triskcaseRecordList.ascending}"
				binding="#{triskcaseRecordList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTriskcaseRecord='#{rowIndexVar}';document.getElementById('triskcaseRecordList:triskcaseRecordRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="riskcaseId" arrow="true">		                
							<h:outputText value="#{text['triskcaseRecord.riskcaseId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="riskcaseId_link" value="../t_riskcase/t_riskcase_ViewForm.faces?_key=#{triskcaseRecord.riskcaseId}">
				  <h:outputText id="riskcaseId" value="#{triskcaseRecord.riskcaseIdOfTriskcase.id}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="investigationDate" arrow="true">		                
							<h:outputText value="#{text['triskcaseRecord.investigationDate']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="investigationDate" value="#{triskcaseRecord.investigationDate}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="createDate" arrow="true">		                
							<h:outputText value="#{text['triskcaseRecord.createDate']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="createDate" value="#{triskcaseRecord.createDate}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="investigationWay" arrow="true">		                
							<h:outputText value="#{text['triskcaseRecord.investigationWay']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="investigationWay" value="#{triskcaseRecord.investigationWay}">
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.3']}" itemValue="3"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="isPickFlow" arrow="true">		                
							<h:outputText value="#{text['triskcaseRecord.isPickFlow']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="isPickFlow" value="#{triskcaseRecord.isPickFlow}"  disabled="true"/>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="pickCnt" arrow="true">		                
							<h:outputText value="#{text['triskcaseRecord.pickCnt']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="pickCnt" value="#{triskcaseRecord.pickCnt}" />
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>