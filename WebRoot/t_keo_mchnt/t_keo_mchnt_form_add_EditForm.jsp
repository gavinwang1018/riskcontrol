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
	<t:saveState value="#{tkeoMchntForm.tkeoMchntPrimaryKey}" />
	<t:saveState value="#{tkeoMchntForm.tkeoMchnt}" />

	<h:form id="tkeoMchntForm" style="width:96%;">
    	<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tkeoMchnt.t_keo_mchnt_form_add_EditForm.heading']}" /></a></li>
    	    </ul>
    	</div>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
		            <h:commandLink action="#{tkeoMchntForm.save}" tabindex="1" 
					  onclick=" if(!validateTkeoMchntForm(document.getElementById('tkeoMchntForm')))return; ">
						<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionedit.t_keo_mchnt_form_add.2c90834916d142fa0116d17939b6001a']}" />
					</h:commandLink>
<f:verbatim></li></f:verbatim>

	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
			</h:panelGrid>
			
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_keo_mchnt_form_add.2c90834916d142fa0116d1793764000f']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="mchntCd" styleClass="outputlabel" value="#{text['tkeoMchnt.mchntCd']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="mchntCd" value="#{tkeoMchntForm.tkeoMchnt.mchntCd}" style="width:'86%'" tabindex="2"   maxlength="255"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="mchntCd" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="reason" styleClass="outputlabel" value="#{text['tkeoMchnt.reason']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="reason" value="#{tkeoMchntForm.tkeoMchnt.reason}" rows="4" style="width:'86%';"   readonly="false" tabindex="3" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="reason" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="mchntName" styleClass="outputlabel" value="#{text['tkeoMchnt.mchntName']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="mchntName" value="#{tkeoMchntForm.tkeoMchnt.mchntName}" style="width:'86%'" tabindex="4"   maxlength="255"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="mchntName" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="type" styleClass="outputlabel" value="#{text['tkeoMchnt.type']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
				          <h:selectOneMenu id="type" value="#{tkeoMchntForm.tkeoMchnt.type}"  readonly="false"  tabindex="5"  style="width:86%">
                            <f:selectItem itemLabel="#{text['tkeoMchnt.type.1']}" itemValue="1"/>
                            <f:selectItem itemLabel="#{text['tkeoMchnt.type.2']}" itemValue="2"/>
                            <f:selectItem itemLabel="#{text['tkeoMchnt.type.3']}" itemValue="3"/>
                            <f:selectItem itemLabel="#{text['tkeoMchnt.type.4']}" itemValue="4"/>
                            <f:selectItem itemLabel="#{text['tkeoMchnt.type.5']}" itemValue="5"/>
                            <f:selectItem itemLabel="#{text['tkeoMchnt.type.6']}" itemValue="6"/>
                            <f:selectItem itemLabel="#{text['tkeoMchnt.type.7']}" itemValue="7"/>
                            <f:selectItem itemLabel="#{text['tkeoMchnt.type.8']}" itemValue="8"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="type" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="belongToInst" styleClass="outputlabel" value="#{text['tkeoMchnt.belongToInst']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
				          <h:selectOneMenu id="belongToInst" value="#{tkeoMchntForm.tkeoMchnt.belongToInst}"  readonly="false"  tabindex="6"  style="width:86%">
                            <f:selectItems value="#{selectItems.belongToInstList}"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="belongToInst" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="settlementAccntNo" styleClass="outputlabel" value="#{text['tkeoMchnt.settlementAccntNo']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="settlementAccntNo" value="#{tkeoMchntForm.tkeoMchnt.settlementAccntNo}" rows="4" style="width:'86%';"   readonly="false" tabindex="7" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="settlementAccntNo" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="state" styleClass="outputlabel" value="#{text['tkeoMchnt.state']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="state" value="#{tkeoMchntForm.tkeoMchnt.state}" style="width:'86%'" tabindex="8"   maxlength="20"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="state" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="approvedDate" styleClass="outputlabel" value="#{text['tkeoMchnt.approvedDate']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:panelGroup>
			           <be:inputDate id="approvedDate" value="#{tkeoMchntForm.tkeoMchnt.approvedDate}" style="width:86%" tabindex="9"   styleClass="edit_input" >
					     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
		               </be:inputDate>
   			         </h:panelGroup>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="approvedDate" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="withdrawInputdate" styleClass="outputlabel" value="#{text['tkeoMchnt.withdrawInputdate']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:panelGroup>
			           <be:inputDate id="withdrawInputdate" value="#{tkeoMchntForm.tkeoMchnt.withdrawInputdate}" style="width:86%" tabindex="10"   styleClass="edit_input" >
					     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
		               </be:inputDate>
   			         </h:panelGroup>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="withdrawInputdate" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="mchntId" styleClass="outputlabel" value="#{text['tkeoMchnt.mchntId']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="mchntId" value="#{tkeoMchntForm.tkeoMchnt.mchntId}" rows="4" style="width:'86%';"   readonly="false" tabindex="11" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="mchntId" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>
		</h:panelGrid>
		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	</h:form>
	<s:validatorScript functionName="validateTkeoMchntForm" />
<%@ include file="../calculator.jsp"%>
</f:view>
</body>