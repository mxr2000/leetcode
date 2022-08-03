package com.mxr.demo;

public class Problem746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) {
            return 0;
        }
        int[] costs = new int[cost.length + 1];
        costs[0] = costs[1] = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            costs[i] = Math.min(costs[i - 2] + cost[i - 2], costs[i - 1] + cost[i - 1]);
        }
        return costs[cost.length];
    }
}
