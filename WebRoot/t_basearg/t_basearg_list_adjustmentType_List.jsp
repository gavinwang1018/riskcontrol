<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="cn.com.brilliance.begen.common.BeGenHistory"%>
<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage" %>
<%
String basePath = request.getContextPath();
javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().setLocale(cn.com.brilliance.begen.common.bundle.ResourceBundle.getLocale(request));

%>
<head>
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/config.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/styles/right.css" />

<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>

<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/calculator.js"></script>
<script language=javascript src="<%=basePath%>/scripts/getreset.js"></script>
</head>
<body onload="loadTbaseargs();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_basearg/t_basearg_adjustment_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tbaseargList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tbasearg.t_basearg_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tbaseargList.tbasearg}" />
	<t:saveState value="#{tbaseargList.queryFields}" />
	<t:saveState id="tbaseargs" value="#{tbaseargList.tbaseargs}" />
	    <a4j:jsFunction name="deleteTbasearg" action="#{tbaseargList.delete}"  reRender="tbaseargPanel,tbaseargs" oncomplete="rowIndexVarOfTbasearg = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTbasearg" action="#{tbaseargList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tbaseargList"  >
	<a4j:jsFunction name="loadTbaseargs" action="#{tbaseargList.initAdjustmentType}" reRender="tbaseargPanel,tbaseargs" />
<script>
		var rowIndexVarOfTbasearg = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tbasearg.t_basearg_adjustment_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tbaseargPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tbaseargList.saveAdjustment}"  rendered="#{sessionScope._user_info.actionMap['action.39'] == 'true'}">				   
				<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.save']}" />
				
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			
			
			<h:panelGrid columns="8" cellspacing="2" cellpadding="5" >
								
				<h:panelGroup>
				<h:outputLabel styleClass="fontnormal" for="adjust" value="贷记调整" />
			    <h:selectBooleanCheckbox id="adjust" value="#{tbaseargList.adjust}"/>
				</h:panelGroup>
				<h:panelGroup>
				<h:outputLabel styleClass="fontnormal" for="turnback" value="退单" />	
			    <h:selectBooleanCheckbox id="turnback" value="#{tbaseargList.turnback}"/>
				</h:panelGroup>
				
				<h:panelGroup>
				<h:outputLabel styleClass="fontnormal" for="askfund" value="请款" />	
			    <h:selectBooleanCheckbox id="askfund" value="#{tbaseargList.askfund}"/>
				</h:panelGroup>
				
				<h:panelGroup>
				<h:outputLabel styleClass="fontnormal" for="returnback" value="二次退单" />		
			    <h:selectBooleanCheckbox id="returnback" value="#{tbaseargList.returnback}"/>
				</h:panelGroup>
				
				<h:panelGroup>
				<h:outputLabel styleClass="fontnormal" for="reaskfund" value="再请款" />		
			    <h:selectBooleanCheckbox id="reaskfund" value="#{tbaseargList.reaskfund}"/>
				</h:panelGroup>
				
				<h:panelGroup>
				<h:outputLabel styleClass="fontnormal" for="others" value="其他" />
			    <h:selectBooleanCheckbox id="others" value="#{tbaseargList.others}"/>
				</h:panelGroup>
			  	</h:panelGrid>
			  
		</h:panelGrid>

	</h:form>
</f:view>
</body>