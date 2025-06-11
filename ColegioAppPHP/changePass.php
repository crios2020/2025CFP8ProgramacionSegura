<?php include_once "php/front/session.php"; ?>

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
            array_key_exists('pass', $_POST)
        ) {
            $sql2="select * from usuarios where email='".$_SESSION['email'].
                        "' and clave=SHA2('".$_POST['pass']."',512)";
            $registros=$conn->query($sql2);
            echo $registros->rowCount();
            if($registros->rowCount()>=1){
                $sql = "update usuarios set clave=? where email=?";
                $stm = $conn->prepare($sql);
                $stm->bindParam(1, $_POST['newPass'], PDO::PARAM_STR, 200);
                $stm->bindParam(2, $_SESSION['email'], PDO::PARAM_STR, 20);
                $stm->execute();
                echo 'Clave Cambiada!!<br>';
            }else{
                echo 'Clave Incorrecta!!<br>';
            }
        }else{
            echo 'Datos incorrectos!<br>';
        }

    ?>

