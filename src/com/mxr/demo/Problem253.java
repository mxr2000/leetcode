package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        int result = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
            result = Math.max(result, pq.size());
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {0, 30},
                {5, 10},
                {15, 20}
        };
        System.out.println((new Problem253()).minMeetingRooms(intervals));
    }
}
