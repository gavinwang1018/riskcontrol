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
	parent.historyIframe.addHistory('/t_organize_user/t_organize_user_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{torganizeUserForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="torganizeUser.t_organize_user_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{torganizeUserForm.torganizeUser.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'torganizeUserForm');"><a href="#"><h:outputText value="#{text['torganizeUser.t_organize_user_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{torganizeUserForm.torganizeUserPrimaryKey}" />
	<h:form id="torganizeUserForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{torganizeUserForm.edit}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_organize_user.2c90834916d142fa0116d2e900390044']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_organize_user/t_organize_user_EditForm.faces?_key=#{torganizeUserForm.torganizeUser.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{torganizeUserForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_organize_user.2c90834916d142fa0116d2e900490045']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_organize_user.2c90834916d142fa0116d2e8ff4f003f']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="organizeId" styleClass="outputlabel" value="#{text['torganizeUser.organizeId']}" />
				<h:outputLink id="organizeId_link" value="../t_organize_info/t_organize_info_ViewForm.faces?_key=#{torganizeUserForm.torganizeUser.organizeId}">
    				<h:outputText id="organizeId" value="#{torganizeUserForm.torganizeUser.organizeIdOfTorganizeInfo.name}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="organizeId" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="userId" styleClass="outputlabel" value="#{text['torganizeUser.userId']}" />
				<h:outputLink id="userId_link" value="../t_user_info/t_user_info_ViewForm.faces?_key=#{torganizeUserForm.torganizeUser.userId}">
    				<h:outputText id="userId" value="#{torganizeUserForm.torganizeUser.userIdOfTuserInfo.id}"/>
				</h:outputLink>	
	            <h:inputHidden />
			    <x:message for="userId" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="type" styleClass="outputlabel" value="#{text['torganizeUser.type']}" />
				<h:selectBooleanCheckbox id="type" value="#{torganizeUserForm.torganizeUser.type}" disabled="true"/> 
	            <h:inputHidden />
			    <x:message for="type" styleClass="fieldError" />
			</h:panelGrid>

  

				<h:outputText value="" />
  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>

	
</f:view>
</body>	