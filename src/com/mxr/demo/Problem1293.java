package com.mxr.demo;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1293 {
    private final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        visited[0][0][0] = true;
        queue.offer(new int[]{0, 0, 0});
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] info = queue.poll();
                if (info[0] == grid.length - 1 && info[1] == grid[0].length - 1) {
                    return result;
                }
                for (int[] d : directions) {
                    int[] newInfo = new int[]{info[0] + d[0], info[1] + d[1], info[2]};
                    if (!withinGrid(grid, newInfo)) {
                        continue;
                    }
                    if (grid[newInfo[0]][newInfo[1]] == 1) {
                        ++newInfo[2];
                    }
                    if (newInfo[2] > k) {
                        continue;
                    }
                    if (visited[newInfo[0]][newInfo[1]][newInfo[2]]) {
                        continue;
                    }

                    visited[newInfo[0]][newInfo[1]][newInfo[2]] = true;
                    queue.offer(newInfo);
                }
            }
            ++result;
        }
        return -1;
    }

    private boolean withinGrid(int[][] grid, int[] info) {
        return info[0] >= 0 && info[0] < grid.length && info[1] >= 0 && info[1] < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}
        };
        System.out.println((new Problem1293()).shortestPath(grid, 1));
    }
}
