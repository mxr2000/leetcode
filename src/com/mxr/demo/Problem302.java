package com.mxr.demo;

public class Problem302 {
    private int left, right, up, down;
    public int minArea(char[][] image, int x, int y) {
        left = right = y;
        up = down = x;
        dfs(image, x, y);
        return (right - left + 1) * (down - up + 1);
    }

    private void dfs(char[][] image, int x, int y) {
        int[] dirs = {0, 1, 0, -1, 0};
        left = Math.min(left, y);
        right = Math.max(right, y);
        up = Math.min(up, x);
        down = Math.max(down, x);
        image[x][y] = '2';
        for (int d = 0; d < 4; ++d) {
            int nx = x + dirs[d], ny = y + dirs[d + 1];
            if (nx < 0 || nx >= image.length || ny < 0 || ny >= image[0].length || image[nx][ny] != '1') {
                continue;
            }
            dfs(image, nx, ny);
        }
    }

    public static void main(String[] args) {
        char[][] image = {
                "11".toCharArray()
        };
        System.out.println((new Problem302()).minArea(image, 0, 1));
    }
}
