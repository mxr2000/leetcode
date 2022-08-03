package com.mxr.demo;

import java.util.*;
import java.util.stream.DoubleStream;

public class Problem288 {
    private final int[][] directions = {
            {1, 2},
            {2, 1},
            {1, -2},
            {2, -1},
            {-1, 2},
            {-2, 1},
            {-1, -2},
            {-2, -1}
    };
    private final List<int[]> directionList = Arrays.stream(directions).toList();

    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        dp[row][column] = 1;
        for (;k > 0; k--) {
            double[][] newDp = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int finalI = i;
                    int finalJ = j;
                    double[][] finalDp = dp;
                    directionList
                            .stream()
                            .map(d -> new int[]{finalI + d[0], finalJ + d[1]})
                            .filter(c -> c[0] >= 0 && c[0] < n && c[1] >= 0 && c[1] < n)
                            .forEach(c -> newDp[c[0]][c[1]] += finalDp[finalI][finalJ] / 8);
                }
            }
            dp = newDp;
        }
        return Arrays.stream(dp).flatMapToDouble(DoubleStream::of).sum();
    }

    public static void main(String[] args) {
        System.out.println((new Problem288()).knightProbability(3, 2, 0, 0));
    }

    /*private double dfs(Coordinate coordinate, int k) {
        if (dp.containsKey(coordinate)) {
            return dp.get(coordinate);
        }
        double value = directionList
                .stream()
                .map(d -> new Coordinate(coordinate.x + d[0], coordinate.y + d[1]))
                .map(c -> dfs(c, k - 1))
                .reduce((double) 0, Double::sum) / 8;
        dp.put(coordinate, value);
        return value;
    }*/
}
