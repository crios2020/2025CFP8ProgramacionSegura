-- Active: 1699112345571@@127.0.0.1@3306@colegio
-- Consultas de prueba
use colegio;
select * from cursos;
select * from alumnos;

-- 1 Seleccionar el nombre del alumno y el nombre del curso al que pertenece:
SELECT a.nombre, c.titulo AS nombre_curso
FROM alumnos AS a
JOIN cursos AS c ON a.id_curso = c.id;

-- 2 Seleccionar los alumnos activos junto con el nombre del curso al que pertenecen:
SELECT a.nombre, c.titulo AS nombre_curso
FROM alumnos AS a
JOIN cursos AS c ON a.id_curso = c.id
WHERE a.activo = 'S';
-- 3 Seleccionar los alumnos junto con el nombre del curso al que pertenecen, ordenados por edad de forma descendente:
SELECT a.nombre, a.apellido, a.edad, c.titulo AS nombre_curso
FROM alumnos AS a
JOIN cursos AS c ON a.id_curso = c.id
ORDER BY a.edad DESC;
-- 4 Seleccionar los alumnos que pertenecen a un curso específico junto con el nombre del curso y el nombre del profesor:
SELECT a.nombre, c.titulo AS nombre_curso, c.profesor AS nombre_profesor
FROM alumnos AS a
JOIN cursos AS c ON a.id_curso = c.id
WHERE c.id = 3;