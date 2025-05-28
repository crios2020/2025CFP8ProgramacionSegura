-- Active: 1745606726772@@127.0.0.1@3306@colegio
use colegio;
drop table if exists usuarios;
create table usuarios(
    id int auto_increment primary key,
    nombre varchar(20),
    apellido varchar(20),
    email varchar(50),
    clave varchar(200)
);
insert into usuarios (nombre, apellido, email) values 
    ('Juan','Perez','JuanPerez@gmail.com'),
    ('Laura','Gomez','LauraGomez@gmail.com');

select * from usuarios;
select * from usuarios where email='Carlos@gmail.com';

SELECT SHA2('contraseña', 512);

-- Delimitador alternativo para evitar problemas con el punto y coma en el código del trigger
DELIMITER $$
DROP TRIGGER IF EXISTS tr_usuarios_insert;
-- Crear el trigger BEFORE INSERT para la tabla 'mi_tabla'
CREATE TRIGGER tr_usuarios_insert
BEFORE INSERT
ON usuarios
FOR EACH ROW
BEGIN
  -- Modificar el valor de la columna 'mi_columna' en la nueva fila
  SET NEW.clave = SHA2(NEW.clave, 512);
  --  Opcional: Agregar lógica para realizar otras modificaciones
  --  ...
END; $$
-- Restaurar el delimitador original
DELIMITER ;
/*
insert into usuarios (nombre, apellido, email,clave) values 
    ('Juan','Perez','JuanPerez@gmail.com','1234'),
    ('Laura','Gomez','LauraGomez@gmail.com','4321');
*/
select * from usuarios;
-- delete from usuarios where id=3;

select * from cursos;
update cursos set activo=true;