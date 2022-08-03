package com.mxr.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem394 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> buffer = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                while (true) {
                    char another = stack.pop();
                    if (another == '[') {
                        break;
                    } else {
                        buffer.add(0, another);
                    }
                }
                int num = getInteger(stack);
                for (int j = 0; j < num; j++) {
                    buffer.forEach(stack::push);
                }
                buffer.clear();
            } else {
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
    private int getInteger(Stack<Character> stack) {
        Stack<Character> numStack = new Stack<>();
        while (stack.size() > 0) {
            char ch = stack.peek();
            if (ch < '0' || ch > '9') {
                break;
            }
            numStack.add(ch);
            stack.pop();
        }
        int num = 0;
        while (!numStack.isEmpty()) {
            char ch = numStack.pop();
            num *= 10;
            num += (ch - '0');
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println((new Problem394()).decodeString("3[a]2[bc]"));
    }
}
