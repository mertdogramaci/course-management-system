package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "course")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Course {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "ects")
    private Integer ects;

    @Column(name = "isCompulsory")
    private boolean isCompulsory;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (isCompulsory != course.isCompulsory) return false;
        if (!id.equals(course.id)) return false;
        if (!title.equals(course.title)) return false;
        if (!ects.equals(course.ects)) return false;
        if (!Objects.equals(description, course.description)) return false;
        return department.equals(course.department);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + ects.hashCode();
        result = 31 * result + (isCompulsory ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + department.hashCode();
        return result;
    }
}
