package com.mxr.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] counts = new int[nums.length];
        int[] pres = new int[nums.length];
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            counts[i] = 0;
            pres[i] = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (counts[j] + 1 > counts[i]) {
                        counts[i] = counts[j] + 1;
                        pres[i] = j;
                    }
                }
            }
            if (counts[i] > max) {
                max = counts[i];
                index = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        while (index != -1) {
            result.add(nums[index]);
            index = pres[index];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8};
        System.out.println((new Problem368()).largestDivisibleSubset(nums));
    }
}
