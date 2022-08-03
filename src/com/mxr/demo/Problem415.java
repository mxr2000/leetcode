package com.mxr.demo;

import java.util.Map;

public class Problem415 {
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int carriage = 0;
        StringBuilder builder = new StringBuilder();
        int i;
        for (i = 0; i < Math.min(chars1.length, chars2.length); i++) {
            char ch1 = chars1[chars1.length - i - 1];
            char ch2 = chars2[chars2.length - i - 1];
            int d1 = ch1 - '0';
            int d2 = ch2 - '0';
            if (d1 + d2 + carriage >= 10) {
                builder.insert(0, (char) ('0' + (d1 + d2 + carriage - 10)));
                carriage = 1;
            } else {
                builder.insert(0, (char) ('0' + (d1 + d2 + carriage)));
                carriage = 0;
            }
        }
        if (chars1.length != chars2.length) {
            char[] remains = chars1.length > chars2.length ? chars1 : chars2;
            for (; i < remains.length; i++) {
                int d = remains[remains.length - i - 1] - '0';
                if (d + carriage >= 10) {
                    builder.insert(0, (char) ('0' + d + carriage - 10));
                    carriage = 1;
                } else {
                    builder.insert(0, (char) ('0' + d + carriage));
                    carriage = 0;
                }
            }
        }
        if (carriage == 1) {
            builder.insert(0, "1");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Problem415()).addStrings("0", "0"));
    }
}
