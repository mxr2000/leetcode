package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;

public class Problem435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (i1, i2) -> i1[1] != i2[1] ? i1[1] - i2[1] : i2[0] - i1[0]);
        int cnt = 1;
        int[] lastInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= lastInterval[1]) {
                ++cnt;
                lastInterval = interval;
            }
        }
        return intervals.length - cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        System.out.println((new Problem435()).eraseOverlapIntervals(intervals));
    }
}
