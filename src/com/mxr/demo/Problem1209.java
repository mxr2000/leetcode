package com.mxr.demo;

import java.util.Stack;

public class Problem1209 {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == (int) ch) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[] {(int) ch, 1});
            }
            if (stack.peek()[1] == k) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            char ch = (char) p[0];
            sb.insert(0, ("" + ch).repeat(p[1]));
        }
        return sb.toString();
    }
}
