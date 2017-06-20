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
<body onload="loadTcardbins();loadHidInfo();getDateObj()">

<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts" ;

try{
	parent.historyIframe.addHistory('/t_cardbin/t_cardbin_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tcardbinList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tcardbin.t_cardbin_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{tcardbinList.tcardbin}" />
	<t:saveState value="#{tcardbinList.queryFields}" />
	<t:saveState id="tcardbins" value="#{tcardbinList.tcardbins}" />
    <a4j:jsFunction name="moveUpTcardbin" action="#{tcardbinList.moveUp}"  reRender="tcardbinPanel,tcardbins"  oncomplete="rowIndexVarOfmoveUpTcardbin = -1">
	</a4j:jsFunction>	
    <a4j:jsFunction name="moveDownTcardbin" action="#{tcardbinList.moveDown}"  reRender="tcardbinPanel,tcardbins"  oncomplete="rowIndexVarOfmoveDownTcardbin = -1">
	</a4j:jsFunction>
	    <a4j:jsFunction name="deleteTcardbin" action="#{tcardbinList.delete}"  reRender="tcardbinPanel,tcardbins" oncomplete="rowIndexVarOfTcardbin = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTcardbin" action="#{tcardbinList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tcardbinList"  >
	<a4j:jsFunction name="loadTcardbins" action="#{tcardbinList.initTcardbins}" reRender="tcardbinPanel,tcardbins" />
<script>
		var rowIndexVarOfTcardbin = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tcardbin.t_cardbin_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tcardbinPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
		    <h:commandLink  onclick="if(rowIndexVarOfTcardbin == -1){alert('#{text['button.selected.confirm']}')}else{moveUpTcardbin();}return false" >
				<f:verbatim><span class="linkMoveUpImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.up']}" />
			</h:commandLink>
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
	        <h:commandLink onclick="if(rowIndexVarOfTcardbin == -1){alert('#{text['button.selected.confirm']}')}else{moveDownTcardbin();}return false" >
				<f:verbatim><span class="linkMoveDownImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.down']}"  />
			</h:commandLink>
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tcardbinList.edit}"  onclick="if(rowIndexVarOfTcardbin == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_cardbin.2c908349169f7cda0116a9a023420856']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_cardbin/t_cardbin_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tcardbinList.view}" onclick="if(rowIndexVarOfTcardbin == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_cardbin.2c908349169f7cda0116a9a023510857']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_cardbin/t_cardbin_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTcardbin == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTcardbin();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_cardbin.2c908349169f7cda0116a9a023610858']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{tcardbinList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_cardbin.2c908349169f7cda0116a9a023030853']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_cardbin/t_cardbin_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tcardbinRowIndex" value="#{tcardbinList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tcardbinDataTable" var="tcardbin"
				value="#{tcardbinList.tcardbins}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{tcardbinList.sortColumn}"
				sortAscending="#{tcardbinList.ascending}"
				binding="#{tcardbinList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTcardbin='#{rowIndexVar}';document.getElementById('tcardbinList:tcardbinRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="name" arrow="true">		                
							<h:outputText value="#{text['tcardbin.name']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="name" value="#{tcardbin.name}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="length" arrow="true">		                
							<h:outputText value="#{text['tcardbin.length']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="length" value="#{tcardbin.length}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="bin" arrow="true">		                
							<h:outputText value="#{text['tcardbin.bin']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="bin" value="#{tcardbin.bin}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="cupscard" arrow="true">		                
							<h:outputText value="#{text['tcardbin.cupscard']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="cupscard" value="#{tcardbin.cupscard}"  disabled="true"/>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="bank" arrow="true">		                
							<h:outputText value="#{text['tcardbin.bank']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="bank" value="#{tcardbin.bank}" />
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>