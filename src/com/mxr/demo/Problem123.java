package com.mxr.demo;

public class Problem123 {
    public int maxProfit(int[] prices) {
        int n = prices.length, result = 0;
        int[][] dp = new int[n + 1][5];
        for (int s = 3; s >= 0; s--) {
            for (int i = n - 1; i >= 0; i--) {
                if (s == 0 || s == 2) {
                    dp[i][s] = dp[i + 1][s + 1] - prices[i];
                } else {
                    dp[i][s] = Math.max(dp[i + 1][s], dp[i + 1][s + 1] + prices[i]);
                }
                result = Math.max(result, dp[i][s]);
            }
        }
        return result;
    }

    private int backtrack(int[] prices, int index, int stage) {
        if (stage == 4 || index == prices.length) {
            return 0;
        } else if (stage == 0 || stage == 2) {
            return backtrack(prices, index + 1, stage + 1) - prices[index];
        } else if (stage == 1 || stage == 3) {
            return Math.max(backtrack(prices, index + 1, stage), backtrack(prices, index + 1, stage + 1) + prices[index]);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println((new Problem123()).maxProfit(prices));
    }
}
