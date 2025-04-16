package com.growdy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/services")
    public String services() {
        return "services";
    }
    
    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }
} 