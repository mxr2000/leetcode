package com.mxr.demo;

public class Problem152 {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max, min;
        min = max = result;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            result = Math.max(max, result);
        }
        return result;
    }

}
