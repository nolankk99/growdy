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
public class ContactReply {
    
    private Integer replyId;
    private Integer inquiryId;
    private String content;
    private String sentBy;
    private LocalDateTime sentDate;
    private Boolean isRead;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    
    private ContactInquiry contactInquiry; // 관계 매핑용
} 