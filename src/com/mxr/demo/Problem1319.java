package com.mxr.demo;


import java.util.HashSet;
import java.util.Set;

public class Problem1319 {
    static class DisjointSet {
        private final int[] parents;
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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet disjointSet = new DisjointSet(n);
        int cable = 0;
        for (int[] con : connections) {
            if (!disjointSet.union(con[0], con[1])) {
                cable++;
            }
        }
        Set<Integer> groupRoots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            groupRoots.add(disjointSet.find(i));
        }
        int groupCnt = groupRoots.size();

        if (groupCnt > cable + 1) {
            return -1;
        }
        return groupCnt - 1;
    }

    public static void main(String[] args) {
        int[][] connections = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3}
        };
        System.out.println((new Problem1319()).makeConnected(6, connections));
    }
}
