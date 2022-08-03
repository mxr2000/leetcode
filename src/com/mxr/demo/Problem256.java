package com.mxr.demo;

public class Problem256 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            int[] cost = costs[i];
            dp[i + 1][0] = cost[0] + Math.min(dp[i][1], dp[i][2]);
            dp[i + 1][1] = cost[1] + Math.min(dp[i][0], dp[i][2]);
            dp[i + 1][2] = cost[2] + Math.min(dp[i][0], dp[i][1]);
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}
