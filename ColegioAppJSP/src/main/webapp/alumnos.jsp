<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/jsp/head.jsp" %>
</head>
<body onload="startTime()">

	<div class="container-fluid bg-success-subtle">

		<%@ include file="/jsp/menu.jsp" %>

		<h1 class="text-primary text-center bg-secondary-subtle">Mantenimiento de Alumnos</h1>

		<!-- Formulario de alta de cursos -->
		<form method='GET'>

			<!--  Nombre -->
			<div class="mb-3 row m-2 p-2">
				<label for="nombre" class="col-sm-4 col-form-label text-primary">Nombre</label>
				<div class="col-sm-8">
					<input type="text"
						class="form-control text-primary bg-primary-subtle" id="nombre"
						value="" name="nombre" placeholder="Ingrese el nombre del alumno"
						minlength="2" maxlength="50" required>
				</div>
			</div>

			<!--  Apellido -->
			<div class="mb-3 row m-2 p-2">
				<label for="apellido" class="col-sm-4 col-form-label text-primary">Apellido</label>
				<div class="col-sm-8">
					<input type="text"
						class="form-control text-primary bg-primary-subtle" id="apellido"
						value="" name="apellido" placeholder="Ingrese el apellido del alumno"
						minlength="2" maxlength="50" required>
				</div>
			</div>
			
			<!--  Edad -->
			<div class="mb-3 row m-2 p-2">
				<label for="apellido" class="col-sm-4 col-form-label text-primary">Edad</label>
				<div class="col-sm-8">
					<input type="number"
						class="form-control text-primary bg-primary-subtle" id="edad" name="edad"
						value="18" name="edad" min="18" max="120" required>
				</div>
			</div>
			
			<!-- curso -->
			<div class="mb-3 row m-2 p-2">
				<label for="idCurso" class="col-sm-4 col-form-label text-primary">Curso</label>
				<div class="col-sm-8">
					<select class="form-select text-primary bg-primary-subtle"
						aria-label="Default select example" name="idCurso">
						<%@ include file="/jsp/selectCursos.jsp"%>
					</select>
				</div>
			</div>
			
			<!-- Botones -->
			<div class="mb-3 row m-2 p-2">
				<button type="reset" class="btn btn-danger col-sm-4">Borrar</button>
				<button type="submit" class="btn btn-success col-sm-4">Guardar</button>
			</div>

			<!--  Información -->
			<div class="mb-3 row m-2 p-2">
				<label for="informacion"
					class="col-sm-4 col-form-label text-primary">Información</label>
				<div class="col-sm-8">
					<input type="text"
						class="form-control text-primary bg-primary-subtle"
						id="informacion"
						value='<%@ include file="/jsp/alumnosInsert.jsp"%>'
						name="informacion" readonly>
				</div>
			</div>

		</form>
		
		<!-- Table de alumnos  -->
		<table class="table table table-striped table-primary table-hover">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nombre y Apellido</th>
					<th scope="col">Edad</th>
					<th scope="col">Curso</th>
					<th scope="col">Borrar</th>
				</tr>
			</thead>
			<tbody>
				<%@ include file="/jsp/alumnosTable.jsp"%>
			</tbody>
		</table>
		
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
	<script src="js/reloj.js"></script>
	<script src="js/main.js"></script>
</body>
</html>