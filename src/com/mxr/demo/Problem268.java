package com.mxr.demo;

import java.util.Arrays;

public class Problem268 {
    public int missingNumber(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        int maxSum = (nums.length + 1) * nums.length / 2;
        return maxSum - totalSum;
    }
}
