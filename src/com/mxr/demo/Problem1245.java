package com.mxr.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1245 {
    private int result = 0;

    public int treeDiameter(int[][] edges) {
        Map<Integer, Set<Integer>> neighbourMap = new HashMap<>();
        for (int[] e : edges) {
            if (!neighbourMap.containsKey(e[1])) {
                neighbourMap.put(e[1], new HashSet<>());
            }
            if (!neighbourMap.containsKey(e[0])) {
                neighbourMap.put(e[0], new HashSet<>());
            }
            neighbourMap.get(e[1]).add(e[0]);
            neighbourMap.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[neighbourMap.size()];
        dfs(neighbourMap, visited, 0);
        return result;
    }

    private int dfs(Map<Integer, Set<Integer>> neighbourMap, boolean[] visited, int current) {
        int longest = 0, secondLongest = 0;
        visited[current] = true;
        for (int c : neighbourMap.get(current)) {
            if (visited[c]) {
                continue;
            }
            int length = dfs(neighbourMap, visited, c);
            if (length > longest) {
                secondLongest = longest;
                longest = length;
            } else if (length == longest) {
                secondLongest = length;
            } else if (length > secondLongest) {
                secondLongest = length;
            }
        }
        int diameter = longest + secondLongest;
        result = Math.max(result, diameter);
        return longest + 1;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}};
        System.out.println((new Problem1245()).treeDiameter(edges));
    }
}
