package com.mxr.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2077 {
    public int numberOfPaths(int n, int[][] corridors) {
        Set<Integer>[] towards = new Set[n];
        for (int i = 0; i < n; i++) {
            towards[i] = new HashSet<>();
        }
        for (int[] edge: corridors) {
            towards[edge[0] - 1].add(edge[1] - 1);
        }

        int cnt = 0;
        for (int i = 0; i < 1; i++) {
            cnt += numOfPaths(towards, new HashSet<>(), i, i);
        }
        return cnt;
    }
    private int numOfPaths(Set<Integer>[] towards, Set<Integer> path, int from, int to) {
        if (from == to && !path.isEmpty()) {
            System.out.println(path);
            return 1;
        }
        if (path.contains(from)) {
            return 0;
        }
        path.add(from);
        int cnt = 0;
        for (int toward : towards[from]) {
            cnt += numOfPaths(towards, path, toward, to);
        }
        path.remove(from);
        return cnt;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {5, 2},
                {4, 1},
                {2, 4},
                {3, 1},
                {3, 4}
        };
        System.out.println((new Problem2077()).numberOfPaths(5, edges));
    }
}
