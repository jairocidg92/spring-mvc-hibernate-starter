<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Departament</h3>

	<form:form action="saveDepartament" modelAttribute="departament" method="POST" class="ui form">
		<div class="field">
			<label>Phone</label> 
			<form:input path="phone"/>
		</div>
		<div class="field">
			<label>Adress</label>
			<form:input path="adress"/>
		</div>
		<div class="field">
			<label>Manager</label> 
			<form:input path="manager"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>