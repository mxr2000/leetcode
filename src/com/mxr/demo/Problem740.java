package com.mxr.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem740 {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> frequencies = map.keySet().stream().sorted().map(key -> new int[]{key, map.get(key)}).toList();
        int n = map.size();
        int[][] dp = new int[n + 1][2];
        for (int index = 1; index <= n; index++) {
            int num = frequencies.get(index - 1)[0];
            int cnt = frequencies.get(index - 1)[1];
            if (index == 1 || frequencies.get(index - 2)[0] == num - 1) {
                dp[index][0] = num * cnt + dp[index - 1][1];
                dp[index][1] = Math.max(dp[index - 1][0], dp[index - 1][1]);
            } else {
                dp[index][0] = num * cnt + Math.max(dp[index - 1][0], dp[index - 1][1]);
                dp[index][1] = Math.max(dp[index - 1][0], dp[index - 1][1]);
            }

        }
        return Math.max(dp[n][0], dp[n][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 4, 5, 5, 5, 6};
        System.out.println((new Problem740()).deleteAndEarn(nums));
    }
}
