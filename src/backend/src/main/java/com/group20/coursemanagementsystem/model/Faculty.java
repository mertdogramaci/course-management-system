package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "faculty")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Faculty {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    private List<Department> departments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        if (!id.equals(faculty.id)) return false;
        return name.equals(faculty.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
