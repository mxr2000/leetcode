package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;

public class Problem452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int right = points[0][1];
        int cnt = 1;
        for (int i = 1; i < points.length; i++) {
            int[] p = points[i];
            if (p[0] > right) {
                ++cnt;
                right = p[1];
            } else {
                right = Math.min(right, p[1]);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] points = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        System.out.println((new Problem452()).findMinArrowShots(points));
    }
}
