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
	parent.historyIframe.addHistory('/t_riskcase/t_riskcase_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="triskcase.t_riskcase_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('triskcaseQuery:searchtab')"><h:outputText value="#{text['triskcase.triskcaseQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="triskcaseQuery" >
		<a4j:jsFunction name="queryTriskcases" action="#{triskcaseList.query}" reRender="triskcasePanel,triskcases" oncomplete="document.getElementById('triskcaseList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('triskcaseQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTriskcases();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 


	             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
			    <h:outputLabel styleClass="fontnormal" for="beginDate_min" value="#{text['triskcase.beginDate']}  #{text['query.from']}" />						
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="beginDate_min" value="#{triskcaseList.queryFields.beginDate_min}" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
	</h:panelGrid>
	        <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">

				<h:outputLabel styleClass="fontnormal" for="beginDate_max" value="#{text['query.to']}" />				
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="beginDate_max" value="#{triskcaseList.queryFields.beginDate_max}" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
	
			  </h:panelGrid>
			  

	             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
			    <h:outputLabel styleClass="fontnormal" for="endDate_min" value="#{text['triskcase.endDate']}  #{text['query.from']}" />						
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="endDate_min" value="#{triskcaseList.queryFields.endDate_min}" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
	</h:panelGrid>
	        <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">

				<h:outputLabel styleClass="fontnormal" for="endDate_max" value="#{text['query.to']}" />				
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="endDate_max" value="#{triskcaseList.queryFields.endDate_max}" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
	
			  </h:panelGrid>
			  


	             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
			    <h:outputLabel styleClass="fontnormal" for="relativeTransAmt_min" value="#{text['triskcase.relativeTransAmt']}  #{text['query.from']}" />						
				<h:panelGroup>
			    <h:inputText id="relativeTransAmt_min" value="#{triskcaseList.queryFields.relativeTransAmt_min}" tabindex="1" styleClass="edit_input">
					<s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.relativeTransAmt_min']}" client="true" server="false" />
				</h:inputText>
				</h:panelGroup>
	</h:panelGrid>
	        <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">

				<h:outputLabel styleClass="fontnormal" for="relativeTransAmt_max" value="#{text['query.to']}" />				
				<h:panelGroup>
			    <h:inputText id="relativeTransAmt_max" value="#{triskcaseList.queryFields.relativeTransAmt_max}" tabindex="2" styleClass="edit_input">
					<s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.relativeTransAmt_max']}" client="true" server="false" />
				</h:inputText>
				</h:panelGroup>
	
			  </h:panelGrid>
			  

             <h:inputHidden/> 	
		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{triskcaseList.triskcase}" />
	<t:saveState value="#{triskcaseList.queryFields}" />
	<t:saveState id="triskcases" value="#{triskcaseList.triskcases}" />
	    <a4j:jsFunction name="deleteTriskcase" action="#{triskcaseList.delete}"  reRender="triskcasePanel,triskcases" oncomplete="rowIndexVarOfTriskcase = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTriskcase" action="#{triskcaseList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="triskcaseList"  style="display:none">
<script>
		var rowIndexVarOfTriskcase = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcase.t_riskcase_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="triskcasePanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseList.edit}"  onclick="if(rowIndexVarOfTriskcase == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase.2c908349169f7cda0116a3f490c703ba']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase/t_riskcase_form_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseList.view}" onclick="if(rowIndexVarOfTriskcase == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase.2c908349169f7cda0116a3f490d703bb']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase/t_riskcase_form_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTriskcase == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTriskcase();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase.2c908349169f7cda0116a3f490e703bc']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{triskcaseList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_riskcase.2c908349169f7cda0116a3f4906a03b9']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_riskcase/t_riskcase_form_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="triskcaseRowIndex" value="#{triskcaseList.rowIndex}"></h:inputHidden>
			<t:dataTable id="triskcaseDataTable" var="triskcase"
				value="#{triskcaseList.triskcases}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{triskcaseList.sortColumn}"
				sortAscending="#{triskcaseList.ascending}"
				binding="#{triskcaseList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTriskcase='#{rowIndexVar}';document.getElementById('triskcaseList:triskcaseRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="caseno" arrow="true">		                
							<h:outputText value="#{text['triskcase.caseno']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="caseno" value="#{triskcase.caseno}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mchntCd" arrow="true">		                
							<h:outputText value="#{text['triskcase.mchntCd']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="mchntCd" value="#{triskcase.mchntCd}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="beginDate" arrow="true">		                
							<h:outputText value="#{text['triskcase.beginDate']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="beginDate" value="#{triskcase.beginDate}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="endDate" arrow="true">		                
							<h:outputText value="#{text['triskcase.endDate']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="endDate" value="#{triskcase.endDate}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="belongToInst" arrow="true">		                
							<h:outputText value="#{text['triskcase.belongToInst']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="belongToInst" value="#{triskcase.belongToInst}">
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="relativeTransAmt" arrow="true">		                
							<h:outputText value="#{text['triskcase.relativeTransAmt']}" />
						</t:commandSortHeader>	
				</f:facet>
				 <h:outputText id="relativeTransAmt" value="#{triskcase.relativeTransAmt}" />
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>