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
	parent.historyIframe.addHistory('/t_riskcase_record/t_riskcase_record_add_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseRecordForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="triskcaseRecord.t_riskcase_record_add_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseRecordForm.triskcaseRecord.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'triskcaseRecordForm');"><a href="#"><h:outputText value="#{text['triskcaseRecord.t_riskcase_record_add_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{triskcaseRecordForm.triskcaseRecordPrimaryKey}" />
	<t:saveState value="#{triskcaseRecordForm.queryFields}" />
	<h:form id="triskcaseRecordForm" >

		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">

			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" style="">
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{triskcaseRecordForm.edit}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_riskcase_record_add.2c90834916e5db4a0116e6169a4d005a']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_riskcase_record/t_riskcase_record_add_EditForm.faces?_key=#{triskcaseRecordForm.triskcaseRecord.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{triskcaseRecordForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_riskcase_record_add.2c90834916e5db4a0116e6169a6c005b']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
		            <h:commandLink action="#{triskcaseRecordForm.back}" >
						<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="取消" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase/t_riskcase_form_makeing_ViewForm" />						
					</h:commandLink>
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink onclick="window.open('../PrintViewServlet?id=#{triskcaseRecordForm.triskcaseRecord.id}','_self','');return false">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="打印预览" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_form_makeing.2c90834916f039110116f11f26340051']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="casefrom" styleClass="outputlabel" value="#{text['triskcase.casefrom']}" />
				<be:outputText id="casefrom" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.casefrom}">					
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.5']}" itemValue="5"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.6']}" itemValue="6"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="casefrom" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="otherno" styleClass="outputlabel" value="#{text['triskcase.otherno']}" />
				<h:outputText id="otherno" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.otherno}" />
	            <h:inputHidden />
			    <x:message for="otherno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="warnLevel" styleClass="outputlabel" value="#{text['triskcase.warnLevel']}" />
				<be:outputText id="warnLevel" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.warnLevel}">					
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.3']}" itemValue="3"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="warnLevel" styleClass="fieldError" />
			</h:panelGrid>
  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mchntName" styleClass="outputlabel" value="#{text['triskcase.mchntName']}" />
				<h:outputText id="mchntName" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.mchntName}" />
	            <h:inputHidden />
			    <x:message for="mchntName" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="transMcc" styleClass="outputlabel" value="#{text['triskcase.transMcc']}" />
				<be:outputText id="transMcc" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.transMcc}" >
					<f:selectItems value="#{selectItems.tmccItems}"/>
				</be:outputText>
	            <h:inputHidden />
			    <x:message for="transMcc" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mchntMcc" styleClass="outputlabel" value="#{text['triskcase.mchntMcc']}" />
				<be:outputText id="mchntMcc" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.mchntMcc}" >
					<f:selectItems value="#{selectItems.tmccItems}"/>
				</be:outputText>
	            <h:inputHidden />
			    <x:message for="mchntMcc" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="acquireInstName" styleClass="outputlabel" value="#{text['triskcase.acquireInstName']}" />
				<be:outputText id="acquireInstName" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.acquireInstName}">					
                   <f:selectItems value="#{selectItems.torganizeInfoItems}"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="acquireInstName" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mchntCd" styleClass="outputlabel" value="#{text['triskcase.mchntCd']}" />
				<h:outputText id="mchntCd" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.mchntCd}" />
	            <h:inputHidden />
			    <x:message for="mchntCd" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="relativeTransNum" styleClass="outputlabel" value="#{text['triskcase.relativeTransNum']}" />
				<h:outputText id="relativeTransNum" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.relativeTransNum}" />
	            <h:inputHidden />
			    <x:message for="relativeTransNum" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="relativeTransAmt" styleClass="outputlabel" value="#{text['triskcase.relativeTransAmt']}(元)" />
				<h:outputText id="relativeTransAmt" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.relativeTransAmt}" >
					<f:convertNumber  minFractionDigits="2" />
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="relativeTransAmt" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="belongToInst" styleClass="outputlabel" value="#{text['triskcase.belongToInst']}" />
				<be:outputText id="belongToInst" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.belongToInst}">					
                   <f:selectItems value="#{selectItems.torganizeInfoItems}"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="belongToInst" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="processLimit" styleClass="outputlabel" value="#{text['triskcase.processLimit']}" />
				<h:outputText id="processLimit" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.processLimit}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="processLimit" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="triggerContent" styleClass="outputlabel" value="#{text['triskcase.triggerContent']}" />
			    <h:outputText id="triggerContent" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.triggerContent}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="triggerContent" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="riskContent" styleClass="outputlabel" value="#{text['triskcase.riskContent']}" />
			    <h:outputText id="riskContent" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.riskContent}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="riskContent" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments1" styleClass="outputlabel" value="#{text['triskcase.comments1']}" />
			    <h:outputText id="comments1" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.comments1}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments1" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments2" styleClass="outputlabel" value="#{text['triskcase.comments2']}" />
			    <h:outputText id="comments2" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.comments2}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments2" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments3" styleClass="outputlabel" value="#{text['triskcase.comments3']}" />
			    <h:outputText id="comments3" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.comments3}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments3" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments4" styleClass="outputlabel" value="#{text['triskcase.comments4']}" />
			    <h:outputText id="comments4" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.comments4}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments4" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments5" styleClass="outputlabel" value="#{text['triskcase.comments5']}" />
			    <h:outputText id="comments5" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.comments5}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments5" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
  			
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments6" styleClass="outputlabel" value="#{text['triskcase.comments6']}" />
			    <h:outputText id="comments6" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.comments6}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments6" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>  		
  			
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments7" styleClass="outputlabel" value="#{text['triskcase.comments7']}" />
			    <h:outputText id="comments7" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.comments7}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments7" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>  
  			
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments8" styleClass="outputlabel" value="#{text['triskcase.comments8']}" />
			    <h:outputText id="comments8" value="#{triskcaseRecordForm.triskcaseRecord.riskcaseIdOfTriskcase.comments8}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments8" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>    			  				
		</h:panelGrid>
		
<div class="mytab1">
<ul class="myTabBar1"  id="listUl">
<LI class="Selected"><a href="#"><h:outputText value="商户/终端信息" /></a></LI>
</ul>
</div>			
		
<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_mchnt_form_detailview.2c90834916f534a20116f6c3a4e40074']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="subinst" styleClass="outputlabel" value="#{text['tmchnt.subinst']}" />
				<be:outputText id="subinst" value="#{triskcaseRecordForm.tmchnt.belongToSubinst.name}">					
                  
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="subinst" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="merchantno" styleClass="outputlabel" value="#{text['tmchnt.merchantno']}" />
				<h:outputText id="merchantno" value="#{triskcaseRecordForm.tmchnt.merchantno}" />
	            <h:inputHidden />
			    <x:message for="merchantno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="merchantcategory" styleClass="outputlabel" value="#{text['tmchnt.merchantcategory']}" />
				
				<be:outputText id="merchantcategory" value="#{triskcaseRecordForm.tmchnt.merchantcategory}">
                   <f:selectItems value="#{extSelectItems.tmccIdsOfTmccs}"/>
				</be:outputText>
	            <h:inputHidden />
			    <x:message for="merchantcategory" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="name" styleClass="outputlabel" value="#{text['tmchnt.name']}" />
				<h:outputText id="name" value="#{triskcaseRecordForm.tmchnt.name}" />
	            <h:inputHidden />
			    <x:message for="name" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="briefname" styleClass="outputlabel" value="#{text['tmchnt.briefname']}" />
				<h:outputText id="briefname" value="#{triskcaseRecordForm.tmchnt.briefname}" />
	            <h:inputHidden />
			    <x:message for="briefname" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="state" styleClass="outputlabel" value="#{text['tmchnt.state']}" />
				<h:outputText id="state" value="#{triskcaseRecordForm.tmchnt.state}" />
	            <h:inputHidden />
			    <x:message for="state" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="province" styleClass="outputlabel" value="#{text['tmchnt.province']}" />
				<h:outputText id="province" value="#{triskcaseRecordForm.tmchnt.province}" />
	            <h:inputHidden />
			    <x:message for="province" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="city" styleClass="outputlabel" value="#{text['tmchnt.city']}" />
				<h:outputText id="city" value="#{triskcaseRecordForm.tmchnt.city}" />
	            <h:inputHidden />
			    <x:message for="city" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="county" styleClass="outputlabel" value="#{text['tmchnt.county']}" />
				<h:outputText id="county" value="#{triskcaseRecordForm.tmchnt.county}" />
	            <h:inputHidden />
			    <x:message for="county" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="merchantnature" styleClass="outputlabel" value="#{text['tmchnt.merchantnature']}" />
				<h:outputText id="merchantnature" value="#{triskcaseRecordForm.tmchnt.merchantnature}" />
	            <h:inputHidden />
			    <x:message for="merchantnature" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="registerAddress" styleClass="outputlabel" value="#{text['tmchnt.registerAddress']}" />
				<h:outputText id="registerAddress" value="#{triskcaseRecordForm.tmchnt.registerAddress}" />
	            <h:inputHidden />
			    <x:message for="registerAddress" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="officeAddress" styleClass="outputlabel" value="#{text['tmchnt.officeAddress']}" />
			    <h:outputText id="officeAddress" value="#{triskcaseRecordForm.tmchnt.officeAddress}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="officeAddress" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="officeZipcode" styleClass="outputlabel" value="#{text['tmchnt.officeZipcode']}" />
				<h:outputText id="officeZipcode" value="#{triskcaseRecordForm.tmchnt.officeZipcode}" />
	            <h:inputHidden />
			    <x:message for="officeZipcode" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="licenseno" styleClass="outputlabel" value="#{text['tmchnt.licenseno']}" />
				<h:outputText id="licenseno" value="#{triskcaseRecordForm.tmchnt.licenseno}" />
	            <h:inputHidden />
			    <x:message for="licenseno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="taxno" styleClass="outputlabel" value="#{text['tmchnt.taxno']}" />
				<h:outputText id="taxno" value="#{triskcaseRecordForm.tmchnt.taxno}" />
	            <h:inputHidden />
			    <x:message for="taxno" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="licensedeadline" styleClass="outputlabel" value="#{text['tmchnt.licensedeadline']}" />
				<h:outputText id="licensedeadline" value="#{triskcaseRecordForm.tmchnt.licensedeadline}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="licensedeadline" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="withdrawinputdate" styleClass="outputlabel" value="#{text['tmchnt.withdrawinputdate']}" />
				<h:outputText id="withdrawinputdate" value="#{triskcaseRecordForm.tmchnt.withdrawinputdate}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="withdrawinputdate" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="withdrawcategory" styleClass="outputlabel" value="#{text['tmchnt.withdrawcategory']}" />
				<h:outputText id="withdrawcategory" value="#{triskcaseRecordForm.tmchnt.withdrawcategory}" />
	            <h:inputHidden />
			    <x:message for="withdrawcategory" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="withdrawoperator" styleClass="outputlabel" value="#{text['tmchnt.withdrawoperator']}" />
				<h:outputText id="withdrawoperator" value="#{triskcaseRecordForm.tmchnt.withdrawoperator}" />
	            <h:inputHidden />
			    <x:message for="withdrawoperator" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="legalman" styleClass="outputlabel" value="#{text['tmchnt.legalman']}" />
				<h:outputText id="legalman" value="#{triskcaseRecordForm.tmchnt.legalman}" />
	            <h:inputHidden />
			    <x:message for="legalman" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="idcardtype" styleClass="outputlabel" value="#{text['tmchnt.idcardtype']}" />
				<h:outputText id="idcardtype" value="#{triskcaseRecordForm.tmchnt.idcardtype}" />
	            <h:inputHidden />
			    <x:message for="idcardtype" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="idcardno" styleClass="outputlabel" value="#{text['tmchnt.idcardno']}" />
				<h:outputText id="idcardno" value="#{triskcaseRecordForm.tmchnt.idcardno}" />
	            <h:inputHidden />
			    <x:message for="idcardno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="contactperson" styleClass="outputlabel" value="#{text['tmchnt.contactperson']}" />
				<h:outputText id="contactperson" value="#{triskcaseRecordForm.tmchnt.contactperson}" />
	            <h:inputHidden />
			    <x:message for="contactperson" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="dept" styleClass="outputlabel" value="#{text['tmchnt.dept']}" />
				<h:outputText id="dept" value="#{triskcaseRecordForm.tmchnt.dept}" />
	            <h:inputHidden />
			    <x:message for="dept" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="tel" styleClass="outputlabel" value="#{text['tmchnt.tel']}" />
				<h:outputText id="tel" value="#{triskcaseRecordForm.tmchnt.tel}" />
	            <h:inputHidden />
			    <x:message for="tel" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mobtel" styleClass="outputlabel" value="#{text['tmchnt.mobtel']}" />
				<h:outputText id="mobtel" value="#{triskcaseRecordForm.tmchnt.mobtel}" />
	            <h:inputHidden />
			    <x:message for="mobtel" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="fax" styleClass="outputlabel" value="#{text['tmchnt.fax']}" />
				<h:outputText id="fax" value="#{triskcaseRecordForm.tmchnt.fax}" />
	            <h:inputHidden />
			    <x:message for="fax" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="email" styleClass="outputlabel" value="#{text['tmchnt.email']}" />
				<h:outputText id="email" value="#{triskcaseRecordForm.tmchnt.email}" />
	            <h:inputHidden />
			    <x:message for="email" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financeperson" styleClass="outputlabel" value="#{text['tmchnt.financeperson']}" />
				<h:outputText id="financeperson" value="#{triskcaseRecordForm.tmchnt.financeperson}" />
	            <h:inputHidden />
			    <x:message for="financeperson" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financetel" styleClass="outputlabel" value="#{text['tmchnt.financetel']}" />
				<h:outputText id="financetel" value="#{triskcaseRecordForm.tmchnt.financetel}" />
	            <h:inputHidden />
			    <x:message for="financetel" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financemotel" styleClass="outputlabel" value="#{text['tmchnt.financemotel']}" />
				<h:outputText id="financemotel" value="#{triskcaseRecordForm.tmchnt.financemotel}" />
	            <h:inputHidden />
			    <x:message for="financemotel" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financefax" styleClass="outputlabel" value="#{text['tmchnt.financefax']}" />
				<h:outputText id="financefax" value="#{triskcaseRecordForm.tmchnt.financefax}" />
	            <h:inputHidden />
			    <x:message for="financefax" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financeemail" styleClass="outputlabel" value="#{text['tmchnt.financeemail']}" />
				<h:outputText id="financeemail" value="#{triskcaseRecordForm.tmchnt.financeemail}" />
	            <h:inputHidden />
			    <x:message for="financeemail" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="foreigncard" styleClass="outputlabel" value="#{text['tmchnt.foreigncard']}" />
				<h:outputText id="foreigncard" value="#{triskcaseRecordForm.tmchnt.foreigncard}" />
	            <h:inputHidden />
			    <x:message for="foreigncard" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
		

<div class="mytab1">
<ul class="myTabBar1"  id="listUl">
<LI class="Selected"><a href="#"><h:outputText value="触发子规则信息" /></a></LI>
</ul>
</div>	

				<t:dataTable id="triskcaseRule" var="triskcaseRule"
				value="#{triskcaseRecordForm.ruleList}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				binding="#{triskcaseRecordForm.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" onclick="hightlightRows(this);">
				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="ruleInstanceId" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.ruleInstanceId']}" />
						</t:commandSortHeader>	
				</f:facet>
					<be:outputText id="ruleInstanceId" value="#{triskcaseRule.ruleInstanceId}" style="width:'80%'">
	  					  <f:selectItems value="#{extSelectItems.truleInstanceItems}"/>
					</be:outputText>										
				</t:column>
								
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="begin" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.begin']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="begin" value="#{triskcaseRule.begin}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="end" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.end']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="end" value="#{triskcaseRule.end}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="value" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.value']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="value" value="#{triskcaseRule.value}" />
				</t:column>	
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="rate" arrow="true">		                
							<h:outputText value="风险比值" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="rate" value="#{triskcaseRule.rate}" />
				</t:column>								
								
			</t:dataTable>	
	
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" style="">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" style="">
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{triskcaseRecordForm.edit}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_riskcase_record_add.2c90834916e5db4a0116e6169a4d005a']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_riskcase_record/t_riskcase_record_add_EditForm.faces?_key=#{triskcaseRecordForm.triskcaseRecord.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{triskcaseRecordForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_riskcase_record_add.2c90834916e5db4a0116e6169a6c005b']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
		            <h:commandLink action="#{triskcaseRecordForm.back}" >
						<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="取消" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase/t_riskcase_form_makeing_ViewForm" />						
					</h:commandLink>
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink onclick="window.open('../PrintViewServlet?id=#{triskcaseRecordForm.triskcaseRecord.id}','_self','');return false">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="打印预览" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>

		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" style="">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_record_add.2c9083491781cf8f01178ac34fdd00e4']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="caseno" styleClass="outputlabel" value="#{text['triskcaseRecord.caseno']}" />
				<h:outputLink id="caseno_link" value="../t_riskcase/t_riskcase_ViewForm.faces?_key=#{triskcaseRecordForm.triskcaseRecord.caseno}">
    				<h:outputText id="caseno" value="#{triskcaseRecordForm.triskcaseRecord.caseno}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="caseno" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="investigationDate" styleClass="outputlabel" value="#{text['triskcaseRecord.investigationDate']}" />
				<h:outputText id="investigationDate" value="#{triskcaseRecordForm.triskcaseRecord.investigationDate}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="investigationDate" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" style="">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_record_add.2c9083491781cf8f01178ac3504a00e7']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="investigationWay" styleClass="outputlabel" value="#{text['triskcaseRecord.investigationWay']}" />
<h:panelGroup>
<f:verbatim><table class="radioGroupView"><tr><td></f:verbatim>			
				<be:groupCheckbox id="investigationWay" value="#{triskcaseRecordForm.investigationWay}" readonly="true" cols="4" disabled="true">
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationWay.3']}" itemValue="3"/>
				</be:groupCheckbox>	
<f:verbatim></td></tr></table></f:verbatim>
</h:panelGroup>			
	            <h:inputHidden />
			    <x:message for="investigationWay" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="otherInvestigationWay" styleClass="outputlabel" value="#{text['triskcaseRecord.otherInvestigationWay']}" />
				<h:outputText id="otherInvestigationWay" value="#{triskcaseRecordForm.triskcaseRecord.otherInvestigationWay}" />
	            <h:inputHidden />
			    <x:message for="otherInvestigationWay" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" style="">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_record_add.2c9083491781cf8f01178ac3509800ea']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="isPickFlow" styleClass="outputlabel" value="#{text['triskcaseRecord.isPickFlow']}" />
				<h:selectBooleanCheckbox id="isPickFlow" value="#{triskcaseRecordForm.triskcaseRecord.isPickFlow}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="isPickFlow" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="pickCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickCnt']}" />
				<h:outputText id="pickCnt" value="#{triskcaseRecordForm.triskcaseRecord.pickCnt}" />
	            <h:inputHidden />
			    <x:message for="pickCnt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="pickAmt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickAmt']}(元)" />
				<h:outputText id="pickAmt" value="#{triskcaseRecordForm.triskcaseRecord.pickAmt}" />
	            <h:inputHidden />
			    <x:message for="pickAmt" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="pick180Cnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pick180Cnt']}" />
				<h:outputText id="pick180Cnt" value="#{triskcaseRecordForm.triskcaseRecord.pick180Cnt}" />
	            <h:inputHidden />
			    <x:message for="pick180Cnt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="pick180Amt" styleClass="outputlabel" value="#{text['triskcaseRecord.pick180Amt']}(元)" />
				<h:outputText id="pick180Amt" value="#{triskcaseRecordForm.triskcaseRecord.pick180Amt}" />
	            <h:inputHidden />
			    <x:message for="pick180Amt" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="pickStatus" styleClass="outputlabel" value="#{text['triskcaseRecord.pickStatus']}" />
				<be:outputText id="pickStatus" value="#{triskcaseRecordForm.triskcaseRecord.pickStatus}">	
				   <f:selectItem itemLabel="" itemValue=""/>				
                   <f:selectItem itemLabel="#{text['triskcaseRecord.pickStatus.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.pickStatus.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.pickStatus.2']}" itemValue="2"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="pickStatus" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="pickFlawCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickFlawCnt']}" />
				<h:outputText id="pickFlawCnt" value="#{triskcaseRecordForm.triskcaseRecord.pickFlawCnt}" />
	            <h:inputHidden />
			    <x:message for="pickFlawCnt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="pickEmptyCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.pickEmptyCnt']}" />
				<h:outputText id="pickEmptyCnt" value="#{triskcaseRecordForm.triskcaseRecord.pickEmptyCnt}" />
	            <h:inputHidden />
			    <x:message for="pickEmptyCnt" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" style="">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_record_add.2c9083491781cf8f01178ac3515400f3']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="investigationResult" styleClass="outputlabel" value="#{text['triskcaseRecord.investigationResult']}" />
				<be:outputText id="investigationResult" value="#{triskcaseRecordForm.triskcaseRecord.investigationResult}">					
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationResult.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.investigationResult.0']}" itemValue="0"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="investigationResult" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="reason" styleClass="outputlabel" value="触发规则的原因" />
				<be:outputText id="reason" value="#{triskcaseRecordForm.triskcaseRecord.reason}">					
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="reason" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="riskLevel" styleClass="outputlabel" value="#{text['triskcaseRecord.riskLevel']}" />
				<be:outputText id="riskLevel" value="#{triskcaseRecordForm.triskcaseRecord.riskLevel}">
				   <f:selectItem itemLabel="" itemValue=""/>					
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskLevel.3']}" itemValue="3"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="riskLevel" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="riskType" styleClass="outputlabel" value="#{text['triskcaseRecord.riskType']}" />
				<be:outputText id="riskType" value="#{triskcaseRecordForm.triskcaseRecord.riskType}">	
					<f:selectItem itemLabel="" itemValue=""/>				
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.riskType.4']}" itemValue="4"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="riskType" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="otherRiskType" styleClass="outputlabel" value="#{text['triskcaseRecord.otherRiskType']}" />
				<h:outputText id="otherRiskType" value="#{triskcaseRecordForm.triskcaseRecord.otherRiskType}" />
	            <h:inputHidden />
			    <x:message for="otherRiskType" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" style="">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_record_add.2c9083491781cf8f01178ac351d100f8']}" />
			</f:facet>

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="process2Type" styleClass="outputlabel" value="#{text['triskcaseRecord.processType']}" />
<h:panelGroup>
<f:verbatim><table class="radioGroupView"><tr><td></f:verbatim>			
				<be:outputText id="process2Type" value="#{triskcaseRecordForm.triskcaseRecord.process2Type}">
                   <f:selectItem itemLabel="" itemValue=""/>
                   <f:selectItem itemLabel="警告" itemValue="0"/>
                   <f:selectItem itemLabel="终止协议" itemValue="1"/>
                   <f:selectItem itemLabel="交收单机构" itemValue="2"/>
				</be:outputText>	
<f:verbatim></td></tr></table></f:verbatim>
</h:panelGroup>			
	            <h:inputHidden />
			    <x:message for="process2Type" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="processType" styleClass="outputlabel" value="#{text['triskcaseRecord.processType']}" />
<h:panelGroup>
<f:verbatim><table class="radioGroupView"><tr><td></f:verbatim>			
				<be:groupCheckbox id="processType" value="#{triskcaseRecordForm.processType}" readonly="true" cols="4" disabled="true">
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.00']}" itemValue="00"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.01']}" itemValue="01"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.10']}" itemValue="10"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.11']}" itemValue="11"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.12']}" itemValue="12"/>
                   <f:selectItem itemLabel="#{text['triskcaseRecord.processType.13']}" itemValue="13"/>
				</be:groupCheckbox>	
<f:verbatim></td></tr></table></f:verbatim>
</h:panelGroup>			
	            <h:inputHidden />
			    <x:message for="processType" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="processFreezeAmt" styleClass="outputlabel" value="#{text['triskcaseRecord.processFreezeAmt']}(元)" />
				<h:outputText id="processFreezeAmt" value="#{triskcaseRecordForm.triskcaseRecord.processFreezeAmt}" />
	            <h:inputHidden />
			    <x:message for="processFreezeAmt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="processWithdrawCnt" styleClass="outputlabel" value="#{text['triskcaseRecord.processWithdrawCnt']}" />
				<h:outputText id="processWithdrawCnt" value="#{triskcaseRecordForm.triskcaseRecord.processWithdrawCnt}" />
	            <h:inputHidden />
			    <x:message for="processWithdrawCnt" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="otherProcessType" styleClass="outputlabel" value="#{text['triskcaseRecord.otherProcessType']}" />
				<h:outputText id="otherProcessType" value="#{triskcaseRecordForm.triskcaseRecord.otherProcessType}" />
	            <h:inputHidden />
			    <x:message for="otherProcessType" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" style="">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_record_add.2c9083491781cf8f01178ac3523e00fd']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter" style="">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView" style="">
				<h:outputLabel for="description" styleClass="outputlabel" value="#{text['triskcaseRecord.description']}" />
			    <h:outputText id="description" value="#{triskcaseRecordForm.triskcaseRecord.description}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="description" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>

	
</f:view>
</body>	