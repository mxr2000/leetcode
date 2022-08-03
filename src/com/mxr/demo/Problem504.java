package com.mxr.demo;

public class Problem504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isPositive = num > 0;
        StringBuilder builder = new StringBuilder("");
        num = Math.abs(num);
        while (num > 0) {
            builder.insert(0, num % 7);
            num /= 7;
        }
        if (!isPositive) {
            builder.insert(0, "-");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Problem504()).convertToBase7(-7));
    }
}
