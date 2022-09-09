package com.mxr.demo;

public class Problem2291 {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        int[][] dp = new int[budget + 1][n + 1];
        for (int i = 0; i <= budget; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= present[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - present[j - 1]][j - 1] + future[j - 1] - present[j - 1]);
                }
            }
        }
        return dp[budget][n];
    }

    public static void main(String[] args) {
        int[] present = {0}, future = {1};
        int budget = 0;
        System.out.println((new Problem2291()).maximumProfit(present, future, budget));
    }
}
