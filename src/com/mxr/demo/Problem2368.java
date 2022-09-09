package com.mxr.demo;

import java.util.*;

public class Problem2368 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int result = 0;
        Map<Integer, Set<Integer>> neighboursMap = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        Set<Integer> restrictedNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int[] e : edges) {
            if (!visited.containsKey(e[0])) {
                visited.put(e[0], false);
                neighboursMap.put(e[0], new HashSet<>());
            }
            if (!visited.containsKey(e[1])) {
                visited.put(e[1], false);
                neighboursMap.put(e[1], new HashSet<>());
            }
            neighboursMap.get(e[0]).add(e[1]);
            neighboursMap.get(e[1]).add(e[0]);
        }
        for (int node : restricted) {
            restrictedNodes.add(node);
        }
        if (visited.containsKey(0) && !restrictedNodes.contains(0)) {
            queue.add(0);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited.put(cur, true);
            ++result;
            for (int next : neighboursMap.get(cur)) {
                if (restrictedNodes.contains(next) || visited.get(next)) {
                    continue;
                }
                queue.offer(next);
            }
        }

        return result;
    }
}
