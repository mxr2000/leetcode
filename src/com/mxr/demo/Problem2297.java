package com.mxr.demo;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Problem2297 {
    public long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        Stack<Integer> decreasingStack = new Stack<>();
        Stack<Integer> increasingStack = new Stack<>();
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            while (!decreasingStack.isEmpty() && nums[i] >= nums[decreasingStack.peek()]) {
                dp[i] = Math.min(dp[i], dp[decreasingStack.pop()] + costs[i]);
            }
            while (!increasingStack.isEmpty() && nums[i] < nums[increasingStack.peek()]) {
                dp[i] = Math.min(dp[i], dp[increasingStack.pop()] + costs[i]);
            }
            increasingStack.push(i);
            decreasingStack.push(i);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        int[] costs = {1, 1, 1};
        System.out.println((new Problem2297()).minCost(nums, costs));
    }
}
