package com.mxr.demo;

public class Problem541 {
    public String reverseStr(String s, int k) {
        String suffix = s.substring(k);
        StringBuilder builder = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < k; i++) {
            builder.insert(0, arr[i]);
        }
        return builder.toString() + suffix;
    }
}
