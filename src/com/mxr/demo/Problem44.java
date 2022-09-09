package com.mxr.demo;

public class Problem44 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m) {
                    dp[i][j] = j == n || (p.charAt(j) == '*' && dp[i][j + 1]);
                } else if (j == n) {
                    dp[i][j] = false;
                } else {
                    if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if (p.charAt(j) == '*') {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }

    private boolean backtrack(String s, String p, int si, int pi) {
        if (si == s.length()) {
            return pi == p.length() || (p.charAt(pi) == '*' && backtrack(s, p, si, pi + 1));
        } else if (pi == p.length()) {
            return false;
        }
        if (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi)) {
            return backtrack(s, p, si + 1, pi + 1);
        } else if (p.charAt(pi) == '*') {
            return backtrack(s, p, si + 1, pi) || backtrack(s, p, si, pi + 1);
        }
        return false;
    }
}
