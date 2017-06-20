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
<body onload="loadTriskcaseAttachments();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseAttachmentList.queryFields}" />
	<t:saveState id="triskcaseAttachments" value="#{triskcaseAttachmentList.triskcaseAttachments}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcaseAttachment.${listLayout.name}_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="triskcaseAttachmentList">
       <a4j:jsFunction name="loadTriskcaseAttachments" action="#{triskcaseAttachmentList.initTriskcaseAttachments}" reRender="triskcaseAttachmentList,triskcaseAttachments" oncomplete="checkLookupS()" />		
		<h:panelGrid  columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
					<f:verbatim><li></f:verbatim>	
					<h:commandLink onclick="window.close()">
					<f:verbatim><span class="linkCancelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.cancel']}" />
					</h:commandLink>	
					<f:verbatim></li></f:verbatim>	
			</h:panelGroup>
		 </h:panelGrid>
			<t:dataTable id="triskcaseAttachmentDataTable" var="triskcaseAttachment"
				value="#{triskcaseAttachmentList.triskcaseAttachments}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{triskcaseAttachmentList.sortColumn}"
				sortAscending="#{triskcaseAttachmentList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{triskcaseAttachmentList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{triskcaseAttachment.id}" />
					<h:inputHidden id="riskcaseId" value="#{triskcaseAttachment.riskcaseId}" />
					<h:inputHidden id="filename" value="#{triskcaseAttachment.filename}" />
					<h:inputHidden id="content" value="#{triskcaseAttachment.content}" />
					<h:inputHidden id="sortcode" value="#{triskcaseAttachment.sortcode}" />
					<h:inputHidden id="caseno" value="#{triskcaseAttachment.caseno}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseAttachment.riskcaseId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseAttachment.id}','#{triskcaseAttachment.id}')">					
						<h:outputText value="#{triskcaseAttachment.riskcaseId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseAttachment.filename']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseAttachment.id}','#{triskcaseAttachment.id}')">					
						<h:outputText value="#{triskcaseAttachment.filename}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseAttachment.content']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcaseAttachment.id}','#{triskcaseAttachment.id}')">					
						<h:outputText value="#{triskcaseAttachment.content}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>