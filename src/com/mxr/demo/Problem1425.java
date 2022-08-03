package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;

public class Problem1425 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int result = Integer.MIN_VALUE, n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (!deque.isEmpty()) {
                dp[i] += dp[deque.peekFirst()];
            }
            result = Math.max(result, dp[i]);
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && deque.peekFirst() + k <= i) {
                deque.pollFirst();
            }
            if (dp[i] > 0) {
                deque.offerLast(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, -2, -10, -5, 20};
        System.out.println((new Problem1425()).constrainedSubsetSum(nums, 2));
    }
}
