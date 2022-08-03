package com.mxr.demo;

import java.util.*;

public class Problem76 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> dict = new HashMap<>();
        for (char ch : t.toCharArray()) {
            dict.put(ch, dict.getOrDefault(ch, 0) + 1);
        }
        int required = dict.size();
        int complete = 0;
        int[] result = {-1, 0, 0};
        int left = 0, right = 0;
        Map<Character, Integer> currentMap = new HashMap<>();
        for (char ch : dict.keySet()) {
            currentMap.put(ch, 0);
        }
        for (; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (!dict.containsKey(ch)) {
                continue;
            }
            currentMap.put(ch, currentMap.get(ch) + 1);
            if ((int) currentMap.get(ch) == dict.get(ch)) {
                ++complete;
            }
            if (complete == required) {
                while (left <= right && complete == required) {
                    if (result[0] == -1 || right - left + 1 < result[0]) {
                        result = new int[] {
                                right - left + 1,
                                left,
                                right
                        };
                    }

                    char first = s.charAt(left);
                    if (dict.containsKey(first)) {
                        currentMap.put(first, currentMap.get(first) - 1);
                        if (currentMap.get(first) == dict.get(first) - 1) {
                            --complete;
                        }
                    }
                    ++left;
                }

            }

        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }

    public static void main(String[] args) {
        System.out.println((new Problem76()).minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
