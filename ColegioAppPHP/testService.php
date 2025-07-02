<?php ini_set("display_errors", "1"); ?>
<?php include_once "php/front/session.php"; ?>
<?php
    //http://localhost/ColegioAppPHP/testService.php?nombre=Carlos
	header("HTTP/1.1 200 OK");
	header('Content-type:application/json');
	
    //Test
    //$nombre="";
    //if (isset($_GET['nombre'])) $nombre=$_GET['nombre'];
    //echo json_encode("Hola ".$nombre);

    //Alumnos Services
    include_once "php/connectors/connector.php";
    $connector = new Connector();
    $titulo="";
    $sql = $connector->
            getConnection()->
            prepare("select * 
                        from cursos 
                        where titulo like :titulo 
                        and activo=true");
    if (isset($_GET['titulo'])) $titulo=$_GET['titulo'];
    $sql->bindValue(':titulo', "%$titulo%");
    $sql->execute();
    echo json_encode($sql->fetchAll());
    //%'; -- 
?>