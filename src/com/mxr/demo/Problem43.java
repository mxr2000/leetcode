package com.mxr.demo;

public class Problem43 {
    public String multiply(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carriage = 0;
        for (int i = 0; i < Math.min(num1.length(), num2.length()); ++i) {
            int d1 = num1.charAt(num1.length() - i - 1) - '0';
            int d2 = num2.charAt(num2.length() - i - 1) - '0';
            char ch;
            int product = d1 * d2 + carriage;
            if (product >= 10) {
                ch = (char) ('0' + product % 10);
                carriage = product / 10;
            } else {
                ch = (char) ('0' + product);
                carriage = 0;
            }
            builder.insert(0, ch);
        }
        if (num1.length() != num2.length()) {
            String s = num1.length() > num2.length() ? num1 : num2;
            int right = builder.length();
            for (int i = 0; i < s.length() - right; ++i) {
                int d = s.charAt(s.length() - right - i - 1) - '0';
                char ch;
                if (d + carriage >= 10) {
                    ch = (char) ('0' + d + carriage - 10);
                    carriage = 1;
                } else {
                    ch = (char) ('0' + d + carriage);
                    carriage = 0;
                }
                builder.insert(0, ch);
            }
        }
        if (carriage == 1) {
            builder.insert(0, '1');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Problem43()).multiply("2", "3"));
    }
}
