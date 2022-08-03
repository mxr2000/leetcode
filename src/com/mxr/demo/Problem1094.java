package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips.length == 0) {
            return true;
        }
        Arrays.sort(trips, Comparator.comparingInt(t -> t[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
        for (int[] trip : trips) {
            while (!pq.isEmpty() && trip[1] >= pq.peek()[0]) {
                capacity += pq.poll()[1];
            }
            if (trip[0] > capacity) {
                return false;
            }
            pq.add(new int[]{trip[2], trip[0]});
            capacity -= trip[0];
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{8, 2, 3}, {4, 1, 3}, {1, 3, 6}, {8, 4, 6}, {4, 4, 8}};
        System.out.println((new Problem1094()).carPooling(trips, 12));
    }
}
