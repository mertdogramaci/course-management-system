-- Drop all tables for being able to re-run this query
DROP TABLE IF EXISTS homework_has_submission;
DROP TABLE IF EXISTS homework_belongs_section;
DROP TABLE IF EXISTS section_has_time_slot;
DROP TABLE IF EXISTS section_belongs_course;
DROP TABLE IF EXISTS course_belongs_department;
DROP TABLE IF EXISTS course_requires_course;
DROP TABLE IF EXISTS faculty_has_department;
DROP TABLE IF EXISTS instructor_belongs_department;
DROP TABLE IF EXISTS instructor_advisor_student;
DROP TABLE IF EXISTS instructor_teaches_section;
DROP TABLE IF EXISTS student_has_submission
DROP TABLE IF EXISTS student_belongs_department;
DROP TABLE IF EXISTS student_enrolls_section;
DROP TABLE IF EXISTS user_has_login_credentials;
DROP TABLE IF EXISTS user_has_contact_info;
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



-- ENTITY TABLES

CREATE TABLE faculty (
    ID INT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE department (
    ID INT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    facultyID INT NOT NULL,
    FOREIGN KEY (facultyID) REFERENCES faculty(ID)
);

CREATE TABLE users (
    ID INT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    departmentID INT NOT NULL,
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
    ID INT PRIMARY KEY NOT NULL,
    phone INT,
    email VARCHAR(255),
    address VARCHAR(255),
    userID INT NOT NULL,
    FOREIGN KEY (userID) REFERENCES users(ID)
);

CREATE TABLE login_credentials(
    ID INT PRIMARY KEY NOT NULL,
    username VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    userID INT NOT NULL,
    FOREIGN KEY (userID) REFERENCES users(ID)
);

CREATE TABLE course(
    ID INT PRIMARY KEY NOT NULL,
    title VARCHAR(255) NOT NULL,
    ects INT NOT NULL,
    -- type için belki boolean gibi bir şey kullanılabilir  // type yerine isCompulsory yazabiliriz
    type VARCHAR(255) NOT NULL,
    description TEXT,
    departmentID INT NOT NULL,
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE section(
    ID INT PRIMARY KEY NOT NULL,
    semester BOOLEAN NOT NULL,
    year INT NOT NULL,
    classroomInfo TEXT,
    quota INT NOT NULL,
    courseID INT NOT NULL,
    instructorID INT NOT NULL,
    FOREIGN KEY (courseID) REFERENCES course(ID),
    FOREIGN KEY (instructorID) REFERENCES instructor(ID)
);

CREATE TABLE homework(
    ID INT PRIMARY KEY NOT NULL,
    title TEXT NOT NULL,
    content BYTEA,
    issueDate DATE NOT NULL,
    dueDate DATE NOT NULL,
    sectionID INT NOT NULL,
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);

CREATE TABLE submission(
    ID INT PRIMARY KEY NOT NULL,
    marks INT,
    content BYTEA,
    studentID INT NOT NULL,
    homeworkID INT NOT NULL,
    FOREIGN KEY (studentID) REFERENCES student(ID),
    FOREIGN KEY (homeworkID) REFERENCES homework(ID)
);

CREATE TABLE time_slot(
    ID INT PRIMARY KEY NOT NULL,
    -- day için belki int gibi bir şey kullanılabilir
    day VARCHAR(255) NOT NULL,
    startTime TIMESTAMP NOT NULL,
    endTime TIMESTAMP NOT NULL,
    sectionID INT NOT NULL,
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);



-- RELATION TABLES


CREATE TABLE user_has_contact_info (
    userID INT NOT NULL,
    contact_infoID INT NOT NULL,
    PRIMARY KEY (userID, contact_infoID),
    FOREIGN KEY (userID) REFERENCES users(ID)
    FOREIGN KEY (contact_infoID) REFERENCES contact_info(ID)
);

CREATE TABLE user_has_login_credentials(
    loginCredentialsID INT NOT NULL,
    userID INT NOT NULL,
    PRIMARY KEY (loginCredentialsID, userID),
    FOREIGN KEY (userID) REFERENCES users(ID),
    FOREIGN KEY (login_credentialsID) REFERENCES login_credentials(ID)
);

CREATE TABLE student_enrolls_section(
    studentID INT NOT NULL,
    sectionID INT NOT NULL,
    grade INT,
    nonAttendanceCount INT,
    isApproved BOOLEAN,
    PRIMARY KEY (studentID, sectionID),
    FOREIGN KEY (studentID) REFERENCES student(ID),
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);

CREATE TABLE student_belongs_department(
    studentID INT NOT NULL,
    departmentID INT NOT NULL,
    PRIMARY KEY (studentID, departmentID),
    FOREIGN KEY (studentID) REFERENCES student(ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE student_has_submission(
    studentID INT NOT NULL,
    submissionID INT NOT NULL,
    PRIMARY KEY (studentID, submissionID),
    FOREIGN KEY (studentID) REFERENCES student(ID),
    FOREIGN KEY (submissionID) REFERENCES submission(ID)
);

CREATE TABLE instructor_teaches_section(
    instructorID INT NOT NULL,
    sectionID INT NOT NULL,
    PRIMARY KEY (instructorID, sectionID),
    FOREIGN KEY (instructorID) REFERENCES instructor(ID),
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);

CREATE TABLE instructor_advisor_student(
    instructorID INT NOT NULL,
    studentID INT NOT NULL,
    PRIMARY KEY (instructorID, studentID),
    FOREIGN KEY (instructorID) REFERENCES instructor(ID),
    FOREIGN KEY (studentID) REFERENCES student(ID)
);

CREATE TABLE instructor_belongs_department(
    instructorID INT NOT NULL,
    departmentID INT NOT NULL,
    PRIMARY KEY (instructorID, departmentID),
    FOREIGN KEY (instructorID) REFERENCES instructor(ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE faculty_has_department(
    facultyID INT NOT NULL,
    departmentID INT NOT NULL,
    PRIMARY KEY (facultyID, departmentID),
    FOREIGN KEY (facultyID) REFERENCES faculty(ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE course_requires_course(
    prereqCourseID INT NOT NULL,
    mainCourseID INT NOT NULL,
    PRIMARY KEY (prereqCourseID, mainCourseID),
    FOREIGN KEY (prereqCourseID) REFERENCES course(ID),
    FOREIGN KEY (mainCourseID) REFERENCES course(ID)
);

CREATE TABLE course_belongs_department(
    courseID INT NOT NULL,
    departmentID INT NOT NULL,
    PRIMARY KEY (courseID, departmentID),
    FOREIGN KEY (courseID) REFERENCES course(ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE section_belongs_course(
    sectionID INT NOT NULL,
    courseID INT NOT NULL,
    PRIMARY KEY (sectionID, courseID),
    FOREIGN KEY (sectionID) REFERENCES section(ID),
    FOREIGN KEY (courseID) REFERENCES course(ID)
);

CREATE TABLE section_has_time_slot(
    sectionID INT NOT NULL,
    time_slotID INT NOT NULL,
    PRIMARY KEY (sectionID, time_slotID),
    FOREIGN KEY (sectionID) REFERENCES section(ID),
    FOREIGN KEY (time_slotID) REFERENCES time_slot(ID)
);

CREATE TABLE homework_belongs_section(
    homeworkID INT NOT NULL,
    sectionID INT NOT NULL,
    PRIMARY KEY (homeworkID, sectionID),
    FOREIGN KEY (homeworkID) REFERENCES homework(ID),
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);

CREATE TABLE homework_has_submission(
    homeworkID INT NOT NULL,
    submissionID INT NOT NULL,
    PRIMARY KEY (homeworkID, submissionID),
    FOREIGN KEY (homeworkID) REFERENCES homework(ID),
    FOREIGN KEY (submissionID) REFERENCES submission(ID)
);