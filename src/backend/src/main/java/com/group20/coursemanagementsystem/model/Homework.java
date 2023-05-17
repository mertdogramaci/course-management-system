package com.group20.coursemanagementsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name = "homework")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Homework {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private Byte[] content;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Homework homework = (Homework) o;

        if (!id.equals(homework.id)) return false;
        if (!title.equals(homework.title)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(content, homework.content)) return false;
        if (!issueDate.equals(homework.issueDate)) return false;
        if (!dueDate.equals(homework.dueDate)) return false;
        return section.equals(homework.section);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + issueDate.hashCode();
        result = 31 * result + dueDate.hashCode();
        result = 31 * result + section.hashCode();
        return result;
    }
}
