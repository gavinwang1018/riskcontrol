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
<body onload="loadTriskcaseAttachments();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_riskcase_attachment/t_riskcase_attachment_add_paper_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskcaseAttachmentList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="triskcaseAttachment.t_riskcase_attachment_add_paper_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{triskcaseAttachmentList.triskcaseAttachment}" />
	<t:saveState value="#{triskcaseAttachmentList.queryFields}" />
	<t:saveState id="triskcaseAttachments" value="#{triskcaseAttachmentList.triskcaseAttachments}" />
	    <a4j:jsFunction name="deleteTriskcaseAttachment" action="#{triskcaseAttachmentList.delete}"  reRender="triskcaseAttachmentPanel,triskcaseAttachments" oncomplete="rowIndexVarOfTriskcaseAttachment = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTriskcaseAttachment" action="#{triskcaseAttachmentList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="triskcaseAttachmentList"  >
	<a4j:jsFunction name="loadTriskcaseAttachments" action="#{triskcaseAttachmentList.initTriskcaseAttachments}" reRender="triskcaseAttachmentPanel,triskcaseAttachments" />
<script>
		var rowIndexVarOfTriskcaseAttachment = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcaseAttachment.t_riskcase_attachment_add_paper_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="triskcaseAttachmentPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseAttachmentList.edit}"  onclick="if(rowIndexVarOfTriskcaseAttachment == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase_attachment_add_paper.2c908349171feac401172026bd7f0041']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase_attachment/t_riskcase_attachment_add_paper_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskcaseAttachmentList.view}" onclick="if(rowIndexVarOfTriskcaseAttachment == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase_attachment_add_paper.2c908349171feac401172026bdad0042']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskcase_attachment/t_riskcase_attachment_add_paper_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTriskcaseAttachment == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTriskcaseAttachment();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskcase_attachment_add_paper.2c908349171feac401172026bdbd0043']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{triskcaseAttachmentList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_riskcase_attachment_add_paper.2c908349171feac401172026bd500040']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_riskcase_attachment/t_riskcase_attachment_add_paper_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="triskcaseAttachmentRowIndex" value="#{triskcaseAttachmentList.rowIndex}"></h:inputHidden>
			<t:dataTable id="triskcaseAttachmentDataTable" var="triskcaseAttachment"
				value="#{triskcaseAttachmentList.triskcaseAttachments}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{triskcaseAttachmentList.sortColumn}"
				sortAscending="#{triskcaseAttachmentList.ascending}"
				binding="#{triskcaseAttachmentList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTriskcaseAttachment='#{rowIndexVar}';document.getElementById('triskcaseAttachmentList:triskcaseAttachmentRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="riskcaseId" arrow="true">		                
							<h:outputText value="#{text['triskcaseAttachment.riskcaseId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="riskcaseId_link" value="../t_riskcase/t_riskcase_ViewForm.faces?_key=#{triskcaseAttachment.riskcaseId}">
				  <h:outputText id="riskcaseId" value="#{triskcaseAttachment.riskcaseIdOfTriskcase.id}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="filename" arrow="true">		                
							<h:outputText value="#{text['triskcaseAttachment.filename']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink value="../FileDownloadServlet" styleClass="listbtn" rendered="#{not empty triskcaseAttachment.filename}">
					<f:param name="fileLocation" value="t_riskcase_attachment/#{triskcaseAttachment.id}/#{triskcaseAttachment.filename}"/>
					<f:param name="fileName" value="#{triskcaseAttachment.filename}"/>
					<h:outputText value="#{triskcaseAttachment.filename}"/>
				</h:outputLink>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="content" arrow="true">		                
							<h:outputText value="#{text['triskcaseAttachment.content']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="content" value="#{triskcaseAttachment.content}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="sortcode" arrow="true">		                
							<h:outputText value="#{text['triskcaseAttachment.sortcode']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="sortcode" value="#{triskcaseAttachment.sortcode}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="caseno" arrow="true">		                
							<h:outputText value="#{text['triskcaseAttachment.caseno']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="caseno_link" value="../t_riskcase/t_riskcase_ViewForm.faces?_key=#{triskcaseAttachment.caseno}">
				  <h:outputText id="caseno" value="#{triskcaseAttachment.casenoOfTriskcase.id}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="userId" arrow="true">		                
							<h:outputText value="#{text['triskcaseAttachment.userId']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="userId" value="#{triskcaseAttachment.userId}" />
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>