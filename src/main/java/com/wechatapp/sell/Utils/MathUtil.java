package com.wechatapp.sell.Utils;

import java.math.BigDecimal;

public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;
    /**
     * Compare if two numbers equal
     * @param d1
     * @param d2
     * @return
     */
    public static boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE)
            return true;
        return false;
    }

}
