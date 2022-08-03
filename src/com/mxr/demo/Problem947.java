package com.mxr.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem947 {
    /*public int removeStones(int[][] stones) {
        Map<Integer, Set<Integer>> sameRows = new HashMap<>();
        Map<Integer, Set<Integer>> sameColumns = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int column = stones[i][1];
            if (!sameRows.containsKey(row)) {
                sameRows.put(row, new HashSet<>());
            }
            sameRows.get(row).add(i);
            if (!sameColumns.containsKey(column)) {
                sameColumns.put(column, new HashSet<>());
            }
            sameColumns.get(column).add(i);
        }

    }

    int remove(Map<Integer, Set<Integer>> sameRows, Map<Integer, Set<Integer>> sameColumns) {
        for (int row : sameRows.keySet()) {
            if (sameRows.get(row).size() >= 2) {
                sameRows.get(row).remove()
            }
        }
    }*/
}
