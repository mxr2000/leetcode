package com.mxr.demo;

public class Problem5 {
    public String longestPalindrome(String s) {
        String result = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int length = 1; length <= n; length++) {
            for (int from = 0; from < n - length + 1; from++) {
                int to = from + length - 1;
                dp[from][to] = s.charAt(from) == s.charAt(from + length - 1) && (length <= 2 || dp[from + 1][to - 1]);
                if (dp[from][to] && length > result.length()) {
                    result = s.substring(from, to + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((new Problem5()).longestPalindrome("cbbd"));
    }
}
