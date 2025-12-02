create database bank;

create table login_info
(
    id       serial primary key not null,
    username varchar(10)        not null unique,
    password varchar(20)        not null
);

create table cards
(
    card_number INTEGER primary key not null unique,
    bank_name   varchar(20)         not null,
    user_id     INTEGER references login_info
);