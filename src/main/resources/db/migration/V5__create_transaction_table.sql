CREATE TABLE IF NOT EXISTS transaction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    sender_user_id BIGINT,
    receiver_user_id BIGINT,
    amount DECIMAL(10, 2) NOT NULL,
    description VARCHAR(255),
    reference_number VARCHAR(255) UNIQUE,
    status_id BIGINT,
    
    FOREIGN KEY (sender_user_id) REFERENCES user(id),
    FOREIGN KEY (receiver_user_id) REFERENCES user(id),
    FOREIGN KEY (status_id) REFERENCES status(id)

);
