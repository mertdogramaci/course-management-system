package com.group20.coursemanagementsystem;

import com.group20.coursemanagementsystem.enums.Day;
import com.group20.coursemanagementsystem.enums.Semester;
import com.group20.coursemanagementsystem.model.*;
import com.group20.coursemanagementsystem.repository.*;
import com.group20.coursemanagementsystem.security.repositories.AuthorityRepository;
import com.group20.coursemanagementsystem.security.domain.Authority;
import javax.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.group20.coursemanagementsystem.enums.MemberType;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DatabasePopulator {

    private final FacultyRepository facultyRepository;

    private final DepartmentRepository departmentRepository;

    private final SectionRepository sectionRepository;

    private final CourseRepository courseRepository;

    private final AuthorityRepository authorityRepository;

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final HomeworkRepository homeworkRepository;

    private final SubmissionRepository submissionRepository;

    private final TimeSlotRepository timeSlotRepository;

    public DatabasePopulator(FacultyRepository facultyRepository, DepartmentRepository departmentRepository,
                             SectionRepository sectionRepository, CourseRepository courseRepository,
                             AuthorityRepository authorityRepository, MemberRepository memberRepository,
                             PasswordEncoder passwordEncoder, HomeworkRepository homeworkRepository,
                             SubmissionRepository submissionRepository, TimeSlotRepository timeSlotRepository) {
        this.facultyRepository = facultyRepository;
        this.departmentRepository = departmentRepository;
        this.sectionRepository = sectionRepository;
        this.courseRepository = courseRepository;
        this.authorityRepository = authorityRepository;
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.homeworkRepository = homeworkRepository;
        this.submissionRepository = submissionRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

    @Transactional
    public void populateDatabase() {
        if (!authorityRepository.existsByAuthority("ADMIN")) {
            authorityRepository.save(new Authority(null, "ADMIN", new HashSet<>()));
        }
        if (!authorityRepository.existsByAuthority("MEMBER")) {
            authorityRepository.save(new Authority(null, "MEMBER", new HashSet<>()));
        }
        if (!authorityRepository.existsByAuthority("STUDENT")) {
            authorityRepository.save(new Authority(null, "STUDENT", new HashSet<>()));
        }
        if (!authorityRepository.existsByAuthority("INSTRUCTOR")) {
            authorityRepository.save(new Authority(null, "INSTRUCTOR", new HashSet<>()));
        }

        facultyRepository.save(new Faculty("Engineering"));
        facultyRepository.save(new Faculty("Medical School"));
        facultyRepository.save(new Faculty("Foreign Languages"));
        facultyRepository.save(new Faculty("Sport Science"));
        facultyRepository.save(new Faculty("Law"));
        facultyRepository.save(new Faculty("Economics and Administrative Sciences"));
        facultyRepository.save(new Faculty("Pharmacy"));
        facultyRepository.save(new Faculty("Science and Literature"));
        facultyRepository.save(new Faculty("Fine Arts"));
        facultyRepository.save(new Faculty("Communication"));


        Faculty faculty1 = facultyRepository.findById(1L);
        Faculty faculty2 = facultyRepository.findById(2L);
        Faculty faculty3 = facultyRepository.findById(3L);
        Faculty faculty4 = facultyRepository.findById(4L);
        Faculty faculty5 = facultyRepository.findById(5L);
        Faculty faculty6 = facultyRepository.findById(6L);
        Faculty faculty7 = facultyRepository.findById(7L);
        Faculty faculty8 = facultyRepository.findById(8L);
        Faculty faculty9 = facultyRepository.findById(9L);
        Faculty faculty10 = facultyRepository.findById(10L);

        departmentRepository.save(new Department("Computer Engineering", faculty1));
        departmentRepository.save(new Department("Electrical and Electronic Engineering", faculty1));
        departmentRepository.save(new Department("Industrial Engineering", faculty1));
        departmentRepository.save(new Department("Medicine", faculty2));
        departmentRepository.save(new Department("Modern Languages", faculty3));
        departmentRepository.save(new Department("Physical Education and Sports Teaching", faculty4));
        departmentRepository.save(new Department("Civil Law", faculty5));
        departmentRepository.save(new Department("Economics", faculty6));
        departmentRepository.save(new Department("Business Administration", faculty6));
        departmentRepository.save(new Department("International Relations", faculty6));
        departmentRepository.save(new Department("Public Finance", faculty6));
        departmentRepository.save(new Department("Pharmacology", faculty7));
        departmentRepository.save(new Department("Statistics", faculty8));
        departmentRepository.save(new Department("Physics", faculty8));
        departmentRepository.save(new Department("Psychology", faculty8));
        departmentRepository.save(new Department("Cartoon and Animation", faculty9));
        departmentRepository.save(new Department("Radio, TV and Film", faculty10));


        Department department1 = departmentRepository.findById(1L);
        Department department2 = departmentRepository.findById(2L);
        Department department3 = departmentRepository.findById(3L);
        Department department4 = departmentRepository.findById(4L);
        Department department5 = departmentRepository.findById(5L);
        Department department6 = departmentRepository.findById(6L);
        Department department7 = departmentRepository.findById(7L);
        Department department8 = departmentRepository.findById(8L);
        Department department9 = departmentRepository.findById(9L);
        Department department10 = departmentRepository.findById(10L);
        Department department11 = departmentRepository.findById(11L);
        Department department12 = departmentRepository.findById(12L);
        Department department13 = departmentRepository.findById(13L);
        Department department14 = departmentRepository.findById(14L);
        Department department15 = departmentRepository.findById(15L);
        Department department16 = departmentRepository.findById(16L);
        Department department17 = departmentRepository.findById(17L);

        Student member = new Student(
                "Özgün", "Akyüz", "zgnakyuz@gmail.com",
                passwordEncoder.encode("özgün"), "507 296 64 91",
                "Hi i'm Özgün Akyüz, I am a 3rd year computer engineering student.",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department1, "21827005", 40
        );
        memberRepository.save(member);
        member = new Student("Mert", "Doğramacı", "mertdogramaci@gmail.com",
                passwordEncoder.encode("deneme"), "05425252477",
                "Yenibağlar Mah Eti Cad Görenek Sok Final Sit D/8 Tepebaşı/Eskişehir", MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department1, "21946055", 40);
        memberRepository.save(member);
        member = new Student("Emre", "Akdeniz", "emreakdeniz@gmail.com",
                passwordEncoder.encode("deneme"), "02134567899", "Eskişehir",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department4, "21945102", 40);
        memberRepository.save(member);
        member = new Student("Eser", "Vatansever", "eservatansever@gmail.com",
                passwordEncoder.encode("deneme"), "01234567899", "İstanbul",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department2, "21947727", 40);
        memberRepository.save(member);
        member = new Student("Abdurrahman", "Özçağlayan", "abdurrahman@gmail.com",
                passwordEncoder.encode("deneme"), "05421234567", "Ankara",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department1, "21296013", 40);
        memberRepository.save(member);
        member = new Student("Efe", "Çelik", "efecelik@gmail.com",
                passwordEncoder.encode("deneme"), "05987654321", "Ankara",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department3, "2200356833", 30);
        memberRepository.save(member);
        member = new Student("Tuğçe", "Dönmez", "tugcedonmez@gmail.com",
                passwordEncoder.encode("deneme"), "09638527411", "Ankara",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department5, "2212345678", 30);
        memberRepository.save(member);
        member = new Student("Ayşe Buket", "Yağız", "aysebuketyagiz@gmail.com",
                passwordEncoder.encode("deneme"), "07418529633", "Kocaeli",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department6, "2214545678", 30);
        memberRepository.save(member);
        member = new Student("İrem", "Yağız", "iremyagiz@gmail.com",
                passwordEncoder.encode("deneme"), "08527419633", "Tokat",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department15, "2202345698", 30);
        memberRepository.save(member);
        member = new Student("Osman", "Portakal", "osmanportakal@gmail.com",
                passwordEncoder.encode("deneme"), "08529637411", "Mersin",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department2, "2222345678", 30);
        memberRepository.save(member);
        member = new Student("Damla", "Özdağ", "damlaozdag@gmail.com",
                passwordEncoder.encode("deneme"), "08529637411", "Ankara",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department2, "2202345678", 30);
        memberRepository.save(member);
        member = new Student("Emrah", "Duman", "emrahduman@gmail.com",
                passwordEncoder.encode("deneme"), "08498496489", "Ankara",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department2, "21745102", 40);
        memberRepository.save(member);
        member = new Student("Melek", "Baykal", "melekbaykal@gmail.com",
                passwordEncoder.encode("deneme"), "08656565163", "Ankara",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department1, "21645102", 40);
        memberRepository.save(member);
        member = new Student("Özge", "Burak", "ozgeburak@gmail.com",
                passwordEncoder.encode("deneme"), "07894561232", "Ankara",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department1, "21945177", 40);
        memberRepository.save(member);
        member = new Student("Alperen", "Doğru", "alperendogru@gmail.com",
                passwordEncoder.encode("deneme"), "08527891235", "Edirne",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department1, "21845102", 40);
        memberRepository.save(member);
        member = new Student("Ali", "Veli", "aliveli@gmail.com",
                passwordEncoder.encode("deneme"), "09637411237", "Ankara",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department1, "21845112", 40);
        memberRepository.save(member);
        member = new Student("Burcu", "Çiçek", "burcucicek@gmail.com",
                passwordEncoder.encode("deneme"), "05550337285", "Ankara",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department1, "2212895678", 30);
        memberRepository.save(member);
        member = new Student("Almila", "Dağlar", "almiladaglar@gmail.com",
                passwordEncoder.encode("deneme"), "06190555252", "Ankara",
                MemberType.STUDENT,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")),
                department1, "2200895678", 30);
        memberRepository.save(member);


        Student student1 = (Student) memberRepository.findById(1L);
        Student student2 = (Student) memberRepository.findById(2L);
        Student student3 = (Student) memberRepository.findById(3L);
        Student student4 = (Student) memberRepository.findById(4L);
        Student student5 = (Student) memberRepository.findById(5L);
        Student student6 = (Student) memberRepository.findById(6L);
        Student student7 = (Student) memberRepository.findById(7L);
        Student student8 = (Student) memberRepository.findById(8L);
        Student student9 = (Student) memberRepository.findById(9L);
        Student student10 = (Student) memberRepository.findById(10L);
        Student student11 = (Student) memberRepository.findById(11L);
        Student student12 = (Student) memberRepository.findById(12L);
        Student student13 = (Student) memberRepository.findById(13L);
        Student student14 = (Student) memberRepository.findById(14L);
        Student student15 = (Student) memberRepository.findById(15L);
        Student student16 = (Student) memberRepository.findById(16L);
        Student student17 = (Student) memberRepository.findById(17L);
        Student student18 = (Student) memberRepository.findById(18L);


        Instructor instructor = new Instructor("Engin", "Demir", "engindemir@gmail.com",
                passwordEncoder.encode("deneme"), "01128549735", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department1);
        memberRepository.save(instructor);
        instructor = new Instructor("Mehmet Erkut", "Erdem", "erkuterdem@gmail.com",
                passwordEncoder.encode("deneme"), "04438193030", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department1);
        memberRepository.save(instructor);
        instructor = new Instructor("Adnan", "Özsoy", "adnanozsoy@gmail.com",
                passwordEncoder.encode("deneme"), "05294093916", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department1);
        memberRepository.save(instructor);
        instructor = new Instructor("Fuat", "Akal", "fuatakal@gmail.com",
                passwordEncoder.encode("deneme"), "07101669719", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department1);
        memberRepository.save(instructor);
        instructor = new Instructor("Ebru", "Akçapınar Sezer", "ebrusezer@gmail.com",
                passwordEncoder.encode("deneme"), "07692466945", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department1);
        memberRepository.save(instructor);
        instructor = new Instructor("Harun", "Artuner", "harunartuner@gmail.com",
                passwordEncoder.encode("deneme"), "01536996113", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department1);
        memberRepository.save(instructor);
        instructor = new Instructor("Murat", "Aydos", "murataydos@gmail.com",
                passwordEncoder.encode("deneme"), "01391468350", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department2);
        memberRepository.save(instructor);
        instructor = new Instructor("Ahmet Selman", "Bozkır", "asbozkir@gmail.com",
                passwordEncoder.encode("deneme"), "06337159101", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department3);
        memberRepository.save(instructor);
        instructor = new Instructor("Ahmet Burak", "Can", "aburakcan@gmail.com",
                passwordEncoder.encode("deneme"), "08525230796", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department2);
        memberRepository.save(instructor);
        instructor = new Instructor("İlyas", "Çiçekli", "ilyascicekli@gmail.com",
                passwordEncoder.encode("deneme"), "01036338604", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department1);
        memberRepository.save(instructor);
        instructor = new Instructor("Tunca", "Doğan", "tuncadogan@gmail.com",
                passwordEncoder.encode("deneme"), "07907135540", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department2);
        memberRepository.save(instructor);
        instructor = new Instructor("Pınar", "Duygulu Şahin", "pinarduygulu@gmail.com",
                passwordEncoder.encode("deneme"), "09675304413", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department1);
        memberRepository.save(instructor);
        instructor = new Instructor("Mehmet Önder", "Efe", "mehmetonderefe@gmail.com",
                passwordEncoder.encode("deneme"), "04284853517", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department9);
        memberRepository.save(instructor);
        instructor = new Instructor("Ebru", "Gökalp Aydın", "ebrugokalp@gmail.com",
                passwordEncoder.encode("deneme"),"07506209378", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department12);
        memberRepository.save(instructor);
        instructor = new Instructor("Nazlı", "İkizler Cinbiş", "nazliikizlercinbis@gmail.com",
                passwordEncoder.encode("deneme"), "02478041088", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department13);
        memberRepository.save(instructor);
        instructor = new Instructor("Ayça", "Kolukısa Tarhan", "aycatarhan@gmail.com",
                passwordEncoder.encode("deneme"), "05455511897", "Ankara",
                MemberType.INSTRUCTOR,
                Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")),
                department14);
        memberRepository.save(instructor);


        Instructor instructor1 = (Instructor) memberRepository.findById(19L);
        Instructor instructor2 = (Instructor) memberRepository.findById(20L);
        Instructor instructor3 = (Instructor) memberRepository.findById(21L);
        Instructor instructor4 = (Instructor) memberRepository.findById(22L);
        Instructor instructor5 = (Instructor) memberRepository.findById(23L);
        Instructor instructor6 = (Instructor) memberRepository.findById(24L);
        Instructor instructor7 = (Instructor) memberRepository.findById(25L);
        Instructor instructor8 = (Instructor) memberRepository.findById(26L);
        Instructor instructor9 = (Instructor) memberRepository.findById(27L);
        Instructor instructor10 = (Instructor) memberRepository.findById(28L);
        Instructor instructor11 = (Instructor) memberRepository.findById(29L);
        Instructor instructor12 = (Instructor) memberRepository.findById(30L);
        Instructor instructor13 = (Instructor) memberRepository.findById(31L);
        Instructor instructor14 = (Instructor) memberRepository.findById(32L);
        Instructor instructor15 = (Instructor) memberRepository.findById(33L);
        Instructor instructor16 = (Instructor) memberRepository.findById(34L);


        courseRepository.save(new Course("BBM101", 6, true,
                "Introducion to Programming I", department1));
        courseRepository.save(new Course("BBM103", 4, true,
                "Introducion to Programming Lab I", department1));
        courseRepository.save(new Course("BBM471", 6, false,
                "Database Management Systems", department1));
        courseRepository.save(new Course("BBM473", 4, false,
                "Database Management Systems Lab", department1));
        courseRepository.save(new Course("BBM405", 6, false,
                "Fundamentals of Artificial Intelligence", department1));
        courseRepository.save(new Course("BBM102", 6, true,
                "Introducion to Programming II", department1));
        courseRepository.save(new Course("BBM104", 4, true,
                "Introducion to Programming Lab II", department1));
        courseRepository.save(new Course("BBM201", 6, true, "Data Structures",
                department1));
        courseRepository.save(new Course("BBM203", 4, true, "Software Laboratory I",
                department1));
        courseRepository.save(new Course("BBM401", 6, false,
                "Automata Theory and Formal Languages", department1));
        courseRepository.save(new Course("ELE244", 6, true, "Electromagnetics I",
                department2));
        courseRepository.save(new Course("ELE230", 6, true, "Electronics I",
                department2));
        courseRepository.save(new Course("ELE475", 6, false, "High Voltage Technology",
                department2));
        courseRepository.save(new Course("ELE477", 6, false, "Electric Machines II",
                department2));
        courseRepository.save(new Course("ELE479", 2, false,
                "Electric Machines Laboratory II", department2));
        courseRepository.save(new Course("ELE481", 6, false, "Electrical Power Systems I",
                department2));


        Course course1 = courseRepository.findById(1L);
        Course course2 = courseRepository.findById(2L);
        Course course3 = courseRepository.findById(3L);
        Course course4 = courseRepository.findById(4L);
        Course course5 = courseRepository.findById(5L);
        Course course6 = courseRepository.findById(6L);
        Course course7 = courseRepository.findById(7L);
        Course course8 = courseRepository.findById(8L);
        Course course9 = courseRepository.findById(9L);
        Course course10 = courseRepository.findById(10L);
        Course course11 = courseRepository.findById(11L);
        Course course12 = courseRepository.findById(12L);
        Course course13 = courseRepository.findById(13L);
        Course course14 = courseRepository.findById(14L);
        Course course15 = courseRepository.findById(15L);
        Course course16 = courseRepository.findById(16L);


        sectionRepository.save(new Section(Semester.FALL, 2022, "D1", 40, course1,
                instructor4));
        sectionRepository.save(new Section(Semester.FALL, 2022, "D2", 40, course1,
                instructor2));
        sectionRepository.save(new Section(Semester.FALL, 2022, "D3", 40, course1,
                instructor3));
        sectionRepository.save(new Section(Semester.SPRING, 2023, "Seminer Hall", 60, course11,
                instructor6));
        sectionRepository.save(new Section(Semester.FALL, 2023, "Seminer Hall", 60, course11,
                instructor7));
        sectionRepository.save(new Section(Semester.FALL, 2022, "Computer Laboratory", 100,
                course2, instructor2));
        sectionRepository.save(new Section(Semester.FALL, 2022, "Computer Laboratory", 100,
                course2, instructor2));
        sectionRepository.save(new Section(Semester.SPRING, 2023, "D10", 60, course3,
                instructor1));
        sectionRepository.save(new Section(Semester.SPRING, 2023, "Computer Laboratory", 60,
                course4, instructor1));
        sectionRepository.save(new Section(Semester.SPRING, 2023, "D8", 60, course5,
                instructor2));
        sectionRepository.save(new Section(Semester.SPRING, 2023, "Seminer Hall", 60, course13,
                instructor6));
        sectionRepository.save(new Section(Semester.SPRING, 2023, "Seminer Hall", 60, course10,
                instructor7));
        sectionRepository.save(new Section(Semester.SPRING, 2023, "Z1", 60, course13,
                instructor8));
        sectionRepository.save(new Section(Semester.SPRING, 2023, "Z2", 60, course13,
                instructor9));
        sectionRepository.save(new Section(Semester.SPRING, 2023, "Seminer Hall", 50, course14,
                instructor10));
        sectionRepository.save(new Section(Semester.SPRING, 2023, "Seminer Hall", 50, course14,
                instructor11));
        sectionRepository.save(new Section(Semester.FALL, 2021, "D1", 40, course1, instructor4));
        sectionRepository.save(new Section(Semester.FALL, 2021, "D2", 40, course1, instructor2));
        sectionRepository.save(new Section(Semester.FALL, 2021, "D3", 40, course1, instructor3));
        sectionRepository.save(new Section(Semester.FALL, 2021, "Computer Laboratory", 100,
                course2, instructor2));
        sectionRepository.save(new Section(Semester.FALL, 2021, "Computer Laboratory", 100,
                course2, instructor2));


        Section section1 = sectionRepository.findById(1L);
        Section section2 = sectionRepository.findById(2L);
        Section section3 = sectionRepository.findById(3L);
        Section section4 = sectionRepository.findById(4L);
        Section section5 = sectionRepository.findById(5L);
        Section section6 = sectionRepository.findById(6L);
        Section section7 = sectionRepository.findById(7L);
        Section section8 = sectionRepository.findById(8L);
        Section section9 = sectionRepository.findById(9L);
        Section section10 = sectionRepository.findById(10L);
        Section section11 = sectionRepository.findById(11L);
        Section section12 = sectionRepository.findById(12L);
        Section section13 = sectionRepository.findById(13L);
        Section section14 = sectionRepository.findById(14L);
        Section section15 = sectionRepository.findById(15L);
        Section section16 = sectionRepository.findById(16L);
        Section section17 = sectionRepository.findById(17L);
        Section section18 = sectionRepository.findById(18L);
        Section section19 = sectionRepository.findById(19L);
        Section section20 = sectionRepository.findById(20L);
        Section section21 = sectionRepository.findById(21L);


        homeworkRepository.save(new Homework("topic1", new Byte[]{},
                LocalDateTime.of(2023, 4, 19, 10, 0),
                LocalDateTime.of(2023, 4, 23, 23, 59), section1));
        homeworkRepository.save(new Homework("topic2", new Byte[]{},
                LocalDateTime.of(2023, 4, 19, 10, 0),
                LocalDateTime.of(2023, 4, 23, 23, 59), section2));
        homeworkRepository.save(new Homework("topic3", new Byte[]{},
                LocalDateTime.of(2023, 4, 19, 10, 0),
                LocalDateTime.of(2023, 4, 23, 23, 59), section3));
        homeworkRepository.save(new Homework("topic4", new Byte[]{},
                LocalDateTime.of(2023, 4, 19, 10, 0),
                LocalDateTime.of(2023, 4, 23, 23, 59), section4));
        homeworkRepository.save(new Homework("topic5", new Byte[]{},
                LocalDateTime.of(2023, 4, 19, 10, 0),
                LocalDateTime.of(2023, 4, 23, 23, 59), section5));
        homeworkRepository.save(new Homework("topic6", new Byte[]{},
                LocalDateTime.of(2023, 4, 19, 10, 0),
                LocalDateTime.of(2023, 4, 23, 23, 59), section6));
        homeworkRepository.save(new Homework("topic7", new Byte[]{},
                LocalDateTime.of(2023, 4, 19, 10, 0),
                LocalDateTime.of(2023, 4, 23, 23, 59), section7));
        homeworkRepository.save(new Homework("topic8", new Byte[]{},
                LocalDateTime.of(2023, 4, 19, 10, 0),
                LocalDateTime.of(2023, 4, 23, 23, 59), section8));
        homeworkRepository.save(new Homework("topic9", new Byte[]{},
                LocalDateTime.of(2023, 4, 19, 10, 0),
                LocalDateTime.of(2023, 4, 23, 23, 59), section9));
        homeworkRepository.save(new Homework("topic10", new Byte[]{},
                LocalDateTime.of(2023, 4, 19, 10, 0),
                LocalDateTime.of(2023, 4, 23, 23, 59), section10));
        homeworkRepository.save(new Homework("topic11", new Byte[]{},
                LocalDateTime.of(2023, 4, 19, 10, 0),
                LocalDateTime.of(2023, 4, 23, 23, 59), section11));


        Homework homework1 = homeworkRepository.findById(1L);
        Homework homework2 = homeworkRepository.findById(2L);
        Homework homework3 = homeworkRepository.findById(3L);
        Homework homework4 = homeworkRepository.findById(4L);
        Homework homework5 = homeworkRepository.findById(5L);
        Homework homework6 = homeworkRepository.findById(6L);
        Homework homework7 = homeworkRepository.findById(7L);
        Homework homework8 = homeworkRepository.findById(8L);
        Homework homework9 = homeworkRepository.findById(9L);
        Homework homework10 = homeworkRepository.findById(10L);
        Homework homework11 = homeworkRepository.findById(11L);


        submissionRepository.save(new Submission(90, new Byte[]{}, student1, homework1));
        submissionRepository.save(new Submission(80, new Byte[]{}, student2, homework1));
        submissionRepository.save(new Submission(75, new Byte[]{}, student3, homework3));
        submissionRepository.save(new Submission(45, new Byte[]{}, student4, homework3));
        submissionRepository.save(new Submission(86, new Byte[]{}, student5, homework1));
        submissionRepository.save(new Submission(56, new Byte[]{}, student6, homework1));
        submissionRepository.save(new Submission(35, new Byte[]{}, student7, homework5));
        submissionRepository.save(new Submission(45, new Byte[]{}, student8, homework6));
        submissionRepository.save(new Submission(15, new Byte[]{}, student9, homework7));
        submissionRepository.save(new Submission(87, new Byte[]{}, student10, homework7));
        submissionRepository.save(new Submission(49, new Byte[]{}, student11, homework8));


        Submission submission1 = submissionRepository.findById(1L);
        Submission submission2 = submissionRepository.findById(2L);
        Submission submission3 = submissionRepository.findById(3L);
        Submission submission4 = submissionRepository.findById(4L);
        Submission submission5 = submissionRepository.findById(5L);
        Submission submission6 = submissionRepository.findById(6L);
        Submission submission7 = submissionRepository.findById(7L);
        Submission submission8 = submissionRepository.findById(8L);
        Submission submission9 = submissionRepository.findById(9L);
        Submission submission10 = submissionRepository.findById(10L);
        Submission submission11 = submissionRepository.findById(11L);


        timeSlotRepository.save(new TimeSlot(Day.MONDAY, LocalTime.of(8, 40),
                LocalTime.of(11, 20), section1));
        timeSlotRepository.save(new TimeSlot(Day.MONDAY, LocalTime.of(13, 40),
                LocalTime.of(15, 20), section2));
        timeSlotRepository.save(new TimeSlot(Day.TUESDAY, LocalTime.of(8, 40),
                LocalTime.of(11, 20), section3));
        timeSlotRepository.save(new TimeSlot(Day.TUESDAY, LocalTime.of(13, 40),
                LocalTime.of(15, 20), section4));
        timeSlotRepository.save(new TimeSlot(Day.WEDNESDAY, LocalTime.of(8, 40),
                LocalTime.of(11, 20), section5));
        timeSlotRepository.save(new TimeSlot(Day.WEDNESDAY, LocalTime.of(13, 40),
                LocalTime.of(15, 20), section6));
        timeSlotRepository.save(new TimeSlot(Day.THURSDAY, LocalTime.of(8, 40),
                LocalTime.of(11, 20), section7));
        timeSlotRepository.save(new TimeSlot(Day.THURSDAY, LocalTime.of(13, 40),
                LocalTime.of(15, 20), section8));
        timeSlotRepository.save(new TimeSlot(Day.FRIDAY, LocalTime.of(8, 40),
                LocalTime.of(11, 20), section9));
        timeSlotRepository.save(new TimeSlot(Day.FRIDAY, LocalTime.of(13, 40),
                LocalTime.of(15, 20), section10));
        timeSlotRepository.save(new TimeSlot(Day.FRIDAY, LocalTime.of(8, 40),
                LocalTime.of(11, 20), section11));
    }
}
