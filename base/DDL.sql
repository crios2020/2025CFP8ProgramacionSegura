-- Active: 1745606726772@@127.0.0.1@3306@colegio
-- Muestra la versión del server
select version();

-- drop database if exists colegio;
-- create database colegio;
-- use colegio;

drop table if exists alumnos;
drop table if exists cursos;

create table cursos(
	id int auto_increment primary key,
    titulo varchar(25) not null check(length(titulo)>=3),
    profesor varchar(25) not null check(length(profesor)>=3),
    dia enum('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES') not null default 'LUNES',
    turno enum('MAÑANA','TARDE','NOCHE') not null default 'MAÑANA',
    activo boolean default true
);

create table alumnos(
	id int auto_increment primary key,
    nombre varchar(25) not null check(length(nombre)>=3),
    apellido varchar(25) not null check(length(apellido)>=3),
    edad int not null check(edad>=18 and edad<=120),
    id_curso int not null,
    activo boolean default true
);

alter table alumnos
    add constraint FK_alumnos_id_cursos
    foreign key (id_curso) 
    references alumnos(id);
