package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;

public class Problem826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = difficulty[i];
            pairs[i][1] = profit[i];
        }
        Arrays.sort(pairs, Comparator.comparingInt(p -> p[0]));
        Arrays.sort(worker);
        int result = 0, maxProfit = 0;
        int index = 0;
        for (int w : worker) {
            while (index < n && w >= pairs[index][0]) {
                maxProfit = Math.max(maxProfit, pairs[index++][1]);
            }
            result += maxProfit;
        }
        return result;
    }
}
