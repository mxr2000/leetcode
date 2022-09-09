package com.mxr.demo;

public class Problem413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0, n = nums.length;
        int left = 0;
        for (int right = 2; right < n; ++right) {
            if (nums[right] - nums[right - 1] != nums[right - 1] - nums[right - 2]) {
                left = right - 1;
                continue;
            }
            if (right >= left + 2) {
                result += (right - left - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println((new Problem413()).numberOfArithmeticSlices(nums));
    }
}
