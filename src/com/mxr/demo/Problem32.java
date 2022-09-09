package com.mxr.demo;

public class Problem32 {
    public int longestValidParentheses(String s) {
        int n = s.length(), result = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                continue;
            }
            if (dp[i - 1] == 0) {
                dp[i] = s.charAt(i - 1) == '(' ? (2 + (i >= 2 ? dp[i - 2] : 0)) : 0;
            } else {
                int index = i - 1 - dp[i - 1];
                dp[i] = (index >= 0 && s.charAt(index) == '(') ? (2 + dp[i - 1] + (index > 0 ? dp[index - 1] : 0)) : 0;
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println((new Problem32()).longestValidParentheses(s));
    }
}
