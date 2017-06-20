<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%
String basePath = request.getContextPath();
javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().setLocale(cn.com.brilliance.begen.common.bundle.ResourceBundle.getLocale(request));
%>
<%@ include file="/common/taglibs.jsp"%>
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
</head>
<body onload="loadTriskprocessTimelimits();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<br>
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('triskprocessTimelimitQuery:searchtab')"><h:outputText value="#{text['triskprocessTimelimit.triskprocessTimelimitList.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>

	<h:form id="triskprocessTimelimitQuery">
		<a4j:jsFunction name="queryTriskprocessTimelimits" action="#{triskprocessTimelimitList.query}" reRender="triskprocessTimelimitList" />   		
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
					
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('triskprocessTimelimitQuery'));">
					<f:verbatim><span class="linkClearImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTriskprocessTimelimits();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		 
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent backColor"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="belongToInst" value="#{text['triskprocessTimelimit.belongToInst']}  #{text['query.equal']}" />

				<h:panelGroup>

	
	
					<h:inputText id="read_belongToInst" value="#{triskprocessTimelimitList.queryFields.belongToInstOfTorganizeInfo.name}" disabled="true" tabindex="1" styleClass="edit_input" /><h:inputHidden id="belongToInst" value="#{triskprocessTimelimitList.queryFields.belongToInst}" /><f:verbatim><span class="lookup_button" onmousedown="event.cancelBubble=true;showdiv(this,'t_organize_info_Lookup.faces','triskprocessTimelimitQuery','belongToInst','')"></span></f:verbatim>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="warnLevel" value="#{text['triskprocessTimelimit.warnLevel']}  #{text['query.equal']}" />

				<h:panelGroup>
				<h:selectOneMenu id="warnLevel" value="#{triskprocessTimelimitList.queryFields.warnLevel}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItem itemLabel="#{text['triskprocessTimelimit.warnLevel.ddd']}" itemValue="ddd"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>



		</h:panelGrid>			
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{triskprocessTimelimitList.queryFields}" />
	<t:saveState id="triskprocessTimelimits" value="#{triskprocessTimelimitList.triskprocessTimelimits}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskprocessTimelimit.t_riskprocess_timelimit_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="triskprocessTimelimitList">
       <a4j:jsFunction name="loadTriskprocessTimelimits" action="#{triskprocessTimelimitList.initTriskprocessTimelimits}" reRender="triskprocessTimelimitList,triskprocessTimelimits" oncomplete="checkLookupS()" />		
		<h:panelGrid  columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
					<f:verbatim><li></f:verbatim>	
					<h:commandLink onclick="window.close()">
					<f:verbatim><span class="linkClearImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.cancel']}" />
					</h:commandLink>	
					<f:verbatim></li></f:verbatim>	
			</h:panelGroup>
		 </h:panelGrid>
			<t:dataTable id="triskprocessTimelimitDataTable" var="triskprocessTimelimit"
				value="#{triskprocessTimelimitList.triskprocessTimelimits}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{triskprocessTimelimitList.sortColumn}"
				sortAscending="#{triskprocessTimelimitList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{triskprocessTimelimitList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="belongToInst" value="#{triskprocessTimelimit.belongToInst}" />
					<h:inputHidden id="warnLevel" value="#{triskprocessTimelimit.warnLevel}" />
					<h:inputHidden id="timeLimit" value="#{triskprocessTimelimit.timeLimit}" />
					<h:inputHidden id="id" value="#{triskprocessTimelimit.id}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskprocessTimelimit.belongToInst']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskprocessTimelimit.id}','#{triskprocessTimelimit.id}')">					
						<h:outputText value="#{triskprocessTimelimit.belongToInst}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskprocessTimelimit.warnLevel']}" />
					</f:facet>
				<be:outputText id="warnLevel1" value="#{triskprocessTimelimit.warnLevel}">
                   <f:selectItem itemLabel="#{text['triskprocessTimelimit.warnLevel.ddd']}" itemValue="ddd"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskprocessTimelimit.timeLimit']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskprocessTimelimit.id}','#{triskprocessTimelimit.id}')">					
						<h:outputText value="#{triskprocessTimelimit.timeLimit}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>