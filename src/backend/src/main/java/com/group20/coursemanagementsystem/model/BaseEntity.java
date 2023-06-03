package com.group20.coursemanagementsystem.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

// we don't want to create a table for this class, that's why it is abstract
@MappedSuperclass // Now this class can be extended from subclasses
@EntityListeners(AuditingEntityListener.class) // Required for these 3 things below
@Getter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    // These attributes will be used when editing concurrent operations ~~Soft Locking
//    @Version
//    private Long version; // will be used for debugging later
//
//    @CreatedDate
//    private LocalDateTime creationDate; // will be used for debugging later
//
//    @LastModifiedDate
//    private LocalDateTime lastModifiedDate; // will be used for debugging later

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
