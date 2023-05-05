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
CALL insert_student('Abdurrahman', 'Özçağlayan', 21296013, '2012-08-10', 40, 1);
CALL insert_student('Efe', 'Çelik', 2200356833, '2020-07-28', 30, 3);
CALL insert_student('Tuğçe', 'Dönmez', 2212345678, '2021-07-15', 30, 5);
CALL insert_student('Ayşe Buket', 'Yağız', 2214545678, '2021-08-18', 30, 6);
CALL insert_student('İrem', 'Yağız', 2202345678, '2020-07-15', 30, 15);
CALL insert_student('Osman', 'Portakal', 2222345678, '2022-08-21', 30, 2);
CALL insert_student('Damla', 'Özdağ', 2202345678, '2020-08-21', 30, 2);
CALL insert_student('Emrah', 'Duman', 21745102, '2017-08-10', 40, 2);
CALL insert_student('Melek', 'Baykal', 21645102, '2016-08-10', 40, 1);
CALL insert_student('Özge', 'Burak', 21945177, '2019-07-10', 40, 1);
CALL insert_student('Alperen', 'Doğru', 21845102, '2018-08-20', 40, 1);
CALL insert_student('Ali', 'Veli', 21845102, '2018-07-10', 40, 1);
CALL insert_student('Burcu', 'Çiçek', 2212895678, '2021-07-10', 30, 1);
CALL insert_student('Almila', 'Dağlar', 2200895678, '2020-08-12', 30, 1);


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
CALL insert_student_contact_info('08498496489', 'emrahduman@gmail.com', 'Ankara', 12);
CALL insert_student_contact_info('08656565163', 'melekbaykal@gmail.com', 'Ankara', 13);
CALL insert_student_contact_info('07894561232', 'ozgeburak@gmail.com', 'Ankara', 14);
CALL insert_student_contact_info('08527891235', 'alperendogru@gmail.com', 'Edirne', 15);
CALL insert_student_contact_info('09637411237', 'aliveli@gmail.com', 'Ankara', 16);
CALL insert_student_contact_info('05550337285', 'burcucicek@gmail.com', 'Ankara', 17);
CALL insert_student_contact_info('06190555252', 'almiladaglar@gmail.com', 'Ankara', 18);


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
CALL insert_student_login_credentials('b21745102', 'M6w7BaZ3o0uHzAUsCvUe0k0zNlky798Ak2K1kvRQ2DL85UFBBMdBR92uNX8ZTDZM', 12);
CALL insert_student_login_credentials('b21645102', 'RSkkOrODZfLfu4JNtAJxCgmOWrKZ4lVJ4WmbTEF19p8GuBgCjVvJhP4Moyv9ZgNs', 13);
CALL insert_student_login_credentials('b21945177', 'SoVdI0xFdOhUQ2M8iMsgJOfBNk7HPMF2aYsteoysYWP5XNVq7pkGDorqFozhxlci', 14);
CALL insert_student_login_credentials('b21845102', '4CngBvRlOPxZED7aVc0nDT3vspkzJW2coWbVWcKMpKL55vEKmj2CQmMfvH6kJux9', 15);
CALL insert_student_login_credentials('b21946102', 'PnuZFoDIUeODTkjHDP1soQTQE12JWhFPKgUQNZgrMdH0lJYa8wHsdvUHEJwiefnb', 16);
CALL insert_student_login_credentials('b2212895678', 'GHePdGkDRS06xGmcYpkdbdRUoookCj4oIRG3oTfadSe7PGg1LiiKM8ff1b9jaymh', 17);
CALL insert_student_login_credentials('b2200895678', 'lcaQWT9K13nMvN4wcbOD7XvEd2msko6kzpPJs5TmfQKiCeixaGjO1gjNz3P8bfw7', 18);


CALL insert_instructor('Engin', 'Demir', 1);
CALL insert_instructor('Mehmet Erkut', 'Erdem', 1);
CALL insert_instructor('Adnan', 'Özsoy', 1);
CALL insert_instructor('Fuat', 'Akal', 1);
CALL insert_instructor('Ebru', 'Akçapınar Sezer', 1);
CALL insert_instructor('Harun', 'Artuner', 1);
CALL insert_instructor('Murat', 'Aydos', 2);
CALL insert_instructor('Ahmet Selman', 'Bozkır', 2);
CALL insert_instructor('Ahmet Burak', 'Can', 2);
CALL insert_instructor('İlyas', 'Çiçekli', 1);
CALL insert_instructor('Tunca', 'Doğan', 2);
CALL insert_instructor('Pınar', 'Duygulu Şahin', 1);
CALL insert_instructor('Mehmet Önder', 'Efe', 9);
CALL insert_instructor('Ebru', 'Gökalp Aydın', 12);
CALL insert_instructor('Nazlı', 'İkizler Cinbiş', 13);
CALL insert_instructor('Ayça', 'Kolukısa Tarhan', 14);


CALL insert_instructor_contact_info('01128549735', 'engindemir@gmail.com', 'Ankara', 1);
CALL insert_instructor_contact_info('04438193030', 'erkuterdem@gmail.com', 'Ankara', 2);
CALL insert_instructor_contact_info('05294093916', 'adnanozsoy@gmail.com', 'Ankara', 3);
CALL insert_instructor_contact_info('07101669719', 'fuatakal@gmail.com', 'Ankara', 4);
CALL insert_instructor_contact_info('07692466945', 'ebrusezer@gmail.com', 'Ankara', 5);
CALL insert_instructor_contact_info('01536996113', 'harunartuner@gmail.com', 'Ankara', 6);
CALL insert_instructor_contact_info('01391468350', 'murataydos@gmail.com', 'Ankara', 7);
CALL insert_instructor_contact_info('06337159101', 'asbozkir@gmail.com', 'Ankara', 8);
CALL insert_instructor_contact_info('08525230796', 'aburakcan@gmail.com', 'Ankara', 9);
CALL insert_instructor_contact_info('01036338604', 'ilyascicekli@gmail.com', 'Ankara', 10);
CALL insert_instructor_contact_info('07907135540', 'tuncadogan@gmail.com', 'Ankara', 11);
CALL insert_instructor_contact_info('09675304413', 'pinarduygulu@gmail.com', 'Ankara', 12);
CALL insert_instructor_contact_info('04284853517', 'mehmetonderefe@gmail.com', 'Ankara', 13);
CALL insert_instructor_contact_info('07506209378', 'ebrugokalp@gmail.com', 'Ankara', 14);
CALL insert_instructor_contact_info('02478041088', 'nazliikizlercinbis@gmail.com', 'Ankara', 15);
CALL insert_instructor_contact_info('05455511897', 'aycatarhan@gmail.com', 'Ankara', 16);


CALL insert_instructor_login_credentials('engin.demir', 'adb2c86cd366a11d033cd89934ebc31719b4305a6af8a95f2b1a8591c50d845c', 1);
CALL insert_instructor_login_credentials('erkut.erdem', '3923221780a0e4b606dc8dc309fb4049835dd59c5e1a561e78ea8c1dddd16b8b', 2);
CALL insert_instructor_login_credentials('adnan.ozsoy', 'a529eb61bf40b823466384d3e65b333fbb5b01b126bcc21e9c5b8d095d8eb356', 3);
CALL insert_instructor_login_credentials('fuat.akal', '2652ac401d43dcb290ed66fe28451b490f1c3df0b0d98f94ae9a445f599d7984', 4);
CALL insert_instructor_login_credentials('ebru.sezer', 'ebc4c796bf1dbe7f95b2d7f4c7d23e864d027d3d8158afd5c461687470bb6327', 5);
CALL insert_instructor_login_credentials('harun.artuner', '64377b72b8c9c6c1ab2fda13f142ca846362a10f0e73d67d7cbe3bdbb4657907', 6);
CALL insert_instructor_login_credentials('murat.aydos', '55555bcaef3c3c4aeb20f507cf0e261774d81f297c61131a4f01d302ca81a239', 7);
CALL insert_instructor_login_credentials('selman.bozkir', '1f54ce3ec624aa3e06dbb61b9aa1f4e9d093ec686c45358362c6cb4b33f51426', 8);
CALL insert_instructor_login_credentials('burak.can', 'b21c900cd05e4a16c2fef48efb1cbda82335cf06948b1f9fbdc020bc56941e4c', 9);
CALL insert_instructor_login_credentials('ilyas.cicekli', '135894da6641471b448c8656c1cd8f68e085063da9109c5ae14d9607227eac0b', 10);
CALL insert_instructor_login_credentials('tunca.dogan', 'ea30e35d55f2d0376ed046d412ba5c9295a1f85a185a94486bbdc5c8fd6864bb', 11);
CALL insert_instructor_login_credentials('pinar.duyglu', 'i8VJ6ReZxRFZmYRJ84otzuj3BDGrquS1IBS8JauAYaIXfYlILzv9nkjJxiZfjIMf', 12);
CALL insert_instructor_login_credentials('onder.efe', '2XS2NmXXda2qm3OOo69w4rZTuOcY6DLKEMgKOooLkg4DMeR7ipU30JrsYEyEp7v6', 13);
CALL insert_instructor_login_credentials('ebru.gokalp', 'qCkd7PjiPEzNWxRrI2wyQWEBatPA4KOG8yDKnfNfrI5Qz4j1nQWtMSPgzLyph1xm', 14);
CALL insert_instructor_login_credentials('nazli.ikizler', 'y8TDr5nxRX4ZqVjOd3RWOD3VZ4XoI7ozyTsChaRKEH4wlVcoIdgHyvLVTKXzgnYY', 15);
CALL insert_instructor_login_credentials('ayca.kolukisa', 'mlPCTaJIZeQ7nvHBzHhl6GmLWQ22CNdtDW9PAn72jZf0uOeaAgf1GjqU2NCya9p3', 16);


CALL insert_course('BBM101', 6, TRUE, 'Introducion to Programming I', 1);
CALL insert_course('BBM103', 4, TRUE, 'Introducion to Programming Lab I', 1);
CALL insert_course('BBM471', 6, FALSE, 'Database Management Systems', 1);
CALL insert_course('BBM473', 4, FALSE, 'Database Management Systems Lab', 1);
CALL insert_course('BBM405', 6, FALSE, 'Fundamentals of Artificial Intelligence', 1);
CALL insert_course('BBM102', 6, TRUE, 'Introducion to Programming II', 1);
CALL insert_course('BBM104', 4, TRUE, 'Introducion to Programming Lab II', 1);
CALL insert_course('BBM201', 6, TRUE, 'Data Structures', 1);
CALL insert_course('BBM203', 4, TRUE, 'Software Laboratory I', 1);
CALL insert_course('BBM401', 6, FALSE, 'Automata Theory and Formal Languages', 1);
CALL insert_course('ELE244', 6, TRUE, 'Electromagnetics I', 2);
CALL insert_course('ELE230', 6, TRUE, 'Electronics I', 2);
CALL insert_course('ELE475', 6, FALSE, 'High Voltage Technology', 2);
CALL insert_course('ELE477', 6, FALSE, 'Electric Machines II', 2);
CALL insert_course('ELE479', 2, FALSE, 'Electric Machines Laboratory II', 2);
CALL insert_course('ELE481', 6, FALSE, 'Electrical Power Systems I', 2);

--FALSE:FALL, TRUE:SPRING
CALL insert_section(FALSE, 2022, 'D1', 40, 1, 4);
CALL insert_section(FALSE, 2022, 'D2', 40, 1, 2);
CALL insert_section(FALSE, 2022, 'D3', 40, 1, 3);
CALL insert_section(TRUE, 2023, 'Seminer Hall', 60, 11, 6);
CALL insert_section(FALSE, 2023, 'Seminer Hall', 60, 11, 7);
CALL insert_section(FALSE, 2022, 'Computer Laboratory', 100, 2, 2);
CALL insert_section(FALSE, 2022, 'Computer Laboratory', 100, 2, 2);
CALL insert_section(TRUE, 2023, 'D10', 60, 3, 1);
CALL insert_section(TRUE, 2023, 'Computer Laboratory', 60, 4, 1);
CALL insert_section(TRUE, 2023, 'D8', 60, 5, 2);
CALL insert_section(TRUE, 2023, 'Seminer Hall', 60, 13, 6);
CALL insert_section(TRUE, 2023, 'Seminer Hall', 60, 10, 7);
CALL insert_section(TRUE, 2023, 'Z1', 60, 13, 8);
CALL insert_section(TRUE, 2023, 'Z2', 60, 13, 9);
CALL insert_section(TRUE, 2023, 'Seminer Hall', 50, 14, 10);
CALL insert_section(TRUE, 2023, 'Seminer Hall', 50, 14, 11);
CALL insert_section(FALSE, 2021, 'D1', 40, 1, 4);
CALL insert_section(FALSE, 2021, 'D2', 40, 1, 2);
CALL insert_section(FALSE, 2021, 'D3', 40, 1, 3);
CALL insert_section(FALSE, 2021, 'Computer Laboratory', 100, 2, 2);
CALL insert_section(FALSE, 2021, 'Computer Laboratory', 100, 2, 2);


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
CALL insert_student_has_contact_info(12, 12);
CALL insert_student_has_contact_info(13, 13);
CALL insert_student_has_contact_info(14, 14);
CALL insert_student_has_contact_info(15, 15);
CALL insert_student_has_contact_info(16, 16);
CALL insert_student_has_contact_info(17, 17);
CALL insert_student_has_contact_info(18, 18);


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
CALL insert_student_has_login_credentials(12, 12);
CALL insert_student_has_login_credentials(13, 13);
CALL insert_student_has_login_credentials(14, 14);
CALL insert_student_has_login_credentials(15, 15);
CALL insert_student_has_login_credentials(16, 16);
CALL insert_student_has_login_credentials(17, 17);
CALL insert_student_has_login_credentials(18, 18);


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
CALL insert_instructor_has_contact_info(12, 12);
CALL insert_instructor_has_contact_info(13, 13);
CALL insert_instructor_has_contact_info(14, 14);
CALL insert_instructor_has_contact_info(15, 15);
CALL insert_instructor_has_contact_info(16, 16);


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
CALL insert_instructor_has_login_credentials(12, 12);
CALL insert_instructor_has_login_credentials(13, 13);
CALL insert_instructor_has_login_credentials(14, 14);
CALL insert_instructor_has_login_credentials(15, 15);
CALL insert_instructor_has_login_credentials(16, 16);


CALL insert_section_has_time_slot(1, 1);
CALL insert_section_has_time_slot(1, 2);
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
CALL insert_section_has_time_slot(12, 2);
CALL insert_section_has_time_slot(13, 3);
CALL insert_section_has_time_slot(14, 4);
CALL insert_section_has_time_slot(15, 5);
CALL insert_section_has_time_slot(16, 6);
CALL insert_section_has_time_slot(17, 7);
CALL insert_section_has_time_slot(18, 8);
CALL insert_section_has_time_slot(19, 9);
CALL insert_section_has_time_slot(20, 10);
CALL insert_section_has_time_slot(21, 11);


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


CALL insert_student_enrolls_section(1, 1, 0, 0, TRUE);
CALL insert_student_enrolls_section(2, 1, 0, 0, TRUE);
CALL insert_student_enrolls_section(3, 1, 0, 0, TRUE);
CALL insert_student_enrolls_section(4, 2, 0, 0, TRUE);
CALL insert_student_enrolls_section(5, 2, 0, 0, FALSE);
CALL insert_student_enrolls_section(6, 7, 0, 0, FALSE);
CALL insert_student_enrolls_section(7, 9, 0, 0, FALSE);
CALL insert_student_enrolls_section(8, 6, 0, 0, FALSE);
CALL insert_student_enrolls_section(9, 10, 0, 0, TRUE);
CALL insert_student_enrolls_section(10, 8, 0, 0, TRUE);
CALL insert_student_enrolls_section(11, 8, 0, 0, TRUE);


CALL insert_student_belongs_department(1, 1);
CALL insert_student_belongs_department(2, 1);
CALL insert_student_belongs_department(3, 1);
CALL insert_student_belongs_department(4, 1);
CALL insert_student_belongs_department(5, 1);
CALL insert_student_belongs_department(6, 2);
CALL insert_student_belongs_department(7, 2);
CALL insert_student_belongs_department(8, 2);
CALL insert_student_belongs_department(9, 2);
CALL insert_student_belongs_department(10, 2);
CALL insert_student_belongs_department(11, 2);


CALL insert_student_has_submission(1, 1);
CALL insert_student_has_submission(2, 2);
CALL insert_student_has_submission(3, 3);
CALL insert_student_has_submission(4, 4);
CALL insert_student_has_submission(5, 5);
CALL insert_student_has_submission(6, 6);
CALL insert_student_has_submission(7, 7);
CALL insert_student_has_submission(8, 8);
CALL insert_student_has_submission(9, 9);
CALL insert_student_has_submission(10, 10);
CALL insert_student_has_submission(11, 11);


CALL insert_instructor_teaches_section(4, 1);
CALL insert_instructor_teaches_section(2, 2);
CALL insert_instructor_teaches_section(3, 3);
CALL insert_instructor_teaches_section(6, 4);
CALL insert_instructor_teaches_section(7, 5);
CALL insert_instructor_teaches_section(2, 6);
CALL insert_instructor_teaches_section(2, 7);
CALL insert_instructor_teaches_section(1, 8);
CALL insert_instructor_teaches_section(1, 9);
CALL insert_instructor_teaches_section(2, 10);
CALL insert_instructor_teaches_section(6, 11);
CALL insert_instructor_teaches_section(7, 12);
CALL insert_instructor_teaches_section(8, 13);
CALL insert_instructor_teaches_section(9, 14);
CALL insert_instructor_teaches_section(10, 15);
CALL insert_instructor_teaches_section(11, 16);
CALL insert_instructor_teaches_section(4, 17);
CALL insert_instructor_teaches_section(2, 18);
CALL insert_instructor_teaches_section(3, 19);
CALL insert_instructor_teaches_section(2, 20);
CALL insert_instructor_teaches_section(2, 21);


CALL insert_instructor_advisor_student(1, 1);
CALL insert_instructor_advisor_student(1, 2);
CALL insert_instructor_advisor_student(1, 3);
CALL insert_instructor_advisor_student(1, 4);
CALL insert_instructor_advisor_student(2, 5);
CALL insert_instructor_advisor_student(2, 6);
CALL insert_instructor_advisor_student(2, 7);
CALL insert_instructor_advisor_student(2, 8);
CALL insert_instructor_advisor_student(2, 9);
CALL insert_instructor_advisor_student(2, 10);
CALL insert_instructor_advisor_student(3, 11);
CALL insert_instructor_advisor_student(4, 12);
CALL insert_instructor_advisor_student(5, 13);
CALL insert_instructor_advisor_student(6, 14);
CALL insert_instructor_advisor_student(7, 15);
CALL insert_instructor_advisor_student(8, 16);
CALL insert_instructor_advisor_student(9, 17);
CALL insert_instructor_advisor_student(10, 18);


CALL insert_instructor_belongs_department(1, 1);
CALL insert_instructor_belongs_department(2, 1);
CALL insert_instructor_belongs_department(3, 1);
CALL insert_instructor_belongs_department(4, 1);
CALL insert_instructor_belongs_department(5, 1);
CALL insert_instructor_belongs_department(6, 1);
CALL insert_instructor_belongs_department(7, 2);
CALL insert_instructor_belongs_department(8, 2);
CALL insert_instructor_belongs_department(9, 2);
CALL insert_instructor_belongs_department(10, 1);
CALL insert_instructor_belongs_department(11, 2);
CALL insert_instructor_belongs_department(12, 1);
CALL insert_instructor_belongs_department(13, 9);
CALL insert_instructor_belongs_department(14, 12);
CALL insert_instructor_belongs_department(15, 13);
CALL insert_instructor_belongs_department(16, 14);


CALL insert_faculty_has_department(1, 1);
CALL insert_faculty_has_department(1, 2);
CALL insert_faculty_has_department(1, 3);
CALL insert_faculty_has_department(2, 4);
CALL insert_faculty_has_department(3, 5);
CALL insert_faculty_has_department(4, 6);
CALL insert_faculty_has_department(5, 7);
CALL insert_faculty_has_department(6, 8);
CALL insert_faculty_has_department(6, 9);
CALL insert_faculty_has_department(6, 10);
CALL insert_faculty_has_department(6, 11);
CALL insert_faculty_has_department(7, 12);
CALL insert_faculty_has_department(8, 13);
CALL insert_faculty_has_department(8, 14);
CALL insert_faculty_has_department(8, 15);
CALL insert_faculty_has_department(9, 16);
CALL insert_faculty_has_department(10, 17);


CALL insert_course_requires_course(6, 1);
CALL insert_course_requires_course(6, 2);
CALL insert_course_requires_course(8, 1);
CALL insert_course_requires_course(8, 2);
CALL insert_course_requires_course(8, 6);
CALL insert_course_requires_course(8, 7);
CALL insert_course_requires_course(3, 8);
CALL insert_course_requires_course(3, 9);
CALL insert_course_requires_course(13, 11);
CALL insert_course_requires_course(16, 12);


CALL insert_course_belongs_department(1, 1);
CALL insert_course_belongs_department(2, 1);
CALL insert_course_belongs_department(3, 1);
CALL insert_course_belongs_department(4, 1);
CALL insert_course_belongs_department(5, 1);
CALL insert_course_belongs_department(6, 1);
CALL insert_course_belongs_department(7, 1);
CALL insert_course_belongs_department(8, 1);
CALL insert_course_belongs_department(9, 1);
CALL insert_course_belongs_department(10, 1);
CALL insert_course_belongs_department(11, 2);
CALL insert_course_belongs_department(12, 2);
CALL insert_course_belongs_department(13, 2);
CALL insert_course_belongs_department(14, 2);
CALL insert_course_belongs_department(15, 2);
CALL insert_course_belongs_department(16, 2);


CALL insert_section_belongs_course(1, 1);
CALL insert_section_belongs_course(2, 1);
CALL insert_section_belongs_course(3, 1);
CALL insert_section_belongs_course(4, 11);
CALL insert_section_belongs_course(5, 11);
CALL insert_section_belongs_course(6, 2);
CALL insert_section_belongs_course(7, 2);
CALL insert_section_belongs_course(8, 3);
CALL insert_section_belongs_course(9, 4);
CALL insert_section_belongs_course(10, 5);
CALL insert_section_belongs_course(11, 13);
CALL insert_section_belongs_course(12, 10);
CALL insert_section_belongs_course(13, 13);
CALL insert_section_belongs_course(14, 13);
CALL insert_section_belongs_course(15, 14);
CALL insert_section_belongs_course(16, 14);
CALL insert_section_belongs_course(17, 1);
CALL insert_section_belongs_course(18, 1);
CALL insert_section_belongs_course(19, 1);
CALL insert_section_belongs_course(20, 2);
CALL insert_section_belongs_course(21, 2);