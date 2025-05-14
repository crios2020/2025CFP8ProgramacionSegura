<?php
    echo "-------------------------------------------------------------<br>";
    echo "Upload: ".$_FILES['file']['name']."<br>";
    echo "Type:   ".$_FILES['file']['type']."<br>";
    echo "Size:   ".intval($_FILES['file']['size']/1024)."kb <br>";
    echo "Stored: ".$_FILES['file']['tmp_name']."<br>";
    echo "-------------------------------------------------------------<br>";

    if(
       ($_FILES['file']['type']=="image/gif"    ||
        $_FILES['file']['type']=="image/webp"   ||
        $_FILES['file']['type']=="image/jpg"    ||
        $_FILES['file']['type']=="image/jpeg"   ||
        $_FILES['file']['type']=="image/png")   &&
        $_FILES['file']['size']<=200000   

    ){
        if(file_exists("upload/".$_FILES['file']['name'])){
            echo "Error, el archivo ya existe!<br>";
        }else{
            move_uploaded_file( 
                        $_FILES['file']['tmp_name'],
                        "upload/".$_FILES['file']['name']
            );
            echo "Se almaceno el archivo ".$_FILES['file']['name']."<br>";
        }
    }else{
        echo "Error, el archivo es invalido!<br>";
    }

?>