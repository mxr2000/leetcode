package com.mxr.demo;

import java.util.*;

public class Problem1976 {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] r : roads) {
            edges.get(r[0]).add(new int[] {r[1], r[2]});
            edges.get(r[1]).add(new int[] {r[0], r[2]});
        }
        int[] distances = new int[n];
        long[] paths = new long[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        paths[0] = 1;
        distances[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(info -> info[1]));
        pq.offer(new int[] {0, 0});
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            if (distances[info[0]] < info[1])
            for (int[] next : edges.get(info[0])) {
                if (distances[next[0]] > info[1] + next[1]) {
                    paths[next[0]] = paths[info[0]];
                    distances[next[0]] = info[1] + next[1];
                    pq.offer(new int[] {next[0], info[1] + next[1]});
                } else if (info[1] + next[1] == distances[next[0]]) {
                    paths[next[0]] += paths[info[0]];
                    paths[next[0]] %= 1_000_000_007;
                }
            }
        }
        return (int) paths[n - 1] % 1_000_000_007;
    }

    public static void main(String[] args) {
        int[][] roads = {
                {0, 1, 1},
                {1, 2, 4},
                {0, 4, 3},
                {3, 2 ,5},
                {3, 4, 1},
                {3, 0, 5},
                {1, 3, 1}
        };
        System.out.println((new Problem1976()).countPaths(5, roads));
    }
}
