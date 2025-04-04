<%@page import="ar.com.eduit.curso.java.web.colegio.connectors.Connector"%>
<%@page import="ar.com.eduit.curso.java.web.colegio.utils.SystemProperties"%>
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

		<h1 class="text-primary text-center bg-secondary-subtle">Configuración de sistema</h1>
		
		<form>
		
			<!--  Sistema Operativo -->
			<div class="mb-3 row m-2 p-2">
				<label for="so" class="col-sm-4 col-form-label text-primary">Sistema Operativo</label>
				<div class="col-sm-8">
					<input type="text" class="form-control text-primary bg-primary-subtle" readonly id="so" value="<% out.print(new SystemProperties().getSystem()); %>" >
				</div>
			</div>
			
			<!--  Versión de Java -->
			<div class="mb-3 row m-2 p-2">
				<label for="java" class="col-sm-4 col-form-label text-primary">Versión de Java</label>
				<div class="col-sm-8">
					<input type="text" class="form-control text-primary bg-primary-subtle" readonly id="javao" value="<% out.print(new SystemProperties().getJava()); %>" >
				</div>
			</div>
			
			<!--  Nombre de Usuario -->
			<div class="mb-3 row m-2 p-2">
				<label for="user" class="col-sm-4 col-form-label text-primary">Nombre de Usuario</label>
				<div class="col-sm-8">
					<input type="text" class="form-control text-primary bg-primary-subtle" readonly id="user" value="<% out.print(new SystemProperties().getUser()); %>" >
				</div>
			</div>
			
			<!--  jdbc -->
			<div class="mb-3 row m-2 p-2">
				<label for="jdbc" class="col-sm-4 col-form-label text-primary">JDBC</label>
				<div class="col-sm-8">
					<input type="text" class="form-control text-primary bg-primary-subtle" readonly id="user" value="<% out.print(Connector.getUrl()); %>" >
				</div>
			</div>
			
			<!--  Ubicación -->
			<div class="mb-3 row m-2 p-2">
				<label for="ubicacion" class="col-sm-4 col-form-label text-primary">Ubicación</label>
				<div class="col-sm-8">
					<input type="text" class="form-control text-primary bg-primary-subtle" readonly id="ubicacion" value="<% out.print(new SystemProperties().getUbicacion()); %>" >
				</div>
			</div>
			
			<!--  Fecha -->
			<div class="mb-3 row m-2 p-2">
				<label for="fecha" class="col-sm-4 col-form-label text-primary">Fecha</label>
				<div class="col-sm-8">
					<input type="text" class="form-control text-primary bg-primary-subtle" readonly id="fecha" value="<% out.print(new SystemProperties().getFecha()); %>" >
				</div>
			</div>
			
			<!--  IP Publica -->
			<div class="mb-3 row m-2 p-2">
				<label for="ip" class="col-sm-4 col-form-label text-primary">IP Pública</label>
				<div class="col-sm-8">
					<input type="text" class="form-control text-primary bg-primary-subtle" readonly id="ip" value="" >
				</div>
			</div>
			
		</form>
		
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script src="js/reloj.js"></script>
	<script src="js/ip.js"></script>
</body>
</html>