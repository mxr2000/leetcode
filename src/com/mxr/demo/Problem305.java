package com.mxr.demo;

import java.util.LinkedList;
import java.util.List;

public class Problem305 {
    private final int[] dirs = {0, 1, 0, -1, 0};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        List<Integer> result = new LinkedList<>();
        int cnt = 0;
        for (int pi = 0; pi < positions.length; pi++) {
            if (pi == 6) {
                System.out.println();
            }
            int[] p = positions[pi];
            if (outOfBounds(m, n, p[0], p[1]) || grid[p[0]][p[1]] != 0) {
                result.add(cnt);
                continue;
            }
            int change = 1;
            grid[p[0]][p[1]] = pi + 1;
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dirs[i], ny = p[1] + dirs[i + 1];
                if (outOfBounds(m, n, nx, ny) || grid[nx][ny] == 0 || grid[nx][ny] == pi + 1) {
                    continue;
                }
                propagate(grid, m, n, nx, ny, grid[nx][ny], pi + 1);
                --change;
            }
            cnt += change;
            result.add(cnt);
        }

        return result;
    }

    private void propagate(int[][] grid, int m, int n, int x, int y, int oldColor, int newColor) {
        grid[x][y] = newColor;
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i], ny = y + dirs[i + 1];
            if (outOfBounds(m, n, nx, ny) || grid[nx][ny] != oldColor) {
                continue;
            }
            propagate(grid, m, n, nx, ny, oldColor, newColor);
        }
    }

    private boolean outOfBounds(int m, int n, int x, int y) {
        return x < 0 || x >= m || y < 0 || y >= n;
    }

    public static void main(String[] args) {
        int[][] positions = {
                {3, 0},
                {4, 1},
                {5, 1},
                {0, 2},
                {0, 1}
        };
        System.out.println((new Problem305()).numIslands2(7, 3, positions));
    }
}
