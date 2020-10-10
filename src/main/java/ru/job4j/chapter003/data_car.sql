-- 1 Создать структур данных в базе. Таблицы. Кузов. Двигатель, Коробка передач.
create database dataCar_db;

create table body(
  id serial primary key,
  name varchar(50)
);

create table engine(
  id serial primary key,
  name varchar(50)
);

create table box(
  id serial primary key,
  name varchar(50)
);

-- 2 Создать структуру Машина. Машина не может существовать без данных из п.1.
create table car(
  id serial primary key,
  name varchar(50),
  body_id int references body(id),
  engine_id int references engine(id),
  boz_id int references box(id)
);

-- 3 Заполнить таблицы через insert.
insert into body(name) values ('XV10');
insert into body(name) values ('XV20');
insert into body(name) values ('XV30');
insert into body(name) values ('xv40');
insert into body(name) values ('xv50');

insert into engine(name) values ('2AZ-FE');
insert into engine(name) values ('2GR-FE');
insert into engine(name) values ('1MZ-FE');


insert into box(name) values ('AKPP');
insert into box(name) values ('MKPP');
insert into box(name) values ('robot');

insert into car(name, body_id, engine_id, boz_id) VALUES ('toyota camry', 4, 1, 1);
insert into car(name, body_id, engine_id, boz_id) VALUES ('toyota camry', 4, 1, 2);
insert into car(name, body_id, engine_id, boz_id) VALUES ('toyota camry', 4, 2, 1);
insert into car(name, body_id, engine_id, boz_id) VALUES ('toyota camry', 4, 2, 2);


-- 3. Вывести список всех машин и все привязанные к ним детали.
select * from car inner join body b on car.body_id = b.id
                  inner join engine e on car.engine_id = e.id
                  inner join box b2 on car.boz_id = b2.id;


-- 4. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select * from car right join body e on car.body_id = e.id where car.id isnull;
select * from car right join engine e on car.engine_id = e.id where car.id isnull;
select * from car right join box e on car.engine_id = e.id where car.id isnull;

