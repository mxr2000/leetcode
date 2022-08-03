package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;


// 1, 1, -1, -1, -1, 1

public class Problem1124 {
    public int longestWPI(int[] hours) {
        int sum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                result = i + 1;
            } else if (map.containsKey(sum - 1)) {
                result = Math.max(result, i - map.get(sum - 1));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return result;
    }
}
