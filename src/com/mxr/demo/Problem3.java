package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        int from = 0, result = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= from) {
                result = Math.max(result, i - from);
                from = lastSeen.get(ch) + 1;
            }
            lastSeen.put(ch, i);
        }
        return Math.max(result, s.length() - from);
    }

    public static void main(String[] args) {
        System.out.println((new Problem3()).lengthOfLongestSubstring("bbbbb"));
    }
}
