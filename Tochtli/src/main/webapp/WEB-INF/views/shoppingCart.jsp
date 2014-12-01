<%@page import="Tochtli.Tochtli.model.entity.OrderedProduct"%>
<%@page import="Tochtli.Tochtli.model.entity.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="Tochtli.Tochtli.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page import="java.util.List" %>
<% Order order = (Order)request.getAttribute("order");
   List<OrderedProduct> ordProds = order.getOrderedProducts();
   String msg =  (String)request.getAttribute("message");
%>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Tamales TOCHTLI - Shopping Cart</title>

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
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Your <strong>Shopping Cart</strong>
					</h2>
					<hr>
				</div>
				<% if(msg != null) {%>
					<h2 class="intro-text text-center">
						<strong><%=msg %></strong>
					</h2>
				<%} %>
				
				<!-- between <%%> you can write java code -->
				<% if(ordProds == null || ordProds.size() == 0){ %>
					<h2 class="intro-text text-center">
						Your Shopping Cart is empty
					</h2>
				<% }else { %>
					<table class="text-center" style="width:50%" align="center">
				      <tr style="font-weight:bold; text-align:left">
				        <td>Product Name</td>
				        <td>Price per Unit</td>
				        <td>Quantity</td>
				        <td>Actions</td>
				      </tr>
					  <% for(OrderedProduct op : ordProds){ %>
					  	<tr style="text-align:left">
					        <td><%=op.getProduct().getName() %></td>
					        <td><%=op.getProduct().getPrice() %> $</td>
					        <td><%=op.getQuantity() %></td>
			      			<td>
								 <form action="removeFromCart" method="post">
								 	<input type="submit" name="Submit" value="Remove">
							        <input type="hidden" name="id" value=<%=op.getProduct().getId() %>>
							      </form>
							 </td>
				      	</tr>
					  <% } %>
					</table>
					<h2 class="intro-text text-center">
						Total : <strong><%=order.getTotal() %> $</strong>
					</h2>
					<p>Place your order</p>
					<form:form method="post" action="placeOrder">
						<div class="row">
							<div class="form-group col-lg-4">
								<form:label path="firstName">First Name</form:label>
								<form:input path="firstName" class="form-control" />
							</div>
							<div class="form-group col-lg-4">
								<form:label path="lastName">Last Name</form:label>
								<form:input path="lastName" class="form-control" />
							</div>
							<div class="clearfix"></div>
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
								<input type="hidden" name="save" value="user">
								<input type="submit" class="btn btn-default" value="Place order" />
							</div>
						</div>
					</form:form>
				<% } %>
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
