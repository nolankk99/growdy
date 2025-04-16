package com.growdy.web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class EmailLog {
    private int logId;
    private String recipientEmail;
    private String subject;
    private String content;
    private Date sendDate;
    private String status;
    private String errorMessage;
} 