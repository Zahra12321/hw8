create database bank;

create table login_info
(
    id       serial primary key not null,
    username varchar(10)        not null unique,
    password varchar(20)        not null
);

create table cards
(
    card_number varchar(16) primary key       not null unique,
    bank_name   varchar(20)                   not null,
    user_id     INTEGER references login_info not null,
    balance     int
);

create table transaction_log
(
    id            serial primary key                         not null,
    src_card_num  varchar(16) references cards (card_number) not null,
    dest_card_num varchar(16) references cards (card_number) not null,
    amount        int                                        not null,
    status        varchar(10)                                not null
);
