package com.mxr.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem2316 {
    public long countPairs(int n, int[][] edges) {
        long sum = 0;
        long result = 0;
        Map<Integer, Set<Integer>> neighbours = new HashMap<>();
        for (int i = 0; i < n; i++) {
            neighbours.put(i, new HashSet<>());
        }
        for (int[] e : edges) {
            neighbours.get(e[0]).add(e[1]);
            neighbours.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int val = dfs(neighbours, visited, i);
            result += val * sum;
            sum += val;
        }
        return result;
    }

    private int dfs(Map<Integer, Set<Integer>> neighbours, boolean[] visited, int current) {
        visited[current] = true;
        int cnt = 1;
        for (int n : neighbours.get(current)) {
            if (!visited[n]) {
                cnt += dfs(neighbours, visited, n);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 2},
                {0, 5},
                {2, 4},
                {1, 6},
                {5, 4}
        };
        System.out.println((new Problem2316()).countPairs(7, edges));
    }
}
