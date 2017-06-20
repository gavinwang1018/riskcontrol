<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="cn.com.brilliance.begen.common.Tools" %>
<%
String basePath = request.getContextPath();
%>
<head>
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/config.css" />

<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>

<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/calculator.js"></script>
</head>
<script  language="JavaScript">
window.history.forward(1); 
var loadImg=opener.parent.document.getElementById("loading");
if(loadImg!=undefined&&loadImg.style.display=="")loadImg.style.display='none';
var loadImgDiv=opener.parent.document.getElementById("sDivInfo");
if(loadImgDiv!=undefined&&loadImgDiv.style.display=="")loadImgDiv.style.display='none';

</script>
<style>
.button {
	font-family: "Arial";
	background-image:  url(<%=basePath%>/images/Btn_bg.gif);
	background-repeat: repeat-x;
	background-position: center center;
	font-size: 12px;
	color:#000000;
	padding:3px 2px 0 2px;
	cursor:pointer;
	font-weight:normal;
	display:inline;
	text-decoration: none;
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-top-color: #eeeeee;
	border-right-color: #00CFFF;
	border-bottom-color: #00CFFF;
	border-left-color: #eeeeee;
	background-color: #FFFFFF;
	margin:3px 5px;
}
.mustw{
	width:3px;
	height:22px;
	background-image:url(<%=basePath%>/images/m.jpg);
	vertical-align:top;
}
.notw{
	width:3px;
	height:22px;
	vertical-align:top;
}
</style>
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/images">
<div class="title" title="<fmt:message key="sysRole.sysRoleList.note" />">
	<table  cellspacing=0 cellpadding=0>
        <tr>
        	<td style="vertical-align:top;">
               <img src="<%=basePath%>/images/title_icon_list.gif" align=left />	
			</td>
			<td>
			   <p class="titleText" ><fmt:message key="sysRole.sysRoleList.heading" /></p>	
			</td>
   		</tr>
   </table>
</div>
<br/>
<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<t:saveState value="#{lookupParameter}" />
	<h:form id="sysRoleList">
		<h:panelGrid  columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable" headerClass="mainHeader" footerClass="mainFooter">
			<t:dataTable cellspacing="2" cellpadding="0" id="sysRoleDataTable" var="sysRole"
				rowIndexVar="rowIndex"
				value="#{sysRoleList.sysRoleList}"  rowClasses="rowsLookClass2,rowsLookClass2"
				binding="#{sysRoleList.dataTable}" styleClass="detail" style="border-top:2px solid #7ABEFF">
				<h:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{sysRole.roleId}" />
					<h:inputHidden id="roleId" value="#{sysRole.roleId}" />
					<h:inputHidden id="roleName" value="#{sysRole.roleName}" />
					<h:inputHidden id="partyId" value="#{sysRole.partyId}" />
				</h:column>
				
                        		<t:column style="text-align:left;padding-left:3px;" headerstyleClass="headTable">
            					<f:facet name="header">
						<h:outputText value="#{text['sysRole.roleId']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysRole.roleId}','#{sysRole.roleName}')">
						<h:outputText value="#{sysRole.roleId}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				
                        		<t:column style="text-align:left;padding-left:3px;" headerstyleClass="headTable">
            					<f:facet name="header">
						<h:outputText value="#{text['sysRole.roleName']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{sysRole.roleId}','#{sysRole.roleName}')">
						<h:outputText value="#{sysRole.roleName}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
			<f:facet name="footer">
				<h:panelGroup>
					<h:commandButton value="#{text['button.cancel']}" onclick="window.close()" styleClass="button" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
	<script type="text/javascript" defer>
		try{
			highlightTableRows("sysRoleList:sysRoleDataTable");
			var inputs=document.getElementsByTagName("INPUT");
			if(inputs!=undefined)
			{
				var hightTd=document.getElementById("hid").value;
				for(var t=0;t<inputs.length;t++)
				{
					if(hightTd==''||hightTd=='null')break;
					else if(inputs[t].value==hightTd)
					{
						inputs[t].parentNode.parentNode.runtimeStyle.backgroundColor="#BBD1E7";
						break;
					}
				}
			}
		}catch(e){}

	</script>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>

