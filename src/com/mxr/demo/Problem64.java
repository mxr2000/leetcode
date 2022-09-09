package com.mxr.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));
        pq.add(new int[] {0, 0, grid[0][0]});
        int[] dirs = {0, 1, 0};
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0], y = p[1], sum = p[2];
            if (grid[x][y] == -1) {
                continue;
            }
            grid[x][y] = -1;
            if (x == m - 1 && y == n - 1) {
                return sum;
            }
            for (int i = 0; i < 2; i++) {
                int nx = x + dirs[i], ny = y + dirs[i + 1];
                if (nx >= m || ny >= n || grid[nx][ny] == -1) {
                    continue;
                }
                pq.offer(new int[] {nx, ny, sum + grid[nx][ny]});
            }
        }
        return 0;
    }
}
