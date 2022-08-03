package com.mxr.demo;

public class Problem122 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                total += prices[i] - prices[i - 1];
            }
        }
        return total;
    }
}
