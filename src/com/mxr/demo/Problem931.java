package com.mxr.demo;

import java.util.Arrays;

public class Problem931 {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        System.arraycopy(matrix[0], 0, dp[0], 0, matrix[0].length);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int leftUp = j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                int directUp = dp[i - 1][j];
                int rightUp = j == matrix[0].length - 1 ? Integer.MAX_VALUE : dp[i - 1][j + 1];
                dp[i][j] = matrix[i][j] + Math.min(leftUp, Math.min(directUp, rightUp));
            }
        }

        return Arrays.stream(dp[dp.length - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println((new Problem931()).minFallingPathSum(matrix));
    }
}
