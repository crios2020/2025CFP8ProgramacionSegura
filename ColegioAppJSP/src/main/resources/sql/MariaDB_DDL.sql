-- Active: 1700312889460@@db4free.net@3306@basegeneral
/*
    Database Client
    v6.8.2
    Weijan Chen

    https://db4free.net/
    db:     basegeneral
    user:   basegeneral
    pass:   basegeneral

*/

drop database if exists colegio;
create database colegio;
use colegio;
drop table if exists alumnos;
drop table if exists cursos;
create table cursos(
    id int auto_increment primary key,
    titulo varchar(50) not null, -- check(length(titulo>=2)),
    profesor varchar(50) not null, -- check(length(profesor>=2)),
    dia enum('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES') not null,
    turno enum('MAÑANA','TARDE','NOCHE') not null,
    activo enum('S','N') default('S')
);
create table alumnos(
    id int auto_increment primary key,
    nombre varchar(50) not null, -- check(length(nombre>=2)),
    apellido varchar(50) not null, -- check(length(apellido>=2)),
    edad int not null check(edad>=18 and edad<=120),
    id_curso int not null,
    activo enum('S','N') default('S')
);
alter table alumnos
    add constraint FK_Alumos_Id_Curso
    foreign key(id_curso)
    references cursos(id);

show tables;
select * from cursos;
select * from alumnos;
