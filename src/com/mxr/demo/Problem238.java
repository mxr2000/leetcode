package com.mxr.demo;

public class Problem238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        int zeroCnt = 0;
        for (int num : nums) {
            if (num == 0) {
                ++zeroCnt;
            } else {
                product *= num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCnt > 1) {
                result[i] = 0;
            } else if (zeroCnt > 0) {
                result[i] = nums[i] == 0 ? product : 0;
            } else {
                result[i] = product / nums[i];
            }

        }
        return result;
    }
}
