<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		<h4 class="text-primary text-center font-weight-bold mt-4 mb-4">Ventas</h4>
	
		<table class="table table-striped table-hover text-center">
				
				<thead class="bg-7E3E98 text-white">
					<tr>
						<th>Fecha</th>
						<th>Cantidad</th>
						<th>Total</th>
					</tr>
				</thead>
				
				<c:forEach var="tempVenta" items="${ventas}">
				
					<tbody>
						<tr>
							<td> ${tempVenta.fecha} </td>
							<td> ${tempVenta.cantidad} </td>
							<td> ${tempVenta.total} </td>
						
						</tr>
					</tbody>
				</c:forEach>
				
			</table>
	
	</div>
	
	<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/libro/list">Back to List</a>
		</p>
	
	

</body>

</html>










