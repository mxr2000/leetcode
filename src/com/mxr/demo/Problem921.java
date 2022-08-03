package com.mxr.demo;

public class Problem921 {
    public int minAddToMakeValid(String s) {
        int result = 0;
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ++cnt;
            } else if (ch == ')') {
                --cnt;
            }
            if (cnt < 0) {
                ++result;
                ++cnt;
            }
        }
        return result + cnt;
    }

    public static void main(String[] args) {
        System.out.println((new Problem921()).minAddToMakeValid("()))(("));
    }
}
