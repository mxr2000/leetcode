package com.mxr.demo;

import java.util.Arrays;

public class Problem611 {
    public int triangleNumber(int[] nums) {
        int result = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = n - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (r > l) {
                if (nums[l] + nums[r] > nums[i]) {
                    result += (r - l);
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return result;
    }
}
