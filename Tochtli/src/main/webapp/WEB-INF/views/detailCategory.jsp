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

</head>

<body>
	<%@include file="menu.jsp" %>

	<div class="container">
		<div class="row">
			<div class="box">
			<c:choose>
			   <c:when test="${category==null}">
					<h2 class="intro-text text-center">
							Inexistent category
					</h2>   
			   </c:when> 
			   <c:otherwise>
			  		<div class="col-lg-12">
						<hr>
							<h2 class="intro-text text-center">
								<p>Our <strong>Products</strong> </p>
								Categoria<b> ${category.name} </b>
							</h2>
						<hr>
					</div>
					
					<c:if test="${message!=null}">
						${message}
					</c:if>
				
					<!-- forEach belongs to the jstl library !!! case sensitive !! -->
					<c:forEach var="product" items="${category.products}">
						<!--  TODO exclude inactive products -->
						<div class="col-sm-4 text-center">
							<img src="${pageContext.request.contextPath}/resources/img/${product.photo_path}" alt="" class="img-thumbnail img-circle"> 
							<h2 class="intro-text text center">
								<strong>${product.name}</strong>
							</h2>
							<table style="width:100%">
								<tr  style="font-weight:bold">
								    <td>Unit</td>
								    <td>Price</td>
								    <td>Stock</td>
								 </tr>
								 <tr>
								   <td>${product.units}</td>	
								   <td>${product.price}</td>
								   <td>${product.stock}</td>	
								 </tr>
								 <tr>
									 <form action="addToCart" method="post">
									 	<td>Quantity</td>
									 	<td><input type="number" name="quantity" value="1"></td>
									 	<td><input type="submit" name="Submit" value="Compra"></td>
								        <input type="hidden" name="id" value="${product.id}">
								        <input type="hidden" name="categId" value="${category.id}">
								      </form>
								 </tr>
							</table>
						</div>
					</c:forEach>
			   </c:otherwise>   
			</c:choose>
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
