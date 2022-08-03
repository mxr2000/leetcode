package com.mxr.demo;

public class Problem647 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int cnt = 0;
        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                if (length == 1) {
                    dp[i][i] = true;
                } else if (length == 2) {
                    dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                } else {
                    dp[i][i + length - 1] = s.charAt(i) == s.charAt(i + length - 1) && dp[i + 1][i + length - 2];
                }
                cnt += dp[i][i + length - 1] ? 1 : 0;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println((new Problem647()).countSubstrings("aaa"));
    }
}
