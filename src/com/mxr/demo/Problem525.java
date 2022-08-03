package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem525 {
    public int findMaxLength(int[] nums) {
        int prefixSum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(prefixSum)) {
                result = Math.max(result, i - map.get(prefixSum));
            }

            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println((new Problem525()).findMaxLength(nums));
    }
}
