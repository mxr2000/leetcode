package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1353 {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, Comparator.comparingInt(e -> e[0]));
        int index = 0, result = 0;
        for (int d = 1; d <= 100000; d++) {
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            while (index < events.length && events[index][0] == d) {
                pq.offer(events[index++][1]);
            }
            if (!pq.isEmpty()) {
                ++result;
                pq.poll();
            }
        }
        return result;
    }
}
