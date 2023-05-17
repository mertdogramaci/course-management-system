package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "instructor_login_credentials")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class InstructorLoginCredentials {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Instructor instructor;

    public InstructorLoginCredentials(String username, String password, Instructor instructor) {
        this.username = username;
        this.password = password;
        this.instructor = instructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstructorLoginCredentials that = (InstructorLoginCredentials) o;

        if (!id.equals(that.id)) return false;
        if (!username.equals(that.username)) return false;
        if (!password.equals(that.password)) return false;
        return instructor.equals(that.instructor);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + instructor.hashCode();
        return result;
    }
}
