<div class="ui segment">
	<h3>List of Employees</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Name</th>
			<th>Surname</th>
			<th>Adress</th>
			<th>Birthday</th>
			<th>Actions</th>
		</thead>
		<!-- loop over and print our students -->
		<c:forEach var="tempE" items="${employees}">

			<tr>
				<td>${tempE.name}</td>
				<td>${tempE.surname}</td>
				<td>${tempE.adress}</td>
				<td>${tempE.birthday}</td>
				<td><button type="submit" class="ui button" id="${tempE.id}"
					name="deleteEmployee"><i class="remove user icon"></i>
					 Delete</button>
					 <a class="ui button"
					href="<c:url value="/employee/${tempE.id}"></c:url>"><i class="unhide icon"></i>
					View/Edit</a>
					<a class="ui button" href="<c:url value="/employee/assignDepartament/${tempE.id}"></c:url>"><i
						class="add user icon"></i>Assign Departament</a>
					<a class="ui button" href="<c:url value="/departament/employee/${tempE.id}/list"></c:url>"><i
						class="list icon"></i>List Departaments</a>		
			</tr>
		</c:forEach>
	</table>
	
	<a class="ui button" href="${pageContext.request.contextPath}/employee/showAddForm" class="item"><i	class="add circle icon"></i>Add Employee</a>
</div>



<script type="text/javascript">
	$("[name='deleteEmployee']").click(function() {
		var urlCall = "<c:url value="/api/employee/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('id'),
			type : 'DELETE',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/employee/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>