package com.mxr.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> sorted = map.keySet().stream().sorted().toList();
        int result = 0;
        for (int i = 0; i < sorted.size() - 1; i++) {
            if (sorted.get(i + 1) == sorted.get(i) + 1) {
                result = Math.max(result, map.get(sorted.get(i)) + map.get(sorted.get(i + 1)));
            }
        }
        return result;
    }
}
