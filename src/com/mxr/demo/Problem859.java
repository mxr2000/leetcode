package com.mxr.demo;

public class Problem859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int[] moreThanOnes = new int[26];
        boolean canSameSwap = false;
        char[] charsToSwap = null;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = goal.charAt(i);

            if (ch1 == ch2) {
                moreThanOnes[ch1 - 'a']++;
                if (!canSameSwap && moreThanOnes[ch1 - 'a'] >= 2) {
                    canSameSwap = true;
                }
                continue;
            }
            if (charsToSwap == null) {
                charsToSwap = new char[] {ch1, ch2};
                cnt++;
            } else if (cnt >= 2) {
                return false;
            } else {
                if (charsToSwap[0] == ch2 && charsToSwap[1] == ch1) {
                    cnt++;
                } else {
                    return false;
                }
            }
        }
        return (cnt == 0 && canSameSwap) || cnt == 2;
    }

    public static void main(String[] args) {
        System.out.println((new Problem859()).buddyStrings("abac", "abad"));
    }
}
