package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

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
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public StudentLoginCredentials(String username, String password, Student student) {
        this.username = username;
        this.password = password;
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentLoginCredentials that = (StudentLoginCredentials) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, student);
    }
}
