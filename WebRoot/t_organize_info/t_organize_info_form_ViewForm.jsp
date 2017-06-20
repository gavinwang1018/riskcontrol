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
	parent.historyIframe.addHistory('/t_organize_info/t_organize_info_form_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{torganizeInfoForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="torganizeInfo.t_organize_info_form_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{torganizeInfoForm.torganizeInfo.name}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'torganizeInfoForm');"><a href="#"><h:outputText value="#{text['torganizeInfo.t_organize_info_form_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{torganizeInfoForm.torganizeInfoPrimaryKey}" />
	<h:form id="torganizeInfoForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{torganizeInfoForm.edit}" rendered="#{sessionScope._user_info.actionMap['action.22'] == 'true'}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_organize_info_form.2c90834916ad22cb0116ad8b74900011']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_organize_info/t_organize_info_form_EditForm.faces?_key=#{torganizeInfoForm.torganizeInfo.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{torganizeInfoForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;" rendered="#{sessionScope._user_info.actionMap['action.22'] == 'true'}">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_organize_info_form.2c90834916ad22cb0116ad8b74af0012']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_organize_info_form.2c908349173e897b01173e8e42100006']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="name" styleClass="outputlabel" value="#{text['torganizeInfo.name']}" />
				<h:outputText id="name" value="#{torganizeInfoForm.torganizeInfo.name}" />
	            <h:inputHidden />
			    <x:message for="name" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="dwFlag" styleClass="outputlabel" value="#{text['torganizeInfo.dwFlag']}" />
				<h:selectBooleanCheckbox id="dwFlag" value="#{torganizeInfoForm.torganizeInfo.dwFlag}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="dwFlag" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="fwdInsIdCd" styleClass="outputlabel" value="#{text['torganizeInfo.fwdInsIdCd']}" />
				<h:outputText id="fwdInsIdCd" value="#{torganizeInfoForm.torganizeInfo.fwdInsIdCd}" />
	            <h:inputHidden />
			    <x:message for="fwdInsIdCd" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="parentId" styleClass="outputlabel" value="#{text['torganizeInfo.parentId']}" />
				<h:outputLink id="parentId_link" value="../t_organize_info/t_organize_info_ViewForm.faces?_key=#{torganizeInfoForm.torganizeInfo.parentId}">
    				<h:outputText id="parentId" value="#{torganizeInfoForm.torganizeInfo.parentId}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="parentId" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="globalSort" styleClass="outputlabel" value="#{text['torganizeInfo.globalSort']}" />
			    <h:inputTextarea id="globalSort" value="#{torganizeInfoForm.torganizeInfo.globalSort}" cols="20" rows="4" readonly="true" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="globalSort" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="originalSort" styleClass="outputlabel" value="#{text['torganizeInfo.originalSort']}" />
			    <h:inputTextarea id="originalSort" value="#{torganizeInfoForm.torganizeInfo.originalSort}" cols="20" rows="4" readonly="true" styleClass="viewTextarea"/>
	            <h:inputHidden />
			    <x:message for="originalSort" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="organizeBm" styleClass="outputlabel" value="#{text['torganizeInfo.organizeBm']}" />
				<h:outputText id="organizeBm" value="#{torganizeInfoForm.torganizeInfo.organizeBm}" />
	            <h:inputHidden />
			    <x:message for="organizeBm" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="organizeLevel" styleClass="outputlabel" value="#{text['torganizeInfo.organizeLevel']}" />
				<h:outputText id="organizeLevel" value="#{torganizeInfoForm.torganizeInfo.organizeLevel}" />
	            <h:inputHidden />
			    <x:message for="organizeLevel" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="isCheck" styleClass="outputlabel" value="#{text['torganizeInfo.isCheck']}" />
				<be:outputText id="isCheck" value="#{torganizeInfoForm.torganizeInfo.isCheck}">					
                   <f:selectItem itemLabel="#{text['torganizeInfo.isCheck.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['torganizeInfo.isCheck.1']}" itemValue="1"/>
				</be:outputText>				
	            <h:inputHidden />
			    <x:message for="isCheck" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>

	
</f:view>
</body>	