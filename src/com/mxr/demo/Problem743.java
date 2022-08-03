package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem743 {
    static class Edge {
        int to;
        int val;

        public Edge(int to, int val) {
            this.to = to;
            this.val = val;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Edge>[] towards = new Set[n];
        int[] minimalValues = new int[n];
        for (int i = 0; i < n; i++) {
            towards[i] = new HashSet<>();
            minimalValues[i] = Integer.MAX_VALUE;
        }
        for (int[] time : times) {
            towards[time[0] - 1].add(new Edge(time[1] - 1, time[2]));
        }
        minimalValues[k - 1] = 0;
        traverse(towards, minimalValues, k - 1);
        int max = 0;
        for (int value : minimalValues) {
            if (value == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, value);
        }
        return max;
    }
    void traverse(Set<Edge>[] towards, int[] minimalValues, int cur) {
        for (Edge edge : towards[cur]) {
            if (minimalValues[cur] + edge.val < minimalValues[edge.to]) {
                minimalValues[edge.to] = minimalValues[cur] + edge.val;
                traverse(towards, minimalValues, edge.to);
            }
        }
    }
}
