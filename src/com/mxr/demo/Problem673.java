package com.mxr.demo;

import java.util.Arrays;

public class Problem673 {
    public int findNumberOfLIS(int[] nums) {
        int[] lens = new int[nums.length];
        int[] counts = new int[nums.length];
        int maxLength = 0;
        int result = 0;
        Arrays.fill(lens, 1);
        Arrays.fill(counts, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lens[i] == lens[j] + 1) {
                        counts[i] += counts[j];
                    } else if (lens[i] < lens[j] + 1) {
                        lens[i] = lens[j] + 1;
                        counts[i] = counts[j];
                    }
                }
            }
            if (maxLength == lens[i]) {
                result += counts[i];
            } else if (maxLength < lens[i]) {
                maxLength = lens[i];
                result = counts[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println((new Problem673()).findNumberOfLIS(nums));
    }
}
