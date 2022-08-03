package com.mxr.demo;

import java.util.*;

public class Problem2093 {
    public int minimumCost(int n, int[][] highways, int discounts) {
        List<List<int[]>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] e : highways) {
            edges.get(e[0]).add(new int[]{e[1], e[2]});
            edges.get(e[1]).add(new int[]{e[0], e[2]});
        }
        int[][] costs = new int[n][discounts + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(info -> info[1]));
        for (int[] row : costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        pq.offer(new int[]{0, 0, discounts});
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            if (info[1] >= costs[info[0]][info[2]]) {
                continue;
            }
            costs[info[0]][info[2]] = info[1];
            if (info[0] == n - 1) {
                return info[1];
            }
            for (int[] neighbour : edges.get(info[0])) {
                if (info[1] + neighbour[1] < costs[neighbour[0]][info[2]]) {
                    pq.offer(new int[]{neighbour[0], info[1] + neighbour[1], info[2]});

                }
                if (info[2] > 0 && info[1] + neighbour[1] / 2 < costs[neighbour[0]][info[2] - 1]) {
                    pq.offer(new int[]{neighbour[0], info[1] + neighbour[1] / 2, info[2] - 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] highways = {{0, 1, 4}, {2, 1, 3}, {1, 4, 11}, {3, 2, 3}, {3, 4, 2}};
        System.out.println((new Problem2093()).minimumCost(5, highways, 1));
    }
}
