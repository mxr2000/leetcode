package com.mxr.demo;

import java.util.*;

public class Problem1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] results = new int[2][n];
        Set<Integer>[] redTowards = new Set[n];
        Set<Integer>[] blueTowards = new Set[n];

        for (int i = 0; i < n; i++) {
            results[0][i] = Integer.MAX_VALUE;
            results[1][i] = Integer.MAX_VALUE;
            redTowards[i] = new HashSet<>();
            blueTowards[i] = new HashSet<>();
        }
        for (int[] edge : redEdges) {
            redTowards[edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            redTowards[edge[0]].add(edge[1]);
        }
        Queue<int[]> currents = new LinkedList<>();
        currents.add(new int[]{0, 0});
        currents.add(new int[]{0, 1});
        while (!currents.isEmpty()) {
            int[] current = currents.poll();
            int index = current[0];
            int color = current[1];
            Set<Integer> towards = redTowards[index];
            if (color == 0) {
                towards = blueTowards[index];
            }
            for (int newIndex : towards) {
                if (results[1 - color][newIndex] == Integer.MAX_VALUE) {
                    results[1 - color][newIndex] = 1 + results[color][index];
                    currents.offer(new int[]{newIndex, 1 - color});
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int val = Math.min(results[0][i], results[1][i]);
            ans[i] = val == Integer.MAX_VALUE ? -1 : val;
        }

        return ans;
    }
}
