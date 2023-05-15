package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "instructor_contact_info")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InstructorContactInfo {

    @Id
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstructorContactInfo that = (InstructorContactInfo) o;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(phone, that.phone)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(address, that.address)) return false;
        return instructor.equals(that.instructor);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + instructor.hashCode();
        return result;
    }
}
