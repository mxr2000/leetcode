package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;

public class Problem1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int result = 0;
        int base = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                deque.offerFirst(i);
            }
            if (deque.size() > k) {
                while (nums[++base] % 2 == 0);
                deque.pollLast();
            }
            if (deque.size() == k) {
                result += (deque.peekLast() - base);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        System.out.println((new Problem1248()).numberOfSubarrays(nums, 2));
    }
}
