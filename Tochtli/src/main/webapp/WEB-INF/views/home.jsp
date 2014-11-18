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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
					<li><a href="admin">Administrar</a></li>

					<li><br><button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#login">Iniciar Sesión</button></li>

                    <!--li>
                        <a href="compra.html">Compra</a>
                    </li-->
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
                <div class="col-lg-12 text-center">
                    <div id="carousel-example-generic" class="carousel slide">
                        <!-- Indicators -->
                        <ol class="carousel-indicators hidden-xs">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="img-responsive img-full" src="${pageContext.request.contextPath}/resources/img/tamales/t1.JPG" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="${pageContext.request.contextPath}/resources/img/employees/emp1.JPG" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="${pageContext.request.contextPath}/resources/img/mole/mole1.JPG" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="${pageContext.request.contextPath}/resources/img/posters/pos1.jpg" alt="">
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="icon-prev"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="icon-next"></span>
                        </a>
                    </div>
                    <h2 class="brand-before">
                        <small>Bienvenidos a</small>
                    </h2>
                    <h1 class="brand-name">Tamales TOCHTLI</h1>
                    <hr class="tagline-divider">

                </div>
            </div>
        </div>

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Landing page with
                        <strong>some stuff</strong>
                    </h2>
                    <hr>
                    <img class="img-responsive img-border img-left" src="${pageContext.request.contextPath}/resources/img/..." alt="">
                    <hr class="visible-xs">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Another part with
                        <strong>more stuff</strong>
                    </h2>
                    <hr>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
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