<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Hospital</title>
	
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>
	<script type="text/javascript">
		// cambio la URL:
		var str = window.location.href;
		var separado = str.split('?');
		if(separado.length > 1){
			var result = str.replace(str.split('EmpleadoControllerServlet').pop(),'');
			location.replace(result);
		}
	</script>

	<div id="wrapper" class="mt-4 row">
		<img src="img/logo.png" alt="logo" width="10px" class="col-sm-2">
		<div class="col-sm-10 mt-4">
			<h1 class="font-weight-bold">Hospital central</h1>
		</div>
	</div>
	
	<div id="boton-agregar" class="mt-4">
		<!-- put new button: Add Student -->
		<input type="button" value="Agregar empleado" 
			onclick="window.location.href='add-empleados-form.html'; return false;"
			class="add-empleados-button btn btn-success"/>
	</div>

	<div id="container" class="text-center mt-4">
	
		<div id="content">
			
			<table class="table table-striped table-hover">
				
				<thead class="bg-primary text-white">
					<tr>
						<th>Nombre</th>
						<th>Apellido paterno</th>
						<th>Apellido materno</th>
						<th>Correo</th>
						<th>Acción</th>
					</tr>
				</thead>
				
				<c:forEach var="tempEmpleados" items="${LISTA_EMPLEADOS}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="EmpleadoControllerServlet">
						<c:param name="command" value="LOAD"/>
						<c:param name="empleadoId" value="${tempEmpleados.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="EmpleadoControllerServlet">
						<c:param name="command" value="DELETE"/>
						<c:param name="empleadoId" value="${tempEmpleados.id}" />
					</c:url>
							
				<tbody>											
					<tr>
						<td> ${tempEmpleados.nombre} </td>
						<td> ${tempEmpleados.ap} </td>
						<td> ${tempEmpleados.am} </td>
						<td> ${tempEmpleados.correo} </td>
						<td> 
							<div class="btn-group">
								<a href="${tempLink}" class="btn btn-warning">Update</a> 
								<a href="${deleteLink}" class="btn btn-danger"
								onclick="if (!(confirm('Esta seguro que desea eliminar a este empleado?'))) return false">
								Delete</a>	
							</div>
						</td>
					</tr>
				</tbody>
				
				</c:forEach>
				
			</table>
		
		</div>
			
	</div>
</body>


</html>








