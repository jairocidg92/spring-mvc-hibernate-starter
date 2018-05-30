<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Assign Departament to ${employee.name}${employee.surname}</h3>
	<c:if test="${not empty departaments}">

		<form method="post"
			action="${pageContext.request.contextPath}/employee/assignDepartament/${employee.id}">
			<div class="field">

				<select name="DepartamentId">
					<c:forEach items="${departaments}" var="adepartament">
						<option value="${adepartament.ID_DEPARTAMENT}">${adepartament.phone}</option>
					</c:forEach>
				</select>
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</div>
			<div class="field">

				<input type="submit" value="Add" />
			</div>
		</form>
	</c:if>
	<c:if test="${empty departaments}">
		<h3>There are no other Departaments</h3>
	</c:if>
</div>