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
	<t:saveState value="#{tbaseargForm.tbaseargPrimaryKey}" />
	<t:saveState value="#{tbaseargForm.tbasearg}" />

	<h:form id="tbaseargForm" style="width:96%;">
    	<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tbasearg.t_basearg_form_similarcard_EditForm.heading']}" /></a></li>
    	    </ul>
    	</div>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{tbaseargForm.saveSimilarCardTime}" tabindex="1" 
					  onclick=" if(!validateTbaseargForm(document.getElementById('tbaseargForm')))
					              {return false} 
					  			if (document.getElementById('tbaseargForm:param1').value=='') {
					  					alert('请填写时间');return false}
					  			if(isNaN(document.getElementById('tbaseargForm:param1').value)){
					  					alert('请输入数字'); return false}
					  			if ((document.getElementById('tbaseargForm:param1').value<2)||(document.getElementById('tbaseargForm:param1').value>4)){
					  					alert('输入的数字必须大于等于2小于等于4');return false}
					  			">
						<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionedit.t_basearg_form_similarcard.2c908349173e897b01173e9b9ec70039']}" />
					</h:commandLink>

<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
	            
    			</h:panelGroup>
			</h:panelGrid>
			
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="name" styleClass="outputlabel" value="#{text['tbasearg.name']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="name" value="#{tbaseargForm.tbasearg.name}" style="width:'86%'" tabindex="2"   maxlength="20"  styleClass="edit_input" disabled="true">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="name" styleClass="fieldError" />
			</h:panelGrid>
			
  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="param1" styleClass="outputlabel" value="#{text['tbasearg.similarCard']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="param1" value="#{tbaseargForm.tbasearg.param1}" style="width:'86%'" tabindex="5"   maxlength="20"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="param1" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


		</h:panelGrid>
		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	</h:form>
	<s:validatorScript functionName="validateTbaseargForm" />
<%@ include file="../calculator.jsp"%>
</f:view>
</body>