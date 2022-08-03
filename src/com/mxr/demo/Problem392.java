package com.mxr.demo;

public class Problem392 {
    public boolean isSubsequence(String s, String t) {
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i][j - 1] || (dp[i - 1][j - 1] && s.charAt(i - 1) == t.charAt(j - 1));
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        System.out.println((new Problem392()).isSubsequence("aaa", "abbaa"));
    }
}
