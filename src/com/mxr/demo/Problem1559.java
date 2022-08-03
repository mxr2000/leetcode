package com.mxr.demo;

public class Problem1559 {
    private final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public boolean containsCycle(char[][] grid) {
        boolean[][] dp = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!dp[i][j] && dfs(grid, dp, new int[]{i, j}, new int[]{-1, -1})) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] dp, int[] coord, int[] lastCoord) {
        dp[coord[0]][coord[1]] = true;
        for (int[] d : directions) {
            int[] newCoord = new int[]{coord[0] + d[0], coord[1] + d[1]};
            if (!isInBound(grid, newCoord)
                    || (newCoord[0] == lastCoord[0] && newCoord[1] == lastCoord[1])
                    || !(grid[newCoord[0]][newCoord[1]] == grid[coord[0]][coord[1]])) {
                continue;
            }
            if (dp[newCoord[0]][newCoord[1]] || dfs(grid, dp, newCoord, coord)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBound(char[][] grid, int[] c) {
        return c[0] >= 0 && c[0] < grid.length && c[1] >= 0 && c[1] < grid[0].length;
    }

    public static void main(String[] args) {
        char[][] grid = {
                /*{'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}*/
                {'a', 'a', 'b'}
        };
        System.out.println((new Problem1559()).containsCycle(grid));
    }
}
