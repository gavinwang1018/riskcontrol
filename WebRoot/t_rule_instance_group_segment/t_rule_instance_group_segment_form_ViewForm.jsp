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
	parent.historyIframe.addHistory('/t_rule_instance_group_segment/t_rule_instance_group_segment_form_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceGroupSegmentForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="truleInstanceGroupSegment.t_rule_instance_group_segment_form_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceGroupSegmentForm.truleInstanceGroupSegment.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'truleInstanceGroupSegmentForm');"><a href="#"><h:outputText value="#{text['truleInstanceGroupSegment.t_rule_instance_group_segment_form_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{truleInstanceGroupSegmentForm.truleInstanceGroupSegmentPrimaryKey}" />
	<h:form id="truleInstanceGroupSegmentForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{truleInstanceGroupSegmentForm.edit}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_rule_instance_group_segment_form.2c90834916d142fa0116d32c4af802cc']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_rule_instance_group_segment/t_rule_instance_group_segment_form_EditForm.faces?_key=#{truleInstanceGroupSegmentForm.truleInstanceGroupSegment.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{truleInstanceGroupSegmentForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_rule_instance_group_segment_form.2c90834916d142fa0116d32c4b0802cd']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_rule_instance_group_segment_form.2c908349172dd02b01172e4c26bb0019']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="ruleInstanceGroupId" styleClass="outputlabel" value="#{text['truleInstanceGroupSegment.ruleInstanceGroupId']}" />
				<h:outputLink id="ruleInstanceGroupId_link" value="../t_rule_instance_group/t_rule_instance_group_ViewForm.faces?_key=#{truleInstanceGroupSegmentForm.truleInstanceGroupSegment.ruleInstanceGroupId}">
    				<h:outputText id="ruleInstanceGroupId" value="#{truleInstanceGroupSegmentForm.truleInstanceGroupSegment.ruleInstanceGroupIdOfTruleInstanceGroup.id}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="ruleInstanceGroupId" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="ruleInstanceId" styleClass="outputlabel" value="#{text['truleInstanceGroupSegment.ruleInstanceId']}" />
				<h:outputLink id="ruleInstanceId_link" value="../t_rule_instance/t_rule_instance_ViewForm.faces?_key=#{truleInstanceGroupSegmentForm.truleInstanceGroupSegment.ruleInstanceId}">
    				<h:outputText id="ruleInstanceId" value="#{truleInstanceGroupSegmentForm.truleInstanceGroupSegment.ruleInstanceIdOfTruleInstance.id}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="ruleInstanceId" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="begin" styleClass="outputlabel" value="#{text['truleInstanceGroupSegment.begin']}" />
				<h:outputText id="begin" value="#{truleInstanceGroupSegmentForm.truleInstanceGroupSegment.begin}" />
	            <h:inputHidden />
			    <x:message for="begin" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="end" styleClass="outputlabel" value="#{text['truleInstanceGroupSegment.end']}" />
				<h:outputText id="end" value="#{truleInstanceGroupSegmentForm.truleInstanceGroupSegment.end}" />
	            <h:inputHidden />
			    <x:message for="end" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="propertion" styleClass="outputlabel" value="#{text['truleInstanceGroupSegment.propertion']}" />
				<h:outputText id="propertion" value="#{truleInstanceGroupSegmentForm.truleInstanceGroupSegment.propertion}" />
	            <h:inputHidden />
			    <x:message for="propertion" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="value" styleClass="outputlabel" value="#{text['truleInstanceGroupSegment.value']}" />
				<h:outputText id="value" value="#{truleInstanceGroupSegmentForm.truleInstanceGroupSegment.value}" />
	            <h:inputHidden />
			    <x:message for="value" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>

	
</f:view>
</body>	