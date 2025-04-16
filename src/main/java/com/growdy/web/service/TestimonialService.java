package com.growdy.web.service;

import com.growdy.web.model.Testimonial;
import java.util.List;

public interface TestimonialService {
    
    List<Testimonial> getAllTestimonials();
    
    List<Testimonial> getActiveTestimonials();
    
    Testimonial getTestimonialById(int testimonialId);
    
    boolean saveTestimonial(Testimonial testimonial);
    
    boolean updateTestimonial(Testimonial testimonial);
    
    boolean updateTestimonialStatus(int testimonialId, boolean isActive);
    
    boolean deleteTestimonial(int testimonialId);
} 