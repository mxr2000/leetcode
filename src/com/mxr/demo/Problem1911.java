package com.mxr.demo;

public class Problem1911 {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long pMax = 0, nMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            pMax = Math.max(pMax, nums[i] + nMax);
            nMax = Math.max(nMax, -nums[i] + pMax);
        }
        return pMax;
    }

    private int backtrack(int[] nums, int from, boolean isNegative) {
        int n = nums.length;
        int max = 0;
        for (int i = from; i < n; i++) {
            max = Math.max(max, nums[i] * (isNegative ? -1 : 1) + backtrack(nums, i + 1, !isNegative));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8};
        System.out.println((new Problem1911()).maxAlternatingSum(nums));
    }
}
