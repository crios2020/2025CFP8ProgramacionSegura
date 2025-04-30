<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>subcribe</title>
</head>
<body>
    <form method="POST">
        <h1>Subscribite</h1>
        nombre: 
        <input type="text" name="nombre"><br>
        apellido:
        <input type="apellido" name="apellido"><br>
        email:
        <input type="email" name="email"><br>
        clave:
        <input type="password" name="clave"><br>
        <button type="reset">Borrar</button><br>
        <button type="submit">Enviar</button>
    </form>
    <?php
        require_once '/php/connectors/connector.php';
        $tabla='usuarios';
        if( array_key_exists('nombre',$_REQUEST) &&
            array_key_exists('apellido',$_REQUEST) &&
            array_key_exists('email',$_REQUEST) &&
            array_key_exists('clave',$_REQUEST)){
                
            }
    ?>
</body>
</html>