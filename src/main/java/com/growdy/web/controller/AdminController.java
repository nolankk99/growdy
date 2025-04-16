package com.growdy.web.controller;

import com.growdy.web.model.ContactInquiry;
import com.growdy.web.model.ContactReply;
import com.growdy.web.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    private final ContactService contactService;
    
    @Autowired
    public AdminController(ContactService contactService) {
        this.contactService = contactService;
    }
    
    // 문의 목록 페이지
    @GetMapping("/inquiries")
    public String inquiriesList(Model model) {
        List<ContactInquiry> inquiries = contactService.getAllInquiries();
        model.addAttribute("inquiries", inquiries);
        return "admin/inquiries";
    }
    
    // 문의 상세 페이지
    @GetMapping("/inquiries/{id}")
    public String inquiryDetail(@PathVariable("id") int inquiryId, Model model) {
        ContactInquiry inquiry = contactService.getInquiryById(inquiryId);
        model.addAttribute("inquiry", inquiry);
        
        // 읽음 상태로 업데이트
        if (!inquiry.isRead()) {
            contactService.updateInquiryStatus(inquiryId, inquiry.getStatus(), true);
        }
        
        return "admin/inquiry-detail";
    }
    
    // 답변 페이지
    @GetMapping("/inquiries/{id}/reply")
    public String replyForm(@PathVariable("id") int inquiryId, Model model) {
        ContactInquiry inquiry = contactService.getInquiryById(inquiryId);
        model.addAttribute("inquiry", inquiry);
        model.addAttribute("reply", new ContactReply());
        
        // 읽음 상태로 업데이트
        if (!inquiry.isRead()) {
            contactService.updateInquiryStatus(inquiryId, inquiry.getStatus(), true);
        }
        
        return "admin/reply-form";
    }
    
    // 답변 제출
    @PostMapping("/inquiries/{id}/reply")
    public String submitReply(@PathVariable("id") int inquiryId, 
                             @ModelAttribute ContactReply reply,
                             RedirectAttributes redirectAttributes) {
        reply.setInquiryId(inquiryId);
        
        boolean success = contactService.replyToInquiry(reply);
        
        if (success) {
            redirectAttributes.addFlashAttribute("successMessage", "답변이 성공적으로 등록되었습니다.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "답변 등록 중 오류가 발생했습니다.");
        }
        
        return "redirect:/admin/inquiries";
    }
    
    // 문의 상태 변경
    @PostMapping("/inquiries/{id}/status")
    public String updateStatus(@PathVariable("id") int inquiryId,
                              @RequestParam("status") String status,
                              RedirectAttributes redirectAttributes) {
        ContactInquiry inquiry = contactService.getInquiryById(inquiryId);
        boolean success = contactService.updateInquiryStatus(inquiryId, status, inquiry.isRead());
        
        if (success) {
            redirectAttributes.addFlashAttribute("successMessage", "상태가 업데이트되었습니다.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "상태 업데이트 중 오류가 발생했습니다.");
        }
        
        return "redirect:/admin/inquiries/" + inquiryId;
    }
} 