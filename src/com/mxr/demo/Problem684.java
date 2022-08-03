package com.mxr.demo;

public class Problem684 {
    static class DisjointSet {
        private int[] parents;
        public DisjointSet(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }
        public int find(int n) {
            if (parents[n] == n) {
                return n;
            }
            return find(parents[n]);
        }
        public boolean union(int a, int b) {
            int i = find(a);
            int j = find(b);
            if (i == j) {
                return false;
            }
            parents[j] = i;
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        }
        DisjointSet set = new DisjointSet(n);
        int[] result = null;
        for (int[] edge : edges) {
            int i = edge[0] - 1;
            int j = edge[1] - 1;
            if (!set.union(i, j)) {
                result = edge;
            }
        }
        return result;
    }
}
