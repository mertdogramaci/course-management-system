-- Drop all tables for being able to re-run this query
DROP TABLE IF EXISTS contact_info;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS instructor;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS faculty;
DROP TABLE IF EXISTS department;


CREATE TABLE faculty (
    ID INT NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (ID)
);

CREATE TABLE users (
    ID INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE student (
    studentID INT NOT NULL,
    schoolEnrollmentDate DATE NOT NULL,
    semesterECTS INT,
    PRIMARY KEY (ID)
) INHERITS (users);

CREATE TABLE instructor (
    PRIMARY KEY (ID)
) INHERITS (users);

CREATE TABLE contact_info (
    ID INT NOT NULL,
    phone INT,
    email VARCHAR(255),
    address VARCHAR(255),
    userID int,
    PRIMARY KEY (ID),
    FOREIGN KEY (userID) REFERENCES users(ID)
);

SELECT * from contact_info;