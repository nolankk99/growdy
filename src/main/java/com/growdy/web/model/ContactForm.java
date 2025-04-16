package com.growdy.web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContactForm {
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;
} 