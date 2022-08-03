package com.mxr.demo;

import java.util.Arrays;

public class Problem1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int verticalMax = verticalCuts[0];
        for (int i = 0; i < verticalCuts.length - 1; i++) {
            verticalMax = Math.max(verticalMax, verticalCuts[i + 1] - verticalCuts[i]);
        }
        verticalMax = Math.max(verticalMax, w - verticalCuts[verticalCuts.length - 1]);

        int horizontalMax = horizontalCuts[0];
        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            horizontalMax = Math.max(horizontalMax, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        horizontalMax = Math.max(horizontalMax, h - horizontalCuts[horizontalCuts.length - 1]);

        return (int)((long)horizontalMax * verticalMax % mod);
    }

    public static void main(String[] args) {
        int[] horizontalCuts = {3,1};
        int[] verticalCuts = {1};
        System.out.println((new Problem1465()).maxArea(5, 4, horizontalCuts, verticalCuts));
    }
}
