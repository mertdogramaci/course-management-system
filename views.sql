-- Drop all tables for being able to re-run this query
DROP VIEW IF EXISTS student_grades;
DROP VIEW IF EXISTS instructor_sections;
DROP VIEW IF EXISTS department_course_stats;
DROP VIEW IF EXISTS student_submission_stats;
DROP VIEW IF EXISTS department_section_stats;


-- View #1 = the grades for all students enrolled in a specific section
CREATE VIEW student_grades AS
SELECT s.ID AS student_ID, s.name, s.surname, ses.sectionID, ses.grade
FROM student s
JOIN student_enrolls_section ses ON s.ID = ses.studentID;

-- Example usage of view #1
SELECT * FROM student_grades WHERE sectionID = 3;


-- View #2 = all sections taught by a specific instructor
CREATE VIEW instructor_sections AS
SELECT i.ID AS instructor_ID, i.name, i.surname/*, s.ID AS section_ID, s.semester, s.year*/
FROM instructor i
JOIN instructor_teaches_section its ON i.ID = its.instructorID
JOIN section s ON its.sectionID = s.ID;

-- Example usage of view #2
SELECT * FROM instructor_sections WHERE instructor_ID = 1;


-- View #3 = retrieve statistics about the courses offered by a specific department, such as the average ECTS credits and the number of sections offered
CREATE VIEW department_course_stats AS
SELECT d.name AS department_name, c.title AS course_title, AVG(c.ects) AS avg_ects, COUNT(DISTINCT s.ID) AS num_sections
FROM department d
JOIN course c ON d.ID = c.departmentID
JOIN section s ON c.ID = s.courseID
GROUP BY d.name, c.title;

-- Example usage of view #3
SELECT * FROM department_course_stats WHERE department_name = 'Computer Engineering';


-- View #4 = retrieve statistics about the submissions made by a specific student, such as the number of submissions and the average marks received
CREATE VIEW student_submission_stats AS
SELECT s.ID AS student_ID, s.name, s.surname, COUNT(sub.ID) AS num_submissions, AVG(sub.marks) AS avg_marks
FROM student s
JOIN student_has_submission shs ON s.ID = shs.studentID
JOIN submission sub ON shs.submissionID = sub.ID
GROUP BY s.ID, s.name, s.surname;

-- Example usage of view #4
SELECT * FROM student_submission_stats WHERE student_ID = 1;


-- View #5 = retrieve statistics about the sections offered by a specific department, such as the average grade and the number of students enrolled
CREATE VIEW department_section_stats AS
SELECT d.name AS department_name, s.ID AS section_ID, AVG(se.grade) AS avg_grade, COUNT(DISTINCT se.studentID) AS num_students
FROM department d
JOIN course c ON d.ID = c.departmentID
JOIN section s ON c.ID = s.courseID
JOIN student_enrolls_section se ON s.ID = se.sectionID
GROUP BY d.name, s.ID;

-- Example usage of view #5
SELECT * FROM department_section_stats WHERE department_name = 'Computer Engineering';