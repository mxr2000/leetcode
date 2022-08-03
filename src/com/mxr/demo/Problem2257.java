package com.mxr.demo;

public class Problem2257 {
    private final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        fillIn(grid, guards);
        fillIn(grid, walls);

        int cnt = m * n - guards.length - walls.length;
        for (int[] c : guards) {
            for (int[] d : directions) {
                int index = 1;
                while (true) {
                    int[] coord = new int[] {c[0] + index * d[0], c[1] + index * d[1]};
                    if (!checkPositionValid(coord, m, n) || grid[coord[0]][coord[1]] == 1) {
                        break;
                    } else {
                        index++;
                        if (grid[coord[0]][coord[1]] == 0) {
                            grid[coord[0]][coord[1]] = 2;
                            cnt--;
                        }
                    }
                }
            }
        }

        return cnt;
    }

    private void fillIn(int[][] grid, int[][] items) {
        for (int[] c : items) {
            grid[c[0]][c[1]] = 1;
        }
    }

    private boolean checkPositionValid(int[] c, int m, int n) {
        return c[0] >= 0 && c[0] < m && c[1] >= 0 && c[1] < n;
    }

    public static void main(String[] args) {
        int[][] guards = {
                {0, 0},
                {1, 1},
                {2, 3}
        };
        int[][] walls = {
                {0, 1},
                {2, 2},
                {1, 4}
        };
        System.out.println((new Problem2257()).countUnguarded(4, 6, guards, walls));
    }
}
