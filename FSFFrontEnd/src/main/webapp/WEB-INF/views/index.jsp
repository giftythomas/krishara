<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>D C FootWear</title>
<%@include file="header.jsp"%>

<div id="myCarousel" class="carousel slide" data-ride="carousel">

	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>


	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img src=<c:url value="/resources/images/banner1.jpg" />
				alt="New York">
		</div>

		<div class="item">
			<img src=<c:url value="/resources/images/banner2.jpg" />
				alt="Chicago">
		</div>

		<div class="item">
			<img src=<c:url value="/resources/images/women.jpg" />
				alt="Los Angeles">
		</div>

	</div>


	<a class="left carousel-control" href="#myCarousel" role="button"
		data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
		aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" role="button"
		data-slide="next"> <span class="glyphicon glyphicon-chevron-right"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
</div>

<div class="container text-center">
	<h3>F R E E &nbsp;S T Y L E</h3>
	<em>We love style!</em>
	<p>
		DC quickly grew to become a leader in performance skateboarding shoes
		and a renowned action sports brand.<br> Today DC stands as a
		global brand whose product line has expanded to include men’s,
		women’s and kids’ skateboarding and lifestyle shoes, apparel,
		snowboards, snowboard boots, outerwear, and accessories. As one of the
		cornerstones of its marketing strategy, DC has built a world-class
		team of professional skateboarding, snowboarding, and motocross
		athletes that exemplify and enhance DC’s brand, develop its
		signature products, and support its promotional efforts.
	</p>
</div>
<div class="container text-center">
	<div class="row">
		<div class="col-sm-4">

			<br> <img src=<c:url value="/resources/images/nike.jpg" />
				class="thumbnail person" alt="Random Name">
		</div>
		<div class="col-sm-4">

			<br> <img src=<c:url value="/resources/images/puma.jpg"/>
				class="thumbnail person" alt="Random Name">
		</div>
		<div class="col-sm-4">

			<br> <img src=<c:url value="/resources/images/adidas.jpg" />
				class="thumbnail person" alt="Random Name">
		</div>
	</div>
</div>
<center>
    <a href=product?name=all class="text-info">All Products</a>
</center>
<div id="contact" class="container">
	<h3 class="text-left">Contact</h3>
	<div class="row test">
		<div class="col-md-4">
			<p>
				<span class="glyphicon glyphicon-map-marker"></span>Hyderabad, India
			</p>
			<p>
				<span class="glyphicon glyphicon-phone"></span>Phone: +914066673789
			</p>
			<p>
				<span class="glyphicon glyphicon-envelope"></span>Email:
				mail@mail.com
			</p>
		</div>
		<h3>Feedback</h3>
		<div class="col-md-8">

			<div class="row">

				<div class="col-sm-6 form-group">
					<input class="form-control" id="name" name="name"
						placeholder="Name" type="text" required>
				</div>
				<div class="col-sm-6 form-group">
					<input class="form-control" id="email" name="email"
						placeholder="Email" type="email" required>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 form-group">
					<button class="btn btn-danger pull-right" type="submit">Send</button>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>