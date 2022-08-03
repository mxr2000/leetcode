package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem1091 {
    int[][] directions = {
            {1, 1},
            {1, 0},
            {1, -1},
            {0, 1},
            {0, -1},
            {-1, 1},
            {-1, 0},
            {-1, -1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int result = 0;
        List<int[]> frontier = new ArrayList<>();
        if (grid[0][0] == 0) {
            frontier.add(new int[] {0, 0});
        }
        while (!frontier.isEmpty()) {
            ++result;
            List<int[]> newFrontier = new ArrayList<>();
            for (int[] p : frontier) {
                if (p[0] == grid.length - 1 && p[1] == grid[0].length - 1) {
                    return result;
                }
                for (int[] d : directions) {
                    int[] newP = new int[] {p[0] + d[0], p[1] + d[1]};
                    if (!isInGrid(grid, newP) || grid[newP[0]][newP[1]] != 0) {
                        continue;
                    }
                    grid[newP[0]][newP[1]] = 2;
                    newFrontier.add(newP);
                }
            }
            frontier = newFrontier;
        }
        return -1;
    }

    private boolean isInGrid(int[][] grid, int[] p) {
        return p[0] >= 0 && p[0] < grid.length && p[1] >= 0 && p[1] < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println((new Problem1091()).shortestPathBinaryMatrix(grid));
    }
}
