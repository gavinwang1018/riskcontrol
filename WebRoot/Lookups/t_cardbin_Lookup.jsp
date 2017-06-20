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
<body onload="loadTcardbins();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tcardbinList.queryFields}" />
	<t:saveState id="tcardbins" value="#{tcardbinList.tcardbins}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tcardbin.t_cardbin_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="tcardbinList">
       <a4j:jsFunction name="loadTcardbins" action="#{tcardbinList.initTcardbins}" reRender="tcardbinList,tcardbins" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="tcardbinDataTable" var="tcardbin"
				value="#{tcardbinList.tcardbins}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{tcardbinList.sortColumn}"
				sortAscending="#{tcardbinList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{tcardbinList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{tcardbin.id}" />
					<h:inputHidden id="name" value="#{tcardbin.name}" />
					<h:inputHidden id="length" value="#{tcardbin.length}" />
					<h:inputHidden id="bin" value="#{tcardbin.bin}" />
					<h:inputHidden id="cupscard" value="#{tcardbin.cupscard}" />
					<h:inputHidden id="bank" value="#{tcardbin.bank}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tcardbin.name']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tcardbin.id}','#{tcardbin.id}')">					
						<h:outputText value="#{tcardbin.name}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tcardbin.length']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tcardbin.id}','#{tcardbin.id}')">					
						<h:outputText value="#{tcardbin.length}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tcardbin.bin']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tcardbin.id}','#{tcardbin.id}')">					
						<h:outputText value="#{tcardbin.bin}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tcardbin.cupscard']}" />
					</f:facet>
				<h:selectBooleanCheckbox id="cupscard1" value="#{tcardbin.cupscard}"  disabled="true"/>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tcardbin.bank']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tcardbin.id}','#{tcardbin.id}')">					
						<h:outputText value="#{tcardbin.bank}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>