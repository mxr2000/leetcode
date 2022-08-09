package com.mxr.demo;

public class Problem1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int result = 0, cur = 0;
        for (int n : values) {
            result = Math.max(result, cur + n);
            cur = Math.max(cur, n) - 1;
        }
        return result;
    }
}
