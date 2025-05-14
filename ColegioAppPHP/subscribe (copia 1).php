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
        <input type="password" name="clave" id="clave"><br>
        <button type="reset">Borrar</button><br>
        <button type="submit" onclick="cifrar()">Enviar</button>
    </form>

    <!-- Encriptar con MD4 -->
    <!-- Descargar https://gist.github.com/romeoh/3302254 -->
    <!-- <script src="js/md4.js"></script> -->

    <!-- Encriptar con MD5 -->
    <!-- Descargar https://gist.github.com/romeoh/3302246 -->
    <!-- <script src="js/md5.js"></script> -->

    <!-- Encriptar con sha1 -->
    <!-- Descargar https://gist.github.com/romeoh/3302256 -->
    <!-- <script src="js/sha1.js"></script> -->


<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/core.min.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/md5.min.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/sha256.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/utf8.min.js"></script>

<script>
    //var hash = CryptoJS.SHA256("Message");
    //console.log(hash.toString(CryptoJS.enc.Base64))
</script>

    <script>
        

        function cifrar() {
            var input_pass = document.getElementById('clave')
            //input_pass.value=hex_md4(input_pass.value)
            //input_pass.value=hex_md5(input_pass.value)
            //input_pass.value = hex_sha1(input_pass.value)
            input_pass.value=CryptoJS
                                        .SHA256(input_pass.value)
                                        .toString(CryptoJS.enc.Base64)     
        }
    </script>

    <?php ini_set("display_errors", "1"); ?>
    <?php

    //Armado de connection root
    //Armar un archivo example y poner en .gitignore
    $driver = 'mysql';
    $hostname = 'localhost';
    $username = 'root';
    $password = '';
    $base = 'colegio';
    $conn = new PDO(
        "$driver:host=$hostname;dbname=$base",
        $username,
        $password
    );

    if (
        array_key_exists('nombre', $_REQUEST) &&
        array_key_exists('apellido', $_REQUEST) &&
        array_key_exists('email', $_REQUEST) &&
        array_key_exists('clave', $_REQUEST)
    ) {
        $sql = "insert into usuarios (nombre, apellido, email, clave) 
                values (?,?,?,?)";
        $stm = $conn->prepare($sql);
        $stm->bindParam(1, $_REQUEST['nombre'], PDO::PARAM_STR, 20);
        $stm->bindParam(2, $_REQUEST['apellido'], PDO::PARAM_STR, 20);
        $stm->bindParam(3, $_REQUEST['email'], PDO::PARAM_STR, 50);
        $stm->bindParam(4, $_REQUEST['clave'], PDO::PARAM_STR, 200);
        $stm->execute();
        echo ('Se ingreso un usuario!<br>');
    } else {
        echo 'Falta ingresar datos.<br>';
    }
    ?>
</body>

</html>