package com.growdy.web.controller;

import com.growdy.web.model.Testimonial;
import com.growdy.web.service.TestimonialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class TestimonialController {

    private final TestimonialService testimonialService;
    
    @Autowired
    public TestimonialController(TestimonialService testimonialService) {
        this.testimonialService = testimonialService;
    }
    
    // API 방식으로 활성화된 후기만 조회
    @GetMapping("/api/testimonials")
    @ResponseBody
    public List<Testimonial> getActiveTestimonials() {
        return testimonialService.getActiveTestimonials();
    }
    
    // 홈페이지에서 후기 섹션 렌더링을 위한 메서드
    @GetMapping("/testimonials")
    public String testimonialSection(Model model) {
        List<Testimonial> testimonials = testimonialService.getActiveTestimonials();
        model.addAttribute("testimonials", testimonials);
        return "testimonials";
    }
    
    // 관리자용 후기 관리 페이지
    @GetMapping("/admin/testimonials")
    public String adminTestimonials(Model model) {
        List<Testimonial> testimonials = testimonialService.getAllTestimonials();
        model.addAttribute("testimonials", testimonials);
        return "admin/testimonials";
    }
    
    // 후기 상세 조회
    @GetMapping("/admin/testimonials/{id}")
    public String getTestimonial(@PathVariable("id") int testimonialId, Model model) {
        Testimonial testimonial = testimonialService.getTestimonialById(testimonialId);
        model.addAttribute("testimonial", testimonial);
        return "admin/testimonial-detail";
    }
    
    // 새 후기 등록 페이지
    @GetMapping("/admin/testimonials/new")
    public String newTestimonialForm(Model model) {
        model.addAttribute("testimonial", new Testimonial());
        return "admin/testimonial-form";
    }
    
    // 후기 수정 페이지
    @GetMapping("/admin/testimonials/{id}/edit")
    public String editTestimonialForm(@PathVariable("id") int testimonialId, Model model) {
        Testimonial testimonial = testimonialService.getTestimonialById(testimonialId);
        model.addAttribute("testimonial", testimonial);
        return "admin/testimonial-form";
    }
    
    // 후기 저장/수정
    @PostMapping("/admin/testimonials")
    public String saveTestimonial(@ModelAttribute Testimonial testimonial) {
        if (testimonial.getTestimonialId() > 0) {
            testimonialService.updateTestimonial(testimonial);
        } else {
            testimonialService.saveTestimonial(testimonial);
        }
        return "redirect:/admin/testimonials";
    }
    
    // 후기 상태 변경
    @PostMapping("/admin/testimonials/{id}/toggle")
    public String toggleTestimonialStatus(@PathVariable("id") int testimonialId, @RequestParam("active") boolean active) {
        testimonialService.updateTestimonialStatus(testimonialId, active);
        return "redirect:/admin/testimonials";
    }
    
    // 후기 삭제
    @PostMapping("/admin/testimonials/{id}/delete")
    public String deleteTestimonial(@PathVariable("id") int testimonialId) {
        testimonialService.deleteTestimonial(testimonialId);
        return "redirect:/admin/testimonials";
    }
} 