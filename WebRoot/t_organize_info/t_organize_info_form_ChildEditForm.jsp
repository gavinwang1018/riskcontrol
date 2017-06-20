<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
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
var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;
</script>
</head>
<body onload="loadTorganizeInfo();getDateObj();">
<center>
<input type="hidden" name="checkcontent" id="checkcontent">
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>

	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{torganizeInfoForm.torganizeInfoPrimaryKey}" />
	<t:saveState value="#{torganizeInfoForm.torganizeInfo}" />

	<h:form id="torganizeInfoForm" style="width:96%;">
	<div class="mytab1">
	    <ul class="myTabBar1">
	      <li class="Selected"><a href="#"><h:outputText value="#{text['torganizeInfo.t_organize_info_form_EditForm.heading']}" /></a></li>
	    </ul>
	</div>
	<a4j:jsFunction name="loadTorganizeInfo" action="#{torganizeInfoForm.loadTorganizeInfo}" reRender="torganizeInfoForm" oncomplete="loadDateSelect()"></a4j:jsFunction>
    	<f:verbatim><div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"></f:verbatim><h:outputText value="#{text['torganizeInfo.t_organize_info_form_EditForm.heading']}" /><f:verbatim></a></li>
    	    </ul>
    	</div>
		</f:verbatim>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>?


		     <f:verbatim><li></f:verbatim>
		      <h:commandLink action="#{torganizeInfoForm.popSave}" tabindex="1"  onclick="  if(!validateTorganizeInfoForm(document.getElementById('torganizeInfoForm')))return; ">
					<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionedit.t_organize_info_form.2c90834916ad22cb0116ad8b74700010']}"/>
					</h:commandLink>
					<f:verbatim></li></f:verbatim>
			<f:verbatim><li></f:verbatim>
					<h:commandLink onclick="window.close()" >
					<f:verbatim><span class="linkCancelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.cancel']}" />				
					</h:commandLink>
				<f:verbatim></li></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
			
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_organize_info_form.2c908349173e897b01173e8e42100006']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="name" styleClass="outputlabel" value="#{text['torganizeInfo.name']}" />
	           <h:panelGroup>
	             <f:verbatim><span class="mustw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="name" value="#{torganizeInfoForm.torganizeInfo.name}" style="width:'86%'" tabindex="2"   maxlength="255"  styleClass="edit_input" >

				           <s:commonsValidator type="required" arg="#{text['torganizeInfo.name']}" client="true" server="false" />
				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="name" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="dwFlag" styleClass="outputlabel" value="#{text['torganizeInfo.dwFlag']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:selectBooleanCheckbox id="dwFlag" value="#{torganizeInfoForm.torganizeInfo.dwFlag}"  readonly="false"  tabindex="3">
                    </h:selectBooleanCheckbox>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="dwFlag" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="fwdInsIdCd" styleClass="outputlabel" value="#{text['torganizeInfo.fwdInsIdCd']}" />
	           <h:panelGroup>
	             <f:verbatim><span class="mustw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="fwdInsIdCd" value="#{torganizeInfoForm.torganizeInfo.fwdInsIdCd}" style="width:'86%'" tabindex="4"   maxlength="13"  styleClass="edit_input" >

				           <s:commonsValidator type="required" arg="#{text['torganizeInfo.fwdInsIdCd']}" client="true" server="false" />
				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="fwdInsIdCd" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="parentId" styleClass="outputlabel" value="#{text['torganizeInfo.parentId']}" />
				<h:panelGroup>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>

	
                	<h:selectOneMenu id="parentId" value="#{torganizeInfoForm.torganizeInfo.parentId}"  style="width:'86%'" >
						  <f:selectItems value="#{selectItems.torganizeInfoItems}"/>
					</h:selectOneMenu>	
                   </h:panelGroup>						
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="parentId" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="globalSort" styleClass="outputlabel" value="#{text['torganizeInfo.globalSort']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="globalSort" value="#{torganizeInfoForm.torganizeInfo.globalSort}" rows="4" style="width:'86%';"   readonly="false" tabindex="6" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="globalSort" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="originalSort" styleClass="outputlabel" value="#{text['torganizeInfo.originalSort']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="originalSort" value="#{torganizeInfoForm.torganizeInfo.originalSort}" rows="4" style="width:'86%';"   readonly="false" tabindex="7" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="originalSort" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="organizeBm" styleClass="outputlabel" value="#{text['torganizeInfo.organizeBm']}" />
	           <h:panelGroup>
	             <f:verbatim><span class="mustw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="organizeBm" value="#{torganizeInfoForm.torganizeInfo.organizeBm}" style="width:'86%'" tabindex="8"   maxlength="20"  styleClass="edit_input" >

				           <s:commonsValidator type="required" arg="#{text['torganizeInfo.organizeBm']}" client="true" server="false" />
				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="organizeBm" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="organizeLevel" styleClass="outputlabel" value="#{text['torganizeInfo.organizeLevel']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <be:inputNumber id="organizeLevel" value="#{torganizeInfoForm.torganizeInfo.organizeLevel}"  style="width:'86%'"   tabindex="9" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['torganizeInfo.organizeLevel']}" client="true" server="false" />
				      </be:inputNumber>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="organizeLevel" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="isCheck" styleClass="outputlabel" value="#{text['torganizeInfo.isCheck']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="isCheck" value="#{torganizeInfoForm.torganizeInfo.isCheck}"  readonly="false"  tabindex="10"  style="width:86%" >
                            <f:selectItem itemLabel="#{text['torganizeInfo.isCheck.0']}" itemValue="0"/>
                            <f:selectItem itemLabel="#{text['torganizeInfo.isCheck.1']}" itemValue="1"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="isCheck" styleClass="fieldError" />
			</h:panelGrid>
			

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	</h:form>
	<s:validatorScript functionName="validateTorganizeInfoForm" />	
<%@ include file="../calculator.jsp"%>
</f:view>
</center>
</body>