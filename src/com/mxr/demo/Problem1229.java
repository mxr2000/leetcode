package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(r -> r[0]));
        Arrays.sort(slots2, Comparator.comparingInt(r -> r[0]));
        int i1 = 0, i2 = 0;
        while (i1 < slots1.length && i2 < slots2.length) {
            if (slots1[i1][0] >= slots2[i2][1]) {
                ++i2;
            } else if (slots2[i2][0] >= slots1[i1][1]) {
                ++i1;
            } else {
                int r = Math.min(slots1[i1][1], slots2[i2][1]) - Math.max(slots1[i1][0], slots2[i2][0]);
                if (r >= duration) {
                    int from = Math.max(slots1[i1][0], slots2[i2][0]);
                    return List.of(from, from + duration);
                }
                if (slots1[i1][1] <= slots2[i2][1]) {
                    ++i1;
                } else {
                    ++i2;
                }
            }
        }
        return List.of();
    }

    public static void main(String[] args) {
        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}}, slots2 = {{0, 15}, {40, 50}};
        System.out.println((new Problem1229()).minAvailableDuration(slots1, slots2, 8));
    }
}
