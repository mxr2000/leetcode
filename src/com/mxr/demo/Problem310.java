package com.mxr.demo;

import java.util.*;
import java.util.stream.Collectors;

public class Problem310 {
    static class Edge {
        int a, b;
        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return a == edge.a && b == edge.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Edge> set = new HashSet<>();
        int minHeight = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            set.add(new Edge(edges[i][0], edges[i][1]));
        }
        for (int i = 0; i < n; i++) {
            if (i == 3) {
                System.out.println();
            }
            int height = 1 + findMinHeightTrees(i, set);
            if (height == minHeight) {
                result.add(i);
            } else if (height < minHeight) {
                minHeight = height;
                result.clear();
                result.add(i);
            }
        }
        return result;
    }
    private int findMinHeightTrees(int n, Set<Edge> edges) {
        Set<Edge> edgesToRemove = edges
                .stream()
                .filter(e -> e.a == n || e.b == n)
                .collect(Collectors.toSet());
        if (edgesToRemove.size() == 0) {
            return 0;
        }
        edges.removeAll(edgesToRemove);
        int max = Integer.MIN_VALUE;
        for (Edge e : edgesToRemove) {
            int index = e.a == n ? e.b : e.a;
            max = Math.max(max, findMinHeightTrees(index, edges));
        }
        edges.addAll(edgesToRemove);
        return 1 + max;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 2},
                {0, 3},
                {3, 4},
                {4, 5}
        };
        System.out.println((new Problem310()).findMinHeightTrees(6, edges));
    }

    public List<Integer> solution(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        List<Set<Integer>> neighbours = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbours.add(new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n >= 2) {
            int index = leaves.poll();
            int newIndex = neighbours.get(index).iterator().next();
            neighbours.get(newIndex).remove(index);
            leaves.offer(newIndex);
            n--;
        }
        result.add(leaves.poll());
        result.add(leaves.poll());
        neighbours.get(leaves.poll());
        return null;
    }
}
