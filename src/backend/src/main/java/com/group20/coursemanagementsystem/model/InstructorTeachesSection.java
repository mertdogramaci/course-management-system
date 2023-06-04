package com.group20.coursemanagementsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "instructor_teaches_section")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class InstructorTeachesSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Member instructor;

    @OneToOne
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;

    public InstructorTeachesSection(Member instructor, Section section) {
        this.instructor = instructor;
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstructorTeachesSection that = (InstructorTeachesSection) o;

        if (!id.equals(that.id)) return false;
        if (!instructor.equals(that.instructor)) return false;
        return section.equals(that.section);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + instructor.hashCode();
        result = 31 * result + section.hashCode();
        return result;
    }
}
