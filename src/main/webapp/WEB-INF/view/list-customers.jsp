<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>List of users</title>

<style type="text/css">

body {
	background-color: #f5f8f8;
}

div {
	background-color: #dbe2e3;
	width: 70%;
	length: 2000px;
	border-left: 1px dotted red;
	border-right: 1px dotted red;
	margin-right: 15%;
	margin-left: 15%;
	padding-top: 20px;
	padding-right: 20px;
	padding-bottom: 20px;
	padding-left: 20px;
}

h2 {
	color: #400080;
	text-align: center
}

p {
	color: #400040;
	text-align: center
}


table.list_customers {
	border-collapse: collapse;
	width: 100%;
}

table.list_customers th, td {
	padding: 8px;
	text-align: left;
}

table.list_customers tr:nth-child(even) {
	background-color: #a8a8a8;
	}

table.pagination {
	border-collapse: collapse;
	margin: auto;
}

</style>
</head>

<body>

	<div >
		
			<h2>List of users</h2>
	
			<input type="button" value="Add User"
				onclick="window.location.href='${pageContext.request.contextPath}/customer/showFormForAdd'; return false;"
				class="add-button" />
				
			<hr>

			<table class="list_customers">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<c:forEach var="tempCustomer" items="${customers}">

					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>

						<td>
							<a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		
		
		<hr>
		
		<table class="pagination">
			<tr>
				<c:if test="${page != 1}">
						<td><a href="${pageContext.request.contextPath}/customer/list/${page - 1}">Prev</a></td>
				</c:if>
				
				<c:forEach var = "i" begin = "1" end = "${countPages}">
					<c:choose>
					
						<c:when test="${page eq i}">
							<td>${i}</td>
						</c:when>
						
						<c:otherwise>
							<td><a href="${pageContext.request.contextPath}/customer/list/${i}">${i}</a></td>
						</c:otherwise>
						
					</c:choose>
				</c:forEach>
				
				<c:if test="${page lt countPages}">
						<td><a href="${pageContext.request.contextPath}/customer/list/${page + 1}">Next</a></td>
				</c:if>
			</tr>
		</table>
		
	
	
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
		<input type="submit" value="Logout" />
		
	</form:form>
	
	</div>
	
</body>
</html>









