package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem904 {
    public int totalFruit(int[] fruits) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (map.size() < 2) {
                map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            } else {

            }
            result = Math.max(result, map.values().stream().reduce(0, Integer::sum));
        }
        return result;
    }
}
