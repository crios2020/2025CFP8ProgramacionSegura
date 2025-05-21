<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Hash con SHA-256</title>
</head>
<body>
    <h2>Formulario para Hashear Clave con SHA-256</h2>
    <form method="POST">
        <label for="clave">Ingresa una clave:</label>
        <input type="password" name="clave" required>
        <br><br>
        <input type="submit" name="guardar" value="Hashear y Guardar">
        <input type="submit" name="verificar" value="Verificar Clave">
    </form>

    <?php
    $archivo_hash = 'clave_sha.txt';

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $clave = $_POST['clave'];
        $hash_sha256 = hash('sha256', $clave); // Usamos SHA-256

        if (isset($_POST['guardar'])) {
            // Abrimos el archivo en modo de adición
            $archivo = fopen($archivo_hash, 'a');
            if ($archivo) {
                // Escribimos el hash seguido de una nueva línea
                fwrite($archivo, $hash_sha256 . PHP_EOL);
                fclose($archivo);
                echo "<p>✅ Clave hasheada y guardada.</p>";
            } else {
                echo "<p>❌ No se pudo abrir el archivo para guardar la clave.</p>";
            }
        }

        if (isset($_POST['verificar'])) {
            if (file_exists($archivo_hash)) {
                $hashes_guardados = file($archivo_hash, FILE_IGNORE_NEW_LINES);
                if (in_array($hash_sha256, $hashes_guardados)) {
                    echo "<p>🔓 Clave correcta (hash coincide).</p>";
                } else {
                    echo "<p>❌ Clave incorrecta.</p>";
                }
            } else {
                echo "<p>⚠️ No hay claves guardadas aún.</p>";
            }
        }
    }
    ?>
</body>
</html>
