package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0;
        int result = 0;
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == k) {
                result = i + 1;
            }
            if (indexes.containsKey(prefixSum - k)) {
                result = Math.max(result, i - indexes.get(prefixSum - k));
            }
            if (!indexes.containsKey(prefixSum)) {
                indexes.put(prefixSum, i);
            }
        }
        return result;
    }
}
