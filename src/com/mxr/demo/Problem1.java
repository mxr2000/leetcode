package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexes.containsKey(target - nums[i])) {
                return new int[] {i, indexes.get(target - nums[i])};
            }
            indexes.put(nums[i], i);
        }
        return nums;
    }
}
