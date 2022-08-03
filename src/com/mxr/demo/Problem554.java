package com.mxr.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem554 {
    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(max, map.get(sum));
            }
        }

        return wall.size() - max;
    }
}
