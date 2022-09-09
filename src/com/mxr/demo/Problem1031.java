package com.mxr.demo;

public class Problem1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length, result = 0;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        return Math.max(maxSum(sums, firstLen, secondLen), maxSum(sums, secondLen, firstLen));
    }

    private int maxSum(int[] sums, int l1, int l2) {
        int result = 0;
        for (int i = l1 + l2, maxL = 0; i < sums.length; i++) {
            maxL = Math.max(maxL, sums[i - l2] - sums[i - l2 - l1]);
            result = Math.max(result, maxL + sums[i] - sums[i - l2]);
        }
        return result;
    }
}
