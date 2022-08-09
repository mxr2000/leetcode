package com.mxr.demo;

import java.util.Arrays;

public class Problem727 {
    public String minWindow(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                dp[i][0] = i;
            } else {
                dp[i][0] = i == 0 ? -1 : dp[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = i == 0 ? -1 : dp[i - 1][j - 1];
                } else {
                    dp[i][j] = i == 0 ? -1 : dp[i - 1][j];
                }
            }
        }
        int from = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (dp[i][n - 1] != -1 && i - dp[i][n - 1] + 1 < result) {
                result = i - dp[i][n - 1] + 1;
                from = dp[i][n - 1];
            }
        }
        return result == Integer.MAX_VALUE ? "" : s1.substring(from, from + result);
    }

    public static void main(String[] args) {
        String s1 = "abcdebdde";
        String s2 = "bde";
        System.out.println((new Problem727()).minWindow(s1, s2));
    }
}
