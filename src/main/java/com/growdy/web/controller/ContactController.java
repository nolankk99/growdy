package com.growdy.web.controller;

import com.growdy.web.model.ContactForm;
import com.growdy.web.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class ContactController {

    private final ContactService contactService;
    
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String contactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@ModelAttribute ContactForm contactForm, RedirectAttributes redirectAttributes) {
        log.info("Contact form submission: {}", contactForm);
        
        boolean success = contactService.saveContactInquiry(contactForm);
        
        if (success) {
            redirectAttributes.addFlashAttribute("successMessage", "문의가 성공적으로 접수되었습니다. 빠른 시일 내에 답변 드리겠습니다.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "문의 접수 중 오류가 발생했습니다. 잠시 후 다시 시도해주세요.");
        }
        
        return "redirect:/contact";
    }
    
    @PostMapping("/newsletter/subscribe")
    @ResponseBody
    public String subscribeToNewsletter(@RequestParam("email") String email) {
        log.info("Newsletter subscription: {}", email);
        
        boolean success = contactService.subscribeToNewsletter(email);
        
        if (success) {
            return "{\"success\": true, \"message\": \"뉴스레터 구독이 완료되었습니다.\"}";
        } else {
            return "{\"success\": false, \"message\": \"구독 처리 중 오류가 발생했습니다. 잠시 후 다시 시도해주세요.\"}";
        }
    }
} 