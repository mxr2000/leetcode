package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem1730 {
    public int getFood(char[][] grid) {
        int[] startP = null;
        int[] dirs = {0, 1, 0, -1, 0};
        for (int i = 0; i < grid.length; i++) {
            boolean found = false;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    startP = new int[] {i, j};
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (startP == null) {
            return -1;
        }
        List<int[]> frontier = new ArrayList<>();
        frontier.add(startP);
        int result = 0;
        while (!frontier.isEmpty()) {
            ++result;
            List<int[]> newFrontier = new ArrayList<>();
            for (int[] p : frontier) {
                if (grid[p[0]][p[1]] == '#') {
                    return result;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = p[0] + dirs[i];
                    int ny = p[1] + dirs[i + 1];
                    if (!isInGrid(grid, nx, ny)) {
                        continue;
                    }
                    if (grid[nx][ny] == '#') {
                        return result;
                    }
                    if (grid[nx][ny] != 'O') {
                        continue;
                    }
                    grid[nx][ny] = '1';
                    newFrontier.add(new int[] {nx, ny});
                }
            }
            frontier = newFrontier;
        }
        return -1;
    }

    private boolean isInGrid(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    public static void main(String[] args) {
        char[][] grid = {
                "XXXXXX".toCharArray(),
                "X*OOOX".toCharArray(),
                "XOO#OX".toCharArray(),
                "XXXXXX".toCharArray()
        };
        System.out.println((new Problem1730()).getFood(grid));
    }
}
