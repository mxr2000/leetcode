package com.mxr.demo;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Problem1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()] && nums.length - i + stack.size() > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = nums[stack.pop()];
        }
        return result;
    }
}
