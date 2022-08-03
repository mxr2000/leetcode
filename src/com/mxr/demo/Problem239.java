package com.mxr.demo;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Problem239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i >= k && deque.peekLast()[1] < i - k + 1) {
                deque.pollLast();
            }
            int num = nums[i];
            while (!deque.isEmpty() && num >= deque.peekFirst()[0]) {
                deque.pollFirst();
            }
            deque.offerFirst(new int[] {num, i});
            if (i >= k - 1) {
                result[i - k + 1] = deque.peekLast()[0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1};
        System.out.println(Arrays.toString((new Problem239()).maxSlidingWindow(nums, 1)));
    }
}
