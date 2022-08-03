package com.mxr.demo;

public class Problem674 {
    public int findLengthOfLCIS(int[] nums) {
        int from = 0;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                max = Math.max(max, i - from + 1);
            } else {
                from = i;
            }
        }
        return Math.max(max, nums.length - from);
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println((new Problem674()).findLengthOfLCIS(nums));
    }
}
