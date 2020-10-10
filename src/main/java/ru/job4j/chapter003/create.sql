create database items_db;

create table Rules(
  id serial primary key,
  name varchar (50)
);

create table Roles (
  id serial primary key,
  name varchar (50)
);

create table RolesRules(
  id serial primary key,
  role_id int references Roles(id),
  rule_id int references Rules(id)
);

create table Users(
  id serial primary key,
  name varchar (50),
  role_id int references Roles(id)
);

create table Category(
  id serial primary key,
  name varchar(50)
);

create table State(
  id serial primary key,
  name varchar(50)
);

create table Items(
  id serial primary key,
  name varchar(50),
  user_is int references Users(id),
  category_id int references Category(id),
  state_id int references State(id)
);

create table Attachs(
  id serial primary key,
  name varchar(50),
  item_id int references Items(id)

);

create table Comments(
  id serial primary key,
  name varchar(200),
  item_id int references Items(id)
);


insert into Rules (name)
values ('read');
insert into Rules (name)
values ('admin');

insert into Roles (name)
values ('docror');
insert into Roles (name)
values ('programmer');

insert into RolesRules (role_id, rule_id)
values (1, 1);
insert into RolesRules (role_id, rule_id)
values (2, 2);

insert into Users (name, role_id)
values ('ivanov', '1');
insert into Users (name, role_id)
values ('petrov', '2');
select *
from Users;

insert into Category (name)
values ('low');
insert into Category (name)
values ('hight');
select *
from Category;

insert into State (name)
values ('inwork');
insert into State (name)
values ('finish');
select *
from State;

insert into Items (name, user_is, category_id, state_id)
values ('помыть руки', 1, 1, 1);
select *
from Items;

insert into Attachs (name, item_id)
values ('fail', 1);
select *
from Attachs;

insert into Comments (name, item_id)
values ('с мылом', 1);
select *
from Comments;