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
<body onload="loadTruleInstanceGroupSegments();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_rule_instance_group_segment/t_rule_instance_group_segment_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceGroupSegmentList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="truleInstanceGroupSegment.t_rule_instance_group_segment_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{truleInstanceGroupSegmentList.truleInstanceGroupSegment}" />
	<t:saveState value="#{truleInstanceGroupSegmentList.queryFields}" />
	<t:saveState id="truleInstanceGroupSegments" value="#{truleInstanceGroupSegmentList.truleInstanceGroupSegments}" />
	    <a4j:jsFunction name="deleteTruleInstanceGroupSegment" action="#{truleInstanceGroupSegmentList.delete}"  reRender="truleInstanceGroupSegmentPanel,truleInstanceGroupSegments" oncomplete="rowIndexVarOfTruleInstanceGroupSegment = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTruleInstanceGroupSegment" action="#{truleInstanceGroupSegmentList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="truleInstanceGroupSegmentList"  >
	<a4j:jsFunction name="loadTruleInstanceGroupSegments" action="#{truleInstanceGroupSegmentList.initTruleInstanceGroupSegments}" reRender="truleInstanceGroupSegmentPanel,truleInstanceGroupSegments" />
<script>
		var rowIndexVarOfTruleInstanceGroupSegment = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['truleInstanceGroupSegment.t_rule_instance_group_segment_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="truleInstanceGroupSegmentPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleInstanceGroupSegmentList.edit}"  onclick="if(rowIndexVarOfTruleInstanceGroupSegment == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_group_segment.2c908349172dd02b01172e4b82da0016']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule_instance_group_segment/t_rule_instance_group_segment_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleInstanceGroupSegmentList.view}" onclick="if(rowIndexVarOfTruleInstanceGroupSegment == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_group_segment.2c908349172dd02b01172e4b83280017']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule_instance_group_segment/t_rule_instance_group_segment_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTruleInstanceGroupSegment == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTruleInstanceGroupSegment();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_group_segment.2c908349172dd02b01172e4b83480018']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{truleInstanceGroupSegmentList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_rule_instance_group_segment.2c908349172dd02b01172e4b825d0015']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_rule_instance_group_segment/t_rule_instance_group_segment_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="truleInstanceGroupSegmentRowIndex" value="#{truleInstanceGroupSegmentList.rowIndex}"></h:inputHidden>
			<t:dataTable id="truleInstanceGroupSegmentDataTable" var="truleInstanceGroupSegment"
				value="#{truleInstanceGroupSegmentList.truleInstanceGroupSegments}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{truleInstanceGroupSegmentList.sortColumn}"
				sortAscending="#{truleInstanceGroupSegmentList.ascending}"
				binding="#{truleInstanceGroupSegmentList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTruleInstanceGroupSegment='#{rowIndexVar}';document.getElementById('truleInstanceGroupSegmentList:truleInstanceGroupSegmentRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="propertion" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.propertion']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="propertion" value="#{truleInstanceGroupSegment.propertion}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="ruleInstanceGroupId" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.ruleInstanceGroupId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="ruleInstanceGroupId_link" value="../t_rule_instance_group/t_rule_instance_group_ViewForm.faces?_key=#{truleInstanceGroupSegment.ruleInstanceGroupId}">
				  <h:outputText id="ruleInstanceGroupId" value="#{truleInstanceGroupSegment.ruleInstanceGroupIdOfTruleInstanceGroup.id}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="begin" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.begin']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="begin" value="#{truleInstanceGroupSegment.begin}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="end" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.end']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="end" value="#{truleInstanceGroupSegment.end}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="ruleInstanceId" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.ruleInstanceId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="ruleInstanceId_link" value="../t_rule_instance/t_rule_instance_ViewForm.faces?_key=#{truleInstanceGroupSegment.ruleInstanceId}">
				  <h:outputText id="ruleInstanceId" value="#{truleInstanceGroupSegment.ruleInstanceIdOfTruleInstance.id}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="value" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.value']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="value" value="#{truleInstanceGroupSegment.value}" />
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>