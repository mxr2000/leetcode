package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len + 1][len + 1];
        dp[0][0] = true;
        List<List<String>> results = new ArrayList<>();
        dfs(results, s, 0, new ArrayList<>(), dp);
        return results;
    }

    private void dfs(List<List<String>> results, String s, int begin, List<String> currentList, boolean[][] dp) {
        if (begin >= s.length()) {
            results.add(new ArrayList<>(currentList));
        }
        for (int end = begin + 1; end <= s.length(); end++) {
            if (s.charAt(begin) == s.charAt(end - 1) && (end - begin <= 3 || dp[begin + 1][end - 1])) {
                dp[begin][end] = true;
                currentList.add(s.substring(begin, end));
                dfs(results, s, end, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    private void dfs2(List<List<String>> results, String s, int begin, List<String> currentList, boolean[][] dp) {
        if (begin >= s.length()) {
            results.add(new ArrayList<>(currentList));
        }
        for (int end = begin; end < s.length(); end++) {
            if (s.charAt(begin) == s.charAt(end) && (end - begin <= 2 || dp[begin + 1][end])) {
                dp[begin][end + 1] = true;
                currentList.add(s.substring(begin, end + 1));
                dfs2(results, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println((new Problem131()).partition("aab"));
    }
}
