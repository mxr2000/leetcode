package com.mxr.demo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem2233 {
    public int maximumProduct(int[] nums, int k) {
        int n = nums.length;
        long mod = 1000000007;
        if (n == 1) {
            return (int) ((nums[0] + k) % mod);
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add((long) num);
        }
        while (k > 0) {
            long n1 = pq.poll();
            long n2 = pq.poll();
            long diff = Math.min(k, n2 - n1 + 1);
            n1 += diff;
            k -= diff;
            pq.add(n1);
            pq.add(n2);
        }
        long result = 1;
        while (!pq.isEmpty()) {
            result = (result * pq.remove()) % mod;
        }
        return (int) result;
    }

    private int backtrack(int[] nums, int k, int index) {
        if (index == nums.length) {
            return 1;
        }
        if (nums[index] == 0) {
            return k == 0 ? 0 : backtrack(nums, k - 1, index + 1);
        }
        int result = 0;
        for (int i = 0; i <= k; i++) {
            result = Math.max(result, (nums[index] + i) * backtrack(nums, k - i, index + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, 3, 2};
        System.out.println((new Problem2233()).maximumProduct(nums, 2));
    }
}
