package com.mxr.demo;

public class Problem1664 {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length, totalSum = 0;
        int[] oddSums = new int[n], evenSums = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenSums[i] = (i == 0 ? 0 : evenSums[i - 2]) + nums[i];
            } else {
                oddSums[i] = (i == 1 ? 0 : oddSums[i - 2]) + nums[i];
            }
            totalSum += nums[i];
        }
        int maxOddIndex = Math.max(0, n % 2 == 0 ? n - 1 : n - 2);
        int maxEvenIndex = Math.max(0, n % 2 == 1 ? n - 1 : n - 2);
        int result = 0;
        for (int i = 0; i < n; i++) {
            int val;
            if (i % 2 == 0) {
                val = (i == 0 ? 0 : evenSums[i - 2]) + ((oddSums[maxOddIndex] - (i >= 2 ? oddSums[i - 1] : 0)));
            } else {
                val = (i == 1 ? 0 : oddSums[i - 2]) + evenSums[maxEvenIndex] - evenSums[i - 1];
            }
            if (val == totalSum - val - nums[i]) {
                ++result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println((new Problem1664()).waysToMakeFair(nums));
    }
}
