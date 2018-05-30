<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Customer</h3>

	<form:form action="saveCustomer" modelAttribute="customer" method="POST" class="ui form">
		<div class="field">
			<label>Name</label> 
			<form:input path="name"/>
		</div>
		<div class="field">
			<label>Surname</label>
			<form:input path="surname"/>
		</div>
		<div class="field">
			<label>Fiscal ID</label> 
			<form:input path="fiscal_id"/>
		</div>
		<div class="field">
			<label>Date Patent</label> 
			<form:input path="date_patent"/>
		</div>
		<div class="field">
			<label>History Events</label> 
			<form:input path="history_events"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>