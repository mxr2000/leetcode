package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;

public class Problem2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n + 1];
        Arrays.sort(rides, Comparator.comparingInt(r -> r[0]));
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            while (j < rides.length && rides[j][0] == i) {
                dp[rides[j][1]] = Math.max(dp[rides[j][1]], dp[i] + rides[j][1] - rides[j][0] + rides[j][2]);
                ++j;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[][] rides = {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}};
        System.out.println((new Problem2008()).maxTaxiEarnings(20, rides));
    }
}
