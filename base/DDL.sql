-- Muestra la versión del server
select version();

drop database if exists colegio;
create database colegio;
use colegio;

drop table if exists alumnos;
drop table if exists cursos;

create table cursos(
	id int auto_increment primary key,
    titulo varchar(50),
    profesor varchar(50),
    dia varchar(50),
    -- dia enum('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES') not null default 'LUNES',
	turno varchar(50),
    -- turno enum('MAÑANA','TARDE','NOCHE'),
    activo boolean default true
);

create table alumnos(
	id int auto_increment primary key,
    nombre varchar(50),
    apellido varchar(50),
    edad int,							-- check(edad>=18 and edad<=120)
    id_curso int,						-- Clave Foranea - Foreign Key (FK)
    activo boolean default true
);


