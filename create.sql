CREATE DATABASE IF NOT EXISTS course_management_system;
USE course_management_system;

CREATE TABLE IF NOT EXISTS user (
    ID INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

insert into user (ID, name, surname) values (1, 'Mert', 'Doğramacı');
select * from user;