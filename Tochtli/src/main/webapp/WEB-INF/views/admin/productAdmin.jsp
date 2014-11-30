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
				<strong>Productos</strong>
			</h2>
			<c:forEach var="product" items="${products}">
				<div class="col-sm-2 text-center">
					<img src="${pageContext.request.contextPath}/resources/img/${product.photo_path}" alt="" height="50" width="50">
					<h2 class="intro-text text center">
						<a href="/Tochtli/admin/productAdmin/${product.id}"><strong>${product.name}</strong></a>
					</h2>
					<button type="button" class="btn btn-default" aria-label="Left Align">
		  				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					</button>
				</div>
			</c:forEach>
			
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