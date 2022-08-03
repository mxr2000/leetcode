package com.mxr.demo;

import java.util.Arrays;

public class Problem169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int value = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times > nums.length / 2) {
                return value;
            }
            if (nums[i] == value) {
                times++;
            } else {
                times = 1;
                value = nums[i];
            }
        }
        return value;
    }
}
