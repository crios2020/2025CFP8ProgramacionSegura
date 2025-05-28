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


    session_start();                //inicia la session
    //echo session_status()."<br>";   //1 no hay session
                                    //2 se inicio la session



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
        array_key_exists('email', $_POST) &&
        array_key_exists('clave', $_POST)
    ) {
        //echo($_POST['email']).'<br>';
        //echo($_POST['clave']).'<br>';

        //Almacenado en la BD
        //03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4
        
        //Ingresado en login
        //03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4
        $clave=$_POST['clave'];
        //echo $clave;
        $sql="select * from usuarios where email='".$_POST['email']."'";

        //echo $sql."<br>";

        $registros=$conn->query($sql);

        if($registros->rowCount()==1){
            foreach ($registros as $registro) {
                /*
                if($registro['clave']==$_POST['clave']){
                    echo 'Bienvenido Usuario!!<br>';
                }else{
                    echo 'Clave Incorrecta!!<br>';
                }
                */
                $sql2="select * from usuarios where email='".$_POST['email'].
                        "' and clave=SHA2('".$clave."',512)";
                $registros2=$conn->query($sql2);
                if($registros2->rowCount()==1){
                    echo 'Bienvenido Usuario!!<br>';
                    $_SESSION['login']=true;
                    header('Location: index.php');
                }else{
                    echo 'Clave Incorrecta!!<br>';
                    $_SESSION['login']=false;
                }
            }
        }else{
            echo 'Usuario inexistente!<br>';
            $_SESSION['login']=false;
        }

        

    }
?>