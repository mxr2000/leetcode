package com.mxr.demo;

public class Problem53 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            current = Math.max(num, num + current);
            result = Math.max(result, current);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((new Problem53()).maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
