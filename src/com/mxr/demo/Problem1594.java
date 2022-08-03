package com.mxr.demo;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1594 {
    public int maxProductPath(int[][] grid) {
        int min = -5;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, grid[0][0]});
        grid[0][0] = min;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[0] < grid.length - 1 && grid[p[0] + 1][p[1]] != 0 && grid[p[0] + 1][p[1]] != min) {
                int val = grid[p[0] + 1][p[1]];
                if (val > 0) {
                    //queue.
                }
            }
        }
        return 0;
    }
}
