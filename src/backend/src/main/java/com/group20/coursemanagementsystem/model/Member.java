package com.group20.coursemanagementsystem.model;

import com.group20.coursemanagementsystem.model.BaseEntity;
import com.group20.coursemanagementsystem.enums.MemberType;
import com.group20.coursemanagementsystem.security.domain.Authority;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "member_table")
public class Member extends BaseEntity implements UserDetails {

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "hacettepe_id")
    protected String hacettepeId;

    @Column(name = "email", unique = true)
    protected String email;

    @Column(name = "password")
    protected String password;

    @Column(name = "profile_photo")
    protected String profilePhoto;

    @Column(name = "phone_number")
    protected String phoneNumber;

    @Column(name = "linked_in_url")
    protected String linkedInURL;

    @Column(name = "github_url")
    protected String githubURL;

    @Column(name = "about")
    protected String about;

    @Column(name = "experience")
    protected String experience;

    @Column(name = "interest")
    protected String interests;

    @Column(name = "member_type")
    protected MemberType memberType;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "MEMBER_AUTHORITIES",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID")
    )
    protected Set<Authority> authorities;

    @ElementCollection
    private List<LocalDate> joinDates = new ArrayList<>();

    //TODO: friends, isOnline, mailbox, isAccountVerified, isBanned

    protected Member() {} //No args constructor is needed for Entity

    public Member(String firstName, String lastName, String hacettepeId, String email, String password, MemberType memberType, Set<Authority> authorities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hacettepeId = hacettepeId;
        this.email = email;
        this.password = password;
        this.memberType = memberType;
        this.authorities = authorities;
    }

    public Member(String firstName, String lastName, String hacettepeId, String email, MemberType memberType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hacettepeId = hacettepeId;
        this.email = email;
        this.memberType = memberType;
    }

    public Member(String firstName, String lastName, String hacettepeId, String email, String password, String profilePhoto,
                  String phoneNumber, String linkedInURL, String githubURL, String about, String experience, String interests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hacettepeId = hacettepeId;
        this.email = email;
        this.password = password;
        this.profilePhoto = profilePhoto;
        this.phoneNumber = phoneNumber;
        this.linkedInURL = linkedInURL;
        this.githubURL = githubURL;
        this.about = about;
        this.experience = experience;
        this.interests = interests;
    }

    public Member(String firstName, String lastName, String hacettepeId, String email, String profilePhoto,
                  String phoneNumber, String linkedInURL, String githubURL, String about, String experience, String interests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hacettepeId = hacettepeId;
        this.email = email;
        this.profilePhoto = profilePhoto;
        this.phoneNumber = phoneNumber;
        this.linkedInURL = linkedInURL;
        this.githubURL = githubURL;
        this.about = about;
        this.experience = experience;
        this.interests = interests;
    }

    public Member(String password) {
        this.password = password;
    }

    public Member(String firstName, String lastName, String hacettepeId, String email, String password,
                  String profilePhoto, String phoneNumber, String linkedInURL, String githubURL, String about,
                  String experience, String interests, MemberType memberType, Set<Authority> authorities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hacettepeId = hacettepeId;
        this.email = email;
        this.password = password;
        this.profilePhoto = profilePhoto;
        this.phoneNumber = phoneNumber;
        this.linkedInURL = linkedInURL;
        this.githubURL = githubURL;
        this.about = about;
        this.experience = experience;
        this.interests = interests;
        this.memberType = memberType;
        this.authorities = authorities;
    }

    public Member(String firstName, String lastName, String hacettepeId, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hacettepeId = hacettepeId;
        this.email = email;
    }

    // Note that some fields should not be updated!
    public void updateMember(final Member updatedMember) {
        this.firstName = updatedMember.getFirstName();
        this.lastName = updatedMember.getLastName();
        this.phoneNumber = updatedMember.getPhoneNumber();
        this.linkedInURL = updatedMember.getLinkedInURL();
        this.githubURL = updatedMember.getGithubURL();
        this.about = updatedMember.getAbout();
        this.experience = updatedMember.getExperience();
        this.interests = updatedMember.getInterests();
        if (updatedMember.getProfilePhoto() != null) {
            this.profilePhoto = updatedMember.getProfilePhoto();
        }
    }

    public void updatePassword(final Member updatedMember) {
        this.password = updatedMember.getPassword();
    }

    public void giveAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //Check whether or not a member has same hacettepe id with another member
    public boolean hasSameHacettepeIdAs(Member member) {
        return hacettepeId.equals(member.getHacettepeId());
    }

    public void addJoinDate(final LocalDate newDate) {
        joinDates.add(newDate);
    }
}
