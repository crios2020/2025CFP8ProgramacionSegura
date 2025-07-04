use colegio;
drop table if exists sessiones;
create table sessiones(
	id int auto_increment primary key,
    username varchar(50) not null,
    fecha_hora datetime not null,
    accion enum('LOGIN','LOGOUT','CHECKLOGIN') not null
);

select sysdate();
select * from sessiones;