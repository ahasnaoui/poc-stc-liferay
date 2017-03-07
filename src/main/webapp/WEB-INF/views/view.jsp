
<%@ include file="init.jsp"%>

<portlet:renderURL var="cancelDeduction">
  <portlet:param name="action" value="cancelDeduction"></portlet:param>
  
</portlet:renderURL>

<portlet:renderURL var="editDeduction">
	<portlet:param name="action" value="EditDeduction"></portlet:param>
</portlet:renderURL>
 


<liferay-ui:error key="succes-cancel-deduction"
	message="Cannot cancel the deduction, please make sure that this deduction is not already cancelled" />
<liferay-ui:success key="cancel-succes" message="Succes" />

<div class="col3">

	<div class="profileBox">
		<img
			src="http://www.snut.fr/wp-content/uploads/2015/06/image-de-profil-2-150x150.jpg" />
		<div class="welcome">Welcome,</div>
		<div class="name">Ziad A.Ismail</div>
		<hr />
		<div class="welcome">
			<strong>Salary :</strong> 7000
		</div>
		<div class="welcome">
			<strong>Role :</strong> Requester
		</div>
		<div class="welcome">
			<strong>Email :</strong> ziad@provenconsult.com
		</div>
		<hr />

	</div>
	<div class="box1">
		<div class="title">
			<a href="#" style="color: white;"> E-Deduction </a>
		</div>

	</div>


</div>


<div class="col4">


	<div class="box3">
		<div class="title4">E-Deduction</div>

	</div>

	<div class="row">
		<div class="col-xs-6">
		<div class="name" style="color:#6f3974"><strong>Social welfore program</strong></div>
		<div class="welcome">
			<strong>created by :</strong> Ziad A.Ismail
		</div>
		
		<div class="welcome">
			<strong>State :</strong> Accepted
		</div>
		<div class="welcome">
			<strong>Total amount :</strong> 100
		</div>
		<div class="welcome">
			<strong>Number months :</strong> 4
		</div>
	</div>
	<div class="col-xs-6">
			<p>
				<liferay-ui:icon-menu>
	  <liferay-ui:icon image="edit" message="EDIT"
	   url="<%=editDeduction %>" />
	 
	 <liferay-ui:icon image="delete" message="CANCEL"
	  url="<%=cancelDeduction %>" />
	</liferay-ui:icon-menu>
			</p>
	</div>
	</div>
	<hr/>

	<div class="row">
		<div class="col-xs-6">
		<div class="name" style="color:#6f3974"><strong>Social welfore program</strong></div>
		<div class="welcome">
			<strong>created by :</strong> Ziad A.Ismail
		</div>
		
		<div class="welcome">
			<strong>State :</strong> Accepted
		</div>
		<div class="welcome">
			<strong>Total amount :</strong> 100
		</div>
		<div class="welcome">
			<strong>Number months :</strong> 4
		</div>
	</div>
	<div class="col-xs-6">
			<p>
				<liferay-ui:icon-menu>
	  <liferay-ui:icon image="edit" message="EDIT"
	   url="<%=editDeduction %>" />
	 
	 <liferay-ui:icon image="delete" message="CANCEL"
	  url="<%=cancelDeduction %>" />
	</liferay-ui:icon-menu>
			</p>
	</div>
	</div>
	<hr/>

	<div class="row">
		<div class="col-xs-6">
		<div class="name" style="color:#6f3974"><strong>Social welfore program</strong></div>
		<div class="welcome">
			<strong>created by :</strong> Ziad A.Ismail
		</div>
		
		<div class="welcome">
			<strong>State :</strong> Accepted
		</div>
		<div class="welcome">
			<strong>Total amount :</strong> 100
		</div>
		<div class="welcome">
			<strong>Number months :</strong> 4
		</div>
	</div>
	<div class="col-xs-6">
			<p>
				<liferay-ui:icon-menu>
	  <liferay-ui:icon image="edit" message="EDIT"
	   url="<%=editDeduction %>" />
	 
	 <liferay-ui:icon image="delete" message="CANCEL"
	  url="<%=cancelDeduction %>" />
	</liferay-ui:icon-menu>
			</p>
	</div>
	</div>
	<hr/>

	<div class="row">
		<div class="col-xs-6">
		<div class="name" style="color:#6f3974"><strong>Social welfore program</strong></div>
		<div class="welcome">
			<strong>created by :</strong> Ziad A.Ismail
		</div>
		
		<div class="welcome">
			<strong>State :</strong> Accepted
		</div>
		<div class="welcome">
			<strong>Total amount :</strong> 100
		</div>
		<div class="welcome">
			<strong>Number months :</strong> 4
		</div>
	</div>
	<div class="col-xs-6">
			<p>
				<liferay-ui:icon-menu>
	  <liferay-ui:icon image="edit" message="EDIT"
	   url="<%=editDeduction %>" />
	 
	 <liferay-ui:icon image="delete" message="CANCEL"
	  url="<%=cancelDeduction %>" />
	</liferay-ui:icon-menu>
			</p>
	</div>
	</div>
	<hr/>

	


	<%-- <liferay-ui:search-container delta="${searchContainer.delta}" emptyResultsMessage="${searchContainer.emptyResultsMessage}" searchContainer="${searchContainer}">

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
	
</liferay-ui:search-container> --%>

</div>