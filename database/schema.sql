create database bgg;

use bgg;

create table user(
user_id varchar(8) not null,
username varchar(20) not null, 
name varchar(20), 
constraint user_pk primary key (user_id)
); 

create table task(
task_id int not null auto_increment,
description varchar(255) not null, 
priority enum('1', '2', '3'),
due_date date, 
usertable_id varchar(8) not null, 
constraint task_pk primary key (task_id), 
constraint task_user_fk foreign key (usertable_id) references user(user_id)
); 

