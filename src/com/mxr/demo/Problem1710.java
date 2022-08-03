package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(b -> -b[1]));
        System.out.println(Arrays.deepToString(boxTypes));
        int amount = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int[] type = boxTypes[i];
            int cnt = Math.min(type[0], truckSize);
            truckSize -= cnt;
            amount += cnt * type[1];
        }
        return amount;
    }

    public static void main(String[] args) {
        int[][] types = {
                {1, 3},
                {2, 2},
                {3, 1}
        };
        System.out.println((new Problem1710()).maximumUnits(types, 4));
    }
}
