package com.mxr.demo;

public class Problem211 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (dp[i][j] != 1) {
                    continue;
                }
                dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
            }
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dp[i][j] * dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char [][] matrix = {
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println((new Problem211()).maximalSquare(matrix));
    }
}
