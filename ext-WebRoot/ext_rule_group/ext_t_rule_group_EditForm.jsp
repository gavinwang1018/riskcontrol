<%@ include file="/common/taglibs.jsp"%>

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page import="cn.com.brilliance.begen.common.webapp.action.ResultPage" %>
<%@page import="javax.faces.context.FacesContext"%>
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

</head>
<body onload="loadChild();getDateObj();loadDateSelect()">
<script>
var imagePath = "<%=basePath%>/images";
var scriptPath = "<%=basePath%>/scripts";

var childScript = "loadTruleInstanceGroupSegmentList();loadHidInfo()".split(";");
var scriptCount = 0;
function loadChild(){
	eval(childScript[scriptCount++]);
}	
</script>

<center>
<input type="hidden" name="checkcontent" id="checkcontent">
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>

	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{truleGroupForm.truleGroupPrimaryKey}" />
	<t:saveState value="#{truleGroupForm.truleGroup}" />


	<t:saveState value="#{truleInstanceGroupSegmentList.truleInstanceGroupSegment}" />
	<t:saveState value="#{truleInstanceGroupSegmentList.queryFields}" />
	<t:saveState id="truleInstanceGroupSegmentList" value="#{truleInstanceGroupSegmentList.truleInstanceGroupSegments}" />

	<h:form id="truleGroupForm" style="width:96%;">
	
	<a4j:jsFunction name="addTruleInstanceGroupSegment" action="#{truleInstanceGroupSegmentList.multiAdd}" reRender="truleInstanceGroupSegmentPanel,truleInstanceGroupSegmentList">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
		<a4j:actionparam name="param2" assignTo="#{truleInstanceGroupSegmentList.belongToInst}" value="document.getElementById('truleGroupForm:belongToInst').value" noEscape="true"/> 		
	</a4j:jsFunction>	
	
    <a4j:jsFunction name="deleteTruleInstanceGroupSegment" action="#{truleInstanceGroupSegmentList.deleteBuffer}"  reRender="truleInstanceGroupSegmentPanel" oncomplete="rowIndexVarOfTruleInstanceGroupSegment = -1" >
	</a4j:jsFunction>	
		
	<a4j:jsFunction name="loadTruleInstanceGroupSegmentList" action="#{truleInstanceGroupSegmentList.initTruleInstanceGroupSegments}" oncomplete="loadChild()" reRender="truleInstanceGroupSegmentPanel,truleInstanceGroupSegmentList"> 
		<a4j:actionparam name="param1" value="#{truleGroupForm.truleGroup.id}" assignTo="#{truleInstanceGroupSegmentList.truleGroupId}"  /> 
		<a4j:actionparam name="param2" value="#{truleGroupForm.truleGroup.belongToInst}" assignTo="#{truleInstanceGroupSegmentList.belongToInst}"  /> 		
	</a4j:jsFunction>

	
<script>
		var rowIndexVarOfTruleInstanceGroupSegment = -1;
</script>
	
    	<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['truleGroup.t_rule_group_form_EditForm.heading']}" /></a></li>
    	    </ul>
    	</div>
    	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
		            <h:commandLink action="#{truleGroupForm.saveData}" tabindex="1" rendered="#{sessionScope._user_info.actionMap['action.7'] == 'true'}" 
					  onclick=" if(!validateTruleGroupForm(document.getElementById('truleGroupForm')))return;">
						<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionedit.t_rule_group_form.2c90834916d142fa0116d302afaa014a']}" />
						<t:updateActionListener property="#{actionParameter.successAction}" value="t_rule_group/t_rule_group_list_List" />
					</h:commandLink>
<f:verbatim></li></f:verbatim>

	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
			</h:panelGrid>
			
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="sectionTable" headerClass="sectionHeader" footerClass="mainFooter2">
			<f:facet name="header">
				<h:outputText value="#{text['section.t_rule_group_form.2c90834916d142fa0116d30cafa901da']}" />
			</f:facet>	

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="belongToInst" styleClass="outputlabel" value="#{text['truleGroup.belongToInst']}" />
				<h:panelGroup>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>

	
                	<h:selectOneMenu id="belongToInst" value="#{truleGroupForm.truleGroup.belongToInst}"  style="width:'86%'" >
						  <f:selectItems value="#{extSelectItems.belongToInstForRuleItems}"/>
					</h:selectOneMenu>	
                   </h:panelGroup>						
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="belongToInst" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="enable" styleClass="outputlabel" value="#{text['truleGroup.enable']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:selectBooleanCheckbox id="enable" value="#{truleGroupForm.truleGroup.enable}"  readonly="false"  tabindex="4">
                    </h:selectBooleanCheckbox>
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="enable" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>


			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="rowTable3,rowTable3" headerClass="mainHeader" footerClass="mainFooter">
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="status" styleClass="outputlabel" value="#{text['truleGroup.status']}" />
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
	<h:panelGroup>
				          <h:selectOneMenu id="status" value="#{truleGroupForm.truleGroup.status}"  readonly="false"  tabindex="4"  style="width:86%">
                            <f:selectItem itemLabel="#{text['truleGroup.status.0']}" itemValue="0"/>
                            <f:selectItem itemLabel="#{text['truleGroup.status.1']}" itemValue="1"/>
				          </h:selectOneMenu >	
                       </h:panelGroup>

                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="status" styleClass="fieldError" />
			</h:panelGrid>
			

  

			<h:panelGrid columns="2" cellspacing="0" cellpadding="0" styleClass="sectionTable" columnClasses="colTitle,colValue">
				<h:outputLabel for="description" styleClass="outputlabel" value="#{text['truleGroup.description']}" />
	           <h:panelGroup>
	             <f:verbatim><span class="mustw"></span></f:verbatim>


	

                      <h:panelGroup>
			              <h:inputTextarea id="description" value="#{truleGroupForm.truleGroup.description}" rows="4" style="width:'86%';"   readonly="false" tabindex="5" styleClass="edit_textarea" >
					         <s:commonsValidator type="required" arg="#{text['truleGroup.description']}" client="true" server="false" />
                          </h:inputTextarea>			

                       </h:panelGroup>

				
                               </h:panelGroup>	            <h:inputHidden />
			    <x:message for="description" styleClass="fieldError" />
			</h:panelGrid>
			

  			</h:panelGrid>
		</h:panelGrid>
		</h:panelGrid>
	<input type="hidden" name="tdClospan" value="2">
	
	
	
	
	
	
		<f:verbatim>
			<span class="notw"></span>
		</f:verbatim>	
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="子规则权重设置" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="truleInstanceGroupSegmentPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTruleInstanceGroupSegment == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.disable']}')){deleteTruleInstanceGroupSegment();}return false" rendered="#{sessionScope._user_info.actionMap['action.7'] == 'true'}">
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_group_segment_list.2c90834916d142fa0116d3310b5702dd']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink onclick="addTruleInstanceGroupSegment();return false;"  rendered="#{sessionScope._user_info.actionMap['action.7'] == 'true'}">
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_rule_instance_group_segment_list.2c90834916d142fa0116d3310b0902da']}" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="truleInstanceGroupSegmentRowIndex" value="#{truleInstanceGroupSegmentList.rowIndex}"></h:inputHidden>
			<h:inputHidden id="ruleInstanceGroupId" value="#{truleGroupForm.truleGroup.id}"></h:inputHidden>
			<t:dataTable id="truleInstanceGroupSegmentDataTable" var="truleInstanceGroupSegment"
				value="#{truleInstanceGroupSegmentList.truleInstanceGroupSegments}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				sortColumn="#{truleInstanceGroupSegmentList.sortColumn}"
				sortAscending="#{truleInstanceGroupSegmentList.ascending}"
				binding="#{truleInstanceGroupSegmentList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" 
				rowOnClick="rowIndexVarOfTruleInstanceGroupSegment='#{rowIndexVar}';document.getElementById('truleGroupForm:truleInstanceGroupSegmentRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="ruleInstanceId" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.ruleInstanceId']}" />
						</t:commandSortHeader>	
				</f:facet>
					<h:selectOneMenu id="ruleInstanceId" value="#{truleInstanceGroupSegment.ruleInstanceId}" style="width:'100%'">
	  					  <f:selectItems value="#{truleInstanceGroupSegmentList.truleInstanceItems}"/>
					</h:selectOneMenu>	
				</t:column>
								
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="begin" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.begin']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:inputText id="begin" value="#{truleInstanceGroupSegment.begin}" tabindex="1" maxlength="6" styleClass="edit_input">
				</h:inputText>
				<x:message for="begin" styleClass="fieldError" />	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="end" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.end']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:inputText id="end" value="#{truleInstanceGroupSegment.end}" tabindex="2" maxlength="6" styleClass="edit_input">
				</h:inputText>
				<x:message for="end" styleClass="fieldError" />	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="propertion" arrow="true">		                
							<h:outputText value="#{text['truleInstanceGroupSegment.value']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:inputText id="value" value="#{truleInstanceGroupSegment.value}" tabindex="3" maxlength="12" styleClass="edit_input">
				</h:inputText>
				<x:message for="value" styleClass="fieldError" />	
				</t:column>
		
			</t:dataTable>

		</h:panelGrid>
		
		
		
		
			
	
	</h:form>
	<s:validatorScript functionName="validateTruleGroupForm" />
	<s:validatorScript functionName="validateTruleInstanceGroupSegmentForm" />	
<%@ include file="../calculator.jsp"%>
</f:view>
</body>