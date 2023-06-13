package com.group20.coursemanagementsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Entity
@Table(name = "processing_history")
@NoArgsConstructor
public class ProcessingHistory {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;

    @Column(name = "activity")
    private String activity;

    public ProcessingHistory(LocalDateTime timeStamp, String userEmail, String activity) {
        this.timeStamp = timeStamp;
        this.userEmail = userEmail;
        this.activity = activity;
    }
}
