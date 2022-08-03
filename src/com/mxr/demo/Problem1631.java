package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1631 {
    private final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(info -> info[2]));
        int[] info = new int[] {0, 0, 0};
        int[][] distances = new int[heights.length][heights[0].length];
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distances[0][0] = 0;
        pq.offer(info);
        while (!pq.isEmpty()) {
            info = pq.poll();
            if (info[2] > distances[info[0]][info[1]]) {
                continue;
            }
            if (info[0] == heights.length - 1 && info[1] == heights[0].length - 1) {
                return info[2];
            }
            for (int[] d : directions) {
                int[] newInfo = new int[] {info[0] + d[0], info[1] + d[1], 0};
                if (!isInGrid(heights, newInfo)) {
                    continue;
                }
                int newDistance = Math.max(info[2], Math.abs(heights[newInfo[0]][newInfo[1]] - heights[info[0]][info[1]]));
                if (newDistance < distances[newInfo[0]][newInfo[1]]) {
                    distances[newInfo[0]][newInfo[1]] = newDistance;
                    newInfo[2] = newDistance;
                    pq.offer(newInfo);
                }
            }
        }
        return 0;
    }

    private boolean isInGrid(int[][] heights, int[] info) {
        return info[0] >= 0 && info[0] < heights.length && info[1] >= 0 && info[1] < heights[0].length;
    }

    public static void main(String[] args) {
        int[][] heights = {
                {10, 8},
                {10, 8},
                {1, 2},
                {10, 3},
                {1, 3},
                {6, 3},
                {5, 2}
        };
        System.out.println((new Problem1631()).minimumEffortPath(heights));
    }
}
