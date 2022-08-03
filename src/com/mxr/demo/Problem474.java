package com.mxr.demo;

public class Problem474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] counts = getCounts(str);
            for (int zero = m; zero >= counts[0]; --zero) {
                for (int one = n; one >= counts[1]; --one) {
                    dp[zero][one] = Math.max(dp[zero][one], 1 + dp[zero - counts[0]][one - counts[1]]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] getCounts(String str) {
        int[] counts = new int[2];
        for (char ch : str.toCharArray()) {
            counts[ch - '0']++;
        }
        return counts;
    }
}
