create user testeval WITH SUPERUSER PASSWORD '123';
create database testeval WITH OWNER testeval;

create table personne
(
    id   bigserial
        primary key,
    name varchar(250) not null,
    age  integer      not null
);

alter table personne
    owner to testeval;

create table users
(
    id        bigserial
        primary key,
    firstname varchar(250) not null,
    username  varchar(250) not null,
    mail      varchar(250) not null,
    password  varchar(250) not null
);

alter table users
    owner to testeval;

