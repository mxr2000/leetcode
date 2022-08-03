package com.mxr.demo;

import java.util.Arrays;

public class Problem361 {
    public static void main(String[] args) {
        char[][] grid = {
                "0".toCharArray(),
                "0".toCharArray(),
                "0".toCharArray()
        };
        System.out.println((new Problem361()).maxKilledEnemies(grid));
    }

    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        int[][] horizontal = new int[m][n];
        int[][] vertical = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(horizontal[i], -1);
            Arrays.fill(vertical[i], -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0') {
                    continue;
                }
                if (horizontal[i][j] == -1) {
                    propagateHorizontal(grid, horizontal, i, j);
                }
                if (vertical[i][j] == -1) {
                    propagateVertical(grid, vertical, i, j);
                }
                result = Math.max(result, horizontal[i][j] + vertical[i][j]);
            }
        }
        return result;
    }

    private void propagateHorizontal(char[][] grid, int[][] horizontal, int x, int y) {
        int cnt = 0;
        int left = y, right = y;
        for (int j = y - 1; j >= 0 && grid[x][j] != 'W'; --j) {
            if (grid[x][j] == 'E') {
                ++cnt;
            }
            left = j;
        }
        for (int j = y + 1; j < grid[0].length && grid[x][j] != 'W'; ++j) {
            if (grid[x][j] == 'E') {
                ++cnt;
            }
            right = j;
        }
        for (int j = left; j <= right; ++j) {
            if (grid[x][j] == '0') {
                horizontal[x][j] = cnt;
            }
        }
    }

    private void propagateVertical(char[][] grid, int[][] vertical, int x, int y) {
        int cnt = 0;
        int up = x, down = x;
        for (int i = x - 1; i >= 0 && grid[i][y] != 'W'; --i) {
            if (grid[i][y] == 'E') {
                ++cnt;
            }
            up = i;
        }
        for (int i = x + 1; i < grid.length && grid[i][y] != 'W'; ++i) {
            if (grid[i][y] == 'E') {
                ++cnt;
            }
            down = i;
        }
        for (int i = up; i <= down; ++i) {
            if (grid[i][y] == '0') {
                vertical[i][y] = cnt;
            }
        }
    }
}
