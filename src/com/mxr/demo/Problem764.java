package com.mxr.demo;

public class Problem764 {

    public static void main(String[] args) {
        int[][] mines = {
                {0, 0}
        };
        System.out.println((new Problem764()).orderOfLargestPlusSign(1, mines));
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        int[][] top = new int[n][n];
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] down = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }

        for (int[] pos : mines) {
            grid[pos[0]][pos[1]] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i == 0) {
                    top[i][j] = 0;
                } else {
                    top[i][j] = grid[i - 1][j] == 1 ? (1 + top[i - 1][j]) : 0;
                }
                if (j == 0) {
                    left[i][j] = 0;
                } else {
                    left[i][j] = grid[i][j - 1] == 1 ? (1 + left[i][j - 1]) : 0;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i == n - 1) {
                    down[i][j] = 0;
                } else {
                    down[i][j] = grid[i + 1][j] == 1 ? (1 + down[i + 1][j]) : 0;
                }
                if (j == n - 1) {
                    right[i][j] = 0;
                } else {
                    right[i][j] = grid[i][j + 1] == 1 ? (1 + right[i][j + 1]) : 0;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                max = Math.max(max, 1 + Math.min(top[i][j], Math.min(down[i][j], Math.min(left[i][j], right[i][j]))));
            }
        }

        return max;
    }
}
