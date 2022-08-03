package com.mxr.demo;

import java.util.*;

public class Problem846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> counts = new HashMap<>();
        for (int h : hand) {
            counts.put(h, counts.getOrDefault(h, 0) + 1);
        }
        Deque<int[]> deque = new LinkedList<>();
        counts.keySet().stream().sorted().map(k -> new int[] {k, counts.get(k)}).forEach(deque::offerFirst);
        int[][] pairs = new int[groupSize][2];
        for (int i = 0; i < n / groupSize; i++) {
            for (int j = 0; j < groupSize; j++) {
                pairs[j] = deque.pollLast();
                if (pairs[j] == null || pairs[j][1] == 0) {
                    return false;
                }
                if (j > 0 && pairs[j - 1][0] + 1 != pairs[j][0]) {
                    return false;
                }
            }
            for (int j = groupSize - 1; j >= 0; j--) {
                --pairs[j][1];
                if (pairs[j][1] > 0) {
                    deque.offerLast(pairs[j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1, 1, 2, 2, 3, 3};
        System.out.println((new Problem846()).isNStraightHand(hand, 3));
    }
}
