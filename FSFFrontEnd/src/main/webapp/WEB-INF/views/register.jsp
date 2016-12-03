<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>

	<h2>Please fill the details</h2>

	<form:form action="user/register" method="post" commandName="user">
		<table>
			<tr>
				<td><form:label path="username">
						<spring:message text="User Name" />
					</form:label></td>

				<td><form:input path="username" required="true"
						title="name should not be empty" /></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message text="Password" />
					</form:label></td>

				<td><form:password path="password" pattern=".{4,15}"
						required="true"
						title="password should contains 4 to 15 characters" /></td>
			</tr>

			<tr>
				<td><form:label path="email">
						<spring:message text="Email" />
					</form:label></td>

				<td><form:input type="email" path="email" /></td>
			</tr>

			<tr>
				<td><form:label path="address">
						<spring:message text="Address" />
					</form:label></td>

				<td><form:input path="address" required="true" /></td>
			</tr>

			<tr>

				<td><input type="submit" class="btn btn-info"
					value="<spring:message text="Register"/>" /></td>
				<td><input class="btn btn-danger" type="reset" value="<spring:message text="Reset"/>" />
				</td>
			</tr>

		</table>

	</form:form>

</body>
</html>