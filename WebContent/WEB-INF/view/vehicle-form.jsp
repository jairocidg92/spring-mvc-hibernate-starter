<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add Vehicle</h3>
		<form:form action="saveVehicle" modelAttribute="vehicle" method="POST" class="ui form">		
		<div class="field">
			<label>Year</label> 
			<form:input path="year"/>
		</div>
		<div class="field">
			<label>Cubic</label> 
			<form:input path="cubic"/>
		</div>
		<div class="field">
			<label>Type</label> 
			<form:input path="type"/>
		</div>
		<div class="field">
			<label>Color</label> 
			<form:input path="color"/>
		</div>
		<div class="field">
			<label>Attribute</label> 
			<form:input path="attribute"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>