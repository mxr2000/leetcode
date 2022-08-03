package com.mxr.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem1182 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> result = new LinkedList<>();
        int n = colors.length;
        int[][] distances = new int[n][3];
        for (int[] row : distances) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (colors[i] == j + 1) {
                    distances[i][j] = 0;
                } else if (i > 0) {
                    distances[i][j] = distances[i - 1][j] == -1 ? -1 : (distances[i - 1][j] + 1);
                }
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (distances[i][j] == -1) {
                    distances[i][j] = distances[i + 1][j] == -1 ? -1 : (distances[i + 1][j] + 1);
                } else {
                    distances[i][j] = Math.min(distances[i][j], distances[i + 1][j] == -1 ? -1 : (distances[i + 1][j] + 1));
                }
            }
        }
        for (int[] query : queries) {
            result.add(distances[query[0]][query[1] - 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] colors = {1, 1, 2, 1, 3, 2, 2, 3, 3};
        int[][] queries = {
                {1, 3},
                {2, 2},
                {6, 1}
        };
        System.out.println((new Problem1182()).shortestDistanceColor(colors, queries));
    }
}
