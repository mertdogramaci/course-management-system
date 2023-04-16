CREATE TABLE IF NOT EXISTS users (
    ID INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

insert into users (ID, name, surname) values (1, 'Mert', 'Doğramacı');
select * from users;
delete from users where id = 1;