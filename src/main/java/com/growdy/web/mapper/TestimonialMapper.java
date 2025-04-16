package com.growdy.web.mapper;

import com.growdy.web.model.Testimonial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestimonialMapper {
    
    List<Testimonial> selectAllTestimonials();
    
    List<Testimonial> selectActiveTestimonials();
    
    Testimonial selectTestimonialById(int testimonialId);
    
    int insertTestimonial(Testimonial testimonial);
    
    int updateTestimonial(Testimonial testimonial);
    
    int updateTestimonialStatus(@Param("testimonialId") int testimonialId, @Param("isActive") boolean isActive);
    
    int deleteTestimonial(int testimonialId);
} 