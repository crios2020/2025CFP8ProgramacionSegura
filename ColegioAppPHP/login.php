<form method='POST'>
    email: <input type="email" id="email" name="email"><br>
    password: <input type="password" id="clave" name="clave"><br>
    <button type="reset">Borrar</button>
    <button type="submit" onclick="cifrar()">Enviar</button>
</form>

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
        array_key_exists('email', $_REQUEST) &&
        array_key_exists('clave', $_REQUEST)
    ) {
        //echo($_REQUEST['email']).'<br>';
        //echo($_REQUEST['clave']).'<br>';

        //Almacenado en la BD
        //03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4
        
        //Ingresado en login
        //03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4

        $sql="select * from usuarios where email='".$_REQUEST['email']."'";

        //echo $sql."<br>";

        $registros=$conn->query($sql);

        if($registros->rowCount()==1){

        }else{
            echo 'Usuario inexistente!<br>';
        }

        

    }
?>