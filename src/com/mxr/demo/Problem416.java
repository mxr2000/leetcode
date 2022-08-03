package com.mxr.demo;

import java.util.Arrays;

public class Problem416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum / 2];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println((new Problem416()).canPartition(nums));
    }
}
