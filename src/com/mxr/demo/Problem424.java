package com.mxr.demo;

public class Problem424 {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] counts = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < n; end++) {
            maxCount = Math.max(maxCount, ++counts[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                --counts[s.charAt(start) - 'A'];
                ++start;
                maxCount = 0;
                for (int i = 0; i < 26; i++) {
                    maxCount = Math.max(maxCount, counts[i]);
                }
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
