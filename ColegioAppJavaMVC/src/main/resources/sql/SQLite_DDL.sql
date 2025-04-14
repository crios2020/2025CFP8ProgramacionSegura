-- Active: 1715034901720@@127.0.0.1@3306
-- extensión MySQL Weijan Chen

drop table if exists alumnos;
drop table if exists cursos;


create table cursos(
    id integer primary key,
    titulo varchar(25) not null check(length(titulo)>=3),
    profesor varchar(25) not null check(length(profesor)>=3),
    dia varchar(12)check (dia in ('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES')) not null,
    turno varchar(12) check (turno in('MAÑANA','TARDE','NOCHE')) not null,
    activo boolean default true
);

create table alumnos(
    id integer primary key,
    nombre varchar(25) not null check(length(nombre)>=3),
    apellido varchar(25) not null check(length(apellido)>=3),
    edad int not null check (edad>=18 and edad<=120),
    idCurso int not null REFERENCES cursos(id),
    activo boolean default true
);



