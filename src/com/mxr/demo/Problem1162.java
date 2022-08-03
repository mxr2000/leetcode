package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem1162 {
    public int maxDistance(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        List<int[]> coords = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                List<int[]> finalCoords = coords;
                getValidNeighbours(grid, i, j).forEach(c -> {
                    if (grid[c[0]][c[1]] == 0) {
                        finalCoords.add(c);
                    }
                });
            }
        }
        int current = 0;
        while (!coords.isEmpty()) {
            ++current;
            List<int[]> newCoords = new ArrayList<>();
            for (int[] p : coords) {
                dp[p[0]][p[1]] = current;
                List<int[]> possibleCoords = getValidNeighbours(grid, p[0], p[1]);
                for (int[] c : possibleCoords) {
                    if (grid[c[0]][c[1]] == 1 || dp[c[0]][c[1]] != 0) {
                        continue;
                    }
                    newCoords.add(c);
                }
            }
            coords = newCoords;
        }
        return current == 0 ? -1 : current;
    }

    private List<int[]> getValidNeighbours(int[][] grid, int x, int y) {
        List<int[]> result = new ArrayList<>();
        if (x - 1 > 0) {
            result.add(new int[] {x - 1, y});
        }
        if (x + 1 < grid.length) {
            result.add(new int[] {x + 1, y});
        }
        if (y - 1 > 0) {
            result.add(new int[] {x, y - 1});
        }
        if (y + 1 < grid[0].length) {
            result.add(new int[] {x, y + 1});
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        System.out.println((new Problem1162()).maxDistance(grid));
    }
}
