
<%@ include file="init.jsp" %>
<h1>Liferay Spring Portlet MVC</h1>

<liferay-ui:search-container delta="${searchContainer.delta}" emptyResultsMessage="${searchContainer.emptyResultsMessage}" searchContainer="${searchContainer}">

	<liferay-ui:search-container-results
		total="${searchContainer.total}"
		results="${searchContainer.results}"
	/>
	
	<liferay-ui:search-container-row
		className="com.stc.poc.model.beans.DeductionDTO"
		modelVar="deduction"
		keyProperty="id"
	>
		
		
		<liferay-ui:search-container-column-text
			name="Created by"
			value="<%= deduction.getCreatedBy() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="State"
			value="<%= deduction.getState() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="N months"
			value="<%= deduction.getnMonths() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Total Amount"
			value="<%= deduction.getTotalAmount() %>"
		/>
		
		
		<liferay-ui:search-container-row-parameter
			name="deduction"
			value="<%= deduction %>"
		/>
		
		<liferay-ui:search-container-column-jsp
			cssClass="column-actions"
			align="right"
			path="/WEB-INF/views/actionButton.jsp"
		/>
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator paginate="true" />
	
</liferay-ui:search-container>