use colegio;

-- Insertar registros en la tabla cursos
INSERT INTO cursos (id, titulo, profesor, dia, turno, activo) VALUES
(1, 'Matemáticas', 'Dr. Pérez', 'LUNES', 'MAÑANA', TRUE),
(2, 'Historia', 'Prof. Gómez', 'MARTES', 'TARDE', TRUE),
(3, 'Biología', 'Dra. López', 'MIERCOLES', 'NOCHE', TRUE),
(4, 'Química', 'Dr. Fernández', 'JUEVES', 'MAÑANA', TRUE),
(5, 'Física', 'Prof. Ruiz', 'VIERNES', 'TARDE', TRUE),
(6, 'Literatura', 'Dra. Martínez', 'LUNES', 'NOCHE', TRUE),
(7, 'Geografía', 'Prof. Torres', 'MARTES', 'MAÑANA', TRUE),
(8, 'Informática', 'Dra. Ramírez', 'MIERCOLES', 'TARDE', TRUE),
(9, 'Educación Física', 'Prof. Morales', 'JUEVES', 'NOCHE', TRUE),
(10, 'Música', 'Dr. Jiménez', 'VIERNES', 'MAÑANA', TRUE),
(11, 'Arte', 'Prof. Soto', 'LUNES', 'TARDE', TRUE),
(12, 'Ética', 'Dra. Castro', 'MARTES', 'NOCHE', TRUE),
(13, 'Filosofía', 'Prof. Ortega', 'MIERCOLES', 'MAÑANA', TRUE),
(14, 'Economía', 'Dra. Herrera', 'JUEVES', 'TARDE', TRUE),
(15, 'Psicología', 'Prof. Delgado', 'VIERNES', 'NOCHE', TRUE),
(16, 'Sociología', 'Dra. Méndez', 'LUNES', 'MAÑANA', TRUE),
(17, 'Antropología', 'Prof. Paredes', 'MARTES', 'TARDE', TRUE),
(18, 'Derecho', 'Dra. Salazar', 'MIERCOLES', 'NOCHE', TRUE),
(19, 'Ingeniería', 'Prof. Mendoza', 'JUEVES', 'MAÑANA', TRUE),
(20, 'Arquitectura', 'Dra. López', 'VIERNES', 'TARDE', TRUE);

-- Insertar registros en la tabla alumnos
INSERT INTO alumnos (id, nombre, apellido, edad, id_curso, activo) VALUES
(1, 'Juan', 'Pérez', 20, 1, TRUE),
(2, 'Ana', 'Gómez', 22, 2, TRUE),
(3, 'Luis', 'López', 19, 3, TRUE),
(4, 'María', 'Fernández', 25, 4, TRUE),
(5, 'Pedro', 'Ruiz', 30, 5, TRUE),
(6, 'Sofía', 'Martínez', 18, 6, TRUE),
(7, 'Diego', 'Torres', 21, 7, TRUE),
(8, 'Clara', 'Ramírez', 23, 8, TRUE),
(9, 'Javier', 'Morales', 26, 9, TRUE),
(10, 'Lucía', 'Jiménez', 29, 10, TRUE),
(11, 'Carlos', 'Soto', 24, 11, TRUE),
(12, 'Valentina', 'Castro', 27, 12, TRUE),
(13, 'Andrés', 'Ortega', 28, 13, TRUE),
(14, 'Natalia', 'Herrera', 32, 14, TRUE),
(15, 'Fernando', 'Delgado', 31, 15, TRUE),
(16, 'Gabriela', 'Méndez', 35, 16, TRUE),
(17, 'Ricardo', 'Paredes', 29, 17, TRUE),
(18, 'Paola', 'Salazar', 34, 18, TRUE),
(19, 'Nicolás', 'Mendoza', 36, 19, TRUE),
(20, 'Isabel', 'López', 40, 20, TRUE);

