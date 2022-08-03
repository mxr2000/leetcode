package com.mxr.demo;

import java.util.Arrays;

public class Problem283 {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 || i == 0 || nums[i - 1] != 0) {
                continue;
            }
            int index = i;
            while (index > 0 && nums[index - 1] == 0) {
                index--;
            }
            nums[index] = nums[i];
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0};
        (new Problem283()).moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
