package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] >= newInterval[0]) {
                interval[1] = Math.max(interval[1], newInterval[1]);
            }
            result.add(interval);
        }
        return null;
    }
}
