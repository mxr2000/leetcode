package com.mxr.demo;

import java.util.*;

public class Problem802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, Set<Integer>> reverseGraph = buildReverseGraph(graph);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            int[] towards = graph[i];
            if (towards.length == 0) {
                set.add(i);
            }
        }
        boolean goon = true;
        while (goon) {
            goon = false;
            List<Integer> newNodes = new ArrayList<>();
            for (int index : set) {
                if (reverseGraph.get(index) != null) {
                    for (int from : reverseGraph.get(index)) {
                        if (!set.contains(from) && isSafe(graph[from], set)) {
                            newNodes.add(from);
                            goon = true;
                        }
                    }
                }
            }
            set.addAll(newNodes);
        }

        return set.stream().sorted().toList();
    }

    private boolean isSafe(int[] towards, Set<Integer> set) {
        for (int toward : towards) {
            if (!set.contains(toward)) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, Set<Integer>> buildReverseGraph(int[][] graph) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            int[] towards = graph[i];
            for (int toward : towards) {
                if (!map.containsKey(toward)) {
                    map.put(toward, new HashSet<>());
                }
                map.get(toward).add(i);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 3, 4},
                {1, 2},
                {3, 4},
                {0, 4},
                {}
        };
        System.out.println((new Problem802()).eventualSafeNodes(graph));
    }
}
