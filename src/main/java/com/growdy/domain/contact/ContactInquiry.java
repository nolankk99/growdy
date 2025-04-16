package com.growdy.domain.contact;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactInquiry {
    
    private Integer inquiryId;
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;
    private String status;
    private Boolean isRead;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    
    // 추가 헬퍼 메서드
    public boolean isNew() {
        return "NEW".equals(status);
    }
    
    public boolean isInProgress() {
        return "IN_PROGRESS".equals(status);
    }
    
    public boolean isCompleted() {
        return "COMPLETED".equals(status);
    }
} 