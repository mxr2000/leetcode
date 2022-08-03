package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem1514 {
    static class Edge {
        int to;
        double val;

        public Edge(int to, double val) {
            this.to = to;
            this.val = val;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Set<Edge>[] towards = new Set[n];
        double[] maxValues = new double[n];
        for (int i = 0; i < n; i++) {
            towards[i] = new HashSet<>();
            maxValues[i] = 0;
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            towards[e[0]].add(new Edge(e[1], succProb[i]));
            towards[e[1]].add(new Edge(e[0], succProb[i]));
        }
        maxValues[start] = 1;
        traverse(towards,maxValues, start, end);
        return maxValues[end];
    }

    void traverse(Set<Edge>[] towards, double[] maxValues, int cur, int dest) {
        if (maxValues[cur] < maxValues[dest]) {
            return;
        }
        for (Edge edge : towards[cur]) {
            if (maxValues[cur] * edge.val > maxValues[edge.to]) {
                maxValues[edge.to] = maxValues[cur] * edge.val;
                traverse(towards, maxValues, edge.to, dest);
            }
        }
    }
}
