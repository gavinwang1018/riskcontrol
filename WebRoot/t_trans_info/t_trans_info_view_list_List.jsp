<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="cn.com.brilliance.begen.common.BeGenHistory"%>
<%@ page
	import="cn.com.brilliance.begen.common.webapp.action.ResultPage"%>
<%
	String basePath = request.getContextPath();
	javax.faces.context.FacesContext
			.getCurrentInstance()
			.getViewRoot()
			.setLocale(
			cn.com.brilliance.begen.common.bundle.ResourceBundle
			.getLocale(request));
%>
<head>
	<link rel="stylesheet" type="text/css" media="all"
		href="<%=basePath%>/styles/config.css" />
	<link rel="stylesheet" type="text/css" media="all"
		href="<%=basePath%>/styles/right.css" />
	<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>

	<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/scripts/calculator.js"></script>
	<script language=javascript src="<%=basePath%>/scripts/getreset.js"></script>
	<script language=javascript src="<%=basePath%>/scripts/edit.js"></script>
</head>
<body onload="loadHidInfo();getDateObj()">
	<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
	<f:view>
		<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts";

try{
	parent.historyIframe.addHistory('/t_trans_info/t_trans_info_view_list_List.faces?<%=FacesContext.getCurrentInstance().getApplication()
							.createValueBinding(
									"#{ttransInfoList.historyUrlParameter}")
							.getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="ttransInfo.t_trans_info_view_list_List.note" />","2")
}catch(e){}
</script>
		<f:loadBundle var="text" basename="ApplicationResources" />
		<f:verbatim>
			<div class="mytab1">
				<ul class="myTabBar1">
					<li class="Selected">
						<a href="#">
		</f:verbatim>
		<h:outputText
			value="#{text['ttransInfo.t_trans_info_view_list_List.heading']}" />
		<f:verbatim>
			</a>
			</li>
			</ul>
			</div>
		</f:verbatim>
		<h:form id="ttransInfoQuery">
			<a4j:jsFunction name="queryTtransInfos"
				action="#{ttransInfoList.query}"
				reRender="ttransInfoList,ttransInfos"
				oncomplete="parent.dyniframesize('mainFrame')" />
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0"
				styleClass="mainTable">
				<h:panelGrid columns="1" cellspacing="0" cellpadding="0"
					styleClass="titleTable" columnClasses="titleTdClass">
					<h:panelGroup>
						<f:verbatim>
							<ul class="button_bar">
								<li>
						</f:verbatim>
						<h:commandLink onclick="queryTtransInfos();return false;">
							<f:verbatim>
								<span class="linkSearchImg"></span>
							</f:verbatim>
							<h:outputText styleClass="buttonText"
								value="#{text['button.query']}" />
						</h:commandLink>
						<f:verbatim>
							</li>
							<li>
						</f:verbatim>
						<h:commandLink onclick="resetTable(document.getElementById('ttransInfoQuery'));">
							<f:verbatim>
								<span class="linkResetImg"></span>
							</f:verbatim>
							<h:outputText styleClass="buttonText"
								value="#{text['button.reset']}" />
						</h:commandLink>
						<f:verbatim>
							</li>
							</ul>
						</f:verbatim>
					</h:panelGroup>
				</h:panelGrid>

				<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
					columnClasses="width50percent,width50percent"
					styleClass="width100percent">






					<h:panelGrid columns="2" cellspacing="2" cellpadding="5"
						styleClass="sectionTableSearch"
						columnClasses="colTitleSearch,colValueSearch">
						<h:outputLabel styleClass="fontnormal" for="settleDt_min"
							value="清算  起始日期  #{text['query.equal']}" />
							<h:panelGroup>
							<f:verbatim><span class="mustw"></span></f:verbatim>
						           <be:inputDate id="settleDt1" value="#{ttransInfoList.queryFields.settleDt_min}" tabindex="2" styleClass="edit_input" >
								     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
					               </be:inputDate>
						</h:panelGroup>
					</h:panelGrid>
					
					<h:panelGrid columns="2" cellspacing="2" cellpadding="5"
						styleClass="sectionTableSearch"
						columnClasses="colTitleSearch,colValueSearch">
						<h:outputLabel styleClass="fontnormal" for="settleDt_max"
							value="清算  结束日期  #{text['query.equal']}" />
							<h:panelGroup>
							<f:verbatim><span class="mustw"></span></f:verbatim>
						           <be:inputDate id="settleDt2" value="#{ttransInfoList.queryFields.settleDt_max}" tabindex="2" styleClass="edit_input" >
								     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
					               </be:inputDate>
						</h:panelGroup>
					</h:panelGrid>

					<h:panelGrid columns="2" cellspacing="2" cellpadding="5"
						styleClass="sectionTableSearch"
						columnClasses="colTitleSearch,colValueSearch">
						<h:outputLabel styleClass="fontnormal" for="priAcctNo"
							value="#{text['ttransInfo.priAcctNo']}  #{text['query.equal']}" />
						<h:panelGroup>
						<f:verbatim><span class="mustw"></span></f:verbatim>
							<h:inputText id="priAcctNo"
								value="#{ttransInfoList.queryFields.priAcctNo}" tabindex="2"
								styleClass="edit_input" />
						</h:panelGroup>
					</h:panelGrid>

					<h:panelGrid columns="2" cellspacing="2" cellpadding="5"
						styleClass="sectionTableSearch"
						columnClasses="colTitleSearch,colValueSearch">
						<h:outputLabel styleClass="fontnormal" for="fwdInsIdCd"
							value="#{text['ttransInfo.fwdInsIdCd']}  #{text['query.equal']}" />
						<h:panelGroup>
						<f:verbatim><span class="mustw"></span></f:verbatim>
								<h:selectOneMenu id="fwdInsIdCd" value="#{ttransInfoList.queryFields.fwdInsIdCd}">
					  					  <f:selectItems value="#{extSelectItems.secondLevelCorpList}"/>
								</h:selectOneMenu>
						</h:panelGroup>
					</h:panelGrid>


					<h:panelGrid columns="2" cellspacing="2" cellpadding="5"
						styleClass="sectionTableSearch"
						columnClasses="colTitleSearch,colValueSearch">
						<h:outputLabel styleClass="fontnormal" for="mchntCd"
							value="商户编号 等于" />
						<h:panelGroup>
						<f:verbatim><span class="mustw"></span></f:verbatim>
							<h:inputText id="mchntCd"
								value="#{ttransInfoList.queryFields.mchntCd}" tabindex="2"
								styleClass="edit_input" />
						</h:panelGroup>
					</h:panelGrid>


					<h:inputHidden />
				</h:panelGrid>

			</h:panelGrid>
		</h:form>
		<t:saveState value="#{ttransInfoList.ttransInfo}" />
		<t:saveState value="#{ttransInfoList.queryFields}" />
		<a4j:jsFunction name="deleteTtransInfo"
			action="#{ttransInfoList.deleteBuffer}"
			reRender="ttransInfoDataTable,ttransInfos"
			oncomplete="rowIndexVarOfTtransInfo = -1">
			<a4j:actionparam name="param1" assignTo="#{ttransInfoList.rowIndex}" />
		</a4j:jsFunction>

		<h:form id="ttransInfoList">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0"
				styleClass="mainTable">
				<h:panelGrid columns="1" cellspacing="0" cellpadding="0"
					styleClass="titleTable" columnClasses="titleTdClass">
					<h:panelGroup>
						<f:verbatim>
							<ul class="button_bar">
						</f:verbatim>



						<h:panelGroup>
							<f:verbatim>
								<li>
							</f:verbatim>
							<h:commandLink action="#{ttransInfoList.view}"
								onclick="if(rowIndexVarOfTtransInfo == -1){alert('#{text['button.selected.confirm']}');return false;}">
								<f:verbatim>
									<span class="linkViewImg"></span>
								</f:verbatim>
								<h:outputText styleClass="buttonText"
									value="#{text['actionlistrec.t_trans_info_view_list.2c90834917afeeb10117b02fcd180010']}" />
								<t:updateActionListener
									property="#{actionParameter.successAction}"
									value="t_trans_info/t_trans_info_view_form_ViewForm" />
							</h:commandLink>
							<f:verbatim>
								</li>
							</f:verbatim>
						</h:panelGroup>


						<f:verbatim>
							</ul>
						</f:verbatim>
					</h:panelGroup>
				</h:panelGrid>
				<f:verbatim>
					<script>
		var rowIndexVarOfTtransInfo = -1;
</script>
				</f:verbatim>
				<h:inputHidden id="ttransInfoRowIndex"
					value="#{ttransInfoList.rowIndex}"></h:inputHidden>
				<t:dataTable id="ttransInfoDataTable" var="ttransInfo"
					value="#{ttransInfoList.ttransInfos}"
					rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar"
					rowOnClick="rowIndexVarOfTtransInfo='#{rowIndexVar}';document.getElementById('ttransInfoList:ttransInfoRowIndex').value='#{rowIndexVar}';"
					onclick="hightlightRows(this)"  rows="20"
					sortColumn="#{ttransInfoList.sortColumn}"
					sortAscending="#{ttransInfoList.ascending}"
					binding="#{ttransInfoList.dataTable}" headerClass="listTableHead"
					styleClass="listTableDetail" columnClasses="listTableTd">
					<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;"
							url="../images/leftFrame_show.gif" />
					</t:column>

					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="settleDt">
								<h:outputText value="#{text['ttransInfo.settleDt']}"/>
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>
							<f:verbatim><nobr></f:verbatim>
								<h:outputText id="settleDt" value="#{ttransInfo.settleDt}" style="width:'100%'">
									<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8" />
								</h:outputText>
								<f:verbatim></nobr></f:verbatim>
							</h:panelGroup>
						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="sysTraNo">
								<h:outputText value="#{text['ttransInfo.sysTraNo']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="sysTraNo" value="#{ttransInfo.sysTraNo}" style="width:'100%'">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="respCd4">
								<h:outputText value="#{text['ttransInfo.respCd4']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="respCd4" value="#{ttransInfo.respCd4}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="transId">
								<h:outputText value="#{text['ttransInfo.transId']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="transId" value="#{ttransInfo.transId}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="settleIn">
								<h:outputText value="#{text['ttransInfo.settleIn']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="settleIn" value="#{ttransInfo.settleIn}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="transAt">
								<h:outputText value="#{text['ttransInfo.transAt']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:outputText id="transAt" value="#{ttransInfo.transAt}">
							</h:outputText>
						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="msgTp">
								<h:outputText value="#{text['ttransInfo.msgTp']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="msgTp" value="#{ttransInfo.msgTp}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="locTransDtTm">
								<h:outputText value="#{text['ttransInfo.locTransDtTm']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="locTransDtTm"
									value="#{ttransInfo.locTransDtTm}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="mchntTp">
								<h:outputText value="#{text['ttransInfo.mchntTp']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="mchntTp" value="#{ttransInfo.mchntTp}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="retriRefNo">
								<h:outputText value="#{text['ttransInfo.retriRefNo']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="retriRefNo" value="#{ttransInfo.retriRefNo}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="priAcctNo">
								<h:outputText value="#{text['ttransInfo.priAcctNo']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="priAcctNo" value="#{ttransInfo.priAcctNo}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="bin">
								<h:outputText value="#{text['ttransInfo.bin']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="bin" value="#{ttransInfo.bin}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="cardAttr">
								<h:outputText value="#{text['ttransInfo.cardAttr']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="cardAttr" value="#{ttransInfo.cardAttr}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="cardMedia">
								<h:outputText value="#{text['ttransInfo.cardMedia']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="cardMedia" value="#{ttransInfo.cardMedia}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="termId">
								<h:outputText value="#{text['ttransInfo.termId']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="termId" value="#{ttransInfo.termId}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="mchntCd">
								<h:outputText value="#{text['ttransInfo.mchntCd']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="mchntCd" value="#{ttransInfo.mchntCd}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="cardAccptrNmLoc">
								<h:outputText value="#{text['ttransInfo.cardAccptrNmLoc']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="cardAccptrNmLoc"
									value="#{ttransInfo.cardAccptrNmLoc}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="acqInsIdCd">
								<h:outputText value="#{text['ttransInfo.acqInsIdCd']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="acqInsIdCd" value="#{ttransInfo.acqInsIdCd}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="fwdInsIdCd">
								<h:outputText value="#{text['ttransInfo.fwdInsIdCd']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="fwdInsIdCd" value="#{ttransInfo.fwdInsIdCd}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="rcvInsIdCd">
								<h:outputText value="#{text['ttransInfo.rcvInsIdCd']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="rcvInsIdCd" value="#{ttransInfo.rcvInsIdCd}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="issInsIdCd">
								<h:outputText value="#{text['ttransInfo.issInsIdCd']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="issInsIdCd" value="#{ttransInfo.issInsIdCd}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="origSysTraNo">
								<h:outputText value="#{text['ttransInfo.origSysTraNo']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="origSysTraNo"
									value="#{ttransInfo.origSysTraNo}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="origTransmsnDtTm">
								<h:outputText value="#{text['ttransInfo.origTransmsnDtTm']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="origTransmsnDtTm"
									value="#{ttransInfo.origTransmsnDtTm}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="rsnCd">
								<h:outputText value="#{text['ttransInfo.rsnCd']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="rsnCd" value="#{ttransInfo.rsnCd}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="authDt">
								<h:outputText value="#{text['ttransInfo.authDt']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>
								<h:outputText id="authDt" value="#{ttransInfo.authDt}">
									<f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8" />
								</h:outputText>
							</h:panelGroup>
						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="authIdRespCd">
								<h:outputText value="#{text['ttransInfo.authIdRespCd']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="authIdRespCd"
									value="#{ttransInfo.authIdRespCd}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="posEntryMdCd">
								<h:outputText value="#{text['ttransInfo.posEntryMdCd']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="posEntryMdCd"
									value="#{ttransInfo.posEntryMdCd}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="posCondCd">
								<h:outputText value="#{text['ttransInfo.posCondCd']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="posCondCd" value="#{ttransInfo.posCondCd}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="procCd">
								<h:outputText value="#{text['ttransInfo.procCd']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="procCd" value="#{ttransInfo.procCd}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="settleYm">
								<h:outputText value="#{text['ttransInfo.settleYm']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="settleYm" value="#{ttransInfo.settleYm}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


					<t:column>
						<f:facet name="header">
							<t:commandSortHeader columnName="fwdInsIdOriginal">
								<h:outputText value="#{text['ttransInfo.fwdInsIdOriginal']}" />
							</t:commandSortHeader>
						</f:facet>
						<h:panelGroup>
							<f:verbatim>
								<span class="notw"></span>
							</f:verbatim>
							<h:panelGroup>


								<h:outputText id="fwdInsIdOriginal"
									value="#{ttransInfo.fwdInsIdOriginal}">

								</h:outputText>
							</h:panelGroup>


						</h:panelGroup>
					</t:column>


				</t:dataTable>
				<h:panelGrid columns="2" styleClass="scrollerTable"
					columnClasses="column1,column2">
					<t:dataScroller id="scroll_1" for="ttransInfoDataTable"
						rowsCountVar="rowsCount"
						displayedRowsCountVar="displayedRowsCountVar"
						firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex"
						pageCountVar="pageCount" immediate="true" pageIndexVar="pageIndex"
						paginator="true" paginatorMaxPages="9">
						<f:facet name="first">
							<h:outputText value="#{text['page.first']}" />
						</f:facet>
						<f:facet name="last">
							<h:outputText value="#{text['page.last']}" />
						</f:facet>
						<f:facet name="previous">
							<h:outputText value="#{text['page.previous']}" />
						</f:facet>
						<f:facet name="next">
							<h:outputText value="#{text['page.next']}" />
						</f:facet>
					</t:dataScroller>
					<t:dataScroller id="scroll_2" for="ttransInfoDataTable"
						rowsCountVar="rowsCount"
						displayedRowsCountVar="displayedRowsCountVar"
						firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex"
						pageCountVar="pageCount" immediate="true" pageIndexVar="pageIndex">
						<h:outputFormat value="#{text['pageFooter']}"
							styleClass="standard">
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
