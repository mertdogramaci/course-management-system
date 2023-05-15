package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Objects;

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

    @ManyToOne
    @JoinColumn(name = "student_id")
    @ToString.Exclude
    private Student student;

    @ManyToOne
    @JoinColumn(name = "homework_id")
    @ToString.Exclude
    private Homework homework;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Submission that = (Submission) o;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(marks, that.marks)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(content, that.content)) return false;
        if (!student.equals(that.student)) return false;
        return homework.equals(that.homework);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (marks != null ? marks.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + student.hashCode();
        result = 31 * result + homework.hashCode();
        return result;
    }
}
