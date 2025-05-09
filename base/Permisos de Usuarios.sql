-- Active: 1745606726772@@127.0.0.1@3306@colegio
use colegio;

-- ColegioAppJSP
DROP USER if exists 'ColegioAppJSP'@'localhost';
CREATE USER 'ColegioAppJSP'@'localhost' IDENTIFIED BY '1234';
GRANT SELECT, INSERT, UPDATE, DELETE ON colegio.cursos
            TO 'ColegioAppJSP'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON colegio.alumnos
            TO 'ColegioAppJSP'@'localhost';
FLUSH PRIVILEGES;

-- ColegioAppJavaMVC
DROP USER if exists 'ColegioAppJavaMVC'@'localhost';
CREATE USER 'ColegioAppJavaMVC'@'localhost' IDENTIFIED BY '1234';
GRANT SELECT, INSERT, UPDATE, DELETE ON colegio.cursos
            TO 'ColegioAppJavaMVC'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON colegio.alumnos
            TO 'ColegioAppJavaMVC'@'localhost';
FLUSH PRIVILEGES;

-- ColegioAppJavaSwing
DROP USER if exists 'ColegioAppJavaSwing'@'localhost';
CREATE USER 'ColegioAppJavaSwing'@'localhost' IDENTIFIED BY '1234';
GRANT SELECT, INSERT, UPDATE, DELETE ON colegio.cursos
            TO 'ColegioAppJavaSwing'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON colegio.alumnos
            TO 'ColegioAppJavaSwing'@'localhost';
FLUSH PRIVILEGES;

-- ColegioAppPHP
DROP USER if exists 'ColegioAppPHP'@'localhost';
CREATE USER 'ColegioAppPHP'@'localhost' IDENTIFIED BY '1234';
GRANT SELECT, INSERT, UPDATE, DELETE ON colegio.cursos
            TO 'ColegioAppPHP'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON colegio.alumnos
            TO 'ColegioAppPHP'@'localhost';
FLUSH PRIVILEGES;


