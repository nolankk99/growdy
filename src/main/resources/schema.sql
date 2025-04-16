-- 문의 테이블
CREATE TABLE IF NOT EXISTS contact_inquiry (
    inquiry_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    subject VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    status VARCHAR(20) DEFAULT 'NEW',
    is_read BOOLEAN DEFAULT FALSE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 문의 답변 테이블
CREATE TABLE IF NOT EXISTS contact_reply (
    reply_id INT AUTO_INCREMENT PRIMARY KEY,
    inquiry_id INT NOT NULL,
    reply_content TEXT NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (inquiry_id) REFERENCES contact_inquiry(inquiry_id)
);

-- 뉴스레터 구독자 테이블
CREATE TABLE IF NOT EXISTS newsletter_subscriber (
    subscriber_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    is_active BOOLEAN DEFAULT TRUE,
    subscribe_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    unsubscribe_date TIMESTAMP NULL
);

-- 이메일 발송 로그 테이블
CREATE TABLE IF NOT EXISTS email_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    recipient_email VARCHAR(255) NOT NULL,
    subject VARCHAR(255),
    content TEXT,
    status VARCHAR(20) NOT NULL,
    error_message TEXT,
    sent_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 고객 후기 테이블
CREATE TABLE IF NOT EXISTS testimonial (
    testimonial_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    company VARCHAR(100),
    position VARCHAR(100),
    content TEXT NOT NULL,
    rating INT NOT NULL DEFAULT 5,
    image_url VARCHAR(255),
    display_order INT DEFAULT 0,
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 인덱스 추가
CREATE INDEX IF NOT EXISTS idx_contact_inquiry_email ON contact_inquiry(email);
CREATE INDEX IF NOT EXISTS idx_contact_inquiry_status ON contact_inquiry(status);
CREATE INDEX IF NOT EXISTS idx_newsletter_subscriber_email ON newsletter_subscriber(email);
CREATE INDEX IF NOT EXISTS idx_email_log_recipient ON email_log(recipient_email);
CREATE INDEX IF NOT EXISTS idx_email_log_status ON email_log(status); 