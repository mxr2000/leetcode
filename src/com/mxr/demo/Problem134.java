package com.mxr.demo;

public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0;
        int totalSurplus = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }
        return totalSurplus < 0 ? -1 : start;
    }
}
