package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> directChildren = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            results.add(new ArrayList<>());
            directChildren.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            directChildren.get(e[0]).add(e[1]);
        }
        for (int i = 0; i < n; i++) {
            dfs(results, directChildren, i, i);
        }
        return results;
    }

    private void dfs(List<List<Integer>> results, List<List<Integer>> directChildren,int current, int x) {
        for (int child : directChildren.get(current)) {
            List<Integer> list = results.get(child);
            if (list.isEmpty() || list.get(list.size() - 1) != x) {
                list.add(x);
                dfs(results, directChildren, child, x);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        System.out.println((new Problem2192()).getAncestors(8, edges));
    }
}
