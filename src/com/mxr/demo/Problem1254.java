package com.mxr.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1254 {
    private static final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int closedIsland(int[][] grid) {
        int validCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j)) {
                    validCount++;
                }
            }
        }
        return validCount;
    }

    private boolean dfs(int[][] grid, int cx, int cy) {
        grid[cx][cy] = -1;
        boolean result = cx != 0 && cx != grid.length - 1 && cy != 0 && cy != grid[0].length - 1;
        List<int[]> coordinates = Arrays
                .stream(directions)
                .map(d -> new int[]{cx + d[0], cy + d[1]})
                .filter(c -> c[0] >= 0 && c[0] < grid.length && c[1] >= 0 && c[1] < grid[0].length)
                .filter(c -> grid[c[0]][c[1]] == 0)
                .toList();
        for (int[] c : coordinates) {
            if (grid[c[0]][c[1]] == 0 && !dfs(grid, c[0], c[1])) {
                result = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println((new Problem1254()).closedIsland(grid));
    }
}
