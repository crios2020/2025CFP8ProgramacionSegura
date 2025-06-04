<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Colegio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body onload="mueveReloj(), getDolar()">

    <?php include_once "php/front/session.php"; ?>

    <div class="container-lg">

        <!-- Menú de navegación -->
        <?php include_once "menu.php"; ?>

        <!-- Banner -->
        <h1 class="bg-secondary-subtle text-primary text-center p-2">Sistema de Colegio</h1>

        <div class="text-center bg-info-subtle">
            <img src="images/aula.png" class="img-fluid" alt="aula de colegio">
        </div>
        
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="js/reloj.js"></script>
    <script src="js/main.js"></script>
</body>

</html>