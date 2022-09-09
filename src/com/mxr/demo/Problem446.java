package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0, n = nums.length;
        Map<Integer, Integer>[] map = new Map[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long delta = (long) nums[i] - (long) nums[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int) delta;
                int sum = map[j].getOrDefault(diff, 0);
                int origin = map[i].getOrDefault(diff, 0);
                map[i].put(diff, origin + sum + 1);
                result += sum;
            }
        }
        return result;
    }

}
