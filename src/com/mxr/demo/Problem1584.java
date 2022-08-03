package com.mxr.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1584 {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
        int minCost = 0;
        pq.add(new int[]{0, 0});
        boolean[] added = new boolean[points.length];
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int cost = pair[0];
            int node = pair[1];

            if (added[node]) {
                continue;
            }
            minCost += cost;
            added[node] = true;
            for (int i = 0; i < points.length; i++) {
                if (added[i]) {
                    continue;
                }
                int distance = Math.abs(points[i][0] - points[node][0]) + Math.abs(points[i][1] - points[node][1]);
                pq.offer(new int[]{distance, i});
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] points = {
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
        };
        System.out.println((new Problem1584()).minCostConnectPoints(points));
    }
}
