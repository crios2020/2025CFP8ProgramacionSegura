<?php ini_set("display_errors", "1"); ?>
<?php


    session_start();                //inicia la session
    
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
        $clave=$_POST['clave'];
        $sql="select * from usuarios where email='".$_POST['email']."'";
        $registros=$conn->query($sql);

        if($registros->rowCount()==1){
            foreach ($registros as $registro) {
                $sql2="select * from usuarios where email='".$_POST['email'].
                        "' and clave=SHA2('".$clave."',512)";
                $registros2=$conn->query($sql2);
                if($registros2->rowCount()==1){
                    echo 'Bienvenido Usuario!!';
                    $_SESSION['login']=true;
                    $_SESSION['email']=$_POST['email'];
                    header('Location: index.php');
                }else{
                    echo 'Clave Incorrecta!!';
                    $_SESSION['login']=false;
                }
            }
        }else{
            echo 'Usuario inexistente!';
            $_SESSION['login']=false;
        }

        

    }
?>