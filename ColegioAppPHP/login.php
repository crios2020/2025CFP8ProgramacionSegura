<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
     <title>VaidrollTeamLogin6</title>
     <link rel="stylesheet" href="css/vaidroll.css">	
</head>
<body>

    <div class="cajafuera">
        <div class="formulariocaja">
            <form method="post" name="vaidrollteam">
                <img src="images/user1.png" alt="imagen1">
                <img src="images/user2.png" alt="imagen2">

                <input type="text" name="email" placeholder="&#128100; Email" class="cajaentradatexto">

                <input type="password" name="clave" id="clave"
                placeholder="&#128274; Password" class="cajaentradatexto">

                <input type="text" name="" class="cajaentradatexto" 
                value='
                    <?php include_once "php/front/loginphp.php"; ?>
                '>

                <input type="submit" value="Iniciar sesión" class="botonenviar" onclick="cifrar()">
                <input type="reset" value="Cancelar" class="botonenviar">
                <div class="ref1"><a href="subscribe.php">Registrar</a> / <a href="#">Recuperar contraseña</a></div>
            </form>
        </div>
    </div> 
    <footer>
        © 2021 Formulario Login. Todos los derechos reservados | Diseño de VaidrollTeam 
    </footer>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/core.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/sha256.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/utf8.min.js"></script>
    <script>
        function cifrar() {
            var input_pass = document.getElementById('clave')
            input_pass.value=CryptoJS
                                        .SHA256(input_pass.value)
                                        .toString(CryptoJS.enc.Base64)  
        }
    </script>
</body>
</html>
