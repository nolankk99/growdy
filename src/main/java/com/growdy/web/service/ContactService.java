package com.growdy.web.service;

import com.growdy.web.model.ContactForm;
import com.growdy.web.model.ContactInquiry;
import com.growdy.web.model.ContactReply;

import java.util.List;

public interface ContactService {
    
    boolean saveContactInquiry(ContactForm contactForm);
    
    List<ContactInquiry> getAllInquiries();
    
    ContactInquiry getInquiryById(int inquiryId);
    
    boolean updateInquiryStatus(int inquiryId, String status, boolean isRead);
    
    boolean replyToInquiry(ContactReply reply);
    
    boolean subscribeToNewsletter(String email);
} 