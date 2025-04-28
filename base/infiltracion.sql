show tables;
describe alumnos;

select * from information_schema.TABLE_CONSTRAINTS tc 
	where tc.TABLE_SCHEMA ='basegeneral' and tc.TABLE_NAME ='alumnos';
alter table alumnos drop constraint FK_alumnos_id_cursos;