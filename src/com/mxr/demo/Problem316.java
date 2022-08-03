package com.mxr.demo;


import java.util.*;

public class Problem316 {
    public String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> lastSeen = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            lastSeen.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                continue;
            }
            set.add(ch);
            while (!stack.isEmpty() && stack.peek() >= ch) {
                if (lastSeen.get(stack.peek()) > i) {
                    char popped = stack.pop();
                    set.remove(popped);
                } else {
                    break;
                }
            }
            stack.push(ch);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Problem316()).removeDuplicateLetters("cbacdcbc"));
    }
}
