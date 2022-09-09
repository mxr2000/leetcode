package com.mxr.demo;

public class Problem2110 {
    public long getDescentPeriods(int[] prices) {
        long result = 0;
        int n = prices.length, left = 0;
        for (int right = 0; right < n; ++right) {
            if (right > 0 && prices[right] != prices[right - 1] - 1) {
                left = right;
            }
            result += (right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 1, 4};
        System.out.println((new Problem2110()).getDescentPeriods(prices));
    }
}
