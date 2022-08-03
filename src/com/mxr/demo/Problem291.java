package com.mxr.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem291 {
    public boolean wordPatternMatch(String pattern, String s) {
        return backtrack(s, pattern, 0, 0, new HashMap<>(), new HashSet<>());
    }

    private boolean backtrack(String s, String pattern, int i, int j, Map<Character, String> map, Set<String> set) {
        if (i == s.length() && j == pattern.length()) {
            return true;
        }
        if (i == s.length() || j == pattern.length()) {
            return false;
        }
        char p = pattern.charAt(j);
        if (map.containsKey(p)) {
            String mapped = map.get(p);
            if (!s.startsWith(mapped, i)) {
                return false;
            }
            return backtrack(s, pattern, i + mapped.length(), j + 1, map, set);
        }
        for (int k = i; k < s.length(); ++k) {
            String mapped = s.substring(i, k + 1);
            if (set.contains(mapped)) {
                continue;
            }
            map.put(p, mapped);
            set.add(mapped);
            if (backtrack(s, pattern, k + 1, j + 1, map, set)) {
                return true;
            }
            map.remove(p);
            set.remove(mapped);
        }
        return false;
    }
}
