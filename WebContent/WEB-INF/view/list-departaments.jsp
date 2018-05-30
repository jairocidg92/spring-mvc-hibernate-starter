<div class="ui segment">
	<h3>List of Departaments</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Phone</th>
			<th>Adress</th>
			<th>Manager</th>
			<th>Actions</th>
		</thead>
		<!-- loop over and print our courses -->
		<c:forEach var="tempD" items="${departaments}">
			<tr>
				<td>${tempD.phone}</td>
				<td>${tempD.adress}</td>
				<td>${tempD.manager}</td>
				<td><button type="submit" id="${tempD.ID_DEPARTAMENT}" class="ui button"
					name="deleteDepartament"><i class="remove user icon"></i>
					 Delete</button>
					 <a class="ui button"
					href="<c:url value="/departament/${tempD.ID_DEPARTAMENT}"></c:url>"><i class="unhide icon"></i>
					View/Edit</a>
					<a class="ui button" href="<c:url value="/employee/departament/${tempD.ID_DEPARTAMENT}/list"></c:url>"><i
						class="list icon"></i>List Employees</a>
			</tr>
		</c:forEach>
	</table>
		<a class="ui button" href="${pageContext.request.contextPath}/departament/showAddForm" class="item"><i	class="add circle icon"></i>Add Departament</a>
	
</div>

<script type="text/javascript">
	$("[name='deleteDepartament']").click(function() {
		var urlCall = "<c:url value="/api/departament/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('id'),
			type : 'DELETE',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/departament/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>