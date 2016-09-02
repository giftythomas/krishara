<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>N-Air a E-commerce category Flat Bootstrap Responsive
	Website Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="N-Air Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() {setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<meta charset utf="8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<script src="https://use.fontawesome.com/bb7d595c3f.js"></script>
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Fredoka+One'
	rel='stylesheet' type='text/css'>

<!--fonts-->
<!--bootstrap-->

<!--custom css-->
<link href=<c:url value="/resources/css/style.css"/> rel="stylesheet"
	type="text/css" />
<!--shop-kart-js-->
<script src=<c:url value="/resources/js/simpleCart.min.js"/>></script>
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">


</head>
<body>
	<div class="header">
		<div class="container">
			<div class="header-top">
				<div class="logo">
					<a href="index">N-AIR</a>
				</div>
				<div class="login-bars">
				<c:choose>
						<c:when test="${empty loggedInUser}">
					<a class="btn btn-default log-bar" href="register"
						role="button">Sign up</a> <a class="btn btn-default log-bar"
						href="User" role="button">Login</a>
						</c:when>
						<c:when test="${not empty loggedInUser}">
						<a class="btn btn-default log-bar" href="logout" role="button">Logout</a>
						</c:when>
						</c:choose>
					
				</div>
				<div class="clearfix"></div>
			</div>
			<!---menu-----bar--->
			<div class="header-botom">
				<div class="content white">
					<nav class="navbar navbar-default nav-menu" role="navigation">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<div class="clearfix"></div>
						<!--/.navbar-header-->

						<div class="collapse navbar-collapse collapse-pdng"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav nav-font">
								<li class="dropdown"><a href="index">Home</a></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">Products<b class="caret"></b></a>
									<ul class="dropdown-menu multi-column columns-3">
										<div class="row">
											<div class="col-sm-4 menu-img-pad">
												<ul class="multi-column-dropdown">
													<li><a href="goToCategory?category=Nike">Nike</a></li>
													<li><a href="goToCategory?category=Puma">Puma</a></li>
													<li><a href="goToCategory?category=Adidas">Adidas</a></li>
												</ul>
											</div>
											<div class="col-sm-4 menu-img-pad">
												<a href="#"><img src=<c:url value="resources/images/menu1.jpg"/> alt="/"
													class="img-rsponsive men-img-wid" /></a>
											</div>
											<div class="col-sm-4 menu-img-pad">
												<a href="#"><img src=<c:url value="resources/images/menu2.jpg"/> alt="/"
													class="img-rsponsive men-img-wid" /></a>
											</div>
										</div>
									</ul></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">Women<b class="caret"></b></a>
									<ul class="dropdown-menu multi-column columns-2">
										<div class="row">
											<div class="col-sm-6">
												<ul class="multi-column-dropdown">
													<li><a href="products.html">Tops</a></li>
													<li><a href="products.html">Bottoms</a></li>
													<li><a href="products.html">Yoga Pants</a></li>
													<li class="divider"></li>
													<li><a href="products.html">Sports</a></li>
													<li class="divider"></li>
													<li><a href="products.html">Gym</a></li>
												</ul>
											</div>
											<div class="col-sm-6">
												<a href="#"><img src=<c:url value="resources/images/menu3.jpg"/> alt="/"
													class="img-responsive men-img-wid" /></a>
											</div>
										</div>
									</ul></li>
								<li><a href="contact.html">Catch</a></li>
								<div class="clearfix"></div>
							</ul>
							<div class="clearfix"></div>
						</div>
						<!--/.navbar-collapse-->
						<div class="clearfix"></div>
					</nav>
					<!--/.navbar-->
					<div class="clearfix"></div>
				</div>
				<!--/.content--->
			</div>
			<!--header-bottom-->
		</div>
	</div>