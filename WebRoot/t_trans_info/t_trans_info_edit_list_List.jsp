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
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/right.css" />
<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>

<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/calculator.js"></script>
<script language=javascript src="<%=basePath%>/scripts/getreset.js"></script>
<script language=javascript src="<%=basePath%>/scripts/edit.js"></script>
</head>
<body onload="loadTtransInfos();loadHidInfo();getDateObj();loadDateSelect();">
<jsp:include flush="true" page="../common/infobar.jsp"></jsp:include>
<f:view>
<script language=javascript>

var imagePath = "<%=basePath%>/images" ;
var scriptPath = "<%=basePath%>/scripts";

try{
	parent.historyIframe.addHistory('/t_trans_info/t_trans_info_edit_list_List.faces?<%=FacesContext.getCurrentInstance().getApplication().createValueBinding("#{ttransInfoList.historyUrlParameter}").getValue(FacesContext.getCurrentInstance())%>',"<fmt:message key="ttransInfo.t_trans_info_edit_list_List.note" />","2")
}catch(e){}
</script>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<f:verbatim><div class="mytab1">
	    <ul class="myTabBar1">
	      <li class="Selected"><a href="#"></f:verbatim><h:outputText value="#{text['ttransInfo.t_trans_info_edit_list_List.heading']}" /><f:verbatim></a></li>
	    </ul>
	</div></f:verbatim>
	<t:saveState value="#{ttransInfoList.ttransInfo}" />
	<t:saveState value="#{ttransInfoList.queryFields}" />
	<t:saveState id="ttransInfos" value="#{ttransInfoList.ttransInfos}" />
	    <a4j:jsFunction name="deleteTtransInfo" action="#{ttransInfoList.deleteBuffer}"  reRender="ttransInfoDataTable,ttransInfos" oncomplete="rowIndexVarOfTtransInfo = -1">
		<a4j:actionparam name="param1" assignTo="#{ttransInfoList.rowIndex}"  /> 
	</a4j:jsFunction>	

	<h:form id="ttransInfoList">
	<a4j:jsFunction name="loadTtransInfos" action="#{ttransInfoList.initTtransInfos}" reRender="ttransInfoList,ttransInfos" />
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="mainTable">
			<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
    			<h:panelGroup>
        			<f:verbatim><ul class="button_bar"></f:verbatim>						

	<h:panelGroup >
			   <f:verbatim><li></f:verbatim><h:commandLink action="#{ttransInfoList.edit}">
				<f:verbatim><span class="linkEditImg"></span></f:verbatim>
				<h:outputText styleClass="linkEditImg"  value="#{text['actionlistrec.t_trans_info_edit_list.2c90834917aea6a90117afb19c8800a8']}"  onclick="if(rowIndexVarOfTtransInfo == -1){alert('#{text['button.selected.confirm']}');return false;}"/>
					<t:updateActionListener property="#{actionParameter.successAction}" value="t_trans_info/t_trans_info_edit_form_EditForm"/>
			   </h:commandLink><f:verbatim></li></f:verbatim>				   
			        </h:panelGroup>

	<h:panelGroup >
			   <f:verbatim><li></f:verbatim>
				<h:commandLink action="#{ttransInfoList.view}" onclick="if(rowIndexVarOfTtransInfo == -1){alert('#{text['button.selected.confirm']}');return false;}">
				<f:verbatim><span class="linkViewImg"></span></f:verbatim><h:outputText styleClass="buttonText"  value="#{text['actionlistrec.t_trans_info_edit_list.2c90834917aea6a90117afb19ca700a9']}"/>
					<t:updateActionListener property="#{actionParameter.successAction}" value="t_trans_info/t_trans_info_view_form_ViewForm"/>
			   </h:commandLink><f:verbatim></li></f:verbatim>
			        </h:panelGroup>

	<h:panelGroup >
            <f:verbatim><li></f:verbatim>
				<h:commandLink action="#{ttransInfoList.delete}"	onclick="if(rowIndexVarOfTtransInfo == -1){alert('#{text['button.selected.confirm']}');return false;}else if(!confirm('#{text['button.confirm.delete']}')){return false;}"  >
						<f:verbatim><span class="linkDelImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistrec.t_trans_info_edit_list.2c90834917aea6a90117afb19ce500aa']}"/>
			</h:commandLink><f:verbatim></li></f:verbatim>
			        </h:panelGroup>

	            <f:verbatim><li></f:verbatim><h:commandLink action="#{ttransInfoList.add}"  >
					<t:updateActionListener property="#{actionParameter.successAction}" value="url:../t_trans_info/t_trans_info_edit_form_EditForm.faces" />
					<f:verbatim><span class="linkAddImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['actionlistform.t_trans_info_edit_list.2c90834917aea6a90117afb19c4900a7']}"/>
	            </h:commandLink><f:verbatim></li></f:verbatim>
                <f:verbatim><li></f:verbatim><h:commandLink action="#{ttransInfoList.save}">
					<f:verbatim><span class="linkSaveImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.save']}"/>
				</h:commandLink><f:verbatim></li></f:verbatim>		
				<f:verbatim></ul></f:verbatim>
				</h:panelGroup>
			</h:panelGrid>
<f:verbatim>				
<script>
		var rowIndexVarOfTtransInfo = -1;
</script>
</f:verbatim>
<h:inputHidden id="ttransInfoRowIndex" value="#{ttransInfoList.rowIndex}"></h:inputHidden>
			<t:dataTable id="ttransInfoDataTable" var="ttransInfo"
				value="#{ttransInfoList.ttransInfos}" rowClasses="rowsClass,rowsClass2" rowIndexVar="rowIndexVar" rowOnClick="rowIndexVarOfTtransInfo='#{rowIndexVar}';document.getElementById('ttransInfoList:ttransInfoRowIndex').value='#{rowIndexVar}';"  onclick="hightlightRows(this)"
				preserveDataModel="true" 
				rows="50"
			
				sortColumn="#{ttransInfoList.sortColumn}"
				sortAscending="#{ttransInfoList.ascending}"
				binding="#{ttransInfoList.dataTable}"  headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd">
				<t:column styleClass="listTableArrow">
						<h:graphicImage style="visibility:hidden;" url="../images/leftFrame_show.gif" />
				</t:column>

				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="settleDt" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.settleDt']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:panelGroup>
			           <be:inputDate id="settleDt" value="#{ttransInfo.settleDt}" style="width:90%" tabindex="1"   styleClass="edit_input">
					     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
		               </be:inputDate>
   			         </h:panelGroup>
                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="sysTraNo" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.sysTraNo']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="sysTraNo" value="#{ttransInfo.sysTraNo}" style="width:'96%'" tabindex="2"   maxlength="6"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="respCd4" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.respCd4']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="respCd4" value="#{ttransInfo.respCd4}" style="width:'96%'" tabindex="3"   maxlength="2"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="transId" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.transId']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="transId" value="#{ttransInfo.transId}" style="width:'96%'" tabindex="4"   maxlength="3"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="settleIn" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.settleIn']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="settleIn" value="#{ttransInfo.settleIn}" style="width:'96%'" tabindex="5"   maxlength="1"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="transAt" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.transAt']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
				    <be:inputAmount id="transAt" value="#{ttransInfo.transAt}" styleClass="edit_input" style="width:'90%'" tabindex="6" >
					   <s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['ttransInfo.transAt']}" client="true" server="false" />
				     </be:inputAmount>
                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="msgTp" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.msgTp']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="msgTp" value="#{ttransInfo.msgTp}" style="width:'96%'" tabindex="7"   maxlength="4"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="locTransDtTm" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.locTransDtTm']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="locTransDtTm" value="#{ttransInfo.locTransDtTm}" style="width:'96%'" tabindex="8"   maxlength="10"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mchntTp" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.mchntTp']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="mchntTp" value="#{ttransInfo.mchntTp}" style="width:'96%'" tabindex="9"   maxlength="4"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="retriRefNo" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.retriRefNo']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="retriRefNo" value="#{ttransInfo.retriRefNo}" style="width:'96%'" tabindex="10"   maxlength="12"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="priAcctNo" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.priAcctNo']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="priAcctNo" value="#{ttransInfo.priAcctNo}" style="width:'96%'" tabindex="11"   maxlength="21"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="bin" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.bin']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="bin" value="#{ttransInfo.bin}" style="width:'96%'" tabindex="12"   maxlength="14"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="cardAttr" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.cardAttr']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="cardAttr" value="#{ttransInfo.cardAttr}" style="width:'96%'" tabindex="13"   maxlength="2"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="cardMedia" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.cardMedia']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="cardMedia" value="#{ttransInfo.cardMedia}" style="width:'96%'" tabindex="14"   maxlength="1"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="termId" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.termId']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="termId" value="#{ttransInfo.termId}" style="width:'96%'" tabindex="15"   maxlength="8"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="mchntCd" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.mchntCd']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="mchntCd" value="#{ttransInfo.mchntCd}" style="width:'96%'" tabindex="16"   maxlength="15"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="cardAccptrNmLoc" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.cardAccptrNmLoc']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="cardAccptrNmLoc" value="#{ttransInfo.cardAccptrNmLoc}" style="width:'96%'" tabindex="17"   maxlength="40"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="acqInsIdCd" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.acqInsIdCd']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="acqInsIdCd" value="#{ttransInfo.acqInsIdCd}" style="width:'96%'" tabindex="18"   maxlength="13"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="fwdInsIdCd" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.fwdInsIdCd']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="fwdInsIdCd" value="#{ttransInfo.fwdInsIdCd}" style="width:'96%'" tabindex="19"   maxlength="13"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="rcvInsIdCd" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.rcvInsIdCd']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="rcvInsIdCd" value="#{ttransInfo.rcvInsIdCd}" style="width:'96%'" tabindex="20"   maxlength="13"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="issInsIdCd" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.issInsIdCd']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="issInsIdCd" value="#{ttransInfo.issInsIdCd}" style="width:'96%'" tabindex="21"   maxlength="13"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="origSysTraNo" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.origSysTraNo']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="origSysTraNo" value="#{ttransInfo.origSysTraNo}" style="width:'96%'" tabindex="22"   maxlength="6"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="origTransmsnDtTm" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.origTransmsnDtTm']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="origTransmsnDtTm" value="#{ttransInfo.origTransmsnDtTm}" style="width:'96%'" tabindex="23"   maxlength="10"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="rsnCd" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.rsnCd']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="rsnCd" value="#{ttransInfo.rsnCd}" style="width:'96%'" tabindex="24"   maxlength="4"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="authDt" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.authDt']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
			        <h:panelGroup>
			           <be:inputDate id="authDt" value="#{ttransInfo.authDt}" style="width:90%" tabindex="25"   styleClass="edit_input">
					     <f:convertDateTime pattern="yyyy-MM-dd" timeZone="GMT+8"/>
		               </be:inputDate>
   			         </h:panelGroup>
                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="authIdRespCd" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.authIdRespCd']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="authIdRespCd" value="#{ttransInfo.authIdRespCd}" style="width:'96%'" tabindex="26"   maxlength="7"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="posEntryMdCd" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.posEntryMdCd']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="posEntryMdCd" value="#{ttransInfo.posEntryMdCd}" style="width:'96%'" tabindex="27"   maxlength="3"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="posCondCd" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.posCondCd']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="posCondCd" value="#{ttransInfo.posCondCd}" style="width:'96%'" tabindex="28"   maxlength="2"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="procCd" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.procCd']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="procCd" value="#{ttransInfo.procCd}" style="width:'96%'" tabindex="29"   maxlength="6"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="settleYm" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.settleYm']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="settleYm" value="#{ttransInfo.settleYm}" style="width:'96%'" tabindex="30"   maxlength="6"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


				<t:column>
					<f:facet name="header">
						<t:commandSortHeader columnName="fwdInsIdOriginal" arrow="true">		                
							<h:outputText value="#{text['ttransInfo.fwdInsIdOriginal']}" />
						</t:commandSortHeader>	
				</f:facet>
	           <h:panelGroup>
		         <f:verbatim><span class="notw"></span></f:verbatim>
                   <h:panelGroup>


		               <h:inputText id="fwdInsIdOriginal" value="#{ttransInfo.fwdInsIdOriginal}" style="width:'96%'" tabindex="31"   maxlength="13"  styleClass="edit_input">

				        </h:inputText>
                      </h:panelGroup>


                               </h:panelGroup>				</t:column>


			</t:dataTable>
		<h:panelGrid columns="2" styleClass="scrollerTable" columnClasses="column1,column2">	
            <t:dataScroller id="scroll_1"
                    for="ttransInfoDataTable"
                    rowsCountVar="rowsCount"
                    displayedRowsCountVar="displayedRowsCountVar"
                    firstRowIndexVar="firstRowIndex"
                    lastRowIndexVar="lastRowIndex"
                    pageCountVar="pageCount"
                    immediate="true"
                    pageIndexVar="pageIndex"
                    paginator="true"
                    paginatorMaxPages="9">
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
                    for="ttransInfoDataTable"
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
	<script type="text/javascript">
		highlightTableRows("ttransInfoList:ttransInfoDataTable");
	</script>
</f:view>
</body>