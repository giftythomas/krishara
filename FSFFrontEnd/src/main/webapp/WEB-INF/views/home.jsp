<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<link rel="shortcut icon"
	href=<c:url value="resources/images/gt_favicon.png"/>>

<title>Freestyle Footwear</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid" data-role="page">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Logo</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Brands</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${empty loggedInUser}">
						<li><a href="loginHere"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
						<li><a href="registerHere"><span
								class="glyphicon glyphicon-user"></span> Register</a></li>
					</c:when>
					<c:when test="${not empty loggedInUser}">
						Welcome ${loggedInUser},
				<li><a href="logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</c:when>
				</c:choose>
			</ul>
			
			<c:if test="${loggedOut==true}">
				<td>${logoutMessage}</td>
			</c:if>
		</div>
	</div>
	</nav>
	<div id="registerHere">
		<c:if test="${userClickedRegisterHere==true}">
			<%@ include file="/WEB-INF/views/register.jsp"%>

		</c:if>
	</div>

	<div id="loginHere">
		<c:if
			test="${userClickedLoginHere==true || invalidCredentials==true}">
			<div id="error">${errorMessage}</div>
			<%@ include file="/WEB-INF/views/login.jsp"%>

		</c:if>
	</div>

	<div id="admin">

		<c:if test="${isAdmin==true}">

			<%@ include file="/WEB-INF/views/adminHome.jsp"%>

		</c:if>
	</div>

</body>
</html>