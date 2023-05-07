package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "time_slot")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TimeSlot {

    @Id
    private Long id;

    @Column(name = "day")
    private Integer day;

    @Column(name = "startTime")
    private Timestamp startTime;

    @Column(name = "endTime")
    private Timestamp endTime;

    @OneToMany
    @JoinColumn(name = "section_id")
    private Section section;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSlot timeSlot = (TimeSlot) o;

        if (!id.equals(timeSlot.id)) return false;
        if (!day.equals(timeSlot.day)) return false;
        if (!startTime.equals(timeSlot.startTime)) return false;
        if (!endTime.equals(timeSlot.endTime)) return false;
        return Objects.equals(section, timeSlot.section);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + day.hashCode();
        result = 31 * result + startTime.hashCode();
        result = 31 * result + endTime.hashCode();
        result = 31 * result + (section != null ? section.hashCode() : 0);
        return result;
    }
}
