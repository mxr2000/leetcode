package com.mxr.demo;

import java.util.Arrays;

public class Problem1340 {
    private int[] dp;

    public int maxJumps(int[] arr, int d) {
        dp = new int[arr.length];
        Arrays.fill(dp, 0);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] != 0) {
                continue;
            }
            max = Math.max(max, dfs(arr, i, d));
        }
        return max;
    }

    private int dfs(int[] arr, int index, int d) {
        if (dp[index] != 0) {
            return dp[index];
        }
        int max = 0, n = arr.length;
        for (int i = index - 1; i >= Math.max(0, index - d); i--) {
            if (arr[i] >= arr[index]) {
                break;
            }
            max = Math.max(max, dfs(arr, i, d));
        }
        for (int i = index + 1; i <= Math.min(n - 1, index + d); i++) {
            if (arr[i] >= arr[index]) {
                break;
            }
            max = Math.max(max, dfs(arr, i, d));
        }
        dp[index] = 1 + max;
        return dp[index];
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        System.out.println((new Problem1340()).maxJumps(arr, 2));
    }
}
