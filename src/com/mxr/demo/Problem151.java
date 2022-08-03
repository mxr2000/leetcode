package com.mxr.demo;

public class Problem151 {
    public String reverseWords(String s) {
        String[] parts = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if ("".equals(part)) {
                continue;
            }
            builder.insert(0, part);
            if (i != parts.length - 1) {
                builder.insert(0, " ");
            }
        }
        return builder.toString().strip();
    }
}
