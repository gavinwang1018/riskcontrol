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
	parent.historyIframe.addHistory('/t_rule_group/t_rule_group_list_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{truleGroupList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="truleGroup.t_rule_group_list_List.heading" />","2")
}catch(e){}

function selAll(){
	var allInputs=document.getElementById("truleGroupList").getElementsByTagName("input");
    for(var i=0;i<allInputs.length;i++)
    {
    	if(allInputs[i].type=="checkbox" && getStrIndex(allInputs[i].name) != -1){
    		allInputs[i].checked=true;
    	}
    }
}

function unselAll(){
	var allInputs=document.getElementById("truleGroupList").getElementsByTagName("input");
    for(var i=0;i<allInputs.length;i++)
    {
    	if(allInputs[i].type=="checkbox" && getStrIndex(allInputs[i].name) != -1){
    		allInputs[i].checked=false;
    	}
    }
}

function getStrIndex(str1){
   var str2 = "check";
   var s = str1.indexOf(str2);
   return(s);
}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('truleGroupQuery:searchtab')"><h:outputText value="#{text['truleGroup.truleGroupQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="truleGroupQuery" >
		<a4j:jsFunction name="queryTruleGroups" action="#{truleGroupList.query}" reRender="truleGroupPanel,truleGroups" oncomplete="document.getElementById('truleGroupList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('truleGroupQuery'));" rendered="#{sessionScope._user_info.actionMap['action.5'] == 'true'}">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTruleGroups();return false;" rendered="#{sessionScope._user_info.actionMap['action.5'] == 'true'}">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="belongToInst" value="#{text['truleGroup.belongToInst']}  #{text['query.equal']}" />				
				<h:panelGroup>
                	<h:selectOneMenu id="belongToInst" value="#{truleGroupList.queryFields.belongToInst}"  style="width:'86%'" >
                		  <a4j:support event="onchange" action="#{truleGroupList.filterTruleGroups}" reRender="id" />
						  <f:selectItems value="#{truleGroupList.belongToInstForRuleItems}"/>
					</h:selectOneMenu>		
				</h:panelGroup>
			  </h:panelGrid>


             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="enable" value="#{text['truleGroup.enable']}  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="enable" value="#{truleGroupList.queryFields.enable}">
					<f:selectItem itemLabel="全部" itemValue=""/>
					<f:selectItem itemLabel="激活" itemValue="true"/>
					<f:selectItem itemLabel="注销" itemValue="false"/>	
				</h:selectOneMenu>				
				</h:panelGroup>
			  </h:panelGrid>
			  
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="enable" value="规则组编号 等于" />				
				<h:panelGroup>
                	<h:selectOneMenu id="id" value="#{truleGroupList.queryFields.id}"  style="width:'86%'" >
						  <f:selectItems value="#{truleGroupList.ruleGroups}"/>
					</h:selectOneMenu>				
				</h:panelGroup>
			  </h:panelGrid>			  

		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{truleGroupList.truleGroup}" />
	<t:saveState value="#{truleGroupList.queryFields}" />
	<t:saveState id="truleGroups" value="#{truleGroupList.truleGroups}" />
	    <a4j:jsFunction name="deleteTruleGroup" action="#{truleGroupList.multiClose}"  reRender="truleGroupPanel,truleGroups" oncomplete="rowIndexVarOfTruleGroup = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTruleGroup" action="#{truleGroupList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="truleGroupList"  >
<script>
		var rowIndexVarOfTruleGroup = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['truleGroup.t_rule_group_list_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="truleGroupPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleGroupList.edit}"  onclick="if(rowIndexVarOfTruleGroup == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.7'] == 'true'}">				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_group_list.2c90834916d142fa0116d302f2ed0152']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="ext_rule_group/ext_t_rule_group_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleGroupList.view}" onclick="if(rowIndexVarOfTruleGroup == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.6'] == 'true'}">				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_group_list.2c90834916d142fa0116d302f2fc0153']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="ext_rule_group/ext_t_rule_group_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="selAll();return false">
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="全选" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="unselAll();return false">
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="重置" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(confirm('#{text['button.confirm.disable']}')){deleteTruleGroup();}return false" rendered="#{sessionScope._user_info.actionMap['action.7'] == 'true'}">
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="注销" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{truleGroupList.add}" rendered="#{sessionScope._user_info.actionMap['action.7'] == 'true'}">
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_rule_group_list.2c90834916d142fa0116d302f2cd0151']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../ext_rule_group/ext_t_rule_group_EditForm.faces?enable=true" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="truleGroupRowIndex" value="#{truleGroupList.rowIndex}"></h:inputHidden>
			<t:dataTable id="truleGroupDataTable" var="truleGroup"
				value="#{truleGroupList.truleGroups}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{truleGroupList.sortColumn}"
				sortAscending="#{truleGroupList.ascending}"
				binding="#{truleGroupList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTruleGroup='#{rowIndexVar}';document.getElementById('truleGroupList:truleGroupRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['button.operator']}" />
					</f:facet>	
				 <h:panelGroup><f:verbatim><nobr></f:verbatim>

				<h:panelGroup >                                              
					<h:selectBooleanCheckbox id="check" value="#{truleGroup._checked_flag}" />
			        </h:panelGroup>
				 <f:verbatim><nobr></f:verbatim></h:panelGroup>					 	
				</t:column>					
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="belongToInst" arrow="true">		                
							<h:outputText value="#{text['truleGroup.belongToInst']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputLink id="belongToInst_link" value="../t_organize_info/t_organize_info_ViewForm.faces?_key=#{truleGroup.belongToInst}">
				  <h:outputText id="belongToInst" value="#{truleGroup.belongToInstOfTorganizeInfo.name}"/>
				</h:outputLink>	
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="description" arrow="true">		                
							<h:outputText value="#{text['truleGroup.description']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="description" value="#{truleGroup.description}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="enable" arrow="true">		                
							<h:outputText value="#{text['truleGroup.enable']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="enable" value="#{truleGroup.enable}"  disabled="true"/>
				</t:column>
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="truleGroup_scroll_1" 
                    for="truleGroupDataTable"
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
            <t:dataScroller id="truleGroup_scroll_2" 
                    for="truleGroupDataTable"
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
			<h:commandLink action="#{truleGroupList.edit}"  onclick="if(rowIndexVarOfTruleGroup == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.7'] == 'true'}">				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_group_list.2c90834916d142fa0116d302f2ed0152']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="ext_rule_group/ext_t_rule_group_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{truleGroupList.view}" onclick="if(rowIndexVarOfTruleGroup == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.6'] == 'true'}">				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_rule_group_list.2c90834916d142fa0116d302f2fc0153']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="ext_rule_group/ext_t_rule_group_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="selAll();return false">
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="全选" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="unselAll();return false">
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="重置" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(confirm('#{text['button.confirm.disable']}')){deleteTruleGroup();}return false" rendered="#{sessionScope._user_info.actionMap['action.7'] == 'true'}">
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="注销" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{truleGroupList.add}" rendered="#{sessionScope._user_info.actionMap['action.7'] == 'true'}">
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_rule_group_list.2c90834916d142fa0116d302f2cd0151']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../ext_rule_group/ext_t_rule_group_EditForm.faces?enable=true" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
    		
		</h:panelGrid>

	</h:form>
</f:view>
</body>