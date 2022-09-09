package com.mxr.demo;

public class Problem2311 {
    public int longestSubsequence(String s, int k) {
        int result = 0, cost = 1, n = s.length();
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '0' || cost <= k) {
                k -= cost * (s.charAt(i) - '0');
                ++result;
            }
            if (cost <= k) {
                cost *= 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((new Problem2311()).longestSubsequence("1001010", 5));
    }
}
