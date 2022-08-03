package com.mxr.demo;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1102 {
    public int maximumMinimumPath(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        dp[0][0] = grid[0][0];
        int[] dirs = {0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dirs[i], ny = p[1] + dirs[i + 1];
                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                    continue;
                }
                int nv = Math.min(dp[p[0]][p[1]], grid[nx][ny]);
                if (nv > dp[nx][ny]) {
                    dp[nx][ny] = nv;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{5,4,5},{1,2,6},{7,4,6}};
        System.out.println((new Problem1102()).maximumMinimumPath(grid));
    }
}
