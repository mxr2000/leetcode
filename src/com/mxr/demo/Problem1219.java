package com.mxr.demo;

public class Problem1219 {
    int[] dirs = {1, 0, -1, 0, 1};

    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nr = i + dirs[k];
                    int nc = j + dirs[k + 1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] != 0) {
                        continue;
                    }
                    max = Math.max(max, dfs(grid, new boolean[grid.length][grid[0].length], i, j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            int nr = row + dirs[i];
            int nc = col + dirs[i + 1];
            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) {
                continue;
            }
            if (grid[nr][nc] == 0 || visited[nr][nc]) {
                continue;
            }
            max = Math.max(max, dfs(grid, visited, nr, nc));
        }
        visited[row][col] = false;
        return grid[row][col] + max;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 7},
                {2, 0, 6},
                {3, 4, 5},
                {0, 3, 0},
                {9, 0, 20}
        };
        System.out.println((new Problem1219()).getMaximumGold(grid));
    }
}
