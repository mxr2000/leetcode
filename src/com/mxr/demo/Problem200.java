package com.mxr.demo;

public class Problem200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] map = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                map[i][j] = grid[i][j] == '1' ? 0 : -1;
            }
        }
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int color = map[i][j];
                if (color == -1) {
                    continue;
                } else if (color == 0) {
                    dye(map, ++cnt, i, j);
                }
            }
        }
        return cnt;
    }
    void dye(int[][] map, int color, int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return;
        }
        if (map[x][y] == -1 || map[x][y] == color) {
            return;
        }
        map[x][y] = color;
        dye(map, color, x - 1, y);
        dye(map, color, x +1, y);
        dye(map, color, x, y - 1);
        dye(map, color, x, y + 1);
    }
}
