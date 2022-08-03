package com.mxr.demo;

public class Problem463 {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int color = grid[i][j];
                if (color == 0) {
                    continue;
                } else if (color == 1) {
                    return dye(grid, i, j);
                }
            }
        }
        return 0;
    }

    int dye(int[][] map, int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return 1;
        }
        if (map[x][y] == 0) {
            return 1;
        } else if (map[x][y] == 2) {
            return 0;
        }
        map[x][y] = 2;
        int cnt = 0;
        cnt += dye(map, x - 1, y);
        cnt += dye(map, x +1, y);
        cnt += dye(map, x, y - 1);
        cnt += dye(map, x, y + 1);
        return cnt;
    }
}
