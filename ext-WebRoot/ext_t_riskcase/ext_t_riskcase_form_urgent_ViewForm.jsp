<%@page import="java.util.*"%> 
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="cn.com.brilliance.begen.common.BeGenHistory"%>
<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage" %>
<%@ page import="cn.com.brilliance.begen.common.Tools" %>
<%@ page import="cn.com.brilliance.begen.dao.*" %>
<%@ page import="cn.com.brilliance.begen.model.*" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%
String basePath = request.getContextPath();
javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().setLocale(cn.com.brilliance.begen.common.bundle.ResourceBundle.getLocale(request));
String pk = (String)FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseForm.triskcasePrimaryKey}").getValue(FacesContext.getCurrentInstance());
TriskcaseDAO triskcaseDAO = (TriskcaseDAO)Tools.getBean("triskcaseDAO");
Triskcase triskcase = triskcaseDAO.getTriskcase(pk);
String caseno = triskcase.getCaseno();
String casefrom = triskcase.getCasefrom();
%>
<head>
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/config.css" />
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/right.css" />
<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>
</head>
<body onload="loadChild();loadChildList()">
<script>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

var childScript = "loadTriskcaseRecords();loadTriskcaseAttachments();loadHidInfo()".split(";");
var scriptCount = 0;
function loadChild(){
	eval(childScript[scriptCount++]);
}
</script>

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
		<f:loadBundle var="text" basename="ApplicationResources" />
<script language=javascript>
try{
	parent.historyIframe.addHistory('/t_riskcase/t_riskcase_form_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="triskcase.t_riskcase_form_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseForm.triskcase.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
<LI class="Selected" ><a href="#"><h:outputText value="要督办的案例信息" /></a></LI>
</ul>
</div>
	<t:saveState value="#{triskcaseForm.triskcasePrimaryKey}" />
	<t:saveState value="#{triskcaseForm.queryFields}" />
	<t:saveState value="#{triskcaseForm.relativeAmt}" />
	<t:saveState value="#{triskcaseForm.allAmt}" />
	
	
	<h:form id="triskcaseForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
					<h:commandLink onclick="window.open('../ext_t_riskcase/ext_t_riskcase_urgent.faces','_self','');return false">				
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="取消" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{extTriskcaseForm.urgent}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="督办" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../ext_t_riskcase/ext_t_riskcase_urgent.faces"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="案例的基本信息" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="caseno" styleClass="outputlabel" value="#{text['triskcase.caseno']}" />
				<h:outputText id="caseno" value="#{triskcaseForm.triskcase.caseno}" />
	            <h:inputHidden />
			    <x:message for="caseno" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="otherno" styleClass="outputlabel" value="#{text['triskcase.otherno']}" />
				<h:outputText id="otherno" value="#{triskcaseForm.triskcase.otherno}" />
	            <h:inputHidden />
			    <x:message for="otherno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="createdate" styleClass="outputlabel" value="#{text['triskcase.createdate']}" />
				<h:outputText id="createdate" value="#{triskcaseForm.triskcase.createdate}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="createdate" styleClass="fieldError" />
			</h:panelGrid>

  			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="casefrom" styleClass="outputlabel" value="#{text['triskcase.casefrom']}" />
				<be:outputText id="casefrom" value="#{triskcaseForm.triskcase.casefrom}">					
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.5']}" itemValue="5"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.6']}" itemValue="6"/>
				</be:outputText>
	            <h:inputHidden />
			    <x:message for="createdate" styleClass="fieldError" />
			</h:panelGrid>

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_form.2c90834917143e52011715cb6129014a']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="beginDate" styleClass="outputlabel" value="#{text['triskcase.beginDate']}" />
				<h:outputText id="beginDate" value="#{triskcaseForm.triskcase.beginDate}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="beginDate" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="endDate" styleClass="outputlabel" value="#{text['triskcase.endDate']}" />
				<h:outputText id="endDate" value="#{triskcaseForm.triskcase.endDate}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="endDate" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="allTransAmt" styleClass="outputlabel" value="#{text['triskcase.allTransAmt']}(元)" />
				<h:outputText id="allTransAmt" value="#{triskcaseForm.triskcase.allAmt}" >
					<f:convertNumber  minFractionDigits="2" />
				</h:outputText>	
	            <h:inputHidden />
			    <x:message for="allTransAmt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="allTransNum" styleClass="outputlabel" value="#{text['triskcase.allTransNum']}" />
				<h:outputText id="allTransNum" value="#{triskcaseForm.triskcase.allTransNum}" />
	            <h:inputHidden />
			    <x:message for="allTransNum" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="score" styleClass="outputlabel" value="#{text['triskcase.score']}" />
				<h:outputText id="score" value="#{triskcaseForm.triskcase.score}" />
	            <h:inputHidden />
			    <x:message for="score" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="triggerRuleNum" styleClass="outputlabel" value="#{text['triskcase.triggerRuleNum']}" />
				<h:outputText id="triggerRuleNum" value="#{triskcaseForm.triskcase.triggerRuleNum}" />
	            <h:inputHidden />
			    <x:message for="triggerRuleNum" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mchntCd" styleClass="outputlabel" value="#{text['triskcase.mchntCd']}" />
				<h:outputText id="mchntCd" value="#{triskcaseForm.triskcase.mchntCd}" />
	            <h:inputHidden />
			    <x:message for="mchntCd" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mchntName" styleClass="outputlabel" value="#{text['triskcase.mchntName']}" />
				<h:outputText id="mchntName" value="#{triskcaseForm.triskcase.mchntName}" />
	            <h:inputHidden />
			    <x:message for="mchntName" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mchntMcc" styleClass="outputlabel" value="#{text['triskcase.mchntMcc']}" />
				<be:outputText id="mchntMcc" value="#{triskcaseForm.triskcase.mchntMcc}" >
					<f:selectItems value="#{selectItems.tmccItems}"/>
				</be:outputText>
	            <h:inputHidden />
			    <x:message for="mchntMcc" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="transMcc" styleClass="outputlabel" value="#{text['triskcase.transMcc']}" />
				<be:outputText id="transMcc" value="#{triskcaseForm.triskcase.transMcc}" >
					<f:selectItems value="#{selectItems.tmccItems}"/>
				</be:outputText>
	            <h:inputHidden />
			    <x:message for="transMcc" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="relativeTransAmt" styleClass="outputlabel" value="#{text['triskcase.relativeTransAmt']}(元)" />
				<h:outputText id="relativeTransAmt" value="#{triskcaseForm.triskcase.relativeAmt}" >
					<f:convertNumber  minFractionDigits="2" />
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="relativeTransAmt" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="relativeTransNum" styleClass="outputlabel" value="#{text['triskcase.relativeTransNum']}" />
				<h:outputText id="relativeTransNum" value="#{triskcaseForm.triskcase.relativeTransNum}" />
	            <h:inputHidden />
			    <x:message for="relativeTransNum" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="belongToInst" styleClass="outputlabel" value="#{text['triskcase.belongToInst']}" />
				<be:outputText id="belongToInst" value="#{triskcaseForm.triskcase.belongToInst}">					
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="belongToInst" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="submit2Inst" styleClass="outputlabel" value="#{text['triskcase.submit2Inst']}" />
				<be:outputText id="submit2Inst" value="#{triskcaseForm.triskcase.submit2Inst}">					
                   <f:selectItems value="#{selectItems.torganizeInfoItems}"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="submit2Inst" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="acquireInstName" styleClass="outputlabel" value="#{text['triskcase.acquireInstName']}" />
				<be:outputText id="acquireInstName" value="#{triskcaseForm.triskcase.acquireInstName}">					
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="acquireInstName" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="warnLevel" styleClass="outputlabel" value="#{text['triskcase.warnLevel']}" />
				<be:outputText id="warnLevel" value="#{triskcaseForm.triskcase.warnLevel}">					
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.3']}" itemValue="3"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="warnLevel" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="processLimit" styleClass="outputlabel" value="#{text['triskcase.processLimit']}" />
				<h:outputText id="processLimit" value="#{triskcaseForm.triskcase.processLimit}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="processLimit" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="status" styleClass="outputlabel" value="#{text['triskcase.status']}" />
				<be:outputText id="status" value="#{triskcaseForm.triskcase.status}">					
                   <f:selectItem itemLabel="#{text['triskcase.status.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcase.status.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.status.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.status.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['triskcase.status.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['triskcase.status.5']}" itemValue="5"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="status" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="beenUrgent" styleClass="outputlabel" value="#{text['triskcase.beenUrgent']}" />
				<h:selectBooleanCheckbox id="beenUrgent" value="#{triskcaseForm.triskcase.beenUrgent}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="beenUrgent" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="urgentCnt" styleClass="outputlabel" value="#{text['triskcase.urgentCnt']}" />
				<h:outputText id="urgentCnt" value="#{triskcaseForm.triskcase.urgentCnt}" />
	            <h:inputHidden />
			    <x:message for="urgentCnt" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="trace" styleClass="outputlabel" value="#{text['triskcase.trace']}" />
				<h:selectBooleanCheckbox id="trace" value="#{triskcaseForm.triskcase.trace}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="trace" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="triggerContent" styleClass="outputlabel" value="#{text['triskcase.triggerContent']}" />
			    <h:outputText id="triggerContent" value="#{triskcaseForm.triskcase.triggerContent}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="triggerContent" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="riskContent" styleClass="outputlabel" value="#{text['triskcase.riskContent']}" />
			    <h:outputText id="riskContent" value="#{triskcaseForm.triskcase.riskContent}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="riskContent" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments1" styleClass="outputlabel" value="#{text['triskcase.comments1']}" />
			    <h:outputText id="comments1" value="#{triskcaseForm.triskcase.comments1}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments1" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments2" styleClass="outputlabel" value="#{text['triskcase.comments2']}" />
			    <h:outputText id="comments2" value="#{triskcaseForm.triskcase.comments2}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments2" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments3" styleClass="outputlabel" value="#{text['triskcase.comments3']}" />
			    <h:outputText id="comments3" value="#{triskcaseForm.triskcase.comments3}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments3" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments4" styleClass="outputlabel" value="#{text['triskcase.comments4']}" />
			    <h:outputText id="comments4" value="#{triskcaseForm.triskcase.comments4}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments4" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments5" styleClass="outputlabel" value="#{text['triskcase.comments5']}" />
			    <h:outputText id="comments5" value="#{triskcaseForm.triskcase.comments5}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments5" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
  			
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments6" styleClass="outputlabel" value="#{text['triskcase.comments6']}" />
			    <h:outputText id="comments6" value="#{triskcaseForm.triskcase.comments6}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments6" styleClass="fieldError" />
			</h:panelGrid>  			
  			
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="comments7" styleClass="outputlabel" value="#{text['triskcase.comments7']}" />
			    <h:outputText id="comments7" value="#{triskcaseForm.triskcase.comments7}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="comments7" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>  
  			


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
				<be:outputText id="subinst" value="#{triskcaseForm.tmchnt.belongToSubinst.name}">					
                  
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="subinst" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="merchantno" styleClass="outputlabel" value="#{text['tmchnt.merchantno']}" />
				<h:outputText id="merchantno" value="#{triskcaseForm.tmchnt.merchantno}" />
	            <h:inputHidden />
			    <x:message for="merchantno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="merchantcategory" styleClass="outputlabel" value="#{text['tmchnt.merchantcategory']}" />
				
				<be:outputText id="merchantcategory" value="#{triskcaseForm.tmchnt.merchantcategory}">
                   <f:selectItems value="#{extSelectItems.tmccIdsOfTmccs}"/>
				</be:outputText>
	            <h:inputHidden />
			    <x:message for="merchantcategory" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="name" styleClass="outputlabel" value="#{text['tmchnt.name']}" />
				<h:outputText id="name" value="#{triskcaseForm.tmchnt.name}" />
	            <h:inputHidden />
			    <x:message for="name" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="briefname" styleClass="outputlabel" value="#{text['tmchnt.briefname']}" />
				<h:outputText id="briefname" value="#{triskcaseForm.tmchnt.briefname}" />
	            <h:inputHidden />
			    <x:message for="briefname" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="state" styleClass="outputlabel" value="#{text['tmchnt.state']}" />
				<h:outputText id="state" value="#{triskcaseForm.tmchnt.state}" />
	            <h:inputHidden />
			    <x:message for="state" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="province" styleClass="outputlabel" value="#{text['tmchnt.province']}" />
				<h:outputText id="province" value="#{triskcaseForm.tmchnt.province}" />
	            <h:inputHidden />
			    <x:message for="province" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="city" styleClass="outputlabel" value="#{text['tmchnt.city']}" />
				<h:outputText id="city" value="#{triskcaseForm.tmchnt.city}" />
	            <h:inputHidden />
			    <x:message for="city" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="county" styleClass="outputlabel" value="#{text['tmchnt.county']}" />
				<h:outputText id="county" value="#{triskcaseForm.tmchnt.county}" />
	            <h:inputHidden />
			    <x:message for="county" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="merchantnature" styleClass="outputlabel" value="#{text['tmchnt.merchantnature']}" />
				<h:outputText id="merchantnature" value="#{triskcaseForm.tmchnt.merchantnature}" />
	            <h:inputHidden />
			    <x:message for="merchantnature" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="registerAddress" styleClass="outputlabel" value="#{text['tmchnt.registerAddress']}" />
				<h:outputText id="registerAddress" value="#{triskcaseForm.tmchnt.registerAddress}" />
	            <h:inputHidden />
			    <x:message for="registerAddress" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="officeAddress" styleClass="outputlabel" value="#{text['tmchnt.officeAddress']}" />
			    <h:outputText id="officeAddress" value="#{triskcaseForm.tmchnt.officeAddress}" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="officeAddress" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="officeZipcode" styleClass="outputlabel" value="#{text['tmchnt.officeZipcode']}" />
				<h:outputText id="officeZipcode" value="#{triskcaseForm.tmchnt.officeZipcode}" />
	            <h:inputHidden />
			    <x:message for="officeZipcode" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="licenseno" styleClass="outputlabel" value="#{text['tmchnt.licenseno']}" />
				<h:outputText id="licenseno" value="#{triskcaseForm.tmchnt.licenseno}" />
	            <h:inputHidden />
			    <x:message for="licenseno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="taxno" styleClass="outputlabel" value="#{text['tmchnt.taxno']}" />
				<h:outputText id="taxno" value="#{triskcaseForm.tmchnt.taxno}" />
	            <h:inputHidden />
			    <x:message for="taxno" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="licensedeadline" styleClass="outputlabel" value="#{text['tmchnt.licensedeadline']}" />
				<h:outputText id="licensedeadline" value="#{triskcaseForm.tmchnt.licensedeadline}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="licensedeadline" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="withdrawinputdate" styleClass="outputlabel" value="#{text['tmchnt.withdrawinputdate']}" />
				<h:outputText id="withdrawinputdate" value="#{triskcaseForm.tmchnt.withdrawinputdate}" >
					<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>
	            <h:inputHidden />
			    <x:message for="withdrawinputdate" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="withdrawcategory" styleClass="outputlabel" value="#{text['tmchnt.withdrawcategory']}" />
				<h:outputText id="withdrawcategory" value="#{triskcaseForm.tmchnt.withdrawcategory}" />
	            <h:inputHidden />
			    <x:message for="withdrawcategory" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="withdrawoperator" styleClass="outputlabel" value="#{text['tmchnt.withdrawoperator']}" />
				<h:outputText id="withdrawoperator" value="#{triskcaseForm.tmchnt.withdrawoperator}" />
	            <h:inputHidden />
			    <x:message for="withdrawoperator" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="legalman" styleClass="outputlabel" value="#{text['tmchnt.legalman']}" />
				<h:outputText id="legalman" value="#{triskcaseForm.tmchnt.legalman}" />
	            <h:inputHidden />
			    <x:message for="legalman" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="idcardtype" styleClass="outputlabel" value="#{text['tmchnt.idcardtype']}" />
				<h:outputText id="idcardtype" value="#{triskcaseForm.tmchnt.idcardtype}" />
	            <h:inputHidden />
			    <x:message for="idcardtype" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="idcardno" styleClass="outputlabel" value="#{text['tmchnt.idcardno']}" />
				<h:outputText id="idcardno" value="#{triskcaseForm.tmchnt.idcardno}" />
	            <h:inputHidden />
			    <x:message for="idcardno" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="contactperson" styleClass="outputlabel" value="#{text['tmchnt.contactperson']}" />
				<h:outputText id="contactperson" value="#{triskcaseForm.tmchnt.contactperson}" />
	            <h:inputHidden />
			    <x:message for="contactperson" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="dept" styleClass="outputlabel" value="#{text['tmchnt.dept']}" />
				<h:outputText id="dept" value="#{triskcaseForm.tmchnt.dept}" />
	            <h:inputHidden />
			    <x:message for="dept" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="tel" styleClass="outputlabel" value="#{text['tmchnt.tel']}" />
				<h:outputText id="tel" value="#{triskcaseForm.tmchnt.tel}" />
	            <h:inputHidden />
			    <x:message for="tel" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="mobtel" styleClass="outputlabel" value="#{text['tmchnt.mobtel']}" />
				<h:outputText id="mobtel" value="#{triskcaseForm.tmchnt.mobtel}" />
	            <h:inputHidden />
			    <x:message for="mobtel" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="fax" styleClass="outputlabel" value="#{text['tmchnt.fax']}" />
				<h:outputText id="fax" value="#{triskcaseForm.tmchnt.fax}" />
	            <h:inputHidden />
			    <x:message for="fax" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="email" styleClass="outputlabel" value="#{text['tmchnt.email']}" />
				<h:outputText id="email" value="#{triskcaseForm.tmchnt.email}" />
	            <h:inputHidden />
			    <x:message for="email" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financeperson" styleClass="outputlabel" value="#{text['tmchnt.financeperson']}" />
				<h:outputText id="financeperson" value="#{triskcaseForm.tmchnt.financeperson}" />
	            <h:inputHidden />
			    <x:message for="financeperson" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financetel" styleClass="outputlabel" value="#{text['tmchnt.financetel']}" />
				<h:outputText id="financetel" value="#{triskcaseForm.tmchnt.financetel}" />
	            <h:inputHidden />
			    <x:message for="financetel" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financemotel" styleClass="outputlabel" value="#{text['tmchnt.financemotel']}" />
				<h:outputText id="financemotel" value="#{triskcaseForm.tmchnt.financemotel}" />
	            <h:inputHidden />
			    <x:message for="financemotel" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financefax" styleClass="outputlabel" value="#{text['tmchnt.financefax']}" />
				<h:outputText id="financefax" value="#{triskcaseForm.tmchnt.financefax}" />
	            <h:inputHidden />
			    <x:message for="financefax" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="financeemail" styleClass="outputlabel" value="#{text['tmchnt.financeemail']}" />
				<h:outputText id="financeemail" value="#{triskcaseForm.tmchnt.financeemail}" />
	            <h:inputHidden />
			    <x:message for="financeemail" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="foreigncard" styleClass="outputlabel" value="#{text['tmchnt.foreigncard']}" />
				<h:outputText id="foreigncard" value="#{triskcaseForm.tmchnt.foreigncard}" />
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
				value="#{triskcaseForm.ruleList}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				binding="#{triskcaseForm.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" onclick="hightlightRows(this);">
				
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
			
<div class="mytab1">
<ul class="myTabBar1"  id="listUl">
<LI class="Selected"><a href="#"><h:outputText value="案例督办意见" /></a></LI>
</ul>
</div>	


		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="请输入督办意见" />
			</f:facet>	

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable1,rowTable5" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="comments8" styleClass="outputlabel" value="#{text['triskcase.comments8']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                      <h:panelGroup>
			              <h:inputTextarea id="comments8" value="#{triskcaseForm.triskcase.comments8}" rows="4" style="width:'86%';" readonly="false" tabindex="15" styleClass="edit_textarea" >
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="comments1" styleClass="fieldError" />
			</h:panelGrid>
			<h:inputHidden />

  			</h:panelGrid>


		</h:panelGrid>
		</h:panelGrid>			
		
	</h:form>

<div class="mytab1">
<ul class="myTabBar1"  id="listUl">
<LI class="Selected"><a href="#"><h:outputText value="#{text['triskcaseRecord.t_riskcase_record_list_add_List.heading']}" /></a></LI>
</ul>
</div>	
	<t:saveState value="#{triskcaseRecordList.triskcaseRecord}" />
	<t:saveState id="triskcaseRecords" value="#{triskcaseRecordList.triskcaseRecords}" />
	    <a4j:jsFunction name="deleteTriskcaseRecord" action="#{triskcaseRecordList.delete}"  reRender="triskcaseRecordPanel,triskcases" oncomplete="rowIndexVarOfTriskcase = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTriskcaseRecord" action="#{triskcaseRecordList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="triskcaseRecordList" >
		<a4j:jsFunction name="loadTriskcaseRecords" action="#{triskcaseForm.loadChildOfTriskcaseRecord}"  reRender="triskcaseRecordPanel,triskcases" oncomplete="loadChild()"/>

<f:verbatim>				
<script>
		var rowIndexVarOfTriskcaseRecord = -1;
</script>
</f:verbatim>
<h:panelGrid id="triskcaseRecordPanel" 	columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
	<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
		<h:panelGroup>
			<f:verbatim><ul class="button_bar"></f:verbatim>
           <f:verbatim></ul></f:verbatim>
		</h:panelGroup>
	</h:panelGrid>
		
			<h:inputHidden id="triskcaseRecordRowIndex" value="#{triskcaseRecordList.rowIndex}"></h:inputHidden>
			<h:outputLabel rendered="#{empty triskcaseRecordList.triskcaseRecords}" value="#{text['formlayout.data.null']}"  styleClass="listTableEmpty" />
			<t:dataTable rendered="#{!empty triskcaseRecordList.triskcaseRecords}" id="triskcaseRecordDataTable" var="triskcaseRecord"
				value="#{triskcaseRecordList.triskcaseRecords}"  rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" rowOnClick="rowIndexVarOfTriskcaseRecord='#{rowIndexVar}';document.getElementById('triskcaseRecordList:triskcaseRecordRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);"
				rows="15"
				binding="#{triskcaseRecordList.dataTable}"  headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd">
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseRecord.caseno']}" />
					</f:facet>
				<h:outputLink id="caseno_link" value="../t_riskcase/t_riskcase_ViewForm.faces?_key=#{triskcaseRecord.caseno}">
				  <h:outputText id="caseno" value="#{triskcaseRecord.caseno}"/>
				</h:outputLink>	
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseRecord.investigationDate']}" />
					</f:facet>
				<h:outputText id="investigationDate" value="#{triskcaseRecord.investigationDate}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseRecord.createDate']}" />
					</f:facet>
				<h:outputText id="createDate" value="#{triskcaseRecord.createDate}" >
					  <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
				</h:outputText>			
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseRecord.isPickFlow']}" />
					</f:facet>
				<h:selectBooleanCheckbox id="isPickFlow" value="#{triskcaseRecord.isPickFlow}"  disabled="true"/>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="是否新的登记要素" />
					</f:facet>
					<be:outputText id="ruleInstanceId" value="#{triskcaseRecord.isLocked}" style="width:'80%'">
	  					  <f:selectItems value="#{extSelectItems.newRecordList}"/>
					</be:outputText>	
				</t:column>					
			</t:dataTable>

         <h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">			
           <t:dataScroller id="triskcaseRecord_scroll_1"
                    for="triskcaseRecordDataTable"
                    rowsCountVar="rowsCount"
                    displayedRowsCountVar="displayedRowsCountVar"
                    firstRowIndexVar="firstRowIndex"
                    lastRowIndexVar="lastRowIndex"
                    pageCountVar="pageCount"
                    immediate="true"
                    pageIndexVar="pageIndex"
                    paginator="true"
                    paginatorMaxPages="9"
                    >
			<f:facet name="first" >
                <h:outputText value="#{text['page.first']}"/>
            </f:facet>
            <f:facet name="last">
                <h:outputText value="#{text['page.last']}"/>
            </f:facet>
            <f:facet name="previous">
                <h:outputText value="#{text['page.previous']}"/>
            </f:facet>
            <f:facet name="next">
                <h:outputText value="#{text['page.next']}"/>
            </f:facet>
            </t:dataScroller> 			
            <t:dataScroller id="triskcaseRecord_scroll_2"
                    for="triskcaseRecordDataTable"
                    rowsCountVar="rowsCount"
                    displayedRowsCountVar="displayedRowsCountVar"
                    firstRowIndexVar="firstRowIndex"
                    lastRowIndexVar="lastRowIndex"
                    pageCountVar="pageCount"
                    immediate="true"
                    pageIndexVar="pageIndex"
                    >
                <h:outputFormat value="#{text['pageFooter']}" styleClass="standard" >
                    <f:param value="#{rowsCount}" />
                    <f:param value="#{displayedRowsCountVar}" />
                    <f:param value="#{firstRowIndex}" />
                    <f:param value="#{lastRowIndex}" />
                    <f:param value="#{pageIndex}" />
                    <f:param value="#{pageCount==0?1:pageCount}" />
                </h:outputFormat>
             </t:dataScroller>           
            </h:panelGrid>				
		</h:panelGrid>
	</h:form>
	
<div class="mytab1">
<ul class="myTabBar1"  id="listUl">
<LI class="Selected"><a href="#"><h:outputText value="#{text['triskcaseAttachment.t_riskcase_attachment_add_List.heading']}" /></a></LI>
</ul>
</div>
	
	<t:saveState value="#{triskcaseAttachmentList.triskcaseAttachment}" />
	<t:saveState id="triskcaseAttachments" value="#{triskcaseAttachmentList.triskcaseAttachments}" />
	    <a4j:jsFunction name="deleteTriskcaseAttachment" action="#{triskcaseAttachmentList.delete}"  reRender="triskcaseAttachmentPanel,triskcases" oncomplete="rowIndexVarOfTriskcase = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTriskcaseAttachment" action="#{triskcaseAttachmentList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="triskcaseAttachmentList" >
		<a4j:jsFunction name="loadTriskcaseAttachments" action="#{triskcaseForm.loadChildOfTriskcaseAttachment}"  reRender="triskcaseAttachmentPanel,triskcases" oncomplete="loadChild()"/>

<f:verbatim>				
<script>
		var rowIndexVarOfTriskcaseAttachment = -1;
</script>
</f:verbatim>
<h:panelGrid id="triskcaseAttachmentPanel" 	columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
	<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
		<h:panelGroup>
			<f:verbatim><ul class="button_bar"></f:verbatim>
           <f:verbatim></ul></f:verbatim>
		</h:panelGroup>
	</h:panelGrid>
		
			<h:inputHidden id="triskcaseAttachmentRowIndex" value="#{triskcaseAttachmentList.rowIndex}"></h:inputHidden>
			<h:outputLabel rendered="#{empty triskcaseAttachmentList.triskcaseAttachments}" value="#{text['formlayout.data.null']}"  styleClass="listTableEmpty" />
			<t:dataTable rendered="#{!empty triskcaseAttachmentList.triskcaseAttachments}" id="triskcaseAttachmentDataTable" var="triskcaseAttachment"
				value="#{triskcaseAttachmentList.triskcaseAttachments}"  rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" rowOnClick="rowIndexVarOfTriskcaseAttachment='#{rowIndexVar}';document.getElementById('triskcaseAttachmentList:triskcaseAttachmentRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);"
				binding="#{triskcaseAttachmentList.dataTable}"  headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd">
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseAttachment.caseno']}" />
					</f:facet>
				<h:outputLink id="caseno_link" value="../t_riskcase/t_riskcase_ViewForm.faces?_key=#{triskcaseAttachment.caseno}">
				  <h:outputText id="caseno" value="#{triskcaseAttachment.caseno}"/>
				</h:outputLink>	
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcaseAttachment.filename']}" />
					</f:facet>
				<h:outputLink value="../FileDownloadServlet" styleClass="listbtn" rendered="#{not empty triskcaseAttachment.filename}">
					<f:param name="fileLocation" value="t_riskcase_attachment/#{triskcaseAttachment.id}/filename"/>
					<f:param name="fileName" value="#{triskcaseAttachment.filename}"/>
					<h:outputText value="#{triskcaseAttachment.filename}"/>
				</h:outputLink>
				</t:column>
			</t:dataTable>

		</h:panelGrid>
	</h:form>
</f:view>
</body>	