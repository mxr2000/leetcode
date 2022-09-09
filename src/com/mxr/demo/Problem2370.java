package com.mxr.demo;

public class Problem2370 {
    public int longestIdealString(String s, int k) {
        int n = s.length(), result = 0;
        int[] dp = new int[26];
        for (char ch : s.toCharArray()) {
            int c = ch - 'a';
            for (int i = Math.max(0, c - k); i <= Math.min(25, c + k); i++) {
                dp[c] = Math.max(dp[c], dp[i]);
            }
            result = Math.max(result, ++dp[c]);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "acfgbd";
        int k = 2;
        System.out.println((new Problem2370()).longestIdealString(s, k));
    }
}
