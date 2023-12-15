package com.techforb.technicaltest.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CardUtil {

    public static String generateRandomCardNumber() {
        Random random = new Random();
        long cardNumber = 100000000000L + (long) (random.nextDouble() * 900000000000L);
        return Long.toString(cardNumber);
    }

    public static int generateRandomCcv() {
        Random random = new Random();
        return 100 + random.nextInt(900);
    }

    public static Date generateExpirationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 4); // Agrega 4 años a la fecha actual
        return calendar.getTime();
    }
}
