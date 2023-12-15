package com.techforb.technicaltest.utils;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class CardUtilTest {

    @Test
    void generateRandomCardNumber_ShouldGenerateValidNumber() {
        String cardNumber = CardUtil.generateRandomCardNumber();
        assertNotNull(cardNumber);
        assertTrue(cardNumber.matches("^\\d{12}$"));
    }

    @Test
    void generateRandomCcv_ShouldGenerateValidCcv() {
        int ccv = CardUtil.generateRandomCcv();
        assertTrue(ccv >= 100 && ccv <= 999); 
    }

    @Test
    void generateExpirationDate_ShouldGenerateValidDate() {
        Date expirationDate = CardUtil.generateExpirationDate();
        assertNotNull(expirationDate);
        assertTrue(expirationDate.after(new Date())); 
    }
}
