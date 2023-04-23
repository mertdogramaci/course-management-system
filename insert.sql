INSERT INTO faculty (ID, name) VALUES (1, 'Engineering');
INSERT INTO faculty (ID, name) VALUES (2, 'Medical School');
INSERT INTO faculty (ID, name) VALUES (3, 'Foreign Languages');
INSERT INTO faculty (ID, name) VALUES (4, 'Sport Science');
INSERT INTO faculty (ID, name) VALUES (5, 'Law');
INSERT INTO faculty (ID, name) VALUES (6, 'Economics and Adminidtrative Sciences');
INSERT INTO faculty (ID, name) VALUES (7, 'Pharmacy');
INSERT INTO faculty (ID, name) VALUES (8, 'Science and Literature');
INSERT INTO faculty (ID, name) VALUES (9, 'Fine Arts');
INSERT INTO faculty (ID, name) VALUES (10, 'Communication');


INSERT INTO department (ID, name, facultyID) VALUES (1, 'Computer Engineering', 1);
INSERT INTO department (ID, name, facultyID) VALUES (2, 'Electrical and Electronic Engineering', 1);
INSERT INTO department (ID, name, facultyID) VALUES (3, 'Industrial Engineering', 1);
INSERT INTO department (ID, name, facultyID) VALUES (4, 'Medicine', 2);
INSERT INTO department (ID, name, facultyID) VALUES (5, 'Modern Languages', 3);
INSERT INTO department (ID, name, facultyID) VALUES (6, 'Physical Education and Sports Teaching', 4);
INSERT INTO department (ID, name, facultyID) VALUES (7, 'Civil Law', 5);
INSERT INTO department (ID, name, facultyID) VALUES (8, 'Economics', 6);
INSERT INTO department (ID, name, facultyID) VALUES (9, 'Business Administration', 6);
INSERT INTO department (ID, name, facultyID) VALUES (10, 'International Relations', 6);
INSERT INTO department (ID, name, facultyID) VALUES (11, 'Public Finance', 6);
INSERT INTO department (ID, name, facultyID) VALUES (12, 'Pharmacology', 7);
INSERT INTO department (ID, name, facultyID) VALUES (13, 'Statistics', 8);
INSERT INTO department (ID, name, facultyID) VALUES (14, 'Physics', 8);
INSERT INTO department (ID, name, facultyID) VALUES (15, 'Psychology', 8);
INSERT INTO department (ID, name, facultyID) VALUES (16, 'Cartoon and Animation', 9);
INSERT INTO department (ID, name, facultyID) VALUES (17, 'Radio, TV and Film', 10);


INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (1, 'Mert', 'Doğramacı', 1, 21946055, '2019-08-21', 40);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (2, 'Özgün', 'Akyüz', 1, 21827005, '2018-08-10', 40);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (3, 'Emre', 'Akdeniz', 4, 21945102, '2019-08-10', 40);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (4, 'Eser', 'Vatansever', 2, 21947727, '2019-08-10', 40);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (5, 'Abdurrahman', 'Özçağlayan', 4, 21296013, '2012-08-10', 40);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (6, 'Efe', 'Çelik', 3, 2200356833, '2020-07-28', 30);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (7, 'Tuğçe', 'Dönmez', 5, 2212345678, '2021-07-15', 30);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (8, 'Ayşe Buket', 'Yağız', 6, 2214545678, '2021-08-18', 30);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (9, 'İrem', 'Yağız', 15, 2202345678, '2020-07-15', 30);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (10, 'Osman', 'Portakal', 7, 2222345678, '2022-08-21', 30);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (11, 'Damla', 'Özdağ', 8, 2202345678, '2020-08-21', 30);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (12, 'Emrah', 'Duman', 9, 21745102, '2017-08-10', 40);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (13, 'Melek', 'Baykal', 10, 21645102, '2016-08-10', 40);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (14, 'Özge', 'Burak', 11, 21945102, '2019-07-10', 40);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (15, 'Alperen', 'Doğru', 12, 21845102, '2018-08-20', 40);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (16, 'Ali', 'Veli', 13, 21845102, '2018-07-10', 40);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (17, 'Özge', 'Burak', 14, 21945102, '2019-07-10', 40);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (18, 'Burcu', 'Çiçek', 16, 2212895678, '2021-07-10', 30);
INSERT INTO student (ID, name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES (19, 'Almila', 'Dağlar', 17, 2200895678, '2020-08-12', 30);


INSERT INTO instructor (ID, name, surname, departmentID) VALUES (20, 'Engin', 'Demir', 1);
INSERT INTO instructor (ID, name, surname, departmentID) VALUES (21, 'Mehmet Erkut', 'Erdem', 1);
INSERT INTO instructor (ID, name, surname, departmentID) VALUES (22, 'Adnan', 'Özsoy', 1);
INSERT INTO instructor (ID, name, surname, departmentID) VALUES (23, 'Fuat', 'Akal', 1);
INSERT INTO instructor (ID, name, surname, departmentID) VALUES (24, 'Ebru', 'Akçapınar Sezer', 1);
INSERT INTO instructor (ID, name, surname, departmentID) VALUES (25, 'Harun', 'Artuner', 2);
INSERT INTO instructor (ID, name, surname, departmentID) VALUES (26, 'Murat', 'Aydos', 3);
INSERT INTO instructor (ID, name, surname, departmentID) VALUES (27, 'Ahmet Selman', 'Bozkır', 4);
INSERT INTO instructor (ID, name, surname, departmentID) VALUES (28, 'Ahmet Burak', 'Can', 5);
INSERT INTO instructor (ID, name, surname, departmentID) VALUES (29, 'İlyas', 'Çiçekli', 6);
INSERT INTO instructor (ID, name, surname, departmentID) VALUES (30, 'Tunca', 'Doğan', 7);

/*
-- TODO: FOREIGN KEY ERROR ALIYORUZ BUNA BİR ÇÖZÜM LAZIM
INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (1, '05425252477', 'mertdogramaci@gmail.com', 'Yenibağlar Mah Eti Cad Görenek Sok Final Sit D/8 Tepebaşı/Eskişehir', 1);
INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (2, '05555555555', 'ozgunakyuz@gmail.com', 'Ankara', 2);
INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (3, '02134567899', 'emreakdeniz@gmail.com', 'Eskişehir', 3);
INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (4, '01234567899', 'eservatansever@gmail.com', 'İstanbul', 4);
INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (5, '05421234567', 'abdurrahman@gmail.com', 'Ankara', 5);
INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (6, '05987654321', 'efecelik@gmail.com', 'Ankara', 6);
INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (7, '09638527411', 'tugcedonmez@gmail.com', 'Ankara', 7);
INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (8, '07418529633', 'aysebuketyagiz@gmail.com', 'Kocaeli', 8);
INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (9, '08527419633', 'iremyagiz@gmail.com', 'Tokat', 9);
INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (10, '08529637411', 'osmanportakal@gmail.com', 'Mersin', 10);
INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (11, '08529637411', 'damlaozdag@gmail.com', 'Ankara', 11);
-- INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (12, 08527419633, 'iremyagiz@gmail.com', 'Tokat', );
-- INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (13, 08529637411, 'osmanportakal@gmail.com', 'Mersin', 10);
-- INSERT INTO contact_info (ID, phone, email, address, userID) VALUES (14, 08529637411, 'damlaozdag@gmail.com', 'Ankara', 11);
*/

-- TODO: FOREIGN KEY ERROR ALIYORUZ BUNA BİR ÇÖZÜM LAZIM
-- INSERT INTO login_credentials (ID, username, password, userID) VALUES (1, '21946055', 'şifre251', 1);


INSERT INTO student_contact_info (ID, phone, email, address, studentID) VALUES (1, '05425252477', 'mertdogramaci@gmail.com', 'Yenibağlar Mah Eti Cad Görenek Sok Final Sit D/8 Tepebaşı/Eskişehir', 1);
INSERT INTO student_contact_info (ID, phone, email, address, studentID) VALUES (2, '05555555555', 'ozgunakyuz@gmail.com', 'Ankara', 2);
INSERT INTO student_contact_info (ID, phone, email, address, studentID) VALUES (3, '02134567899', 'emreakdeniz@gmail.com', 'Eskişehir', 3);
INSERT INTO student_contact_info (ID, phone, email, address, studentID) VALUES (4, '01234567899', 'eservatansever@gmail.com', 'İstanbul', 4);
INSERT INTO student_contact_info (ID, phone, email, address, studentID) VALUES (5, '05421234567', 'abdurrahman@gmail.com', 'Ankara', 5);
INSERT INTO student_contact_info (ID, phone, email, address, studentID) VALUES (6, '05987654321', 'efecelik@gmail.com', 'Ankara', 6);
INSERT INTO student_contact_info (ID, phone, email, address, studentID) VALUES (7, '09638527411', 'tugcedonmez@gmail.com', 'Ankara', 7);
INSERT INTO student_contact_info (ID, phone, email, address, studentID) VALUES (8, '07418529633', 'aysebuketyagiz@gmail.com', 'Kocaeli', 8);
INSERT INTO student_contact_info (ID, phone, email, address, studentID) VALUES (9, '08527419633', 'iremyagiz@gmail.com', 'Tokat', 9);
INSERT INTO student_contact_info (ID, phone, email, address, studentID) VALUES (10, '08529637411', 'osmanportakal@gmail.com', 'Mersin', 10);
INSERT INTO student_contact_info (ID, phone, email, address, studentID) VALUES (11, '08529637411', 'damlaozdag@gmail.com', 'Ankara', 11);


INSERT INTO course (ID, title, ects, isCompulsory, description, departmentID) VALUES (1, 'BBM101', 6, TRUE, 'Introducion to Programming I', 1);
INSERT INTO course (ID, title, ects, isCompulsory, description, departmentID) VALUES (2, 'BBM103', 4, TRUE, 'Introducion to Programming Lab I', 1);
INSERT INTO course (ID, title, ects, isCompulsory, description, departmentID) VALUES (3, 'BBM471', 6, FALSE, 'Database Management Systems', 1);
INSERT INTO course (ID, title, ects, isCompulsory, description, departmentID) VALUES (4, 'BBM473', 4, FALSE, 'Database Management Systems Lab', 1);
INSERT INTO course (ID, title, ects, isCompulsory, description, departmentID) VALUES (5, 'BBM406', 6, FALSE, 'Fundamentals of Artificial Intelligence', 1);


INSERT INTO section (ID, semester, year, classroomInfo, quota, courseID, instructorID) VALUES (1, FALSE, 2023, 'D1', 40, 1, 20);
INSERT INTO section (ID, semester, year, classroomInfo, quota, courseID, instructorID) VALUES (2, FALSE, 2023, 'D2', 40, 1, 21);
INSERT INTO section (ID, semester, year, classroomInfo, quota, courseID, instructorID) VALUES (3, TRUE, 2023, 'Seminer Hall', 60, 3, 20);


-- TODO: bu da error alıyor
INSERT INTO student_enrolls_section (studentID, sectionID, grade, nonAttendanceCount, isApproved) VALUES (1, 3, 85, 3, TRUE);



select * 
from student join department on (student.departmentID = department.ID)
join faculty on (faculty.ID = department.facultyID)
join student_contact_info on (student.ID = student_contact_info.studentID);