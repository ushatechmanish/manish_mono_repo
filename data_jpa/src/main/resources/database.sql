create database jpa;

use jpa;

create table student
(
    student_id varchar(50) PRIMARY KEY NOT NULL ,
    student_name varchar(50),
    student_mobile int,
    student_address varchar(50)
);