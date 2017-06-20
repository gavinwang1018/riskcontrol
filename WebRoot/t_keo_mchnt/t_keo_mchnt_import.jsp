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
<body onload="loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_keo_mchnt/t_keo_mchnt_import.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{keoMchntImport.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tkeoMchnt.tkeoMchntimport.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('keoMchntImport:searchtab')"><h:outputText value="#{text['tkeoMchnt.tkeoMchntimport.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="keoMchntImport" enctype="multipart/form-data" > 
		
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="type" value="导入文件格式" />				
				<h:panelGroup>
					<h:outputLink value="t_keo_mchnt_import_example.jsp" target="_blank" >  <f:verbatim>查看</f:verbatim></h:outputLink>
					
				</h:panelGroup>
				
			  </h:panelGrid>
		
		
		<h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="type" value="#{text['tkeoMchnt.type']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="type" value="#{keoMchntImport.type}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.7']}" itemValue="7"/>
                   <f:selectItem itemLabel="#{text['tkeoMchnt.type.8']}" itemValue="8"/>
				</h:selectOneMenu >				
				</h:panelGroup>
				
			  </h:panelGrid>
		
		
		<h:panelGrid columns="4" cellspacing="4" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch" style="width:1500px">
				<h:outputLabel for="myFiledId" value="文件: "/>
				<h:panelGroup >
					<x:inputFileUpload id="myFileId" value="#{keoMchntImport.myFile}" storage="file" required="true" style="width:'100%';"/>
						<h:message for="myFiledId"/>
				
				</h:panelGroup>
				<h:panelGroup>
					<h:commandButton id="import" value="导入文件" action="#{keoMchntImport.processMyFile}" onclick="if (document.getElementById('keoMchntImport:type').value==''){
												 alert('请选择类型');return false}
												 if (document.getElementById('keoMchntImport:myFileId').value==''){
												 alert('请选择文件');return false}
												 if (document.getElementById('keoMchntImport:type').value=='1'){
												
												 if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.1']}')){
												    return false;}			
											}
											if (document.getElementById('keoMchntImport:type').value=='2'){
												if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.2']}' )){
												    return false;}							
											}
											if (document.getElementById('keoMchntImport:type').value=='3'){
												if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.3']}')){
												    return false;}							
											}
											if (document.getElementById('keoMchntImport:type').value=='4'){
												if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.4']}')){
												    return false;}							
											}
											if (document.getElementById('keoMchntImport:type').value=='7'){
												if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.7']}' )){
												    return false;}							
											}
											if (document.getElementById('keoMchntImport:type').value=='8'){
												if (!confirm('您选择的风险类型是:'+'#{text['tkeoMchnt.type.8']}' )){
												    return false;}							
											} "  rendered="#{sessionScope._user_info.actionMap['action.51'] == 'true'}"/>
					 
				</h:panelGroup>
				 <x:message for="import" styleClass="fieldError" />
			  </h:panelGrid>
					
		
			
	
		</h:panelGrid>
	</h:form>
	
	
</f:view>
</body>