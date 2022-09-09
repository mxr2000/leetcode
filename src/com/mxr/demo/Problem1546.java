package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Map<Integer, Integer> indexMap = new HashMap<>();
        int sum = 0;
        indexMap.put(0, 0);
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            if (indexMap.containsKey(sum - target)) {
                int j = indexMap.get(sum - target);
                dp[i] = Math.max(dp[i - 1], 1 + dp[j]);
            } else {
                dp[i] = dp[i - 1];
            }
            indexMap.put(sum, i);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums = {-1, 3, 5, 1, 4, 2, -9};
        System.out.println((new Problem1546()).maxNonOverlapping(nums, 6));
    }
}
