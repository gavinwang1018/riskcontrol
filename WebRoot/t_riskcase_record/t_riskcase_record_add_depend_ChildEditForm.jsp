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
<body onload="loadTriskcaseRecord();getDateObj();">
<center>
<input type="hidden" name="checkcontent" id="checkcontent">
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>

	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseRecordForm.triskcaseRecordPrimaryKey}" />
	<t:saveState value="#{triskcaseRecordForm.triskcaseRecord}" />

	<h:form id="triskcaseRecordForm" style="width:96%;">
	<div class="mytab1">
	    <ul class="myTabBar1">
	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcaseRecord.t_riskcase_record_add_depend_EditForm.heading']}" /></a></li>
	    </ul>
	</div>
	<a4j:jsFunction name="loadTriskcaseRecord" action="#{triskcaseRecordForm.loadTriskcaseRecord}" reRender="triskcaseRecordForm" oncomplete="loadDateSelect()"></a4j:jsFunction>
    	<f:verbatim><div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"></f:verbatim><h:outputText value="#{text['triskcaseRecord.t_riskcase_record_add_depend_EditForm.heading']}" /><f:verbatim></a></li>
    	    </ul>
    	</div>
		</f:verbatim>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>?


		     <f:verbatim><li></f:verbatim>
		      <h:commandLink action="#{triskcaseRecordForm.popSave}" tabindex="1"  onclick="  if(!validateTriskcaseRecordForm(document.getElementById('triskcaseRecordForm')))return; ">
					<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionedit.t_riskcase_record_add_depend.2c908349173e897b01173f029c70008e']}"/>
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
				<h:outputText value="#{text['section.t_riskcase_record_add_depend.2c9083491781cf8f01178ac088dd00c9']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="caseno" styleClass="outputlabel" value="#{text['triskcaseRecord.caseno']}" />
				<h:panelGroup>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>

	
					<h:outputText id="caseno" value="#{triskcaseRecordForm.triskcaseRecord.caseno}" 
						title="#{triskcaseRecordForm.triskcaseRecord.casenoOfTriskcase.id}" />	
                   </h:panelGroup>						
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="caseno" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="investigationDate" styleClass="outputlabel" value="#{text['triskcaseRecord.investigationDate']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:panelGroup>
			           <be:inputDate id="investigationDate" value="#{triskcaseRecordForm.triskcaseRecord.investigationDate}" style="width:86%" tabindex="3"   styleClass="edit_input" >
					     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
		               </be:inputDate>
   			         </h:panelGroup>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="investigationDate" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_record_add_depend.2c9083491781cf8f01178ac08b4e00cc']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="investigationWay" styleClass="outputlabel" value="#{text['triskcaseRecord.investigationWay']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="investigationWay" value="#{triskcaseRecordForm.triskcaseRecord.investigationWay}"  readonly="false"  tabindex="4"  style="width:86%" >
                            <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.0']}" itemValue="0"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.1']}" itemValue="1"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.2']}" itemValue="2"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.3']}" itemValue="3"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="investigationWay" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="otherInvestigationWay" styleClass="outputlabel" value="#{text['triskcaseRecord.otherInvestigationWay']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="otherInvestigationWay" value="#{triskcaseRecordForm.triskcaseRecord.otherInvestigationWay}" style="width:'86%'" tabindex="5"   maxlength="255"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="otherInvestigationWay" styleClass="fieldError" />
			</h:panelGrid>
			

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_record_add_depend.2c9083491781cf8f01178ac08b8c00cf']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="isPickFlow" styleClass="outputlabel" value="#{text['triskcaseRecord.isPickFlow']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:selectBooleanCheckbox id="isPickFlow" value="#{triskcaseRecordForm.triskcaseRecord.isPickFlow}"  readonly="false"  tabindex="6">
                    </h:selectBooleanCheckbox>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="isPickFlow" styleClass="fieldError" />
			</h:panelGrid>
			

  

				<h:outputText value="" />
  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="pickCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickCnt']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <be:inputNumber id="pickCnt" value="#{triskcaseRecordForm.triskcaseRecord.pickCnt}"  style="width:'86%'"   tabindex="7" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcaseRecord.pickCnt']}" client="true" server="false" />
				      </be:inputNumber>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="pickCnt" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="pickAmt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickAmt']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
				    <be:inputAmount id="pickAmt" value="#{triskcaseRecordForm.triskcaseRecord.pickAmt}" styleClass="edit_input" style="width:'86%'" tabindex="8" >
					   <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcaseRecord.pickAmt']}" client="true" server="false" />
				     </be:inputAmount>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="pickAmt" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="pick180Cnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pick180Cnt']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <be:inputNumber id="pick180Cnt" value="#{triskcaseRecordForm.triskcaseRecord.pick180Cnt}"  style="width:'86%'"   tabindex="9" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcaseRecord.pick180Cnt']}" client="true" server="false" />
				      </be:inputNumber>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="pick180Cnt" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="pick180Amt" styleClass="outputlabel" value="#{text['triskcaseRecord.pick180Amt']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
				    <be:inputAmount id="pick180Amt" value="#{triskcaseRecordForm.triskcaseRecord.pick180Amt}" styleClass="edit_input" style="width:'86%'" tabindex="10" >
					   <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcaseRecord.pick180Amt']}" client="true" server="false" />
				     </be:inputAmount>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="pick180Amt" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="pickStatus" styleClass="outputlabel" value="#{text['triskcaseRecord.pickStatus']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="pickStatus" value="#{triskcaseRecordForm.triskcaseRecord.pickStatus}"  readonly="false"  tabindex="11"  style="width:86%" >
                            <f:selectItem itemLabel="#{text['triskcaseRecord.pickStatus.0']}" itemValue="0"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.pickStatus.1']}" itemValue="1"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.pickStatus.2']}" itemValue="2"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="pickStatus" styleClass="fieldError" />
			</h:panelGrid>
			

  

				<h:outputText value="" />
  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="pickFlawCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickFlawCnt']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <be:inputNumber id="pickFlawCnt" value="#{triskcaseRecordForm.triskcaseRecord.pickFlawCnt}"  style="width:'86%'"   tabindex="12" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcaseRecord.pickFlawCnt']}" client="true" server="false" />
				      </be:inputNumber>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="pickFlawCnt" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="pickEmptyCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickEmptyCnt']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <be:inputNumber id="pickEmptyCnt" value="#{triskcaseRecordForm.triskcaseRecord.pickEmptyCnt}"  style="width:'86%'"   tabindex="13" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcaseRecord.pickEmptyCnt']}" client="true" server="false" />
				      </be:inputNumber>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="pickEmptyCnt" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_record_add_depend.2c9083491781cf8f01178ac08c7700d8']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="investigationResult" styleClass="outputlabel" value="#{text['triskcaseRecord.investigationResult']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="investigationResult" value="#{triskcaseRecordForm.triskcaseRecord.investigationResult}"  readonly="false"  tabindex="14"  style="width:86%" >
                            <f:selectItem itemLabel="#{text['triskcaseRecord.investigationResult.1']}" itemValue="1"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.investigationResult.0']}" itemValue="0"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="investigationResult" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="riskLevel" styleClass="outputlabel" value="#{text['triskcaseRecord.riskLevel']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="riskLevel" value="#{triskcaseRecordForm.triskcaseRecord.riskLevel}"  readonly="false"  tabindex="15"  style="width:86%" >
                            <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.0']}" itemValue="0"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.1']}" itemValue="1"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.2']}" itemValue="2"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.3']}" itemValue="3"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="riskLevel" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="riskType" styleClass="outputlabel" value="#{text['triskcaseRecord.riskType']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="riskType" value="#{triskcaseRecordForm.triskcaseRecord.riskType}"  readonly="false"  tabindex="16"  style="width:86%" >
                            <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.0']}" itemValue="0"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.1']}" itemValue="1"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.2']}" itemValue="2"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.3']}" itemValue="3"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.4']}" itemValue="4"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="riskType" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="otherRiskType" styleClass="outputlabel" value="#{text['triskcaseRecord.otherRiskType']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="otherRiskType" value="#{triskcaseRecordForm.triskcaseRecord.otherRiskType}" style="width:'86%'" tabindex="17"   maxlength="255"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="otherRiskType" styleClass="fieldError" />
			</h:panelGrid>
			

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_record_add_depend.2c9083491781cf8f01178ac08d6100dd']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="processType" styleClass="outputlabel" value="#{text['triskcaseRecord.processType']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="processType" value="#{triskcaseRecordForm.triskcaseRecord.processType}"  readonly="false"  tabindex="18"  style="width:86%" >
                            <f:selectItem itemLabel="#{text['triskcaseRecord.processType.00']}" itemValue="00"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.processType.01']}" itemValue="01"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.processType.10']}" itemValue="10"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.processType.11']}" itemValue="11"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.processType.12']}" itemValue="12"/>
                            <f:selectItem itemLabel="#{text['triskcaseRecord.processType.13']}" itemValue="13"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="processType" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="processFreezeAmt" styleClass="outputlabel" value="#{text['triskcaseRecord.processFreezeAmt']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <be:inputNumber id="processFreezeAmt" value="#{triskcaseRecordForm.triskcaseRecord.processFreezeAmt}"  style="width:'86%'"   tabindex="19" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcaseRecord.processFreezeAmt']}" client="true" server="false" />
				      </be:inputNumber>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="processFreezeAmt" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="processWithdrawCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.processWithdrawCnt']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <be:inputNumber id="processWithdrawCnt" value="#{triskcaseRecordForm.triskcaseRecord.processWithdrawCnt}"  style="width:'86%'"   tabindex="20" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcaseRecord.processWithdrawCnt']}" client="true" server="false" />
				      </be:inputNumber>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="processWithdrawCnt" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="otherProcessType" styleClass="outputlabel" value="#{text['triskcaseRecord.otherProcessType']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="otherProcessType" value="#{triskcaseRecordForm.triskcaseRecord.otherProcessType}" style="width:'86%'" tabindex="21"   maxlength="255"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="otherProcessType" styleClass="fieldError" />
			</h:panelGrid>
			

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_record_add_depend.2c9083491781cf8f01178ac08dde00e2']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="description" styleClass="outputlabel" value="#{text['triskcaseRecord.description']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="description" value="#{triskcaseRecordForm.triskcaseRecord.description}" rows="4" style="width:'86%';"   readonly="false" tabindex="22" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="description" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	</h:form>
	<s:validatorScript functionName="validateTriskcaseRecordForm" />	
<%@ include file="../calculator.jsp"%>
</f:view>
</center>
</body>