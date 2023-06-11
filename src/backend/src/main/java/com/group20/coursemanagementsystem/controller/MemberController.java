package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.dto.MessageResponse;
import com.group20.coursemanagementsystem.enums.MessageType;
import com.group20.coursemanagementsystem.model.Department;
import com.group20.coursemanagementsystem.model.Student;
import com.group20.coursemanagementsystem.request.ProfileDataRequest;
import com.group20.coursemanagementsystem.response.MemberResponse;
import com.group20.coursemanagementsystem.model.Member;
import com.group20.coursemanagementsystem.response.MemberQueryResponse;
import com.group20.coursemanagementsystem.response.StudentResponse;
import com.group20.coursemanagementsystem.security.request.ChangePasswordRequest;
import com.group20.coursemanagementsystem.security.request.UpdateMemberRequest;
import com.group20.coursemanagementsystem.security.service.CustomUserDetailsService;
import com.group20.coursemanagementsystem.service.FileService;
import com.group20.coursemanagementsystem.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final CustomUserDetailsService customUserDetailsService;

    private final FileService fileService;

    public MemberController(final MemberService memberService,
                            final CustomUserDetailsService customUserDetailsService, FileService fileService) {
        this.memberService = memberService;
        this.customUserDetailsService = customUserDetailsService;
        this.fileService = fileService;
    }

    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @GetMapping("/findStudent/{id}")
    public StudentResponse getStudent(@PathVariable Long id) {
        Student student = memberService.getStudentById(id);
        return new StudentResponse(student);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @PostMapping("/profile")
    public MemberResponse getProfileData(@RequestBody final ProfileDataRequest profileDataRequest) {
        // TODO: Requester logic
        Member member = memberService.getMemberById(profileDataRequest.getRequestedId());
        return new MemberResponse(member);
    }

    @PreAuthorize("hasAnyAuthority('MEMBER')")
    @GetMapping("/profile")
    public MemberResponse getMyAccountInfo(HttpServletRequest req) {
        String token = req.getHeader("Authorization");
        String jwtToken = token.substring(7);
        String[] chunks = jwtToken.split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String payload = new String(decoder.decode(chunks[1]));
        String subPrefix = payload.substring(8);
        String sub = subPrefix.split("\"")[0];

        Member member = memberService.getMemberByEmail(sub);
        return new MemberResponse(member);
    }

    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @GetMapping("/fetchAllMembers")
    public List<MemberQueryResponse> getAll() {
        List<Member> foundMembers = memberService.getAll();
        List<MemberQueryResponse> responseList = new ArrayList<>();

        for (Member member : foundMembers) {
            responseList.add(new MemberQueryResponse(member));
        }
        return responseList;
    }

//    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
//    @GetMapping("/search")
//    public List<MemberQueryResponse> search(@RequestParam(value = "query") String query) {
//        List<Member> foundMembers = memberService.search(query);
//        List<MemberQueryResponse> responseList = new ArrayList<>();
//
//        for (Member member : foundMembers) {
//            responseList.add(new MemberQueryResponse(member));
//        }
//        return responseList;
//    }

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @GetMapping("/{hacettepeId}")
//    public MemberQueryResponse getMemberByHacettepeId(@PathVariable final String hacettepeId) {
//        Member member = memberService.getMemberByHacettepeId(hacettepeId);
//        return new MemberQueryResponse(member);
//    }

    @PutMapping("/{id}")
    public MessageResponse updateMember(@PathVariable Long id, @ModelAttribute UpdateMemberRequest request) {
        if (request.getProfilePhoto() != null) {
            try {
                String photoPath = fileService.store(request.getProfilePhoto(), request.getEmail());
                return memberService.updateMember(id, request.toMember(photoPath));
            } catch (Exception e) {
                return new MessageResponse(MessageType.ERROR, String.format("Could not upload the file: %s", request.getProfilePhoto().getOriginalFilename()));
            }
        } else {
            return memberService.updateMember(id, request.toMember(null));
        }
    }

    // Cannot be used by members!
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public MessageResponse deleteMember(@PathVariable Long id) {
        return memberService.deleteMember(id);
    }

    @PostMapping("/change-password")
    public MessageResponse changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
        return memberService.changePassword(changePasswordRequest.getUserID(), changePasswordRequest.getOldPassword(), changePasswordRequest.getNewPassword());
    }

    @GetMapping("/userinfo")
    public ResponseEntity<?> getUserInfo(Principal user) {
        Member member = (Member) customUserDetailsService.loadUserByUsername(user.getName());

        return ResponseEntity.ok(member);
    }

    @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @GetMapping("/getDepartment/{memberId}")
    public ResponseEntity<Department> getDepartmentOfMember(@PathVariable Long memberId) {
        Member student = memberService.getStudentById(memberId);
        return ResponseEntity.ok(student.getDepartment());
    }
}
