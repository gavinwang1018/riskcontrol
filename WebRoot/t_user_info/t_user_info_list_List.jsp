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
	parent.historyIframe.addHistory('/t_user_info/t_user_info_list_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tuserInfoList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tuserInfo.t_user_info_list_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('tuserInfoQuery:searchtab')"><h:outputText value="#{text['tuserInfo.tuserInfoQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="tuserInfoQuery" >
		<a4j:jsFunction name="queryTuserInfos" action="#{tuserInfoList.query}" reRender="tuserInfoPanel,tuserInfos" oncomplete="document.getElementById('tuserInfoList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('tuserInfoQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTuserInfos();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="organizeId" value="#{text['tuserInfo.organizeId']}  #{text['query.equal']}" />				
				<h:panelGroup>
                	<h:selectOneMenu id="belongToInst" value="#{tuserInfoList.queryFields.organizeId}"  style="width:'86%'" >
						  <f:selectItems value="#{extSelectItems.belongToInstItems}"/>
					</h:selectOneMenu>					
				</h:panelGroup>
			  </h:panelGrid>
			  			  		
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="loginName_like" value="#{text['tuserInfo.loginName']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="loginName_like" value="#{tuserInfoList.queryFields.loginName_like}" tabindex="3" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="name_like" value="#{text['tuserInfo.name']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="name_like" value="#{tuserInfoList.queryFields.name_like}" tabindex="4" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

             <h:inputHidden/> 	
		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{tuserInfoList.tuserInfo}" />
	<t:saveState value="#{tuserInfoList.queryFields}" />
	<t:saveState id="tuserInfos" value="#{tuserInfoList.tuserInfos}" />
	    <a4j:jsFunction name="deleteTuserInfo" action="#{tuserInfoList.closeUser}"  reRender="tuserInfoPanel,tuserInfos" oncomplete="rowIndexVarOfTuserInfo = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTuserInfo" action="#{tuserInfoList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tuserInfoList" >
<script>
		var rowIndexVarOfTuserInfo = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tuserInfo.t_user_info_list_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="tuserInfoPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tuserInfoList.edit}"  onclick="if(rowIndexVarOfTuserInfo == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.20'] == 'true'}">				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_user_info_list.2c908349169f7cda0116a99524be0784']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_user_info/t_user_info_form_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tuserInfoList.view}" onclick="if(rowIndexVarOfTuserInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_user_info_list.2c908349169f7cda0116a99524ed0785']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_user_info/t_user_info_form_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTuserInfo == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.disable']}')){deleteTuserInfo();}return false" rendered="#{sessionScope._user_info.actionMap['action.20'] == 'true'}">
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="注销" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{tuserInfoList.add}" rendered="#{sessionScope._user_info.actionMap['action.20'] == 'true'}">
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_user_info_list.2c908349169f7cda0116a995249f0783']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_user_info/t_user_info_form_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tuserInfoRowIndex" value="#{tuserInfoList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tuserInfoDataTable" var="tuserInfo"
				value="#{tuserInfoList.tuserInfos}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{tuserInfoList.sortColumn}"
				sortAscending="#{tuserInfoList.ascending}"
				binding="#{tuserInfoList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTuserInfo='#{rowIndexVar}';document.getElementById('tuserInfoList:tuserInfoRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="loginName" arrow="true">		                
							<h:outputText value="#{text['tuserInfo.loginName']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="loginName" value="#{tuserInfo.loginName}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="name" arrow="true">		                
							<h:outputText value="#{text['tuserInfo.name']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="name" value="#{tuserInfo.name}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="enable" arrow="true">		                
							<h:outputText value="#{text['tuserInfo.enable']}" />
						</t:commandSortHeader>	
				</f:facet>
<h:selectBooleanCheckbox id="enable" value="#{tuserInfo.enable}"  disabled="true" />				
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="email" arrow="true">		                
							<h:outputText value="#{text['tuserInfo.email']}" />
						</t:commandSortHeader>	
				</f:facet>
				 <h:outputText id="email" value="#{tuserInfo.email}" />
				</t:column>
				
				<t:column >
					<f:facet name="header">
						<h:outputText value="#{text['torganizeInfo.name']}" />
					</f:facet>
					<h:outputText id="organizeId-name" value="#{tuserInfo.organizeIdOfTorganizeInfo.name}" />			
				</t:column>
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="tuserInfo_scroll_1" 
                    for="tuserInfoDataTable"
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
            <t:dataScroller id="tuserInfo_scroll_2" 
                    for="tuserInfoDataTable"
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
			<h:commandLink action="#{tuserInfoList.edit}"  onclick="if(rowIndexVarOfTuserInfo == -1){alert('#{text['button.selected.confirm']}');return false}" rendered="#{sessionScope._user_info.actionMap['action.20'] == 'true'}">				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_user_info_list.2c908349169f7cda0116a99524be0784']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_user_info/t_user_info_form_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{tuserInfoList.view}" onclick="if(rowIndexVarOfTuserInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_user_info_list.2c908349169f7cda0116a99524ed0785']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_user_info/t_user_info_form_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTuserInfo == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.disable']}')){deleteTuserInfo();}return false" rendered="#{sessionScope._user_info.actionMap['action.20'] == 'true'}">
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="注销" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{tuserInfoList.add}" rendered="#{sessionScope._user_info.actionMap['action.20'] == 'true'}">
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_user_info_list.2c908349169f7cda0116a995249f0783']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_user_info/t_user_info_form_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
    		
		</h:panelGrid>

	</h:form>
</f:view>
</body>