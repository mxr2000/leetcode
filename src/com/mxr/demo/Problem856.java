package com.mxr.demo;

import java.util.Stack;

public class Problem856 {
    public int scoreOfParentheses(String s) {
        Stack<Object> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return -1;
                }

                if (stack.peek() instanceof Character && (Character) stack.peek() == '(') {
                    stack.pop();
                    int num = 1;
                    while (!stack.isEmpty() && (stack.peek() instanceof Integer )) {
                        num += (Integer) stack.pop();
                    }
                    stack.push(num);
                } else if (stack.peek() instanceof Integer) {
                    int sum = 0;
                    while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                        sum += (Integer) stack.pop();
                    }
                    stack.pop();
                    stack.push(sum * 2);
                }
            }
            int num = 0;
            while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                num += (Integer) stack.pop();
            }
            if (num != 0) {
                stack.push(num);
            }
        }
        return (Integer) stack.pop();
    }

    public static void main(String[] args) {
        System.out.println((new Problem856()).scoreOfParentheses("()(())"));
    }
}
