package com.mxr.demo;

import java.util.*;

public class Problem340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        Map<Character, Integer> lastSeen = new HashMap<>();
        int from = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (lastSeen.containsKey(ch) || lastSeen.size() < k) {
                lastSeen.put(ch, i);
                continue;
            }
            char targetChar = 'a';
            int min = Integer.MAX_VALUE;
            for (char p : lastSeen.keySet()) {
                if (lastSeen.get(p) < min) {
                    min = lastSeen.get(p);
                    targetChar = p;
                }
            }
            result = Math.max(result, i - from);
            from = lastSeen.get(targetChar) + 1;
            lastSeen.remove(targetChar);
            lastSeen.put(ch, i);
        }
        return Math.max(result, s.length() - from);
    }

    public static void main(String[] args) {
        System.out.println((new Problem340()).lengthOfLongestSubstringKDistinct("a", 0));
    }
}
