package com.growdy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 가장 기본적인 설정으로 /admin/** 경로만 인증 필요
        http
            .authorizeRequests()
                .antMatchers("/admin/**").authenticated()
                .anyRequest().permitAll()
            .and()
            .formLogin()
                .loginPage("/login")
                .permitAll();
        
        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        
        UserDetails admin = User.builder()
                .username("admin")
                .password("admin1234")
                .passwordEncoder(s -> "{noop}" + s)
                .roles("ADMIN")
                .build();
        
        return new InMemoryUserDetailsManager(admin);
    }
} 