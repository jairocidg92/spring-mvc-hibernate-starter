<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Student</h3>

	<form:form action="saveEmployee" modelAttribute="employee" method="POST" class="ui form">
		<div class="field">
			<label>First Name</label> 
			<form:input path="name"/>
		</div>
		<div class="field">
			<label>Last Name</label>
			<form:input path="surname"/>
		</div>
		<div class="field">
			<label>Adress</label> 
			<form:input path="adress"/>
		</div>
		<div class="field">
			<label>Birtday</label> 
			<form:input path="birthday"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>