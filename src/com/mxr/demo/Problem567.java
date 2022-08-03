package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> target = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> cur = new HashMap<>();
        for (char ch : target.keySet()) {
            cur.put(ch, 0);
        }
        int from = 0;
        char[] arr = s2.toCharArray();
        for (int to = 0; to < s2.length(); to++) {
            char ch = arr[to];
            if (target.containsKey(ch)) {
                if (cur.get(ch) < target.get(ch)) {
                    cur.put(ch, cur.get(ch) + 1);
                } else {
                    while (arr[from] != ch) {
                        cur.put(arr[from], cur.get(arr[from]) - 1);
                        ++from;
                    }
                    ++from;
                    continue;
                }
            } else {
                from = to + 1;
                for (char c : cur.keySet()) {
                    cur.put(c, 0);
                }
                continue;
            }
            if (to - from + 1 > s1.length()) {
                cur.put(arr[from], cur.get(arr[from]) - 1);
                ++from;
            }
            if (to - from + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println((new Problem567()).checkInclusion("ky",
                "ainwkckifykxlribaypk"));
    }
}
