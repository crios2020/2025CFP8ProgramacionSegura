-- Active: 1745609022511@@db4free.net@3306@basegeneral
-- use colegio;
select version();
-- registros validos
-- insert into cursos (titulo, profesor, dia, turno) values 
--     ('Java','Gomez','LUNES','TARDE');
-- insert into alumnos (nombre, apellido, edad, id_curso) values 
--     ('Andres','Lopez',24,1);

-- Integridad Referencial
insert into alumnos (nombre, apellido, edad, id_curso) values
    ('Ana','Gallardo',24,10000);

-- Tabla cursos
-- constraint titulo
insert into cursos (titulo, profesor, dia, turno) values 
    (null, 'Gomez','LUNES','TARDE');
insert into cursos (titulo, profesor, dia, turno) values 
    ('Ja','Gomez','LUNES','TARDE');
insert into cursos (titulo, profesor, dia, turno) values 
    ('Java el mejor curso de todos de toda historia','Gomez','LUNES','TARDE');

-- constraint profesor
insert into cursos (titulo, profesor, dia, turno) values 
    (null,'Gomez','LUNES','TARDE');
insert into cursos (titulo, profesor, dia, turno) values 
    ('Java','Go','LUNES','TARDE');

insert into cursos (titulo, profesor, dia, turno) values 
    ('Java','Gomez el mejor profesor de toda la historia','LUNES','TARDE');

-- contraint Dia
insert into cursos (titulo, profesor, dia, turno) values 
    ('Java','Gomez',null,'TARDE');
insert into cursos (titulo, profesor, dia, turno) values 
    ('Java','Gomez','Osvaldo','TARDE');
insert into cursos (titulo, profesor, dia, turno) values 
    ('Java','Gomez','lunes','TARDE');

-- constraint turno
insert into cursos (titulo, profesor, dia, turno) values 
    ('Java','Gomez',null,'TARDE');
insert into cursos (titulo, profesor, dia, turno) values 
    ('Java','Gomez','LUNES','MADRUGADA');
insert into cursos (titulo, profesor, dia, turno) values 
    ('Java','Gomez','LUNES','tarde');

-- constraint nombre
insert into alumnos (nombre, apellido, edad, id_curso) values 
    (null,'Lopez',24,1);
insert into alumnos (nombre, apellido, edad, id_curso) values 
    ('An','Lopez',24,1);

insert into alumnos (nombre, apellido, edad, id_curso) values 
    ('Andres el mejor alumno de todos','Lopez',24,1);


-- constraint apellido
insert into alumnos (nombre, apellido, edad, id_curso) values 
    ('Andres',null,24,1);

insert into alumnos (nombre, apellido, edad, id_curso) values 
    ('Andres','Lo',24,1);

insert into alumnos (nombre, apellido, edad, id_curso) values 
    ('Andres','Lopez el mejor alumnos de todos',24,1);

-- constraint edad
insert into alumnos (nombre, apellido, edad, id_curso) values 
    ('Andres','Lopez',null,1);
insert into alumnos (nombre, apellido, edad, id_curso) values 
    ('Andres','Lopez',17,1);
insert into alumnos (nombre, apellido, edad, id_curso) values 
    ('Andres','Lopez',240,1);

-- constraint id_curso
insert into alumnos (nombre, apellido, edad, id_curso) values 
    ('Andres','Lopez',24,null);
insert into alumnos (nombre, apellido, edad, id_curso) values 
    ('Andres','Lopez',24,999999999);

select * from cursos;
select * from alumnos;


