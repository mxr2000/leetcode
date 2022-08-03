package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem694 {
    private final int[] dirs = {0, 1, 0, -1, 0};

    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                set.add(dfs(grid, i, j));
            }
        }

        return set.size();
    }

    private String dfs(int[][] grid, int x, int y) {
        grid[x][y] = 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i], ny = y + dirs[i + 1];
            if (!isInGrid(grid, nx, ny) || grid[nx][ny] != 1) {
                continue;
            }
            result.append(i);
            result.append(dfs(grid, nx, ny));
        }
        result.append("-");
        return result.toString();
    }

    private boolean isInGrid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };
        System.out.println((new Problem694()).numDistinctIslands(grid));
    }
}
