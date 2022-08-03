package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem266 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int oddCnt = 0;
        for (char ch : s.toCharArray()) {
            int newCnt = map.getOrDefault(ch, 0) + 1;
            if (newCnt % 2 == 1) {
                ++oddCnt;
            } else {
                --oddCnt;
            }
            map.put(ch, newCnt);
        }
        return oddCnt < 2;
    }
}
