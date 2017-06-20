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
	parent.historyIframe.addHistory('/t_rule_instance/t_rule_instance_form_view_ViewForm.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceForm.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>','<fmt:message key="truleInstance.t_rule_instance_form_view_ViewForm.heading" />(<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceForm.truleInstance.id}").getValue(FacesContext.getCurrentInstance()) %>)',"1")
}catch(e){}
</script>

	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('truleQuery:searchtab')"><h:outputText value="选择子规则" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
   	
	<t:saveState value="#{truleInstanceList.queryFields.code}" />
	<h:form id="truleQuery" >
		<a4j:jsFunction name="queryTrules" action="#{truleInstanceList.ruleDispatch}" reRender="trulePanel,trules" oncomplete="document.getElementById('truleList').style.display='block';parent.dyniframesize('ruleInstanceFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('truleQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink id="ruleInstanceFrame" target="ruleInstanceFrame">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
					<f:param name="code" value="#{truleInstanceList.queryFields.code}"/>
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="id" value="规则名称  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="code" value="#{truleInstanceList.queryFields.code}">		
                   <f:selectItems value="#{selectItems.truleItems}"/>
				</h:selectOneMenu>								    
				</h:panelGroup>
			  </h:panelGrid>
			  
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="id" value="是否激活  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="enable" value="#{truleInstanceList.queryFields.enable}">
                   <f:selectItem itemLabel="激活" itemValue="0"/>
                   <f:selectItem itemLabel="关闭" itemValue="1"/>
				   <f:selectItem itemLabel="全部" itemValue="2"/>	                   
				</h:selectOneMenu>								    
				</h:panelGroup>
			  </h:panelGrid>			  
             <h:inputHidden/> 	
		</h:panelGrid>				
					
		</h:panelGrid>
	</h:form>

<f:verbatim>
<iframe frameborder="0" name="ruleInstanceFrame" id="ruleInstanceFrame" onload="dyniframesize('ruleInstanceFrame')" style="width:100%;overflow-y:auto;" src="" scrolling="yes"></iframe>
</f:verbatim>		
</f:view>
</body>	

<script language="javascript">
function ruleDispatch() {
	var ruleNo = document.getElementById("truleQuery:code");
	var ruleValue = ruleNo.value;
	var enableState = document.getElementById("truleQuery:enable");
	var enableValue = enableState.value;
	var tform = document.getElementById("truleQuery");
	window.open('<%=basePath%>/t_rule_instance/t_rule_instance_list_view_List.faces?_code='+ruleValue+'&_enable='+enableValue,'ruleInstanceFrame','')
}

function dyniframesize(iframename) {
  var pTar = null;
  if (document.getElementById){
    pTar = document.getElementById(iframename);
  }
  else{
    eval('pTar = ' + iframename + ';');
  }
  if (pTar && !window.opera){
	pTar.style.display="block"
	if (pTar.Document && pTar.Document.body.scrollHeight){
		pTar.style.height = pTar.Document.body.scrollHeight+200;
		pTar.parentNode.style.height=pTar.style.height;
	}
  }
}
</script>