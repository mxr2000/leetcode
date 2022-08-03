package com.mxr.demo;

import java.util.Stack;

public class Problem402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        if (k >= num.length()) {
            return "";
        }
        for (char ch : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                --k;
            }
            stack.push(ch);
        }
        while (k > 0) {
            stack.pop();
            --k;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        while (builder.length() > 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Problem402()).removeKdigits("1432219", 3));
    }
}
