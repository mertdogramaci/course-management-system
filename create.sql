-- Drop all tables for being able to re-run this query
DROP TABLE IF EXISTS login_credentials;
DROP TABLE IF EXISTS contact_info;
DROP TABLE IF EXISTS submission;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS homework;
DROP TABLE IF EXISTS time_slot;
DROP TABLE IF EXISTS section;
DROP TABLE IF EXISTS instructor;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS faculty;



CREATE TABLE faculty (
    ID INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE department (
    ID INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    facultyID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (facultyID) REFERENCES faculty(ID)
);

CREATE TABLE users (
    ID INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    departmentID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE student (
    studentID INT NOT NULL,
    schoolEnrollmentDate DATE NOT NULL,
    semesterECTS INT,
    PRIMARY KEY (ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
) INHERITS (users);

CREATE TABLE instructor (
    PRIMARY KEY (ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
) INHERITS (users);

CREATE TABLE contact_info (
    ID INT NOT NULL,
    phone INT,
    email VARCHAR(255),
    address VARCHAR(255),
    userID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (userID) REFERENCES users(ID)
);

CREATE TABLE login_credentials(
    ID INT NOT NULL,
    -- username = int de olabilir ben instructor username adı.soyadı şeklinde olacak diye düşündüm
    username VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    userID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (userID) REFERENCES users(ID)
);

CREATE TABLE course(
    ID INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    ects INT NOT NULL,
    -- type için belki boolean gibi bir şey kullanılabilir
    type VARCHAR(255) NOT NULL,
    description TEXT,
    departmentID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE section(
    ID INT NOT NULL,
    -- semester için belki boolean gibi bir şey kullanılabilir veya int daha iyi bool yerine
    semester VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    classroomInfo TEXT, 
    quota INT NOT NULL,
    courseID INT NOT NULL,
    instructorID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (courseID) REFERENCES course(ID),
    FOREIGN KEY (instructorID) REFERENCES instructor(ID)
);

CREATE TABLE homework(
    ID INT NOT NULL,
    title TEXT NOT NULL,
    content BYTEA,
    issueDate DATE NOT NULL,
    dueDate DATE NOT NULL,
    sectionID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);

CREATE TABLE submission(
    ID INT NOT NULL,
    marks INT,
    content BYTEA,
    studentID INT NOT NULL,
    homeworkID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (studentID) REFERENCES student(ID),
    FOREIGN KEY (homeworkID) REFERENCES homework(ID)
);

CREATE TABLE time_slot(
    ID INT NOT NULL,
    -- semester için belki int gibi bir şey kullanılabilir
    day VARCHAR(255) NOT NULL,
    startTime TIMESTAMP NOT NULL,
    endTime TIMESTAMP NOT NULL,
    sectionID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);