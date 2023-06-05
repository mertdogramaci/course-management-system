package com.group20.coursemanagementsystem.controller;

import com.group20.coursemanagementsystem.model.Member;
import com.group20.coursemanagementsystem.model.ProcessingHistory;
import com.group20.coursemanagementsystem.repository.ProcessingHistoryRepository;
import com.group20.coursemanagementsystem.response.LogResponse;
import com.group20.coursemanagementsystem.response.MemberQueryResponse;
import com.group20.coursemanagementsystem.response.MemberResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/log")
public class ProcessingHistoryController {

    ProcessingHistoryRepository processingHistoryRepository;

    public ProcessingHistoryController(ProcessingHistoryRepository processingHistoryRepository) {
        this.processingHistoryRepository = processingHistoryRepository;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping()
    public List<LogResponse> getAllLogs() {
        List<ProcessingHistory> logs = processingHistoryRepository.findAll();

        List<LogResponse> responseList = new ArrayList<>();

        for (ProcessingHistory processingHistory : logs) {
            responseList.add(new LogResponse(processingHistory));
        }

        return responseList;
    }
}
