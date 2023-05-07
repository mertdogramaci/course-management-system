package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "submission")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Submission {

    @Id
    private Long id;

    @Column(name = "marks")
    private Integer marks;

    @Column(name = "content")
    private Byte[] content;

    @OneToMany
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany
    @JoinColumn(name = "homework_id")
    private Homework homework;
}
