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

    <div class="brand">Tamales TOCHTLI           
    	<img src="${pageContext.request.contextPath}/resources/img/tch.jpg" alt="aaa.jpg" class="img-rounded">
    </div>
    <div class="address-bar">5 de Mayo Norte 1027 | Barrio Analco | Coronango Puebla</div>

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="index.html">TOCHTLI</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/Tochtli">Inicio</a></li>
					<li><a href="history">Historia</a></li>
					<li><a href="galery">Galería</a></li>
					<li><a href="contact">Contact</a></li>
					<li><a href="admin">Administrar</a></li>

					<li><br><button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#login">Iniciar Sesión</button></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <div class="modal fade bs-example-modal-sm" id="login" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  		<div class="modal-dialog modal-sm">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        			<h4 class="modal-title" id="exampleModalLabel">Introduce tus datos</h4>
      			</div>
     			<div class="modal-body">
        			<form role="form">
  						<div class="form-group">
   							<label for="user-name">Usuario</label>
    						<input type="text" class="form-control" id="user-name" placeholder="Nombre de usuario">
  						</div>
  						<div class="form-group">
    						<label for="pass-word">Password</label>
    						<input type="password" class="form-control" id="pass-word" placeholder="Contraseña">
  						</div>
  						<button type="submit" class="btn btn-default">Submit</button>
					</form>
      			</div>
    		</div>
    	</div>
  	</div>
    
        
    <div class="container">
    	<div class="row">
    		<div class="box">
    			<div role="tabpanel">
  					<!-- Nav tabs -->
  					<ul class="nav nav-tabs nav-justified" role="tablist">
    					<li role="presentation" class="active"><a href="#products" aria-controls="products" role="tab" data-toggle="tab">Productos</a></li>
    					<li role="presentation"><a href="#family" aria-controls="family" role="tab" data-toggle="tab">Categorías</a></li>
    					<li role="presentation"><a href="#reports" aria-controls="reports" role="tab" data-toggle="tab">Reportes</a></li>
    					<li role="presentation"><a href="#clients" aria-controls="clients" role="tab" data-toggle="tab">Clientes</a></li>
  					</ul>
  					<!-- Tab panes -->
  					<div class="tab-content">
    					<div role="tabpanel" class="tab-pane fade active" id="products">
    						<h2 class="intro-text text-center"><strong>Productos:</strong></h2>
    						<h4 class="intro-text">Here we show all the products</h4>
    						<button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#edit">Edit</button>
    					</div>
    					<div role="tabpanel" class="tab-pane fade" id="family">
    						<h2 class="intro-text text-center"><strong>Categorías:</strong></h2>
    						<h4 class="intro-text">Here we show all the families</h4>
    						<button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#edit">Edit</button>
    					</div>
    					<div role="tabpanel" class="tab-pane fade" id="reports">
    						<h2 class="intro-text text-center"><strong>Reportes:</strong></h2>
    					    <h4 class="intro-text">Here we show all the reports</h4>
    					    <!--button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#edit">Edit</button-->
    					</div>
    					<div role="tabpanel" class="tab-pane fade" id="clients">
    						<h2 class="intro-text text-center"><strong>Clientes:</strong></h2>
    					    <h4 class="intro-text">Here we show all the clients</h4>
    					    <button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#edit">Edit</button>
    					</div>
  					</div>

				</div>
    		</div>
    	</div>
	</div>

	<div class="modal fade bs-example-modal-sm" id="edit" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  		<div class="modal-dialog modal-sm">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        			<h4 class="modal-title" id="exampleModalLabel">Editar:</h4>
      			</div>
     			<div class="modal-body">
        			<form role="form">
  						<div class="form-group">
   							<label for="name">Name:</label>
    						<input type="text" class="form-control" id="user-name" placeholder="Name">
  						</div>
  						<div class="form-group">
   							<label for="id">ID:</label>
    						<input type="text" class="form-control" id="user-name" placeholder="ID">
  						</div>
  						<div class="form-group">
   							<label for="other">Other:</label>
    						<input type="text" class="form-control" id="user-name" placeholder="Other">
  						</div>
  						<button type="submit" class="btn btn-default">Submit</button>
					</form>
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