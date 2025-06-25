<?php
    session_start();    
    $_SESSION['login']=false;
    $_SESSION['email']="";
    session_unset();
    header('Location: login.php');
    exit();
?>