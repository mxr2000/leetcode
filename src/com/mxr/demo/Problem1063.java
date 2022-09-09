package com.mxr.demo;

import java.util.Stack;

public class Problem1063 {
    public int validSubarrays(int[] nums) {
        int result = 0, n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && num < stack.peek()) {
                stack.pop();
            }
            stack.push(num);
            result += stack.size();
        }
        return result;
    }
}
