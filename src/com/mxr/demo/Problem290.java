package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem290 {
    public boolean wordPattern(String pattern, String s) {
        String[] parts = s.split(" ");
        if (parts.length != pattern.length()) {
            return false;
        }
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String key = pattern.substring(i, i + 1);
            if (!map.containsKey(key)) {
                if (map.containsValue(parts[i])) {
                    return false;
                }
                map.put(key, parts[i]);
            } else {
                if (!map.get(key).equals(parts[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "dog cat cat fish";
        String pattern = "abba";
        System.out.println((new Problem290()).wordPattern(pattern, s));
    }
}
