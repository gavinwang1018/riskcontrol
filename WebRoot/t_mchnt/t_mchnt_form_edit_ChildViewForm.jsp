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
<body onload="loadTmchnt();loadHidInfo();">
<center>
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>
try{
	parent.historyIframe.addHistory('/t_mchnt/t_mchnt_form_edit_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','商户信息表(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tmchntForm.tmchnt.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tmchntForm.tmchntPrimaryKey}" />
	<h:form id="tmchntForm" style="width:96%">
    	<f:verbatim><div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"></f:verbatim><h:outputText value="#{text['tmchnt.t_mchnt_form_edit_ViewForm.heading']}" /><f:verbatim></a></li>
    	    </ul>
    	</div></f:verbatim>
	<a4j:jsFunction name="loadTmchnt" action="#{tmchntForm.loadTmchnt}" reRender="tmchntForm"></a4j:jsFunction>		
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
						

		</h:panelGrid>
	</h:form>
</f:view>
</center>
</body>	