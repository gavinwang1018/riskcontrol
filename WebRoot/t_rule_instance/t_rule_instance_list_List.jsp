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
	parent.historyIframe.addHistory('/t_rule_instance/t_rule_instance_list_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleInstanceList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="truleInstance.t_rule_instance_list_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('truleInstanceQuery:searchtab')"><h:outputText value="#{text['truleInstance.truleInstanceQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="truleInstanceQuery" >
		<a4j:jsFunction name="queryTruleInstances" action="#{truleInstanceList.query}" reRender="truleInstancePanel,truleInstances" oncomplete="document.getElementById('truleInstanceList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('truleInstanceQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTruleInstances();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="code" value="#{text['truleInstance.code']}  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="code" value="#{truleInstanceList.queryFields.code}">	
				   <f:selectItem itemLabel="全部" itemValue=""/>
                   <f:selectItems value="#{extSelectItems.truleItems}"/>
				</h:selectOneMenu>			    
				</h:panelGroup>
			  </h:panelGrid>



             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="enable" value="#{text['truleInstance.enable']}  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="enable" value="#{truleInstanceList.queryFields.enable}">
					<f:selectItems value="#{extSelectItems.enableQueriesItems}"/>
				</h:selectOneMenu>
				</h:panelGroup>
			  </h:panelGrid>



		</h:panelGrid>				
			<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
	             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
					<h:outputLabel styleClass="fontnormal" for="code" value="所属机构  #{text['query.equal']}" />				
					<h:panelGroup>
					<h:selectOneMenu id="belongToInst" value="#{truleInstanceList.queryFields.belongToInst}">	
	                   <f:selectItems value="#{extSelectItems.belongToInstForRuleItems}"/>
					</h:selectOneMenu>			    
					</h:panelGroup>
				  </h:panelGrid>
			</h:panelGrid>		
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{truleInstanceList.truleInstance}" />
	<t:saveState value="#{truleInstanceList.queryFields}" />
	<t:saveState id="truleInstances" value="#{truleInstanceList.truleInstances}" />
	    <a4j:jsFunction name="deleteTruleInstance" action="#{truleInstanceList.close}"  reRender="truleInstancePanel,truleInstances" oncomplete="rowIndexVarOfTruleInstance = -1">
	</a4j:jsFunction>
	    <a4j:jsFunction name="activate" action="#{truleInstanceList.activate}"  reRender="truleInstancePanel,truleInstances" oncomplete="rowIndexVarOfTruleInstance = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTruleInstance" action="#{truleInstanceList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
		<a4j:actionparam name="param2" assignTo="#{truleInstanceList.queryFields.code}" value="document.getElementById('truleInstanceQuery:code').value" noEscape="true"/> 		
	</a4j:jsFunction>	
	<h:form id="truleInstanceList" >
<script>
		var rowIndexVarOfTruleInstance = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['truleInstance.t_rule_instance_list_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="truleInstancePanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTruleInstance == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('是否启用')){activate();}return false" >
				<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="启用" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>


<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleInstanceList.edit}"  onclick="if(rowIndexVarOfTruleInstance == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_list.2c90834916f039110116f0ee5185002f']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="ext_rule_instance/ext_t_rule_instance_EditForm_1" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleInstanceList.view}" onclick="if(rowIndexVarOfTruleInstance == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_list.2c90834916f039110116f0ee51a40030']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="url:../ext_rule_instance/ext_t_rule_instance_ViewForm_#{truleInstanceList.queryFields.code}.faces?code=#{truleInstanceList.queryFields.code}&belongToInst=#{truleInstanceList.queryFields.belongToInst}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTruleInstance == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.disable']}')){deleteTruleInstance();}return false" >
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="注销" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink onclick="if(document.getElementById('truleInstanceQuery:code').value==''){alert('请选择某一确定的子规则再添加记录');return false}else{addTruleInstance();}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_rule_instance_list.2c90834916f039110116f0ee5165002e']}" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="truleInstanceRowIndex" value="#{truleInstanceList.rowIndex}"></h:inputHidden>
			<t:dataTable id="truleInstanceDataTable" var="truleInstance"
				value="#{truleInstanceList.truleInstances}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{truleInstanceList.sortColumn}"
				sortAscending="#{truleInstanceList.ascending}"
				binding="#{truleInstanceList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTruleInstance='#{rowIndexVar}';document.getElementById('truleInstanceList:truleInstanceRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="code" arrow="true">		                
							<h:outputText value="#{text['truleInstance.code']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="code" value="#{truleInstance.code}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="description" arrow="true">		                
							<h:outputText value="#{text['truleInstance.description']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="description" value="#{truleInstance.description}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="versionBm" arrow="true">		                
							<h:outputText value="#{text['truleInstance.versionBm']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="versionBm" value="#{truleInstance.versionBm}" />
				</t:column>
			
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="belongToInst" arrow="true">		                
							<h:outputText value="所属机构" />
						</t:commandSortHeader>	
				</f:facet>
					<h:outputText id="belongToInst" value="#{truleInstance.belongToInstOfTorganizeInfo.name}" />		
				</t:column>
								
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="enable" arrow="true">		                
							<h:outputText value="是否激活" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="enable" value="#{truleInstance.enable}"  disabled="true"/>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="cycle" arrow="true">		                
							<h:outputText value="#{text['truleInstance.cycle']}" />
						</t:commandSortHeader>	
				</f:facet>
					<be:outputText id="cycle" value="#{truleInstance.cycle}">
<f:selectItem itemLabel="天" itemValue="1" />
<f:selectItem itemLabel="周" itemValue="2" />
<f:selectItem itemLabel="半月" itemValue="3" />
<f:selectItem itemLabel="月" itemValue="4" />
					</be:outputText>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="timeParam" arrow="true">		                
							<h:outputText value="#{text['truleInstance.timeParam']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="timeParam" value="#{truleInstance.timeParam}" />
				</t:column>

				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="supportTrace" arrow="true">		                
							<h:outputText value="是否需要回溯" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="supportTrace" value="#{truleInstance.supportTrace}" disabled="true"/>
				</t:column>
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="truleInstance_scroll_1" 
                    for="truleInstanceDataTable"
                    rowsCountVar="rowsCount"
                    displayedRowsCountVar="displayedRowsCountVar"
                    firstRowIndexVar="firstRowIndex"
                    lastRowIndexVar="lastRowIndex"
                    pageCountVar="pageCount"
                    immediate="true"
                    pageIndexVar="pageIndex"
                    paginator="true"
                    paginatorMaxPages="9"

                    >
			<f:facet name="first" >
                <h:outputText value="#{text['page.first']}"/>
            </f:facet>
            <f:facet name="last">
                <h:outputText value="#{text['page.last']}"/>
            </f:facet>
            <f:facet name="previous">
                <h:outputText value="#{text['page.previous']}"/>
            </f:facet>
            <f:facet name="next">
                <h:outputText value="#{text['page.next']}"/>
            </f:facet>
            </t:dataScroller> 			
            <t:dataScroller id="truleInstance_scroll_2" 
                    for="truleInstanceDataTable"
                    rowsCountVar="rowsCount"
                    displayedRowsCountVar="displayedRowsCountVar"
                    firstRowIndexVar="firstRowIndex"
                    lastRowIndexVar="lastRowIndex"
                    pageCountVar="pageCount"
                    immediate="true"
                    pageIndexVar="pageIndex"
                    >
                <h:outputFormat value="#{text['pageFooter']}" styleClass="standard" >
                    <f:param value="#{rowsCount}" />
                    <f:param value="#{displayedRowsCountVar}" />
                    <f:param value="#{firstRowIndex}" />
                    <f:param value="#{lastRowIndex}" />
                    <f:param value="#{pageIndex}" />
                    <f:param value="#{pageCount==0?1:pageCount}" />
                </h:outputFormat>
             </t:dataScroller>           
            </h:panelGrid>


		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >

			
			<h:panelGroup>
        		<f:verbatim><ul id="tool_r"></f:verbatim>
					<f:verbatim><li></f:verbatim>
						<h:panelGroup >
								 <h:commandLink  onclick="if(rowIndexVarOfTruleInstance == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('是否启用')){activate();}return false" >
									<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="启用" />
								</h:commandLink>							
						</h:panelGroup>
					<f:verbatim></li></f:verbatim>


					<f:verbatim><li></f:verbatim>
						<h:panelGroup >
							<h:commandLink action="#{truleInstanceList.edit}"  onclick="if(rowIndexVarOfTruleInstance == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
								<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_list.2c90834916f039110116f0ee5185002f']}" />
								<t:updateActionListener property="#{actionParameter.successAction}" value="ext_rule_instance/ext_t_rule_instance_EditForm_1" />
							</h:commandLink>							
						</h:panelGroup>
					<f:verbatim></li></f:verbatim>

					<f:verbatim><li></f:verbatim>
						<h:panelGroup >
							<h:commandLink action="#{truleInstanceList.view}" onclick="if(rowIndexVarOfTruleInstance == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
								<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_instance_list.2c90834916f039110116f0ee51a40030']}" />
								<t:updateActionListener property="#{actionParameter.successAction}" value="url:../ext_rule_instance/ext_t_rule_instance_ViewForm_#{truleInstanceList.queryFields.code}.faces?code=#{truleInstanceList.queryFields.code}&belongToInst=#{truleInstanceList.queryFields.belongToInst}" />
							</h:commandLink>	
						</h:panelGroup>
					<f:verbatim></li></f:verbatim>
	
					<f:verbatim><li></f:verbatim>
						<h:panelGroup >
								 <h:commandLink  onclick="if(rowIndexVarOfTruleInstance == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.disable']}')){deleteTruleInstance();}return false" >
									<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="注销" />
								</h:commandLink>	
						</h:panelGroup>
					<f:verbatim></li></f:verbatim>
       
					<f:verbatim><li></f:verbatim>
						<h:panelGroup >
							<h:commandLink onclick="if(document.getElementById('truleInstanceQuery:code').value==''){alert('请选择某一确定的子规则再添加记录');return false}else{addTruleInstance();}"  >
								<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_rule_instance_list.2c90834916f039110116f0ee5165002e']}" />
							</h:commandLink>
						</h:panelGroup>
					<f:verbatim></li></f:verbatim>
	
				<f:verbatim></ul></f:verbatim>
    		</h:panelGroup>
    		
			<h:panelGroup>
				<f:verbatim><ul id="tool_r"></f:verbatim>
				<f:verbatim></ul></f:verbatim>
			</h:panelGroup>
    	</h:panelGrid>



		</h:panelGrid>

	</h:form>
</f:view>
</body>