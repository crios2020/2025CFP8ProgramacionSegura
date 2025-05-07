-- Active: 1746473779017@@localhost@3306
select * from cursos;
insert into cursos VALUES
    (null,'Jarrones','Lopez','LUNES','MAÑANA',true);
update cursos set titulo='Jabones' where id=9;

delete from cursos where id=9;

create table test(
    texto varchar(20)
);
drop table cursos;

show tables;
select * from usuarios;