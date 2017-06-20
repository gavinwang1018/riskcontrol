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
	parent.historyIframe.addHistory('/t_organize_info/t_organize_info_list_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{torganizeInfoList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="torganizeInfo.t_organize_info_list_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('torganizeInfoQuery:searchtab')"><h:outputText value="#{text['torganizeInfo.torganizeInfoQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="torganizeInfoQuery" >
		<a4j:jsFunction name="queryTorganizeInfos" action="#{torganizeInfoList.query}" reRender="torganizeInfoPanel,torganizeInfos" oncomplete="document.getElementById('torganizeInfoList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('torganizeInfoQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTorganizeInfos();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="name_like" value="#{text['torganizeInfo.name']}  #{text['query.equal']}" />				
				<h:panelGroup>
                	<h:selectOneMenu id="belongToInst" value="#{torganizeInfoList.queryFields.globalSort_like}"  style="width:'86%'" >
						  <f:selectItems value="#{extSelectItems.belongToInstForOrgItems}"/>
					</h:selectOneMenu>				    
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="name_like" value="部门名称  包含" />				
				<h:panelGroup>
			    <h:inputText id="name_like" value="#{torganizeInfoList.queryFields.name_like}" tabindex="1" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>
			  
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="dwFlag" value="#{text['torganizeInfo.dwFlag']}  #{text['query.equal']}" />				
				<h:panelGroup>
				<h:selectOneMenu id="dwFlag" value="#{torganizeInfoList.queryFields.dwFlag}">
					<f:selectItem itemLabel="------" itemValue=""/>
					<f:selectItem itemLabel="是" itemValue="true"/>
					<f:selectItem itemLabel="否" itemValue="false"/>
				</h:selectOneMenu>
				</h:panelGroup>
			  </h:panelGrid>

		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{torganizeInfoList.torganizeInfo}" />
	<t:saveState value="#{torganizeInfoList.queryFields}" />
	<t:saveState id="torganizeInfos" value="#{torganizeInfoList.torganizeInfos}" />
	    <a4j:jsFunction name="deleteTorganizeInfo" action="#{torganizeInfoList.delete}"  reRender="torganizeInfoPanel,torganizeInfos" oncomplete="rowIndexVarOfTorganizeInfo = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTorganizeInfo" action="#{torganizeInfoList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="torganizeInfoList">
<script>
		var rowIndexVarOfTorganizeInfo = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['torganizeInfo.t_organize_info_list_List.heading']}" /></a></li>
    	    </ul>
    	</div>



	<h:panelGrid  id="torganizeInfoPanel" columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" >	
		
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{torganizeInfoList.edit}"  rendered="#{sessionScope._user_info.actionMap['action.22'] == 'true'}" onclick="if(rowIndexVarOfTorganizeInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_info_list.2c90834916ad22cb0116ad8bbc95001b']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_organize_info/t_organize_info_form_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{torganizeInfoList.view}" onclick="if(rowIndexVarOfTorganizeInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_info_list.2c90834916ad22cb0116ad8bbca5001c']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_organize_info/t_organize_info_form_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTorganizeInfo == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTorganizeInfo();}return false" rendered="#{sessionScope._user_info.actionMap['action.22'] == 'true'}">
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_info_list.2c90834916ad22cb0116ad8bbcc4001d']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{torganizeInfoList.add}" rendered="#{sessionScope._user_info.actionMap['action.22'] == 'true'}">
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_organize_info_list.2c90834916ad22cb0116ad8bbc76001a']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_organize_info/t_organize_info_form_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="torganizeInfoRowIndex" value="#{torganizeInfoList.rowIndex}"></h:inputHidden>
			<t:dataTable id="torganizeInfoDataTable" var="torganizeInfo"
				value="#{torganizeInfoList.torganizeInfos}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				sortColumn="#{torganizeInfoList.sortColumn}"
				sortAscending="#{torganizeInfoList.ascending}"
				binding="#{torganizeInfoList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTorganizeInfo='#{rowIndexVar}';document.getElementById('torganizeInfoList:torganizeInfoRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>	
				
				<t:column >
					<f:facet name="header">
						<h:outputText value="#{text['torganizeInfo.name']}" />
					</f:facet>
					<h:outputText id="parentId-name" value="#{torganizeInfo.parentIdOfTorganizeInfo.name}" />			
				</t:column>
									
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="name" arrow="true">		                
							<h:outputText value="部门名称" />
						</t:commandSortHeader>	
				</f:facet>
				<h:outputText id="name" value="#{torganizeInfo.name}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="dwFlag" arrow="true">		                
							<h:outputText value="#{text['torganizeInfo.dwFlag']}" />
						</t:commandSortHeader>	
				</f:facet>
				<h:selectBooleanCheckbox id="dwFlag" value="#{torganizeInfo.dwFlag}"  disabled="true"/>
				</t:column>

			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="torganizeInfo_scroll_1" 
                    for="torganizeInfoDataTable"
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
            <t:dataScroller id="torganizeInfo_scroll_2" 
                    for="torganizeInfoDataTable"
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
			<h:commandLink action="#{torganizeInfoList.edit}"  rendered="#{sessionScope._user_info.actionMap['action.22'] == 'true'}" onclick="if(rowIndexVarOfTorganizeInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkEditImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_info_list.2c90834916ad22cb0116ad8bbc95001b']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_organize_info/t_organize_info_form_EditForm" />
			</h:commandLink>							
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			<h:commandLink action="#{torganizeInfoList.view}" onclick="if(rowIndexVarOfTorganizeInfo == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_info_list.2c90834916ad22cb0116ad8bbca5001c']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_organize_info/t_organize_info_form_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>

<f:verbatim><li></f:verbatim>
	<h:panelGroup >
			 <h:commandLink  onclick="if(rowIndexVarOfTorganizeInfo == -1){alert('#{text['button.selected.confirm']}')}else if(confirm('#{text['button.confirm.delete']}')){deleteTorganizeInfo();}return false" rendered="#{sessionScope._user_info.actionMap['action.22'] == 'true'}">
				<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_organize_info_list.2c90834916ad22cb0116ad8bbcc4001d']}" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{torganizeInfoList.add}" rendered="#{sessionScope._user_info.actionMap['action.22'] == 'true'}">
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_organize_info_list.2c90834916ad22cb0116ad8bbc76001a']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_organize_info/t_organize_info_form_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
    		
		</h:panelGrid>

	</h:form>
</f:view>
</body>