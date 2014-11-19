<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Tamales TOCHTLI - Compras</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/business-casual.css"
	rel="stylesheet">

<!-- Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="brand">
		Tamales TOCHTLI <img class="img-rounded"
			src="${pageContext.request.contextPath}/resources/img/tch.jpg" alt="">
	</div>
	<div class="address-bar">5 de Mayo Norte 1027 | Barrio Analco |
		Coronango Puebla</div>

	<!-- Navigation -->
	<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
			<a class="navbar-brand" href="index.html">TOCHTLI</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/Tochtli">Inicio</a></li>
				<li><a href="history">Historia</a></li>
				<li><a href="galery">Galería</a></li>
				<li><a href="login.html"><button type="button"
							class="btn btn-default btn-lg">Iniciar Sesión</button></a></li>
				<!--li>
                        <a href="compra.html">Compra</a>
                    </li-->
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<div class="container">

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Contact <strong>business casual</strong>
					</h2>
					<hr>
				</div>
				<div class="col-md-8">
					<!-- Embedded Google Map using an iframe - to select your location find it on Google maps and paste the link as the iframe src. If you want to use the Google Maps API instead then have at it! -->
					<iframe width="100%" height="400" frameborder="0" scrolling="no"
						marginheight="0" marginwidth="0"
						src="http://maps.google.com/maps?hl=en&amp;ie=UTF8&amp;ll=37.0625,-95.677068&amp;spn=56.506174,79.013672&amp;t=m&amp;z=4&amp;output=embed"></iframe>
				</div>
				<div class="col-md-4">
					<p>
						Phone: <strong>123.456.7890</strong>
					</p>
					<p>
						Email: <strong><a href="mailto:name@example.com">name@example.com</a></strong>
					</p>
					<p>
						Address: <strong>3481 Melrose Place <br>Beverly
							Hills, CA 90210
						</strong>
					</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Contact <strong>form</strong>
					</h2>
					<hr>
					<p>Contacts us!</p>
					<form:form method="post" action="contactTochtli">
						<div class="row">
							<div class="form-group col-lg-4">
								<form:label path="name">Name</form:label>
								<form:input path="name" class="form-control" />
							</div>
							<div class="form-group col-lg-4">
								<form:label path="email">Email Address</form:label>
								<form:input path="email" class="form-control" type="email" />
							</div>
							<div class="form-group col-lg-4">
								<form:label path="phone">Phone number</form:label>
								<form:input path="phone" class="form-control" type="tel" />
							</div>
							<div class="clearfix"></div>
							<div class="form-group col-lg-12">
								<form:label path="message">Message</form:label>
								<form:input path="message" class="form-control" rows="6" />
							</div>
							<div class="form-group col-lg-12">
								<input type="hidden" name="save" value="contact"> <input
									type="submit" class="btn btn-default" value="Submit" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container -->

	<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<p>Copyright &copy; Your Website 2014</p>
			</div>
		</div>
	</div>
	</footer>

	<!-- jQuery Version 1.11.0 -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

</body>

</html>
