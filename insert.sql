CALL insert_faculty('Engineering');
CALL insert_faculty('Medical School');
CALL insert_faculty('Foreign Languages');
CALL insert_faculty('Sport Science');
CALL insert_faculty('Law');
CALL insert_faculty('Economics and Adminidtrative Sciences');
CALL insert_faculty('Pharmacy');
CALL insert_faculty('Science and Literature');
CALL insert_faculty('Fine Arts');
CALL insert_faculty('Communication');


CALL insert_department('Computer Engineering', 1);
CALL insert_department('Electrical and Electronic Engineering', 1);
CALL insert_department('Industrial Engineering', 1);
CALL insert_department('Medicine', 2);
CALL insert_department('Modern Languages', 3);
CALL insert_department('Physical Education and Sports Teaching', 4);
CALL insert_department('Civil Law', 5);
CALL insert_department('Economics', 6);
CALL insert_department('Business Administration', 6);
CALL insert_department('International Relations', 6);
CALL insert_department('Public Finance', 6);
CALL insert_department('Pharmacology', 7);
CALL insert_department('Statistics', 8);
CALL insert_department('Physics', 8);
CALL insert_department('Psychology', 8);
CALL insert_department('Cartoon and Animation', 9);
CALL insert_department('Radio, TV and Film', 10);


CALL insert_student('Mert', 'Doğramacı', 21946055, '2019-08-21', 40, 1);
CALL insert_student('Özgün', 'Akyüz', 21827005, '2018-08-10', 40, 1);
CALL insert_student('Emre', 'Akdeniz', 21945102, '2019-08-10', 40, 4);
CALL insert_student('Eser', 'Vatansever', 21947727, '2019-08-10', 40, 2);
CALL insert_student('Abdurrahman', 'Özçağlayan', 21296013, '2012-08-10', 40, 4);
CALL insert_student('Efe', 'Çelik', 2200356833, '2020-07-28', 30, 3);
CALL insert_student('Tuğçe', 'Dönmez', 2212345678, '2021-07-15', 30, 5);
CALL insert_student('Ayşe Buket', 'Yağız', 2214545678, '2021-08-18', 30, 6);
CALL insert_student('İrem', 'Yağız', 2202345678, '2020-07-15', 30, 15);
CALL insert_student('Osman', 'Portakal', 2222345678, '2022-08-21', 30, 7);
CALL insert_student('Damla', 'Özdağ', 2202345678, '2020-08-21', 30, 8);
CALL insert_student('Emrah', 'Duman', 21745102, '2017-08-10', 40, 9);
CALL insert_student('Melek', 'Baykal', 21645102, '2016-08-10', 40, 10);
CALL insert_student('Özge', 'Burak', 21945102, '2019-07-10', 40, 11);
CALL insert_student('Alperen', 'Doğru', 21845102, '2018-08-20', 40, 12);
CALL insert_student('Ali', 'Veli', 21845102, '2018-07-10', 40, 13);
CALL insert_student('Özge', 'Burak', 21945102, '2019-07-10', 40, 14);
CALL insert_student('Burcu', 'Çiçek', 2212895678, '2021-07-10', 30, 16);
CALL insert_student('Almila', 'Dağlar', 2200895678, '2020-08-12', 30, 17);


CALL insert_instructor('Engin', 'Demir', 1);
CALL insert_instructor('Mehmet Erkut', 'Erdem', 1);
CALL insert_instructor('Adnan', 'Özsoy', 1);
CALL insert_instructor('Fuat', 'Akal', 1);
CALL insert_instructor('Ebru', 'Akçapınar Sezer', 1);
CALL insert_instructor('Harun', 'Artuner', 2);
CALL insert_instructor('Murat', 'Aydos', 3);
CALL insert_instructor('Ahmet Selman', 'Bozkır', 4);
CALL insert_instructor('Ahmet Burak', 'Can', 5);
CALL insert_instructor('İlyas', 'Çiçekli', 6);
CALL insert_instructor('Tunca', 'Doğan', 7);
CALL insert_instructor('Pınar', 'Duygulu Şahin', 8);
CALL insert_instructor('Mehmet Önder', 'Efe', 9);
CALL insert_instructor('Özgür', 'Erkent', 10);
CALL insert_instructor('Burkay', 'Genç', 11);
CALL insert_instructor('Ebru', 'Gökalp Aydın', 12);
CALL insert_instructor('Nazlı', 'İkizler Cinbiş', 13);
CALL insert_instructor('Ebru', 'Gökalp Aydın', 14);
CALL insert_instructor('Kayhan', 'İmre', 15);
CALL insert_instructor('Aydın', 'Kaya', 16);
CALL insert_instructor('Ali Seydi', 'Keçeli', 17);


-- CALL contact_info (phone, email, address, userID) VALUES (12, 08527419633, 'iremyagiz@gmail.com', 'Tokat', );
-- CALL contact_info (phone, email, address, userID) VALUES (13, 08529637411, 'osmanportakal@gmail.com', 'Mersin', 10);
-- CALL contact_info (phone, email, address, userID) VALUES (14, 08529637411, 'damlaozdag@gmail.com', 'Ankara', 11);

-- TODO: FOREIGN KEY ERROR ALIYORUZ BUNA BİR ÇÖZÜM LAZIM
-- CALL login_credentials (username, password, userID) VALUES (1, '21946055', 'şifre251', 1);


CALL insert_student_contact_info('05425252477', 'mertdogramaci@gmail.com', 'Yenibağlar Mah Eti Cad Görenek Sok Final Sit D/8 Tepebaşı/Eskişehir', 1);
CALL insert_student_contact_info('05555555555', 'ozgunakyuz@gmail.com', 'Ankara', 2);
CALL insert_student_contact_info('02134567899', 'emreakdeniz@gmail.com', 'Eskişehir', 3);
CALL insert_student_contact_info('01234567899', 'eservatansever@gmail.com', 'İstanbul', 4);
CALL insert_student_contact_info('05421234567', 'abdurrahman@gmail.com', 'Ankara', 5);
CALL insert_student_contact_info('05987654321', 'efecelik@gmail.com', 'Ankara', 6);
CALL insert_student_contact_info('09638527411', 'tugcedonmez@gmail.com', 'Ankara', 7);
CALL insert_student_contact_info('07418529633', 'aysebuketyagiz@gmail.com', 'Kocaeli', 8);
CALL insert_student_contact_info('08527419633', 'iremyagiz@gmail.com', 'Tokat', 9);
CALL insert_student_contact_info('08529637411', 'osmanportakal@gmail.com', 'Mersin', 10);
CALL insert_student_contact_info('08529637411', 'damlaozdag@gmail.com', 'Ankara', 11);


CALL insert_course('BBM101', 6, TRUE, 'Introducion to Programming I', 1);
CALL insert_course('BBM103', 4, TRUE, 'Introducion to Programming Lab I', 1);
CALL insert_course('BBM471', 6, FALSE, 'Database Management Systems', 1);
CALL insert_course('BBM473', 4, FALSE, 'Database Management Systems Lab', 1);
CALL insert_course('BBM406', 6, FALSE, 'Fundamentals of Artificial Intelligence', 1);


CALL insert_section(FALSE, 2023, 'D1', 40, 1, 1);
CALL insert_section(FALSE, 2023, 'D2', 40, 1, 2);
CALL insert_section(TRUE, 2023, 'Seminer Hall', 60, 3, 1);


INSERT INTO student_enrolls_section VALUES (1, 3, 85, 3, TRUE);

INSERT INTO instructor_teaches_section VALUES (1, 3);



select * 
from student join student_enrolls_section on (student_enrolls_section.studentID = student.ID)
join section on (section.ID = student_enrolls_section.sectionID) 
join course on (course.ID = section.courseID)
join instructor on (section.instructorID = instructor.ID);