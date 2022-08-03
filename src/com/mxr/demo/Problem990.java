package com.mxr.demo;

import java.util.*;

public class Problem990 {
    static class DisjointSet {
        private Map<Character, Character> parents;
        public DisjointSet(Set<Character> set) {
            parents = new HashMap<>();
            for (char ch : set) {
                parents.put(ch, ch);
            }
        }
        public char find(char ch) {
            if (parents.get(ch).equals(ch)) {
                return ch;
            }
            return find(parents.get(ch));
        }
        public boolean union(char a, char b) {
            char i = find(a);
            char j = find(b);
            if (i == j) {
                return false;
            }
            parents.put(j, i);
            return true;
        }
    }
    public boolean equationsPossible(String[] equations) {
        List<char[]> equals = new ArrayList<>();
        List<char[]> unequals = new ArrayList<>();
        Set<Character> characters = new HashSet<>();
        for (String equation : equations) {
            char ch1 = equation.charAt(0);
            char ch2 = equation.charAt(3);
            boolean isEqual = equation.charAt(1) == '=';
            if (isEqual) {
                equals.add(new char[]{ch1, ch2});
            } else {
                unequals.add(new char[]{ch1, ch2});
            }
            characters.add(ch1);
            characters.add(ch2);
        }
        DisjointSet set = new DisjointSet(characters);
        for (char[] pair : equals) {
            set.union(pair[0], pair[1]);
        }
        for (char[] pair : unequals) {
            if (set.find(pair[0]) == set.find(pair[1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] equations = {
                "a!=b",
                "b!=c",
                "c!=a"
        };
        System.out.println((new Problem990()).equationsPossible(equations));
    }
}
