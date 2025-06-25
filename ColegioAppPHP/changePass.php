<?php include_once "php/front/session.php"; ?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Colegio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body onload="mueveReloj()">

    <?php include_once "php/front/session.php"; ?>

    <div class="container-lg">

        <!-- Menú de navegación -->
        <?php include_once "menu.php"; ?>

        <!-- Banner -->
        <h1 class="bg-secondary-subtle text-primary text-center p-2">Configuración del sistema</h1>

        <!-- Formulario de configuración -->
        <div class="p-4 bg-info-subtle">

            <!-- Password Actual -->
            <div class="mb-3 row">
                <label for="pass" class="col-sm-3 col-form-label text-primary">Password Actual</label>
                <div class="col-sm-9">
                    <input type="password" class="form-control text-primary" 
                        id="pass" name="pass">
                </div>
            </div>

            <!-- Password Nuevo  -->
            <div class="mb-3 row">
                <label for="newPass" class="col-sm-3 col-form-label text-primary">Password Nueva</label>
                <div class="col-sm-9">
                    <input type="password" class="form-control text-primary" 
                        id="newPass">
                </div>
            </div>

            <!-- Confirmación de password -->
            <div class="mb-3 row">
                <label for="confirmPass" class="col-sm-3 col-form-label text-primary">Confirmar Password</label>
                <div class="col-sm-9">
                    <input type="password" class="form-control text-primary" 
                        id="confirmPass" name= "confirmPass">
                </div>
            </div>           

            <!-- botones -->
            <div class="mb-3 row">
                <button type="reset" class="btn btn-danger col-sm-3 m-2">Borrar</button>
                <button type="submit" class="btn btn-success col-sm-3 m-2"
                    onclick="cifrar()" onsubmit="validar()">Cambiar</button>
            </div>

            <!-- Información -->
            <div class="mb-3 row">
                <label for="info" class="col-sm-3 col-form-label text-primary">Información</label>
                <div class="col-sm-9">
                    <div class="form-control text-primary" id="info">
                        <?php include_once "php/front/change.php"; ?>
                    </div>
                </div>
            </div>

        </div>

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="js/reloj.js"></script>
    <script src="js/main.js"></script>
</body>

</html>

<!--
<form method='POST'>

    Ingrese su password actual: <input type="password" 
        id="pass" name="pass"><br>
    Ingrese su nuevo password: <input type="password"
        id="newPass" name="newPass"><br>
    Confirmación de password: <input type="password"
        id="confirmPass" name="confirmPass"><br>
    <button type="reset" >Borrar</button>
    <button type="submit" onclick="cifrar()" onsubmit="validar()">Cambiar</button>
</form>
-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/core.min.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/md5.min.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/sha256.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/utf8.min.js"></script>

<script>
    
    function validar(){
        //alert("Se ejecuto la funcion validar")
        //console.log("Se ejecuto la funcion validar")
        pass1=document.getElementById('newPass').value
        pass2=document.getElementById('confirmPass').value
        //if(pass1!=pass2) alert('Las claves no coinciden')
        return pass1==pass2
    }

    function cifrar() {
        //alert("Se ejecuto la funcion cifrar")
        //console.log("Se ejecuto la funcion cifrar")
        var input_pass1 = document.getElementById('newPass')
        var input_pass2 = document.getElementById('confirmPass')
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

    

