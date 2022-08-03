package com.mxr.demo;

import java.util.*;

public class Problem1376 {
    int result = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> directChildren = new HashMap<>();
        for (int i = 0; i < n; i++) {
            directChildren.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int m = manager[i];
            if (m == -1) {
                continue;
            }
            directChildren.get(m).add(i);
        }
        dfs(directChildren, informTime, headID, 0);
        return result;
    }

    private void dfs(Map<Integer, List<Integer>> directChildren, int[] informTime, int current, int time) {
        if (directChildren.get(current).isEmpty()) {
            result = Math.max(result, time);
            return;
        }
        for (int ch : directChildren.get(current)) {
            dfs(directChildren, informTime, ch, time + informTime[current]);
        }
    }

    public static void main(String[] args) {
        int[] manager = {2, 2, -1, 2, 2, 2};
        int[] informTime = {0, 0, 1, 0, 0, 0};
        System.out.println((new Problem1376()).numOfMinutes(6, 2, manager, informTime));
    }
}
