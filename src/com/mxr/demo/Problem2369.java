package com.mxr.demo;

public class Problem2369 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (i < n - 2) {
                if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
                    dp[i] = dp[i + 3];
                } else if (nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]) {
                    dp[i] = dp[i + 3];
                }
            }
            if (!dp[i] && nums[i] == nums[i + 1]) {
                dp[i] = dp[i + 2];
            }
        }
        return dp[0];
    }

    private boolean backtrack(int[] nums, int index) {
        int n = nums.length, length = n - index;
        return
                (length == 0) ||
                        (length >= 2 && nums[index] == nums[index + 1] && backtrack(nums, index + 2)) ||
                        (length >= 3 && nums[index] == nums[index + 1] && nums[index + 1] == nums[index + 2] && backtrack(nums, index + 3)) ||
                        (length >= 3 && nums[index] + 1 == nums[index + 1] && nums[index + 1] + 1 == nums[index + 2] && backtrack(nums, index + 3));
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 3};
        System.out.println((new Problem2369()).validPartition(nums));
    }
}
