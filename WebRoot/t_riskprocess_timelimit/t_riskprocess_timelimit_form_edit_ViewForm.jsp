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
	parent.historyIframe.addHistory('/t_riskprocess_timelimit/t_riskprocess_timelimit_form_edit_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskprocessTimelimitForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="triskprocessTimelimit.t_riskprocess_timelimit_form_edit_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskprocessTimelimitForm.triskprocessTimelimit.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'triskprocessTimelimitForm');"><a href="#"><h:outputText value="#{text['triskprocessTimelimit.t_riskprocess_timelimit_form_edit_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{triskprocessTimelimitForm.triskprocessTimelimitPrimaryKey}" />
	<h:form id="triskprocessTimelimitForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{triskprocessTimelimitForm.edit}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_riskprocess_timelimit_form_edit.2c908349171a86da01171aa120800058']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_riskprocess_timelimit/t_riskprocess_timelimit_form_edit_EditForm.faces?_key=#{triskprocessTimelimitForm.triskprocessTimelimit.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{triskprocessTimelimitForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_riskprocess_timelimit_form_edit.2c908349171a86da01171aa120900059']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskprocess_timelimit_form_edit.2c908349171a86da01171aa2d7290063']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="belongToInst" styleClass="outputlabel" value="#{text['triskprocessTimelimit.belongToInst']}" />
				<h:outputLink id="belongToInst_link" value="../t_organize_info/t_organize_info_ViewForm.faces?_key=#{triskprocessTimelimitForm.triskprocessTimelimit.belongToInst}">
    				<h:outputText id="belongToInst" value="#{triskprocessTimelimitForm.triskprocessTimelimit.belongToInstOfTorganizeInfo.name}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="belongToInst" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="warnLevel" styleClass="outputlabel" value="#{text['triskprocessTimelimit.warnLevel']}" />
				<be:outputText id="warnLevel" value="#{triskprocessTimelimitForm.triskprocessTimelimit.warnLevel}">					
                   <f:selectItem itemLabel="#{text['triskprocessTimelimit.warnLevel.ddd']}" itemValue="ddd"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="warnLevel" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="timeLimit" styleClass="outputlabel" value="#{text['triskprocessTimelimit.timeLimit']}" />
				<h:outputText id="timeLimit" value="#{triskprocessTimelimitForm.triskprocessTimelimit.timeLimit}" />
	            <h:inputHidden />
			    <x:message for="timeLimit" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>

	
</f:view>
</body>	