package com.group20.coursemanagementsystem.service;

import com.group20.coursemanagementsystem.model.Instructor;
import com.group20.coursemanagementsystem.repository.InstructorRepository;
import com.group20.coursemanagementsystem.dto.MessageResponse;
import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.enums.MessageType;
import com.group20.coursemanagementsystem.request.EnrolmentRequest;
import com.group20.coursemanagementsystem.repository.EnrolmentRequestRepository;
import com.group20.coursemanagementsystem.model.Member;
import com.group20.coursemanagementsystem.repository.MemberRepository;
import com.group20.coursemanagementsystem.security.repositories.AuthorityRepository;
import com.group20.coursemanagementsystem.model.Student;
import com.group20.coursemanagementsystem.repository.StudentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;
import java.util.List;


@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;
    private final AuthorityRepository authorityRepository;
    private final EnrolmentRequestRepository enrolmentRequestRepository;
    private final PasswordEncoder passwordEncoder;

    private final EnrolmentRequestService enrolmentRequestService; // ATTENTION: avoid circular dependencies between modules.

    private static final String MEMBER_DOES_NOT_EXIST_MESSAGE = "Member with hacettepe id %s does not exist!";
    private static final String MEMBER_ID_DOES_NOT_EXIST_MESSAGE = "Member with id %s does not exist!";
    private static final String MEMBER_WITH_EMAIL_DOES_NOT_EXIST_MESSAGE = "Member with email %s does not exist!";
    private static final String REQUEST_ID_DOES_NOT_EXIST_MESSAGE = "Request id %s does not exist!";
    private static final String MEMBER_UPDATED_MESSAGE = "Your profile has been updated successfully";
    private static final String MEMBER_DELETED_MESSAGE = "Member with id %s has been deleted successfully";
    private static final String MEMBER_ADDED_MESSAGE = "Member with hacettepe id %s has been approved!";
    private static final String MEMBER_PASSWORD_CHANGED_MESSAGE = "Your password successfully changed!";
    private static final String MEMBER_PASSWORD_NOT_EQUAL_MESSAGE = "Your password is not correct!";
    public MemberService(final MemberRepository memberRepository,
                         final StudentRepository studentRepository,
                         final InstructorRepository instructorRepository,
                         final AuthorityRepository authorityRepository,
                         final EnrolmentRequestRepository enrolmentRequestRepository,
                         final PasswordEncoder passwordEncoder,
                         final EnrolmentRequestService enrolmentRequestService) {
        this.memberRepository = memberRepository;
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
        this.authorityRepository = authorityRepository;
        this.enrolmentRequestRepository = enrolmentRequestRepository;
        this.enrolmentRequestService = enrolmentRequestService;
        this.passwordEncoder = passwordEncoder;
    }

    public MessageResponse addMember(final Long requestId) {
        EnrolmentRequest enrolmentRequestFromDB = enrolmentRequestRepository.findById(requestId)
                .orElseThrow(() -> new EntityNotFoundException(REQUEST_ID_DOES_NOT_EXIST_MESSAGE.formatted(requestId)));

        if (enrolmentRequestFromDB.getMemberType() == MemberType.STUDENT) {
            Student newStudent = enrolmentRequestFromDB.toStudent();
            newStudent.giveAuthorities(Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("STUDENT")));
            studentRepository.save(newStudent);
        }
        else if (enrolmentRequestFromDB.getMemberType() == MemberType.INSTRUCTOR) {
            Instructor newInstructor = enrolmentRequestFromDB.toInstructor();
            newInstructor.giveAuthorities(Set.of(authorityRepository.findByAuthority("MEMBER"), authorityRepository.findByAuthority("INSTRUCTOR")));
//            instructorRepository.save(newInstructor);
        }
        else {
            System.out.println("Other type of member is not possible!");
        }
        enrolmentRequestService.deleteEnrolmentRequest(requestId);
        return new MessageResponse(MessageType.SUCCESS, MEMBER_ADDED_MESSAGE.formatted(enrolmentRequestFromDB.getHacettepeId()));
    }

//    public Member getMemberByHacettepeId(final String hacettepeId) {
//        return memberRepository.findByHacettepeId(hacettepeId)
//                .orElseThrow(() -> new EntityNotFoundException(MEMBER_DOES_NOT_EXIST_MESSAGE.formatted(hacettepeId)));
//    }
    public Member getMemberById(final Long id) {
        Member member = memberRepository.findById(id);
        if (member.getMemberType() == MemberType.STUDENT) {
            Student student = studentRepository.findById(id);
            student.updateMemberFields(member);
            return student;
        }

        return member;
        // throw new EntityNotFoundException(MEMBER_ID_DOES_NOT_EXIST_MESSAGE.formatted(id)));
    }

    public Student getStudentById(final Long id) {
        Member member = memberRepository.findById(id);
        Student student = studentRepository.findById(id);
        student.updateMemberFields(member);
        return student;
        // throw new EntityNotFoundException(MEMBER_ID_DOES_NOT_EXIST_MESSAGE.formatted(id)));
    }

    public Member getMemberByEmail(final String email) {
        Member member = memberRepository.findByEmail(email);
        if (member == null) {
            throw new EntityNotFoundException(MEMBER_WITH_EMAIL_DOES_NOT_EXIST_MESSAGE.formatted(email));
        }

        if (member.getMemberType() == MemberType.STUDENT) {
            Student student = studentRepository.findById(member.getId());
            student.updateMemberFields(member);
            return student;
        }

        return member;
    }

    public MessageResponse updateMember(final Long id, final Member updatedMember) {
        Member memberFromDB = memberRepository.findById(id);
        if (memberFromDB == null) {
            throw new EntityNotFoundException(MEMBER_ID_DOES_NOT_EXIST_MESSAGE.formatted(id));
        }

        memberFromDB.updateMember(updatedMember);
        memberRepository.update(memberFromDB);
        return new MessageResponse(MessageType.SUCCESS, MEMBER_UPDATED_MESSAGE);
    }

    // Cannot be used by members!
    public MessageResponse deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            return new MessageResponse(MessageType.ERROR, MEMBER_ID_DOES_NOT_EXIST_MESSAGE.formatted(id));
        }
        memberRepository.deleteById(id);

        return new MessageResponse(MessageType.SUCCESS, MEMBER_DELETED_MESSAGE.formatted(id));
    }

//    public List<Member> search(String keyword) {
//        if (keyword != null) {
//            return memberRepository.search(keyword);
//        }
//        return memberRepository.findAll();
//    }

    public MessageResponse changePassword(Long id, String oldPassword, String newPassword){
        if (!memberRepository.existsById(id)) {
            return new MessageResponse(MessageType.ERROR, MEMBER_ID_DOES_NOT_EXIST_MESSAGE.formatted(id));
        }

        Member memberToChange = getMemberById(id);

        if(passwordEncoder.matches(oldPassword,memberToChange.getPassword())){
            memberToChange.updatePassword(new Member(passwordEncoder.encode(newPassword)));
            updateMember(memberToChange.getId(), memberToChange);

            return new MessageResponse(MessageType.SUCCESS, MEMBER_PASSWORD_CHANGED_MESSAGE);
        }else {

            return new MessageResponse(MessageType.ERROR, MEMBER_PASSWORD_NOT_EQUAL_MESSAGE);
        }
    }

    public boolean existsMemberById(Long id) {
        return memberRepository.existsById(id);
    }
    public List<Member> getAll() {
        return memberRepository.findAll();
    }
}
