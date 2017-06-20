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
	<t:saveState value="#{triskcaseForm.triskcasePrimaryKey}" />
	<t:saveState value="#{triskcaseForm.triskcase}" />

	<h:form id="triskcaseForm" style="width:96%;">
    	<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcase.t_riskcase_form_EditForm.heading']}" /></a></li>
    	    </ul>
    	</div>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
			</h:panelGrid>
			
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_form.2c90834917143e52011715cb60bb0146']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="caseno" styleClass="outputlabel" value="#{text['triskcase.caseno']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="caseno" value="#{triskcaseForm.triskcase.caseno}" style="width:'86%'" tabindex="1"   maxlength="12"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="caseno" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="otherno" styleClass="outputlabel" value="#{text['triskcase.otherno']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="otherno" value="#{triskcaseForm.triskcase.otherno}" style="width:'86%'" tabindex="2"   maxlength="20"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="otherno" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="createdate" styleClass="outputlabel" value="#{text['triskcase.createdate']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:panelGroup>
			           <be:inputDate id="createdate" value="#{triskcaseForm.triskcase.createdate}" style="width:86%" tabindex="3"   styleClass="edit_input" >
					     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
		               </be:inputDate>
   			         </h:panelGroup>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="createdate" styleClass="fieldError" />
			</h:panelGrid>
			

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_form.2c90834917143e52011715cb6129014a']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="beginDate" styleClass="outputlabel" value="#{text['triskcase.beginDate']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:panelGroup>
			           <be:inputDate id="beginDate" value="#{triskcaseForm.triskcase.beginDate}" style="width:86%" tabindex="4"   styleClass="edit_input" >
					     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
		               </be:inputDate>
   			         </h:panelGroup>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="beginDate" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="endDate" styleClass="outputlabel" value="#{text['triskcase.endDate']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:panelGroup>
			           <be:inputDate id="endDate" value="#{triskcaseForm.triskcase.endDate}" style="width:86%" tabindex="5"   styleClass="edit_input" >
					     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
		               </be:inputDate>
   			         </h:panelGroup>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="endDate" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="allTransAmt" styleClass="outputlabel" value="#{text['triskcase.allTransAmt']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
				    <h:inputText id="allTransAmt" value="#{triskcaseForm.triskcase.allTransAmt}" styleClass="edit_input" style="width:'86%'" tabindex="6" >
					   <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.allTransAmt']}" client="true" server="false" />
				     </h:inputText><f:verbatim>(元)</f:verbatim>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="allTransAmt" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="allTransNum" styleClass="outputlabel" value="#{text['triskcase.allTransNum']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <be:inputNumber id="allTransNum" value="#{triskcaseForm.triskcase.allTransNum}"  style="width:'86%'"   tabindex="7" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.allTransNum']}" client="true" server="false" />
				      </be:inputNumber>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="allTransNum" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="score" styleClass="outputlabel" value="#{text['triskcase.score']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <h:inputText id="score" value="#{triskcaseForm.triskcase.score}"  style="width:'86%'"   tabindex="8" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.score']}" client="true" server="false" />
				      </h:inputText><f:verbatim>(元)</f:verbatim>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="score" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="triggerRuleNum" styleClass="outputlabel" value="#{text['triskcase.triggerRuleNum']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <be:inputNumber id="triggerRuleNum" value="#{triskcaseForm.triskcase.triggerRuleNum}"  style="width:'86%'"   tabindex="9" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.triggerRuleNum']}" client="true" server="false" />
				      </be:inputNumber>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="triggerRuleNum" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="mchntCd" styleClass="outputlabel" value="#{text['triskcase.mchntCd']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="mchntCd" value="#{triskcaseForm.triskcase.mchntCd}" style="width:'86%'" tabindex="10"   maxlength="15"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="mchntCd" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="mchntName" styleClass="outputlabel" value="#{text['triskcase.mchntName']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="mchntName" value="#{triskcaseForm.triskcase.mchntName}" style="width:'86%'" tabindex="11"   maxlength="255"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="mchntName" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="mchntMcc" styleClass="outputlabel" value="#{text['triskcase.mchntMcc']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="mchntMcc" value="#{triskcaseForm.triskcase.mchntMcc}" style="width:'86%'" tabindex="12"   maxlength="20"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="mchntMcc" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="transMcc" styleClass="outputlabel" value="#{text['triskcase.transMcc']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="transMcc" value="#{triskcaseForm.triskcase.transMcc}" style="width:'86%'" tabindex="13"   maxlength="20"  styleClass="edit_input" >

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="transMcc" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="relativeTransAmt" styleClass="outputlabel" value="#{text['triskcase.relativeTransAmt']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
				    <h:inputText id="relativeTransAmt" value="#{triskcaseForm.triskcase.relativeTransAmt}" styleClass="edit_input" style="width:'86%'" tabindex="14" >
					   <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.relativeTransAmt']}" client="true" server="false" />
				     </h:inputText><f:verbatim>(元)</f:verbatim>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="relativeTransAmt" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="relativeTransNum" styleClass="outputlabel" value="#{text['triskcase.relativeTransNum']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <be:inputNumber id="relativeTransNum" value="#{triskcaseForm.triskcase.relativeTransNum}"  style="width:'86%'"   tabindex="15" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.relativeTransNum']}" client="true" server="false" />
				      </be:inputNumber>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="relativeTransNum" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="belongToInst" styleClass="outputlabel" value="#{text['triskcase.belongToInst']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="belongToInst" value="#{triskcaseForm.triskcase.belongToInst}"  readonly="false"  tabindex="16"  style="width:86%" >
                            <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="belongToInst" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="submit2Inst" styleClass="outputlabel" value="#{text['triskcase.submit2Inst']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="submit2Inst" value="#{triskcaseForm.triskcase.submit2Inst}"  readonly="false"  tabindex="17"  style="width:86%" >
                            <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="submit2Inst" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="acquireInstName" styleClass="outputlabel" value="#{text['triskcase.acquireInstName']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="acquireInstName" value="#{triskcaseForm.triskcase.acquireInstName}"  readonly="false"  tabindex="18"  style="width:86%" >
                            <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="acquireInstName" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="warnLevel" styleClass="outputlabel" value="#{text['triskcase.warnLevel']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="warnLevel" value="#{triskcaseForm.triskcase.warnLevel}"  readonly="false"  tabindex="19"  style="width:86%" >
                            <f:selectItem itemLabel="#{text['triskcase.warnLevel.0']}" itemValue="0"/>
                            <f:selectItem itemLabel="#{text['triskcase.warnLevel.1']}" itemValue="1"/>
                            <f:selectItem itemLabel="#{text['triskcase.warnLevel.2']}" itemValue="2"/>
                            <f:selectItem itemLabel="#{text['triskcase.warnLevel.3']}" itemValue="3"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="warnLevel" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="processLimit" styleClass="outputlabel" value="#{text['triskcase.processLimit']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:panelGroup>
			           <be:inputDate id="processLimit" value="#{triskcaseForm.triskcase.processLimit}" style="width:86%" tabindex="20"   styleClass="edit_input" >
					     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
		               </be:inputDate>
   			         </h:panelGroup>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="processLimit" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="status" styleClass="outputlabel" value="#{text['triskcase.status']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
		
				          <h:selectOneMenu id="status" value="#{triskcaseForm.triskcase.status}"  readonly="false"  tabindex="21"  style="width:86%" >
                            <f:selectItem itemLabel="#{text['triskcase.status.0']}" itemValue="0"/>
                            <f:selectItem itemLabel="#{text['triskcase.status.1']}" itemValue="1"/>
                            <f:selectItem itemLabel="#{text['triskcase.status.2']}" itemValue="2"/>
                            <f:selectItem itemLabel="#{text['triskcase.status.3']}" itemValue="3"/>
                            <f:selectItem itemLabel="#{text['triskcase.status.4']}" itemValue="4"/>
                            <f:selectItem itemLabel="#{text['triskcase.status.5']}" itemValue="5"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="status" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="beenUrgent" styleClass="outputlabel" value="#{text['triskcase.beenUrgent']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:selectBooleanCheckbox id="beenUrgent" value="#{triskcaseForm.triskcase.beenUrgent}"  readonly="false"  tabindex="22">
                    </h:selectBooleanCheckbox>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="beenUrgent" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="urgentCnt" styleClass="outputlabel" value="#{text['triskcase.urgentCnt']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			          <be:inputNumber id="urgentCnt" value="#{triskcaseForm.triskcase.urgentCnt}"  style="width:'86%'"   tabindex="23" styleClass="edit_input">
					    <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.urgentCnt']}" client="true" server="false" />
				      </be:inputNumber>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="urgentCnt" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="trace" styleClass="outputlabel" value="#{text['triskcase.trace']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:selectBooleanCheckbox id="trace" value="#{triskcaseForm.triskcase.trace}"  readonly="false"  tabindex="24">
                    </h:selectBooleanCheckbox>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="trace" styleClass="fieldError" />
			</h:panelGrid>
			

  

				<h:outputText value="" />
  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="triggerContent" styleClass="outputlabel" value="#{text['triskcase.triggerContent']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="triggerContent" value="#{triskcaseForm.triskcase.triggerContent}" rows="4" style="width:'86%';"   readonly="false" tabindex="25" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="triggerContent" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="riskContent" styleClass="outputlabel" value="#{text['triskcase.riskContent']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="riskContent" value="#{triskcaseForm.triskcase.riskContent}" rows="4" style="width:'86%';"   readonly="false" tabindex="26" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="riskContent" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="comments1" styleClass="outputlabel" value="#{text['triskcase.comments1']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="comments1" value="#{triskcaseForm.triskcase.comments1}" rows="4" style="width:'86%';"   readonly="false" tabindex="27" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="comments1" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="comments2" styleClass="outputlabel" value="#{text['triskcase.comments2']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="comments2" value="#{triskcaseForm.triskcase.comments2}" rows="4" style="width:'86%';"   readonly="false" tabindex="28" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="comments2" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="comments3" styleClass="outputlabel" value="#{text['triskcase.comments3']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="comments3" value="#{triskcaseForm.triskcase.comments3}" rows="4" style="width:'86%';"   readonly="false" tabindex="29" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="comments3" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="comments4" styleClass="outputlabel" value="#{text['triskcase.comments4']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="comments4" value="#{triskcaseForm.triskcase.comments4}" rows="4" style="width:'86%';"   readonly="false" tabindex="30" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="comments4" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="comments5" styleClass="outputlabel" value="#{text['triskcase.comments5']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="comments5" value="#{triskcaseForm.triskcase.comments5}" rows="4" style="width:'86%';"   readonly="false" tabindex="31" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="comments5" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>
		</h:panelGrid>
		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	</h:form>
	<s:validatorScript functionName="validateTriskcaseForm" />
<%@ include file="../calculator.jsp"%>
</f:view>
</body>