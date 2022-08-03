package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer>[] neighbours = new Set[n];
        for (int i = 0; i < neighbours.length; i++) {
            neighbours[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            neighbours[edge[0]].add(edge[1]);
            neighbours[edge[1]].add(edge[0]);
        }
        return isValid(neighbours, new HashSet<>(), source, destination);
    }

    private boolean isValid(Set<Integer>[] neighbours, Set<Integer> visited, int cur, int dest) {
        if (cur == dest) {
            return true;
        }
        if (visited.contains(cur)) {
            return false;
        }
        visited.add(cur);
        for (int neighbour : neighbours[cur]) {
            if (isValid(neighbours, visited, neighbour, dest)) {
                return true;
            }
        }
        return false;
    }

}
