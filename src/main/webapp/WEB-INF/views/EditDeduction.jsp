<%@ include file="/WEB-INF/views/init.jsp" %>

<h1></h1>

<%-- <c:choose>
	<c:when test="${deductionDTO.id > 0}">
		<h4><liferay-ui:message key="annuaire.application.update.label" /></h4>
	</c:when>
	<c:otherwise>
		<h4><liferay-ui:message key="annuaire.application.new.label" /></h4>
	</c:otherwise>

</c:choose> --%>


<portlet:actionURL var="editDeductionUrl">

  <portlet:param name="action" value="submitDeduction"></portlet:param>
	
</portlet:actionURL>

<portlet:actionURL var="cancel">

	<portlet:param name="action" value="cancel"></portlet:param>
	
</portlet:actionURL>

<liferay-ui:error key="name-can-not-be-empty" message="name-can-not-be-empty"/>
<div class="container">
<h1>Hello! José Oliveira</h1>
          <div class="jumbotron description-profil">
            <div class="row">
              <div class="col-md-8">
                <h2>position :  Developer</h2>
                <p><strong>salary :</strong>  7000</p>
                <p><strong>Role :</strong> Requester</p>
                <p><strong>Email :</strong> jose.oliveira@wrightia.com</p>
              </div>
              <div class="col-md-4">
                <img class="img-thumbnail img-profil" src="http://www.snut.fr/wp-content/uploads/2015/06/image-de-profil-2-150x150.jpg"/>
              </div>
            </div>
</div>

<aui:form method="POST" action="#">
	
	<aui:input type="hidden"  name="deductionId" value="" />
	<aui:select name="typeDnation" label="Deduction Type">
	    <aui:option value="type1">Association of disabled children</aui:option>
	    <aui:option value="type2">Association of syrian children</aui:option>
	    <aui:option value="type3">Social Welfare Program</aui:option>
	</aui:select>
	
	<aui:select name="select-example" label="Donate to">
	    <aui:option value="Option 1">Donation 1</aui:option>
	    <aui:option value="Option 2">Donation 2</aui:option>
	    <aui:option value="Option 3">Donation 3</aui:option>
	</aui:select>
	<aui:input type="text"  name="amount" label="Total Amount"/>
	<aui:select name="number-month" label="Number of Month">
	    <aui:option value="1">1 month</aui:option>
	    <aui:option value="Option 2">2 month</aui:option>
	    <aui:option value="Option 3">3 month</aui:option>
	    <aui:option value="Option 4">4 month</aui:option>
	    <aui:option value="Option 5">5 month</aui:option>
	    <aui:option value="Option 5">6 month</aui:option>
	</aui:select>
	<aui:input type="text"  name="amount" label="number Of month" />
	
	<div class="button-holder">
		<aui:button cssClass="btn" name="btn-submit" type="submit" label="" value="Submit" />
		<aui:button cssClass="btn" name="btn-cancel" onClick="${cancel}" type="button" label="" value="Cancel" />
	</div>
</aui:form>
</div>
<aui:script>
function cancel() {
   $(location).attr('href','<%=cancel%>');
}

</aui:script>
	