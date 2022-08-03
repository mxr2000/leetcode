package com.mxr.demo;

import java.util.Arrays;

public class Problem1727 {
    public int largestSubmatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                result = Math.max(result, matrix[i][j] * (matrix[0].length - j));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1}, {1, 1, 1}, {1, 0, 1}};
        System.out.println((new Problem1727()).largestSubmatrix(matrix));
    }
}
