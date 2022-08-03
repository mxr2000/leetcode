package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;

public class Problem1696 {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[deque.peekFirst()] + nums[i];

            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {10, -5, -2, 4, 0, 3};
        System.out.println((new Problem1696()).maxResult(nums, 3));
    }
}
