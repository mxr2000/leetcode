package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem1590 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length, need = 0, cur = 0;
        for (int num : nums) {
            need = (need + num) % p;
        }
        int result = n;
        Map<Integer, Integer> lastSeen = new HashMap<>();
        lastSeen.put(0, -1);
        for (int i = 0; i < n; ++i) {
            cur = (cur + nums[i]) % p;
            lastSeen.put(cur, i);
            int target = (cur - need + p) % p;
            result = Math.min(result, i - lastSeen.getOrDefault(target, -n));
        }
        return result < n ? result : -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        System.out.println((new Problem1590()).minSubarray(nums, 6));
    }
}
