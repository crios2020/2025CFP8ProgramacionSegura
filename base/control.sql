-- Active: 1745606726772@@127.0.0.1@3306@colegio
use colegio;
drop table if exists control_auditoria;
create table control_auditoria(
    id int auto_increment primary key,
    tabla enum('ALUMNOS','CURSOS'),
    accion enum('INSERT','DELETE','UPDATE') not null,
    registro_id int not null,
    usuario varchar(50) not null,
    hostname varchar(50) not null,
    fecha_hora datetime not null
);

select * from control_auditoria;

insert into control_auditoria VALUES (
    null,'ALUMNOS','INSERT',2,user(),'',sysdate()
);

drop trigger if exists tr_cursos_insert;
DELIMITER $$
CREATE TRIGGER tr_cursos_insert
    AFTER INSERT ON cursos
    FOR EACH ROW
    BEGIN
        insert into control_auditoria VALUES (
            null,'CURSOS','INSERT',NEW.id,user(),'',sysdate()
    );
END;$$

-- consulta de catalogo de triggers
select * from information_schema.TRIGGERS 
    where TRIGGER_SCHEMA='colegio';

insert into cursos values 
    (null,'Herreria','Gimenez','LUNES','TARDE',true);

CREATE TRIGGER tr_cursos_delete
    AFTER DELETE ON cursos
    FOR EACH ROW
    BEGIN
        insert into control_auditoria VALUES (
            null,'CURSOS','DELETE',OLD.id,user(),'',sysdate()
    );
END;$$
DROP TRIGGER if EXISTS tr_cursos_update;
CREATE TRIGGER tr_cursos_update
    AFTER UPDATE ON cursos
    FOR EACH ROW
    BEGIN
        IF (NEW.activo=OLD.activo) THEN
            insert into control_auditoria VALUES (
            null,'CURSOS','UPDATE',NEW.id,user(),'',sysdate());
        ELSE
            insert into control_auditoria VALUES (
            null,'CURSOS','DELETE',NEW.id,user(),'',sysdate());
        END IF;

END;$$

delete from cursos where id=10;
select * from control_auditoria;

-- TODO Triggers Alumnos
