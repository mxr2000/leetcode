package com.mxr.demo;

import java.util.Arrays;
import java.util.Stack;

public class Problem84 {
    public int largestRectangleArea(int[] heights) {
        int[] rightIndexes = new int[heights.length];
        int[] leftIndexes = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(leftIndexes, -1);
        Arrays.fill(rightIndexes, heights.length);
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int index = stack.pop();
                    rightIndexes[index] = i;
                }
                stack.push(i);
            }
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int index = stack.pop();
                    leftIndexes[index] = i;
                }
                stack.push(i);
            }
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (rightIndexes[i] - leftIndexes[i] - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {2, 4};
        System.out.println((new Problem84()).largestRectangleArea(heights));
    }
}
