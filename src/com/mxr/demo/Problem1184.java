package com.mxr.demo;

import java.util.Arrays;

public class Problem1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int all = Arrays.stream(distance).sum();
        int sum = 0;
        for (int i = start; i != destination; i = (i + 1) % distance.length) {
            sum += distance[i];
        }
        return Math.min(sum, all - sum);
    }
}
