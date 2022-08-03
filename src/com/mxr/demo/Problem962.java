package com.mxr.demo;

import java.util.Stack;

public class Problem962 {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.empty() || nums[stack.peek()] >= nums[i]) {
                stack.push(i);
            }
        }
        int result = 0;

        for (int i = nums.length - 1; i > result; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i]) {
                result = Math.max(result, i - stack.pop());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, 0, 8, 2, 1, 5};
        System.out.println((new Problem962()).maxWidthRamp(nums));
    }
}
