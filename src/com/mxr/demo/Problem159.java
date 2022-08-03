package com.mxr.demo;


public class Problem159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Object[][] map = new Object[2][2];
        int from = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map[0][0] != null && ch == (Character) map[0][0]) {
                map[0][1] = i;
                continue;
            } else if (map[1][0] != null && ch == (Character) map[1][0]) {
                map[1][1] = i;
                continue;
            } else if (map[0][0] == null) {
                map[0][0] = ch;
                map[0][1] = i;
                continue;
            } else if (map[1][0] == null) {
                map[1][0] = ch;
                map[1][1] = i;
                continue;
            }
            int fi = (Integer) map[0][1];
            int si = (Integer) map[1][1];
            result = Math.max(result, i - from);
            if (fi < si) {
                from = fi + 1;
                map[0][0] = ch;
                map[0][1] = i;
            } else {
                from = si + 1;
                map[1][0] = ch;
                map[1][1] = i;
            }

        }
        return Math.max(result, s.length() - from);
    }

    public static void main(String[] args) {
        System.out.println((new Problem159()).lengthOfLongestSubstringTwoDistinct("abcabcabc"));
    }
}
