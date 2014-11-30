<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tamales TOCHTLI - Inicio</title>

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
	<%@include file="menu.jsp" %>
        
    <div class="container">
    	<div class="row">
    		<div class="box">
    			<div role="tabpanel">
  					<!-- Nav tabs -->
  					<ul class="nav nav-tabs nav-justified" role="tablist">
    					<li role="tab" class="active"><a href="#products" aria-controls="products" role="tab" data-toggle="tab">Productos</a></li>
    					<li role="tab"><a href="#family" aria-controls="family" role="tab" data-toggle="tab">Categorías</a></li>
    					<li role="tab"><a href="#orders" aria-controls="orders" role="tab" data-toggle="tab">Orders</a></li>
    					<li role="tab"><a href="#reports" aria-controls="reports" role="tab" data-toggle="tab">Reportes</a></li>
    					<li role="tab"><a href="#clients" aria-controls="clients" role="tab" data-toggle="tab">Clientes</a></li>
  					</ul>
  					<!-- Tab panes -->
  					<div class="tab-content">
    					<div role="tabpanel" class="tab-pane fade active" id="products">
	    					<%@include file="admin/productAdmin.jsp" %>
    					</div>
    					<div role="tabpanel" class="tab-pane fade" id="family">
							<%@include file="admin/categoryAdmin.jsp" %>
    					</div>
    					<div role="tabpanel" class="tab-pane fade" id="orders">
							<%@include file="admin/ordersAdmin.jsp" %>
    					</div>
    					<div role="tabpanel" class="tab-pane fade" id="reports">
							<%@include file="admin/reportsAdmin.jsp" %>
    					</div>
    					<div role="tabpanel" class="tab-pane fade" id="clients">
							<%@include file="admin/clientAdmin.jsp" %>
    					</div>
  					</div>
				</div>
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
    

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>