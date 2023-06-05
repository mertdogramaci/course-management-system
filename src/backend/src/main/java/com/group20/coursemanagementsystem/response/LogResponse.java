package com.group20.coursemanagementsystem.response;

import com.group20.coursemanagementsystem.model.ProcessingHistory;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LogResponse {

    private final Long id;
    private final LocalDateTime timeStamp;
    private final String process;

    public LogResponse(ProcessingHistory processingHistory) {
        this.id = processingHistory.getId();
        this.timeStamp = processingHistory.getTimeStamp();
        this.process = processingHistory.getProcess();
    }
}
