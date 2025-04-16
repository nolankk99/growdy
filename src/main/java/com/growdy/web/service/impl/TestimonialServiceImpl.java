package com.growdy.web.service.impl;

import com.growdy.web.mapper.TestimonialMapper;
import com.growdy.web.model.Testimonial;
import com.growdy.web.service.TestimonialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialMapper testimonialMapper;
    
    @Autowired
    public TestimonialServiceImpl(TestimonialMapper testimonialMapper) {
        this.testimonialMapper = testimonialMapper;
    }
    
    @Override
    public List<Testimonial> getAllTestimonials() {
        return testimonialMapper.selectAllTestimonials();
    }
    
    @Override
    public List<Testimonial> getActiveTestimonials() {
        return testimonialMapper.selectActiveTestimonials();
    }
    
    @Override
    public Testimonial getTestimonialById(int testimonialId) {
        return testimonialMapper.selectTestimonialById(testimonialId);
    }
    
    @Override
    @Transactional
    public boolean saveTestimonial(Testimonial testimonial) {
        try {
            int result = testimonialMapper.insertTestimonial(testimonial);
            return result > 0;
        } catch (Exception e) {
            log.error("고객 후기 저장 중 오류가 발생했습니다", e);
            return false;
        }
    }
    
    @Override
    @Transactional
    public boolean updateTestimonial(Testimonial testimonial) {
        try {
            int result = testimonialMapper.updateTestimonial(testimonial);
            return result > 0;
        } catch (Exception e) {
            log.error("고객 후기 수정 중 오류가 발생했습니다", e);
            return false;
        }
    }
    
    @Override
    @Transactional
    public boolean updateTestimonialStatus(int testimonialId, boolean isActive) {
        try {
            int result = testimonialMapper.updateTestimonialStatus(testimonialId, isActive);
            return result > 0;
        } catch (Exception e) {
            log.error("고객 후기 상태 변경 중 오류가 발생했습니다", e);
            return false;
        }
    }
    
    @Override
    @Transactional
    public boolean deleteTestimonial(int testimonialId) {
        try {
            int result = testimonialMapper.deleteTestimonial(testimonialId);
            return result > 0;
        } catch (Exception e) {
            log.error("고객 후기 삭제 중 오류가 발생했습니다", e);
            return false;
        }
    }
} 