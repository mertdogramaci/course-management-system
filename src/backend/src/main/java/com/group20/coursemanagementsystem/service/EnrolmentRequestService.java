package com.group20.coursemanagementsystem.service;

import com.group20.coursemanagementsystem.dto.MessageResponse;
import com.group20.coursemanagementsystem.enums.MessageType;
import com.group20.coursemanagementsystem.repository.EnrolmentRequestRepository;
import com.group20.coursemanagementsystem.request.EnrolmentRequest;
import com.group20.coursemanagementsystem.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service()
public class EnrolmentRequestService {

    private final EnrolmentRequestRepository enrolmentRequestRepository;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private static final String REQUEST_SENT_MESSAGE = "Your registration request was sent successfully!";
    private static final String ENROLMENT_REQUEST_ALREADY_EXISTS_MESSAGE = "Enrolment request with hacettepe id %s already exists!";
    private static final String MEMBER_WITH_HACETTEPE_ID_ALREADY_EXISTS_MESSAGE = "Member with hacettepe id %s already exists!";
    private static final String MEMBER_WITH_EMAIL_ALREADY_EXISTS_MESSAGE = "Member with email %s already exists!";
    private static final String ENROLMENT_REQUEST_EMAIL_ALREADY_EXISTS_MESSAGE = "Enrolment request with email %s already exists!";
    private static final String ENROLMENT_ID_DOES_NOT_EXIST_MESSAGE = "Enrolment request with id %s does not exist!";
    private static final String REQUEST_ID_DOES_NOT_EXIST_MESSAGE = "Request id %s does not exist!";
    private static final String ENROLMENT_REQUEST_DELETED_MESSAGE = "Enrolment request with hacettepe id %s has been denied!";

    public EnrolmentRequestService(final EnrolmentRequestRepository enrolmentRequestRepository,
                                   final PasswordEncoder passwordEncoder,
                                   final MemberRepository memberRepository) {
        this.enrolmentRequestRepository = enrolmentRequestRepository;
        this.passwordEncoder = passwordEncoder;
        this.memberRepository = memberRepository;
    }

    public MessageResponse addEnrolmentRequest(EnrolmentRequest newEnrolmentRequest) {
        if (enrolmentRequestRepository.existsByHacettepeId(newEnrolmentRequest.getHacettepeId()))
            return new MessageResponse(MessageType.ERROR, ENROLMENT_REQUEST_ALREADY_EXISTS_MESSAGE.formatted(newEnrolmentRequest.getHacettepeId()));
        if (enrolmentRequestRepository.existsByEmail(newEnrolmentRequest.getEmail()))
            return new MessageResponse(MessageType.ERROR, ENROLMENT_REQUEST_EMAIL_ALREADY_EXISTS_MESSAGE.formatted(newEnrolmentRequest.getHacettepeId()));
//        if (memberRepository.existsByHacettepeId(newEnrolmentRequest.getHacettepeId()))
//            return new MessageResponse(MessageType.ERROR, MEMBER_WITH_HACETTEPE_ID_ALREADY_EXISTS_MESSAGE.formatted(newEnrolmentRequest.getHacettepeId()));
        if (memberRepository.existsByEmail(newEnrolmentRequest.getEmail()))
            return new MessageResponse(MessageType.ERROR, MEMBER_WITH_EMAIL_ALREADY_EXISTS_MESSAGE.formatted(newEnrolmentRequest.getHacettepeId()));
        newEnrolmentRequest.setPassword(passwordEncoder.encode(newEnrolmentRequest.getPassword()));
        enrolmentRequestRepository.save(newEnrolmentRequest);
        return new MessageResponse(MessageType.SUCCESS, REQUEST_SENT_MESSAGE);
    }

    public MessageResponse deleteEnrolmentRequest(Long id) {
        if (!enrolmentRequestRepository.existsById(id)) {
            return new MessageResponse(MessageType.ERROR, ENROLMENT_ID_DOES_NOT_EXIST_MESSAGE.formatted(id));
        }
        EnrolmentRequest enrolmentRequestFromDB = enrolmentRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(REQUEST_ID_DOES_NOT_EXIST_MESSAGE.formatted(id)));
        enrolmentRequestRepository.deleteById(id);

        return new MessageResponse(MessageType.SUCCESS, ENROLMENT_REQUEST_DELETED_MESSAGE.formatted(enrolmentRequestFromDB.getHacettepeId()));
    }

    public List<EnrolmentRequest> getAllEnrolmentRequests() {
        return enrolmentRequestRepository.findAll();
    }
}
