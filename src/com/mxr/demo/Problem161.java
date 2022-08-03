package com.mxr.demo;

public class Problem161 {
    public boolean isOneEditDistance(String s, String t) {
        return dfs(s.toCharArray(), t.toCharArray(), 0, 0, false);
    }

    private boolean dfs(char[] s1, char[] s2, int i1, int i2, boolean hasChanged) {
        if (i1 == s1.length && i2 == s2.length) {
            return hasChanged;
        }
        if (i1 == s1.length || i2 == s2.length) {
            return !hasChanged && (i1 == s1.length && i2 == s2.length - 1 || i1 == s1.length - 1);
        }
        if (s1[i1] == s2[i2]) {
            return dfs(s1, s2, i1 + 1, i2 + 1, hasChanged) || (!hasChanged &&
                    (s2.length == s1.length + 1 && dfs(s1, s2, i1, i2 + 1, true)) ||
                    (s2.length == s1.length - 1 && dfs(s1, s2, i1 + 1, i2, true))
            );
        } else {
            return !hasChanged && (
                    (s1.length == s2.length && dfs(s1, s2, i1 + 1, i2 + 1, true)) ||
                            (s2.length == s1.length - 1 && dfs(s1, s2, i1 + 1, i2, true)) ||
                            (s2.length == s1.length + 1 && dfs(s1, s2, i1, i2 + 1, true))
            );
        }
    }

    public static void main(String[] args) {
        System.out.println((new Problem161()).isOneEditDistance("a", ""));
    }
}
