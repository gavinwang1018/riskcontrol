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
<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/calculator.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/edit.js"></script>
<script>
var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;
</script>
</head>
<body onload="loadTriskcaseAttachment();getDateObj();">
<center>
<input type="hidden" name="checkcontent" id="checkcontent">
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>

	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseAttachmentForm.triskcaseAttachmentPrimaryKey}" />
	<t:saveState value="#{triskcaseAttachmentForm.triskcaseAttachment}" />

	<h:form id="triskcaseAttachmentForm" enctype="multipart/form-data" style="width:96%;">
	<div class="mytab1">
	    <ul class="myTabBar1">
	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcaseAttachment.t_riskcase_attachment_info_inst_EditForm.heading']}" /></a></li>
	    </ul>
	</div>
	<a4j:jsFunction name="loadTriskcaseAttachment" action="#{triskcaseAttachmentForm.loadTriskcaseAttachment}" reRender="triskcaseAttachmentForm" oncomplete="loadDateSelect()"></a4j:jsFunction>
    	<f:verbatim><div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"></f:verbatim><h:outputText value="#{text['triskcaseAttachment.t_riskcase_attachment_info_inst_EditForm.heading']}" /><f:verbatim></a></li>
    	    </ul>
    	</div>
		</f:verbatim>
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>?


		     <f:verbatim><li></f:verbatim>
		      <h:commandLink action="#{triskcaseAttachmentForm.popSave}" tabindex="1"  onclick="  if(!validateTriskcaseAttachmentForm(document.getElementById('triskcaseAttachmentForm')))return; ">
					<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionedit.t_riskcase_attachment_info_inst.2c9083491752314901175237c9ae004a']}"/>
					</h:commandLink>
					<f:verbatim></li></f:verbatim>
			<f:verbatim><li></f:verbatim>
					<h:commandLink onclick="window.close()" >
					<f:verbatim><span class="linkCancelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.cancel']}" />				
					</h:commandLink>
				<f:verbatim></li></ul></f:verbatim>
			</h:panelGroup>
		</h:panelGrid>
			
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_riskcase_attachment_info_inst.2c9083491752314901175237ca2b004d']}" />
			</f:facet>	


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="caseno" styleClass="outputlabel" value="#{text['triskcaseAttachment.caseno']}" />
				<h:panelGroup>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>

	
					<h:outputText id="caseno" value="#{triskcaseAttachmentForm.triskcaseAttachment.caseno}" 
						title="#{triskcaseAttachmentForm.triskcaseAttachment.casenoOfTriskcase.id}" />	
                   </h:panelGroup>						
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="caseno" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="filename" styleClass="outputlabel" value="#{text['triskcaseAttachment.filename']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                       <h:panelGroup>
    	                  <x:inputFileUpload id="filename" value="#{triskcaseAttachmentForm.filename_File}" storage="file" onkeydown='return false;' tabindex="3">
        		                 </x:inputFileUpload>
		                 <h:panelGroup>
    	                    <h:outputLink value="../FileDownloadServlet" styleClass="listbtn" rendered="#{not empty triskcaseAttachmentForm.triskcaseAttachment.filename}"  target="_blank">
                              <f:param name="fileLocation" value="t_riskcase_attachment/#{triskcaseAttachmentForm.triskcaseAttachment.id}/filename"/>
                      		  <f:param name="fileName" value="#{triskcaseAttachmentForm.triskcaseAttachment.filename}"/>
			                  <h:outputText value="#{triskcaseAttachmentForm.triskcaseAttachment.filename}"/>
		                    </h:outputLink>
		                    <f:verbatim>&nbsp;</f:verbatim>
			                <h:commandLink value="#{text['button.delete']}" rendered="#{not empty triskcaseAttachmentForm.triskcaseAttachment.filename}"
				              action="#{triskcaseAttachmentForm.deleteFilenameFile}" onclick="if(!confirm('#{text['button.confirm.delete']}'))return false;" styleClass="listbtn"/>  
		                 </h:panelGroup>
                        </h:panelGroup>

						
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="filename" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>
		</h:panelGrid>

		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	</h:form>
	<s:validatorScript functionName="validateTriskcaseAttachmentForm" />	
<%@ include file="../calculator.jsp"%>
</f:view>
</center>
</body>