package com.group20.coursemanagementsystem.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class ProfileDataRequest implements Serializable {

    private Long requesterId;

    private Long requestedId;

    public ProfileDataRequest(Long requesterId, Long requestedId) {
        this.requesterId = requesterId;
        this.requestedId = requestedId;
    }
}
