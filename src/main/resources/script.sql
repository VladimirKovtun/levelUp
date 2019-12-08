-- create database book_store;

-- create table book
create table if not exists book
(
	id integer primary key,
-- varchar()
-- text
	isbn varchar(30) not null unique,
	name varchar(255) not null,
	year integer not null
);

insert into book values
	(1, '45-234-42-322', 'C/C++ Procedure programming', 2008);
insert into book (name, isbn, year, id) values
	('Bla-bla-bla', '43-456-4-644', 2013, 2),
	('Flash MX 2004', '53-532-3-534', 2004, 4);

select * from book
order by year desc, name asc;

update book set year = 2009
-- where id = 2;
where name = 'Bla-bla-bla';
-- where name like '%bla';

delete from book
where id = 4 and year = 2010;
-- where id = 5  or id = 4;
-- <>
-- where id not in (4, 5, 8, 9)
-- where id >= 50 and id <= 100;
-- where id between 50 and 100 or id > 300;

create table if not exists book_details (
	book_id integer primary key,
	pages_count integer,
	genre varchar,
	publisher varchar not null,
	constraint book_id_fkey
			foreign key (book_id) references book(id)
);

insert into book_details values
	(2, 366, null, 'Эксмо');

select * from book_details;

-- constraint <constraint_name> unique (<column_name>)
insert into book values
	(5, '4558-98-58-75', '7 навыков', 2018),
	(6, '534-534-42-23', 'Визуальные заметки', 2014),
	(7, '534-234-235-78', 'Самоучитель C++', 1998);

insert into book_details values
	(5, null, 'Супербестселлер', 'Москва'),
	(6, 230, 'Учебник', 'Москва');

select * from book b
inner join book_details bd on b.id = bd.book_id;


select b.* from book b
left join book_details bd on b.id = bd.book_id
where book_id is null;

select * from book_details bd
right join book b on b.id = bd.book_id;

create table if not exists publishers
(
	id serial primary key,
	name varchar not null unique
);

alter table book add column publisher_id integer;
alter table book add constraint publisher_id_fkey
	foreign key (publisher_id) references publishers(id);

insert into publishers (name) values
	('Москва');
update book set publisher_id = 1;
alter table book alter column publisher_id set not null;

alter table book_details drop column publisher;
