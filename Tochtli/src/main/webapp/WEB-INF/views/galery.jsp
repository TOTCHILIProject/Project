<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="Tochtli.Tochtli.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Tamales TOCHTLI - Galería</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />

<!-- Custom CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/business-casual.css" />

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
	<%@include file="menu.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Our <strong>Product Categories</strong>
					</h2>
					<hr>
				</div>
				
				<!-- forEach belongs to the jstl library !!! case sensitive !! -->
				<c:forEach var="category" items="${categories}">
					<div class="col-sm-4 text-center">
						<img class="img-responsive img-full" data-toggle="modal" data-target="#${category.name}" 
								src="${pageContext.request.contextPath}/resources/img/${category.photo_path}" alt="">
						<h2 class="intro-text text center">
							<a href="/Tochtli/galery/${category.id}"><strong>${category.name}</strong></a>
						</h2>
					</div>
					
					<!-- the details window -->
					<div class="modal fade bs-example-modal-lg" id="${category.name}" 
						tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
	  					<div class="modal-dialog modal-lg">
	    					<div class="modal-content">
	    						<h2 class="intro-text text-center">
									<strong>${category.name}</strong>
								<hr>
								<div class="row">
									<div class="col-lg-12 text-left">
										<p>${category.description}</p>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-1 text center"></div>
									<div class="col-sm-11 text-left">
										<h3 class="intro-text">Lista productos: </h3>
										<ul>
										<c:forEach var="product" items="${category.products}">
											<li>${product.name}</li>
										</c:forEach>
										</ul>
									</div>
								</div>
	    					</div>
	  					</div>
					</div>
				</c:forEach>
				<div class="clearfix"></div>
			</div>
		</div>

	</div>
	<!-- /.container -->

	<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<p>Copyright &copy; tamales TOCHTLI 2014</p>
			</div>
		</div>
	</div>
	</footer>

	<!-- jQuery Version 1.11.0 -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	

</body>

</html>
