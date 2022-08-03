package com.mxr.demo;

public class Problem1267 {
    public int countServers(int[][] grid) {
        int[] rowCounts = new int[grid.length];
        int[] columnCounts = new int[grid[0].length];
        int result = 0;
        for (int i = 0; i < rowCounts.length; i++) {
            for (int j = 0; j < columnCounts.length; j++) {
                if (grid[i][j] == 1) {
                    rowCounts[i]++;
                    columnCounts[j]++;
                }
            }
        }
        for (int i = 0; i < rowCounts.length; i++) {
            for (int j = 0; j < columnCounts.length; j++) {
                if (grid[i][j] == 1 && (rowCounts[i] > 1 || columnCounts[j] > 1)) {
                    result++;
                }
            }
        }
        return result;
    }
}
