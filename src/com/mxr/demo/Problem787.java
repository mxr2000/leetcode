package com.mxr.demo;

import java.util.*;

public class Problem787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> neighbours = new HashMap<>();
        int[] results = new int[n];
        Arrays.fill(results, Integer.MAX_VALUE);
        for (int[] flight : flights) {
            if (!neighbours.containsKey(flight[0])) {
                neighbours.put(flight[0], new HashMap<>());
            }
            neighbours.get(flight[0]).put(flight[1], flight[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(info -> -info[1]));
        pq.add(new int[]{src, 0, k + 1});
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            if (info[2] < 0) {
                continue;
            }
            if (info[1] >= results[info[0]]) {
                continue;
            }
            results[info[0]] = info[1];
            if (!neighbours.containsKey(info[0])) {
                continue;
            }
            for (int to : neighbours.get(info[0]).keySet()) {
                int cost = neighbours.get(info[0]).get(to);
                pq.offer(new int[] {to, info[1] + cost, info[2] - 1});
            }
        }
        return results[dst] == Integer.MAX_VALUE ? -1 : results[dst];
    }

    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        System.out.println((new Problem787()).findCheapestPrice(4, flights, 0, 3, 1));
    }
}
