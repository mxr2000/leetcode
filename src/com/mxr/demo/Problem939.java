package com.mxr.demo;

import java.util.*;

public class Problem939 {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> verticalMap = new HashMap<>();
        Map<Integer, Set<Integer>> horizontalMap = new HashMap<>();
        for (int[] p : points) {
            if (!verticalMap.containsKey(p[0])) {
                verticalMap.put(p[0], new HashSet<>());
            }
            if (!horizontalMap.containsKey(p[1])) {
                horizontalMap.put(p[1], new HashSet<>());
            }
            verticalMap.get(p[0]).add(p[1]);
            horizontalMap.get(p[1]).add(p[0]);
        }
        int min = Integer.MAX_VALUE;

        for (int[] p : points) {
            for (int y : verticalMap.get(p[0])) {
                if (y == p[1]) {
                    continue;
                }
                for (int x : horizontalMap.get(p[1])) {
                    if (x == p[0]) {
                        continue;
                    }
                    if (verticalMap.containsKey(x) &&
                            verticalMap.get(x).contains(y) &&
                            horizontalMap.containsKey(y) &&
                            horizontalMap.get(y).contains(x)
                    ) {
                        int width = Math.abs(x - p[0]);
                        int height = Math.abs(y - p[1]);
                        min = Math.min(width * height, min);
                    }
                }
            }

            verticalMap.get(p[0]).remove(p[1]);
            horizontalMap.get(p[1]).remove(p[0]);
            if (verticalMap.get(p[0]).isEmpty()) {
                verticalMap.remove(p[0]);
            }
            if (horizontalMap.get(p[1]).isEmpty()) {
                horizontalMap.remove(p[1]);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}};
        System.out.println((new Problem939()).minAreaRect(points));
    }
}
