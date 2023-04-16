DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS instructor;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    ID INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);


CREATE TABLE IF NOT EXISTS student (
    studentID INT NOT NULL,
    schoolEnrollmentDate DATE NOT NULL,
    semesterECTS INT
) INHERITS (users);

insert into student (ID, name, surname, studentID, schoolEnrollmentDate, semesterECTS) values (1, 'Mert', 'Doğramacı', 21946055, '21/03/2023', 0);
select * from student;
delete from student where id = 1;


CREATE TABLE IF NOT EXISTS instructor () INHERITS (users);