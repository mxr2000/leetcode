package com.mxr.demo;

public class Problem1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && isSubIsland(grid1, grid2, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    boolean isSubIsland(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || x >= grid2.length || y < 0 || y >= grid2[0].length) {
            return true;
        }
        if (grid2[x][y] == 0 || grid2[x][y] == 2) {
            return true;
        }
        boolean result = true;
        if (grid2[x][y] == 1 && grid1[x][y] == 0) {
            result = false;
        }
        grid2[x][y] = 2;
        result &= isSubIsland(grid1, grid2, x - 1, y);
        result &= isSubIsland(grid1, grid2, x +1, y);
        result &= isSubIsland(grid1, grid2, x, y - 1);
        result &= isSubIsland(grid1, grid2, x, y + 1);
        return result;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}
        };

    }
}
