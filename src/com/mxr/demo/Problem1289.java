package com.mxr.demo;

import java.util.Arrays;

public class Problem1289 {
    public int minFallingPathSum(int[][] grid) {
        int firstMin = 0;
        int secondMin = 0;
        int pos = -1;
        for (int[] row : grid) {
            int newFirstMin = Integer.MAX_VALUE;
            int newSecondMin = Integer.MAX_VALUE;
            int newPos = -1;
            for (int j = 0; j < grid[0].length; j++) {
                int val = j != pos ? firstMin : secondMin;
                if (row[j] + val < newFirstMin) {
                    newSecondMin = newFirstMin;
                    newFirstMin = row[j] + val;
                    newPos = j;
                } else {
                    newSecondMin = Math.min(newSecondMin, row[j] + val);
                }
            }
            firstMin = newFirstMin;
            secondMin = newSecondMin;
            pos = newPos;
        }

        return firstMin;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {-73, 61, 43, -48, -36},
                {3, 30, 27, 57, 10},
                {96, -76, 84, 59, -15},
                {5, -49, 76, 31, -7},
                {97, 91, 61, -46, 67}
        };
        System.out.println((new Problem1289()).minFallingPathSum(matrix));
    }

}
