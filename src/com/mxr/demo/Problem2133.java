package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem2133 {
    public boolean checkValid(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (!check(matrix, matrix.length, i, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[][] matrix, int n, int row, int col) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = matrix[i][col];
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        set.clear();
        for (int i = 0; i < n; i++) {
            int num = matrix[row][i];
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return true;
    }
}
