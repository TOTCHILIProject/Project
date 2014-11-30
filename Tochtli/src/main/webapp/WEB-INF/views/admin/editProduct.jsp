<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="Tochtli.Tochtli.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


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
    			
    			<form:form method="post" action="/Tochtli/admin/products/persistProduct">
					<div class="row">
					<!-- TODO categories -->
						<div class="form-group col-lg-4">
							<form:label path="name">Name</form:label>
							<form:input path="name" class="form-control" />
						</div>
						<div class="clearfix"></div>
						<div class="form-group col-lg-4">
							<form:label path="units">Units</form:label>
							<form:input path="units" class="form-control" />
						</div>
						<div class="form-group col-lg-4">
							<form:label path="price">Price</form:label>
							<form:input path="price" class="form-control" type="number" />
						</div>
						<div class="form-group col-lg-12">
							<form:label path="photo_path">Path Photo</form:label>
							<form:input path="photo_path" class="form-control" rows="6" />
						</div><div>
						<div class="form-group col-lg-12">
							<input type="hidden" name="save" value="product"> <input
								type="submit" class="btn btn-default" value="Save" />
						</div>
					</div>
				</form:form>
		
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