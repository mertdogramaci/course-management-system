package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student_login_credentials")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class StudentLoginCredentials {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private Long username;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentLoginCredentials that = (StudentLoginCredentials) o;

        if (!id.equals(that.id)) return false;
        if (!username.equals(that.username)) return false;
        if (!password.equals(that.password)) return false;
        return student.equals(that.student);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + student.hashCode();
        return result;
    }
}
