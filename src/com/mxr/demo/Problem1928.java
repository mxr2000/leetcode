package com.mxr.demo;

import java.util.*;

public class Problem1928 {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        Map<Integer, List<int[]>> neighbours = new HashMap<>();
        for (int[] e : edges) {
            if (!neighbours.containsKey(e[0])) {
                neighbours.put(e[0], new LinkedList<>());
            }
            if (!neighbours.containsKey(e[1])) {
                neighbours.put(e[1], new LinkedList<>());
            }
            neighbours.get(e[0]).add(new int[]{e[1], e[2]});
            neighbours.get(e[1]).add(new int[]{e[0], e[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(info -> info[1]));
        pq.offer(new int[]{0, passingFees[0], 0});

        int[] minTime = new int[passingFees.length];
        Arrays.fill(minTime, Integer.MAX_VALUE);


        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            if (info[2] >= minTime[info[0]]) {
                continue;
            }
            minTime[info[0]] = info[2];
            if (info[0] == passingFees.length - 1) {
                return info[1];
            }

            for (int[] n : neighbours.get(info[0])) {
                int time = info[2] + n[1];
                int cost = info[1] + passingFees[n[0]];
                if (time > maxTime) {
                    continue;
                } else if (time > minTime[n[0]]) {
                    continue;
                }
                pq.offer(new int[] {n[0], cost, time});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
        int[] passingFees = {5, 1, 2, 20, 20, 3};
        int maxTime = 30;
        System.out.println((new Problem1928()).minCost(maxTime, edges, passingFees));
    }
}
