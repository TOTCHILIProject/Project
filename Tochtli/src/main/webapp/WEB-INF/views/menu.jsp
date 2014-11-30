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
				<li><a href="/Tochtli/history">Historia</a></li>
				<li><a href="/Tochtli/galery">Galería</a></li>
				<li><a href="/Tochtli/contact">Contact</a></li>
				<li><a role="button" data-toggle="dropdown" data-target="#">Administrar
					<span class="caret"></span></a>
		    		<ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
		              <li><a href="/Tochtli/admin/products">Productos</a></li>
		              <li><a href="#">Categorías</a></li>
		              <li><a href="/Tochtli/admin/orders">Pedidos</a></li>
		              <li><a href="#">Reportes</a></li>
		              <li><a href="#">Clientes</a></li>
		            </ul>
				</li>
				<li><a role="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#login">Iniciar Sesión</a></li>
				<li><a href="/Tochtli/shoppingCart"><img src="${pageContext.request.contextPath}/resources/img/cartImg.jpg" alt="" width="30"></a></li>
           </ul>
       </div>
       <!-- /.navbar-collapse -->
   </div>
   <!-- /.container -->
</nav>

<!-- LOGIN form -->
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
