package com.mxr.demo;

public class Problem1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, result = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = nums1[i] == nums2[j] ? (1 + dp[i + 1][j + 1]) : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 5, 1, 2, 5}, nums2 = {10, 5, 2, 1, 5, 2};
        System.out.println((new Problem1035()).maxUncrossedLines(nums1, nums2));
    }
}
