package com.mxr.demo;

public class Problem1871 {
    // 0 1 0 0 0
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        int pre = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i >= minJump && dp[i - minJump]) {
                ++pre;
            }
            if (i > maxJump && dp[i - maxJump - 1]) {
                --pre;
            }
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }

        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println((new Problem1871()).canReach("01101110", 2, 3));
    }
}
