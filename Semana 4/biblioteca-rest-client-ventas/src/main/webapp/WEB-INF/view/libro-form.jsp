<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Biblioteca central</title>

<!-- 	<link type="text/css" -->
<!-- 		  rel="stylesheet" -->
<%-- 		  href="${pageContext.request.contextPath}/resources/css/style.css"> --%>

<!-- 	<link type="text/css" -->
<!-- 		  rel="stylesheet" -->
<%-- 		  href="${pageContext.request.contextPath}/resources/css/add-libro-style.css"> --%>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
	
	<div id="wrapper" class="mt-4 row">
		<img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="logo" class="col-sm-4">
		<div class="col-sm-8 mt-4">
			<h1 class="font-weight-bold">Biblioteca central</h1>
		</div>
	</div>
	
	<div class="container_form">
		<h4 class="text-primary text-center font-weight-bold mt-4">Guardar libro</h4>
	
		<form:form action="saveLibro" modelAttribute="libro" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
			
			<div class="row g-3 mt-1 align-items-center">
			  <div class="col-sm-5">
			    <label class="col-form-label">Nombre:</label>
			  </div>
			  <div class="col-sm-7">
			    <form:input path="nombre" class="form-control" />
			  </div>
			</div>
			
			<div class="row g-3 mt-1 align-items-center">
			  <div class="col-sm-5">
			    <label class="col-form-label">Genero:</label>
			  </div>
			  <div class="col-sm-7">
			    <form:input path="genero" class="form-control" />
			  </div>
			</div>
			
			<div class="row g-3 mt-1 align-items-center">
			  <div class="col-sm-5">
			    <label class="col-form-label">Autor</label>
			  </div>
			  <div class="col-sm-7">
			    <form:input path="autor" class="form-control" />
			  </div>
			</div>
			
			<div class="row g-3 mt-1 align-items-center">
			  <div class="col-sm-5">
			    <label class="col-form-label">Precio</label>
			  </div>
			  <div class="col-sm-7">
			    <form:input path="precio" class="form-control" />
			  </div>
			</div>
			
				<input type="submit" value="Save" class="save mt-3 mb-3 btn btn-primary"/>
			</div>
					
<!-- 			<table> -->
<!-- 				<tbody> -->
<!-- 					<tr> -->
<!-- 						<td><label>Nombre:</label></td> -->
<%-- 						<td><form:input path="nombre" /></td> --%>
<!-- 					</tr> -->
				
<!-- 					<tr> -->
<!-- 						<td><label>Genero:</label></td> -->
<%-- 						<td><form:input path="genero" /></td> --%>
<!-- 					</tr> -->

<!-- 					<tr> -->
<!-- 						<td><label>Autor:</label></td> -->
<%-- 						<td><form:input path="autor" /></td> --%>
<!-- 					</tr> -->
					
<!-- 					<tr> -->
<!-- 						<td><label>Precio:</label></td> -->
<%-- 						<td><form:input path="precio" /></td> --%>
<!-- 					</tr> -->

<!-- 					<tr> -->
<!-- 						<td><label></label></td> -->
<!-- 						<td><input type="submit" value="Save" class="save" /></td> -->
<!-- 					</tr> -->

				
<!-- 				</tbody> -->
<!-- 			</table> -->
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/libro/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










