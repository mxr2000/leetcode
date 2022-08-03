package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int from = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        int result = 0;
        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            prefixSum[i] = num + (i == 0 ? 0 : prefixSum[i - 1]);
            if (seen.containsKey(num) && seen.get(num) >= from) {
                from = seen.get(num) + 1;
            }
            seen.put(num, i);
            result = Math.max(result, prefixSum[i] - (from == 0 ? 0 : prefixSum[from - 1]));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        System.out.println((new Problem1695()).maximumUniqueSubarray(nums));
    }
}
