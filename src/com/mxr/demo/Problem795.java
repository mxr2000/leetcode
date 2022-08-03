package com.mxr.demo;

public class Problem795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int max) {
        int result = 0, val = 0;
        for (int num : nums) {
            val = num <= max ? val + 1 : 0;
            result += val;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3};
        System.out.println((new Problem795()).numSubarrayBoundedMax(nums, 2, 3));
    }
}
