package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem417 {
    private final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> results = new ArrayList<>();
        int[][] counts = new int[heights.length][heights[0].length];
        List<int[]> frontier = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            frontier.add(new int[]{i, heights[0].length - 1});
        }
        for (int j = 0; j < heights[0].length - 1; j++) {
            frontier.add(new int[]{heights.length - 1, j});
        }
        bfs(heights, counts, frontier);

        frontier.clear();
        for (int i = 0; i < heights.length; i++) {
            frontier.add(new int[]{i, 0});
        }
        for (int j = 1; j < heights[0].length; j++) {
            frontier.add(new int[]{0, j});
        }
        bfs(heights, counts, frontier);
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (counts[i][j] == 2) {
                    results.add(List.of(i, j));
                }
            }
        }
        return results;
    }

    private void bfs(int[][] heights, int[][] counts, List<int[]> frontier) {
        boolean[][] dp = new boolean[heights.length][heights[0].length];
        for (int[] d : frontier) {
            dp[d[0]][d[1]] = true;
        }
        while (!frontier.isEmpty()) {
            List<int[]> newFrontier = new ArrayList<>();
            for (int[] c : frontier) {
                ++counts[c[0]][c[1]];
                for (int[] d : directions) {
                    int[] newC = new int[]{c[0] + d[0], c[1] + d[1]};
                    if (!isInBounds(heights, newC) || dp[newC[0]][newC[1]]) {
                        continue;
                    }
                    if (heights[newC[0]][newC[1]] >= heights[c[0]][c[1]]) {
                        dp[newC[0]][newC[1]] = true;
                        newFrontier.add(newC);
                    }
                }
            }
            frontier = newFrontier;
        }
    }

    private boolean isInBounds(int[][] heights, int[] c) {
        return c[0] >= 0 && c[0] < heights.length && c[1] >= 0 && c[1] < heights[0].length;
    }

    public static void main(String[] args) {
        /*int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};*/
        int[][] heights = {{2, 1}, {1, 2}};
        System.out.println((new Problem417()).pacificAtlantic(heights));
    }
}
