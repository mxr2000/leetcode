package com.mxr.demo;

public class Problem1578 {
    public int minCost(String colors, int[] neededTime) {
        int result = 0, maxCost = 0, sumCost = 0, n = colors.length();
        for (int i = 0; i < n; i++) {
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                result += sumCost - maxCost;
                sumCost = maxCost = 0;
            }
            sumCost += neededTime[i];
            maxCost = Math.max(maxCost, neededTime[i]);
        }
        result += sumCost - maxCost;
        return result;
    }

    public static void main(String[] args) {
        int[] times = {1, 2, 3, 4, 1};
        System.out.println((new Problem1578()).minCost("aabaa", times));
    }
}
