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

    @Column(name = "email", unique = true)
    protected String email;

    @Column(name = "password")
    protected String password;

    @Column(name = "phone_number")
    protected String phoneNumber;

    @Column(name = "about") //TODO: Change this as Address
    protected String about;

    @Column(name = "member_type")
    protected MemberType memberType;

    @Column(name = "profile_photo")
    protected String profilePhoto;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

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

    public Member(String firstName, String lastName, String email, String password, MemberType memberType, Set<Authority> authorities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.memberType = memberType;
        this.authorities = authorities;
    }

    public Member(String firstName, String lastName, String email, MemberType memberType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.memberType = memberType;
    }

    public Member(String firstName, String lastName, String email, String password, String phoneNumber, String about, String profilePhoto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.about = about;
        this.profilePhoto = profilePhoto;
    }

    public Member(String firstName, String lastName, String email, String phoneNumber, String about, String profilePhoto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.about = about;
        this.profilePhoto = profilePhoto;
    }

    public Member(String password) {
        this.password = password;
    }

    public Member(String firstName, String lastName, String email, String password, String phoneNumber, String about,
                  String profilePhoto, MemberType memberType, Set<Authority> authorities, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.profilePhoto = profilePhoto;
        this.about = about;
        this.memberType = memberType;
        this.authorities = authorities;
        this.department = department;
    }

    public Member(String firstName, String lastName, String email, String password, String phoneNumber, String about,
                  MemberType memberType, Set<Authority> authorities, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.about = about;
        this.memberType = memberType;
        this.authorities = authorities;
        this.department = department;
    }

    public Member(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Note that some fields should not be updated!
    public void updateMember(final Member updatedMember) {
        this.firstName = updatedMember.getFirstName();
        this.lastName = updatedMember.getLastName();
        this.phoneNumber = updatedMember.getPhoneNumber();
        this.about = updatedMember.getAbout();
        if (updatedMember.getProfilePhoto() != null) {
            this.profilePhoto = updatedMember.getProfilePhoto();
        }
    }

    public void updateDepartment(final Department department) {
        this.department = department;
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

//    //Check whether or not a member has same hacettepe id with another member
//    public boolean hasSameHacettepeIdAs(Member member) {
//        return hacettepeId.equals(member.getHacettepeId());
//    }
}
