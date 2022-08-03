package com.mxr.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }
        return (int) Arrays.stream(words).filter(w -> {
            for (char ch : w.toCharArray()) {
                if (!set.contains(ch)) {
                    return false;
                }
            }
            return true;
        }).count();
    }
}
