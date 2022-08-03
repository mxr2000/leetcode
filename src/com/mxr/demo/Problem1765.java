package com.mxr.demo;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1765 {
    public int[][] highestPeak(int[][] isWater) {
        int[][] height = new int[isWater.length][isWater[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[] {i, j});
                } else {
                    height[i][j] = -1;
                }
            }
        }
        int[] dirs = {0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r = p[0] + dirs[i];
                int c = p[1] + dirs[i + 1];
                if (r < 0 || r >= isWater.length || c < 0 || c >= isWater[0].length) {
                    continue;
                }
                if (height[r][c] != -1) {
                    continue;
                }
                height[r][c] = height[p[0]][p[1]] + 1;
                queue.offer(new int[] {r, c});
            }
        }

        return height;
    }

}
