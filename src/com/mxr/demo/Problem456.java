package com.mxr.demo;

import java.util.Stack;

public class Problem456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Stack<int[]> stack = new Stack<>();
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
                stack.pop();
            }
            if (!stack.isEmpty() && nums[i] > stack.peek()[1]) {
                return true;
            }
            stack.push(new int[]{nums[i], min});
            min = Math.min(min, nums[i]);
        }
        return false;
    }
}
