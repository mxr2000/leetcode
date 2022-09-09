package com.mxr.demo;

public class Problem10 {
    public boolean isMatch(String s, String p) {
        return backtrack(s, p, 0, 0);
    }

    private boolean backtrack(String s, String p, int sIndex, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (sIndex == s.length()) {
            return pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*' && backtrack(s, p, sIndex, pIndex + 2);
        }
        if (pIndex == p.length()) {
            return false;
        }
        char ch1 = s.charAt(sIndex), ch2 = p.charAt(pIndex);
        boolean firstMatch = ch1 == ch2 || ch2 == '.';
        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            return backtrack(s, p, sIndex, pIndex + 2) || (firstMatch && backtrack(s, p, sIndex + 1, pIndex));
        } else {
            return firstMatch && backtrack(s, p, sIndex + 1, pIndex + 1);
        }
    }
}
