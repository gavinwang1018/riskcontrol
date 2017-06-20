<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="cn.com.brilliance.begen.common.BeGenHistory"%>
<%@ page
	import="cn.com.brilliance.begen.common.webapp.action.ResultPage"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

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
	<link rel="stylesheet" type="text/css"
		href="<%=basePath%>/styles/right.css" />

	<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>

	<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/scripts/includedate.js" defer></script>
	<script type="text/javascript"
		src="<%=basePath%>/scripts/calculator.js"></script>
	<script language=javascript src="scripts/getreset.js"></script>
	<script language="JavaScript" defer>
loadHidInfo()

    function isEmpty() {
      var studyId = document.getElementById("StudySamplingReport:read_studyId_like").value;
      if(studyId == "") {
        alert("请先选择一个条件！");
        return false;
      }
      else
       return true;
   }

</script>
</head>

<body onload="loadHidInfo();getDateObj()">
	<input type="hidden" id="imagePath" value="<%=basePath%>/images">
	<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">
	<div class="title" title="各行业疑似风险商户案例处理情况统计表">
		<table cellspacing=0 cellpadding=0>
			<tr>
				<td style="vertical-align:top;">
					<img src="<%=basePath%>/images/title_icon_list.gif" align=left />
				</td>
				<td>
					<p>
						各行业疑似风险商户案例处理情况统计表
					</p>
				</td>
			</tr>
		</table>
	</div>
	<%
				ResultPage resultPage = (ResultPage) request
				.getAttribute(ResultPage.REQUEST_ATTRIBUTE_NAME);
		if (resultPage == null) {
			resultPage = new ResultPage();
			resultPage.setMessageType(ResultPage.MESSAGE_TYPE_OTHER_ERROR);
		}
	%>

	<%
				if (resultPage.getMessageLabel() != null
				&& !"".equals(resultPage.getMessageLabel())) {
	%>
	<div id="errorInfor" class="error"
		style="cursor:hand;display:'';font-size:12px;"
		title="<%=resultPage.getMessageContent()%>">
		<%
		} else {
		%>
		<div id="errorInfor" class="error"
			style="cursor:hand;display:'none';font-size:12px;"
			title="<%=resultPage.getMessageContent()%>">
			<%
			}
			%>
			<img src="<%=basePath%>/images/iconInformation.gif" width=14
				height=13 style="vertical-align:middle;margin-right:5px;" />
			<span style="clear:none"><%=resultPage.getMessageLabel()%>
			</span><span
				style="text-align:right;float:right;vertical-align:top;margin-top:-15px;"><img
					src="<%=basePath%>/images/errorclose.gif" width=14 height=14
					style="vertical-align:top;cursor:hand;" onclick="showError(this)">
			</span>
			<div id="errorURL" style="display:none;height:16px;margin-top:4px;">
				<%
						for (int i = 0; i < resultPage.getLinks().size(); i++) {
						String link = String.valueOf(resultPage.getLinks().getValue(i));
						if (!link.startsWith("http://"))
							link = basePath + link;
				%>
				&nbsp;&nbsp;
				<img src="<%=basePath%>/images/math.gif" width=14 height=14 />
				<a href="<%=link%>"><%=resultPage.getLinks().get(i)%>
				</a>
				<%
				}
				%>
			</div>
		</div>
		<%
					if (resultPage.getMessageLabel() == null
					|| "".equals(resultPage.getMessageLabel())) {
		%>
		<br />
		<%
		}
		%>
		<f:view>

			<f:loadBundle var="text" basename="ApplicationResources" />

			<h:form id="report">
				<h:panelGrid id="searchtab" columns="1" cellspacing="0"
					cellpadding="0" styleClass="mainSearchTab">

					<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
						styleClass="sectionTable" columnClasses="rowTable3,rowTable3"
						headerClass="mainHeader" footerClass="mainFooter">
						<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
							styleClass="sectionTable"
							columnClasses="colTitleView,colValueView">
							<h:outputLabel for="subinst" styleClass="outputlabel"
								value="机构名称：" />
							<h:panelGroup>
								<f:verbatim>
									<span class="notw"></span>
								</f:verbatim>
								<h:panelGroup>
									<h:selectOneMenu id="subinst"
										value="#{reportList.belongToInst}" readonly="false"
										tabindex="1" style="width:86%">
										<f:selectItems value="#{extSelectItems.belongToInstList}" />
									</h:selectOneMenu>
								</h:panelGroup>
							</h:panelGroup>
							<h:inputHidden />
						</h:panelGrid>
					</h:panelGrid>




					<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
						styleClass="sectionTable" columnClasses="rowTable3,rowTable3"
						headerClass="mainHeader" footerClass="mainFooter">
						<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
							styleClass="sectionTable"
							columnClasses="colTitleView,colValueView">
							<h:outputLabel for="beginDate" styleClass="outputlabel"
								value="统计起始时间：" />
							<h:panelGroup>
								<f:verbatim>
									<span class="notw"></span>
								</f:verbatim>
							        <h:panelGroup>
							           <be:inputDate id="beginDate" value="#{reportList.beginDate}" style="width:86%" tabindex="11"   styleClass="edit_input" >
									     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
						               </be:inputDate>
				   			         </h:panelGroup>
			                </h:panelGroup>	
							<h:inputHidden />								
								
								
							<h:inputHidden />
						</h:panelGrid>
						
						
						
						
						
						


						<h:panelGrid columns="2" cellspacing="0" cellpadding="0"
							styleClass="sectionTable"
							columnClasses="colTitleView,colValueView">
							<h:outputLabel for="subinst" styleClass="outputlabel"
								value="统计结束时间：" />
							<h:panelGroup>
								<f:verbatim>
									<span class="notw"></span>
								</f:verbatim>
							        <h:panelGroup>
							           <be:inputDate id="endDate" value="#{reportList.endDate}" style="width:86%" tabindex="11"   styleClass="edit_input" >
									     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
						               </be:inputDate>
				   			         </h:panelGroup>
			                </h:panelGroup>	
							<h:inputHidden />	
							<h:inputHidden />
						</h:panelGrid>


					</h:panelGrid>

					<h:panelGroup>
						<h:commandButton value="#{text['button.query']}"
							action="#{reportList.query}" onclick="return isEmpty();"
							styleClass="button">
						</h:commandButton>
						<h:commandButton value="导出Excel文件" action="#{reportList.export}"
							onclick="return isEmpty();" styleClass="button">
						</h:commandButton>
					</h:panelGroup>
				</h:panelGrid>

			</h:form>
		</f:view>