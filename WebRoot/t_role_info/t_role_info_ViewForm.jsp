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
	parent.historyIframe.addHistory('/t_role_info/t_role_info_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{troleInfoForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="troleInfo.t_role_info_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{troleInfoForm.troleInfo.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

<div class="mytab1">
    <ul class="myTabBar1"  id="listUl">
		<LI onclick="showListBefore()" style="display:none"><a href="#"><</a></LI>
<LI class="Selected" onclick="changeChildListForm(this,'troleInfoForm');"><a href="#"><h:outputText value="#{text['troleInfo.t_role_info_ViewForm.heading']}" /></a></LI>
<LI onclick="showListAfter()"  style="display:none"><a href="#">></a></LI>
</ul>
</div>
	<t:saveState value="#{troleInfoForm.troleInfoPrimaryKey}" />
	<h:form id="troleInfoForm" >
		<h:inputHidden id="forId"/>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{troleInfoForm.edit}" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_role_info.2c908349169f7cda0116a4b9dee9061d']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_role_info/t_role_info_EditForm.faces?_key=#{troleInfoForm.troleInfo.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink
						action="#{troleInfoForm.delete}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionview.t_role_info.2c908349169f7cda0116a4b9df08061e']}" />
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim><li></f:verbatim>
					<h:commandLink action="#{troleInfoForm.authControl}" rendered="#{sessionScope._user_info.actionMap['action.21'] == 'true'}">				
						<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="权限设置" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="url:../ext_right/ext_role_menu_right.faces?_roleId=#{troleInfoForm.troleInfo.id}"/>
					</h:commandLink>	
<f:verbatim></li></f:verbatim>
<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
		
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_role_info.2c908349169f7cda0116a4ba53ea0626']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="name" styleClass="outputlabel" value="#{text['troleInfo.name']}" />
				<h:outputText id="name" value="#{troleInfoForm.troleInfo.name}" />
	            <h:inputHidden />
			    <x:message for="name" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="code" styleClass="outputlabel" value="#{text['troleInfo.code']}" />
				<h:outputText id="code" value="#{troleInfoForm.troleInfo.code}" />
	            <h:inputHidden />
			    <x:message for="code" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>

	
</f:view>
</body>	