package com.mxr.demo;

public class Problem12 {
    public String intToRoman(int num) {
        int d1 = num / 1000;
        int d2 = (num % 1000) / 100;
        int d3 = (num % 100) / 10;
        int d4 = num % 10;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < d1; i++) {
            builder.append("M");
        }
        if (d2 != 0) {
            if (d2 == 4) {
                builder.append("CD");
            } else if (d2 == 9) {
                builder.append("CM");
            } else {
                if (d2 >= 5) {
                    builder.append("D");
                }
                for (int i = 0; i < (d2 >= 5 ? (d2 - 5) : d2); i++) {
                    builder.append("C");
                }
            }
        }
        if (d3 != 0) {
            if (d3 == 4) {
                builder.append("XL");
            } else if (d3 == 9) {
                builder.append("XC");
            } else {
                if (d3 >= 5) {
                    builder.append("L");
                }
                for (int i = 0; i < (d3 >= 5 ? (d3 - 5) : d3); i++) {
                    builder.append("X");
                }
            }
        }
        if (d4 != 0) {
            if (d4 == 4) {
                builder.append("IV");
            } else if (d4 == 9) {
                builder.append("IX");
            } else {
                if (d4 >= 5) {
                    builder.append("V");
                }
                for (int i = 0; i < (d4 >= 5 ? (d4 - 5) : d4); i++) {
                    builder.append("I");
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Problem12()).intToRoman(1994));
    }
}
