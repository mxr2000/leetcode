package com.mxr.demo;

public class Problem1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int[][] tops = new int[grid.length][grid[0].length];
        int[][] lefts = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                tops[i][j] = i == 0 ? 1 : (tops[i - 1][j] + 1);
                lefts[i][j] = j == 0 ? 1 : (lefts[i][j - 1] + 1);
            }
        }
        for (int length = Math.min(grid.length, grid[0].length); length > 0; length--) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (tops[i][j] < length || lefts[i][j] < length) {
                        continue;
                    }
                    if (lefts[i - length + 1][j] < length || tops[i][j - length + 1] < length) {
                        continue;
                    }
                    return length * length;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0}
        };
        System.out.println((new Problem1139()).largest1BorderedSquare(grid));
    }
}
