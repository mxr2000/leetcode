package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem1062 {
    public int longestRepeatingSubstring(String s) {
        int result = 0;
        for (int l = 1; l <= s.length(); l++) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i <= s.length() - l; i++) {
                String sub = s.substring(i, i + l);
                int val = map.getOrDefault(sub, 0) + 1;
                map.put(sub, val);
                if (val > 1) {
                    result = Math.max(result, map.get(sub));
                }
            }
        }
        return result;
    }
}
