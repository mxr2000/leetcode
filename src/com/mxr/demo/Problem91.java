package com.mxr.demo;

import java.util.Arrays;

public class Problem91 {
    public static void main(String[] args) {
        System.out.println((new Problem91()).numDecodings("226"));
    }
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= length; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }
}
