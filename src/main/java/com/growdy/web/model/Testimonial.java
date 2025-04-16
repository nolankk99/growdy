package com.growdy.web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Testimonial {
    private int testimonialId;
    private String customerName;
    private String company;
    private String position;
    private String content;
    private int rating;
    private String imageUrl;
    private int displayOrder;
    private boolean isActive;
    private Date createdDate;
    private Date modifiedDate;
} 