package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem2290 {
    private final int[][] directions = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    public int minimumObstacles(int[][] grid) {
        int result = 0;
        // 1 for visited road, 2 for obstacle to remove, 0 for removed obstacle or space
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = 1;
        List<int[]> frontier = new ArrayList<>();
        frontier.add(new int[]{0, 0});
        while (!frontier.isEmpty()) {

            List<int[]> newFrontier = new ArrayList<>();
            for (int[] p : frontier) {
                if (propagate(grid, dp, p, newFrontier)) {
                    return result;
                }
            }
            frontier = newFrontier;
            for (int[] p : frontier) {
                dp[p[0]][p[1]] = 1;
            }
            ++result;
        }
        return result;
    }

    private boolean propagate(int[][] grid, int[][] dp, int[] p, List<int[]> frontier) {
        if (p[0] == grid.length - 1 && p[1] == grid[0].length - 1) {
            return true;
        }
        for (int[] d : directions) {
            int[] newP = new int[]{p[0] + d[0], p[1] + d[1]};
            if (!isWithinGrid(grid, newP)) {
                continue;
            }
            if (grid[newP[0]][newP[1]] == 0 && dp[newP[0]][newP[1]] == 0) {
                dp[newP[0]][newP[1]] = 1;
                if (propagate(grid, dp, newP, frontier)) {
                    return true;
                }
            }
            if (grid[newP[0]][newP[1]] == 1 && dp[newP[0]][newP[1]] == 0) {
                dp[newP[0]][newP[1]] = 2;
                frontier.add(newP);
            }
        }
        return false;
    }

    private boolean isWithinGrid(int[][] grid, int[] p) {
        return p[0] >= 0 && p[0] < grid.length && p[1] >= 0 && p[1] < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0}
        };
        System.out.println((new Problem2290()).minimumObstacles(grid));
    }
}
