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
<body onload="loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_rule_instance_group_segment/t_rule_instance_group_segment_list_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceGroupSegmentList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="truleInstanceGroupSegment.t_rule_instance_group_segment_list_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('truleInstanceGroupSegmentQuery:searchtab')"><h:outputText value="#{text['truleInstanceGroupSegment.truleInstanceGroupSegmentQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="truleInstanceGroupSegmentQuery" >
		<a4j:jsFunction name="queryTruleInstanceGroupSegments" action="#{truleInstanceGroupSegmentList.query}" reRender="truleInstanceGroupSegmentPanel,truleInstanceGroupSegments" oncomplete="document.getElementById('truleInstanceGroupSegmentList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('truleInstanceGroupSegmentQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTruleInstanceGroupSegments();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="ruleInstanceGroupId" value="#{text['truleInstanceGroupSegment.ruleInstanceGroupId']}  #{text['query.equal']}" />				
				<h:panelGroup>

	
	
					<h:inputText id="read_ruleInstanceGroupId" value="#{truleInstanceGroupSegmentList.queryFields.ruleInstanceGroupIdOfTruleInstanceGroup.id}" disabled="true" tabindex="1" styleClass="edit_input" /><h:inputHidden id="ruleInstanceGroupId" value="#{truleInstanceGroupSegmentList.queryFields.ruleInstanceGroupId}" /><f:verbatim><span class="lookup_button"  onmousedown="event.cancelBubble=true;showdiv(this,'t_rule_instance_group_Lookup.faces','truleInstanceGroupSegmentQuery','ruleInstanceGroupId','')"></span></f:verbatim>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="ruleInstanceId" value="#{text['truleInstanceGroupSegment.ruleInstanceId']}  #{text['query.equal']}" />				
				<h:panelGroup>

	
	
					<h:inputText id="read_ruleInstanceId" value="#{truleInstanceGroupSegmentList.queryFields.ruleInstanceIdOfTruleInstance.id}" disabled="true" tabindex="2" styleClass="edit_input" /><h:inputHidden id="ruleInstanceId" value="#{truleInstanceGroupSegmentList.queryFields.ruleInstanceId}" /><f:verbatim><span class="lookup_button"  onmousedown="event.cancelBubble=true;showdiv(this,'t_rule_instance_Lookup.faces','truleInstanceGroupSegmentQuery','ruleInstanceId','')"></span></f:verbatim>
				</h:panelGroup>
			  </h:panelGrid>




		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{truleInstanceGroupSegmentList.truleInstanceGroupSegment}" />
	<t:saveState value="#{truleInstanceGroupSegmentList.queryFields}" />
	<t:saveState id="truleInstanceGroupSegments" value="#{truleInstanceGroupSegmentList.truleInstanceGroupSegments}" />
	    <a4j:jsFunction name="deleteTruleInstanceGroupSegment" action="#{truleInstanceGroupSegmentList.delete}"  reRender="truleInstanceGroupSegmentPanel,truleInstanceGroupSegments" oncomplete="rowIndexVarOfTruleInstanceGroupSegment = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTruleInstanceGroupSegment" action="#{truleInstanceGroupSegmentList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="truleInstanceGroupSegmentList"  style="display:none">
<script>
		var rowIndexVarOfTruleInstanceGroupSegment = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['truleInstanceGroupSegment.t_rule_instance_group_segment_list_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="truleInstanceGroupSegmentPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleInstanceGroupSegmentList.edit}"  onclick="if(rowIndexVarOfTruleInstanceGroupSegment == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_group_segment_list.2c90834916d142fa0116d3310b2802db']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule_instance_group_segment/t_rule_instance_group_segment_form_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleInstanceGroupSegmentList.view}" onclick="if(rowIndexVarOfTruleInstanceGroupSegment == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_group_segment_list.2c90834916d142fa0116d3310b4702dc']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule_instance_group_segment/t_rule_instance_group_segment_form_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTruleInstanceGroupSegment == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTruleInstanceGroupSegment();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_group_segment_list.2c90834916d142fa0116d3310b5702dd']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{truleInstanceGroupSegmentList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_rule_instance_group_segment_list.2c90834916d142fa0116d3310b0902da']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_rule_instance_group_segment/t_rule_instance_group_segment_form_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="truleInstanceGroupSegmentRowIndex" value="#{truleInstanceGroupSegmentList.rowIndex}"></h:inputHidden>
			<t:dataTable id="truleInstanceGroupSegmentDataTable" var="truleInstanceGroupSegment"
				value="#{truleInstanceGroupSegmentList.truleInstanceGroupSegments}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{truleInstanceGroupSegmentList.sortColumn}"
				sortAscending="#{truleInstanceGroupSegmentList.ascending}"
				binding="#{truleInstanceGroupSegmentList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTruleInstanceGroupSegment='#{rowIndexVar}';document.getElementById('truleInstanceGroupSegmentList:truleInstanceGroupSegmentRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
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
						<t:commandSortHeader columnName="propertion" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.propertion']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="propertion" value="#{truleInstanceGroupSegment.propertion}" />
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
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="truleInstanceGroupSegment_scroll_1" 
                    for="truleInstanceGroupSegmentDataTable"
                    rowsCountVar="rowsCount"
                    displayedRowsCountVar="displayedRowsCountVar"
                    firstRowIndexVar="firstRowIndex"
                    lastRowIndexVar="lastRowIndex"
                    pageCountVar="pageCount"
                    immediate="true"
                    pageIndexVar="pageIndex"
                    paginator="true"
                    paginatorMaxPages="9"

                    >
			<f:facet name="first" >
                <h:outputText value="#{text['page.first']}"/>
            </f:facet>
            <f:facet name="last">
                <h:outputText value="#{text['page.last']}"/>
            </f:facet>
            <f:facet name="previous">
                <h:outputText value="#{text['page.previous']}"/>
            </f:facet>
            <f:facet name="next">
                <h:outputText value="#{text['page.next']}"/>
            </f:facet>
            </t:dataScroller> 			
            <t:dataScroller id="truleInstanceGroupSegment_scroll_2" 
                    for="truleInstanceGroupSegmentDataTable"
                    rowsCountVar="rowsCount"
                    displayedRowsCountVar="displayedRowsCountVar"
                    firstRowIndexVar="firstRowIndex"
                    lastRowIndexVar="lastRowIndex"
                    pageCountVar="pageCount"
                    immediate="true"
                    pageIndexVar="pageIndex"
                    >
                <h:outputFormat value="#{text['pageFooter']}" styleClass="standard" >
                    <f:param value="#{rowsCount}" />
                    <f:param value="#{displayedRowsCountVar}" />
                    <f:param value="#{firstRowIndex}" />
                    <f:param value="#{lastRowIndex}" />
                    <f:param value="#{pageIndex}" />
                    <f:param value="#{pageCount==0?1:pageCount}" />
                </h:outputFormat>
             </t:dataScroller>           
            </h:panelGrid>

		</h:panelGrid>

	</h:form>
</f:view>
</body>