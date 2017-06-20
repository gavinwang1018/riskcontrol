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
	parent.historyIframe.addHistory('/t_cardbin/t_cardbin_list_2_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{tcardbinList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="tcardbin.t_cardbin_list_2_List.heading" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('tcardbinQuery:searchtab')"><h:outputText value="#{text['tcardbin.tcardbinQueryForm.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>
	
	<h:form id="tcardbinQuery" >
		<a4j:jsFunction name="queryTcardbins" action="#{tcardbinList.query}" reRender="tcardbinPanel,tcardbins" oncomplete="document.getElementById('tcardbinList').style.display='block';parent.dyniframesize('mainFrame')" />   
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
				
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('tcardbinQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
				
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTcardbins();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="name" value="#{text['tcardbin.name']}  #{text['query.equal']}" />				
				<h:panelGroup>
			    <h:inputText id="name" value="#{tcardbinList.queryFields.name}" tabindex="1" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="length" value="#{text['tcardbin.length']}  #{text['query.equal']}" />				
				<h:panelGroup>
			    <h:inputText id="length" value="#{tcardbinList.queryFields.length}" styleClass="edit_input">
					<s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['tcardbin.length']}" client="true" server="false" />
				</h:inputText>					
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="bin_like" value="#{text['tcardbin.bin']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="bin_like" value="#{tcardbinList.queryFields.bin_like}" tabindex="2" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>


             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel styleClass="fontnormal" for="bank_like" value="#{text['tcardbin.bank']}  #{text['query.like']}" />				
				<h:panelGroup>
			    <h:inputText id="bank_like" value="#{tcardbinList.queryFields.bank_like}" tabindex="3" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

		</h:panelGrid>				
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{tcardbinList.tcardbin}" />
	<t:saveState value="#{tcardbinList.queryFields}" />
	<t:saveState id="tcardbins" value="#{tcardbinList.tcardbins}" />
    <a4j:jsFunction name="moveUpTcardbin" action="#{tcardbinList.moveUp}"  reRender="tcardbinPanel,tcardbins"  oncomplete="rowIndexVarOfmoveUpTcardbin = -1">
	</a4j:jsFunction>	
    <a4j:jsFunction name="moveDownTcardbin" action="#{tcardbinList.moveDown}"  reRender="tcardbinPanel,tcardbins"  oncomplete="rowIndexVarOfmoveDownTcardbin = -1">
	</a4j:jsFunction>
	<a4j:jsFunction name="addTcardbin" action="#{tcardbinList.add}">
		<a4j:actionparam name="param1" assignTo="#{actionParameter.successAction}"  />  
	</a4j:jsFunction>	
	<h:form id="tcardbinList"  style="display:none">
<script>
		var rowIndexVarOfTcardbin = -1;
</script>

<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tcardbin.t_cardbin_list_2_List.heading']}" /></a></li>
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
			<h:commandLink action="#{tcardbinList.view}" onclick="if(rowIndexVarOfTcardbin == -1){alert('#{text['button.selected.confirm']}');return false}" >				   
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_cardbin_list_2.2c908349169f7cda0116a346e83c00a5']}" />
				<t:updateActionListener property="#{actionParameter.successAction}" value="t_cardbin/t_cardbin_form_2_ViewForm" />
			</h:commandLink>	
	</h:panelGroup>
<f:verbatim></li></f:verbatim>
       
	<f:verbatim><li></f:verbatim>
		<h:commandLink action="#{tcardbinList.add}"  >
			<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_cardbin_list_2.2c908349169f7cda0116a346e7cf00a1']}" />
			<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_cardbin/t_cardbin_form_2_EditForm.faces" />
		</h:commandLink>
	<f:verbatim></li></f:verbatim>
	
	            <f:verbatim></ul></f:verbatim>
    			</h:panelGroup>
    		</h:panelGrid>
			<h:inputHidden id="tcardbinRowIndex" value="#{tcardbinList.rowIndex}"></h:inputHidden>
			<t:dataTable id="tcardbinDataTable" var="tcardbin"
				value="#{tcardbinList.tcardbins}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" 
				rows="50"
				binding="#{tcardbinList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd" rowOnClick="rowIndexVarOfTcardbin='#{rowIndexVar}';document.getElementById('tcardbinList:tcardbinRowIndex').value='#{rowIndexVar}';" onclick="hightlightRows(this);">				
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>		
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tcardbin.name']}" />
				</f:facet>
				<h:outputText id="name" value="#{tcardbin.name}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tcardbin.length']}" />
				</f:facet>
				<h:outputText id="length" value="#{tcardbin.length}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tcardbin.bin']}" />
				</f:facet>
				<h:outputText id="bin" value="#{tcardbin.bin}" />
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tcardbin.cupscard']}" />
				</f:facet>
				<h:selectBooleanCheckbox id="cupscard" value="#{tcardbin.cupscard}"  disabled="true"/>
				</t:column>
				
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tcardbin.bank']}" />
				</f:facet>
				<h:outputText id="bank" value="#{tcardbin.bank}" />
				</t:column>
				
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="tcardbin_scroll_1" 
                    for="tcardbinDataTable"
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
            <t:dataScroller id="tcardbin_scroll_2" 
                    for="tcardbinDataTable"
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

		</h:panelGrid>

	</h:form>
</f:view>
</body>