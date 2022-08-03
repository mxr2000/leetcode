package com.mxr.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
        for (int num : stones) {
            pq.offer(num);
        }
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if (first == second) {
                continue;
            }
            pq.offer(first - second);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
