package com.group20.coursemanagementsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "section_has_time_slot")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SectionHasTimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;

    @OneToOne
    @JoinColumn(name = "time_slot_id", referencedColumnName = "id")
    private TimeSlot timeSlot;

    public SectionHasTimeSlot(Section section, TimeSlot timeSlot) {
        this.section = section;
        this.timeSlot = timeSlot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionHasTimeSlot that = (SectionHasTimeSlot) o;

        if (!id.equals(that.id)) return false;
        if (!section.equals(that.section)) return false;
        return timeSlot.equals(that.timeSlot);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + section.hashCode();
        result = 31 * result + timeSlot.hashCode();
        return result;
    }
}
