package com.mxr.demo;

public class Problem769 {
    public int maxChunksToSorted(int[] arr) {
        int[] maxes = new int[arr.length];
        maxes[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxes[i] = Math.max(maxes[i - 1], arr[i]);
        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxes[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }
}
