package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem1027 {
    public int longestArithSeqLength(int[] nums) {
        int result = 0;
        int n = nums.length;
        Map<Integer, Integer>[] dp = new Map[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int diff = nums[i] - nums[j];
                int len = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, Math.max(len, dp[i].getOrDefault(diff, 1)));
                result = Math.max(result, len);
            }
        }

        return result;
    }
}
