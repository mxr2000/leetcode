package com.mxr.demo;

public class Problem72 {
    private static final int MAX = 501;

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][n] = m - i;
        }
        for (int j = 0; j < n; j++) {
            dp[m][j] = n - j;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int val;
                if (word1.charAt(i) == word2.charAt(j)) {
                    val = dp[i + 1][j + 1];
                } else {
                    val = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                }
                dp[i][j] = val;
            }
        }
        return dp[0][0];
    }

    private int backtrack(String w1, String w2, int i1, int i2) {
        if (i1 == w1.length() && i2 == w2.length()) {
            return 0;
        }
        if (i2 == w2.length()) {
            return w1.length() - i1;
        }
        if (i1 == w1.length()) {
            return w2.length() - i2;
        }
        if (w1.charAt(i1) == w2.charAt(i2)) {
            return backtrack(w1, w2, i1 + 1, i2 + 1);
        }
        return 1 + Math.min(backtrack(w1, w2, i1 + 1, i2), Math.min(backtrack(w1, w2, i1, i2 + 1), backtrack(w1, w2, i1 +1, i2 + 1)));
    }

    public static void main(String[] args) {
        String w1 = "intention";
        String w2 = "execution";
        System.out.println((new Problem72()).minDistance(w1, w2));
    }
}
