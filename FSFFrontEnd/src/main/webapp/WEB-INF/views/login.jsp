<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Shopping cart</title>
<link rel="stylesheet" href=<c:url value="resources/css/main.css"/>>
<style>
.message {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
</style>
</head>
<body>
	<c:url var="action" value="/login"></c:url>
	<div class="view">
		<div class="container">
			<div id="loginbox" style="margin-top: 50px;"
				class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">Sign In</div>
					</div>
					<c:if test="${not empty message}">
						<div class="message">${message}</div>
					</c:if>
					<div style="padding-top: 30px" class="panel-body">
						<div style="display: none" id="login-alert"
							class="alert alert-danger col-sm-12"></div>
						<form:form id="loginform" class="form-horizontal" method="post"
							action="${action }">
							<div style="margin-bottom: 25px" class="md-form">
								<i class="fa fa-user fa-lg prefix"></i> <input id="login-username"
									type="text" class="form-control" name="username" value="">
								<label for="login-username">Username</label>
							</div>
							<div style="margin-bottom: 25px" class="md-form">
								<i class="fa fa-lock fa-lg prefix"></i> <input id="login-password"
									type="password" class="form-control" name="password"> <label
									for="login-password">Password</label>
							</div>
							<div style="margin-top: 10px" class="text-xs-center">
								<!-- Button -->
								<div class="col-sm-12 controls">
									<button id="btn-login" type="submit"
										class="btn btn-md btn-primary">Login</button>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12 control">
									<div
										style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
										Don't have an account! <a href="registerHere"> Sign Up
											Here </a>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>