<%@ include file="/WEB-INF/views/init.jsp"%>

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

<liferay-ui:error key="name-can-not-be-empty"
	message="name-can-not-be-empty" />
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

		<aui:form method="POST" action="#">


			<div class="editForm">

			<aui:input type="hidden" name="deductionId" value="" />
			<div class="edit1">
			<aui:select name="typeDnation" label="Deduction Type">
				<aui:option value="type1">Association of disabled children</aui:option>
				<aui:option value="type2">Association of syrian children</aui:option>
				<aui:option value="type3">Social Welfare Program</aui:option>
			</aui:select>
</div>
			<div class="edit1">
			<aui:input type="text" name="amount" label="Total Amount" />
			</div>
			<div class="edit1">
			<aui:input type="text" name="amount" label="number Of month" />
			</div>
			</div>
			<div class="button-holder">
				<aui:button cssClass="btn" name="btn-submit" type="submit" label=""
					value="Submit" />
				<aui:button cssClass="btn" name="btn-cancel" onClick="${cancel}"
					type="button" label="" value="Cancel" />
			</div>
		</aui:form>
	</div>
</div>
<aui:script>
	function cancel() {
		$(location).attr('href', '<%=cancel%>');
	}
</aui:script>
	

