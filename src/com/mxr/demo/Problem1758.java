package com.mxr.demo;

public class Problem1758 {
    public int minOperations(String s) {
        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (i % 2 == 1) {
                if (s.charAt(i) == '1') {
                    ++cnt0;
                } else {
                    ++cnt1;
                }
            } else {
                if (s.charAt(i) == '0') {
                    ++cnt0;
                } else {
                    ++cnt1;
                }
            }
        }
        return Math.min(cnt0, cnt1);
    }
}
