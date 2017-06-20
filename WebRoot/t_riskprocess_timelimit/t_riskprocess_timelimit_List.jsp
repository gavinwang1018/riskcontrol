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
	parent.historyIframe.addHistory('/t_riskprocess_timelimit/t_riskprocess_timelimit_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{triskprocessTimelimitList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="triskprocessTimelimit.t_riskprocess_timelimit_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('triskprocessTimelimitQuery:searchtab')"><h:outputText value="#{text['triskprocessTimelimit.triskprocessTimelimitQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="triskprocessTimelimitQuery" >
		<a4j:jsFunction name="queryTriskprocessTimelimits" action="#{triskprocessTimelimitList.query}" reRender="triskprocessTimelimitPanel,triskprocessTimelimits" oncomplete="document.getElementById('triskprocessTimelimitList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('triskprocessTimelimitQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTriskprocessTimelimits();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="belongToInst" value="#{text['triskprocessTimelimit.belongToInst']}  #{text['query.equal']}" />				
				
				<h:panelGroup>
				<h:selectOneMenu id="belongToInst" value="#{triskprocessTimelimitList.queryFields.belongToInst}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="warnLevel" value="#{text['triskprocessTimelimit.warnLevel']}  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="warnLevel" value="#{triskprocessTimelimitList.queryFields.warnLevel}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItems value="#{extSelectItems.nameOfWarnLevel}"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>


		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{triskprocessTimelimitList.triskprocessTimelimit}" />
	<t:saveState value="#{triskprocessTimelimitList.queryFields}" />
	<t:saveState id="triskprocessTimelimits" value="#{triskprocessTimelimitList.triskprocessTimelimits}" />
	    <a4j:jsFunction name="deleteTriskprocessTimelimit" action="#{triskprocessTimelimitList.delete}"  reRender="triskprocessTimelimitPanel,triskprocessTimelimits" oncomplete="rowIndexVarOfTriskprocessTimelimit = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTriskprocessTimelimit" action="#{triskprocessTimelimitList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="triskprocessTimelimitList"  >
<script>
		var rowIndexVarOfTriskprocessTimelimit = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskprocessTimelimit.t_riskprocess_timelimit_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="triskprocessTimelimitPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{triskprocessTimelimitList.edit}"  onclick="if(rowIndexVarOfTriskprocessTimelimit == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.34'] == 'true'}">				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskprocess_timelimit.2c908349171a86da01171a9c4e9d004e']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_riskprocess_timelimit/t_riskprocess_timelimit_form_edit_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTriskprocessTimelimit == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTriskprocessTimelimit();}return false" rendered="#{sessionScope._user_info.actionMap['action.34'] == 'true'}">
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_riskprocess_timelimit.2c908349171a86da01171a9c4eeb0050']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{triskprocessTimelimitList.add}"  rendered="#{sessionScope._user_info.actionMap['action.34'] == 'true'}">
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_riskprocess_timelimit.2c908349171a86da01171a9c4e7e004d']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_riskprocess_timelimit/t_riskprocess_timelimit_form_add_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="triskprocessTimelimitRowIndex" value="#{triskprocessTimelimitList.rowIndex}"></h:inputHidden>
			<t:dataTable id="triskprocessTimelimitDataTable" var="triskprocessTimelimit"
				value="#{triskprocessTimelimitList.triskprocessTimelimits}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{triskprocessTimelimitList.sortColumn}"
				sortAscending="#{triskprocessTimelimitList.ascending}"
				binding="#{triskprocessTimelimitList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTriskprocessTimelimit='#{rowIndexVar}';document.getElementById('triskprocessTimelimitList:triskprocessTimelimitRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="belongToInst" arrow="true">		                
							<h:outputText value="#{text['triskprocessTimelimit.belongToInst']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="belongToInst_link" value="../t_organize_info/t_organize_info_ViewForm.faces?_key=#{triskprocessTimelimit.belongToInst}">
				  <h:outputText id="belongToInst" value="#{triskprocessTimelimit.belongToInstOfTorganizeInfo.name}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="warnLevel" arrow="true">		                
							<h:outputText value="#{text['triskprocessTimelimit.warnLevel']}" />
						</t:commandSortHeader>	
				</f:facet>
				<be:outputText id="warnLevel" value="#{triskprocessTimelimit.wevel.name}">
                   
				</be:outputText>
				
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="timeLimit" arrow="true">		                
							<h:outputText value="#{text['triskprocessTimelimit.timeLimit']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="timeLimit" value="#{triskprocessTimelimit.timeLimit}" />
				</t:column>
				
			</t:dataTable>

		</h:panelGrid>

	</h:form>
</f:view>
</body>