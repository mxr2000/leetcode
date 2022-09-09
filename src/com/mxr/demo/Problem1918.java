package com.mxr.demo;

import java.util.PriorityQueue;

public class Problem1918 {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int n = nums.length, result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] prefixSums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = nums[i - 1] + prefixSums[i - 1];
            for (int j = 0; j < i; j++) {
                int sum = prefixSums[i] - prefixSums[j];
                pq.add(sum);
            }
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 5, 5};
        System.out.println((new Problem1918()).kthSmallestSubarraySum(nums, 7));
    }
}
