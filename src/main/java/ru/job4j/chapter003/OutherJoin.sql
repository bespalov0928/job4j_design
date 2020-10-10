--1. Создать таблицы и заполнить их начальными данными
create database office_bd;

create table departments (
  id serial primary key,
  name varchar(50)
);

create table emploees(
  id serial primary key,
  name varchar(50),
  departments_id int references departments(id)
);


insert into departments(name) values ('moscow');
insert into departments(name) values ('yfa');
insert into departments(name) values ('kazan');
select * from departments;


insert into emploees(name, departments_id) values ('ivanov', 1);
insert into emploees(name, departments_id) VALUES ('petrov', 2);
insert into emploees(name, departments_id) VALUES ('bespalov', 3);
insert into emploees(name) VALUES ('eskina');
select * from emploees;


--2. Выполнить запросы с left, rigth, full, cross соединениями
select * from emploees e left join departments d2 on e.departments_id = d2.id;
select * from emploees e right join departments d2 on e.departments_id = d2.id;
select * from emploees e full join departments d2 on e.departments_id = d2.id;
select * from emploees e cross join departments d2;


--3. Используя left join найти работников, которые не относятся ни к одну из департаментов
select * from emploees where departments_id isnull ;


--4. Используя left и right join написать запросы, которые давали бы одинаковый результат.
select * from emploees e left join departments d2 on e.departments_id = d2.id;
select * from departments d2 right join emploees e on e.departments_id = d2.id;


-- 5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары
create table teens(
  id serial primary key,
  name character(50),
  gender character(1)
 );


insert into teens(name, gender) VALUES ('ivanov', 'm');
insert into teens(name, gender) VALUES ('petrov', 'm');
insert into teens(name, gender) VALUES ('bespalov', 'm');
insert into teens(name, gender) VALUES ('eskina', 'w');
select * from teens;

select distinct d1.name, d2.gender from emploees d1 cross join teens d2 group by d1.name, gender;