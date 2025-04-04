-- Active: 1699112345571@@127.0.0.1@3306@Agenda
use colegio;
select version();
INSERT INTO cursos (titulo, profesor, dia, turno, activo) VALUES
    ('Programación en Python', 'Juan Pérez', 'LUNES', 'MAÑANA', 'S'),
    ('Introducción a la Inteligencia Artificial', 'María Gómez', 'MARTES', 'TARDE', 'S'),
    ('Diseño de Bases de Datos', 'Carlos Rodríguez', 'MIERCOLES', 'NOCHE', 'S'),
    ('Desarrollo Web con HTML y CSS', 'Ana López', 'JUEVES', 'TARDE', 'S'),
    ('Redes de Computadoras', 'Pedro Martínez', 'VIERNES', 'MAÑANA', 'S'),
    ('Análisis de Datos', 'Laura Fernández', 'MARTES', 'NOCHE', 'S'),
    ('Inglés Avanzado', 'David Smith', 'MIERCOLES', 'TARDE', 'S'),
    ('Diseño Gráfico Digital', 'Sofía Ramírez', 'JUEVES', 'NOCHE', 'S'),
    ('Contabilidad Financiera', 'Luisa Torres', 'LUNES', 'TARDE', 'S'),
    ('Marketing Digital', 'Eduardo López', 'VIERNES', 'NOCHE', 'S'),
    ('Gestión de Proyectos', 'Roberto Hernández', 'MARTES', 'MAÑANA', 'S'),
    ('Estadística Aplicada', 'Carolina González', 'MIERCOLES', 'TARDE', 'S'),
    ('Programación en Java', 'Andrés Sánchez', 'JUEVES', 'MAÑANA', 'S'),
    ('Finanzas Corporativas', 'Marcela Ramírez', 'LUNES', 'NOCHE', 'S'),
    ('Derecho Laboral', 'Fernando Castro', 'MARTES', 'TARDE', 'S'),
    ('Psicología Organizacional', 'Gabriela Fernández', 'VIERNES', 'MAÑANA', 'S'),
    ('Comunicación Efectiva', 'José Silva', 'MIERCOLES', 'NOCHE', 'S'),
    ('Desarrollo de Aplicaciones Móviles', 'Silvia Muñoz', 'JUEVES', 'TARDE', 'S'),
    ('Gestión del Talento Humano', 'Pedro Pérez', 'LUNES', 'MAÑANA', 'S'),
    ('Mercadotecnia Estratégica', 'María Rodríguez', 'MARTES', 'NOCHE', 'S'),
    ('Sistemas Operativos', 'Carlos Gómez', 'MIERCOLES', 'TARDE', 'S'),
    ('Economía Internacional', 'Laura Torres', 'JUEVES', 'MAÑANA', 'S'),
    ('Desarrollo de Negocios Digitales', 'Andrea Sánchez', 'VIERNES', 'TARDE', 'S'),
    ('Administración de Proyectos', 'Roberto González', 'LUNES', 'NOCHE', 'S'),
    ('Introducción a la Programación', 'Alejandra López', 'MIERCOLES', 'MAÑANA', 'S');

INSERT INTO alumnos (nombre, apellido, edad, id_curso, activo)
VALUES
    ('Ricardo', 'Lara', 22, 12, 'S'),
    ('Andrea', 'Gómez', 23, 13, 'S'),
    ('Fernando', 'Martínez', 24, 14, 'S'),
    ('Gabriela', 'Hernández', 25, 15, 'S'),
    ('Alejandro', 'Silva', 21, 16, 'S'),
    ('Carmen', 'Rodríguez', 22, 17, 'S'),
    ('Mario', 'Torres', 23, 18, 'S'),
    ('Sara', 'López', 24, 19, 'S'),
    ('Diego', 'García', 25, 20, 'S'),
    ('Valeria', 'Hernández', 21, 21, 'S'),
    ('Roberto', 'Gómez', 22, 22, 'S'),
    ('Laura', 'Pérez', 23, 23, 'S'),
    ('Jorge', 'Martínez', 24, 24, 'S'),
    ('Ana', 'Gutiérrez', 25, 25, 'S'),
    ('Pedro', 'López', 21, 1, 'S'),
    ('María', 'García', 22, 2, 'S'),
    ('Carlos', 'Torres', 23, 3, 'S'),
    ('Luisa', 'Hernández', 24, 4, 'S'),
    ('Fernanda', 'López', 25, 5, 'S'),
    ('Daniel', 'Gómez', 21, 6, 'S'),
    ('Valentina', 'Rodríguez', 22, 7, 'S'),
    ('Andrés', 'Martínez', 23, 8, 'S'),
    ('Mariana', 'Silva', 24, 9, 'S'),
    ('Santiago', 'Hernández', 25, 10, 'S');

select * from cursos;

select * from alumnos;