package com.mxr.demo;

import java.util.Stack;

public class Problem1717 {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> s1 = new Stack<>(), s2 = new Stack<>();
        int result = 0;
        int max = Math.max(x, y), min = Math.min(x, y);
        char first = x > y ? 'a' : 'b', second = x > y ? 'b' : 'a';
        for (char ch : s.toCharArray()) {
            if (!s1.isEmpty() && s1.peek() == first && ch == second) {
                s1.pop();
                result += max;
            } else {
                s1.push(ch);
            }
        }
        while (!s1.isEmpty()) {
            char ch = s1.pop();
            if (!s2.isEmpty() && s2.peek() == first && ch == second) {
                s2.pop();
                result += min;
            } else {
                s2.push(ch);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        System.out.println((new Problem1717()).maximumGain(s, 4, 5));
    }
}
