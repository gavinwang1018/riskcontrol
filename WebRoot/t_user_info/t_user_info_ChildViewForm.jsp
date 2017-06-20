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
<body onload="loadTuserInfo();loadHidInfo();">
<center>
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>
try{
	parent.historyIframe.addHistory('/t_user_info/t_user_info_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tuserInfoForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','用户信息(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tuserInfoForm.tuserInfo.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tuserInfoForm.tuserInfoPrimaryKey}" />
	<h:form id="tuserInfoForm" style="width:96%">
    	<f:verbatim><div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"></f:verbatim><h:outputText value="#{text['tuserInfo.t_user_info_ViewForm.heading']}" /><f:verbatim></a></li>
    	    </ul>
    	</div></f:verbatim>
	<a4j:jsFunction name="loadTuserInfo" action="#{tuserInfoForm.loadTuserInfo}" reRender="tuserInfoForm"></a4j:jsFunction>		
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
				<h:outputText value="#{text['section.t_user_info.2c908349169f7cda0116a9936eb10764']}" />
			</f:facet>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="loginName" styleClass="outputlabel" value="#{text['tuserInfo.loginName']}" />
				<h:outputText id="loginName" value="#{tuserInfoForm.tuserInfo.loginName}" />
	            <h:inputHidden />
			    <x:message for="loginName" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="name" styleClass="outputlabel" value="#{text['tuserInfo.name']}" />
				<h:outputText id="name" value="#{tuserInfoForm.tuserInfo.name}" />
	            <h:inputHidden />
			    <x:message for="name" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="password" styleClass="outputlabel" value="#{text['tuserInfo.password']}" />
	            <h:inputHidden />
			    <x:message for="password" styleClass="fieldError" />
			</h:panelGrid>

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitleView,colValueView">
				<h:outputLabel for="email" styleClass="outputlabel" value="#{text['tuserInfo.email']}" />
				<h:outputText id="email" value="#{tuserInfoForm.tuserInfo.email}" />
	            <h:inputHidden />
			    <x:message for="email" styleClass="fieldError" />
			</h:panelGrid>

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	</h:form>
</f:view>
</center>
</body>	