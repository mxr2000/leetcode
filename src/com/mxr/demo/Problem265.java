package com.mxr.demo;

public class Problem265 {
    public int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        int lastRowMinVal = Integer.MAX_VALUE, lastRowSecondVal = Integer.MAX_VALUE;
        int lastRowMinIndex = -1;
        for (int c = 0; c < k; ++c) {
            if (costs[0][c] <= lastRowMinVal) {
                lastRowSecondVal = lastRowMinVal;
                lastRowMinVal = costs[0][c];
                lastRowMinIndex = c;
            } else if (costs[0][c] <= lastRowSecondVal) {
                lastRowSecondVal = costs[0][c];
            }
        }
        for (int i = 1; i < n; ++i) {
            int rowMinIndex = -1;
            int minVal = Integer.MAX_VALUE, secondVal = Integer.MAX_VALUE;
            for (int c = 0; c < k; ++c) {
                int val = (c == lastRowMinIndex ? lastRowSecondVal : lastRowMinVal) + costs[i][c];
                if (val <= minVal) {
                    secondVal = minVal;
                    minVal = val;
                    rowMinIndex = c;
                } else if (val <= secondVal) {
                    secondVal = val;
                }
            }
            lastRowMinVal = minVal;
            lastRowSecondVal = secondVal;
            lastRowMinIndex = rowMinIndex;
        }
        return lastRowMinVal;
    }

    public static void main(String[] args) {
        int[][] costs = {
                {1, 3},
                {2, 4}
        };
        System.out.println((new Problem265()).minCostII(costs));
    }
}
