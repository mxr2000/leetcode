package com.mxr.demo;

public class Problem279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int cnt = i / (j * j);
                int remain = i - cnt * (j * j);
                min = Math.min(min, cnt + dp[remain]);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println((new Problem279()).numSquares(13));
    }
}
