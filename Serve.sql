create database serv;
use serv;
create table logins(
Nombre varchar(25),
ApellidoP varchar(25),
ApellidoM varchar(25),
Correo varchar(25),
Contraseña varchar(25)
);

insert into logins (Nombre,ApellidoP,ApellidoM,Correo,Contraseña) values('Genaro','Rodriguez','Morua','genarin@gmail.com','genarin');
select * from logins;