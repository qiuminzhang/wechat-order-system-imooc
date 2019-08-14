package com.wechatapp.sell.Utils;

import java.util.Random;

/** Generate a random key for orderId*/
public class KeyUtil {
    /** Generate unique key
     * Format: time + random number*/
    public static synchronized String genUniqueKey() {

        Random random = new Random();
        System.currentTimeMillis();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
