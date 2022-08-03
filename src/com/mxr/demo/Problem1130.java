package com.mxr.demo;

public class Problem1130 {
    public int mctFromLeafValues(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= arr.length; i++) {
            //dp[i] = Math.min(dp[i - 1] + dp[i - 1] * arr[i - 1], dp[i - 2] + arr[i - 2] * arr[i - 1] * (1 +))
        }
        return dp[arr.length];
    }
}
