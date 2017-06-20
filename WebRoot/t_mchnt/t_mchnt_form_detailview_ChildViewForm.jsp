<%@page import="java.util.*"%> 
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="cn.com.brilliance.begen.common.BeGenHistory"%>
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
<script>
var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;
</script>
</head>
<body onload="loadTmchnt();loadHidInfo();">
<center>
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>
try{
	parent.historyIframe.addHistory('/t_mchnt/t_mchnt_form_detailview_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','商户信息表(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntForm.tmchnt.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tmchntForm.tmchntPrimaryKey}" />
	<h:form id="tmchntForm" style="width:96%">
    	<f:verbatim><div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"></f:verbatim><h:outputText value="#{text['tmchnt.t_mchnt_form_detailview_ViewForm.heading']}" /><f:verbatim></a></li>
    	    </ul>
    	</div></f:verbatim>
	<a4j:jsFunction name="loadTmchnt" action="#{tmchntForm.loadTmchnt}" reRender="tmchntForm"></a4j:jsFunction>		
		<h:inputHidden id="forId"/>	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"><li></f:verbatim>
					<h:commandLink   onclick="window.close()">
						<f:verbatim><span class="linkClearImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.cancel']}"/>
					</h:commandLink>						
					<f:verbatim></li></ul></f:verbatim>
				</h:panelGroup>
			</h:panelGrid>	
						
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_mchnt_form_detailview.2c90834916f534a20116f6c3a4e40074']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="subinst" styleClass="outputlabel" value="#{text['tmchnt.subinst']}" />
				<be:outputText id="subinst" value="#{tmchntForm.tmchnt.subinst}">					
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="subinst" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="merchantno" styleClass="outputlabel" value="#{text['tmchnt.merchantno']}" />
				<h:outputText id="merchantno" value="#{tmchntForm.tmchnt.merchantno}" />
	            <h:inputHidden />
			    <x:message for="merchantno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="merchantcategory" styleClass="outputlabel" value="#{text['tmchnt.merchantcategory']}" />
				<h:outputLink id="merchantcategory_link" value="../t_mcc/t_mcc_ViewForm.faces?_key=#{tmchntForm.tmchnt.merchantcategory}">
    				<h:outputText id="merchantcategory" value="#{tmchntForm.tmchnt.merchantcategoryOfTmcc.id}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="merchantcategory" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="name" styleClass="outputlabel" value="#{text['tmchnt.name']}" />
				<h:outputText id="name" value="#{tmchntForm.tmchnt.name}" />
	            <h:inputHidden />
			    <x:message for="name" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="briefname" styleClass="outputlabel" value="#{text['tmchnt.briefname']}" />
				<h:outputText id="briefname" value="#{tmchntForm.tmchnt.briefname}" />
	            <h:inputHidden />
			    <x:message for="briefname" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="state" styleClass="outputlabel" value="#{text['tmchnt.state']}" />
				<h:outputText id="state" value="#{tmchntForm.tmchnt.state}" />
	            <h:inputHidden />
			    <x:message for="state" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="province" styleClass="outputlabel" value="#{text['tmchnt.province']}" />
				<h:outputText id="province" value="#{tmchntForm.tmchnt.province}" />
	            <h:inputHidden />
			    <x:message for="province" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="city" styleClass="outputlabel" value="#{text['tmchnt.city']}" />
				<h:outputText id="city" value="#{tmchntForm.tmchnt.city}" />
	            <h:inputHidden />
			    <x:message for="city" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="county" styleClass="outputlabel" value="#{text['tmchnt.county']}" />
				<h:outputText id="county" value="#{tmchntForm.tmchnt.county}" />
	            <h:inputHidden />
			    <x:message for="county" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="merchantnature" styleClass="outputlabel" value="#{text['tmchnt.merchantnature']}" />
				<h:outputText id="merchantnature" value="#{tmchntForm.tmchnt.merchantnature}" />
	            <h:inputHidden />
			    <x:message for="merchantnature" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="registerAddress" styleClass="outputlabel" value="#{text['tmchnt.registerAddress']}" />
				<h:outputText id="registerAddress" value="#{tmchntForm.tmchnt.registerAddress}" />
	            <h:inputHidden />
			    <x:message for="registerAddress" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="officeAddress" styleClass="outputlabel" value="#{text['tmchnt.officeAddress']}" />
			    <h:inputTextarea id="officeAddress" value="#{tmchntForm.tmchnt.officeAddress}" cols="20" rows="4" readonly="true" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="officeAddress" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="officeZipcode" styleClass="outputlabel" value="#{text['tmchnt.officeZipcode']}" />
				<h:outputText id="officeZipcode" value="#{tmchntForm.tmchnt.officeZipcode}" />
	            <h:inputHidden />
			    <x:message for="officeZipcode" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="licenseno" styleClass="outputlabel" value="#{text['tmchnt.licenseno']}" />
				<h:outputText id="licenseno" value="#{tmchntForm.tmchnt.licenseno}" />
	            <h:inputHidden />
			    <x:message for="licenseno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="taxno" styleClass="outputlabel" value="#{text['tmchnt.taxno']}" />
				<h:outputText id="taxno" value="#{tmchntForm.tmchnt.taxno}" />
	            <h:inputHidden />
			    <x:message for="taxno" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="licensedeadline" styleClass="outputlabel" value="#{text['tmchnt.licensedeadline']}" />
				<h:outputText id="licensedeadline" value="#{tmchntForm.tmchnt.licensedeadline}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="licensedeadline" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="withdrawinputdate" styleClass="outputlabel" value="#{text['tmchnt.withdrawinputdate']}" />
				<h:outputText id="withdrawinputdate" value="#{tmchntForm.tmchnt.withdrawinputdate}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="withdrawinputdate" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="withdrawcategory" styleClass="outputlabel" value="#{text['tmchnt.withdrawcategory']}" />
				<h:outputText id="withdrawcategory" value="#{tmchntForm.tmchnt.withdrawcategory}" />
	            <h:inputHidden />
			    <x:message for="withdrawcategory" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="withdrawoperator" styleClass="outputlabel" value="#{text['tmchnt.withdrawoperator']}" />
				<h:outputText id="withdrawoperator" value="#{tmchntForm.tmchnt.withdrawoperator}" />
	            <h:inputHidden />
			    <x:message for="withdrawoperator" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="legalman" styleClass="outputlabel" value="#{text['tmchnt.legalman']}" />
				<h:outputText id="legalman" value="#{tmchntForm.tmchnt.legalman}" />
	            <h:inputHidden />
			    <x:message for="legalman" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="idcardtype" styleClass="outputlabel" value="#{text['tmchnt.idcardtype']}" />
				<h:outputText id="idcardtype" value="#{tmchntForm.tmchnt.idcardtype}" />
	            <h:inputHidden />
			    <x:message for="idcardtype" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="idcardno" styleClass="outputlabel" value="#{text['tmchnt.idcardno']}" />
				<h:outputText id="idcardno" value="#{tmchntForm.tmchnt.idcardno}" />
	            <h:inputHidden />
			    <x:message for="idcardno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="contactperson" styleClass="outputlabel" value="#{text['tmchnt.contactperson']}" />
				<h:outputText id="contactperson" value="#{tmchntForm.tmchnt.contactperson}" />
	            <h:inputHidden />
			    <x:message for="contactperson" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="dept" styleClass="outputlabel" value="#{text['tmchnt.dept']}" />
				<h:outputText id="dept" value="#{tmchntForm.tmchnt.dept}" />
	            <h:inputHidden />
			    <x:message for="dept" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="tel" styleClass="outputlabel" value="#{text['tmchnt.tel']}" />
				<h:outputText id="tel" value="#{tmchntForm.tmchnt.tel}" />
	            <h:inputHidden />
			    <x:message for="tel" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mobtel" styleClass="outputlabel" value="#{text['tmchnt.mobtel']}" />
				<h:outputText id="mobtel" value="#{tmchntForm.tmchnt.mobtel}" />
	            <h:inputHidden />
			    <x:message for="mobtel" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="fax" styleClass="outputlabel" value="#{text['tmchnt.fax']}" />
				<h:outputText id="fax" value="#{tmchntForm.tmchnt.fax}" />
	            <h:inputHidden />
			    <x:message for="fax" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="email" styleClass="outputlabel" value="#{text['tmchnt.email']}" />
				<h:outputText id="email" value="#{tmchntForm.tmchnt.email}" />
	            <h:inputHidden />
			    <x:message for="email" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financeperson" styleClass="outputlabel" value="#{text['tmchnt.financeperson']}" />
				<h:outputText id="financeperson" value="#{tmchntForm.tmchnt.financeperson}" />
	            <h:inputHidden />
			    <x:message for="financeperson" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financetel" styleClass="outputlabel" value="#{text['tmchnt.financetel']}" />
				<h:outputText id="financetel" value="#{tmchntForm.tmchnt.financetel}" />
	            <h:inputHidden />
			    <x:message for="financetel" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financemotel" styleClass="outputlabel" value="#{text['tmchnt.financemotel']}" />
				<h:outputText id="financemotel" value="#{tmchntForm.tmchnt.financemotel}" />
	            <h:inputHidden />
			    <x:message for="financemotel" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financefax" styleClass="outputlabel" value="#{text['tmchnt.financefax']}" />
				<h:outputText id="financefax" value="#{tmchntForm.tmchnt.financefax}" />
	            <h:inputHidden />
			    <x:message for="financefax" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financeemail" styleClass="outputlabel" value="#{text['tmchnt.financeemail']}" />
				<h:outputText id="financeemail" value="#{tmchntForm.tmchnt.financeemail}" />
	            <h:inputHidden />
			    <x:message for="financeemail" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="foreigncard" styleClass="outputlabel" value="#{text['tmchnt.foreigncard']}" />
				<h:outputText id="foreigncard" value="#{tmchntForm.tmchnt.foreigncard}" />
	            <h:inputHidden />
			    <x:message for="foreigncard" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>
</f:view>
</center>
</body>	