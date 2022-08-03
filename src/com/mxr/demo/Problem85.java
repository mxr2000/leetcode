package com.mxr.demo;

import java.util.Arrays;

public class Problem85 {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int n = matrix[0].length, m = matrix.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        for (char[] row : matrix) {
            int rB = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (row[j] == '1') {
                    right[j] = Math.min(right[j], rB);
                } else {
                    right[j] = n;
                    rB = j - 1;
                }
            }

            int lB = 0;
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') {
                    left[j] = Math.max(left[j], lB);
                    ++height[j];
                    max = Math.max(max, height[j] * (right[j] - left[j] + 1));
                } else {
                    left[j] = -1;
                    lB = j + 1;
                    height[j] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                "10100".toCharArray(),
                "10111".toCharArray(),
                "11111".toCharArray(),
                "10010".toCharArray()
        };
        System.out.println((new Problem85()).maximalRectangle(matrix));
    }
}
