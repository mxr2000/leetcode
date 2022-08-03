package com.mxr.demo;

public class Problem395 {
    public int longestSubstring(String s, int k) {
        int maxUnique = getMaxUnique(s);
        char[] arr = s.toCharArray();
        int result = 0;
        for (int targetUnique = 1; targetUnique <= maxUnique; targetUnique++) {
            int[] counts = new int[26];
            int left = 0, right = 0;
            int unique = 0, fulfilled = 0;
        }

        return 0;
    }

    private int getMaxUnique(String s) {
        boolean[] map = new boolean[s.length()];
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (map[idx]) {
                continue;
            }
            map[idx] = true;
            ++cnt;
        }
        return cnt;
    }

}
