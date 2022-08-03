package com.mxr.demo;

public class Problem67 {
    public static void main(String[] args) {
        System.out.println((new Problem67()).addBinary("1010", "1011"));
    }
    public String addBinary(String a, String b) {
        StringBuilder buffer = new StringBuilder();
        int index = 0;
        int append = 0;
        while (index < Math.max(a.length(), b.length())) {
            char first = a.length() - index - 1 >= 0 ? a.charAt(a.length() - index - 1) : '0';
            char second = b.length() - index - 1 >= 0 ? b.charAt(b.length() - index - 1) : '0';
            if (append == 0) {
                if (first == '0' && second == '0') {
                    buffer.insert(0, "0");
                } else if (first == '1' && second == '1') {
                    buffer.insert(0, "0");
                    append++;
                } else {
                    buffer.insert(0, "1");
                }
            } else {
                if (first == '1' && second == '1') {
                    buffer.insert(0, "0");
                } else if (first == '0' && second == '0') {
                    buffer.insert(0, "1");
                    append--;
                } else {
                    buffer.insert(0, "0");
                }
            }
            index++;
        }
        if (append > 0) {
            while (append > 1) {
                buffer.insert(0, "0");
            }
            buffer.insert(0, "1");
        }

        return buffer.toString();
    }
}
