package com.group20.coursemanagementsystem.model;

import javax.persistence.*;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marks")
    private Integer marks;

    @Column(name = "content")
    private Byte[] content;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @ToString.Exclude
    private Member student;

    @ManyToOne
    @JoinColumn(name = "homework_id", referencedColumnName = "id")
    @ToString.Exclude
    private Homework homework;

    public Submission(int marks, Byte[] content, Member student, Homework homework) {
        this.marks = marks;
        this.content = content;
        this.student = student;
        this.homework = homework;
    }

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
