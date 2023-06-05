package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.dto.MessageResponse;
import com.group20.coursemanagementsystem.request.EnrolmentRequest;
import com.group20.coursemanagementsystem.response.EnrolmentQueryResponse;
import com.group20.coursemanagementsystem.service.EnrolmentRequestService;
import com.group20.coursemanagementsystem.service.MemberService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/enroll")
public class EnrolmentRequestController {

    private final EnrolmentRequestService enrolmentRequestService;
    private final MemberService memberService;

    public EnrolmentRequestController(final EnrolmentRequestService enrolmentRequestService,
                                      final MemberService memberService) {
        this.enrolmentRequestService = enrolmentRequestService;
        this.memberService = memberService;
    }

    @PostMapping()
    public MessageResponse addEnrolmentRequest(@Valid @RequestBody final EnrolmentRequest request) {
        return enrolmentRequestService.addEnrolmentRequest(request);
    }

    @GetMapping()
    public List<EnrolmentQueryResponse> getAllEnrolmentRequests() {
        return enrolmentRequestService.getAllEnrolmentRequests()
                .stream()
                .map(EnrolmentQueryResponse::new)
                .toList();
    }

    // DENY == deleteEnrolmentRequest
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/deny/{id}")
    public MessageResponse denyEnrolmentRequest(@PathVariable Long id) {
        return enrolmentRequestService.deleteEnrolmentRequest(id);
    }

    // APPROVE
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/approve/{id}")
    public MessageResponse approve(@PathVariable Long id) {
        return memberService.addMember(id);
    }
}
