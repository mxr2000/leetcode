package com.mxr.demo;

public class Problem329 {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        System.out.println((new Problem329()).longestIncreasingPath(matrix));
    }

    private final int[] dirs = {0, 1, 0, -1, 0};
    public int longestIncreasingPath(int[][] matrix) {
        int max = 1;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (!isValidStartingPosition(matrix, x, y)) {
                    continue;
                }
                max = Math.max(max, dfs(matrix, dp, x, y));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] dp, int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        int max = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i];
            int ny = y + dirs[i + 1];
            if (!isInBounds(matrix, nx, ny) || matrix[nx][ny] <= matrix[x][y]) {
                continue;
            }
            max = Math.max(max, dfs(matrix, dp, nx, ny));
        }
        dp[x][y] = 1 + max;
        return 1 + max;
    }

    private boolean isInBounds(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }

    private boolean isValidStartingPosition(int[][] matrix, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i];
            int ny = y + dirs[i + 1];
            if (isInBounds(matrix, nx, ny) && matrix[nx][ny] < matrix[x][y]) {
                return false;
            }
        }
        return true;
    }
}
