package com.growdy.web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ContactReply {
    private int replyId;
    private int inquiryId;
    private String replyContent;
    private Date repliedDate;
} 