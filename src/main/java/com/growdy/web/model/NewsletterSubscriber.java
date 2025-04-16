package com.growdy.web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class NewsletterSubscriber {
    private int subscriberId;
    private String email;
    private Date subscriptionDate;
    private boolean isActive;
} 