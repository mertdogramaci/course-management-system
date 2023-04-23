INSERT INTO faculty (name) VALUES ('Engineering');
INSERT INTO faculty (name) VALUES ('Medical School');
INSERT INTO faculty (name) VALUES ('Foreign Languages');
INSERT INTO faculty (name) VALUES ('Sport Science');
INSERT INTO faculty (name) VALUES ('Law');
INSERT INTO faculty (name) VALUES ('Economics and Adminidtrative Sciences');
INSERT INTO faculty (name) VALUES ('Pharmacy');
INSERT INTO faculty (name) VALUES ('Science and Literature');
INSERT INTO faculty (name) VALUES ('Fine Arts');
INSERT INTO faculty (name) VALUES ('Communication');


INSERT INTO department (name, facultyID) VALUES ('Computer Engineering', 1);
INSERT INTO department (name, facultyID) VALUES ('Electrical and Electronic Engineering', 1);
INSERT INTO department (name, facultyID) VALUES ('Industrial Engineering', 1);
INSERT INTO department (name, facultyID) VALUES ('Medicine', 2);
INSERT INTO department (name, facultyID) VALUES ('Modern Languages', 3);
INSERT INTO department (name, facultyID) VALUES ('Physical Education and Sports Teaching', 4);
INSERT INTO department (name, facultyID) VALUES ('Civil Law', 5);
INSERT INTO department (name, facultyID) VALUES ('Economics', 6);
INSERT INTO department (name, facultyID) VALUES ('Business Administration', 6);
INSERT INTO department (name, facultyID) VALUES ('International Relations', 6);
INSERT INTO department (name, facultyID) VALUES ('Public Finance', 6);
INSERT INTO department (name, facultyID) VALUES ('Pharmacology', 7);
INSERT INTO department (name, facultyID) VALUES ('Statistics', 8);
INSERT INTO department (name, facultyID) VALUES ('Physics', 8);
INSERT INTO department (name, facultyID) VALUES ('Psychology', 8);
INSERT INTO department (name, facultyID) VALUES ('Cartoon and Animation', 9);
INSERT INTO department (name, facultyID) VALUES ('Radio, TV and Film', 10);


INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Mert', 'Doğramacı', 1, 21946055, '2019-08-21', 40);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Özgün', 'Akyüz', 1, 21827005, '2018-08-10', 40);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Emre', 'Akdeniz', 4, 21945102, '2019-08-10', 40);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Eser', 'Vatansever', 2, 21947727, '2019-08-10', 40);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Abdurrahman', 'Özçağlayan', 4, 21296013, '2012-08-10', 40);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Efe', 'Çelik', 3, 2200356833, '2020-07-28', 30);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Tuğçe', 'Dönmez', 5, 2212345678, '2021-07-15', 30);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Ayşe Buket', 'Yağız', 6, 2214545678, '2021-08-18', 30);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('İrem', 'Yağız', 15, 2202345678, '2020-07-15', 30);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Osman', 'Portakal', 7, 2222345678, '2022-08-21', 30);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Damla', 'Özdağ', 8, 2202345678, '2020-08-21', 30);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Emrah', 'Duman', 9, 21745102, '2017-08-10', 40);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Melek', 'Baykal', 10, 21645102, '2016-08-10', 40);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Özge', 'Burak', 11, 21945102, '2019-07-10', 40);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Alperen', 'Doğru', 12, 21845102, '2018-08-20', 40);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Ali', 'Veli', 13, 21845102, '2018-07-10', 40);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Özge', 'Burak', 14, 21945102, '2019-07-10', 40);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Burcu', 'Çiçek', 16, 2212895678, '2021-07-10', 30);
INSERT INTO student (name, surname, departmentID, studentID, schoolEnrollmentDate, semesterECTS) VALUES ('Almila', 'Dağlar', 17, 2200895678, '2020-08-12', 30);


INSERT INTO instructor (name, surname, departmentID) VALUES ('Engin', 'Demir', 1);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Mehmet Erkut', 'Erdem', 1);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Adnan', 'Özsoy', 1);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Fuat', 'Akal', 1);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Ebru', 'Akçapınar Sezer', 1);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Harun', 'Artuner', 2);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Murat', 'Aydos', 3);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Ahmet Selman', 'Bozkır', 4);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Ahmet Burak', 'Can', 5);
INSERT INTO instructor (name, surname, departmentID) VALUES ('İlyas', 'Çiçekli', 6);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Tunca', 'Doğan', 7);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Pınar', 'Duygulu Şahin', 8);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Mehmet Önder', 'Efe', 9);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Özgür', 'Erkent', 10);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Burkay', 'Genç', 11);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Ebru', 'Gökalp Aydın', 12);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Nazlı', 'İkizler Cinbiş', 13);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Ebru', 'Gökalp Aydın', 14);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Kayhan', 'İmre', 15);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Aydın', 'Kaya', 16);
INSERT INTO instructor (name, surname, departmentID) VALUES ('Ali Seydi', 'Keçeli', 17);


-- INSERT INTO contact_info (phone, email, address, userID) VALUES (12, 08527419633, 'iremyagiz@gmail.com', 'Tokat', );
-- INSERT INTO contact_info (phone, email, address, userID) VALUES (13, 08529637411, 'osmanportakal@gmail.com', 'Mersin', 10);
-- INSERT INTO contact_info (phone, email, address, userID) VALUES (14, 08529637411, 'damlaozdag@gmail.com', 'Ankara', 11);

-- TODO: FOREIGN KEY ERROR ALIYORUZ BUNA BİR ÇÖZÜM LAZIM
-- INSERT INTO login_credentials (username, password, userID) VALUES (1, '21946055', 'şifre251', 1);


INSERT INTO student_contact_info (phone, email, address, studentID) VALUES ('05425252477', 'mertdogramaci@gmail.com', 'Yenibağlar Mah Eti Cad Görenek Sok Final Sit D/8 Tepebaşı/Eskişehir', 1);
INSERT INTO student_contact_info (phone, email, address, studentID) VALUES ('05555555555', 'ozgunakyuz@gmail.com', 'Ankara', 2);
INSERT INTO student_contact_info (phone, email, address, studentID) VALUES ('02134567899', 'emreakdeniz@gmail.com', 'Eskişehir', 3);
INSERT INTO student_contact_info (phone, email, address, studentID) VALUES ('01234567899', 'eservatansever@gmail.com', 'İstanbul', 4);
INSERT INTO student_contact_info (phone, email, address, studentID) VALUES ('05421234567', 'abdurrahman@gmail.com', 'Ankara', 5);
INSERT INTO student_contact_info (phone, email, address, studentID) VALUES ('05987654321', 'efecelik@gmail.com', 'Ankara', 6);
INSERT INTO student_contact_info (phone, email, address, studentID) VALUES ('09638527411', 'tugcedonmez@gmail.com', 'Ankara', 7);
INSERT INTO student_contact_info (phone, email, address, studentID) VALUES ('07418529633', 'aysebuketyagiz@gmail.com', 'Kocaeli', 8);
INSERT INTO student_contact_info (phone, email, address, studentID) VALUES ('08527419633', 'iremyagiz@gmail.com', 'Tokat', 9);
INSERT INTO student_contact_info (phone, email, address, studentID) VALUES ('08529637411', 'osmanportakal@gmail.com', 'Mersin', 10);
INSERT INTO student_contact_info (phone, email, address, studentID) VALUES ('08529637411', 'damlaozdag@gmail.com', 'Ankara', 11);


INSERT INTO course (title, ects, isCompulsory, description, departmentID) VALUES ('BBM101', 6, TRUE, 'Introducion to Programming I', 1);
INSERT INTO course (title, ects, isCompulsory, description, departmentID) VALUES ('BBM103', 4, TRUE, 'Introducion to Programming Lab I', 1);
INSERT INTO course (title, ects, isCompulsory, description, departmentID) VALUES ('BBM471', 6, FALSE, 'Database Management Systems', 1);
INSERT INTO course (title, ects, isCompulsory, description, departmentID) VALUES ('BBM473', 4, FALSE, 'Database Management Systems Lab', 1);
INSERT INTO course (title, ects, isCompulsory, description, departmentID) VALUES ('BBM406', 6, FALSE, 'Fundamentals of Artificial Intelligence', 1);


INSERT INTO section (semester, year, classroomInfo, quota, courseID, instructorID) VALUES (FALSE, 2023, 'D1', 40, 1, 1);
INSERT INTO section (semester, year, classroomInfo, quota, courseID, instructorID) VALUES (FALSE, 2023, 'D2', 40, 1, 2);
INSERT INTO section (semester, year, classroomInfo, quota, courseID, instructorID) VALUES (TRUE, 2023, 'Seminer Hall', 60, 3, 1);


INSERT INTO student_enrolls_section (studentID, sectionID, grade, nonAttendanceCount, isApproved) VALUES (1, 3, 85, 3, TRUE);



select * 
from student;
/*join student_enrolls_section on (student_enrolls_section.studentID = student.ID)
join section on (section.ID = student_enrolls_section.sectionID) 
join course on (course.ID = section.courseID)
join instructor on (section.instructorID = instructor.ID);*/