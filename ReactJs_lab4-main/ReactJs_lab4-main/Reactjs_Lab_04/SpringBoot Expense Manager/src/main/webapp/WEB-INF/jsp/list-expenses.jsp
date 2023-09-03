<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>My Expenses</caption>
			<thead>
				<tr>
					<th>Expense Date</th>
					<th>Payee Name</th>
					<th>Price</th>
					<th>Expense Date</th>					
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${expenses}" var="expense">
					<tr>
						<td>${expense.expenseDescription}</td>
						<td>${expense.payeeName}</td>
						<td>${expense.price}</td>
						<td>${expense.date}</td>
						
						<td><a type="button" class="btn btn-success"
							href="/update-expense?id=${expense.id}">Update</a></td>
						<td><a type="button" class="btn btn-danger"
							href="/delete-expense?id=${expense.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-expense">Add a new Expense</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>