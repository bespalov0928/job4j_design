create database spammer_db;

create table email(
  id serial primary key,
  mail varchar(255),
  name varchar(255)
)