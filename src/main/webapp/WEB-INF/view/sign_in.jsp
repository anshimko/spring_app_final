<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign in</title>

<style type="text/css">
body {
	background-color: #f5f8f8;
}

div {
	background-color: #dbe2e3;
	align: center;
	text-align: center;
	width: 30%;
	length: 2000px;
	border-left: 1px dotted red;
	border-right: 1px dotted red;
	margin-right: 30%;
	margin-left: 30%;
	padding-top: 20px;
	padding-right: 20px;
	padding-bottom: 20px;
	padding-left: 20px;
	text-align: center;
}

h2 {
	color: #400080;
	text-align: center
}

p {
	color: #400040;
	text-align: center
}

p.error {
	color: red;
}

table.login {
	border-collapse: collapse;
	margin: auto;
	width: 30%;
}

td {
    text-align: left;
}

</style>
</head>

<body>

	<div>

		<h2>Sign in</h2>

		<form:form action="${pageContext.request.contextPath}/authenticate"
			method="POST">




			<table class="login">

				<c:if test="${param.error != null}">
					<tr>
						<td colspan="2"><p class="error">Invalid username and password</p></td>
					</tr>
				</c:if>

				<c:if test="${param.logout != null}">
					<tr>
						<td colspan="2"><p class="error">You have been logged out</p></td>
					</tr>
				</c:if>

				<tr>
					<td><label>Login:</label></td>
					<td><input name="username" placeholder="login" type="text" /></td>
				</tr>

				<tr>
					<td><label>Password:</label></td>
					<td><input name="password" placeholder="password"
						type="password" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Sign in" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="button" value="Sign up"
						onclick="window.location.href='sign_up'; return false;"
						class="add-button" /></td>
				</tr>

			</table>

		</form:form>

	</div>
</body>
</html>