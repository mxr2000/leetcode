package com.mxr.demo;

public class Problem813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] sums = new double[n + 1];
        double[] dp = new double[n];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            dp[i] = (sums[n] - sums[i]) / (n - i);
        }
        for (int d = 0; d < k - 1; d++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    dp[i] = Math.max(dp[i], dp[j] + (sums[j] - sums[i]) / (j - i));
                }
            }
        }

        return dp[0];
    }

}
