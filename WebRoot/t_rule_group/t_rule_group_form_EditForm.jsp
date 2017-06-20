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
	<t:saveState value="#{truleGroupForm.truleGroupPrimaryKey}" />
	<t:saveState value="#{truleGroupForm.truleGroup}" />

	<h:form id="truleGroupForm" style="width:96%;">
    	<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['truleGroup.t_rule_group_form_EditForm.heading']}" /></a></li>
    	    </ul>
    	</div>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
		            <h:commandLink action="#{truleGroupForm.save}" tabindex="1" 
					  onclick=" if(!validateTruleGroupForm(document.getElementById('truleGroupForm')))return; ">
						<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionedit.t_rule_group_form.2c90834916d142fa0116d302afaa014a']}" />
					</h:commandLink>
<f:verbatim></li></f:verbatim>

	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
			</h:panelGrid>
			
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_rule_group_form.2c90834916d142fa0116d30cafa901da']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="belongToInst" styleClass="outputlabel" value="#{text['truleGroup.belongToInst']}" />
				<h:panelGroup>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>

	
                	<h:selectOneMenu id="belongToInst" value="#{truleGroupForm.truleGroup.belongToInst}"  style="width:'86%'" >
						  <f:selectItems value="#{selectItems.torganizeInfoItems}"/>
					</h:selectOneMenu>	
                   </h:panelGroup>						
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="belongToInst" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="enable" styleClass="outputlabel" value="#{text['truleGroup.enable']}" />
	           <h:panelGroup>
	             <f:verbatim><span class="mustw"></span></f:verbatim>
			        <h:selectBooleanCheckbox id="enable" value="#{truleGroupForm.truleGroup.enable}"  readonly="false"  tabindex="3">
					  <s:commonsValidator type="required" arg="#{text['truleGroup.enable']}" client="true" server="false" />
                    </h:selectBooleanCheckbox>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="enable" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="status" styleClass="outputlabel" value="#{text['truleGroup.status']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
				          <h:selectOneMenu id="status" value="#{truleGroupForm.truleGroup.status}"  readonly="false"  tabindex="4"  style="width:86%">
                            <f:selectItem itemLabel="#{text['truleGroup.status.0']}" itemValue="0"/>
                            <f:selectItem itemLabel="#{text['truleGroup.status.1']}" itemValue="1"/>
                            <f:selectItem itemLabel="#{text['truleGroup.status.2']}" itemValue="2"/>
                            <f:selectItem itemLabel="#{text['truleGroup.status.3']}" itemValue="3"/>
                            <f:selectItem itemLabel="#{text['truleGroup.status.4']}" itemValue="4"/>
                            <f:selectItem itemLabel="#{text['truleGroup.status.5']}" itemValue="5"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="status" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="description" styleClass="outputlabel" value="#{text['truleGroup.description']}" />
	           <h:panelGroup>
	             <f:verbatim><span class="mustw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="description" value="#{truleGroupForm.truleGroup.description}" rows="4" style="width:'86%';"   readonly="false" tabindex="5" styleClass="edit_textarea" >
					         <s:commonsValidator type="required" arg="#{text['truleGroup.description']}" client="true" server="false" />
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="description" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>
		</h:panelGrid>
		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	</h:form>
	<s:validatorScript functionName="validateTruleGroupForm" />
<%@ include file="../calculator.jsp"%>
</f:view>
</body>