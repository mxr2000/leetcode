package com.mxr.demo;

public class Problem59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int x = 0, y = 0;
        int[] dirs = {0, 1, 0, -1, 0};
        int dir = 0;
        int current = 0;
        while (inBound(n, x, y) && matrix[x][y] == 0) {
            matrix[x][y] = ++current;
            int nx = x + dirs[dir];
            int ny = y + dirs[dir + 1];
            if (!inBound(n, nx, ny) || matrix[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dirs[dir];
                ny = y + dirs[dir + 1];
            }
            x = nx;
            y = ny;
        }
        return matrix;
    }

    private boolean inBound(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
