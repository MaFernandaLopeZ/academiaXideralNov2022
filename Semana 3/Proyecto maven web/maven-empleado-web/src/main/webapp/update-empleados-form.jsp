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
	<div id="wrapper" class="mt-4 row">
		<img src="img/logo.png" alt="logo" width="10px" class="col-sm-2">
		<div class="col-sm-10 mt-4">
			<h1 class="font-weight-bold">Hospital central</h1>
		</div>
	</div>
	
	<div id="container">
		<h4 class="text-primary font-weight-bold mt-4">Modificar empleado</h4>
		
		<form action="EmpleadoControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name=empleadoId value="${THE_EMPLEADO.id}" />
			
			<div class="row g-3 mt-1 align-items-center">
			  <div class="col-sm-2">
			    <label class="col-form-label">Nombre:</label>
			  </div>
			  <div class="col-sm-5">
			    <input type="text" name="nombre" value="${THE_EMPLEADO.nombre}" class="form-control">
			  </div>
			</div>
			
			<div class="row g-3 mt-1 align-items-center">
			  <div class="col-sm-2">
			    <label class="col-form-label">Apellido paterno:</label>
			  </div>
			  <div class="col-sm-5">
			    <input type="text" name="ap" value="${THE_EMPLEADO.ap}" class="form-control">
			  </div>
			</div>
			
			<div class="row g-3 mt-1 align-items-center">
			  <div class="col-sm-2">
			    <label class="col-form-label">Apellido materno:</label>
			  </div>
			  <div class="col-sm-5">
			    <input type="text" name="am" value="${THE_EMPLEADO.am}" class="form-control">
			  </div>
			</div>
			
			<div class="row g-3 mt-1 align-items-center">
			  <div class="col-sm-2">
			    <label class="col-form-label">Correo:</label>
			  </div>
			  <div class="col-sm-5">
			    <input type="text" name="correo" value="${THE_EMPLEADO.correo}" class="form-control">
			  </div>
			</div>
			
			<input type="submit" value="Save" class="save mt-3 mb-3 btn btn-primary" />
			
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="EmpleadoControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











