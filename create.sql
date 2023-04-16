CREATE TABLE IF NOT EXISTS users (
    ID INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS student (
    studentID INT NOT NULL
) INHERITS (users);

insert into student (ID, name, surname, studentID) values (1, 'Mert', 'Doğramacı', 21946055);
select * from student;
delete from student where id = 1;