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

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;

    @Column(name = "process")
    private String process;

    public ProcessingHistory(LocalDateTime timeStamp, String process) {
        this.timeStamp = timeStamp;
        this.process = process;
    }
}
