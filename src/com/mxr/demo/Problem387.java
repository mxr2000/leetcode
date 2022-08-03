package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (map.containsKey(ch) && map.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }
}
