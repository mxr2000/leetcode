package com.mxr.demo;

public class Problem2348 {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        int n = nums.length, left = 0;
        for (int right = 0; right < n; ++right) {
            if (nums[right] != 0) {
                left = right + 1;
                continue;
            }
            result += (right - left + 1);
        }

        return result;
    }
}
