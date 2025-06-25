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