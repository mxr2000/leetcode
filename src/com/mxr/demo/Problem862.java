package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;

public class Problem862 {
    public int shortestSubarray(int[] nums, int k) {
        int result = Integer.MAX_VALUE, n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        long[] prefixSum = new long[n + 1];
        deque.offerLast(0);
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] += nums[i] + prefixSum[i];
            while (!deque.isEmpty() && prefixSum[deque.peekLast()] >= prefixSum[i + 1]) {
                deque.pollLast();
            }
            deque.offerLast(i + 1);
            while (!deque.isEmpty() && prefixSum[i + 1] - prefixSum[deque.peekFirst()] >= k) {
                result = Math.min(result, i - deque.peekFirst() + 1);
                deque.pollFirst();
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println((new Problem862()).shortestSubarray(nums, 4));
    }
}
