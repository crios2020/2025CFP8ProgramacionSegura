use colegio;

INSERT INTO cursos (titulo, profesor, dia, turno, activo) VALUES
    ('Matemáticas', 'Juan Pérez', 'LUNES', 'MAÑANA', true),
    ('Historia', 'María Gómez', 'MARTES', 'TARDE', true),
    ('Ciencias', 'Luis Hernández', 'MIERCOLES', 'NOCHE', true),
    ('Literatura', 'Ana Rodríguez', 'JUEVES', 'MAÑANA', true),
    ('Inglés', 'Pedro Martínez', 'VIERNES', 'TARDE', true),
    ('Física', 'Laura Pérez', 'LUNES', 'NOCHE', true),
    ('Química', 'Carlos García', 'MARTES', 'MAÑANA', true),
    ('Arte', 'Sofía Fernández', 'MIERCOLES', 'TARDE', true),
    ('Música', 'Javier González', 'JUEVES', 'NOCHE', true),
    ('Informática', 'Valeria Torres', 'VIERNES', 'MAÑANA', true),
    ('Economía', 'Daniel Sánchez', 'LUNES', 'TARDE', true),
    ('Biología', 'Lucía Flores', 'MARTES', 'NOCHE', true),
    ('Geografía', 'Miguel Romero', 'MIERCOLES', 'MAÑANA', true),
    ('Filosofía', 'Isabella Jiménez', 'JUEVES', 'TARDE', true),
    ('Psicología', 'Alejandro Vargas', 'VIERNES', 'NOCHE', true),
    ('Sociología', 'Fernanda Suárez', 'LUNES', 'MAÑANA', true),
    ('Derecho', 'Gabriel Molina', 'MARTES', 'TARDE', true),
    ('Medicina', 'Paula Ortega', 'MIERCOLES', 'NOCHE', true),
    ('Arquitectura', 'Andrés Rojas', 'JUEVES', 'MAÑANA', true),
    ('Ingeniería', 'Camila Cruz', 'VIERNES', 'TARDE', true);
    
INSERT INTO alumnos (nombre, apellido, edad, id_curso, activo) VALUES
    ('Juan', 'López', 20, 1, true),
    ('María', 'Gómez', 22, 2, true),
    ('Luis', 'Hernández', 25, 3, true),
    ('Ana', 'Rodríguez', 19, 4, true),
    ('Pedro', 'Martínez', 21, 5, true),
    ('Laura', 'Pérez', 23, 6, true),
    ('Carlos', 'García', 24, 7, true),
    ('Sofía', 'Fernández', 20, 8, true),
    ('Javier', 'González', 22, 9, true),
    ('Valeria', 'Torres', 21, 10, true),
    ('Daniel', 'Sánchez', 19, 11, true),
    ('Lucía', 'Flores', 25, 12, true),
    ('Miguel', 'Romero', 23, 13, true),
    ('Isabella', 'Jiménez', 24, 14, true),
    ('Alejandro', 'Vargas', 20, 15, true),
    ('Fernanda', 'Suárez', 22, 16, true),
    ('Gabriel', 'Molina', 21, 17, true),
    ('Paula', 'Ortega', 19, 18, true),
    ('Andrés', 'Rojas', 25, 19, true),
    ('Camila', 'Cruz', 23, 20, true);