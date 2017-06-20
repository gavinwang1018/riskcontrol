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
<body onload="loadTriskcases();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

function compareDate() {
	var str1 = document.getElementById("triskcaseQuery:processLimit_min").value;
	var str2 = document.getElementById("triskcaseQuery:processLimit_max").value;
	d1 = new Date(str1.replace("-","/"));
	d2 = new Date(str2.replace("-","/"));
	if(Date.parse(d1) - Date.parse(d2) > 0) {
		return true;
	}
	return false;
}

function compareDateOfCreate() {
	var str1 = document.getElementById("triskcaseQuery:createdate_min").value;
	var str2 = document.getElementById("triskcaseQuery:createdate_max").value;
	d1 = new Date(str1.replace("-","/"));
	d2 = new Date(str2.replace("-","/"));
	if(Date.parse(d1) - Date.parse(d2) > 0) {
		alert('生成日期的结束时间不能小于起始时间!');
		return true;
	}
	return false;
}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('triskcaseQuery:searchtab')"><h:outputText value="#{text['triskcase.triskcaseQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="triskcaseQuery" >
		<a4j:jsFunction name="queryTriskcases" action="#{triskcaseList.queryByInst}" reRender="triskcasePanel,triskcases" oncomplete="document.getElementById('triskcaseList').style.display='block';parent.dyniframesize('mainFrame')" />   
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
				<h:commandLink  onclick="if(compareDate()) {return false;} else if(compareDateOfCreate()) {return false;}else{queryTriskcases();return false;}">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 

	             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
			    <h:outputLabel styleClass="fontnormal" for="processLimit_min" value="#{text['triskcase.processLimit']}  #{text['query.from']}" />						
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="processLimit_min" value="#{triskcaseList.queryFields.processLimit_min}" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
	</h:panelGrid>
	        <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">

				<h:outputLabel styleClass="fontnormal" for="processLimit_max" value="#{text['query.to']}" />				
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="processLimit_max" value="#{triskcaseList.queryFields.processLimit_max}" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
	
			  </h:panelGrid>
			  
	             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
			    <h:outputLabel styleClass="fontnormal" for="createdate_min" value="#{text['triskcase.createdate']}  #{text['query.from']}" />						
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="createdate_min" value="#{triskcaseList.queryFields.createdate_min}" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
	</h:panelGrid>
	        <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">

				<h:outputLabel styleClass="fontnormal" for="createdate_max" value="#{text['query.to']}" />				
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="createdate_max" value="#{triskcaseList.queryFields.createdate_max}" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
	
			  </h:panelGrid>	
			  
	             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
			    <h:outputLabel styleClass="fontnormal" for="beginDate" value="#{text['triskcase.beginDate']}  #{text['query.equal']}" />						
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="beginDate" value="#{triskcaseList.queryFields.beginDate}" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
	</h:panelGrid>
	        <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">

				<h:outputLabel styleClass="fontnormal" for="endDate" value="#{text['triskcase.endDate']}  #{text['query.equal']}" />				
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="endDate" value="#{triskcaseList.queryFields.endDate}" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
	
			  </h:panelGrid>				  


             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="status" value="#{text['triskcase.status']}  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="status" value="#{triskcaseList.queryFields.status}">
                   <f:selectItem itemLabel="#{text['triskcase.status.2']}" itemValue="2"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="backCnt" value="#{text['triskcase.backCnt']} #{text['query.equal']}" />				
				<h:panelGroup>
				<h:inputText id="backCnt" value="#{triskcaseList.queryFields.backCnt}" />
				</h:panelGroup>
			  </h:panelGrid>
			  
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="warnLevel" value="#{text['triskcase.warnLevel']} #{text['query.equal']}" />				
				<h:panelGroup>
				          <h:selectOneMenu id="warnLevel" value="#{triskcaseList.queryFields.warnLevel}"  readonly="false"  tabindex="19"  style="width:86%" >
				          <f:selectItem itemLabel="------" itemValue=""/>
                            <f:selectItem itemLabel="#{text['triskcase.warnLevel.0']}" itemValue="0"/>
                            <f:selectItem itemLabel="#{text['triskcase.warnLevel.1']}" itemValue="1"/>
                            <f:selectItem itemLabel="#{text['triskcase.warnLevel.2']}" itemValue="2"/>
                            <f:selectItem itemLabel="#{text['triskcase.warnLevel.3']}" itemValue="3"/>
				          </h:selectOneMenu >	
				</h:panelGroup>
			  </h:panelGrid>	
			  
			  
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="urgentCnt" value="#{text['triskcase.urgentCnt']} >=" />				
				<h:panelGroup>
				<h:inputText id="urgentCnt" value="#{triskcaseList.queryFields.urgentCnt}" />
				</h:panelGroup>
			  </h:panelGrid>				  		  
			  
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="casefrom" value="#{text['triskcase.casefrom']} #{text['query.equal']}" />				
				<h:panelGroup>
				          <h:selectOneMenu id="casefrom" value="#{triskcaseList.queryFields.casefrom}"  readonly="false"  tabindex="19"  style="width:86%" >
				          <f:selectItem itemLabel="------" itemValue=""/>
                            <f:selectItem itemLabel="#{text['triskcase.casefrom.1']}" itemValue="1"/>
                            <f:selectItem itemLabel="#{text['triskcase.casefrom.2']}" itemValue="2"/>
                            <f:selectItem itemLabel="#{text['triskcase.casefrom.3']}" itemValue="3"/>
                            <f:selectItem itemLabel="#{text['triskcase.casefrom.4']}" itemValue="4"/>
                            <f:selectItem itemLabel="#{text['triskcase.casefrom.5']}" itemValue="5"/>
                            <f:selectItem itemLabel="#{text['triskcase.casefrom.6']}" itemValue="6"/>
				          </h:selectOneMenu >	
				</h:panelGroup>
			  </h:panelGrid>		
			  
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="caseno" value="#{text['triskcase.caseno']} #{text['query.equal']}" />				
				<h:panelGroup>
						<h:inputText id="caseno" value="#{triskcaseList.queryFields.caseno}" />
				</h:panelGroup>
			  </h:panelGrid>				  	
			  
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="mchntCd" value="#{text['triskcase.mchntCd']} #{text['query.equal']}" />				
				<h:panelGroup>
						<h:inputText id="mchntCd" value="#{triskcaseList.queryFields.mchntCd}" />
				</h:panelGroup>
			  </h:panelGrid>	
			  
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="mchntName" value="#{text['triskcase.mchntName']} #{text['query.like']}" />				
				<h:panelGroup>
						<h:inputText id="mchntName" value="#{triskcaseList.queryFields.mchntName}" />
				</h:panelGroup>
			  </h:panelGrid>		
			  
			  
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="bigMccName" value="商户行业类别 #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="bigMccName" value="#{triskcaseList.queryFields.bigMccName}">
					<a4j:support event="onchange" action="#{triskcaseList.getTransMcc}" reRender="transMcc" />
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItems value="#{triskcaseList.bigMccNameList}"/>
				</h:selectOneMenu >	
				</h:panelGroup>
			  </h:panelGrid>				  		  	
			  
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="transMcc" value="#{text['triskcase.transMcc']} #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="transMcc" value="#{triskcaseList.queryFields.transMcc}">
                  	<f:selectItems value="#{triskcaseList.tmccItems}"/>
				</h:selectOneMenu >	
				</h:panelGroup>
			  </h:panelGrid>			

             <h:inputHidden/> 	
		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>	
	<t:saveState value="#{triskcaseList.triskcase}" />
	<t:saveState value="#{triskcaseList.queryFields}" />
	<t:saveState value="#{triskcaseList.saveQueryFiellds}" />
	<a4j:jsFunction name="addTriskcase" action="#{triskcaseList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="triskcaseList"  >
	<a4j:jsFunction name="loadTriskcases" action="#{triskcaseList.initTriskcases}" reRender="triskcasePanel,triskcases" />
<script>
		var rowIndexVarOfTriskcase = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcase.t_riskcase_form_makeing_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="triskcasePanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseList.view}" onclick="if(rowIndexVarOfTriskcase == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="处理" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase/t_riskcase_form_makeing_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseList.downLoadExcel}"  >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="导出Excel文件" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="triskcaseRowIndex" value="#{triskcaseList.rowIndex}"></h:inputHidden>
			<t:dataTable id="triskcaseDataTable" var="triskcase"
				value="#{triskcaseList.triskcases}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="20"
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
						<t:commandSortHeader columnName="casefrom" arrow="true">		                
							<h:outputText value="#{text['triskcase.casefrom']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="casefrom" value="#{triskcase.casefrom}">
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.5']}" itemValue="5"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.6']}" itemValue="6"/>
				</be:outputText>
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
						<t:commandSortHeader columnName="mchntName" arrow="true">		                
							<h:outputText value="#{text['triskcase.mchntName']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="mchntName" value="#{triskcase.mchntName}" />
				</t:column>	
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mchntType" arrow="true">		                
							<h:outputText value="商户行业类别" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="mchntType" value="#{triskcase.mchntType}">
				</be:outputText>				
				</t:column>					
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="transMcc" arrow="true">		                
							<h:outputText value="#{text['triskcase.transMcc']}" />
						</t:commandSortHeader>	
				</f:facet>
					<be:outputText id="transMcc" value="#{triskcase.transMcc}">
	                   <f:selectItems value="#{extSelectItems.tmccListItems}"/>
					</be:outputText>
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
						<t:commandSortHeader columnName="submit2Inst" arrow="true">		                
							<h:outputText value="#{text['triskcase.submit2Inst']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="submit2Inst" value="#{triskcase.submit2Inst}">
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</be:outputText>
				</t:column>				

				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="createdate" arrow="true">		                
							<h:outputText value="#{text['triskcase.createdate']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="createdate" value="#{triskcase.createdate}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
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
						<t:commandSortHeader columnName="relativeTransAmt" arrow="true">		                
							<h:outputText value="#{text['triskcase.relativeTransAmt']}" />
						</t:commandSortHeader>	
				</f:facet>
				 <h:outputText id="relativeTransAmt" value="#{triskcase.relativeTransAmt}" >
				 	<f:convertNumber  minFractionDigits="2" />
				 </h:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="relativeTransNum" arrow="true">		                
							<h:outputText value="#{text['triskcase.relativeTransNum']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="relativeTransNum" value="#{triskcase.relativeTransNum}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="warnLevel" arrow="true">		                
							<h:outputText value="#{text['triskcase.warnLevel']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="warnLevel" value="#{triskcase.warnLevel}">
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.3']}" itemValue="3"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="triggerRuleNum" arrow="true">		                
							<h:outputText value="#{text['triskcase.triggerRuleNum']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="triggerRuleNum" value="#{triskcase.triggerRuleNum}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="urgentCnt" arrow="true">		                
							<h:outputText value="#{text['triskcase.beenUrgent']}" />
						</t:commandSortHeader>	
				</f:facet>
					<h:selectBooleanCheckbox id="beenUrgent" value="#{triskcase.beenUrgent}" disabled="true"/> 
				</t:column>					
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="urgentCnt" arrow="true">		                
							<h:outputText value="#{text['triskcase.urgentCnt']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="urgentCnt" value="#{triskcase.urgentCnt}" style="color:red" rendered="#{triskcase.urgentCnt != 0}">
                   <f:selectItems value="#{extSelectItems.urgentTimes}"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="processLimit" arrow="true">		                
							<h:outputText value="#{text['triskcase.processLimit']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="processLimit" value="#{triskcase.processLimit}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="status" arrow="true">		                
							<h:outputText value="#{text['triskcase.status']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="status" value="#{triskcase.status}">
                   <f:selectItem itemLabel="#{text['triskcase.status.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcase.status.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.status.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.status.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['triskcase.status.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['triskcase.status.5']}" itemValue="5"/>
                   <f:selectItem itemLabel="#{text['triskcase.status.6']}" itemValue="6"/>
				</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="backCnt" arrow="true">		                
							<h:outputText value="#{text['triskcase.backCnt']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="backCnt" value="#{triskcase.backCnt}" style="color:red" rendered="#{triskcase.backCnt != 0}">
                   <f:selectItems value="#{extSelectItems.backCntItems}"/>
				</be:outputText>
				</t:column>
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="triskcase_scroll_1" 
                    for="triskcaseDataTable"
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
            <t:dataScroller id="triskcase_scroll_2" 
                    for="triskcaseDataTable"
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
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseList.view}" onclick="if(rowIndexVarOfTriskcase == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="处理" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase/t_riskcase_form_makeing_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseList.downLoadExcel}"  >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="导出Excel文件" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>                       
            </h:panelGrid>

		</h:panelGrid>

	</h:form>
</f:view>
</body>