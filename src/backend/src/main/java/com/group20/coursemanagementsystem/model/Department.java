package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Department {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany
    private List<Instructor> instructors;

    @OneToMany
    private List<Course> courses;

    @OneToMany
    private List<Student> students;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        return faculty.equals(that.faculty);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + faculty.hashCode();
        return result;
    }
}
