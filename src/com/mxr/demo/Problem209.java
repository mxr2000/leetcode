package com.mxr.demo;

public class Problem209 {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int begin = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                result = Math.min(result, i - begin + 1);
                sum -= nums[begin];
                begin++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println((new Problem209()).minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
