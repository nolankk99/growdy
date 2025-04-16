package com.growdy.web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ContactInquiry {
    private int inquiryId;
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;
    private Date createdDate;
    private String status;
    private boolean isRead;
} 