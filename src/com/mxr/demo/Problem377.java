package com.mxr.demo;

public class Problem377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int sum = 1; sum <= target; ++sum) {
            for (int num : nums) {
                if (sum >= num) {
                    dp[sum] += dp[sum - num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println((new Problem377()).combinationSum4(nums, 4));
    }
}
