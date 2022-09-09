package com.mxr.demo;

public class Problem1493 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int len0 = nums[0], len1 = 0, result = len1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                len1 = len0;
                len0 = 0;
            } else {
                ++len0;
                ++len1;
            }
            result = Math.max(result, len1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println((new Problem1493()).longestSubarray(nums));
    }
}
