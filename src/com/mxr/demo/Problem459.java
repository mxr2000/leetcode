package com.mxr.demo;

public class Problem459 {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 2; i <= s.length() / 2; i++) {
            if (check(s, s.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
    private boolean check(String s, String p) {
        if (p.length() < 2 || s.length() % p.length() != 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i += p.length()) {
            if (!s.substring(i, i + p.length()).equals(p)) {
                return false;
            }
        }
        return true;
    }
}
