package com.mxr.demo;

import java.util.Arrays;
import java.util.Stack;

public class Problem503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] results = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(results, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            while (!stack.empty() && nums[stack.peek() % nums.length] < nums[i % nums.length]) {
                results[stack.pop()] = nums[i % nums.length];
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString((new Problem503()).nextGreaterElements(nums)));
    }
}
