<%@ include file="/common/taglibs.jsp"%>

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage" %>
<%
String basePath = request.getContextPath();
javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().setLocale(cn.com.brilliance.begen.common.bundle.ResourceBundle.getLocale(request));

%>

<head>
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/config.css" />
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/right.css" />
<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>

<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/calculator.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/edit.js"></script>
<script>
var imagePath = "<%=basePath%>/images";
var scriptPath = "<%=basePath%>/scripts";
</script>
</head>
<body onload="loadHidInfo();getDateObj();loadDateSelect();">
<center>
<input type="hidden" name="checkcontent" id="checkcontent">
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>

	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{torganizeUserForm.torganizeUserPrimaryKey}" />
	<t:saveState value="#{torganizeUserForm.torganizeUser}" />

	<h:form id="torganizeUserForm" style="width:96%;">
    	<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['torganizeUser.t_organize_user_EditForm.heading']}" /></a></li>
    	    </ul>
    	</div>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
		            <h:commandLink action="#{torganizeUserForm.save}" tabindex="1" 
					  onclick=" if(!validateTorganizeUserForm(document.getElementById('torganizeUserForm')))return; ">
						<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionedit.t_organize_user.2c90834916d142fa0116d2e8ffdc0043']}" />
					</h:commandLink>
<f:verbatim></li></f:verbatim>

	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
			</h:panelGrid>
			
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_organize_user.2c90834916d142fa0116d2e8ff4f003f']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="organizeId" styleClass="outputlabel" value="#{text['torganizeUser.organizeId']}" />
				<h:panelGroup>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>

	
                	<h:selectOneMenu id="organizeId" value="#{torganizeUserForm.torganizeUser.organizeId}"  style="width:'86%'" >
						  <f:selectItems value="#{selectItems.torganizeInfoItems}"/>
					</h:selectOneMenu>	
                   </h:panelGroup>						
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="organizeId" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="userId" styleClass="outputlabel" value="#{text['torganizeUser.userId']}" />
				<h:panelGroup>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>

	
                	<h:selectOneMenu id="userId" value="#{torganizeUserForm.torganizeUser.userId}"  style="width:'86%'" >
						  <f:selectItems value="#{selectItems.tuserInfoItems}"/>
					</h:selectOneMenu>	
                   </h:panelGroup>						
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="userId" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="type" styleClass="outputlabel" value="#{text['torganizeUser.type']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:selectBooleanCheckbox id="type" value="#{torganizeUserForm.torganizeUser.type}"  readonly="false"  tabindex="4">
                    </h:selectBooleanCheckbox>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="type" styleClass="fieldError" />
			</h:panelGrid>
			

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>
		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	</h:form>
	<s:validatorScript functionName="validateTorganizeUserForm" />
<%@ include file="../calculator.jsp"%>
</f:view>
</body>