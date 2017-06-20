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
	parent.historyIframe.addHistory('/t_rule_group/t_rule_group_form_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleGroupForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="truleGroup.t_rule_group_form_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleGroupForm.truleGroup.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'truleGroupForm');"><a href="#"><h:outputText value="#{text['truleGroup.t_rule_group_form_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{truleGroupForm.truleGroupPrimaryKey}" />
	<h:form id="truleGroupForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{truleGroupForm.edit}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_rule_group_form.2c90834916d142fa0116d302afc9014b']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_rule_group/t_rule_group_form_EditForm.faces?_key=#{truleGroupForm.truleGroup.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{truleGroupForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_rule_group_form.2c90834916d142fa0116d302afe8014c']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_rule_group_form.2c90834916d142fa0116d30cafa901da']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="belongToInst" styleClass="outputlabel" value="#{text['truleGroup.belongToInst']}" />
				<h:outputLink id="belongToInst_link" value="../t_organize_info/t_organize_info_ViewForm.faces?_key=#{truleGroupForm.truleGroup.belongToInst}">
    				<h:outputText id="belongToInst" value="#{truleGroupForm.truleGroup.belongToInstOfTorganizeInfo.name}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="belongToInst" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="enable" styleClass="outputlabel" value="#{text['truleGroup.enable']}" />
				<h:selectBooleanCheckbox id="enable" value="#{truleGroupForm.truleGroup.enable}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="enable" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="status" styleClass="outputlabel" value="#{text['truleGroup.status']}" />
				<be:outputText id="status" value="#{truleGroupForm.truleGroup.status}">					
                   <f:selectItem itemLabel="#{text['truleGroup.status.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['truleGroup.status.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['truleGroup.status.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['truleGroup.status.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['truleGroup.status.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['truleGroup.status.5']}" itemValue="5"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="status" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="description" styleClass="outputlabel" value="#{text['truleGroup.description']}" />
			    <h:inputTextarea id="description" value="#{truleGroupForm.truleGroup.description}" cols="20" rows="4" readonly="true" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="description" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>

	
</f:view>
</body>	