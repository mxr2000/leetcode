package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;

public class Problem1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> increasingDeque = new LinkedList<>();
        Deque<Integer> decreasingDeque = new LinkedList<>();
        int from = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!decreasingDeque.isEmpty() && nums[i] > nums[decreasingDeque.peekLast()]) {
                decreasingDeque.pollLast();
            }
            while (!increasingDeque.isEmpty() && nums[i] < nums[increasingDeque.peekLast()]) {
                increasingDeque.pollLast();
            }
            decreasingDeque.offerLast(i);
            increasingDeque.offerLast(i);

            while (nums[decreasingDeque.peekFirst()] - nums[increasingDeque.peekFirst()] > limit) {
                if (nums[decreasingDeque.peekFirst()] == nums[from]) {
                    decreasingDeque.pollFirst();
                }
                if (nums[increasingDeque.peekFirst()] == nums[from]) {
                    increasingDeque.pollFirst();
                }
                ++from;
            }
            result = Math.max(result, i - from + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 2, 4, 4, 2, 2};
        System.out.println((new Problem1438()).longestSubarray(nums, 0));
    }
}
