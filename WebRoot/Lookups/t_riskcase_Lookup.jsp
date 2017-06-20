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
<body onload="loadTriskcases();loadHidInfo();getDateObj()">
<input type="hidden" id="imagePath" value="<%=basePath%>/images">
<input type="hidden" id="scriptPath" value="<%=basePath%>/scripts">


<f:view>
	<f:loadBundle var="text" basename="ApplicationResources" />
	<br>
	<div class="mytab1">
   	    <ul class="myTabBar1">
   	      <li class="Selected"><a href="#" onmouseup="hidShowSearchImg('triskcaseQuery:searchtab')"><h:outputText value="#{text['triskcase.triskcaseList.heading']}" /><h:graphicImage id="searchImgId" styleClass="searchImgClass" url="../images/button_showall.gif" /></a></li>
   	    </ul>
   	</div>

	<h:form id="triskcaseQuery">
		<a4j:jsFunction name="queryTriskcases" action="#{triskcaseList.query}" reRender="triskcaseList" />   		
		<h:panelGrid id="searchtab" columns="1" cellspacing="0" cellpadding="0" styleClass="mainSearchTab">
	
		<h:panelGrid columns="1" cellspacing="0" cellpadding="0" styleClass="titleTable" columnClasses="titleTdClass" >
			<h:panelGroup>
				<f:verbatim><ul id="tool_3"></f:verbatim>
					
				<f:verbatim><li></f:verbatim>				
				<h:commandLink onclick="resetTable(document.getElementById('triskcaseQuery'));">
					<f:verbatim><span class="linkResetImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.reset']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
				<f:verbatim><li></f:verbatim>
				<h:commandLink  onclick="queryTriskcases();return false;">
					<f:verbatim><span class="linkSearchImg"></span></f:verbatim><h:outputText styleClass="buttonText" value="#{text['button.query']}" />
				</h:commandLink>	
				<f:verbatim></li></f:verbatim>
			
	            <f:verbatim></ul></f:verbatim>			
			</h:panelGroup>
		 </h:panelGrid>
		 
		
		<h:panelGrid columns="2" cellspacing="0" cellpadding="0"  columnClasses="width50percent,width50percent" styleClass="width100percent backColor"> 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="caseno" value="#{text['triskcase.caseno']}  #{text['query.equal']}" />

				<h:panelGroup>
			    <h:inputText id="caseno" value="#{triskcaseList.queryFields.caseno}" tabindex="1" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="belongToInst" value="#{text['triskcase.belongToInst']}  #{text['query.equal']}" />

				<h:panelGroup>
				<h:selectOneMenu id="belongToInst" value="#{triskcaseList.queryFields.belongToInst}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>

                 <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
			    <h:outputLabel for="relativeTransAmt_min" value="#{text['triskcase.relativeTransAmt']}  #{text['query.from']}" />
				<h:panelGroup>
			    <h:inputText id="relativeTransAmt_min" value="#{triskcaseList.queryFields.relativeTransAmt_min}" tabindex="2" styleClass="edit_input">
					<s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.relativeTransAmt_min']}" client="true" server="false" />
				</h:inputText>
				</h:panelGroup>
	         </h:panelGrid>
			 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="relativeTransAmt_max" value="#{text['query.to']}" />				
				<h:panelGroup>
			    <h:inputText id="relativeTransAmt_max" value="#{triskcaseList.queryFields.relativeTransAmt_max}" tabindex="3" styleClass="edit_input">
					<s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.relativeTransAmt_max']}" client="true" server="false" />
				</h:inputText>
				</h:panelGroup>
			  </h:panelGrid>

                 <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
			    <h:outputLabel for="relativeTransNum_min" value="#{text['triskcase.relativeTransNum']}  #{text['query.from']}" />
				<h:panelGroup>
			    <h:inputText id="relativeTransNum_min" value="#{triskcaseList.queryFields.relativeTransNum_min}" styleClass="edit_input">
					<s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.relativeTransNum_min']}" client="true" server="false" />
				</h:inputText>					
				</h:panelGroup>
	         </h:panelGrid>
			 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="relativeTransNum_max" value="#{text['query.to']}" />				
				<h:panelGroup>
			    <h:inputText id="relativeTransNum_max" value="#{triskcaseList.queryFields.relativeTransNum_max}" styleClass="edit_input">
					<s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.relativeTransNum_max']}" client="true" server="false" />
				</h:inputText>					
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="warnLevel" value="#{text['triskcase.warnLevel']}  #{text['query.equal']}" />

				<h:panelGroup>
				<h:selectOneMenu id="warnLevel" value="#{triskcaseList.queryFields.warnLevel}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.3']}" itemValue="3"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="casefrom" value="#{text['triskcase.casefrom']}  #{text['query.equal']}" />

				<h:panelGroup>
				<h:selectOneMenu id="casefrom" value="#{triskcaseList.queryFields.casefrom}">
					<f:selectItem itemLabel="------" itemValue=""/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.5']}" itemValue="5"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.6']}" itemValue="6"/>
				</h:selectOneMenu >				
				</h:panelGroup>
			  </h:panelGrid>

                 <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
			    <h:outputLabel for="createdate_min" value="#{text['triskcase.createdate']}  #{text['query.from']}" />
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="createdate_min" value="#{triskcaseList.queryFields.createdate_min}" size="18" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
	         </h:panelGrid>
			 
             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="createdate_max" value="#{text['query.to']}" />				
				<h:panelGroup>
			    <h:panelGroup>
			        <h:inputText id="createdate_max" value="#{triskcaseList.queryFields.createdate_max}" size="18" styleClass="edit_input"/><f:verbatim><span class="datebutton" onclick="event.cancelBubble=true;new Calendar().show(this)"  /></span></f:verbatim>	
   			    </h:panelGroup>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="mchntName_like" value="#{text['triskcase.mchntName']}  #{text['query.like']}" />

				<h:panelGroup>
			    <h:inputText id="mchntName_like" value="#{triskcaseList.queryFields.mchntName_like}" tabindex="4" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="triggerRuleNum" value="#{text['triskcase.triggerRuleNum']}  #{text['query.equal']}" />

				<h:panelGroup>
			    <h:inputText id="triggerRuleNum" value="#{triskcaseList.queryFields.triggerRuleNum}" styleClass="edit_input">
					<s:commonsValidator type="floatRange" min="0" max="10000000" arg="#{text['triskcase.triggerRuleNum']}" client="true" server="false" />
				</h:inputText>					
				</h:panelGroup>
			  </h:panelGrid>

             <h:panelGrid columns="2" cellspacing="2" cellpadding="5" styleClass="sectionTableSearch backColor" columnClasses="colTitleSearch,colValueSearch">
				<h:outputLabel for="mchntMcc" value="#{text['triskcase.mchntMcc']}  #{text['query.equal']}" />

				<h:panelGroup>
			    <h:inputText id="mchntMcc" value="#{triskcaseList.queryFields.mchntMcc}" tabindex="5" styleClass="edit_input"/>
				</h:panelGroup>
			  </h:panelGrid>


		</h:panelGrid>			
			
		</h:panelGrid>
	</h:form>
	<t:saveState value="#{triskcaseList.queryFields}" />
	<t:saveState id="triskcases" value="#{triskcaseList.triskcases}" />
	
	<br>
		<div class="mytab1">
    	    <ul class="myTabBar1">
    	      <li class="Selected"><a href="#"><h:outputText value="#{text['triskcase.t_riskcase_List.heading']}" /></a></li>
    	    </ul>
    	</div>
	<h:form id="triskcaseList">
       <a4j:jsFunction name="loadTriskcases" action="#{triskcaseList.initTriskcases}" reRender="triskcaseList,triskcases" oncomplete="checkLookupS()" />		
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
			<t:dataTable id="triskcaseDataTable" var="triskcase"
				value="#{triskcaseList.triskcases}" rowClasses="rowsClass,rowsClass2"
				sortColumn="#{triskcaseList.sortColumn}"
				sortAscending="#{triskcaseList.ascending}"
				preserveDataModel="true"
				preserveSort="true"
				binding="#{triskcaseList.dataTable}" headerClass="listTableHead" styleClass="listTableDetail" columnClasses="listTableTd"
			>				
				<t:column>

					<h:selectBooleanCheckbox id = "select_checkbox" value="" 
						rendered="#{lookupParameter.multiSelect eq 'true'}" />
					<h:inputHidden id="id" value="#{triskcase.id}" />
					<h:inputHidden id="caseno" value="#{triskcase.caseno}" />
					<h:inputHidden id="mchntCd" value="#{triskcase.mchntCd}" />
					<h:inputHidden id="beginDate" value="#{triskcase.beginDate}" />
					<h:inputHidden id="endDate" value="#{triskcase.endDate}" />
					<h:inputHidden id="belongToInst" value="#{triskcase.belongToInst}" />
					<h:inputHidden id="relativeTransAmt" value="#{triskcase.relativeTransAmt}" />
					<h:inputHidden id="allTransAmt" value="#{triskcase.allTransAmt}" />
					<h:inputHidden id="allTransNum" value="#{triskcase.allTransNum}" />
					<h:inputHidden id="createdate" value="#{triskcase.createdate}" />
					<h:inputHidden id="score" value="#{triskcase.score}" />
					<h:inputHidden id="triggerRuleNum" value="#{triskcase.triggerRuleNum}" />
					<h:inputHidden id="mchntName" value="#{triskcase.mchntName}" />
					<h:inputHidden id="transMcc" value="#{triskcase.transMcc}" />
					<h:inputHidden id="processLimit" value="#{triskcase.processLimit}" />
					<h:inputHidden id="warnLevel" value="#{triskcase.warnLevel}" />
					<h:inputHidden id="otherno" value="#{triskcase.otherno}" />
					<h:inputHidden id="mchntMcc" value="#{triskcase.mchntMcc}" />
					<h:inputHidden id="triggerContent" value="#{triskcase.triggerContent}" />
					<h:inputHidden id="riskContent" value="#{triskcase.riskContent}" />
					<h:inputHidden id="acquireInstName" value="#{triskcase.acquireInstName}" />
					<h:inputHidden id="status" value="#{triskcase.status}" />
					<h:inputHidden id="comments1" value="#{triskcase.comments1}" />
					<h:inputHidden id="comments2" value="#{triskcase.comments2}" />
					<h:inputHidden id="comments3" value="#{triskcase.comments3}" />
					<h:inputHidden id="comments4" value="#{triskcase.comments4}" />
					<h:inputHidden id="comments5" value="#{triskcase.comments5}" />
					<h:inputHidden id="relativeTransNum" value="#{triskcase.relativeTransNum}" />
					<h:inputHidden id="trace" value="#{triskcase.trace}" />
					<h:inputHidden id="beenUrgent" value="#{triskcase.beenUrgent}" />
					<h:inputHidden id="urgentCnt" value="#{triskcase.urgentCnt}" />
					<h:inputHidden id="submit2Inst" value="#{triskcase.submit2Inst}" />
					<h:inputHidden id="casefrom" value="#{triskcase.casefrom}" />
					<h:inputHidden id="mchntId" value="#{triskcase.mchntId}" />
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcase.caseno']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcase.id}','#{triskcase.id}')">					
						<h:outputText value="#{triskcase.caseno}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcase.belongToInst']}" />
					</f:facet>
				<be:outputText id="belongToInst1" value="#{triskcase.belongToInst}">
                   <f:selectItems value="#{extSelectItems.belongToInstList}"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcase.relativeTransAmt']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcase.id}','#{triskcase.id}')">					
						<h:outputText value="#{triskcase.relativeTransAmt}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcase.relativeTransNum']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcase.id}','#{triskcase.id}')">					
						<h:outputText value="#{triskcase.relativeTransNum}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcase.warnLevel']}" />
					</f:facet>
				<be:outputText id="warnLevel1" value="#{triskcase.warnLevel}">
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.0']}" itemValue="0"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.warnLevel.3']}" itemValue="3"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcase.casefrom']}" />
					</f:facet>
				<be:outputText id="casefrom1" value="#{triskcase.casefrom}">
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.1']}" itemValue="1"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.2']}" itemValue="2"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.3']}" itemValue="3"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.4']}" itemValue="4"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.5']}" itemValue="5"/>
                   <f:selectItem itemLabel="#{text['triskcase.casefrom.6']}" itemValue="6"/>
				</be:outputText>
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcase.createdate']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcase.id}','#{triskcase.id}')">					
						<h:outputText value="#{triskcase.createdate}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcase.mchntName']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcase.id}','#{triskcase.id}')">					
						<h:outputText value="#{triskcase.mchntName}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcase.triggerRuleNum']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcase.id}','#{triskcase.id}')">					
						<h:outputText value="#{triskcase.triggerRuleNum}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
				<t:column>
					<f:facet name="header">
						<h:outputText value="#{text['triskcase.mchntMcc']}" />
					</f:facet>
				<h:outputLink onclick="returnLookupValue('#{triskcase.id}','#{triskcase.id}')">					
						<h:outputText value="#{triskcase.mchntMcc}"  styleClass="linkLookUp" />
				</h:outputLink>		
				</t:column>
			</t:dataTable>
		
		</h:panelGrid>
	</h:form>
	<input type=hidden id="hid" value='<%=request.getParameter("_value")%>' />
</f:view>
</body>