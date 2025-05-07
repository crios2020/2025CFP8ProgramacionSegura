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