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
        <input type="password" name="clave1" id="clave1" 
            require minLength=8 maxLength=20><br>
        Repita la clave:
        <input type="password" name="clave2" id="clave2"
            require minLength=8 maxLength=20><br>
        <button type="reset">Borrar</button><br>
        <button type="submit" onclick="cifrar()" onsubmit="validar()">Enviar</button>

        <!-- 
        Para exigir que una contraseña contenga letras minúsculas, letras mayúsculas y números en un control de tipo password en HTML, puedes utilizar el atributo pattern junto con una expresión regular. Aquí tienes un ejemplo:

        <input type="password" 
            id="password" 
            name="password" 
            required 
            pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,}" 
            title="La contraseña debe tener al menos 8 caracteres, incluyendo letras mayúsculas, minúsculas y números.">
        Desglose del patrón:
        (?=.*[a-z]) - Asegura que haya al menos una letra minúscula.
        (?=.*[A-Z]) - Asegura que haya al menos una letra mayúscula.
        (?=.*\d) - Asegura que haya al menos un número.
        .{8,} - Asegura que la longitud mínima sea de 8 caracteres.
        Atributos:
        required - Hace que el campo sea obligatorio.
        title - Proporciona un mensaje que se mostrará si la contraseña no cumple con los requisitos.
        Con este enfoque, podrás asegurar que los usuarios ingresen contraseñas seguras.


        -->

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
        
        function validar(){
            //alert("Se ejecuto la funcion validar")
            //console.log("Se ejecuto la funcion validar")
            pass1=document.getElementById('clave1').value
            pass2=document.getElementById('clave2').value
            //if(pass1!=pass2) alert('Las claves no coinciden')
            return pass1==pass2
        }

        function cifrar() {
            //alert("Se ejecuto la funcion cifrar")
            //console.log("Se ejecuto la funcion cifrar")
            var input_pass1 = document.getElementById('clave1')
            var input_pass2 = document.getElementById('clave2')
            //input_pass.value=hex_md4(input_pass.value)
            //input_pass.value=hex_md5(input_pass.value)
            //input_pass.value = hex_sha1(input_pass.value)
            input_pass1.value=CryptoJS
                                        .SHA256(input_pass1.value)
                                        .toString(CryptoJS.enc.Base64) 
            input_pass2.value=CryptoJS
                                        .SHA256(input_pass2.value)
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
        array_key_exists('nombre', $_POST) &&
        array_key_exists('apellido', $_POST) &&
        array_key_exists('email', $_POST) &&
        array_key_exists('clave1', $_POST)
    ) {
        $sql = "insert into usuarios (nombre, apellido, email, clave) 
                values (?,?,?,?)";
        $stm = $conn->prepare($sql);
        $stm->bindParam(1, $_POST['nombre'], PDO::PARAM_STR, 20);
        $stm->bindParam(2, $_POST['apellido'], PDO::PARAM_STR, 20);
        $stm->bindParam(3, $_POST['email'], PDO::PARAM_STR, 50);
        $stm->bindParam(4, $_POST['clave1'], PDO::PARAM_STR, 200);
        $stm->execute();
        echo ('Se ingreso un usuario!<br>');
    } else {
        echo 'Falta ingresar datos.<br>';
    }
    ?>
</body>

</html>