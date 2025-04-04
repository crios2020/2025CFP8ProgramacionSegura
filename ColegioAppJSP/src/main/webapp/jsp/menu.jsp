<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Menú de navegación -->
<nav class="navbar navbar-expand-lg" style="background-color: #e3f2fd;">
	<div class="container-fluid">
		<a class="navbar-brand text-primary" href="">Colegio</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<!-- Elementos de menú -->
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active text-success"
					aria-current="page" href="/index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link active text-success"
					aria-current="page" href="/cursos.jsp">Cursos</a></li>
				<li class="nav-item"><a class="nav-link active text-success"
					aria-current="page" href="/alumnos.jsp">Alumnos</a></li>
				<li class="nav-item"><a class="nav-link active text-success"
					aria-current="page" href="/config.jsp">Configuración</a></li>
			</ul>

			<!-- Boton buscar -->
			<form class="d-flex m-2" role="search">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search" name="buscar">
				<button class="btn btn-outline-success" type="submit">Buscar</button>
			</form>

			<!-- Reloj -->
			<div id="clockdate">
				<div class="clockdate-wrapper">
					<div id="clock"></div>
				</div>
			</div>

		</div>
	</div>
</nav>

