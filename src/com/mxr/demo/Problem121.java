package com.mxr.demo;

public class Problem121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int value = prices[i];
            if (value < min) {
                min = value;
            } else if (value - min > maxProfit) {
                maxProfit = value - min;
            }

        }
        return maxProfit;
    }
}
