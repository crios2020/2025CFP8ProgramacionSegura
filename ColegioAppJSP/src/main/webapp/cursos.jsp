<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/head.jsp"%>
</head>
<body onload="startTime()">

	<div class="container-fluid bg-success-subtle">

		<%@ include file="/jsp/menu.jsp"%>

		<h1 class="text-primary text-center bg-secondary-subtle">Mantenimiento
			de cursos</h1>

		<!-- Formulario de alta de cursos -->
		<form method='GET'>

			<!--  Título -->
			<div class="mb-3 row m-2 p-2">
				<label for="titulo" class="col-sm-4 col-form-label text-primary">Título</label>
				<div class="col-sm-8">
					<input type="text"
						class="form-control text-primary bg-primary-subtle" id="so"
						value="" name="titulo" placeholder="Ingrese el título del curso" 
						minlength="2" maxlength="50" required>
				</div>
			</div>

			<!--  Profesor -->
			<div class="mb-3 row m-2 p-2">
				<label for="profesor" class="col-sm-4 col-form-label text-primary">Profesor</label>
				<div class="col-sm-8">
					<input type="text"
						class="form-control text-primary bg-primary-subtle" id="profesor"
						value="" name="profesor" placeholder="Ingrese el profesor" 
						minlength="2" maxlength="50" required>
				</div>
			</div>

			<!-- Día -->
			<div class="mb-3 row m-2 p-2">
				<label for="dia" class="col-sm-4 col-form-label text-primary">Día</label>
				<div class="col-sm-8">
					<select class="form-select text-primary bg-primary-subtle"
						aria-label="Default select example" name="dia">
						<!-- 
						<option value="LUNES">lunes</option>
						<option value="MARTES">martes</option>
						<option value="MIERCOLES">miércoles</option>
						<option value="JUEVES">jueves</option>
						<option value="VIERNES">viernes</option>
						-->
						<%@ include file="/jsp/selectDias.jsp"%>
					</select>
				</div>
			</div>

			<!-- Turno -->
			<div class="mb-3 row m-2 p-2">
				<label for="turno" class="col-sm-4 col-form-label text-primary">Turno</label>
				<div class="col-sm-8">
					<select class="form-select text-primary bg-primary-subtle"
						aria-label="Default select example" name="turno">
						<%@ include file="/jsp/selectTurnos.jsp"%>
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
						value='<%@ include file="/jsp/cursosInsert.jsp"%>'
						name="informacion" readonly>
				</div>
			</div>

		</form>

		<!-- Table de cursos  -->
		<table class="table table table-striped table-primary table-hover">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Título</th>
					<th scope="col">Profesor</th>
					<th scope="col">Día</th>
					<th scope="col">Turno</th>
					<th scope="col">Borrar</th>
				</tr>
			</thead>
			<tbody>
				<%@ include file="/jsp/cursosTable.jsp"%>
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