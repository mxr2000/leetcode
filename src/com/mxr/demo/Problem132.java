package com.mxr.demo;

public class Problem132 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] palindromeDp = new boolean[n][n];
        int[] dp = new int[n];
        for (int end = 0; end < n; end++) {
            int min = end;
            for (int begin = 0; begin <= end; begin++) {
                if (s.charAt(begin) == s.charAt(end) && (end - begin <= 2 || palindromeDp[begin + 1][end - 1])) {
                    palindromeDp[begin][end] = true;
                    min = Math.min(min, begin == 0 ? 0 : (dp[begin - 1] + 1));
                }
            }
            dp[end] = min;
        }
        return dp[n - 1];
    }
}
