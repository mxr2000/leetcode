package com.mxr.demo;

public class Problem495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int from = timeSeries[0];
        for (int t : timeSeries) {
            if (from >= t + duration) {
                continue;
            } else if (from >= t) {
                result += (duration - (from - t));
            } else {
                result += duration;
            }
            from = t + duration;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] t = {1, 2};
        System.out.println((new Problem495()).findPoisonedDuration(t, 2));
    }
}
