package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem318 {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int bitMask = 0, bitNum = 0;
        for (String word : words) {
            bitMask = getBitRepresentation(word);
            map.put(bitMask, Math.max(map.getOrDefault(bitMask, 0), word.length()));
        }
        int result = 0;
        for (int x : map.keySet()) {
            for (int y : map.keySet()) {
                if ((x & y) == 0) {
                    result = Math.max(result, map.get(x) * map.get(y));
                }
            }
        }
        return result;
    }

    private int getBitRepresentation(String word) {
        int n = word.length();
        int result = 0;
        for (char ch : word.toCharArray()) {
            result = result | (1 << (ch - 'a'));
        }
        return result;
    }
}
