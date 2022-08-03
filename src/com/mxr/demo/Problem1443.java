package com.mxr.demo;

import java.util.*;

public class Problem1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> connected = new HashMap<>();
        for (int[] edge : edges) {
            if (!connected.containsKey(edge[0])) {
                connected.put(edge[0], new ArrayList<>());
            }
            if (!connected.containsKey(edge[1])) {
                connected.put(edge[1], new ArrayList<>());
            }
            connected.get(edge[0]).add(edge[1]);
            connected.get(edge[1]).add(edge[0]);
        }
        Map<Integer, Set<Integer>> descendents = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (!connected.containsKey(p)) {
                continue;
            }
            for (int c : connected.get(p)) {
                if (descendents.containsKey(c) && descendents.get(c).contains(p)) {
                    continue;
                }
                if (!descendents.containsKey(p)) {
                    descendents.put(p, new HashSet<>());
                }
                descendents.get(p).add(c);
                queue.add(c);
            }
        }
        int result = dfs(descendents, hasApple, 0);
        return result == 0 ? 0 : result - 2;
    }

    private int dfs(Map<Integer, Set<Integer>> descendents, List<Boolean> hasApple, int current) {
        int sum = 0;
        if (descendents.get(current) != null) {
            for (int d : descendents.get(current)) {
                sum += dfs(descendents, hasApple, d);
            }
        }
        if (sum != 0) {
            return sum + 2;
        } else if (hasApple.get(current)) {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 2}, {0, 3}, {1, 2}};
        List<Boolean> hasApple = List.of(false, true, false, false);
        System.out.println((new Problem1443()).minTime(7, edges, hasApple));
    }
}
