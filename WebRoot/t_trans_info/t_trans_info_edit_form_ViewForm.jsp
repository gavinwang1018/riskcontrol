<%@page import="java.util.*"%> 
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="cn.com.brilliance.begen.common.BeGenHistory"%>
<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage" %>
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
</head>
<body onload="loadHidInfo();">	

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
		<f:loadBundle var="text" basename="ApplicationResources" />
<script language=javascript>
try{
	parent.historyIframe.addHistory('/t_trans_info/t_trans_info_edit_form_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{ttransInfoForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="ttransInfo.t_trans_info_edit_form_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{ttransInfoForm.ttransInfo.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'ttransInfoForm');"><a href="#"><h:outputText value="#{text['ttransInfo.t_trans_info_edit_form_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{ttransInfoForm.ttransInfoPrimaryKey}" />
	<h:form id="ttransInfoForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{ttransInfoForm.edit}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_trans_info_edit_form.2c90834917aea6a90117afaff7c1007a']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_trans_info/t_trans_info_edit_form_EditForm.faces?_key=#{ttransInfoForm.ttransInfo.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{ttransInfoForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_trans_info_edit_form.2c90834917aea6a90117afaff7e0007b']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_trans_info_edit_form.2c90834917afeeb10117b032e92d0012']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="settleDt" styleClass="outputlabel" value="#{text['ttransInfo.settleDt']}" />
				<h:outputText id="settleDt" value="#{ttransInfoForm.ttransInfo.settleDt}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="settleDt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="sysTraNo" styleClass="outputlabel" value="#{text['ttransInfo.sysTraNo']}" />
				<h:outputText id="sysTraNo" value="#{ttransInfoForm.ttransInfo.sysTraNo}" />
	            <h:inputHidden />
			    <x:message for="sysTraNo" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="respCd4" styleClass="outputlabel" value="#{text['ttransInfo.respCd4']}" />
				<h:outputText id="respCd4" value="#{ttransInfoForm.ttransInfo.respCd4}" />
	            <h:inputHidden />
			    <x:message for="respCd4" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="transId" styleClass="outputlabel" value="#{text['ttransInfo.transId']}" />
				<h:outputText id="transId" value="#{ttransInfoForm.ttransInfo.transId}" />
	            <h:inputHidden />
			    <x:message for="transId" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="settleIn" styleClass="outputlabel" value="#{text['ttransInfo.settleIn']}" />
				<h:outputText id="settleIn" value="#{ttransInfoForm.ttransInfo.settleIn}" />
	            <h:inputHidden />
			    <x:message for="settleIn" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="transAt" styleClass="outputlabel" value="#{text['ttransInfo.transAt']}" />
				<h:outputText id="transAt" value="#{ttransInfoForm.ttransInfo.transAt}" />
	            <h:inputHidden />
			    <x:message for="transAt" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="msgTp" styleClass="outputlabel" value="#{text['ttransInfo.msgTp']}" />
				<h:outputText id="msgTp" value="#{ttransInfoForm.ttransInfo.msgTp}" />
	            <h:inputHidden />
			    <x:message for="msgTp" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="locTransDtTm" styleClass="outputlabel" value="#{text['ttransInfo.locTransDtTm']}" />
				<h:outputText id="locTransDtTm" value="#{ttransInfoForm.ttransInfo.locTransDtTm}" />
	            <h:inputHidden />
			    <x:message for="locTransDtTm" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mchntTp" styleClass="outputlabel" value="#{text['ttransInfo.mchntTp']}" />
				<h:outputText id="mchntTp" value="#{ttransInfoForm.ttransInfo.mchntTp}" />
	            <h:inputHidden />
			    <x:message for="mchntTp" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="retriRefNo" styleClass="outputlabel" value="#{text['ttransInfo.retriRefNo']}" />
				<h:outputText id="retriRefNo" value="#{ttransInfoForm.ttransInfo.retriRefNo}" />
	            <h:inputHidden />
			    <x:message for="retriRefNo" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="priAcctNo" styleClass="outputlabel" value="#{text['ttransInfo.priAcctNo']}" />
				<h:outputText id="priAcctNo" value="#{ttransInfoForm.ttransInfo.priAcctNo}" />
	            <h:inputHidden />
			    <x:message for="priAcctNo" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="bin" styleClass="outputlabel" value="#{text['ttransInfo.bin']}" />
				<h:outputText id="bin" value="#{ttransInfoForm.ttransInfo.bin}" />
	            <h:inputHidden />
			    <x:message for="bin" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="cardAttr" styleClass="outputlabel" value="#{text['ttransInfo.cardAttr']}" />
				<h:outputText id="cardAttr" value="#{ttransInfoForm.ttransInfo.cardAttr}" />
	            <h:inputHidden />
			    <x:message for="cardAttr" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="cardMedia" styleClass="outputlabel" value="#{text['ttransInfo.cardMedia']}" />
				<h:outputText id="cardMedia" value="#{ttransInfoForm.ttransInfo.cardMedia}" />
	            <h:inputHidden />
			    <x:message for="cardMedia" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="termId" styleClass="outputlabel" value="#{text['ttransInfo.termId']}" />
				<h:outputText id="termId" value="#{ttransInfoForm.ttransInfo.termId}" />
	            <h:inputHidden />
			    <x:message for="termId" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mchntCd" styleClass="outputlabel" value="#{text['ttransInfo.mchntCd']}" />
				<h:outputText id="mchntCd" value="#{ttransInfoForm.ttransInfo.mchntCd}" />
	            <h:inputHidden />
			    <x:message for="mchntCd" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="cardAccptrNmLoc" styleClass="outputlabel" value="#{text['ttransInfo.cardAccptrNmLoc']}" />
				<h:outputText id="cardAccptrNmLoc" value="#{ttransInfoForm.ttransInfo.cardAccptrNmLoc}" />
	            <h:inputHidden />
			    <x:message for="cardAccptrNmLoc" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="acqInsIdCd" styleClass="outputlabel" value="#{text['ttransInfo.acqInsIdCd']}" />
				<h:outputText id="acqInsIdCd" value="#{ttransInfoForm.ttransInfo.acqInsIdCd}" />
	            <h:inputHidden />
			    <x:message for="acqInsIdCd" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="fwdInsIdCd" styleClass="outputlabel" value="#{text['ttransInfo.fwdInsIdCd']}" />
				<h:outputText id="fwdInsIdCd" value="#{ttransInfoForm.ttransInfo.fwdInsIdCd}" />
	            <h:inputHidden />
			    <x:message for="fwdInsIdCd" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="rcvInsIdCd" styleClass="outputlabel" value="#{text['ttransInfo.rcvInsIdCd']}" />
				<h:outputText id="rcvInsIdCd" value="#{ttransInfoForm.ttransInfo.rcvInsIdCd}" />
	            <h:inputHidden />
			    <x:message for="rcvInsIdCd" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="issInsIdCd" styleClass="outputlabel" value="#{text['ttransInfo.issInsIdCd']}" />
				<h:outputText id="issInsIdCd" value="#{ttransInfoForm.ttransInfo.issInsIdCd}" />
	            <h:inputHidden />
			    <x:message for="issInsIdCd" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="origSysTraNo" styleClass="outputlabel" value="#{text['ttransInfo.origSysTraNo']}" />
				<h:outputText id="origSysTraNo" value="#{ttransInfoForm.ttransInfo.origSysTraNo}" />
	            <h:inputHidden />
			    <x:message for="origSysTraNo" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="origTransmsnDtTm" styleClass="outputlabel" value="#{text['ttransInfo.origTransmsnDtTm']}" />
				<h:outputText id="origTransmsnDtTm" value="#{ttransInfoForm.ttransInfo.origTransmsnDtTm}" />
	            <h:inputHidden />
			    <x:message for="origTransmsnDtTm" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="rsnCd" styleClass="outputlabel" value="#{text['ttransInfo.rsnCd']}" />
				<h:outputText id="rsnCd" value="#{ttransInfoForm.ttransInfo.rsnCd}" />
	            <h:inputHidden />
			    <x:message for="rsnCd" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="authDt" styleClass="outputlabel" value="#{text['ttransInfo.authDt']}" />
				<h:outputText id="authDt" value="#{ttransInfoForm.ttransInfo.authDt}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="authDt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="authIdRespCd" styleClass="outputlabel" value="#{text['ttransInfo.authIdRespCd']}" />
				<h:outputText id="authIdRespCd" value="#{ttransInfoForm.ttransInfo.authIdRespCd}" />
	            <h:inputHidden />
			    <x:message for="authIdRespCd" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="posEntryMdCd" styleClass="outputlabel" value="#{text['ttransInfo.posEntryMdCd']}" />
				<h:outputText id="posEntryMdCd" value="#{ttransInfoForm.ttransInfo.posEntryMdCd}" />
	            <h:inputHidden />
			    <x:message for="posEntryMdCd" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="posCondCd" styleClass="outputlabel" value="#{text['ttransInfo.posCondCd']}" />
				<h:outputText id="posCondCd" value="#{ttransInfoForm.ttransInfo.posCondCd}" />
	            <h:inputHidden />
			    <x:message for="posCondCd" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="procCd" styleClass="outputlabel" value="#{text['ttransInfo.procCd']}" />
				<h:outputText id="procCd" value="#{ttransInfoForm.ttransInfo.procCd}" />
	            <h:inputHidden />
			    <x:message for="procCd" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="settleYm" styleClass="outputlabel" value="#{text['ttransInfo.settleYm']}" />
				<h:outputText id="settleYm" value="#{ttransInfoForm.ttransInfo.settleYm}" />
	            <h:inputHidden />
			    <x:message for="settleYm" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="fwdInsIdOriginal" styleClass="outputlabel" value="#{text['ttransInfo.fwdInsIdOriginal']}" />
				<h:outputText id="fwdInsIdOriginal" value="#{ttransInfoForm.ttransInfo.fwdInsIdOriginal}" />
	            <h:inputHidden />
			    <x:message for="fwdInsIdOriginal" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>

	
</f:view>
</body>	