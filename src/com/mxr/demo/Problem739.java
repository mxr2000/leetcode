package com.mxr.demo;

import java.util.Arrays;
import java.util.Stack;

public class Problem739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                results[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return results;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString((new Problem739()).dailyTemperatures(temperatures)));
    }
}
