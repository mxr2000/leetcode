package com.mxr.demo;

public class Problem1582 {
    public int numSpecial(int[][] mat) {
        int cnt = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && dye(mat, i, j)) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    private boolean dye(int[][] mat, int x, int y) {
        boolean result = true;
        mat[x][y] = 2;
        for (int j = 0; j < mat[0].length; j++) {
            if (j == y) {
                continue;
            }
            if (mat[x][j] == 1) {
                result = false;
                dye(mat, x, j);
            } else {
                mat[x][j] = 2;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (i == x) {
                continue;
            }
            if (mat[i][y] == 1) {
                result = false;
                dye(mat, i, y);
            } else {
                mat[i][y] = 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println((new Problem1582()).numSpecial(mat));
    }
}
