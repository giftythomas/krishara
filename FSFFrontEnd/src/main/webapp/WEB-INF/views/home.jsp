<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="shortcut icon"
	href=<c:url value="/resources/images/gt_favicon.png"/>>
<link rel="stylesheet"
	href=<c:url value="/resources/css/normalize.css"/>>
<link rel="stylesheet" href=<c:url value="/resources/css/main.css"/>>
<link href=<c:url value="/resources/css/mdb.min.css"/> rel="stylesheet">
<link
	href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i'
	rel='stylesheet' type='text/css'>
<title>Freestyle Footwear</title>
<style>
html *
{
font-family: 'Product Sans', Arial, sans-serif ,FontAwesome!important;
}
</style>
</head>
<body>
	<div class="navbar navbar-inverse">
		<div class="container-fluid">
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
					<li><a href="#">Products</a></li>
					<li><a href="#">Deals</a></li>
					<li><a href="#">Stores</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right" data-role="page">
					<c:choose>
						<c:when test="${empty loggedInUser}">
							<li><a href="loginHere"><i class="fa fa-sign-in"></i>
									Login</a></li>
							<li><a href="registerHere"><i class="fa fa-user"></i>Register</a></li>
						</c:when>
						<c:when test="${not empty loggedInUser}">
							<li><a href="logout"><i class="fa fa-sign-out"></i>Logout</a></li>
						</c:when>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	<c:if test="${not empty loggedInUser}">
		<h3 class="text-primary">Welcome ${loggedInUser},</h3>
	</c:if>
	<c:if test="${loggedOut==true}">
		<h3 class="text-info">${logoutMessage}</h3>
	</c:if>
	<div id="loader-wrapper">
		<div id="loader"></div>
		<div class="loader-section section-left"></div>
		<div class="loader-section section-right"></div>
	</div>
	<div id="registerHere">
		<c:if test="${userClickedRegisterHere==true}">
			<%@ include file="/WEB-INF/views/register.jsp"%>
		</c:if>
	</div>
	<div id="loginHere">
		<c:if test="${userClickedLoginHere==true || invalidCredentials==true}">
			<div id="error">${errorMessage}</div>
			<%@ include file="/WEB-INF/views/login.jsp"%>
		</c:if>
	</div>
	<div id="admin">
		<c:if test="${isAdmin==true}">
			<%@ include file="/WEB-INF/views/adminHome.jsp"%>
		</c:if>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src=<c:url value="/resources/js/modernizr-2.6.2.min.js"/>></script>
	<script type="text/javascript"
		src=<c:url value="/resources/js/mdb.min.js"/>></script>
	<script src=<c:url value="/resources/js/main.js"/>></script>
</body>
</html>