<%@page import="Tochtli.Tochtli.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2 class="intro-text text-center">
	<strong>Productos:</strong>
</h2>
<h4 class="intro-text">Here we show all the products</h4>

	<c:forEach var="product" items="${products}">
		<div class="col-sm-4 text-center">
			<img class="img-responsive img-full" data-toggle="modal" data-target="#${product.name}" 
				src="${pageContext.request.contextPath}/resources/img/${product.photo_path}" alt="">
			<h2 class="intro-text text center">
				<a href="/Tochtli/admin/productAdmin/${product.id}"><strong>${product.name}</strong></a>
			</h2>
			<button type="button" class="btn btn-default" aria-label="Left Align">
  				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
			</button>
		</div>
	</c:forEach>


	<div class="modal fade bs-example-modal-sm" id="edit" tabindex="-1"
		role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">Editar:</h4>
				</div>
				<div class="modal-body">
					<form role="form">
						<div class="form-group">
							<label for="name">Name:</label> <input type="text"
								class="form-control" id="user-name" placeholder="Name">
						</div>
						<div class="form-group">
							<label for="id">ID:</label> <input type="text"
								class="form-control" id="user-name" placeholder="ID">
						</div>
						<div class="form-group">
							<label for="other">Other:</label> <input type="text"
								class="form-control" id="user-name" placeholder="Other">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>

