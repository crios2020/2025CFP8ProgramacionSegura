<?php include_once "php/front/session.php"; ?>

<!-- Menú de navegación -->
<nav class="navbar navbar-expand-lg" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand text-primary" href="index.php">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active text-primary" aria-current="page" href="cursos.php">Cursos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active text-primary" aria-current="page" href="alumnos.php">Alumnos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active text-primary" aria-current="page" href="configuracion.php">Configuración</a>
                </li>
                <li class="nav-item">
                    <input type="text" id="reloj" class="text-success text-center bg-primary-subtle" readonly value="reloj">
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" name="buscar" id="buscar" value="" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<!-- Fin Menú de navegación -->