package com.mxr.demo;

public class Problem1869 {
    public boolean checkZeroOnes(String s) {
        boolean isOne = s.charAt(0) == '1';
        int len0 = 0, len1 = 0, max0 = 0, max1 = 0;
        for (char ch : s.toCharArray()) {
            if (isOne) {
                if (ch == '1') {
                    ++len1;
                } else {
                    isOne = false;
                    len1 = 0;
                    len0 = 1;
                }
            } else {
                if (ch == '0') {
                    ++len0;
                } else {
                    isOne = true;
                    len0 = 0;
                    len1 = 1;
                }
            }
            max0 = Math.max(max0, len0);
            max1 = Math.max(max1, len1);
        }
        return max1 > max0;
    }
}
