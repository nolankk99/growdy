package com.growdy.web.service.impl;

import com.growdy.web.mapper.ContactMapper;
import com.growdy.web.model.ContactForm;
import com.growdy.web.model.ContactInquiry;
import com.growdy.web.model.ContactReply;
import com.growdy.web.model.EmailLog;
import com.growdy.web.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactMapper contactMapper;
    
    @Autowired
    public ContactServiceImpl(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }
    
    @Override
    @Transactional
    public boolean saveContactInquiry(ContactForm contactForm) {
        try {
            int result = contactMapper.insertContactInquiry(contactForm);
            
            // 관리자에게 알림 이메일 발송 (실제 구현이 필요함)
            sendNotificationEmail(contactForm);
            
            return result > 0;
        } catch (Exception e) {
            log.error("문의 저장 중 오류가 발생했습니다", e);
            return false;
        }
    }
    
    @Override
    public List<ContactInquiry> getAllInquiries() {
        return contactMapper.selectAllInquiries();
    }
    
    @Override
    public ContactInquiry getInquiryById(int inquiryId) {
        return contactMapper.selectInquiryById(inquiryId);
    }
    
    @Override
    @Transactional
    public boolean updateInquiryStatus(int inquiryId, String status, boolean isRead) {
        try {
            int result = contactMapper.updateInquiryStatus(inquiryId, status, isRead);
            return result > 0;
        } catch (Exception e) {
            log.error("문의 상태 업데이트 중 오류가 발생했습니다", e);
            return false;
        }
    }
    
    @Override
    @Transactional
    public boolean replyToInquiry(ContactReply reply) {
        try {
            int result = contactMapper.insertReply(reply);
            
            // 상태 업데이트
            contactMapper.updateInquiryStatus(reply.getInquiryId(), "ANSWERED", true);
            
            // 답변 이메일 발송 (실제 구현이 필요함)
            sendReplyEmail(reply);
            
            return result > 0;
        } catch (Exception e) {
            log.error("문의 답변 중 오류가 발생했습니다", e);
            return false;
        }
    }
    
    @Override
    @Transactional
    public boolean subscribeToNewsletter(String email) {
        try {
            int result = contactMapper.insertNewsletterSubscriber(email);
            return result > 0;
        } catch (Exception e) {
            log.error("뉴스레터 구독 처리 중 오류가 발생했습니다", e);
            return false;
        }
    }
    
    // 이메일 발송 관련 메서드 (실제 구현은 JavaMailSender 등을 활용하여 구현 필요)
    private void sendNotificationEmail(ContactForm contactForm) {
        // 실제 이메일 발송 로직 구현
        EmailLog emailLog = new EmailLog();
        emailLog.setRecipientEmail("admin@growdy.com");
        emailLog.setSubject("[그로우디] 새로운 문의가 등록되었습니다");
        emailLog.setContent("새로운 문의: " + contactForm.getSubject());
        emailLog.setStatus("SUCCESS");
        
        try {
            contactMapper.insertEmailLog(emailLog);
        } catch (Exception e) {
            log.error("이메일 로그 저장 중 오류가 발생했습니다", e);
        }
    }
    
    private void sendReplyEmail(ContactReply reply) {
        // 실제 이메일 발송 로직 구현
        ContactInquiry inquiry = contactMapper.selectInquiryById(reply.getInquiryId());
        
        if (inquiry != null) {
            EmailLog emailLog = new EmailLog();
            emailLog.setRecipientEmail(inquiry.getEmail());
            emailLog.setSubject("[그로우디] 문의하신 내용에 대한 답변입니다");
            emailLog.setContent("문의하신 내용: " + inquiry.getSubject() + "\n\n답변: " + reply.getReplyContent());
            emailLog.setStatus("SUCCESS");
            
            try {
                contactMapper.insertEmailLog(emailLog);
            } catch (Exception e) {
                log.error("이메일 로그 저장 중 오류가 발생했습니다", e);
            }
        }
    }
} 