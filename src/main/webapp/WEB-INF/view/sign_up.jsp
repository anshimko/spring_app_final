<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Save Customer</title>

<style type="text/css">
body {
	background-color: #f5f8f8;
}

div {
	background-color: #dbe2e3;
	align: center;
	text-align:center;
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

table {
	border-collapse: collapse;
	margin: auto;
	width: 40%;
}

td {
    text-align: left;
}

.error {
	color: red;
}
</style>

</head>
<body>

	<div>

		<h2>User Relationship Manager</h2>

		<h3>Save User</h3>

		<form:form action="sign_up" modelAttribute="customer" method="POST">

			<form:hidden path="id" />

			<table>
				<tbody>

					<tr>
						<td><label>Login:</label></td>
						<td><form:input path="login" /> <form:errors path="login"
								cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Password:</label></td>
						<td><form:input type="password" name="password"
								path="password" /> <form:errors path="password"
								cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /> <form:errors
								path="firstName" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /> <form:errors
								path="lastName" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input type="email" path="email" /> <form:errors
								path="email" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Age:</label></td>
						<td><form:input path="age" /> <form:errors path="age"
								cssClass="error" /></td>
					</tr>

					<tr>
						<td>Sex</td>
						<td><form:radiobutton path="sex" value="M" />Male <form:radiobutton
								path="sex" value="F" />Female <form:errors path="sex"
								cssClass="error" /></td>
					</tr>

					<tr>
						<td>Married</td>
						<td><form:checkbox path="married" /> <form:errors
								path="married" /></td>
					</tr>

					<tr>
						<td colspan="2"><form:textarea
								placeholder="Tell me about yourself" path="aboutMe" rows="3"
								cols="33" /></td>
					</tr>

					<tr></tr>

					<tr>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>

		</form:form>
	</div>
</body>
</html>