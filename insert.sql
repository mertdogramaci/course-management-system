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
CALL insert_student('İrem', 'Yağız', 2202345679, '2020-07-15', 30, 15);
CALL insert_student('Osman', 'Portakal', 2222345678, '2022-08-21', 30, 7);
CALL insert_student('Damla', 'Özdağ', 2202345678, '2020-08-21', 30, 8);


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


CALL insert_student_login_credentials('b21946055', 'adb2c86cd366a11d033cd89934ebc31719b4305a6af8a95f2b1a8591c50d845c', 1);
CALL insert_student_login_credentials('b21827005', '3923221780a0e4b606dc8dc309fb4049835dd59c5e1a561e78ea8c1dddd16b8b', 2);
CALL insert_student_login_credentials('b21945102', 'a529eb61bf40b823466384d3e65b333fbb5b01b126bcc21e9c5b8d095d8eb356', 3);
CALL insert_student_login_credentials('b21947727', '2652ac401d43dcb290ed66fe28451b490f1c3df0b0d98f94ae9a445f599d7984', 4);
CALL insert_student_login_credentials('b21296013', 'ebc4c796bf1dbe7f95b2d7f4c7d23e864d027d3d8158afd5c461687470bb6327', 5);
CALL insert_student_login_credentials('b2200356833', '64377b72b8c9c6c1ab2fda13f142ca846362a10f0e73d67d7cbe3bdbb4657907', 6);
CALL insert_student_login_credentials('b2212345678', '55555bcaef3c3c4aeb20f507cf0e261774d81f297c61131a4f01d302ca81a239', 7);
CALL insert_student_login_credentials('b2214545678', '1f54ce3ec624aa3e06dbb61b9aa1f4e9d093ec686c45358362c6cb4b33f51426', 8);
CALL insert_student_login_credentials('b2202345679', 'b21c900cd05e4a16c2fef48efb1cbda82335cf06948b1f9fbdc020bc56941e4c', 9);
CALL insert_student_login_credentials('b2222345678', '135894da6641471b448c8656c1cd8f68e085063da9109c5ae14d9607227eac0b', 10);
CALL insert_student_login_credentials('b2202345678', 'ea30e35d55f2d0376ed046d412ba5c9295a1f85a185a94486bbdc5c8fd6864bb', 11);


CALL insert_instructor('Engin', 'Demir', 1);
CALL insert_instructor('Mehmet Erkut', 'Erdem', 1);
CALL insert_instructor('Adnan', 'Özsoy', 1);
CALL insert_instructor('Fuat', 'Akal', 1);
CALL insert_instructor('Ebru', 'Akçapınar Sezer', 1);
CALL insert_instructor('Harun', 'Artuner', 2);
CALL insert_instructor('Murat', 'Aydos', 2);
CALL insert_instructor('Ahmet Selman', 'Bozkır', 2);
CALL insert_instructor('Ahmet Burak', 'Can', 2);
CALL insert_instructor('İlyas', 'Çiçekli', 2);
CALL insert_instructor('Tunca', 'Doğan', 2);


CALL insert_instructor_contact_info('08529637411', 'engindemir@gmail.com', 'Mersin', 1);
CALL insert_instructor_contact_info('08529637411', 'erkuterdem@gmail.com', 'Ankara', 2);
CALL insert_instructor_contact_info('08529637411', 'adnanozsoy@gmail.com', 'Ankara', 3);
CALL insert_instructor_contact_info('08529637411', 'fuatakal@gmail.com', 'Ankara', 4);
CALL insert_instructor_contact_info('08529637411', 'ebrusezer@gmail.com', 'Ankara', 5);
CALL insert_instructor_contact_info('08529637411', 'harunartuner@gmail.com', 'Ankara', 6);
CALL insert_instructor_contact_info('08529637411', 'murataydos@gmail.com', 'Ankara', 7);
CALL insert_instructor_contact_info('08529637411', 'asbozkir@gmail.com', 'Ankara', 8);
CALL insert_instructor_contact_info('08529637411', 'aburakcan@gmail.com', 'Ankara', 9);
CALL insert_instructor_contact_info('08529637411', 'ilyascicekli@gmail.com', 'Ankara', 10);
CALL insert_instructor_contact_info('08529637411', 'tuncadogan@gmail.com', 'Ankara', 11);


CALL insert_instructor_login_credentials('engindemir', 'adb2c86cd366a11d033cd89934ebc31719b4305a6af8a95f2b1a8591c50d845c', 1);
CALL insert_instructor_login_credentials('erkuterdem', '3923221780a0e4b606dc8dc309fb4049835dd59c5e1a561e78ea8c1dddd16b8b', 2);
CALL insert_instructor_login_credentials('adnanozsoy', 'a529eb61bf40b823466384d3e65b333fbb5b01b126bcc21e9c5b8d095d8eb356', 3);
CALL insert_instructor_login_credentials('fuatakal', '2652ac401d43dcb290ed66fe28451b490f1c3df0b0d98f94ae9a445f599d7984', 4);
CALL insert_instructor_login_credentials('ebrusezer', 'ebc4c796bf1dbe7f95b2d7f4c7d23e864d027d3d8158afd5c461687470bb6327', 5);
CALL insert_instructor_login_credentials('harunartuner', '64377b72b8c9c6c1ab2fda13f142ca846362a10f0e73d67d7cbe3bdbb4657907', 6);
CALL insert_instructor_login_credentials('murataydos', '55555bcaef3c3c4aeb20f507cf0e261774d81f297c61131a4f01d302ca81a239', 7);
CALL insert_instructor_login_credentials('asbozkir', '1f54ce3ec624aa3e06dbb61b9aa1f4e9d093ec686c45358362c6cb4b33f51426', 8);
CALL insert_instructor_login_credentials('aburakcan', 'b21c900cd05e4a16c2fef48efb1cbda82335cf06948b1f9fbdc020bc56941e4c', 9);
CALL insert_instructor_login_credentials('ilyascicekli', '135894da6641471b448c8656c1cd8f68e085063da9109c5ae14d9607227eac0b', 10);
CALL insert_instructor_login_credentials('tuncadogan', 'ea30e35d55f2d0376ed046d412ba5c9295a1f85a185a94486bbdc5c8fd6864bb', 11);


CALL insert_course('BBM101', 6, TRUE, 'Introducion to Programming I', 1);
CALL insert_course('BBM103', 4, TRUE, 'Introducion to Programming Lab I', 1);
CALL insert_course('BBM471', 6, FALSE, 'Database Management Systems', 1);
CALL insert_course('BBM473', 4, FALSE, 'Database Management Systems Lab', 1);
CALL insert_course('BBM406', 6, FALSE, 'Fundamentals of Artificial Intelligence', 1);
CALL insert_course('ELE244', 6, TRUE, 'Electromagnetics I', 2);
CALL insert_course('ELE230', 6, TRUE, 'Electronics I', 2);
CALL insert_course('ELE475', 6, FALSE, 'High Voltage Technology', 2);
CALL insert_course('ELE477', 6, FALSE, 'Electric Machines II', 2);
CALL insert_course('ELE479', 2, FALSE, 'Electric Machines Laboratory II', 2);
CALL insert_course('ELE481', 6, FALSE, 'Electrical Power Systems I', 2);

--FALSE:FALL, TRUE:SPRING
CALL insert_section(FALSE, 2023, 'D1', 40, 1, 1);
CALL insert_section(FALSE, 2023, 'D2', 40, 1, 2);
CALL insert_section(FALSE, 2023, 'D3', 40, 1, 3);
CALL insert_section(TRUE, 2023, 'Seminer Hall', 60, 6, 6);
CALL insert_section(TRUE, 2023, 'Seminer Hall', 60, 6, 7);
CALL insert_section(FALSE, 2023, 'D4', 60, 3, 4);
CALL insert_section(FALSE, 2023, 'D5', 40, 3, 5);
CALL insert_section(TRUE, 2023, 'Z1', 60, 7, 8);
CALL insert_section(TRUE, 2023, 'Z2', 60, 7, 9);
CALL insert_section(TRUE, 2023, 'Seminer Hall', 50, 8, 10);
CALL insert_section(TRUE, 2023, 'Seminer Hall', 50, 8, 11);


CALL insert_homework('topic1', 'content1', '2023-04-19', '2023-04-23', 1);
CALL insert_homework('topic2', 'content2', '2023-04-19', '2023-04-23', 2);
CALL insert_homework('topic3', 'content3', '2023-04-19', '2023-04-23', 3);
CALL insert_homework('topic4', 'content4', '2023-04-19', '2023-04-23', 4);
CALL insert_homework('topic5', 'content5', '2023-04-19', '2023-04-23', 5);
CALL insert_homework('topic6', 'content6', '2023-04-19', '2023-04-23', 6);
CALL insert_homework('topic7', 'content7', '2023-04-19', '2023-04-23', 7);
CALL insert_homework('topic8', 'content8', '2023-04-19', '2023-04-23', 8);
CALL insert_homework('topic9', 'content9', '2023-04-19', '2023-04-23', 9);
CALL insert_homework('topic10', 'content10', '2023-04-19', '2023-04-23', 10);
CALL insert_homework('topic11', 'content11', '2023-04-19', '2023-04-23', 11);


CALL insert_submission(90, 'submitted1', 1, 1);
CALL insert_submission(80, 'submitted2', 2, 1);
CALL insert_submission(75, 'submitted3', 3, 3);
CALL insert_submission(45, 'submitted4', 4, 3);
CALL insert_submission(86, 'submitted5', 5, 1);
CALL insert_submission(56, 'submitted6', 6, 1);
CALL insert_submission(35, 'submitted7', 7, 5);
CALL insert_submission(45, 'submitted8', 8, 6);
CALL insert_submission(15, 'submitted9', 9, 7);
CALL insert_submission(87, 'submitted10', 10, 7);
CALL insert_submission(49, 'submitted11', 11, 8);


CALL insert_time_slot(0, '2023-06-22 08:40:00-00', '2023-06-22 11:20:00-00', 1);
CALL insert_time_slot(0, '2023-06-22 13:40:00-00', '2023-06-22 15:20:00-00', 2);
CALL insert_time_slot(1, '2023-06-22 08:40:00-00', '2023-06-22 11:20:00-00', 3);
CALL insert_time_slot(1, '2023-06-22 13:40:00-00', '2023-06-22 15:20:00-00', 4);
CALL insert_time_slot(2, '2023-06-22 08:40:00-00', '2023-06-22 11:20:00-00', 5);
CALL insert_time_slot(2, '2023-06-22 13:40:00-00', '2023-06-22 15:20:00-00', 6);
CALL insert_time_slot(3, '2023-06-22 08:40:00-00', '2023-06-22 11:20:00-00', 7);
CALL insert_time_slot(3, '2023-06-22 13:40:00-00', '2023-06-22 15:20:00-00', 8);
CALL insert_time_slot(4, '2023-06-22 08:40:00-00', '2023-06-22 11:20:00-00', 9);
CALL insert_time_slot(4, '2023-06-22 13:40:00-00', '2023-06-22 15:20:00-00', 10);
CALL insert_time_slot(4, '2023-06-22 08:40:00-00', '2023-06-22 11:20:00-00', 11);


CALL insert_student_has_contact_info(1, 1);
CALL insert_student_has_contact_info(2, 2);
CALL insert_student_has_contact_info(3, 3);
CALL insert_student_has_contact_info(4, 4);
CALL insert_student_has_contact_info(5, 5);
CALL insert_student_has_contact_info(6, 6);
CALL insert_student_has_contact_info(7, 7);
CALL insert_student_has_contact_info(8, 8);
CALL insert_student_has_contact_info(9, 9);
CALL insert_student_has_contact_info(10, 10);
CALL insert_student_has_contact_info(11, 11);


CALL insert_student_has_login_credentials(1, 1);
CALL insert_student_has_login_credentials(2, 2);
CALL insert_student_has_login_credentials(3, 3);
CALL insert_student_has_login_credentials(4, 4);
CALL insert_student_has_login_credentials(5, 5);
CALL insert_student_has_login_credentials(6, 6);
CALL insert_student_has_login_credentials(7, 7);
CALL insert_student_has_login_credentials(8, 8);
CALL insert_student_has_login_credentials(9, 9);
CALL insert_student_has_login_credentials(10, 10);
CALL insert_student_has_login_credentials(11, 11);


CALL insert_instructor_has_contact_info(1, 1);
CALL insert_instructor_has_contact_info(2, 2);
CALL insert_instructor_has_contact_info(3, 3);
CALL insert_instructor_has_contact_info(4, 4);
CALL insert_instructor_has_contact_info(5, 5);
CALL insert_instructor_has_contact_info(6, 6);
CALL insert_instructor_has_contact_info(7, 7);
CALL insert_instructor_has_contact_info(8, 8);
CALL insert_instructor_has_contact_info(9, 9);
CALL insert_instructor_has_contact_info(10, 10);
CALL insert_instructor_has_contact_info(11, 11);


CALL insert_instructor_has_login_credentials(1, 1);
CALL insert_instructor_has_login_credentials(2, 2);
CALL insert_instructor_has_login_credentials(3, 3);
CALL insert_instructor_has_login_credentials(4, 4);
CALL insert_instructor_has_login_credentials(5, 5);
CALL insert_instructor_has_login_credentials(6, 6);
CALL insert_instructor_has_login_credentials(7, 7);
CALL insert_instructor_has_login_credentials(8, 8);
CALL insert_instructor_has_login_credentials(9, 9);
CALL insert_instructor_has_login_credentials(10, 10);
CALL insert_instructor_has_login_credentials(11, 11);


CALL insert_student_enrolls_section(1, 1);
CALL insert_student_enrolls_section(2, 2);
CALL insert_student_enrolls_section(3, 3);
CALL insert_student_enrolls_section(4, 4);
CALL insert_student_enrolls_section(5, 5);
CALL insert_student_enrolls_section(6, 6);
CALL insert_student_enrolls_section(7, 7);
CALL insert_student_enrolls_section(8, 8);
CALL insert_student_enrolls_section(9, 9);
CALL insert_student_enrolls_section(10, 10);
CALL insert_student_enrolls_section(11, 11);


CALL insert_section_has_time_slot(1, 1);
CALL insert_section_has_time_slot(2, 2);
CALL insert_section_has_time_slot(3, 3);
CALL insert_section_has_time_slot(4, 4);
CALL insert_section_has_time_slot(5, 5);
CALL insert_section_has_time_slot(6, 6);
CALL insert_section_has_time_slot(7, 7);
CALL insert_section_has_time_slot(8, 8);
CALL insert_section_has_time_slot(9, 9);
CALL insert_section_has_time_slot(10, 10);
CALL insert_section_has_time_slot(11, 11);


CALL insert_homework_belongs_section(1, 1);
CALL insert_homework_belongs_section(2, 2);
CALL insert_homework_belongs_section(3, 3);
CALL insert_homework_belongs_section(4, 4);
CALL insert_homework_belongs_section(5, 5);
CALL insert_homework_belongs_section(6, 6);
CALL insert_homework_belongs_section(7, 7);
CALL insert_homework_belongs_section(8, 8);
CALL insert_homework_belongs_section(9, 9);
CALL insert_homework_belongs_section(10, 10);
CALL insert_homework_belongs_section(11, 11);


CALL insert_homework_has_submission(1, 1);
CALL insert_homework_has_submission(1, 2);
CALL insert_homework_has_submission(3, 3);
CALL insert_homework_has_submission(1, 4);
CALL insert_homework_has_submission(1, 5);
CALL insert_homework_has_submission(1, 6);
CALL insert_homework_has_submission(5, 7);
CALL insert_homework_has_submission(6, 8);
CALL insert_homework_has_submission(7, 9);
CALL insert_homework_has_submission(7, 10);
CALL insert_homework_has_submission(8, 11);