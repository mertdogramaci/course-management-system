package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "section")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Section {

    @Id
    private Long id;

    @Column(name = "semester")
    private Boolean semester;

    @Column(name = "year")
    private Integer year;

    @Column(name = "classroomInfo")
    private String classroomInfo;

    @Column(name = "quota")
    private Integer quota;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    @ToString.Exclude
    private Instructor instructor;

    @OneToMany
    private List<Homework> homeworks;

    @ManyToMany
    private List<TimeSlot> timeSlots;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Section section = (Section) o;

        if (!id.equals(section.id)) return false;
        if (!semester.equals(section.semester)) return false;
        if (!year.equals(section.year)) return false;
        if (!Objects.equals(classroomInfo, section.classroomInfo))
            return false;
        if (!quota.equals(section.quota)) return false;
        if (!course.equals(section.course)) return false;
        return instructor.equals(section.instructor);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + semester.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + (classroomInfo != null ? classroomInfo.hashCode() : 0);
        result = 31 * result + quota.hashCode();
        result = 31 * result + course.hashCode();
        result = 31 * result + instructor.hashCode();
        return result;
    }
}
