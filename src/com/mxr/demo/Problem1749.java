package com.mxr.demo;

public class Problem1749 {
    public int maxAbsoluteSum(int[] nums) {
        int result = 0;
        int min = 0, max = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int newMin = Math.min(min, sum);
            int newMax = Math.max(max, sum);
            if (newMax > max) {
                result = Math.max(result, newMax - min);
            }
            if (newMin < min) {
                result = Math.max(result, max - newMin);
            }
            min = newMin;
            max = newMax;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, -5, 1, -4, 3, -2};
        System.out.println((new Problem1749()).maxAbsoluteSum(nums));
    }
}
