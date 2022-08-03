package com.mxr.demo;

public class Problem733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dye(image, image[sr][sc], newColor, sr, sc);
        return image;
    }
    void dye(int[][] map, int oldColor, int newColor, int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return;
        }
        if (map[x][y] != oldColor || map[x][y] == newColor) {
            return;
        }
        map[x][y] = newColor;
        dye(map, oldColor, newColor, x - 1, y);
        dye(map, oldColor, newColor, x +1, y);
        dye(map, oldColor, newColor, x, y - 1);
        dye(map, oldColor, newColor, x, y + 1);
    }
}
