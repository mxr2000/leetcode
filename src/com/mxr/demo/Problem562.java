package com.mxr.demo;

public class Problem562 {
    public int longestLine(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] top = new int[m][n], left = new int[m][n], topLeft = new int[m][n], topRight = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                top[i][j] = 1 + (i > 0 ? top[i - 1][j] : 0);
                left[i][j] = 1 + (j > 0 ? left[i][j - 1] : 0);
                topLeft[i][j] = 1 + ((i > 0 && j > 0) ? topLeft[i - 1][j - 1] : 0);
                result = Math.max(result, Math.max(top[i][j], Math.max(left[i][j], topLeft[i][j])));
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    continue;
                }
                topRight[i][j] = 1 + ((i > 0 && j < n - 1) ? topRight[i - 1][j + 1] : 0);
                result = Math.max(result, topRight[i][j]);
            }
        }
        return result;
    }
}
