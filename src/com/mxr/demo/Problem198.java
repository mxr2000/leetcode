package com.mxr.demo;

import java.util.Arrays;

public class Problem198 {
    int[] dp;
    public int rob(int[] nums) {
        /*dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + val);
        }
        return dp[nums.length];*/
        int prevOfPrev = 0;
        int last = nums[0];
        int max = last;
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            max = Math.max(last, prevOfPrev + val);
            prevOfPrev = last;
            last = max;
        }
        return max;
    }

    private int getMax(int[] nums, int index) {
        if (index < 0) {
            return 0;
        }
        if (dp[index] >= 0) {
            return dp[index];
        }
        int result = Math.max(nums[index] + getMax(nums, index - 2), getMax(nums, index - 1));
        dp[index] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println((new Problem198()).rob(new int[]{1, 2, 3, 1}));
    }
}
