package com.growdy.web.mapper;

import com.growdy.web.model.ContactForm;
import com.growdy.web.model.ContactInquiry;
import com.growdy.web.model.ContactReply;
import com.growdy.web.model.EmailLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContactMapper {
    
    int insertContactInquiry(ContactForm contactForm);
    
    List<ContactInquiry> selectAllInquiries();
    
    ContactInquiry selectInquiryById(int inquiryId);
    
    int updateInquiryStatus(@Param("inquiryId") int inquiryId, 
                           @Param("status") String status, 
                           @Param("isRead") boolean isRead);
    
    int insertReply(ContactReply reply);
    
    int insertNewsletterSubscriber(String email);
    
    int insertEmailLog(EmailLog emailLog);
} 