package com.mxr.demo;

public class Problem1746 {
    public int maxSumAfterOperation(int[] nums) {
        int n = nums.length;
        int max0 = nums[0], max1 = nums[0] * nums[0], result = max1;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            max1 = Math.max(num * num, Math.max(max0 + num * num, max1 + num));
            max0 = Math.max(num, max0 + num);
            result = Math.max(result, max1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 1, 1, -1, -1, 1};
        System.out.println((new Problem1746()).maxSumAfterOperation(nums));
    }
}
