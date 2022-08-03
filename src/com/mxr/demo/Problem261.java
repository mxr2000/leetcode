package com.mxr.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem261 {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 4},
                {1, 3}
        };
        System.out.println((new Problem261()).validTree(5, edges));
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            return n == 0 || n == 1;
        }
        Set<int[]> invalidEdges = new HashSet<>();
        Set<Integer> nodes = new HashSet<>();
        invalidEdges.addAll(Arrays.asList(edges));
        while (!invalidEdges.isEmpty()) {
            Set<int[]> newSet = new HashSet<>();
            for (int[] edge : invalidEdges) {
                if (nodes.isEmpty()) {
                    nodes.add(edge[0]);
                    nodes.add(edge[1]);
                } else if(nodes.contains(edge[0]) && nodes.contains(edge[1])) {
                    return false;
                } else if (nodes.contains(edge[0])) {
                    nodes.add(edge[1]);
                } else if (nodes.contains(edge[1])) {
                    nodes.add(edge[0]);
                } else {
                    newSet.add(edge);
                }
            }
            if (newSet.size() == invalidEdges.size()) {
                return false;
            }
            invalidEdges = newSet;
        }
        return nodes.size() == n;
    }
}
