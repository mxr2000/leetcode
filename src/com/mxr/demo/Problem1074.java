package com.mxr.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        int result = 0;
        for (int c1 = 0; c1 < matrix[0].length; c1++) {
            for (int c2 = c1 + 1; c2 <= matrix[0].length; c2++) {
                int sum = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int row = 0; row < matrix.length; row++) {
                    sum += (matrix[row][c2 - 1] - (c1 == 0 ? 0 :matrix[row][c1 - 1]));
                    if (map.containsKey(sum - target)) {
                        result += map.get(sum - target);
                    }
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        System.out.println((new Problem1074()).numSubmatrixSumTarget(matrix, 0));
    }
}
