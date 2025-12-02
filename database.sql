create database bank;

create table login_info(
    id serial not null,
    username varchar(10) not null unique,
    password varchar(20) not null
);

