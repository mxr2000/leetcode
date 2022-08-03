package com.mxr.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j]) {
                    String word = s.substring(j, i);
                    if (dict.contains(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.substring(1, 2));
    }
}
