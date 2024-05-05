create database bd_rb;
use bd_rb;
-- crear tablas --
create table tb_usuario(
	idUsuario int(11) auto_increment primary key,
    nombre varchar(30) not null,
    apellido varchar(30) not null,
    usuario varchar(30) not null,
    password varchar(30) not null,
    telefono varchar(30) not null,
    estado int(1) not null
);
create table tb_categorias(
	idCategoria int(11) auto_increment primary key,
    descripcion varchar(200) not null,
    estado int(1) not null
);
create table tb_productos(
	idProducto int(11) auto_increment primary key,
    nombre varchar(30) not null,
    cantidad int(10) not null,
    precio varchar(10) not null,
    descripcion varchar(30) not null,
    porcIva int(2) not null,
    categoria varchar(30) not null,
    estado int(1) not null
);
create table tb_producto_3(
	idProducto int(11) auto_increment primary key,
    nombre varchar(30) not null,
    cantidad int(10) not null,
    precioc double(10, 2) not null, 
    descripcion varchar(30) not null,
    preciov double(10, 2) not null,
    porcIva int(2) not null,
    categoria varchar(30) not null,
    estado int(1) not null
);
create table tb_ganancias(
	nombre varchar(30) not null,
    descripcion varchar(30) not null,
    categoria varchar(30) not null,
    ganancias double(10,2) not null
);
show tables;
insert into tb_usuario(nombre, apellido, usuario, password, telefono, estado) values("Pablo", "Martinez", "pablo", "1234", "0971907705", 1);
select * from tb_usuario;
select concat(nombre, " ", apellido) as Nombres, usuario, password from tb_usuario where usuario="pablo" and password="1234";
select usuario, password from tb_usuario where usuario="pablo" and password="1234";
SET GLOBAL time_zone = '-3:00';