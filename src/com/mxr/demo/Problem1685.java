package com.mxr.demo;

import java.util.Arrays;

public class Problem1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSums = new int[n], result = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSums[i] = (i == 0 ? 0 : prefixSums[i - 1]) + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int former = i == 0 ? 0 : (i * nums[i] - prefixSums[i - 1]);
            int later = i == n - 1 ? 0 : (prefixSums[n - 1] - prefixSums[i] - (n - i - 1) * nums[i]);
            result[i] = former + later;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        System.out.println(Arrays.toString((new Problem1685()).getSumAbsoluteDifferences(nums)));
    }


}
