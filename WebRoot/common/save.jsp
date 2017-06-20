
<f:view>
	<f:loadBundle var="text" basename="ApplicationREsources" />
	<h:form id="saveAllConfig" >
		<h:commandButton value="#{text['basePage.saveAllConfig']}" action="#{basePage.saveAllConfig}" id="save" styleClass="button" />
	</h:form>
</f:view>

