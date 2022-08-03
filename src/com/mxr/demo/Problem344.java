package com.mxr.demo;

import java.util.Arrays;

public class Problem344 {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char ch = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = ch;
        }
    }

    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        (new Problem344()).reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
