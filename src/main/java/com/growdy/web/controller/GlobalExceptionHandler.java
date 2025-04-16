package com.growdy.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler(SQLException.class)
    public ModelAndView handleSQLException(HttpServletRequest request, Exception ex) {
        log.error("데이터베이스 오류가 발생했습니다: URL={}", request.getRequestURL(), ex);
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "데이터베이스 오류가 발생했습니다.");
        modelAndView.addObject("errorDetails", ex.getMessage());
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName("error/database-error");
        
        return modelAndView;
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex) {
        log.error("처리되지 않은 예외가 발생했습니다: URL={}", request.getRequestURL(), ex);
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", "오류가 발생했습니다.");
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName("error/general-error");
        
        return modelAndView;
    }
} 