-- Active: 1715034901720@@127.0.0.1@3306

-- 1. Obtener el nombre y apellido de los alumnos inscritos en un curso junto con el título del curso:
SELECT alumnos.nombre, alumnos.apellido, cursos.titulo
FROM alumnos
INNER JOIN cursos ON alumnos.idCurso = cursos.id;

-- 2. Obtener el nombre y turno de los cursos junto con el nombre y apellido del profesor que los imparte:
SELECT cursos.titulo, cursos.turno, cursos.profesor
FROM cursos;

-- 3. Obtener el título del curso y el nombre del profesor para los cursos en los que hay alumnos inscritos:
SELECT cursos.titulo, cursos.profesor AS nombre_profesor
FROM cursos
INNER JOIN alumnos ON cursos.id = alumnos.idCurso;

-- 4. Obtener el nombre y apellido de los alumnos junto con el título del curso en el que están inscritos, solo para los cursos activos:
SELECT alumnos.nombre, alumnos.apellido, cursos.titulo
FROM alumnos
INNER JOIN cursos ON alumnos.idCurso = cursos.id
WHERE cursos.activo = true;

-- 5. Obtener el título de los cursos que se imparten los lunes en la mañana, junto con el nombre y apellido del profesor que los imparte:
SELECT cursos.titulo, cursos.profesor
FROM cursos
WHERE cursos.dia = 'LUNES' AND cursos.turno = 'MAÑANA';

select * from cursos;