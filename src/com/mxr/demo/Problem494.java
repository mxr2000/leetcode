package com.mxr.demo;

import java.util.Arrays;

public class Problem494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][sum + nums[0]] = 1;
        dp[0][sum - nums[0]] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (dp[i - 1][j + sum] > 0) {
                    dp[i][sum + j + nums[i]] += dp[i - 1][sum + j];
                    dp[i][sum + j - nums[i]] += dp[i - 1][sum + j];
                }
            }
        }
        return Math.abs(target) > sum ? 0 : dp[nums.length - 1][target + sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println((new Problem494()).findTargetSumWays(nums, 3));
    }
}
