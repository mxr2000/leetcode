package com.mxr.demo;

public class Problem934 {
    final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int shortestBridge(int[][] grid) {
        int initialRow = -1;
        int initialCol = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    initialRow = i;
                    initialCol = j;
                    break;
                }
            }
        }
        if (initialCol == -1) {
            return 0;
        }
        int val = 2;
        while (true) {
            if (expand(grid, initialRow, initialCol, val, val == 2)) {
                break;
            }
            ++val;
        }
        return val - 2;
    }

    boolean expand(int[][] grid, int row, int col, int val, boolean firstRound) {
        if (!firstRound && grid[row][col] == 1) {
            return true;
        }
        grid[row][col] = val;
        for (int[] d : directions) {
            int newX = d[0] + row;
            int newY = d[1] + col;
            if (!isInGrid(grid, newX, newY)) {
                continue;
            }
            if (grid[newX][newY] == val) {
                continue;
            }
            if (grid[newX][newY] == 0) {
                grid[newX][newY] = val;
            } else {
                if (expand(grid, newX, newY, val, firstRound)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isInGrid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        System.out.println((new Problem934()).shortestBridge(grid));
    }
}
