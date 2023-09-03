<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

	<form:form method="post" modelAttribute="expense">

		<form:hidden path="id" />

		<fieldset class="form-group">
			<form:label path="expenseDescription">Expense Description</form:label>
			<form:input path="expenseDescription" type="text" class="form-control"
				required="required" />
			<form:errors path="expenseDescription" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="payeeName">Payee Name</form:label>
			<form:input path="payeeName" type="text" class="form-control"
				required="required" />
			<form:errors path="payeeName" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="price">Price</form:label>
			<form:input path="price" type="text" class="form-control"
				required="required" />
			<form:errors path="price" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="date">Expense Date</form:label>
			<form:input path="date" type="text" class="form-control"
				required="required" />
			<form:errors path="date" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>