package com.mxr.demo;

public class Problem1752 {
    public boolean check(int[] nums) {
        boolean lowered = false;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                if (!lowered) {
                    lowered = true;
                } else {
                    return false;
                }
            }
        }
        return !lowered || nums[0] >= nums[n - 1];
    }
}
