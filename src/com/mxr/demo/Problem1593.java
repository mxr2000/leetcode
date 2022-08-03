package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem1593 {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int from, Set<String> set) {
        if (from == s.length()) {
            return set.size();
        }
        int max = 0;
        for (int to = from + 1; to <= s.length(); ++to) {
            String sub = s.substring(from, to);
            if (set.contains(sub)) {
                continue;
            }
            set.add(sub);
            max = Math.max(max, backtrack(s, to, set));
            set.remove(sub);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println((new Problem1593()).maxUniqueSplit("ababccc"));
    }
}
