<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
  <t:saveState value="#{fileAction}" />
  <h:form id="fileAction" enctype="multipart/form-data">
    <h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable2,rowTable2" headerClass="mainHeader" footerClass="mainFooter"> 
        <h:panelGrid>
	 <h:outputLabel for="file" styleClass="outputlabel" value="#{text['message.hint.import']}" />    
         <x:inputFileUpload id="uploadFile" value="#{fileAction.uploadFile}" storage="file"/>
        </h:panelGrid>    
       <f:facet name="footer">
	  <h:panelGroup>        
             <h:commandButton value="#{text['button.import']}" action="#{fileAction.doImport}" styleClass="button"/>
          </h:panelGroup>
       </f:facet>  
     </h:panelGrid>        
  </h:form>
</f:view>