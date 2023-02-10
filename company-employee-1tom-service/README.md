
create table if not exists ikon
(
id bigint auto_increment
primary key,
first_name  varchar(225) null,
last_name   varchar(225) null,
money double null
);

create table if not exists ikon_child
(
id bigint auto_increment
primary key,
name  varchar(225) null,
FOREIGN KEY (ikon_id) REFERENCES ikon(id),
ikon_id bigint

);

INSERT INTO ikon (first_name, last_name, money)
VALUES
('fajri', 'illahi', 1000.0),
('Aditya', 'fathur', 2000.0),
('gokil', 'ballado', 3000.0);

INSERT INTO ikon_child (name, ikon_id)
VALUES
('joko', 1),
('wido', 2),
('do', 1);

select * from ikon i where i.last_name like '%ll%' limit 2 offset 1

select sum(i.money) as total
from ikon i;

select count(i.money) as total
from ikon i;

select first_name, sum(i.money) as total
from ikon i group by i.first_name
order by i.first_name;


select * from  ikon i join ikon_child ic on i.id = ic.ikon_id