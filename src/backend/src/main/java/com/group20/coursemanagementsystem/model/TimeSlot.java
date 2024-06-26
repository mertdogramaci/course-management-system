package com.group20.coursemanagementsystem.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "time_slot")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TimeSlot {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day")
    private Integer day;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @ToString.Exclude
    private Section section;

    public TimeSlot(int day, LocalTime startTime, LocalTime endTime, Section section) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.section = section;
    }

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
