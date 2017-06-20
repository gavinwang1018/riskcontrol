<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%
String basePath = request.getContextPath();
javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().setLocale(cn.com.brilliance.begen.common.bundle.ResourceBundle.getLocale(request));
%>
<%@ include file="/common/taglibs.jsp"%>
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
</head>
<body onload="loadTmchnts();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<br>
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('tmchntQuery:searchtab')"><h:outputText value="#{text['tmchnt.tmchntList.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>

	<h:form id="tmchntQuery">
		<a4j:jsFunction name="queryTmchnts" action="#{tmchntList.query}" reRender="tmchntList" />   		
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
					
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('tmchntQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTmchnts();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		 
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent backColor"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="subinst" value="#{text['tmchnt.subinst']}  #{text['query.equal']}" />

				<h:panelGroup>
				<h:selectOneMenu id="subinst" value="#{tmchntList.queryFields.subinst}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="merchantno_like" value="#{text['tmchnt.merchantno']}  #{text['query.like']}" />

				<h:panelGroup>
			    <h:inputText id="merchantno_like" value="#{tmchntList.queryFields.merchantno_like}" tabindex="1" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="briefname_like" value="#{text['tmchnt.briefname']}  #{text['query.like']}" />

				<h:panelGroup>
			    <h:inputText id="briefname_like" value="#{tmchntList.queryFields.briefname_like}" tabindex="2" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>





             <h:inputHidden/> 	

		</h:panelGrid>			
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{tmchntList.queryFields}" />
	<t:saveState id="tmchnts" value="#{tmchntList.tmchnts}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['tmchnt.t_mchnt_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="tmchntList">
       <a4j:jsFunction name="loadTmchnts" action="#{tmchntList.initTmchnts}" reRender="tmchntList,tmchnts" oncomplete="checkLookupS()" />		
		<h:panelGrid  columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			
		<h:panelGrid columns="1" cellspacing="1" cellpadding="2" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
        			<f:verbatim><ul id="tool_r"></f:verbatim>
					<f:verbatim><li></f:verbatim>	
					<h:commandLink onclick="window.close()">
					<f:verbatim><span class="linkCancelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.cancel']}" />
					</h:commandLink>	
					<f:verbatim></li></f:verbatim>	
			</h:panelGroup>
		 </h:panelGrid>
			<t:dataTable id="tmchntDataTable" var="tmchnt"
				value="#{tmchntList.tmchnts}" rowClasses="rowsClass,rowsClass2"
				rows="50"
				sortColumn="#{tmchntList.sortColumn}"
				sortAscending="#{tmchntList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{tmchntList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="merchantcategory" value="#{tmchnt.merchantcategory}" />
					<h:inputHidden id="id" value="#{tmchnt.id}" />
					<h:inputHidden id="foreigncard" value="#{tmchnt.foreigncard}" />
					<h:inputHidden id="merchantnature" value="#{tmchnt.merchantnature}" />
					<h:inputHidden id="name" value="#{tmchnt.name}" />
					<h:inputHidden id="briefname" value="#{tmchnt.briefname}" />
					<h:inputHidden id="engname" value="#{tmchnt.engname}" />
					<h:inputHidden id="engbriefname" value="#{tmchnt.engbriefname}" />
					<h:inputHidden id="contractant" value="#{tmchnt.contractant}" />
					<h:inputHidden id="licenseno" value="#{tmchnt.licenseno}" />
					<h:inputHidden id="registeredcapital" value="#{tmchnt.registeredcapital}" />
					<h:inputHidden id="taxno" value="#{tmchnt.taxno}" />
					<h:inputHidden id="merchantno" value="#{tmchnt.merchantno}" />
					<h:inputHidden id="installdate" value="#{tmchnt.installdate}" />
					<h:inputHidden id="withdrawinputdate" value="#{tmchnt.withdrawinputdate}" />
					<h:inputHidden id="subinst" value="#{tmchnt.subinst}" />
					<h:inputHidden id="developingmethod" value="#{tmchnt.developingmethod}" />
					<h:inputHidden id="multiacquirer" value="#{tmchnt.multiacquirer}" />
					<h:inputHidden id="businessacceptmethod" value="#{tmchnt.businessacceptmethod}" />
					<h:inputHidden id="state" value="#{tmchnt.state}" />
					<h:inputHidden id="servicerate" value="#{tmchnt.servicerate}" />
					<h:inputHidden id="legalman" value="#{tmchnt.legalman}" />
					<h:inputHidden id="idcardtype" value="#{tmchnt.idcardtype}" />
					<h:inputHidden id="idcardno" value="#{tmchnt.idcardno}" />
					<h:inputHidden id="licensedeadline" value="#{tmchnt.licensedeadline}" />
					<h:inputHidden id="registerAddress" value="#{tmchnt.registerAddress}" />
					<h:inputHidden id="registerZipcode" value="#{tmchnt.registerZipcode}" />
					<h:inputHidden id="officeAddress" value="#{tmchnt.officeAddress}" />
					<h:inputHidden id="officeZipcode" value="#{tmchnt.officeZipcode}" />
					<h:inputHidden id="contactperson" value="#{tmchnt.contactperson}" />
					<h:inputHidden id="dept" value="#{tmchnt.dept}" />
					<h:inputHidden id="tel" value="#{tmchnt.tel}" />
					<h:inputHidden id="mobtel" value="#{tmchnt.mobtel}" />
					<h:inputHidden id="fax" value="#{tmchnt.fax}" />
					<h:inputHidden id="email" value="#{tmchnt.email}" />
					<h:inputHidden id="financeperson" value="#{tmchnt.financeperson}" />
					<h:inputHidden id="financetel" value="#{tmchnt.financetel}" />
					<h:inputHidden id="financemotel" value="#{tmchnt.financemotel}" />
					<h:inputHidden id="financefax" value="#{tmchnt.financefax}" />
					<h:inputHidden id="financeemail" value="#{tmchnt.financeemail}" />
					<h:inputHidden id="mailperson" value="#{tmchnt.mailperson}" />
					<h:inputHidden id="mailtel" value="#{tmchnt.mailtel}" />
					<h:inputHidden id="mailmobtel" value="#{tmchnt.mailmobtel}" />
					<h:inputHidden id="chargereduingtime" value="#{tmchnt.chargereduingtime}" />
					<h:inputHidden id="guaranteemethod" value="#{tmchnt.guaranteemethod}" />
					<h:inputHidden id="guaranteemethoddesc" value="#{tmchnt.guaranteemethoddesc}" />
					<h:inputHidden id="approvedesc" value="#{tmchnt.approvedesc}" />
					<h:inputHidden id="approveddate" value="#{tmchnt.approveddate}" />
					<h:inputHidden id="addingcategory" value="#{tmchnt.addingcategory}" />
					<h:inputHidden id="logoutinputdate" value="#{tmchnt.logoutinputdate}" />
					<h:inputHidden id="withdrawcategory" value="#{tmchnt.withdrawcategory}" />
					<h:inputHidden id="withdrawoperator" value="#{tmchnt.withdrawoperator}" />
					<h:inputHidden id="laststatechangedate" value="#{tmchnt.laststatechangedate}" />
					<h:inputHidden id="laststatechangeoperator" value="#{tmchnt.laststatechangeoperator}" />
					<h:inputHidden id="province" value="#{tmchnt.province}" />
					<h:inputHidden id="city" value="#{tmchnt.city}" />
					<h:inputHidden id="county" value="#{tmchnt.county}" />
					<h:inputHidden id="refusereason" value="#{tmchnt.refusereason}" />
					<h:inputHidden id="remark" value="#{tmchnt.remark}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchnt.subinst']}" />
					</f:facet>
				<be:outputText id="subinst1" value="#{tmchnt.subinst}">
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchnt.merchantno']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmchnt.id}','#{tmchnt.id}')">					
						<h:outputText value="#{tmchnt.merchantno}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchnt.briefname']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmchnt.id}','#{tmchnt.id}')">					
						<h:outputText value="#{tmchnt.briefname}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchnt.state']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmchnt.id}','#{tmchnt.id}')">					
						<h:outputText value="#{tmchnt.state}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchnt.merchantcategory']}" />
					</f:facet>
				<be:outputText id="merchantcategory1" value="#{tmchnt.merchantcategory}">
                   <f:selectItems value="#{extSelectItems.tmccIdsOfTmccs}"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchnt.registerAddress']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmchnt.id}','#{tmchnt.id}')">					
						<h:outputText value="#{tmchnt.registerAddress}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['tmchnt.licenseno']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{tmchnt.id}','#{tmchnt.id}')">					
						<h:outputText value="#{tmchnt.licenseno}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">
            <t:dataScroller id="scroll_1"
                    for="tmchntDataTable"
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
            <t:dataScroller id="scroll_2"
                    for="tmchntDataTable"
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
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>