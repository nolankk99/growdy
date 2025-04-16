-- 샘플 고객 후기 데이터
INSERT INTO testimonial (customer_name, company, position, content, rating, image_url, display_order, is_active)
VALUES 
('김영희', '스타트업 A', 'CEO', '그로우디 서비스를 통해 우리 회사는 디지털 마케팅 성과를 2배 이상 향상시켰습니다. 전문적인 컨설팅과 맞춤형 솔루션을 제공해주셔서 감사합니다.', 5, '/images/testimonials/profile1.jpg', 1, true),
('이철수', '중소기업 B', '마케팅 팀장', '처음에는 반신반의했지만, 그로우디 팀의 전문성과 열정에 깊은 인상을 받았습니다. 우리 회사 특성에 맞는 맞춤형 전략을 수립해주셔서 ROI가 크게 향상되었습니다.', 5, '/images/testimonials/profile2.jpg', 2, true),
('박지민', '대기업 C', '디지털 마케팅 매니저', '데이터 분석과 인사이트 도출 능력이 탁월합니다. 그로우디 덕분에 우리 마케팅 팀의 역량이 한층 성장할 수 있었습니다.', 4, '/images/testimonials/profile3.jpg', 3, true),
('최현우', '스타트업 D', 'CTO', '기술적 니즈를 정확히 파악하고 최적의 솔루션을 제안해주셨습니다. 개발팀과의 협업도 매우 원활했습니다.', 5, NULL, 4, true),
('정미영', '중견기업 E', '영업 이사', '고객 니즈를 정확히 파악하는 능력이 뛰어납니다. 그로우디의 인사이트 덕분에 신규 고객 유치율이 30% 증가했습니다.', 5, '/images/testimonials/profile4.jpg', 5, true); 