create database db_oficina_java;

use db_oficina_java;

create table usuario (

id integer not null primary key auto_increment,
nome_usuario varchar(60) not null,
email_usuario varchar (60) not null
);