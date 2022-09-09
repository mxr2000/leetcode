package com.mxr.demo;

public class Problem1827 {
    public int minOperations(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                continue;
            }
            int change = nums[i - 1] - nums[i] + 1;
            nums[i] += change;
            result += change;
        }

        return result;
    }
}
