<div class="ui segment">
	<h3>List of Vehicles</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Year</th>
			<th>Cubic</th>
			<th>Type</th>
			<th>Color</th>
			<th>Attribute</th>
			<th>Actions</th>
		</thead>
		<!-- loop over and print our courses -->
		<c:forEach var="tempVehicle" items="${vehicles}">
			<tr>
				<td>${tempVehicle.year}</td>
				<td>${tempVehicle.cubic}</td>
				<td>${tempVehicle.type}</td>
				<td>${tempVehicle.color}</td>
				<td>${tempVehicle.attribute}</td>
				<td><button type="submit" id="${tempVehicle.id}" class="ui button"
					name="deleteVehicle"><i class="remove user icon"></i>
					 Delete</button>
					 <a class="ui button"
					href="<c:url value="/vehicle/${tempVehicle.id}"></c:url>"><i class="unhide icon"></i>
					View/Edit</a>
			</tr>
		</c:forEach>
	</table>
			<a class="ui button" href="${pageContext.request.contextPath}/vehicle/showAddForm" class="item"><i	class="add circle icon"></i>Add Vehicle</a>
</div>

<script type="text/javascript">
	$("[name='deleteVehicle']").click(function() {
		var urlCall = "<c:url value="/api/vehicle/delete/"></c:url>";
		$.ajax({
			url : urlCall + $(this).attr('id'),
			type : 'DELETE',
			success : function(result) {
				console.log(result);
				$(location).attr("href", "<c:url value="/vehicle/list"></c:url>");
			},
			error : function(result) {
				console.log(result);
			},
		});
	});
</script>