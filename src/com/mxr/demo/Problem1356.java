package com.mxr.demo;

import java.util.PriorityQueue;

public class Problem1356 {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] results = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] == p2[1] ? p1[0] - p2[0] : p1[1] - p2[1]);
        for (int num : arr) {
            pq.add(new int[] {num, getCount(num)});
        }
        int index = 0;
        while (!pq.isEmpty()) {
            results[index++] = pq.poll()[0];
        }
        return results;
    }

    private int getCount(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 2;
            n /= 2;
        }
        return result;
    }
}
