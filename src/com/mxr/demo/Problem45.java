package com.mxr.demo;

public class Problem45 {
    public int jump(int[] nums) {
        int end = nums[0], max = 0;
        int steps = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                ++steps;
                end = max;
            }
        }
        return steps;
    }
}
