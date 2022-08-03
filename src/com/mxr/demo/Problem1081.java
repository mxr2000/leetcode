package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Problem1081 {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> another = new Stack<>();
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (!set.contains(ch)) {
                stack.push(ch);
                set.add(ch);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < ch) {
                another.push(stack.pop());
            }
            if (stack.peek() == ch) {
                stack.pop();
                while (!another.isEmpty()) {
                    stack.push(another.pop());
                }
                stack.push(ch);
            }

        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Problem1081()).smallestSubsequence("cbacdcbc"));
    }
}
