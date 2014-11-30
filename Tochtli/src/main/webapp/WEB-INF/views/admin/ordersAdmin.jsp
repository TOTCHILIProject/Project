<%@page import="Tochtli.Tochtli.model.entity.Order"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<% List<Order> orders = (List<Order>)request.getAttribute("orders");%>

<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tamales TOCHTLI - Administrar</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    <!-- <link href="/resources/css/bootstrap.min.css" rel="stylesheet">  -->
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/business-casual.css" />
  
    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

</head>

<body>
	<%@include file="../menu.jsp" %>
        
    <div class="container">
    	<div class="row">
    		<div class="box">
	    		<h2 class="intro-text text-center">
					<strong>Pedidos</strong>
				</h2>
							
				<% if(orders == null || orders.size() == 0){ %>
					<h2 class="intro-text text-center">
						No orders
					</h2>
				<% }else { %>
					<table class="text-center" style="width:50%" align="center">
				      <tr style="font-weight:bold; text-align:left">
				        <td>Order ID</td>
				        <td>User</td>
				        <td>Date</td>
				        <td>Number of items</td>
				        <td>Total</td>
				      </tr>
					  <% for(Order order : orders){ %>
					  	<tr style="text-align:left">
					        <td><%=order.getId() %></td>
					        <td><%=order.getUser()%> $</td>
					        <td><%=order.getDate()%></td>
					        <td><%=order.getOrderedProducts().size()%></td>
					        <td><%=order.getTotal()%></td>
				      	</tr>
					  <% } %>
					</table>
				<% } %>
    		</div>
    	</div>
	</div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Tamales TOCHTLI 2014</p>
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