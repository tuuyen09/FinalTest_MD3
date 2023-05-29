create database final_test;
use final_test;
create table employee(
                         id int not null,
                         name varchar(200),
                         email varchar(200),
                         address varchar(200),
                         phone_number varchar(200),
                         salary float,
                         department varchar(200)
);
create table department(
                           d_id int,
                           d_name varchar(200),
                           e_id int,
                           foreign key(e_id) references employee(id)
);
insert into employee values
                         (1, 'Uyên','uyen@gmail.com', 'Hà Nội', '12345', 12000000, 'abc'),
                         (2, 'Dủa','dua@gmail.com', 'Bắc Ninh', '12234', 10000000, 'abc'),
                         (3, 'Sơn','son@gmail.com', 'Hà Nội', '123455', 10000000, 'abc');