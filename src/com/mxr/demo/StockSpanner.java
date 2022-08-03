package com.mxr.demo;

import java.util.Stack;

public class StockSpanner {
    private final Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int result = 1;
        while (!stack.empty() && stack.peek()[0] <= price) {
            result += stack.pop()[1];
        }
        stack.add(new int[] {price, result});
        return result;
    }
}
