package com.mxr.demo;

import java.util.Arrays;
import java.util.List;

public class Problem1020 {
    private static final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    private int dfs(int[][] grid, int cx, int cy) {
        grid[cx][cy] = -1;
        int cnt = 1;
        boolean result = cx != 0 && cx != grid.length - 1 && cy != 0 && cy != grid[0].length - 1;
        List<int[]> coordinates = Arrays
                .stream(directions)
                .map(d -> new int[]{cx + d[0], cy + d[1]})
                .filter(c -> c[0] >= 0 && c[0] < grid.length && c[1] >= 0 && c[1] < grid[0].length)
                .filter(c -> grid[c[0]][c[1]] == 1)
                .toList();
        for (int[] c : coordinates) {
            if (grid[c[0]][c[1]] == 1) {
                int ret = dfs(grid, c[0], c[1]);
                if (ret == 0) {
                    result = false;
                }
                cnt += ret;
            }
        }
        return result ? cnt : 0;
    }

    public int numEnclaves(int[][] grid) {
        int enclaves = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    enclaves += dfs(grid, i, j);
                }
            }
        }
        return enclaves;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println((new Problem1020()).numEnclaves(grid));
    }
}
