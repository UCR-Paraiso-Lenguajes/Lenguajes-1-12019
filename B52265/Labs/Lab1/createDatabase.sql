create database Orbis_B52265_I_2019
use Orbis_B52265_I_2019

create table editorial(
id_editorial numeric(10) constraint editorial_pk primary key,
nombre varchar(50),
direccion varchar(50),
telefono varchar(50)
);

create table libro(
id_libro numeric(10) constraint libro_pk primary key,
titulo varchar(50),
ano smallint,
precio float,
id_editorial numeric(10),
constraint libro_editorial_fk foreign key (id_editorial) references editorial(id_editorial)
);

create table autor(
id_autor numeric(10) constraint autor_pk primary key,
nombre_autor varchar(40),
apellidos_autor varchar(40)
);

create table libro_autor(
id_libro numeric(10),
id_autor numeric(10),
constraint libro_autor_pk primary key (id_libro,id_autor),
constraint autor_libro_autor_fk foreign key (id_autor) references autor(id_autor),
constraint libro_libro_autor_fk foreign key (id_libro) references libro(id_libro)
);