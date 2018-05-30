<div class="ui segment">
	<h3>List of Customers</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Name</th>
			<th>Surname</th>
			<th>Fiscal ID</th>
			<th>Date Patent</th>
			<th>History Events</th>
			<th>Actions</th>
		</thead>
		<!-- loop over and print our teachers -->
		<c:forEach var="tempCustomer" items="${customers}">

			<tr>
				<td>${tempCustomer.name}</td>
				<td>${tempCustomer.surname}</td>
				<td>${tempCustomer.fiscal_id}</td>
				<td>${tempCustomer.date_patent}</td>
				<td>${tempCustomer.history_events}</td>
				<td><button type="submit" id="${tempCustomer.id}" class="ui button"
						name="deleteCustomer">
						<i class="remove user icon"></i> Delete
					</button> 
					<a class="ui button" href="<c:url value="/customer/${tempCustomer.id}"></c:url>"><i
						class="unhide icon"></i> View/Edit</a>
<%-- 					<a class="ui button" href="<c:url value="/customer/assignVehicle/${tempCustomer.id}"></c:url>"><i
						class="add user icon"></i>Assign Vechicle</a>
					<a class="ui button" href="<c:url value="/vehicle/customer/${tempCustomer.id}/list"></c:url>"><i
						class="list icon"></i>List Vehicles</a>	 --%>
			</tr>
		</c:forEach>
	</table>
	
		<a class="ui button" href="${pageContext.request.contextPath}/customer/showAddForm" class="item"><i
						class="add circle icon"></i>Add Customer</a>
</div>

<script type="text/javascript">
	$("[name='deleteCustomer']").click(
			function() {
				var urlCall = "<c:url value="/api/customer/delete/"></c:url>";
				$.ajax({
					url : urlCall + $(this).attr('id'),
					type : 'DELETE',
					success : function(result) {
						console.log(result);
						$(location).attr("href",
								"<c:url value="/customer/list"></c:url>");
					},
					error : function(result) {
						console.log(result);
					},
				});
			});
</script>