-- Drop all tables for being able to re-run this query
DROP VIEW IF EXISTS student_grades;
DROP VIEW IF EXISTS instructor_sections;
DROP VIEW IF EXISTS department_course_stats;
DROP VIEW IF EXISTS student_submission_stats;
DROP VIEW IF EXISTS department_section_stats;
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
DROP TABLE IF EXISTS student_has_submission;
DROP TABLE IF EXISTS student_belongs_department;
DROP TABLE IF EXISTS student_enrolls_section;
DROP TABLE IF EXISTS user_has_contact_info;
DROP TABLE IF EXISTS student_has_login_credentials;
DROP TABLE IF EXISTS student_has_contact_info;
DROP TABLE IF EXISTS instructor_has_login_credentials;
DROP TABLE IF EXISTS instructor_has_contact_info;
DROP TABLE IF EXISTS student_login_credentials;
DROP TABLE IF EXISTS instructor_login_credentials;
DROP TABLE IF EXISTS student_contact_info;
DROP TABLE IF EXISTS instructor_contact_info;
DROP TABLE IF EXISTS submission;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS homework;
DROP TABLE IF EXISTS time_slot;
DROP TABLE IF EXISTS section;
DROP TABLE IF EXISTS instructor;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS department cascade;
DROP TABLE IF EXISTS faculty cascade;

-- Drop all sequnces for being able to re-run this query
-- Delete this queries if the database is already empty
DROP SEQUENCE student_seq;
DROP SEQUENCE instructor_seq;
DROP SEQUENCE student_contact_info_seq;
DROP SEQUENCE instructor_contact_info_seq;
DROP SEQUENCE student_login_credentials_seq;
DROP SEQUENCE instructor_login_credentials_seq;
DROP SEQUENCE faculty_seq;
DROP SEQUENCE department_seq;
DROP SEQUENCE course_seq;
DROP SEQUENCE section_seq;
DROP SEQUENCE homework_seq;
DROP SEQUENCE submission_seq;
DROP SEQUENCE time_slot_seq;

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

CREATE TABLE student (
    ID INT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    departmentID INT NOT NULL,
    studentID BIGINT NOT NULL,
    schoolEnrollmentDate DATE NOT NULL,
    semesterECTS INT DEFAULT 0,
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE instructor (
    ID INT PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    departmentID INT NOT NULL,
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE student_contact_info (
    ID INT PRIMARY KEY NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(255),
    address TEXT,
    studentID INT NOT NULL,
    FOREIGN KEY (studentID) REFERENCES student(ID)
);

CREATE TABLE student_login_credentials (
    ID INT PRIMARY KEY NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    studentID INT NOT NULL,
    FOREIGN KEY (studentID) REFERENCES student(ID)
);

CREATE TABLE instructor_login_credentials (
    ID INT PRIMARY KEY NOT NULL,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255) NOT NULL,
    instructorID INT NOT NULL,
    FOREIGN KEY (instructorID) REFERENCES instructor(ID)
);

CREATE TABLE instructor_contact_info (
    ID INT PRIMARY KEY NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(255),
    address TEXT,
    instructorID INT NOT NULL,
    FOREIGN KEY (instructorID) REFERENCES instructor(ID)
);

CREATE TABLE course (
    ID INT PRIMARY KEY NOT NULL,
    title VARCHAR(255) NOT NULL,
    ects INT NOT NULL,
    isCompulsory BOOLEAN NOT NULL,
    description TEXT,
    departmentID INT NOT NULL,
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE section (
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

CREATE TABLE homework (
    ID INT PRIMARY KEY NOT NULL,
    title TEXT NOT NULL,
    content BYTEA,
    issueDate DATE NOT NULL,
    dueDate DATE NOT NULL,
    sectionID INT NOT NULL,
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);

CREATE TABLE submission (
    ID INT PRIMARY KEY NOT NULL,
    marks INT,
    content BYTEA,
    studentID INT NOT NULL,
    homeworkID INT NOT NULL,
    FOREIGN KEY (studentID) REFERENCES student(ID),
    FOREIGN KEY (homeworkID) REFERENCES homework(ID)
);

CREATE TABLE time_slot (
    ID INT PRIMARY KEY NOT NULL,
    day INT NOT NULL,
    startTime TIMESTAMP NOT NULL,
    endTime TIMESTAMP NOT NULL,
    sectionID INT NOT NULL,
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);



-- RELATION TABLES

CREATE TABLE student_has_contact_info (
    studentID INT NOT NULL,
    student_contact_infoID INT NOT NULL,
    PRIMARY KEY (studentID, student_contact_infoID),
    FOREIGN KEY (studentID) REFERENCES student(ID),
    FOREIGN KEY (student_contact_infoID) REFERENCES student_contact_info(ID)
);

CREATE TABLE student_has_login_credentials (
    student_login_credentialsID INT NOT NULL,
    studentID INT NOT NULL,
    PRIMARY KEY (student_login_credentialsID, studentID),
    FOREIGN KEY (studentID) REFERENCES student(ID),
    FOREIGN KEY (student_login_credentialsID) REFERENCES student_login_credentials(ID)
);

CREATE TABLE instructor_has_contact_info (
    instructorID INT NOT NULL,
    instructor_contact_infoID INT NOT NULL,
    PRIMARY KEY (instructorID, instructor_contact_infoID),
    FOREIGN KEY (instructorID) REFERENCES instructor(ID),
    FOREIGN KEY (instructor_contact_infoID) REFERENCES instructor_contact_info(ID)
);

CREATE TABLE instructor_has_login_credentials (
    instructor_login_credentialsID INT NOT NULL,
    instructorID INT NOT NULL,
    PRIMARY KEY (instructor_login_credentialsID, instructorID),
    FOREIGN KEY (instructorID) REFERENCES instructor(ID),
    FOREIGN KEY (instructor_login_credentialsID) REFERENCES instructor_login_credentials(ID)
);

CREATE TABLE student_enrolls_section (
    studentID INT NOT NULL,
    sectionID INT NOT NULL,
    grade INT,
    nonAttendanceCount INT DEFAULT 0,
    isApproved BOOLEAN,
    PRIMARY KEY (studentID, sectionID),
    FOREIGN KEY (studentID) REFERENCES student(ID),
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);

CREATE TABLE student_belongs_department (
    studentID INT NOT NULL,
    departmentID INT NOT NULL,
    PRIMARY KEY (studentID, departmentID),
    FOREIGN KEY (studentID) REFERENCES student(ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE student_has_submission (
    studentID INT NOT NULL,
    submissionID INT NOT NULL,
    PRIMARY KEY (studentID, submissionID),
    FOREIGN KEY (studentID) REFERENCES student(ID),
    FOREIGN KEY (submissionID) REFERENCES submission(ID)
);

CREATE TABLE instructor_teaches_section (
    instructorID INT NOT NULL,
    sectionID INT NOT NULL,
    PRIMARY KEY (instructorID, sectionID),
    FOREIGN KEY (instructorID) REFERENCES instructor(ID),
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);

CREATE TABLE instructor_advisor_student (
    instructorID INT NOT NULL,
    studentID INT NOT NULL,
    PRIMARY KEY (instructorID, studentID),
    FOREIGN KEY (instructorID) REFERENCES instructor(ID),
    FOREIGN KEY (studentID) REFERENCES student(ID)
);

CREATE TABLE instructor_belongs_department (
    instructorID INT NOT NULL,
    departmentID INT NOT NULL,
    PRIMARY KEY (instructorID, departmentID),
    FOREIGN KEY (instructorID) REFERENCES instructor(ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE faculty_has_department (
    facultyID INT NOT NULL,
    departmentID INT NOT NULL,
    PRIMARY KEY (facultyID, departmentID),
    FOREIGN KEY (facultyID) REFERENCES faculty(ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE course_requires_course (
    prereqCourseID INT NOT NULL,
    mainCourseID INT NOT NULL,
    PRIMARY KEY (prereqCourseID, mainCourseID),
    FOREIGN KEY (prereqCourseID) REFERENCES course(ID),
    FOREIGN KEY (mainCourseID) REFERENCES course(ID)
);

CREATE TABLE course_belongs_department (
    courseID INT NOT NULL,
    departmentID INT NOT NULL,
    PRIMARY KEY (courseID, departmentID),
    FOREIGN KEY (courseID) REFERENCES course(ID),
    FOREIGN KEY (departmentID) REFERENCES department(ID)
);

CREATE TABLE section_belongs_course (
    sectionID INT NOT NULL,
    courseID INT NOT NULL,
    PRIMARY KEY (sectionID, courseID),
    FOREIGN KEY (sectionID) REFERENCES section(ID),
    FOREIGN KEY (courseID) REFERENCES course(ID)
);

CREATE TABLE section_has_time_slot (
    sectionID INT NOT NULL,
    time_slotID INT NOT NULL,
    PRIMARY KEY (sectionID, time_slotID),
    FOREIGN KEY (sectionID) REFERENCES section(ID),
    FOREIGN KEY (time_slotID) REFERENCES time_slot(ID)
);

CREATE TABLE homework_belongs_section (
    homeworkID INT NOT NULL,
    sectionID INT NOT NULL,
    PRIMARY KEY (homeworkID, sectionID),
    FOREIGN KEY (homeworkID) REFERENCES homework(ID),
    FOREIGN KEY (sectionID) REFERENCES section(ID)
);

CREATE TABLE homework_has_submission (
    homeworkID INT NOT NULL,
    submissionID INT NOT NULL,
    PRIMARY KEY (homeworkID, submissionID),
    FOREIGN KEY (homeworkID) REFERENCES homework(ID),
    FOREIGN KEY (submissionID) REFERENCES submission(ID)
);



-- Create sequences and triggers for automatically incrementing primary key fields in your tables

CREATE SEQUENCE student_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE instructor_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE student_contact_info_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE instructor_contact_info_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE student_login_credentials_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE instructor_login_credentials_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE faculty_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE department_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE course_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE section_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE homework_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE submission_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE time_slot_seq START WITH 1 INCREMENT BY 1;



CREATE OR REPLACE FUNCTION set_student_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('student_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_student_id
    BEFORE INSERT ON student
    FOR EACH ROW
    EXECUTE FUNCTION set_student_id();


CREATE OR REPLACE FUNCTION set_instructor_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('instructor_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_instructor_id
    BEFORE INSERT ON instructor
    FOR EACH ROW
    EXECUTE FUNCTION set_instructor_id();


CREATE OR REPLACE FUNCTION set_student_contact_info_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('student_contact_info_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_student_contact_info_id
    BEFORE INSERT ON student_contact_info
    FOR EACH ROW
    EXECUTE FUNCTION set_student_contact_info_id();


CREATE OR REPLACE FUNCTION set_student_login_credentials_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('student_login_credentials_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_student_login_credentials_id
    BEFORE INSERT ON student_login_credentials
    FOR EACH ROW
    EXECUTE FUNCTION set_student_login_credentials_id();


CREATE OR REPLACE FUNCTION set_instructor_contact_info_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('instructor_contact_info_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_instructor_contact_info_id
    BEFORE INSERT ON instructor_contact_info
    FOR EACH ROW
    EXECUTE FUNCTION set_instructor_contact_info_id();


CREATE OR REPLACE FUNCTION set_instructor_login_credentials_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('instructor_login_credentials_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_instructor_login_credentials_id
    BEFORE INSERT ON instructor_login_credentials
    FOR EACH ROW
    EXECUTE FUNCTION set_instructor_login_credentials_id();


CREATE OR REPLACE FUNCTION set_faculty_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('faculty_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_faculty_id
    BEFORE INSERT ON faculty
    FOR EACH ROW
    EXECUTE FUNCTION set_faculty_id();


CREATE OR REPLACE FUNCTION set_department_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('department_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_department_id
    BEFORE INSERT ON department
    FOR EACH ROW
    EXECUTE FUNCTION set_department_id();


CREATE OR REPLACE FUNCTION set_course_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('course_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_course_id
    BEFORE INSERT ON course
    FOR EACH ROW
    EXECUTE FUNCTION set_course_id();


CREATE OR REPLACE FUNCTION set_section_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('section_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_section_id
    BEFORE INSERT ON section
    FOR EACH ROW
    EXECUTE FUNCTION set_section_id();


CREATE OR REPLACE FUNCTION set_homework_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('homework_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_homework_id
    BEFORE INSERT ON homework
    FOR EACH ROW
    EXECUTE FUNCTION set_homework_id();


CREATE OR REPLACE FUNCTION set_submission_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('submission_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_submission_id
    BEFORE INSERT ON submission
    FOR EACH ROW
    EXECUTE FUNCTION set_submission_id();


CREATE OR REPLACE FUNCTION set_time_slot_id() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ID IS NULL THEN
        NEW.ID := nextval('time_slot_seq');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_time_slot_id
    BEFORE INSERT ON time_slot
    FOR EACH ROW
    EXECUTE FUNCTION set_time_slot_id();



-- Generate insert, update and delete stored procedures for all tables in your database.
-- Stored procedures for entities

CREATE OR REPLACE PROCEDURE insert_faculty(
    in_name VARCHAR(255)
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO faculty (name)
    VALUES (in_name);
END;
$$;

CREATE OR REPLACE PROCEDURE update_faculty(
    in_id INT,
    in_name VARCHAR(255)
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE faculty
    SET name = in_name
    WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_faculty(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM faculty_has_department WHERE facultyID = id_val;
    DELETE FROM faculty WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_department(
    in_name VARCHAR(255),
    in_faculty_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  INSERT INTO department (name, facultyID)
  VALUES (in_name, in_faculty_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_department(
    in_id INT,
    in_name VARCHAR(255),
    in_faculty_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  UPDATE department
  SET name = in_name, facultyID = in_faculty_id
  WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_department(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM student_belongs_department WHERE departmentID = id_val;
    DELETE FROM instructor_belongs_department WHERE departmentID = id_val;
    DELETE FROM course_belongs_department WHERE departmentID = id_val;
    DELETE FROM faculty_has_department WHERE departmentID = id_val;
    DELETE FROM department WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_student(
    in_name VARCHAR(255),
    in_surname VARCHAR(255),
    in_student_id BIGINT,
    in_school_enrollment_date DATE,
    in_semester_ects INT,
    in_department_id INT
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO student (name, surname, studentID, schoolEnrollmentDate, semesterECTS, departmentID)
    VALUES (in_name, in_surname, in_student_id, in_school_enrollment_date, in_semester_ects, in_department_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_student(
    in_id INT,
    in_name VARCHAR(255),
    in_surname VARCHAR(255),
    in_student_id BIGINT,
    in_school_enrollment_date DATE,
    in_semester_ects INT,
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE Student
    SET StudentID = in_student_id,
    SchoolEnrollmentDate = in_school_enrollment_date,
    emesterECTS = in_semester_ects,
    departmentID = in_department_id
    WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_student(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM student_belongs_department WHERE studentID = id_val;
    DELETE FROM student_enrolls_section WHERE studentID = id_val;
    DELETE FROM student_has_contact_info WHERE studentID = id_val;
    DELETE FROM student_has_login_credentials WHERE studentID = id_val;
    DELETE FROM student_has_submission WHERE studentID = id_val;
    DELETE FROM student WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_instructor(
    in_name VARCHAR(255),
    in_surname VARCHAR(255),
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO instructor (name, surname, departmentID)
    VALUES (in_name, in_surname, in_department_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_instructor(
    in_id INT,
    in_name VARCHAR(255),
    in_surname VARCHAR(255),
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE instructor
    SET departmentID = in_department_id
    WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_instructor(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM instructor_advisor_student WHERE instructorID = id_val;
    DELETE FROM instructor_belongs_department WHERE instructorID = id_val;
    DELETE FROM instructor_has_contact_info WHERE instructorID = id_val;
    DELETE FROM instructor_has_login_credentials WHERE instructorID = id_val;
    DELETE FROM instructor_teaches_section WHERE instructorID = id_val;
    DELETE FROM instructor WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_student_contact_info(
    in_phone VARCHAR(15),
    in_email VARCHAR(255),
    in_address TEXT,
    in_student_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  INSERT INTO student_contact_info (phone, email, address, studentID)
  VALUES (in_phone, in_email, in_address, in_student_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_student_contact_info(
    in_id INT,
    in_phone VARCHAR(15),
    in_email VARCHAR(255),
    in_address TEXT,
    in_student_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE student_contact_info
    SET phone = in_phone,
        email = in_email,
        address = in_address,
        studentID = in_student_id
    WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_student_contact_info(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM student_has_contact_info WHERE student_contact_infoID = id_val;
    DELETE FROM student_contact_info WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_instructor_contact_info(
    in_phone VARCHAR(15),
    in_email VARCHAR(255),
    in_address TEXT,
    in_instructor_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  INSERT INTO instructor_contact_info (phone, email, address, instructorID)
  VALUES (in_phone, in_email, in_address, in_instructor_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_instructor_contact_info(
    in_id INT,
    in_phone VARCHAR(15),
    in_email VARCHAR(255),
    in_address TEXT,
    in_instructor_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE instructor_contact_info
    SET phone = in_phone,
        email = in_email,
        address = in_address,
        instructorID = in_instructor_id
    WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_instructor_contact_info(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM instructor_has_contact_info WHERE instructor_contact_infoID = id_val;
    DELETE FROM instructor_contact_info WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_student_login_credentials(
    in_username VARCHAR(255),
    in_password VARCHAR(255),
    in_student_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  INSERT INTO student_login_credentials (username, password, studentID)
  VALUES (in_username, in_password, in_student_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_student_login_credentials(
    in_username VARCHAR(255),
    in_password VARCHAR(255),
    in_student_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  UPDATE student_login_credentials
  SET username = in_username,
        password = in_password,
        studentID = in_student_id
  WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_student_login_credentials(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM student_has_login_credentials WHERE student_login_credentialsID = id_val;
    DELETE FROM student_login_credentials WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_instructor_login_credentials(
    in_username VARCHAR(255),
    in_password VARCHAR(255),
    in_instructor_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  INSERT INTO instructor_login_credentials (username, password, instructorID)
  VALUES (in_username, in_password, in_instructor_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_instructor_login_credentials(
    in_username VARCHAR(255),
    in_password VARCHAR(255),
    in_instructor_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  UPDATE instructor_login_credentials
  SET username = in_username,
        password = in_password,
        instructorID = in_instructor_id
  WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_instructor_login_credentials(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM instructor_has_login_credentials WHERE instructor_login_credentialsID = id_val;
    DELETE FROM instructor_login_credentials WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_course(
    in_title VARCHAR(255),
    in_ects INT,
    in_isCompulsory BOOLEAN,
    in_description TEXT,
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  INSERT INTO course (title, ects, isCompulsory, description, departmentID)
  VALUES (in_title, in_ects, in_isCompulsory, in_description, in_department_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_course(
    in_title VARCHAR(255),
    in_ects INT,
    in_isCompulsory BOOLEAN,
    in_description TEXT,
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE course
    SET title = in_title,
        ects = in_ects,
        isCompulsory = in_isCompulsory,
        description = in_description,
        departmentID = in_department_id
    WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_course(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM course_belongs_department WHERE courseID = id_val;
    DELETE FROM course_requires_course WHERE courseID = id_val;
    DELETE FROM section_belongs_course WHERE courseID = id_val;
    DELETE FROM course WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_section(
    in_semester BOOLEAN,
    in_year INT,
    in_classroomInfo TEXT,
    in_quota INT,
    in_course_id INT,
    in_instructor_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  INSERT INTO section (semester, year, classroomInfo, quota, courseID, instructorID)
  VALUES (in_semester, in_year, in_classroomInfo, in_quota, in_course_id, in_instructor_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_section(
    in_semester BOOLEAN,
    in_year INT,
    in_classroomInfo TEXT,
    in_quota INT,
    in_course_id INT,
    in_instructor_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE section
    SET semester = in_semester,
        year = in_year,
        classroomInfo = in_classroomInfo,
        quota = in_quota,
        courseID = in_course_id,
        instructorID = in_instructor_id
    WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_section(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM section_belongs_course WHERE sectionID = id_val;
    DELETE FROM section_has_time_slot WHERE sectionID = id_val;
    DELETE FROM student_enrolls_section WHERE sectionID = id_val;
    DELETE FROM instructor_teaches_section WHERE sectionID = id_val;
    DELETE FROM homework_belongs_section WHERE sectionID = id_val;
    DELETE FROM section WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_homework(
    in_title TEXT,
    in_content BYTEA,
    in_issueDate DATE,
    in_dueDate DATE,
    in_section_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  INSERT INTO homework (title, content, issueDate, dueDate, sectionID)
  VALUES (in_title, in_content, in_issueDate, in_dueDate, in_section_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_homework(
    in_title TEXT,
    in_content BYTEA,
    in_issueDate DATE,
    in_dueDate DATE,
    in_section_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE homework
    SET title = in_title,
        content = in_content,
        issueDate = in_issueDate,
        dueDate = in_dueDate,
        sectionID = in_section_id
    WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_homework(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM homework_belongs_section WHERE homeworkID = id_val;
    DELETE FROM homework_has_submission WHERE homeworkID = id_val;
    DELETE FROM homework WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_submission(
    in_marks INT,
    in_content BYTEA,
    in_student_id INT,
    in_homework_id INT
) LANGUAGE plpgsql AS $$
BEGIN
  INSERT INTO submission (marks, content, studentID, homeworkID)
  VALUES (in_marks, in_content, in_student_id, in_homework_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_submission(
    in_marks INT,
    in_content BYTEA,
    in_student_id INT,
    in_homework_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE submission
    SET marks = in_marks,
        content = in_content,
        studentID = in_student_id,
        homeworkID = in_homework_id
    WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_submission(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM student_has_submission WHERE submissionID = id_val;
    DELETE FROM homework_has_submission WHERE submissionID = id_val;
    DELETE FROM submission WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_time_slot(
    in_day INT,
    in_startTime TIMESTAMP,
    in_endTime TIMESTAMP,
    in_section_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO time_slot (day, startTime, endTime, sectionID)
    VALUES (in_day, in_startTime, in_endTime, in_section_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_time_slot(
    in_day INT,
    in_startTime TIMESTAMP,
    in_endTime TIMESTAMP,
    in_section_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE time_slot
    SET day = in_day,
        startTime = in_startTime,
        endTime = in_endTime,
        sectionID = in_section_id
    WHERE ID = in_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_time_slot(id_val INT)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM section_has_time_slot WHERE time_slotID = id_val;
    DELETE FROM time_slot WHERE ID = id_val;
END;
$$
LANGUAGE plpgsql;


-- Stored procedures for relationship tables

CREATE OR REPLACE PROCEDURE insert_student_has_contact_info(
    in_student_id INT,
    in_student_contact_info_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO student_has_contact_info (studentID, student_contact_infoID)
    VALUES (in_student_id, in_student_contact_info_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_student_has_contact_info(
    in_student_id INT,
    in_student_contact_info_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE student_has_contact_info
    SET studentID = in_student_id,
        student_contact_infoID = in_student_contact_info_id
    WHERE studentID = in_student_id AND student_contact_infoID = in_student_contact_info_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_student_has_contact_info(
    in_student_id INT,
    in_student_contact_info_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM student_has_contact_info
    WHERE studentID = in_student_id AND student_contact_infoID = in_student_contact_info_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_student_has_login_credentials(
    in_student_id INT,
    in_student_login_credentials_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO student_has_login_credentials (studentID, student_login_credentialsID)
    VALUES (in_student_id, in_student_login_credentials_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_student_has_login_credentials(
    in_student_id INT,
    in_student_login_credentials_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE student_has_login_credentials
    SET studentID = in_student_id,
        student_login_credentialsID = in_student_login_credentials_id
    WHERE studentID = in_student_id AND student_login_credentialsID = in_student_login_credentials_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_student_has_login_credentials(
    in_student_id INT,
    in_student_login_credentials_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM student_has_login_credentials
    WHERE studentID = in_student_id AND student_login_credentialsID = in_student_login_credentials_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_instructor_has_login_credentials(
    in_instructor_id INT,
    in_instructor_login_credentials_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO instructor_has_login_credentials (instructorID, instructor_login_credentialsID)
    VALUES (in_instructor_id, in_instructor_login_credentials_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_instructor_has_login_credentials(
    in_instructor_id INT,
    in_instructor_login_credentials_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE instructor_has_login_credentials
    SET instructorID = in_instructor_id,
        instructor_login_credentialsID = in_instructor_login_credentials_id
    WHERE instructorID = in_instructor_id AND instructor_login_credentialsID = in_instructor_login_credentials_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_instructor_has_login_credentials(
    in_instructor_id INT,
    in_instructor_login_credentials_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM instructor_has_login_credentials
    WHERE instructorID = in_instructor_id AND instructor_login_credentialsID = in_instructor_login_credentials_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_instructor_has_contact_info(
    in_instructor_id INT,
    in_instructor_contact_info_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO instructor_has_contact_info (instructorID, instructor_contact_infoID)
    VALUES (in_instructor_id, in_instructor_contact_info_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_instructor_has_contact_info(
    in_instructor_id INT,
    in_instructor_contact_info_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE instructor_has_contact_info
    SET instructorID = in_instructor_id,
        instructor_contact_infoID = in_instructor_contact_info_id
    WHERE instructorID = in_instructor_id AND instructor_contact_infoID = in_instructor_contact_info_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_instructor_has_contact_info(
    in_instructor_id INT,
    in_instructor_contact_info_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM instructor_has_contact_info
    WHERE instructorID = in_instructor_id AND instructor_contact_infoID = in_instructor_contact_info_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_student_enrolls_section(
    in_student_id INT,
    in_section_id INT,
    in_grade INT,
    in_non_attendence_count INT,
    in_is_approved BOOLEAN
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO student_enrolls_section (studentID, sectionID, grade, nonAttendanceCount, isApproved)
    VALUES (in_student_id, in_section_id, in_grade, in_non_attendence_count, in_is_approved);
END;
$$;

CREATE OR REPLACE PROCEDURE update_student_enrolls_section(
    in_student_id INT,
    in_section_id INT,
    in_grade INT,
    in_non_attendence_count INT,
    in_is_approved BOOLEAN
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE student_enrolls_section
    SET studentID = in_student_id,
        sectionID = in_section_id,
        grade = in_grade,
        nonAttendanceCount = in_non_attendence_count,
        isApproved = in_is_approved
    WHERE studentID = in_student_id AND sectionID = in_section_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_student_enrolls_section(
    in_student_id INT,
    in_section_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM student_enrolls_section
    WHERE studentID = in_student_id AND sectionID = in_section_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_student_belongs_department(
    in_student_id INT,
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO student_belongs_department (studentID, departmentID)
    VALUES (in_student_id, in_department_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_student_belongs_department(
    in_student_id INT,
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE student_belongs_department
    SET studentID = in_student_id,
        departmentID = in_department_id
    WHERE studentID = in_student_id AND departmentID = in_department_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_student_belongs_department(
    in_student_id INT,
    in_department_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM student_belongs_department
    WHERE studentID = in_student_id AND departmentID = in_department_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_student_has_submission(
    in_student_id INT,
    in_submission_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO student_belongs_department (studentID, submissionID)
    VALUES (in_student_id, in_submission_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_student_has_submission(
    in_student_id INT,
    in_submission_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE student_belongs_department
    SET studentID = in_student_id,
        submissionID = in_submission_id
    WHERE studentID = in_student_id AND submissionID = in_submission_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_student_has_submission(
    in_student_id INT,
    in_submission_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM student_belongs_department
    WHERE studentID = in_student_id AND submissionID = in_submission_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_instructor_teaches_section(
    in_instructor_id INT,
    in_section_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO instructor_teaches_section (instructorID, sectionID)
    VALUES (in_instructor_id, in_section_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_instructor_teaches_section(
    in_instructor_id INT,
    in_section_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE instructor_teaches_section
    SET instructorID = in_instructor_id,
        sectionID = in_section_id
    WHERE instructorID = in_instructor_id AND sectionID = in_section_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_instructor_teaches_section(
    in_instructor_id INT,
    in_section_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM instructor_teaches_section
    WHERE instructorID = in_instructor_id AND sectionID = in_section_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_instructor_advisor_student(
    in_instructor_id INT,
    in_student_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO instructor_advisor_student (instructorID, studentID)
    VALUES (in_instructor_id, in_student_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_instructor_advisor_student(
    in_instructor_id INT,
    in_student_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE instructor_advisor_student
    SET instructorID = in_instructor_id,
        studentID = in_student_id
    WHERE instructorID = in_instructor_id AND studentID = in_student_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_instructor_advisor_student(
    in_instructor_id INT,
    in_student_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM instructor_advisor_student
    WHERE instructorID = in_instructor_id AND studentID = in_student_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_instructor_belongs_department(
    in_instructor_id INT,
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO instructor_belongs_department (instructorID, departmentID)
    VALUES (in_instructor_id, in_department_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_instructor_belongs_department(
    in_instructor_id INT,
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE instructor_belongs_department
    SET instructorID = in_instructor_id,
        departmentID = in_department_id
    WHERE instructorID = in_instructor_id AND departmentID = in_department_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_instructor_belongs_department(
    in_instructor_id INT,
    in_department_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM instructor_belongs_department
    WHERE instructorID = in_instructor_id AND departmentID = in_department_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_faculty_has_department(
    in_faculty_id INT,
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO faculty_has_department (facultyID, departmentID)
    VALUES (in_faculty_id, in_department_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_faculty_has_department(
    in_faculty_id INT,
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE faculty_has_department
    SET facultyID = in_faculty_id,
        departmentID = in_department_id
    WHERE facultyID = in_faculty_id AND departmentID = in_department_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_faculty_has_department(
    in_faculty_id INT,
    in_department_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM faculty_has_department
    WHERE facultyID = in_faculty_id AND departmentID = in_department_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_course_requires_course(
    in_prereq_course_id INT,
    in_main_course_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO course_requires_course (prereqCourseID, mainCourseID)
    VALUES (in_prereq_course_id, in_main_course_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_course_requires_course(
    in_prereq_course_id INT,
    in_main_course_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE course_requires_course
    SET prereqCourseID = in_prereq_course_id,
        mainCourseID = in_main_course_id
    WHERE prereqCourseID = in_prereq_course_id AND mainCourseID = in_main_course_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_course_requires_course(
    in_prereq_course_id INT,
    in_main_course_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM course_requires_course
    WHERE prereqCourseID = in_prereq_course_id AND mainCourseID = in_main_course_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_course_belongs_department(
    in_course_id INT,
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO course_belongs_department (courseID, departmentID)
    VALUES (in_course_id, in_department_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_course_belongs_department(
    in_course_id INT,
    in_department_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE course_belongs_department
    SET courseID = in_course_id,
        departmentID = in_department_id
    WHERE courseID = in_course_id AND departmentID = in_department_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_course_belongs_department(
    in_course_id INT,
    in_department_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM course_belongs_department
    WHERE courseID = in_course_id AND departmentID = in_department_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_section_belongs_course(
    in_section_id INT,
    in_course_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO section_belongs_course (sectionID, courseID)
    VALUES (in_section_id, in_course_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_section_belongs_course(
    in_section_id INT,
    in_course_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE section_belongs_course
    SET sectionID = in_section_id,
        courseID = in_course_id
    WHERE sectionID = in_section_id AND courseID = in_course_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_section_belongs_course(
    in_section_id INT,
    in_course_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM section_belongs_course
    WHERE sectionID = in_section_id AND courseID = in_course_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_section_has_time_slot(
    in_section_id INT,
    in_time_slot_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO section_has_time_slot (sectionID, time_slotID)
    VALUES (in_section_id, in_time_slot_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_section_has_time_slot(
    in_section_id INT,
    in_time_slot_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE section_has_time_slot
    SET sectionID = in_section_id,
        time_slotID = in_time_slot_id
    WHERE sectionID = in_section_id AND time_slotID = in_time_slot_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_section_has_time_slot(
    in_section_id INT,
    in_time_slot_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM section_has_time_slot
    WHERE sectionID = in_section_id AND time_slotID = in_time_slot_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_homework_belongs_section(
    in_homework_id INT,
    in_section_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO homework_belongs_section (homeworkID, sectionID)
    VALUES (in_homework_id, in_section_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_homework_belongs_section(
    in_homework_id INT,
    in_section_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE homework_belongs_section
    SET homeworkID = in_homework_id,
        sectionID = in_section_id
    WHERE homeworkID = in_homework_id AND sectionID = in_section_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_homework_belongs_section(
    in_homework_id INT,
    in_section_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM homework_belongs_section
    WHERE homeworkID = in_homework_id AND sectionID = in_section_id;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE insert_homework_has_submission(
    in_homework_id INT,
    in_submission_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    INSERT INTO homework_has_submission (homeworkID, submissionID)
    VALUES (in_homework_id, in_submission_id);
END;
$$;

CREATE OR REPLACE PROCEDURE update_homework_has_submission(
    in_homework_id INT,
    in_submission_id INT
) LANGUAGE plpgsql AS $$
BEGIN
    UPDATE homework_has_submission
    SET homeworkID = in_homework_id,
        submissionID = in_submission_id
    WHERE homeworkID = in_homework_id AND submissionID = in_submission_id;
END;
$$;

CREATE OR REPLACE FUNCTION delete_homework_has_submission(
    in_homework_id INT,
    in_submission_id INT
)
RETURNS VOID AS
$$
BEGIN
    DELETE FROM homework_has_submission
    WHERE homeworkID = in_homework_id AND submissionID = in_submission_id;
END;
$$
LANGUAGE plpgsql;