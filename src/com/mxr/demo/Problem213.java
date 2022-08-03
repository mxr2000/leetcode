package com.mxr.demo;

public class Problem213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), Math.max(rob(nums, 1, nums.length), rob(nums, 1, nums.length - 1)));
    }

    private int rob(int[] nums, int from, int to) {
        int[] dp = new int[nums.length];
        for (int i = from; i < to; i++) {
            dp[i] = -1;
        }
        return getMax(dp, nums, to - 1, from);
    }

    private int getMax(int[] dp, int[] nums, int index, int from) {
        if (index < from) {
            return 0;
        }
        if (dp[index] >= 0) {
            return dp[index];
        }
        int result = Math.max(getMax(dp, nums, index - 1, from), getMax(dp, nums, index - 2, from) + nums[index]);
        if (result > dp[index]) {
            dp[index] = result;
        }
        return dp[index];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println((new Problem213()).rob(nums));
    }
}
