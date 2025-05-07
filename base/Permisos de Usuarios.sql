-- Active: 1745606726772@@127.0.0.1@3306@colegio
use colegio;
DROP USER if exists 'ColegioAppJSP'@'localhost';
CREATE USER 'ColegioAppJSP'@'localhost' IDENTIFIED BY '1234';
GRANT SELECT, INSERT, UPDATE, DELETE ON colegio.cursos
            TO 'ColegioAppJSP'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON colegio.alumnos
            TO 'ColegioAppJSP'@'localhost';
FLUSH PRIVILEGES;