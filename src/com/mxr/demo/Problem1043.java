package com.mxr.demo;

public class Problem1043 {
    private int[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int max = 0, val = 0;
            for (int j = i; j < Math.min(i + k, n); j++) {
                max = Math.max(max, arr[j]);
                val = Math.max(val, max * (j - i + 1) + (j == n - 1 ? 0 : dp[j + 1]));
            }
            dp[i] = val;
        }
        return dp[0];
    }

    private int backtrack(int[] arr, int k, int index) {
        if (memo[index] != -1) {
            return memo[index];
        }
        int result = 0, max = 0, n = arr.length;
        for (int i = index; i < Math.min(n, index + k); i++) {
            max = Math.max(max, arr[i]);
            result = Math.max(result, max * (i - index + 1) + (i == n - 1 ? 0 : backtrack(arr, k, i + 1)));
        }
        memo[index] = result;
        System.out.printf("%d -> %d%n", index, result);
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        System.out.println((new Problem1043()).maxSumAfterPartitioning(arr, 4));
    }
}
