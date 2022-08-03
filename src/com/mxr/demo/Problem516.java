package com.mxr.demo;

public class Problem516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0 ; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], j == i + 1 ? 2 : (2 + dp[i + 1][j - 1]));
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], i == n - 1 ? 1 : dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println((new Problem516()).longestPalindromeSubseq("cbbd"));
    }
}
