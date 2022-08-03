package com.mxr.demo;

public class Problem695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int newColor = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int color = grid[i][j];
                if (color == 0) {
                    continue;
                } else if (color == 1) {
                    max = Math.max(max, dye(grid, newColor, i, j));
                    newColor++;
                }
            }
        }
        return max;
    }

    int dye(int[][] map, int color, int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return 0;
        }
        if (map[x][y] == 0 || map[x][y] == color) {
            return 0;
        }
        map[x][y] = color;
        int cnt = 1;
        cnt += dye(map, color, x - 1, y);
        cnt += dye(map, color, x +1, y);
        cnt += dye(map, color, x, y - 1);
        cnt += dye(map, color, x, y + 1);
        return cnt;
    }
}
