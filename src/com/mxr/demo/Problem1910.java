package com.mxr.demo;

import java.util.Stack;

public class Problem1910 {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for (char ch : s.toCharArray()) {
            stack.push(ch);
            if (stack.size() < part.length()) {
                continue;
            }
            for (int j = part.length() - 1; j >= 0; --j) {
                if (stack.peek() == part.charAt(j)) {
                    temp.push(stack.pop());
                } else {
                    break;
                }
            }
            if (temp.size() != part.length()) {
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
            }
            temp.clear();
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "axxxxyyyyb", part = "xy";
        System.out.println((new Problem1910()).removeOccurrences(s, part));
    }
}
