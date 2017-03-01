
<%@ include file="init.jsp" %>

<liferay-ui:error key="succes-cancel-deduction" message="Cannot cancel the deduction, please make sure that this deduction is not already cancelled" />
<liferay-ui:success key="cancel-succes" message="Succes" />

<div class="container">

<h1>Hello! José Oliveira</h1>
          <div class="jumbotron description-profil">
            <div class="row">
              <div class="col-md-8">
                <h2>position :  Developer</h2>
                <p><strong>salary :</strong>  7000</p>app
                <p><strong>Role :</strong> Requester</p>
                <p><strong>Email :</strong> jose.oliveira@wrightia.com</p>
              </div>
              <div class="col-md-4">
                <img class="img-thumbnail img-profil" src="http://www.snut.fr/wp-content/uploads/2015/06/image-de-profil-2-150x150.jpg"/>
              </div>
            </div>
</div>

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
			name="Deduction type"
			value="<%= deduction.getDeductionTypeDetailName() %>"
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
	
	<liferay-ui:search-iterator paginate="false" />
	
</liferay-ui:search-container>

</div>